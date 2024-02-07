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
public class UpdateSkillBean extends AbstractResponsePayload {

    private final FindSkillBean findSkillBean;
    private final SkillRepository skillRepository;
    private final SkillDtoMapper skillDtoMapper;

    @Transactional
    public ResponsePayload<SkillDTO> updateSkill(SkillDTO skillDTO) {
        ResponsePayload<SkillDTO> skillDTOResponsePayload = findSkillBean.findById(skillDTO.getId());
        if(Boolean.TRUE.equals(skillDTOResponsePayload.getIsSuccess())) {
            Skill updatedSkill = skillRepository.save(skillDtoMapper.convertToEntity(skillDTO));
            return setResponse(ResponseEnum.OK, MessageEnum.UPDATE_SUCCESS, skillDtoMapper.map(updatedSkill));
        }
        return setResponse(ResponseEnum.ERROR, MessageEnum.NOT_FOUND.getMessage());
    }

}
