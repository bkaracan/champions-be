package com.bkaracan.champions.bean.skill;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.entity.Skill;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.SkillDtoMapper;
import com.bkaracan.champions.repository.SkillRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveSkillBean extends AbstractResponsePayload {

    private final SkillRepository skillRepository;
    private final SkillDtoMapper skillDtoMapper;

    @Transactional
    public ResponsePayload<SkillDTO> saveSkill(SkillDTO skillDTO) {
        if (skillDTO.getId() == null) {
            Skill savedSkill = skillRepository.save(skillDtoMapper.convertToEntity(skillDTO));
            SkillDTO savedSkillDTO = skillDtoMapper.map(savedSkill);
            return setResponse(ResponseEnum.OK, MessageEnum.SAVE_SUCCESS, savedSkillDTO);
        }
        return setResponse(ResponseEnum.ERROR, MessageEnum.ID_MUST_BE_NULL.getMessage());
    }
}
