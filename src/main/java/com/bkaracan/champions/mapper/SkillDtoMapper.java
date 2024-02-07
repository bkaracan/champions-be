package com.bkaracan.champions.mapper;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.entity.Skill;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SkillDtoMapper {

    public Skill convertToEntity(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setId(skillDTO.getId());
        skill.setType(skillDTO.getType());
        skill.setName(skillDTO.getName());
        skill.setDescription(skillDTO.getDescription());
        skill.setIsActive(skillDTO.getIsActive());
        return skill;
    }

    public SkillDTO map(Skill skill) {
        return SkillDTO.builder()
                .id(skill.getId())
                .type(skill.getType())
                .name(skill.getName())
                .description(skill.getDescription())
                .isActive(skill.getIsActive())
                .build();
    }

    public List<SkillDTO> mapList(List<Skill> skillList) {
        return skillList.stream().map(this::map).collect(Collectors.toList());
    }

    public SkillDTO mapWithChampion(Skill skill) {
        SkillDTO skillDTO = map(skill);
        if(skill.getChampion() != null) {
            skillDTO.setChampionId(skill.getChampion().getId());
        }
        return skillDTO;
    }

    public List<SkillDTO> mapListWithChampion(List<Skill> skillList) {
        return skillList.stream().map(this::mapWithChampion).collect(Collectors.toList());
    }
}
