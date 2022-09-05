package com.example.customer.model;

import javax.persistence.*;

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

    public Customer() {
    }

    public Customer(int customerCode, String customerName, String dateOfBirth, int gender, String identify, String phoneNumber, String email, String address, TypeCustomer typeCustomer) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.identify = identify;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
    }

    public Customer(String customerName, String dateOfBirth, int gender, String identify, String phoneNumber, String email, String address, TypeCustomer typeCustomer) {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.identify = identify;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
