package com.bkaracan.champions.controller;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Skill",
        description = "İlgili REST API Skill entity'sine ait CRUD süreçlerini yürütür."
)
@RestController
@RequestMapping("/api/v1/skill")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SkillController {

    private final SkillService skillService;

    @Operation(
            summary = "Mevcut yeteneği id'si üzerinden döndürür."
    )
    @GetMapping(value = "/findSkillById")
    public ResponsePayload<SkillDTO> findSkillById(@RequestParam("skillId") Long skillId) {
        return skillService.findSkillById(skillId);
    }

    @Operation(
            summary = "Bir şampiyona ait yeni bir yetenek oluşturur."
    )
    @PostMapping(value = "/saveSkill")
    public ResponsePayload<SkillDTO> saveSkill(@RequestBody SkillDTO skillDTO) {
        return skillService.saveSkill(skillDTO);
    }

    @Operation(
            summary = "Bir şampiyona ait bir yeteneği günceller."
    )
    @PutMapping(value = "/updateSkill")
    public ResponsePayload<SkillDTO> updateSkill(@RequestBody SkillDTO skillDTO) {
        return skillService.updateSkill(skillDTO);
    }

    @Operation(
            summary = "Bir şampiyona ait olan skilleri listeler."
    )
    @GetMapping(value = "/findSkillsByChampionId")
    public ResponsePayload<List<SkillDTO>> findSkillsByChampionId(@RequestParam("championId") Long championId) {
        return skillService.getSkillsByChampionId(championId);
    }
}
