package com.robot.apocalypse.assignment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({"infectedSurvivorsPercentage", "nonInfectedSurvivorsPercentage", "infectedSurvivors", "nonInfectedSurvivors", "robots"})
public class Report {
    private String infectedSurvivorsPercentage;
    private String nonInfectedSurvivorsPercentage;
    private List<SurvivorDTO> infectedSurvivors;
    private List<SurvivorDTO> nonInfectedSurvivors;
    private List<Robot> robots;
}
