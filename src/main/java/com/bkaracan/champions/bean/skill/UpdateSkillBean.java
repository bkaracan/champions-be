package com.bkaracan.champions.bean.skill;

import com.bkaracan.champions.bean.champion.FindChampionBean;
import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
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
    private final FindChampionBean findChampionBean;
    private final SaveSkillBean saveSkillBean;

    @Transactional
    public ResponsePayload<SkillDTO> updateSkill(SkillDTO skillDTO) {
        if (skillDTO.getId() == null) {
            return setResponse(ResponseEnum.BAD_REQUEST, "Skill ID is required!");
        }

        ResponsePayload<SkillDTO> skillDTOResponsePayload = findSkillBean.findById(skillDTO.getId());
        if (skillDTOResponsePayload.getData() == null && !skillDTOResponsePayload.getIsSuccess()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.SKILL_NOT_FOUND.getMessage());
        }
        SkillDTO existingSkillDto = skillDTOResponsePayload.getData();
        if (skillDTO.getChampionId() != null) {
            ResponsePayload<ChampionDTO> championDTOResponsePayload = findChampionBean.findById(skillDTO.getChampionId());
            if (championDTOResponsePayload.getData() == null && !championDTOResponsePayload.getIsSuccess()) {
                return setResponse(ResponseEnum.BAD_REQUEST, MessageEnum.CHAMPION_NOT_FOUND.getMessage());
            }
            if (championDTOResponsePayload.getData() != null) {
                existingSkillDto.setChampionId(championDTOResponsePayload.getData().getId());
            }
        }
        existingSkillDto.setType(skillDTO.getType());
        existingSkillDto.setName(skillDTO.getName());
        existingSkillDto.setDescription(skillDTO.getDescription());
        existingSkillDto.setIsActive(skillDTO.getIsActive());
        ResponsePayload<SkillDTO> updatedSkillDto = saveSkillBean.saveSkill(existingSkillDto);
        return setResponse(ResponseEnum.OK, MessageEnum.UPDATE_SUCCESS, updatedSkillDto.getData());
    }

}
