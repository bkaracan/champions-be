package com.bkaracan.champions.mapper;

import com.bkaracan.champions.dto.AppUserDTO;
import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.enumeration.environment.AppUserRoleEnum;
import org.springframework.stereotype.Component;

@Component
public class AppUserDtoMapper {

    public AppUser convertToEntity(AppUserDTO register) {
        AppUser appUser = new AppUser();
        appUser.setId(register.getId());
        appUser.setFirstName(register.getFirstName());
        appUser.setLastName(register.getLastName());
        appUser.setUsername(register.getUsername());
        appUser.setEmail(register.getEmail());
        appUser.setPassword(register.getPassword());
        appUser.setRole(AppUserRoleEnum.valueOf(register.getRole().toString()));
        return appUser;
    }

    public AppUserDTO map(AppUser appUser) {
        return AppUserDTO.builder()
                .id(appUser.getId())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .username(appUser.getUsername())
                .email(appUser.getEmail())
                .password(appUser.getPassword())
                .role(appUser.getRole().toString())
                .build();
    }
}
