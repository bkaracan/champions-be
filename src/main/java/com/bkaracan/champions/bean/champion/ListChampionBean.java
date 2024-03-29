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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListChampionBean extends AbstractResponsePayload {

    private final ChampionRepository championRepository;
    private final ChampionDtoMapper championDtoMapper;
    private final RoleRepository roleRepository;

    public ResponsePayload<List<ChampionDTO>> getAllChampions() {
        List<Champion> champions = championRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<ChampionDTO> championDTOs = champions.stream()
                .map(championDtoMapper::map)
                .toList();
        return setResponse(ResponseEnum.OK, MessageEnum.FETCH_SUCCESS, championDTOs);
    }

    @Transactional
    public ResponsePayload<List<ChampionDTO>> getChampionsByRoleId(Long roleId) {
        Optional<Role> roleOptional = roleRepository.findById(roleId);
        if(roleOptional.isEmpty()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.ROLE_NOT_FOUND.getMessage());
        }
        Role role = roleOptional.get();
        if(role.getChampions().isEmpty()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.CHAMPION_NOT_FOUND.getMessage());
        }
        List<ChampionDTO> championDTOs = role.getChampions().stream()
                .map(championDtoMapper::map)
                .sorted(Comparator.comparing(ChampionDTO::getName))
                .toList();
        return setResponse(ResponseEnum.OK, MessageEnum.FETCH_SUCCESS, championDTOs);
    }
}
