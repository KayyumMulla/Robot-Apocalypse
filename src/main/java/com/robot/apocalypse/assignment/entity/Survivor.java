package com.robot.apocalypse.assignment.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Data
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    @OneToOne(cascade = {CascadeType.ALL})
    private Location location;
    @OneToOne(cascade = {CascadeType.ALL})
    private Resource resources;
    private boolean infected;

    @ElementCollection(targetClass=Long.class)
    private Set<Long> infections;
}
