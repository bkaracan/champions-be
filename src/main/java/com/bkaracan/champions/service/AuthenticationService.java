package com.bkaracan.champions.service;

import com.bkaracan.champions.dto.AppUserDTO;
import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.entity.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse register(AppUserDTO request);

    AuthenticationResponse authenticate(AppUser request);
}
