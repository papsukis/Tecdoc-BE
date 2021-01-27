package com.adMaroc.Tecdoc.Security.Security;

import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Exceptions.ResourceNotFoundException;
import com.adMaroc.Tecdoc.Security.Models.User;
import com.adMaroc.Tecdoc.Security.Models.UserDetailsAdapter;
import com.adMaroc.Tecdoc.Security.Repository.UserRepository;
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
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider .class);


    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


    @Override
        public Authentication authenticate(Authentication auth)
      throws AuthenticationException {

            final User user = userRepository.findByUsername(auth.getName()).orElseThrow(() -> new ResourceNotFoundException( String.format("username %s", auth.getName())));;
            UserDetailsAdapter userDetailsAdapter = new UserDetailsAdapter(user);
            boolean sameIP = true;
            boolean goodTime = true;

            if ((user == null)) {
                throw new BadCredentialsException("Invalid username or password");
            }
            if(userDetailsAdapter.getPassword().length()>0){
                if(!bCryptPasswordEncoder.matches((CharSequence) auth.getCredentials(),userDetailsAdapter.getPassword()))
                {
                    throw new BadCredentialsException("Invalid username or password");
                }
            }else{
                throw  new InternalServerException("Password cannot be empty");
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

        
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}

