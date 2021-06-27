package com.example.b03_product_springboot.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductDto implements Validator {

    private Integer id;
    private String name;
    @NotNull(message = "Please input price")
    private Double price;
    @NotBlank(message = "Please input description")
    private String description;
    @NotBlank(message = "Please input manufacturer")
    private String manufacturer;



    private String date;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto= (ProductDto) target;
//        if (productDto.price.toString().matches("\\d")){
//            errors.rejectValue("price","price.valid","Please input number");
//        }
        if (!productDto.name.matches("^[A-Z]([a-z]*)+([0-9]*)$")){
            errors.rejectValue("name","name.valid","Please input name valid");
        }
    }
}
