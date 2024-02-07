package com.bkaracan.champions.service.impl;

import com.bkaracan.champions.bean.skill.FindSkillBean;
import com.bkaracan.champions.bean.skill.ListSkillBean;
import com.bkaracan.champions.bean.skill.SaveSkillBean;
import com.bkaracan.champions.bean.skill.UpdateSkillBean;
import com.bkaracan.champions.dto.SkillDTO;
import com.bkaracan.champions.responsepayload.ResponsePayload;
import com.bkaracan.champions.service.SkillService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SkillServiceImpl implements SkillService {

    private final FindSkillBean findSkillBean;
    private final SaveSkillBean saveSkillBean;
    private final UpdateSkillBean updateSkillBean;
    private final ListSkillBean listSkillBean;
    @Override
    public ResponsePayload<SkillDTO> findSkillById(Long skillId) {
        return findSkillBean.findById(skillId);
    }

    @Override
    public ResponsePayload<SkillDTO> saveSkill(SkillDTO skillDTO) {
        return saveSkillBean.saveSkill(skillDTO);
    }

    @Override
    public ResponsePayload<SkillDTO> updateSkill(SkillDTO skillDTO) {
        return updateSkillBean.updateSkill(skillDTO);
    }

    @Override
    public ResponsePayload<List<SkillDTO>> getSkillsByChampionId(Long championId) {
        return listSkillBean.getSkillsByChampionId(championId);
    }
}
