package com.bkaracan.champions.service;

import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import java.util.List;

public interface ChampionService {

    ResponsePayload<ChampionDTO> findChampionById(Long championId);

    ResponsePayload<ChampionDTO> saveChampion(ChampionDTO championDTO);

    ResponsePayload<ChampionDTO> updateChampion(ChampionDTO championDTO);

    ResponsePayload<List<ChampionDTO>> findAllChampions();

    ResponsePayload<List<ChampionDTO>> findChampionsByRoleId(Long roleId);
}
