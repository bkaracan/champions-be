package com.bkaracan.champions.repository;

import com.bkaracan.champions.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long>,
        JpaSpecificationExecutor<Champion> {
}
