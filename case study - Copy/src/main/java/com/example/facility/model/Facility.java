package com.example.facility.model;

import com.example.contract.model.Contract;
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
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private int facilityId;
    @Column(name = "facility_name")
    private String facilityName;
    @Column(name = "area")
    private Integer area;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "max_people")
    private Integer maxPeople;
    @Column(name = "standard_room")
    private String standardRoom;
    @Column(name = "description_other_convenience")
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private Double poolArea;
    @Column(name = "number_of_floor")
    private Integer numberOfFloor;
    @Column(name = "facility_free")
    private String facilityFree;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "facility_type_id", referencedColumnName = "facility_type_id")
    private FacilityType facilityType;

    @OneToMany (mappedBy = "facility")
    private List<Contract> contractList;

}
