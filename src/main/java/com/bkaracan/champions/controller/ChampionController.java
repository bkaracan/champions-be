package com.bkaracan.champions.controller;

import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.ChampionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Champion",
        description = "İlgili REST API Champion entity'sine ait CRUD süreçlerini yürütür."
)
@RestController
@RequestMapping("api/v1/champion")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "http://localhost:3000")
public class ChampionController {

    private final ChampionService championService;

    @Operation(
            summary = "Mevcut şampiyonu id'si üzerinden döndürür."
    )
    @GetMapping(value = "/findChampionById")
    public ResponsePayload<ChampionDTO> findChampionById(@RequestParam("championId") Long championId) {
        return championService.findChampionById(championId);
    }

    @Operation(
            summary = "Yeni bir şampiyon oluşturur."
    )
    @PostMapping(value = "/saveChampion")
    public ResponsePayload<ChampionDTO> saveChampion(@RequestBody ChampionDTO championDTO) {
        return championService.saveChampion(championDTO);
    }

    @Operation(
            summary = "Mevcut şampiyon verilerini id'si üzerinden günceller."
    )
    @PutMapping(value = "/updateChampion")
    public ResponsePayload<ChampionDTO> updateChampion(@RequestBody ChampionDTO championDTO) {
        return championService.updateChampion(championDTO);
    }

    @Operation(
            summary = "Tüm şampiyonları listeler."
    )
    @GetMapping(value = "/findAllChampions")
    public ResponsePayload<List<ChampionDTO>> findAllChampions() {
        return championService.findAllChampions();
    }

    @Operation(
            summary = "Bir role ait olan şampiyonların listesini döndürür."
    )
    @GetMapping(value = "/findChampionsByRoleId")
    public ResponsePayload<List<ChampionDTO>> findChampionsByRoleId(@RequestParam("roleId") Long roleId) {
        return championService.findChampionsByRoleId(roleId);
    }
}
