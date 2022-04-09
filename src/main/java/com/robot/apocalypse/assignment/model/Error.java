package com.robot.apocalypse.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private int status;
    private String errorMessage;
}
