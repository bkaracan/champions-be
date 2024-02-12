package com.bkaracan.champions.service.impl;

import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.entity.AuthenticationResponse;
import com.bkaracan.champions.repository.AppUserRepository;
import com.bkaracan.champions.service.AuthenticationService;
import com.bkaracan.champions.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(AppUser request) {
        AppUser appUser = new AppUser();
        appUser.setFirstName(request.getFirstName());
        appUser.setLastName(request.getLastName());
        appUser.setUsername(request.getUsername());
        appUser.setPassword(passwordEncoder.encode(request.getPassword()));
        appUser.setAppUserRoleEnum(appUser.getAppUserRoleEnum());
        appUser = appUserRepository.save(appUser);
        String token = jwtService.generateToken(appUser);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(AppUser request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        AppUser appUser = appUserRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.generateToken(appUser);
        return new AuthenticationResponse(token);
    }

}
