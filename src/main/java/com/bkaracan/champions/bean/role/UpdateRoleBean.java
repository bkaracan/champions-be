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
public class UpdateRoleBean extends AbstractResponsePayload {

    private final FindRoleBean findRoleBean;
    private final RoleRepository roleRepository;
    private final RoleDtoMapper roleDtoMapper;

    @Transactional
    public ResponsePayload<RoleDTO> updateRole(RoleDTO roleDTO) {
        ResponsePayload<RoleDTO> roleDTOResponsePayload = findRoleBean.findById(roleDTO.getId());
        if (Boolean.TRUE.equals(roleDTOResponsePayload.getIsSuccess())) {
            Role updatedRole = roleRepository.save(roleDtoMapper.convertToEntity(roleDTO));
            return setResponse(ResponseEnum.OK, MessageEnum.UPDATE_SUCCESS, roleDtoMapper.map(updatedRole));
        }
        return setResponse(ResponseEnum.ERROR, MessageEnum.NOT_FOUND.getMessage());
    }
}
