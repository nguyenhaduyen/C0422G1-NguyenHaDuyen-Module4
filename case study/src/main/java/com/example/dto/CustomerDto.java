package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Validator {
    private int customerCode;
    @NotBlank
    @Pattern(regexp = "^([A-Z][a-z]*)+(\\s[A-Z][a-z]+)*$", message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải\n" +
            "viết hoa.")
    private String customerName;
    private String dateOfBirth;
    private int gender;
    @Pattern(regexp = "^[0-9]{9}$", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX\n" +
            "(X là số 0-9).")
    @NotBlank
    private String identify;
    @Pattern(regexp = "^[0|84+][90|91][0-9]{8}$", message = "Nhập đúng định dạng phone number")
    @NotBlank
    private String phoneNumber;
    @Pattern(regexp = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Địa chỉ email phải đúng định dạng.")
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    private String typeCustomer;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        LocalDate birthday;
        if (customerDto.getDateOfBirth() == "") {
            errors.rejectValue("dateOfBirth", "add.dateOfBirth", "Không được để trống");

        } else {
            try {
                birthday = LocalDate.parse(customerDto.getDateOfBirth());
                if (Period.between(birthday, LocalDate.now()).getYears() < 18) {
                    errors.rejectValue("dateOfBirth", "add.dateOfBirth", "Nhập ngày tháng lớn hơn 18 tuổi");
                }
            } catch (Exception e) {
                errors.rejectValue("dateOfBirth", "add.dateOfBirth", "Nhập đúng định dạng: dd/MM/yyyy");
            }

        }
    }
}
