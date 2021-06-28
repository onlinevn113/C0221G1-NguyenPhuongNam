package com.example.validate_regist_form.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Getter
@Setter
public class UserDto implements Validator {

    private Integer id;

    @NotBlank(message = "Please input first name")
    @Size(min = 5, max = 45, message = "from 5 to 45 letter")
    private String firstName;

    @NotBlank(message = "Please input last name")
    @Size(min = 5, max = 45, message = "from 5 to 45 letter")
    private String lastName;


    @NotBlank
    private String phoneNumber;


    @Min(value = 18, message = "Please input age more than 18")
//    @Max(value = 150, message = "Please input age less than 150")
    private int age;


    @Email(message = "Please input email invalid")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.email.equals("")) {
            errors.rejectValue("email", "email.valid", "Please input email");
        }
        if (userDto.age > 150) {
            errors.rejectValue("age", "age.valid", "You died!!");
        }
        if (userDto.phoneNumber.matches("^(84|0[3|5|7|8|9])([0-9]{8})$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.valid", "Please input phone number invalid");
        }
    }
}
