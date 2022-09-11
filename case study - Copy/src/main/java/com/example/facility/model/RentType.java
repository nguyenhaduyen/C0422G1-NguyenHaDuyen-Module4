package com.example.facility.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    @Column (name = "rent_type_id")
    private int rentTypeId;
    @Column (name = "rent_type_name")
    private String rentTypeName;
    @OneToMany (mappedBy = "rentType")
    private List<Facility> facilityList;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, List<Facility> facilityList) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.facilityList = facilityList;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
