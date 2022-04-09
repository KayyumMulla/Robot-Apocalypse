package com.robot.apocalypse.assignment.controller;

import com.robot.apocalypse.assignment.model.LocationDTO;
import com.robot.apocalypse.assignment.model.Report;
import com.robot.apocalypse.assignment.model.SurvivorDTO;
import com.robot.apocalypse.assignment.service.RobotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j
@RequestMapping(value = "api/survivors", produces = MediaType.APPLICATION_JSON_VALUE)
public class RobotController {

    @Autowired
    private RobotService robotService;

    @PostMapping("/registers")
    public ResponseEntity<SurvivorDTO> registerSurvivor(@RequestBody SurvivorDTO survivorDTO) {
        log.info("Calling Register Survivor endPoint");
        ResponseEntity<SurvivorDTO> survivorResponseEntity = new ResponseEntity<>(robotService.registerSurvivor(survivorDTO), HttpStatus.OK);
        log.info("Finished Register Survivor endPoint");
        return survivorResponseEntity;
    }

    @GetMapping
    public ResponseEntity<List<SurvivorDTO>> getAllSurvivorDetails() {
        log.info("Calling Get All Survivor Details endPoint");
        ResponseEntity<List<SurvivorDTO>> survivorsResponseEntity = new ResponseEntity<>(robotService.getAllSurvivor(), HttpStatus.OK);
        log.info("Finished Get All Survivor Details endPoint");
        return survivorsResponseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurvivorDTO> getSurvivor(@PathVariable Long id) {
        log.info("Calling Get Survivor endPoint");
        ResponseEntity<SurvivorDTO> survivorResponseEntity = new ResponseEntity<>(robotService.getSurvivor(id), HttpStatus.OK);
        log.info("Finished Get Survivor endPoint");
        return survivorResponseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSurvivorLocation(@PathVariable Long id, @RequestBody LocationDTO locationDTO) {
        log.info("Calling Update Survivor location endPoint");
        robotService.updateSurvivorLocation(id, locationDTO);
        log.info("Finished Update Survivor location endPoint");
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}/reportInfection/{reportInfectionId}")
    public ResponseEntity<Object> setFlagAsInfected(@PathVariable Long id, @PathVariable Long reportInfectionId) {
        log.info("Calling set Survivor As Infected endPoint");
        robotService.reportSurvivorAsInfected(id, reportInfectionId);
        log.info("Finished set Survivor As Infected endPoint");
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/report")
    private ResponseEntity<Report> getReport() {
        log.info("Calling Get Report endPoint");
        ResponseEntity<Report> reportResponseEntity = new ResponseEntity<>(robotService.getReport(), HttpStatus.OK);
        log.info("Finished Get Report endPoint");
        return reportResponseEntity;
    }
}
