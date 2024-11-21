package com.epam.quizApplication.service.serviceInterface;


import com.epam.quizApplication.Dto.request.QuizDTO;
import com.epam.quizApplication.Dto.response.ResponseQuizDTO;

import java.util.List;


public interface QuizService {
    void createQuiz(QuizDTO quiz);
    void updateQuiz(QuizDTO quiz) ;
    void removeQuiz(String quizName) ;
    ResponseQuizDTO findQuiz(String quizName);
    List<ResponseQuizDTO> findAllQuiz();
}

