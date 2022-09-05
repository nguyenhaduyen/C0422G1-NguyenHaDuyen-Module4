package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

public class FormDto implements Validator {
    @NotBlank(message = "Khong dc de trong")
    private String firstName;
    @NotBlank(message = "Khong dc de trong")
    @Size(min = 5, max = 45)
    private String lastName;
    @Pattern(regexp = "^0\\d{9}$", message = "nhap dung dinh dang phone")
    private String phoneNumber;

    private String age;
    @NotBlank
    @Email
    private String email;

    public FormDto() {
    }

    public FormDto(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormDto formDto = (FormDto) target;
        if (formDto.firstName.length() < 5 || formDto.firstName.length() > 45) {
            errors.rejectValue("firstName", "create.firstName", "ten ko duoc duoi 5 ki tu hoac tren 45 ki tu");
        }
        LocalDate now = LocalDate.now();
        LocalDate age = null;
        try {
            age = LocalDate.parse(formDto.getAge());
            if (Period.between(age, now).getYears() < 18 || Period.between(age, now).getYears() > 100) {
                errors.rejectValue("age", "age.err", "vui long nhap tuoi tu 18-100");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "age,err", "Vui long nhap");
        }

    }
}
