package com.adMaroc.Tecdoc.Security.Security;

import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Exceptions.ResourceNotFoundException;
import com.adMaroc.Tecdoc.Security.Models.Config;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Models.UserDetailsAdapter;
import com.adMaroc.Tecdoc.Security.Models.UserLog;
import com.adMaroc.Tecdoc.Security.Repository.ConfigurationRepository;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
import com.adMaroc.Tecdoc.Security.Services.ConfigurationService;
import com.adMaroc.Tecdoc.Security.Services.UserLogService;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Component
@Slf4j
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider .class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfigurationService configService;


    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


    @Override
        public Authentication authenticate(Authentication auth)
      throws AuthenticationException {

            final User user = userRepository.findByUsername(auth.getName()).orElseThrow(() -> new ResourceNotFoundException( String.format("username %s", auth.getName())));;
            UserDetailsAdapter userDetailsAdapter = new UserDetailsAdapter(user);
            boolean sameIP = true;
            boolean goodTime = true;

            long nbrOfLogin = configService.getConfiguration("number_of_login").getNumberValue();

            if(nbrOfLogin<=user.getNumberOfLogins()){
                user.setNumberOfLogins(0);
                user.setActive(false);
                userRepository.save(user);
                throw new InternalServerException("Max number of attempts");
            }

            if(!user.isActive()){
                user.setNumberOfLogins(user.getNumberOfLogins()+1);
                userRepository.save(user);

                throw new InternalServerException("User is not active");
            }

            if ((user == null)) {
                throw new BadCredentialsException("Invalid username or password");
            }

            if(userDetailsAdapter.getPassword().length()>0){
                if(!bCryptPasswordEncoder.matches((CharSequence) auth.getCredentials(),userDetailsAdapter.getPassword()))
                {
                    user.setNumberOfLogins(user.getNumberOfLogins()+1);
                    userRepository.save(user);

                    throw new BadCredentialsException("Invalid username or password");
                }
            }else{
                throw  new InternalServerException("Password cannot be empty");
            }

            try{
//                Config config = configService.getConfiguration('');
            }catch (Exception ex){
                throw  new InternalServerException("Cannot find configuration");
            }
            WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();

            return new UsernamePasswordAuthenticationToken(
                    userDetailsAdapter,
                    userDetailsAdapter.getPassword(),
                    userDetailsAdapter.getAuthorities());

    }

        private boolean isValidLong(String code) {
            try {
                Long.parseLong(code);
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }


    private boolean matches(HttpServletRequest request, String subnet) {
        IpAddressMatcher ipAddressMatcher = new IpAddressMatcher(subnet);
        return ipAddressMatcher.matches(request);
    }
    @Override
    protected void doAfterPropertiesSet() {
        if(super.getUserDetailsService() != null){
            log.info("UserDetailsService has been configured properly");
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}

