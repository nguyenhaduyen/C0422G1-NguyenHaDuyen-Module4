package com.example.employee.model;

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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "  employee_id")
    private int idEmployee;
    @Column(name = "employee_name")
    private String nameOfEmployee;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "id_card")
    private String idCard;
    @Column(name = "salary")
    private double salary;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn (name = "education_degree_id", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn (name = "division_id",referencedColumnName = "division_id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;

}
