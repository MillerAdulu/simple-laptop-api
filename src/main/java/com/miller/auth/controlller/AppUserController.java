package com.miller.auth.controlller;

import com.miller.auth.model.AppUser;
import com.miller.auth.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")

public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AppUserController(AppUserRepository aUR, BCryptPasswordEncoder bPE) {
        this.appUserRepository = aUR;
        this.bCryptPasswordEncoder = bPE;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
    }
}