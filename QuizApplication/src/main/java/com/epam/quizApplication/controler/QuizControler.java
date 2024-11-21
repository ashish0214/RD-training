package com.epam.quizApplication.controler;

import com.epam.quizApplication.Dto.request.QuestionDTO;
import com.epam.quizApplication.Dto.request.QuizDTO;
import com.epam.quizApplication.Dto.response.ResponseQuestionDTO;
import com.epam.quizApplication.Dto.response.ResponseQuizDTO;
import com.epam.quizApplication.service.serviceInterface.QuizService;
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
@RequestMapping("/quiz")
public class QuizControler {

    QuizService quizService;

    public QuizControler(QuizService quizService) {
        this.quizService = quizService;
    }



    @Tag(name = "Get", description = "Get method of Quiz")
    @ApiResponses(
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseQuizDTO.class)) }))
    @GetMapping
    public ResponseEntity<List<ResponseQuizDTO>> getQuiz(){
        return new ResponseEntity<>(quizService.findAllQuiz(),HttpStatus.OK);
    }



    @Tag(name = "Get", description = "Get method of Quiz")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseQuizDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Quiz id Not present",
                    content = @Content) })
    @GetMapping("{id}")
    public ResponseEntity<ResponseQuizDTO> getQuizById(@PathVariable String quizName){
        return new ResponseEntity<>(quizService.findQuiz(quizName),HttpStatus.OK);
    }



    @Tag(name = "Create", description = "Create method of Quiz")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content),
            @ApiResponse(responseCode = "409", description = "QuizName present",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<HttpStatus> createQuiz( @Valid @RequestBody QuizDTO quizDTO) {
        quizService.createQuiz( quizDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @Tag(name = "Update", description = "Update method of Quiz")
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = @Content),
            @ApiResponse(responseCode = "404", description = "QuizName not present",
                    content = @Content) })
    @PutMapping
    public  ResponseEntity<HttpStatus> updateQuiz(@Valid @RequestBody QuizDTO quizDTO){
        quizService.updateQuiz(quizDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



    @Tag(name = "Delete", description = "Delete method of Quiz")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content),
            @ApiResponse(responseCode = "404", description = "Quiz not found",
                    content = @Content) })
    @DeleteMapping("{quizName}")
    public  ResponseEntity<HttpStatus> deleteQuiz(@PathVariable String quizName){
        quizService.removeQuiz(quizName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
