package com.epam.quizApplication.Dto.response;

import com.epam.quizApplication.model.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseQuizDTO {
    @NotBlank(message = "Quiz description cannot be empty or Blank")
    private String description;

    @NotEmpty
    @Size(min =5,message ="Minimum 5 questions are required")
    private List<Question> questionsList;

}
