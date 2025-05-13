package com.matrimonyproject.matrimony.security.service;

import com.matrimonyproject.matrimony.entity.UserRegister;
import com.matrimonyproject.matrimony.repository.SignupRepository;
import com.matrimonyproject.matrimony.security.jwt.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    SignupRepository signupRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRegister user = signupRepository.findByUsername( username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        logger.debug("User fetched from DB: " + user);
        logger.debug("isPasswordCorrect:    "+user.getPassword());
        return UserDetailsImpl.build(user);
    }



}