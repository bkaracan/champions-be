package com.bkaracan.champions.mapper;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.entity.Skill;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .championId(skill.getChampion() != null ? skill.getChampion().getId() : null)
                .build();
    }

    public List<SkillDTO> mapList(List<Skill> skillList) {
        return skillList.stream().map(this::map).toList();
    }
}
