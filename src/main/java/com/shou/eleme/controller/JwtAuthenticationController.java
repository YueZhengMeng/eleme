package com.shou.eleme.controller;

import com.shou.eleme.dao.UserRepository;
import com.shou.eleme.dto.JwtRequest;
import com.shou.eleme.dto.JwtResponse;
import com.shou.eleme.dto.SignupRequest;
import com.shou.eleme.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.shou.eleme.service.JwtUserDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/authenticate")
public class JwtAuthenticationController {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse login(@RequestBody JwtRequest authenticationRequest) throws Exception {

        userDetailsService.authenticate(authenticationRequest.getUserId(), authenticationRequest.getPassword());
        return userDetailsService.generateJwtToken(authenticationRequest.getUserId());
    }

    @PostMapping(value = "/signup")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse signup(@RequestBody SignupRequest signupRequest) throws Exception {
        String password = new BCryptPasswordEncoder().encode(signupRequest.getPassword());
        String userId = signupRequest.getUserId();
        int userSex = signupRequest.getUserSex();
        String nickName = signupRequest.getNickName();
        String phone=signupRequest.getPhone();
        User user = new User(userId, password,phone,userSex, nickName);
        userRepository.insertNewUser(user);
        return userDetailsService.generateJwtToken(signupRequest.getUserId());
    }

    @PutMapping("/ban")
    @ResponseStatus(HttpStatus.OK)
    public void banUser(@RequestBody String userId) {
        userDetailsService.banUser(userId);
    }

    @PutMapping("/unban")
    @ResponseStatus(HttpStatus.OK)
    public void unbanUser(@RequestBody String userId) {
        userDetailsService.unbanUser(userId);
    }
}
