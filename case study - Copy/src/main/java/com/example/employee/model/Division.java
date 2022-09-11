package com.example.employee.model;

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
@Table (name = "division")
public class Division {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "division_id")
    private int idDivision;
    @Column (name = "division_name")
    private String divisionName;
    @OneToMany (mappedBy = "division")
    private List<Employee> employeeList;
}
