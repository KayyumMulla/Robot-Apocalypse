package com.robot.apocalypse.assignment.repository;

import com.robot.apocalypse.assignment.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
