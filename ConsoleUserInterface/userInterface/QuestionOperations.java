package com.epam.quizApplication.ConsoleUserInterface.userInterface;


import com.epam.quizApplication.services.serviceInterface.QuestionService;

import java.util.Scanner;

public interface QuestionOperations {
	void execute(QuestionService questionServices, Scanner scanner);
}
