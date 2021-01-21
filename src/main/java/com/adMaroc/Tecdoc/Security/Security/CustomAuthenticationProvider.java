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
            System.out.println(user.getUsername());
            UserDetailsAdapter userDetailsAdapter = new UserDetailsAdapter(user);
            boolean sameIP = true;
            boolean goodTime = true;

            if ((user == null)) {
                throw new BadCredentialsException("Invalid username or password");
            }

            if(!bCryptPasswordEncoder.matches((CharSequence) auth.getCredentials(),userDetailsAdapter.getPassword()))
            {
                throw new BadCredentialsException("Invalid username or password");
            }

            WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
            return new UsernamePasswordAuthenticationToken(userDetailsAdapter, userDetailsAdapter.getPassword(), userDetailsAdapter.getAuthorities());


        /*int minH=config.min.getHourOfDay();
        int minM=config.min.getMinuteOfHour();
        int maxH=config.max.getHourOfDay();
        int maxM=config.max.getMinuteOfHour();
        DateTime current=new DateTime();
        int currentH=current.getHourOfDay();
        int currentM=current.getMinuteOfHour();*/
//

        // to verify verification code

       /* if ((!isValidLong(verificationCode) || !totp.verify(verificationCode))) {
            throw new BadCredentialsException("Invalid verfication code");
        }*/

//        if(!user.getUsual_IP().matches(details.getRemoteAddress()))
//        {
//            throw new BadCredentialsException("Bad IP address");
//        }
      /* if(!( (( minH <= currentH ) || (minH==currentH && minM <= currentM )) && (( maxH >= currentH ) || (maxH==currentH && maxM >= currentM ))))
        {
            throw new BadCredentialsException("Incorrect time to conect");
        }*/


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
    protected void doAfterPropertiesSet() {
        if(super.getUserDetailsService() != null){
            System.out.println("UserDetailsService has been configured properly");
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}

