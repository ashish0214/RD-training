package com.epam.quizApplication.service;

import com.epam.quizApplication.Dto.request.QuestionDTO;
import com.epam.quizApplication.Dto.response.ResponseQuestionDTO;
import com.epam.quizApplication.exception.ResourceAlreadyExistException;
import com.epam.quizApplication.exception.ResourceNotFoundException;
import com.epam.quizApplication.mapper.Mapper;
import com.epam.quizApplication.model.Question;
import com.epam.quizApplication.repositorie.QuestionLibraryDAO;
import com.epam.quizApplication.service.serviceInterface.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionServicesImpl implements QuestionService {

    private static Logger log = LogManager.getLogger(QuestionServicesImpl.class);
    private QuestionLibraryDAO questionDAO;
    private Mapper mapper;
@Autowired
    public QuestionServicesImpl(QuestionLibraryDAO questionDAO, Mapper mapper) {
        this.questionDAO = questionDAO;
        this.mapper = mapper;
    }


    @Override
    public void createQuestion(QuestionDTO questionDTO) throws ResourceAlreadyExistException {

        Optional<Question> questionExists = questionDAO.findByQuestionTitle(questionDTO.getQuestionTitle());
        Question question = mapper.mapToQuestionEntity(questionDTO);
        questionExists.ifPresentOrElse(question1 -> {
            throw new ResourceAlreadyExistException("Question id already present");
        }, () -> questionDAO.save(question));
        log.info("Question created");
    }

    @Override
    public void updateQuestion(int id, QuestionDTO questionDTO) throws ResourceAlreadyExistException {
        Question newQuestion = mapper.mapToQuestionEntity(questionDTO);
        Optional<Question> questionExists = questionDAO.findById(id);
        questionExists.ifPresentOrElse(question -> questionDAO.save(newQuestion), () -> {
            throw new ResourceNotFoundException("Question id not present to modify");
        });
        log.info("Question updated successfully");
    }

    @Override
    public void deleteQuestion(int id) throws ResourceAlreadyExistException {

        Optional<Question> questionExists = questionDAO.findById(id);

        questionExists.ifPresentOrElse(question -> questionDAO.delete(question), () -> {
            throw new ResourceNotFoundException("Quesation id not present to remove");
        });
        log.info("Question deleted successfully");
    }


    public List<ResponseQuestionDTO> getAllquestion() throws ResourceAlreadyExistException {
        List<Question> questions = questionDAO.findAll();
        log.info("All Question  fetched successfully");
        return questions.stream().map(ele -> mapper.mapToQuestionDTO(ele)).toList();

    }

    public ResponseQuestionDTO getQuestionById(int id) {
        Optional<Question> questions = questionDAO.findById(id);
        if (questions.isEmpty()) {
            throw new ResourceNotFoundException("Question id not present");
        }
        log.info("Question id fetched successfully");
        return mapper.mapToQuestionDTO(questions.get());

    }

    public List<ResponseQuestionDTO> getQuestionByCategory(String category) {
        List<Question> questions = questionDAO.findByCategory(category);
        log.info("All Question  fetched by %s successfully", category);
        return questions.stream().map(ele -> mapper.mapToQuestionDTO(ele)).toList();
    }


}

