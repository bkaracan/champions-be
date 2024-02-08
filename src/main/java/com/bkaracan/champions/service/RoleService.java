package com.bkaracan.champions.service;

import com.bkaracan.champions.dto.RoleDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;

import java.util.List;

public interface RoleService {

    ResponsePayload<RoleDTO> findRoleById(Long roleId);

    ResponsePayload<RoleDTO> saveRole(RoleDTO roleDTO);

    ResponsePayload<RoleDTO> updateRole(RoleDTO roleDTO);

    ResponsePayload<List<RoleDTO>> findAllRoles();

}
