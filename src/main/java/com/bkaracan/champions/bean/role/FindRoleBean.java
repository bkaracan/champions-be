package com.bkaracan.champions.bean.role;

import com.bkaracan.champions.dto.RoleDTO;
import com.bkaracan.champions.entity.Role;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.RoleDtoMapper;
import com.bkaracan.champions.repository.RoleRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindRoleBean extends AbstractResponsePayload {

    private final RoleRepository roleRepository;
    private final RoleDtoMapper roleDtoMapper;

    public ResponsePayload<RoleDTO> findById(Long roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if (roleOptional.isPresent()) {
            return setResponse(roleDtoMapper.map(roleOptional.get()));
        }
        return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.NOT_FOUND.getMessage());
    }
}
