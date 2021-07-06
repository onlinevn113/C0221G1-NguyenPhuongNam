package com.model.dto;

import com.model.common.Regex;
import com.model.entity.customer.Customer;
import com.model.entity.employee.Employee;
import com.model.entity.service.Service;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotNull;


@Data
public class ContractDto implements Validator {
    private Long id;

    private String startDate;
    private String endDate;
    @NotNull
    private Double deposit;
    @NotNull
    private Double totalMoney;

    private Customer customer;

    private Employee employee;

    private Service service;





    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Regex regex=new Regex();
        ContractDto contractDto= (ContractDto) target;

        if (contractDto.startDate.matches("")){
            errors.rejectValue("startDate","startDate.valid","FU");
        }else if (contractDto.startDate.matches(regex.DATE)){
            errors.rejectValue("startDate","startDate.valid","FU");
        }

        if (contractDto.endDate.matches("")){
            errors.rejectValue("startDate","startDate.valid","FU");
        }else if (contractDto.endDate.matches(regex.DATE)){
            errors.rejectValue("startDate","startDate.valid","FU");
        }
    }
}
