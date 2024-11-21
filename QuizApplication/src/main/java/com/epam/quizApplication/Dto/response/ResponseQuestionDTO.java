package com.epam.quizApplication.Dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseQuestionDTO {

    private int id;
    @NotBlank(message = "Question Title cannot be empty or Blank")
    @Size(min = 10)
    private String questionTitle;

    @NotEmpty(message = "Options should not be Empty")
    @Size(min = 4 ,message = "Minimum 4 Options Required ")
    private Set<String> options;

    private String difficulty_Level;
    @NotBlank(message = "Category cannot be empty or Blank")
    private String category;

    private Integer marks;

    @NotEmpty(message = "Correct Options should not be Empty")
    @Size(min = 1)
    private Set<String> correctOption;


}
