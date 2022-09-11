package com.example.customer.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_type_id")
    private int idTypeCustomer;
    @Column (name = "customer_type_name")
    private String nameOfTypeCustomer;

    @OneToMany(mappedBy = "typeCustomer")
    List<Customer> customerList;

    public TypeCustomer() {
    }

    public TypeCustomer(int idTypeCustomer, String nameOfTypeCustomer, List<Customer> customerList) {
        this.idTypeCustomer = idTypeCustomer;
        this.nameOfTypeCustomer = nameOfTypeCustomer;
        this.customerList = customerList;
    }

    public int getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(int idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getNameOfTypeCustomer() {
        return nameOfTypeCustomer;
    }

    public void setNameOfTypeCustomer(String nameOfTypeCustomer) {
        this.nameOfTypeCustomer = nameOfTypeCustomer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
