package com.jparelation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
}
