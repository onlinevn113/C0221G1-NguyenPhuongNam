package com.model.dto;

import com.model.common.Regex;
import com.model.entity.employee.Division;
import com.model.entity.employee.EducationDegree;
import com.model.entity.employee.Position;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Data
public class EmployeeDto implements Validator {
    private Long id;
    private String name;
    private String birthday;
    private String idCard;
    @NotNull
    private Double salary;
    private String phone;
    private String email;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private boolean flag;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Regex regex = new Regex();
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (employeeDto.name.matches("")) {
            errors.rejectValue("name", "name.valid", "Please input name");
        } else if (!employeeDto.name.matches(regex.VIETNAMESENAME)) {
            errors.rejectValue("name", "name.valid", "Please input in valid");
        }


        if (employeeDto.birthday.matches("")) {
            errors.rejectValue("birthday", "birthday.valid", "Please input birthday");
        } else if (!employeeDto.birthday.matches(regex.DATE)) {
            errors.rejectValue("birthday", "birthday.valid", "FU");
        } else {
            int age= Period.between(LocalDate.parse(employeeDto.birthday),LocalDate.now()).getYears();
            if (age < 18) {
                errors.rejectValue("birthday", "birthday.valid", "Age must be more than 18");
            }else if (age>150){
                errors.rejectValue("birthday", "birthday.valid", "You die");
            }
        }


        if (employeeDto.idCard.matches("")) {
            errors.rejectValue("idCard", "idCard.valid", "Please input idCard");
        } else if (!employeeDto.idCard.matches("^\\d{9}||\\d{12}$")) {
            errors.rejectValue("idCard", "idCard.valid", "Please input in valid");

        }


        if (employeeDto.salary <= 0) {
            errors.rejectValue("salary", "salary.valid", "Please input positive integer");
        }







        if (employeeDto.phone.matches("")) {
            errors.rejectValue("phone", "phone.valid", "Please input phone");
        } else if (!employeeDto.phone.matches(regex.PHONENUMBER)) {
            errors.rejectValue("phone", "phone.valid", "Please input phone");

        }


        if (employeeDto.email.matches("")) {
            errors.rejectValue("email", "email.valid", "Please input email");
        }
        if (employeeDto.address.matches("")) {
            errors.rejectValue("address", "address.valid", "Please input address");
        }
    }
}
