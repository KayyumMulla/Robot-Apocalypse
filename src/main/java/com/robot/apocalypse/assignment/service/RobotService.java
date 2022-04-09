package com.robot.apocalypse.assignment.service;

import com.robot.apocalypse.assignment.entity.Location;
import com.robot.apocalypse.assignment.entity.Survivor;
import com.robot.apocalypse.assignment.exception.RobotApocalypseException;
import com.robot.apocalypse.assignment.exception.SurvivorNotFoundException;
import com.robot.apocalypse.assignment.model.LocationDTO;
import com.robot.apocalypse.assignment.model.Report;
import com.robot.apocalypse.assignment.model.Robot;
import com.robot.apocalypse.assignment.model.SurvivorDTO;
import com.robot.apocalypse.assignment.repository.SurvivorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RobotService {

    private SurvivorRepository survivorRepository;
    private ModelMapper modelMapper;
    private RobotClientService robotClientService;

    @Autowired
    public RobotService(SurvivorRepository survivorRepository, ModelMapper modelMapper, RobotClientService robotClientService) {
        this.survivorRepository = survivorRepository;
        this.modelMapper = modelMapper;
        this.robotClientService = robotClientService;
    }

    public SurvivorDTO registerSurvivor(SurvivorDTO survivorDTO) {
        Survivor survivorEntity = modelMapper.map(survivorDTO, Survivor.class);
        return modelMapper.map(survivorRepository.save(survivorEntity), SurvivorDTO.class);
    }

    public List<SurvivorDTO> getAllSurvivor() {
        return survivorRepository.findAll().stream().map(survivor -> modelMapper.map(survivor, SurvivorDTO.class)).collect(Collectors.toList());
    }

    public SurvivorDTO getSurvivor(Long id) {
        Survivor survivorEntity = survivorRepository.findById(id).orElseThrow(() -> new SurvivorNotFoundException("Survivor id not found"));
        return modelMapper.map(survivorEntity, SurvivorDTO.class);
    }

    public void updateSurvivorLocation(Long id, LocationDTO locationDTO) {
        Survivor survivor = survivorRepository.getById(id);
        Location survivorEntity = modelMapper.map(locationDTO, Location.class);
        survivor.setLocation(survivorEntity);
        survivorRepository.save(survivor);
    }

    public void reportSurvivorAsInfected(Long id, Long infectedSurvivorId) {
        if (id == infectedSurvivorId) {
            throw new RobotApocalypseException("The survivor cannot report himself as infected!");
        }
        Survivor survivor = survivorRepository.findById(id).orElseThrow(() -> new SurvivorNotFoundException("Survivor id not found"));
        survivorRepository.findById(infectedSurvivorId).orElseThrow(() -> new SurvivorNotFoundException("infectedSurvivor id not found"));
        Set<Long> infections = survivor.getInfections();
        if (infections.size() > 3 || survivor.isInfected()) {
            throw new RobotApocalypseException("The survivor is infected, he has already been reported as infected 3 times!");
        }
        infections.add(infectedSurvivorId);
        survivor.setInfections(infections);
        if (infections.size() == 3) {
            survivor.setInfected(true);
        }
        survivorRepository.save(survivor);
    }

    public Report getReport() {
        List<Survivor> survivors = survivorRepository.findAll();
        if (survivors.size() == 0) {
            return new Report();
        }
        return buildReport(survivors);
    }

    private Report buildReport(List<Survivor> survivors) {
        List<SurvivorDTO> infectedSurvivorsList = new ArrayList<>();
        List<SurvivorDTO> nonInfectedSurvivorsList = new ArrayList<>();
        for (Survivor s : survivors) {
            if (s.isInfected()) {
                infectedSurvivorsList.add(modelMapper.map(s, SurvivorDTO.class));
            } else {
                nonInfectedSurvivorsList.add(modelMapper.map(s, SurvivorDTO.class));
            }
        }
        double infectedPercentage = (infectedSurvivorsList.size() / (double) survivors.size()) * 100;
        double nonInfectedPercentage = (nonInfectedSurvivorsList.size() / (double) survivors.size()) * 100;

        return new Report(infectedPercentage + "%", nonInfectedPercentage + "%", infectedSurvivorsList, nonInfectedSurvivorsList, getRobotDetails());
    }

    private List<Robot> getRobotDetails() {
        List<Robot> robotDetails = robotClientService.getRobotDetails();
        robotDetails.sort(Comparator.comparing(Robot::getCategory));
        return robotDetails;
    }


}
