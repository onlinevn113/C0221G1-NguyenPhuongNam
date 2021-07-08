package com.model.dto;

import com.model.common.Regex;
import com.model.entity.customer.CustomerType;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Email;


@Data
public class CustomerDto implements Validator {
    private Long id;
    private CustomerType customerType;
    private String code;
    private String name;
    private String birthday;
    private Byte gender;
    private String idCard;
    private String phone;
    private boolean flag;
    @Email
    private String email;
    private String address;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("KH-1234".matches("^KH-\\d{4}$"));
    }
    @Override
    public void validate(Object target, Errors errors) {
        Regex regex=new Regex();
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.code.matches("^KH-\\d{4}$")){
            errors.rejectValue("code", "code.valid", "Please input valid KH-XXXX");
        }





        if (customerDto.name.matches("")) {
            errors.rejectValue("name", "name.valid", "Please input name");
        }else if (!customerDto.name.matches(regex.VIETNAMESENAME)){
            errors.rejectValue("name", "name.valid", "Please input in valid");
        }


        if (customerDto.customerType==null){
            errors.rejectValue("customerType", "customerType.valid", "Please input customer type");
        }



        if (customerDto.birthday.matches("")) {
            errors.rejectValue("birthday", "birthday.valid", "Please input birthday");
        }else if (!customerDto.birthday.matches(regex.DATE)){
            errors.rejectValue("birthday", "birthday.valid", "FU");
        }



        if (customerDto.gender.toString().matches("")) {
            errors.rejectValue("gender", "gender.valid", "Please input gender");
        }else if (!customerDto.gender.toString().matches("^0|1|2$")){
            errors.rejectValue("gender","gender.valid","FU");
        }


        if (customerDto.idCard.matches("")) {
            errors.rejectValue("idCard", "idCard.valid", "Please input idCard");
        }else if (!customerDto.idCard.matches("^\\d{9}||\\d{12}$")){
            errors.rejectValue("idCard", "idCard.valid", "Please input in valid");

        }



        if (customerDto.phone.matches("")) {
            errors.rejectValue("phone", "phone.valid", "Please input phone");
        }else if (!customerDto.phone.matches(regex.PHONENUMBER)){
            errors.rejectValue("phone", "phone.valid", "Please input phone");

        }



        if (customerDto.email.matches("")) {
            errors.rejectValue("email", "email.valid", "Please input email");
        }
        if (customerDto.address.matches("")) {
            errors.rejectValue("address", "address.valid", "Please input address");
        }

    }
}
