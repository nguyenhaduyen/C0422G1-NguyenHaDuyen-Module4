package com.example.contract.model;

import com.example.contract_detail.model.ContractDetail;
import com.example.customer.model.Customer;
import com.example.employee.model.Employee;
import com.example.facility.model.Facility;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "contract")
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer idContract;
    @Column (name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column (name = "deposit")
    private Double deposit;

    @ManyToOne
    @JoinColumn (name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn (name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name = "facility_id", referencedColumnName = "facility_id")
    private Facility facility;

    @OneToMany (mappedBy = "contract")
    private List<ContractDetail> contractDetailList;
}
