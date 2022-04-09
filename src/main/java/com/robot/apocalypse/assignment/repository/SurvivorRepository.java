package com.robot.apocalypse.assignment.repository;

import com.robot.apocalypse.assignment.entity.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {
}
