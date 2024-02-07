package com.bkaracan.champions.bean.skill;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.entity.Skill;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.SkillDtoMapper;
import com.bkaracan.champions.repository.SkillRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindSkillBean extends AbstractResponsePayload {

    private final SkillRepository skillRepository;
    private final SkillDtoMapper skillDtoMapper;

    public ResponsePayload<SkillDTO> findById(Long skillId) {
        Optional<Skill> skillOptional = skillRepository.findById(skillId);
        if(skillOptional.isEmpty()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.NOT_FOUND.getMessage());
        }
        SkillDTO skillDTO = skillDtoMapper.map(skillOptional.get());
        return setResponse(ResponseEnum.OK, MessageEnum.FETCH_SUCCESS, skillDTO);
    }
}
