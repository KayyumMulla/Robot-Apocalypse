package com.robot.apocalypse.assignment.service;

import com.robot.apocalypse.assignment.model.Robot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RobotClientService {
    private RestTemplate restTemplate;

    private static final String URL = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

    @Autowired
    public RobotClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Robot> getRobotDetails() {
        log.info("Calling Robot CPU Client Endpoint");
        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(URL, Robot[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
