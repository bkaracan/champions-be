package com.bkaracan.champions.bean.skill;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.SkillDtoMapper;
import com.bkaracan.champions.repository.SkillRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListSkillBean extends AbstractResponsePayload {

    private final SkillRepository skillRepository;
    private final SkillDtoMapper skillDtoMapper;

    public ResponsePayload<List<SkillDTO>> getSkillsByChampionId(Long championId) {
        List<SkillDTO> skillDTOs = skillRepository.findByChampionId(championId).stream()
                .map(skillDtoMapper::map)
                .collect(Collectors.toList());

        if(skillDTOs.isEmpty()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.EMPTY_LIST.getMessage());
        }
        return setResponse(ResponseEnum.OK, MessageEnum.FETCH_SUCCESS, skillDTOs);
    }
}
