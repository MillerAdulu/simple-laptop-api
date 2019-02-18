package com.miller.auth.services;

import com.miller.auth.model.AppUser;
import com.miller.auth.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class AppUserService implements UserDetailsService{
    @Autowired
    private AppUserRepository aRepository;

    public AppUserService(AppUserRepository aUR) {
        this.aRepository = aUR;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = aRepository.findByUsername(username);

        if(appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(appUser.getUsername(), appUser.getPassword(), emptyList());
    }
}