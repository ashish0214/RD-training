package com.epam.quizApplication.service;

import com.epam.quizApplication.Dto.request.QuizDTO;
import com.epam.quizApplication.Dto.response.ResponseQuizDTO;
import com.epam.quizApplication.exception.ResourceAlreadyExistException;
import com.epam.quizApplication.exception.ResourceNotFoundException;
import com.epam.quizApplication.mapper.Mapper;
import com.epam.quizApplication.model.Quiz;
import com.epam.quizApplication.repositorie.QuizLibraryDAO;
import com.epam.quizApplication.service.serviceInterface.QuizService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServicesImpl implements QuizService {
    private static Logger log=LogManager.getLogger(QuizServicesImpl.class);
    private QuizLibraryDAO quizLibraryDAO;
    private Mapper mapper;

    public QuizServicesImpl(QuizLibraryDAO quizLibraryDAO, Mapper mapper) {
        this.quizLibraryDAO = quizLibraryDAO;
        this.mapper = mapper;
    }

    @Override
    public void createQuiz(QuizDTO quizDTO) throws ResourceAlreadyExistException {
        Quiz quiz =mapper.mapToQuizEntity(quizDTO);
        Optional<Quiz> checkSameQuizAvailable = quizLibraryDAO.findById(quizDTO.getQuizTitle());
        checkSameQuizAvailable.ifPresentOrElse(element -> {
            throw new ResourceAlreadyExistException("QuizName present");
        }, () -> quizLibraryDAO.save(quiz));
        log.info("Quiz created");
    }

    @Override
    public void updateQuiz( QuizDTO quizDTO) throws ResourceNotFoundException {
        Quiz quiz = mapper.mapToQuizEntity(quizDTO);
        Optional<Quiz> checkSameQuizAvailable = quizLibraryDAO.findById(quizDTO.getQuizTitle());
        checkSameQuizAvailable.ifPresentOrElse(element -> quizLibraryDAO.save(quiz),
                () -> {
                    throw new ResourceNotFoundException("QuizName not present");
                });
        log.info("Quiz updated successfully");
    }

    @Override
    public void removeQuiz(String quizName) throws ResourceNotFoundException {
        Optional<Quiz> checkSameQuizAvailable = quizLibraryDAO.findById(quizName);
        checkSameQuizAvailable.ifPresentOrElse(element -> quizLibraryDAO.deleteById(quizName),
                () -> {
                    throw new ResourceNotFoundException("Quiz not found");
                });
        log.info("Quiz deleted successfully");
    }

    @Override
    public ResponseQuizDTO findQuiz(String quizName) {
        Optional<Quiz> quiz = quizLibraryDAO.findById(quizName);
        if(quiz.isEmpty()){
            throw new ResourceNotFoundException("Quiz id Not present");
        }
        log.info("Quiz name fetched successfully");
        ResponseQuizDTO responseQuizDTO = mapper.mapToQuizDTO(quiz.get());
        return responseQuizDTO;
    }

    public List<ResponseQuizDTO> findAllQuiz() {
        List<Quiz> quizList = quizLibraryDAO.findAll();
        log.info("All Question  fetched successfully");
        return quizList.stream().map(ele -> mapper.mapToQuizDTO(ele)).toList();
    }

}

