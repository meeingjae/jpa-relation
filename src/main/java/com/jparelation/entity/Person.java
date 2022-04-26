package com.jparelation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long personId;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    @JoinColumn(name = "personId")
    private List<Car> cars;
}
