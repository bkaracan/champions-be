package com.bkaracan.champions.service;

import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.entity.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse register(AppUser request);

    AuthenticationResponse authenticate(AppUser request);
}
