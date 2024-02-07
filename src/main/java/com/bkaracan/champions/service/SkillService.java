package com.bkaracan.champions.service;

import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import java.util.List;

public interface SkillService {

    ResponsePayload<SkillDTO> findSkillById(Long skillId);

    ResponsePayload<SkillDTO> saveSkill(SkillDTO skillDTO);

    ResponsePayload<SkillDTO> updateSkill(SkillDTO skillDTO);

    ResponsePayload<List<SkillDTO>> getSkillsByChampionId(Long championId);
}
