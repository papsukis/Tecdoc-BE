package com.adMaroc.Tecdoc.Security.Security.jwt;

import com.adMaroc.Tecdoc.Security.Exceptions.AlreadyLoggedException;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Exceptions.ResourceNotFoundException;
import com.adMaroc.Tecdoc.Security.Models.ApiError;
import com.adMaroc.Tecdoc.Security.Models.JwtConfig;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Models.UserDetailsAdapter;
import com.adMaroc.Tecdoc.Security.Services.Implementations.JwtTokenManager;
import com.adMaroc.Tecdoc.Security.Services.Implementations.UserDetailsServiceImpl;
import com.adMaroc.Tecdoc.Security.Services.UserService;
import com.adMaroc.Tecdoc.Security.handler.RestExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Optional;

@Slf4j
public class AuthTokenFilter extends OncePerRequestFilter implements Filter {

    private final JwtConfig jwtConfig;
    private JwtTokenManager tokenProvider;
    private UserService userService;
    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;


    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    public AuthTokenFilter(
            JwtConfig jwtConfig,
            JwtTokenManager tokenProvider,
            UserService userService,
            HandlerExceptionResolver handlerExceptionResolver) {

        this.jwtConfig = jwtConfig;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
        this.handlerExceptionResolver=handlerExceptionResolver;
    }

    //    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//        //Manually get an instance of MyExceptionController
//        ApplicationContext ctx = (ApplicationContext) WebApplicationContextUtils
//                .getRequiredWebApplicationContext(arg0.getServletContext());
//
//        //MyExceptionHanlder is now accessible because I loaded it manually
//        this.restClientException = ctx.get(RestClientException.class);
//    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {


        // 1. get the authentication header. Tokens are supposed to be passed in the authentication header
        String header = request.getHeader(jwtConfig.getHeader());

        // 2. validate the header and check the prefix
        if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
            chain.doFilter(request, response);        // If not valid, go to the next filter.
            return;
        }

        // If there is no token provided and hence the user won't be authenticated.
        // It's Ok. Maybe the user accessing a public path or asking for a token.

        // All secured paths that needs a token are already defined and secured in config class.
        // And If user tried to access without access token, then he won't be authenticated and an exception will be thrown.
//        log.info(request.getRemoteAddr());
        // 3. Get the token
        String token = header.replace(jwtConfig.getPrefix(), "");
        Claims claims = tokenProvider.getClaimsFromJWT(token);
        String username = claims.getSubject();
        Optional<User> tmp = userService.findByUsername(username);
        try {
            if (tokenProvider.validateToken(token, tmp.get().getLastLogged())) {
                if(!tmp.get().isActive()){
                    throw new InternalServerException("User is not active");
                }
                UsernamePasswordAuthenticationToken auth =
                        tmp.map(UserDetailsAdapter::new)
                                .map(userDetails -> {
                                    UsernamePasswordAuthenticationToken authentication =
                                            new UsernamePasswordAuthenticationToken(
                                                    userDetails, null, userDetails.getAuthorities());
                                    authentication
                                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                                    return authentication;
                                })
                                .orElse(null);

                SecurityContextHolder.getContext().setAuthentication(auth);
            } else {
                SecurityContextHolder.clearContext();
            }
        } catch (Exception ex) {
            handlerExceptionResolver.resolveException(request, response, null, ex);
            return;
        }
        // go to the next filter in the filter chain
        chain.doFilter(request, response);
    }


    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;

    }

}
