package com.shou.eleme.service;
import java.util.ArrayList;

import com.shou.eleme.dao.UserRepository;
import com.shou.eleme.dto.JwtResponse;
import com.shou.eleme.po.User;
import com.shou.eleme.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user= userRepository.selectUserById(userId);
        if (user!=null) {
            String password=user.getPassword();
            return new org.springframework.security.core.userdetails.User(userId, password,new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + userId);
        }
    }

    public String getLoginUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }
            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return ((UserDetails) (authentication.getPrincipal())).getUsername();
            }
        }
        return null;
    }

    public JwtResponse generateJwtToken(String userId) {
        final UserDetails userDetails = loadUserByUsername(userId);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }

    public void authenticate(String userId, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public void banUser(String userId)
    {
        userRepository.banUser(userId);
    }

    public void unbanUser(String userId)
    {
        userRepository.unbanUser(userId);
    }
}