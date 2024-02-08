package com.bkaracan.champions.bean.skill;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.entity.Champion;
import com.bkaracan.champions.entity.Skill;
import com.bkaracan.champions.enumeration.core.MessageEnum;
import com.bkaracan.champions.enumeration.core.ResponseEnum;
import com.bkaracan.champions.mapper.SkillDtoMapper;
import com.bkaracan.champions.repository.ChampionRepository;
import com.bkaracan.champions.repository.SkillRepository;
import com.bkaracan.champions.responsepayload.AbstractResponsePayload;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveSkillBean extends AbstractResponsePayload {

    private final SkillRepository skillRepository;
    private final ChampionRepository championRepository;
    private final SkillDtoMapper skillDtoMapper;

    @Transactional
    public ResponsePayload<SkillDTO> saveSkill(SkillDTO skillDTO) {
        Optional<Champion> championOptional = championRepository.findById(skillDTO.getChampionId());
        if (championOptional.isEmpty()) {
            return setResponse(ResponseEnum.NOT_FOUND, MessageEnum.CHAMPION_NOT_FOUND.getMessage());
        }

        Skill skill = skillDtoMapper.convertToEntity(skillDTO);
        skill.setChampion(championOptional.get()); // Champion'ı Skill'e ata
        Skill savedSkill = skillRepository.save(skill);

        return setResponse(ResponseEnum.OK, MessageEnum.SAVE_SUCCESS, skillDtoMapper.map(savedSkill));
    }
}
