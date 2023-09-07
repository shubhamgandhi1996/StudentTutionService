package com.batch.batchDetails.entity;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "batch")
    private List<SubBatch> subBatches;


}
