package com.epam.quizApplication.mapper;

import com.epam.quizApplication.Dto.request.QuestionDTO;
import com.epam.quizApplication.Dto.request.QuizDTO;
import com.epam.quizApplication.Dto.response.ResponseQuestionDTO;
import com.epam.quizApplication.Dto.response.ResponseQuizDTO;
import com.epam.quizApplication.model.Question;
import com.epam.quizApplication.model.Quiz;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ModelMapper mapper;

    public Mapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ResponseQuestionDTO mapToQuestionDTO(Question question){
      ResponseQuestionDTO responseQuestionDTO=mapper.map(question,ResponseQuestionDTO.class);
      return responseQuestionDTO;
    }
    public Question mapToQuestionEntity(QuestionDTO questionDTO){
        Question question=mapper.map(questionDTO,Question.class);
        return question;
    }

    public ResponseQuizDTO mapToQuizDTO(Quiz quiz){
        ResponseQuizDTO responseQuizDTO=mapper.map(quiz,ResponseQuizDTO.class);
        return responseQuizDTO;
    }
    public Quiz mapToQuizEntity(QuizDTO quizDTO){
        Quiz quiz=mapper.map(quizDTO,Quiz.class);
        return quiz;
    }
}
