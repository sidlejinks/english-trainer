package com.dtorianik.english.trainer.mongo;

import com.dtorianik.english.trainer.dao.ApplicationUserDao;
import com.dtorianik.english.trainer.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MongoDbUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicationUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userDao.find(username);
        return new User(applicationUser.getUsername(),
                                            applicationUser.getPassword(),
                                            true, true, true, true,
                                            resolveAuthorities(applicationUser.getGroups()));
    }

    private Collection<GrantedAuthority> resolveAuthorities(List<String> groups) {
        List<GrantedAuthority> authList = new ArrayList<>();

        for (String group : groups) {
            authList.add(new SimpleGrantedAuthority(group));
        }

        return authList;
    }
}

