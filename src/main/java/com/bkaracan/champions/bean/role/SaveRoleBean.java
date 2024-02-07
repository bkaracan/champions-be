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
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveRoleBean extends AbstractResponsePayload {

    private final RoleRepository roleRepository;
    private final RoleDtoMapper roleDtoMapper;

    @Transactional
    public ResponsePayload<RoleDTO> saveRole(RoleDTO roleDTO) {
        if(roleDTO.getId() == null) {
            Role savedRole = roleRepository.save(roleDtoMapper.convertToEntity(roleDTO));
            RoleDTO savedRoleDTO = roleDtoMapper.map(savedRole);
            return setResponse(ResponseEnum.OK, MessageEnum.SAVE_SUCCESS, savedRoleDTO);
        }
        return setResponse(ResponseEnum.ERROR, MessageEnum.ID_MUST_BE_NULL.getMessage());
    }
}
