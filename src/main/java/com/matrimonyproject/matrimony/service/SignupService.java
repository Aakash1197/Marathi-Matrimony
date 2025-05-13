package com.matrimonyproject.matrimony.service;


import com.matrimonyproject.matrimony.security.request.SignupRequest;

public interface SignupService {
    String registerNewUser(SignupRequest signupRequest);

}
