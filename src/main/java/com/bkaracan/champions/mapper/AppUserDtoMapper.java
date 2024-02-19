package com.bkaracan.champions.mapper;

import com.bkaracan.champions.dto.AppUserDTO;
import com.bkaracan.champions.entity.AppUser;
import com.bkaracan.champions.enumeration.environment.AppUserRoleEnum;
import org.springframework.stereotype.Component;

@Component
public class AppUserDtoMapper {

    public AppUser convertToEntity(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser();
        appUser.setId(appUserDTO.getId());
        appUser.setFirstName(appUserDTO.getFirstName());
        appUser.setLastName(appUserDTO.getLastName());
        appUser.setUsername(appUserDTO.getUsername());
        appUser.setEmail(appUserDTO.getEmail());
        appUser.setPassword(appUserDTO.getPassword());
        if(appUserDTO.getRole() == null) {
            appUser.setRole(AppUserRoleEnum.USER);
        }else{
            appUser.setRole(AppUserRoleEnum.valueOf(appUserDTO.getRole()));
        }
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
