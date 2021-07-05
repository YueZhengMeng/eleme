package com.shou.eleme.controller;

import java.util.Objects;

import com.shou.eleme.dto.JwtRequest;
import com.shou.eleme.dto.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shou.eleme.utils.JwtTokenUtil;
import com.shou.eleme.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return ResponseEntity.ok(generateJwtToken(authenticationRequest.getUsername()));
    }

    @RequestMapping(value = "authenticate/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println(new BCryptPasswordEncoder().encode(authenticationRequest.getPassword()));
        System.out.println(authenticationRequest.getUsername());
        System.out.println(authenticationRequest.getPassword());

        return ResponseEntity.ok(generateJwtToken(authenticationRequest.getUsername()));
    }

    private JwtResponse generateJwtToken(String username) {
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
