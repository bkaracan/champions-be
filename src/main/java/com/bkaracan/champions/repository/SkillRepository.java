package com.bkaracan.champions.repository;

import com.bkaracan.champions.entity.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SkillRepository extends JpaRepository<Skill, Long>,
        JpaSpecificationExecutor<Skill> {

    List<Skill> findByChampionId(Long championId);
}
