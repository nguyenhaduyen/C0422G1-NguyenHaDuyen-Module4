package com.example.contract.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "attach_facility_id")
    private int idAttachFacilityId;
    @Column(name = "attach_facility_name")
    private String nameOfAttachFacility;
    @Column (name = "price")
    private double price;
    @Column (name = "unit")
    private String unit;
    @Column (name = "status")
    private String status;
    @JsonBackReference
    @OneToMany (mappedBy = "attachFacility")
    private List<ContractDetail> contractDetailList;

}
