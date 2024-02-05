package com.bkaracan.champions.service.impl;

import com.bkaracan.champions.bean.role.FindRoleBean;
import com.bkaracan.champions.bean.role.ListRoleBean;
import com.bkaracan.champions.bean.role.SaveRoleBean;
import com.bkaracan.champions.bean.role.UpdateRoleBean;
import com.bkaracan.champions.dto.RoleDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private final FindRoleBean findRoleBean;
    private final SaveRoleBean saveRoleBean;
    private final UpdateRoleBean updateRoleBean;
    private final ListRoleBean listRoleBean;
    @Override
    public ResponsePayload<RoleDTO> findRoleById(Long roleId) {
        return findRoleBean.findById(roleId) ;
    }

    @Override
    public ResponsePayload<RoleDTO> saveRole(RoleDTO roleDTO) {
        return saveRoleBean.saveRole(roleDTO);
    }

    @Override
    public ResponsePayload<RoleDTO> updateRole(RoleDTO roleDTO) {
        return updateRoleBean.updateRole(roleDTO);
    }

    @Override
    public ResponsePayload<List<RoleDTO>> findAllRoles() {
        return listRoleBean.findAllRoles();
    }
}
