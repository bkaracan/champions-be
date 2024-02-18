package com.bkaracan.champions.controller.authentication;

import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.entity.AuthenticationResponse;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController extends AbstractResponsePayload {

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/register")
    public ResponsePayload<AuthenticationResponse> register(@RequestBody AppUser request) {
        return setResponse(ResponseEnum.OK, authenticationService.register(request));
    }

    @PostMapping(value = "/login")
    public ResponsePayload<AuthenticationResponse> login(@RequestBody AppUser request) {
        return setResponse(ResponseEnum.OK, authenticationService.authenticate(request));
    }
}
