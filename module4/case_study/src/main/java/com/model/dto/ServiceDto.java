package com.model.dto;

import com.model.common.Regex;
import com.model.entity.contract.Contract;
import com.model.entity.service.RentType;
import com.model.entity.service.Service;
import com.model.entity.service.ServiceType;
import com.model.service.IServiceService;
import com.model.service.impl.ServiceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ServiceDto implements Validator {

    private Long id;
    @NotBlank(message = "Please Input")
    private String code;
    @NotBlank(message = "Please Input")
    private String name;
    @NotNull(message = "Please Input")
    @Min(value = 0, message = "Please input positive integer")
    private Integer area;
    @NotNull(message = "Please Input")
    @Min(value = 0, message = "Please input positive integer")
    private Double cost;
    @NotNull(message = "Please Input")
    @Min(value = 0, message = "Please input positive integer")
    private Integer maxPeople;


    private String standardRoom;
    private String description;
    private Double poolArea;
    private Integer floors;


    private boolean flag;


    private RentType rentType;
    private ServiceType serviceType;

    public static void main(String[] args) {
        System.out.println("DV-1000".matches("^DV-\\d{4}$"));
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

        Regex regex = new Regex();
        ServiceDto serviceDto = (ServiceDto) target;
        if (!serviceDto.code.matches("^DV-[0-9]{4}$")) {
            errors.rejectValue("code", "code.valid", "Please input invalid DV-XXXX");
        }

    }
}
