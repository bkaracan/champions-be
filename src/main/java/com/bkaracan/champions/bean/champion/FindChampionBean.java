package com.bkaracan.champions.bean.champion;

import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.entity.Champion;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.ChampionDtoMapper;
import com.bkaracan.champions.repository.ChampionRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindChampionBean extends AbstractResponsePayload {

    private final ChampionRepository championRepository;
    private final ChampionDtoMapper championDtoMapper;

    public ResponsePayload<ChampionDTO> findById(Long championId) {
        Optional<Champion> championOptional = championRepository.findById(championId);
        if(championOptional.isPresent()) {
            return setResponse(championDtoMapper.map(championOptional.get()));
        }
        return  setResponse(ResponseEnum.NOT_FOUND, MessageEnum.CHAMPION_NOT_FOUND.getMessage());
    }
}
