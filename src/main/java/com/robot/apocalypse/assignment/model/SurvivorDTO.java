package com.robot.apocalypse.assignment.model;

import lombok.Data;

@Data
public class SurvivorDTO {
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private LocationDTO location;
    private ResourcesDTO resources;
    private boolean infected;
}
