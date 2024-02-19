package com.bkaracan.champions.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Schema(
        name = "AppUser",
        description = "Kullanıcı verisini tutmak için ilgili şema"
)
public class AppUserDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String role;
}
