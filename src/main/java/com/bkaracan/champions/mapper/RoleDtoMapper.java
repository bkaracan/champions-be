package com.bkaracan.champions.mapper;

import com.bkaracan.champions.dto.RoleDTO;
import com.bkaracan.champions.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleDtoMapper {

    public Role convertToEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        return role;
    }

    public RoleDTO map(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public List<RoleDTO> mapList(List<Role> roleList) {
        List<RoleDTO> mappedList = new ArrayList<>();
        for (Role role : roleList) {
            mappedList.add(this.map(role));
        }
        return mappedList;
    }
}
