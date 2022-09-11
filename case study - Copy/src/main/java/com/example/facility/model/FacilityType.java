package com.example.facility.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "facility_type_id")
    private int facilityTypeId;
    @Column (name = "facility_type_name")
    private String facilityTypeName;
    @OneToMany (mappedBy = "facilityType")
    private List<Facility> facilities;

    public FacilityType() {
    }

    public FacilityType(int facilityTypeId, String facilityTypeName, List<Facility> facilities) {
        this.facilityTypeId = facilityTypeId;
        this.facilityTypeName = facilityTypeName;
        this.facilities = facilities;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
