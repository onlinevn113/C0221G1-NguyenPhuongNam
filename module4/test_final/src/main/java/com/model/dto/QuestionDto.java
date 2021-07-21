package com.model.dto;

import com.model.entity.QuestionType;
import lombok.Data;
import lombok.Singular;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class QuestionDto {
    private Long id;
    @NotBlank
    @Size(min = 5,max = 100,message = "Tiêu đề phải từ 5 đến 100 ký tự")
    private String title;
    @NotBlank(message = "Không được để trống")
    @Size(min = 10 ,max = 500,message = "Nội dung phải từ 10 đến 500 ký tự")
    private String question;
    private QuestionType questionType;
    private String answer;
    private String dateCreate= LocalDate.now().toString();
    private String status="Chưa phản hồi";
    private boolean flag;
}
