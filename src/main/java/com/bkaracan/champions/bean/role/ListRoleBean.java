package com.bkaracan.champions.bean.role;

import com.bkaracan.champions.dto.RoleDTO;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.RoleDtoMapper;
import com.bkaracan.champions.repository.RoleRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListRoleBean extends AbstractResponsePayload {

    private final RoleRepository roleRepository;
    private final RoleDtoMapper roleDtoMapper;

    public ResponsePayload<List<RoleDTO>> findAllRoles() {
        List<RoleDTO> roleDTOList = roleRepository.findAll().stream()
                .map(roleDtoMapper::map)
                .toList();

        if(roleDTOList.isEmpty()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.EMPTY_LIST.getMessage());
        }
        return setResponse(ResponseEnum.OK, roleDTOList);
    }
}
