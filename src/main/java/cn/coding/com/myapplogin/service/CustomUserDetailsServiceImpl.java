package cn.coding.com.myapplogin.service;

import cn.coding.com.myapplogin.entity.Developer;
import cn.coding.com.myapplogin.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**@Author JosephCrypto
 *@Create 2022-00-2/14/22 10:00 PM
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private DeveloperRepository repository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Developer developer = repository.findByName(name);
        if (developer == null) {
            throw new UsernameNotFoundException("Developer name not found " + name);

        }
        return new CustomUserDetails(developer);
    }
}
