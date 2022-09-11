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
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private int idEducationDegree;
    @Column(name = "education_degree_name")
    private String nameOfEducationDegree;
    @OneToMany (mappedBy = "educationDegree")
    private List<Employee> employeeList;
}
