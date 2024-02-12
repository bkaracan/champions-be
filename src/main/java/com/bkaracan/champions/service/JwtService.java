package com.bkaracan.champions.service;

import com.bkaracan.champions.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String extractUsername(String token);
    String generateToken(AppUser appUser);
    boolean isValid(String token, UserDetails appUser);

}
