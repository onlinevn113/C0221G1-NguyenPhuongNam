package com.model.dto;

import com.model.common.Regex;
import com.model.entity.contract.Contract;
import com.model.entity.service.RentType;
import com.model.entity.service.ServiceType;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ServiceDto implements Validator {

    private Long id;
    @NotBlank
    private String code;
    @NotBlank
    private String name;
    @NotNull
    private Integer area;
    @NotNull
    private Double cost;
    @NotNull
    private Integer maxPeople;

    @NotBlank
    private String standardRoom;
    @NotBlank
    private String description;
    @NotNull
    private Double poolArea;
    @NotNull
    private Integer floors;


    private boolean flag;

    private RentType rentType;
    private ServiceType serviceType;



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Regex regex=new Regex();
        ServiceDto serviceDto = (ServiceDto) target;
        if (serviceDto.code.matches("")){

        }

    }
}
