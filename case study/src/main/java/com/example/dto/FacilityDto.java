package com.example.dto;

import com.example.facility.model.FacilityType;
import com.example.facility.model.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto implements Validator {
    private int facilityId;
    @Pattern(regexp = "^([A-Z][a-z0-1]*)+(\\s[A-Z0-9][a-z0-9]*)*$",message = "Tên dịch vụ được phép chứa số. Và các kí tự đầu tiên của mỗi từ phải viết\n" +
            "hoa.")
    private String facilityName;
    @NotNull(message = "Không được để trống, Nhập số")
    private Integer area;
    @NotNull(message = "Không được để trống, Nhập số")
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
       if (facilityDto.numberOfFloor != null){
           if (facilityDto.numberOfFloor<=0) {
               errors.rejectValue("numberOfFloor","add.numberOfFloor","Số tầng phải là số nguyên dương");
           }
       }
        if (facilityDto.cost != null){
            if(facilityDto.cost<=0) {
                errors.rejectValue("cost","add.cost","Giá phải là số dương.");
            }
        }
        if (facilityDto.area!=null) {
            if (facilityDto.area<=0) {
                errors.rejectValue("area","add.area","Area phải là số dương.");
            }
        }
//        if (facilityDto.facilityType.getFacilityTypeId()!=3) {
//            if (facilityDto.poolArea == null) {
//                errors.rejectValue("poolArea","add.area","poolArea khoong duoc de trong");
//            }
//        }
    }
}
