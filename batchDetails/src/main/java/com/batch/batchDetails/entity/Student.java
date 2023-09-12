package com.batch.batchDetails.entity;


import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "subbatch_id")
    private SubBatch subBatch;

    public Student(int id, String name, SubBatch subBatch) {
        this.id = id;
        this.name = name;
        this.subBatch = subBatch;
    }

    public SubBatch getSubBatch() {
        return subBatch;
    }

    public void setSubBatch(SubBatch subBatch) {
        this.subBatch = subBatch;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
