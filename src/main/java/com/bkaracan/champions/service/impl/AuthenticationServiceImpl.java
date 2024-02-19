package com.bkaracan.champions.service.impl;

import com.bkaracan.champions.dto.AppUserDTO;
import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.entity.AuthenticationResponse;
import com.bkaracan.champions.enumeration.environment.AppUserRoleEnum;
import com.bkaracan.champions.exception.EmailAlreadyExistsException;
import com.bkaracan.champions.exception.UsernameAlreadyExistsException;
import com.bkaracan.champions.mapper.AppUserDtoMapper;
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
    private final AppUserDtoMapper appUserDtoMapper;

    public AuthenticationResponse register(AppUserDTO request) {
        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("The email is already exists!");
        }
        if (appUserRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException("The username is already exists!");
        }
        AppUser user = appUserDtoMapper.convertToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(AppUserRoleEnum.USER);
        user = appUserRepository.save(user);
        String token = jwtService.generateToken(user);
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
