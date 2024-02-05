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
    private final FindRoleBean findRoleBean;

    @Transactional
    public ResponsePayload<RoleDTO> saveRole(RoleDTO roleDTO) {
        if (roleDTO.getId() == null) {
            Role savedRole = roleRepository.save(roleDtoMapper.convertToEntity(roleDTO));
            return setResponse(ResponseEnum.OK, MessageEnum.SAVE_SUCCESS, roleDtoMapper.map(savedRole));
        } else {
            ResponsePayload<RoleDTO> roleDTOResponsePayload = findRoleBean.findById(roleDTO.getId());
            if (roleDTOResponsePayload.getResponseEnum().equals(ResponseEnum.NOT_FOUND)) {
                Role savedRole = roleRepository.save(roleDtoMapper.convertToEntity(roleDTO));
                return setResponse(ResponseEnum.OK, MessageEnum.SAVE_SUCCESS, roleDtoMapper.map(savedRole));
            }
            return setResponse(ResponseEnum.WARNING, MessageEnum.RECORD_EXISTS.getMessage());
        }
    }
}
