package com.example.b03_upload_file_springboot.model.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ProductForm {
    private Integer id;

    private String name;

    private String description;

    private MultipartFile image;

}
