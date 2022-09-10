package com.example.attach_facility.model;

import com.example.contract_detail.model.ContractDetail;
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

    @OneToMany (mappedBy = "attachFacility")
    private List<ContractDetail> contractDetailList;

}
