package com.bkaracan.champions.service.impl;

import com.bkaracan.champions.bean.champion.FindChampionBean;
import com.bkaracan.champions.bean.champion.ListChampionBean;
import com.bkaracan.champions.bean.champion.SaveChampionBean;
import com.bkaracan.champions.bean.champion.UpdateChampionBean;
import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.ChampionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChampionServiceImpl implements ChampionService {

    private final FindChampionBean findChampionBean;
    private final SaveChampionBean saveChampionBean;
    private final UpdateChampionBean updateChampionBean;
    private final ListChampionBean listChampionBean;

    @Override
    public ResponsePayload<ChampionDTO> findChampionById(Long championId) {
        return findChampionBean.findById(championId);
    }

    @Override
    public ResponsePayload<ChampionDTO> saveChampion(ChampionDTO championDTO) {
        return saveChampionBean.saveChampion(championDTO);
    }

    @Override
    public ResponsePayload<ChampionDTO> updateChampion(ChampionDTO championDTO) {
        return updateChampionBean.updateChampion(championDTO);
    }

    @Override
    public ResponsePayload<List<ChampionDTO>> findAllChampions() {
        return listChampionBean.getAllChampions();
    }

    @Override
    public ResponsePayload<List<ChampionDTO>> findChampionsByRoleId(Long roleId) {
        return listChampionBean.getChampionsByRoleId(roleId);
    }
}
