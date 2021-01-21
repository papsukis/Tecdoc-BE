package com.adMaroc.Tecdoc.Security.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Implementation of the interface UserDetails necessary for the configuration of spring security.
 */

public class UserDetailsAdapter extends User implements UserDetails {

    private User user;

    public UserDetailsAdapter(User user) {this.user = user;}

    public User getAccount() {return user;}

    public long getId(){return user.getId();}

    public String getEmail () {return user.getEmail();}

    /**
     * Maps all privileges with their respective role and returns a List of authorities.
     * @return List<GrantedAuthority>
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities= new ArrayList<>();

        for (Role role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPrivileges().stream().map(p -> new SimpleGrantedAuthority(p.getName())).forEach(authorities::add);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    public String getSecret() {
        return user.getSecret();
    }

}
