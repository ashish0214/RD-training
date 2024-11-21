package com.epam.quizApplication.controler;

import com.epam.quizApplication.Dto.request.QuestionDTO;
import com.epam.quizApplication.Dto.response.ResponseQuestionDTO;
import com.epam.quizApplication.service.serviceInterface.QuestionService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionControler {

    private QuestionService questionService;

    public QuestionControler(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Tag(name = "Get", description = "Get method of Questions")
    @ApiResponses(
            @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseQuestionDTO.class))}))
    @GetMapping
    public ResponseEntity<List<ResponseQuestionDTO>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllquestion(), HttpStatus.OK);
    }



    @Tag(name = "Get", description = "Get method of Questions")
    @ApiResponses({
            @ApiResponse(responseCode = "302", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseQuestionDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Question id not present",
                    content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<ResponseQuestionDTO> getQuestionById(@PathVariable int id) {
        return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.FOUND);
    }


    @Tag(name = "Get", description = "Get method of Question by category")
    @ApiResponses({
            @ApiResponse(responseCode = "302", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = QuestionDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Quiz id Not present",
                    content = @Content)})
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ResponseQuestionDTO>> getQuestionById(@PathVariable String category) {
        return new ResponseEntity<>(questionService.getQuestionByCategory(category), HttpStatus.FOUND);

    }


    @Tag(name = "Create", description = "Create method of Question")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content),
            @ApiResponse(responseCode = "409", description = "Question id already present",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<HttpStatus> createQuestion(@Valid @RequestBody QuestionDTO questionDTO) {
        questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Tag(name = "Update", description = "Update method of Question")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content),
            @ApiResponse(responseCode = "404", description = "Question id not present to modify",
                    content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateQuestion(@PathVariable int id, @Valid @RequestBody QuestionDTO questionDTO) {
        questionService.updateQuestion(id, questionDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @Tag(name = "Delete", description = "Update method of Question")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content),
            @ApiResponse(responseCode = "404", description = "Question id not present to modify",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable int id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
