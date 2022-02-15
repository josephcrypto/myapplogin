package cn.coding.com.myapplogin.service;

import cn.coding.com.myapplogin.entity.Developer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/*@Author JosephCrypto
 *@Create 2022-52-2/14/22 9:52 PM
 */
public class CustomUserDetails implements UserDetails {

    private Developer developer;

    public CustomUserDetails(Developer developer) {
        this.developer = developer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return developer.getPassword();
    }

    @Override
    public String getUsername() {
        return developer.getName();
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
        return true;
    }

    public String getName() {
        return developer.getName();
    }
}
