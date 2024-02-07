package com.bkaracan.champions.mapper;

import com.bkaracan.champions.dto.ChampionDTO;
import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.entity.Champion;
import com.bkaracan.champions.entity.Role;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ChampionDtoMapper {

    public Champion convertToEntity(ChampionDTO championDTO) {
        Champion champion = new Champion();
        champion.setId(championDTO.getId());
        champion.setName(championDTO.getName());
        champion.setTitle(championDTO.getTitle());
        champion.setDescription(championDTO.getDescription());
        return champion;
    }

    public ChampionDTO map(Champion champion) {

        List<Long> roleIds = champion.getRoles() != null ? champion.getRoles().stream()
                .map(Role::getId)
                .toList() : Collections.emptyList();
        return ChampionDTO.builder()
                .id(champion.getId())
                .name(champion.getName())
                .title(champion.getTitle())
                .description(champion.getDescription())
                .roleIds(roleIds)
                .build();
    }

    public ChampionDTO mapWithSkills(Champion champion) {
        ChampionDTO championDTO = map(champion);
        List<SkillDTO> skillDTOs = champion.getSkills().stream()
                .map(new SkillDtoMapper()::map).toList();
        championDTO.setSkills(skillDTOs);
        return championDTO;
    }

    public List<ChampionDTO> mapList(List<Champion> champions) {
        return champions.stream()
                .map(this::map).toList();
    }
}
