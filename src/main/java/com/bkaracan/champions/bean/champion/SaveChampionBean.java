package com.bkaracan.champions.bean.champion;

import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.entity.Champion;
import com.bkaracan.champions.entity.Role;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.ChampionDtoMapper;
import com.bkaracan.champions.repository.ChampionRepository;
import com.bkaracan.champions.repository.RoleRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveChampionBean extends AbstractResponsePayload {

    private final ChampionRepository championRepository;
    private final ChampionDtoMapper championDtoMapper;
    private final RoleRepository roleRepository;

    @Transactional
    public ResponsePayload<ChampionDTO> saveChampion(ChampionDTO championDTO) {
        if (championDTO.getId() == null) {
            Champion champion = championDtoMapper.convertToEntity(championDTO);
            if (championDTO.getRoleIds() != null && !championDTO.getRoleIds().isEmpty()) {
                List<Role> roles = new ArrayList<>(roleRepository.findAllById(championDTO.getRoleIds()));
                champion.setRoles(roles);
            }
            Champion savedChampion = championRepository.save(champion);
            ChampionDTO savedChampionDTO = championDtoMapper.map(savedChampion);
            return setResponse(ResponseEnum.OK, MessageEnum.SAVE_SUCCESS, savedChampionDTO);
        }
        return setResponse(ResponseEnum.ERROR, MessageEnum.ID_MUST_BE_NULL.getMessage());
    }
}

