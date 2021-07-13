package com.model.dto;

import com.model.common.Regex;
import com.model.entity.customer.Customer;
import com.model.entity.employee.Employee;
import com.model.entity.service.Service;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class ContractDto implements Validator {
    private Long id;

    private String startDate;
    private String endDate;
    @NotNull
    @Min(value = 0)
    private Double deposit;
    private Double totalMoney;
    private Customer customer;

    private Employee employee;

    private Service service;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @SneakyThrows
    @Override
    public void validate(Object target, Errors errors) {


        Regex regex = new Regex();
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.startDate.matches("")) {
            errors.rejectValue("startDate", "startDate.valid", "Please input");
        } else if (!contractDto.startDate.matches(regex.DATE)) {
            errors.rejectValue("startDate", "startDate.valid", "FU");
        } else if (contractDto.endDate.matches("")) {
            errors.rejectValue("endDate", "endDate.valid", "Please input");
        } else if (!contractDto.endDate.matches(regex.DATE)) {
            errors.rejectValue("endDate", "endDate.valid", "FU");
        } else {
            Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.startDate);
            Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.endDate);
            if (eDate.getTime() < sDate.getTime()) {
                errors.rejectValue("endDate", "endDate.valid", "End date must be more start date");
            }
        }

    }
}
