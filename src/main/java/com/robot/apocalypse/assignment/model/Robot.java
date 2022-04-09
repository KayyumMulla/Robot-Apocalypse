package com.robot.apocalypse.assignment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Robot {
    private String model;
    private String serialNumber;
    private String manufacturedDate;
    private String category;
}
