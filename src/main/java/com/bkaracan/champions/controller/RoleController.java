package com.bkaracan.champions.controller;

import com.bkaracan.champions.dto.RoleDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Role",
        description = "İlgili REST API Role entity'sine ait CRUD süreçlerini yürütür."
)
@RestController
@RequestMapping("api/v1/role")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:8082"})
public class RoleController {

    private final RoleService roleService;

    @Operation(
            summary = "Mevcut rolü id'si üzerinden döndürür."
    )
    @GetMapping(value = "/findRoleById")
    public ResponsePayload<RoleDTO> findRoleById(@RequestParam("roleId") Long roleId) {
        return roleService.findRoleById(roleId);
    }

    @Operation(
            summary = "Yeni bir rol oluşturur."
    )
    @PostMapping(value = "/saveRole")
    public ResponsePayload<RoleDTO> saveRole(@RequestBody RoleDTO roleDTO) {
        return roleService.saveRole(roleDTO);
    }

    @Operation(
            summary = "Mevcut rol verilerini id'si üzerinden günceller."
    )
    @PutMapping(value = "/updateRole")
    public ResponsePayload<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {
        return roleService.updateRole(roleDTO);
    }

    @Operation(
            summary = "Mevcut tüm rollerin listesini döndürür."
    )
    @GetMapping(value = "/findAllRoles")
    public ResponsePayload<List<RoleDTO>> findAllRoles() {
        return roleService.findAllRoles();
    }
}
