package com.bkaracan.champions.repository;

import com.bkaracan.champions.entity.Champion;
import com.bkaracan.champions.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long>,
        JpaSpecificationExecutor<Champion> {

    Optional<Champion> findByName(String name);
}
