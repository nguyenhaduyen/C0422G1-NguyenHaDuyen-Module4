package com.example.customer.model;

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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private int customerCode;
    @Column (name = "customer_name")
    private String customerName;
    @Column (name = "date_of_birth")
    private String dateOfBirth;
    @Column (name = "gender")
    private int gender;
    @Column (name = "id_card")
    private String identify;
    @Column (name = "phone_number")
    private String phoneNumber;
    @Column (name = "email")
    private String email;
    @Column (name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private TypeCustomer typeCustomer;

    @OneToMany (mappedBy = "customer")
    private List<Contract> contractList;

}
