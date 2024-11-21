package com.epam.quizApplication.service.serviceInterface;

import com.epam.quizApplication.Dto.request.QuestionDTO;
import com.epam.quizApplication.Dto.response.ResponseQuestionDTO;

import java.util.List;

public interface QuestionService {
    void  createQuestion(QuestionDTO question);

    void  updateQuestion(int id, QuestionDTO newQuestion);

    void  deleteQuestion(int id) ;

    List<ResponseQuestionDTO> getAllquestion();

    public ResponseQuestionDTO getQuestionById(int id);

    public List<ResponseQuestionDTO> getQuestionByCategory(String category);
}
