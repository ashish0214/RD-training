package com.epam.quizApplication.ConsoleUserInterface.userInterface;


import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;

import java.util.Scanner;

public interface QuizOperations {
	void execute(QuizService quizServices, QuestionService questionServices, Scanner scanner);
}
