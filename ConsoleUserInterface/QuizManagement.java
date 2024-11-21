package com.epam.quizApplication.ConsoleUserInterface;


import com.epam.quizApplication.ConsoleUserInterface.userInterface.Operation;
import com.epam.quizApplication.constant.Role;
import com.epam.quizApplication.exceptions.QuizNamePresentException;
import com.epam.quizApplication.models.User;
import com.epam.quizApplication.services.serviceInterface.QuestionService;
import com.epam.quizApplication.services.serviceInterface.QuizService;
import com.epam.quizApplication.services.serviceInterface.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class QuizManagement {
    static{
        System.out.println("Hello User");
    }
    private static final Logger logger= LogManager.getLogger(QuizManagement.class);
    private static QuestionService questionServices;
    private static QuizService quizServices;
    private static UserServices userServices;

    @Autowired
    public QuizManagement(QuestionService questionServices, QuizService quizServices, UserServices userServices) {
        this.questionServices = questionServices;
        this.quizServices = quizServices;
        this.userServices = userServices;
    }

    public void quizManagement() {

        Scanner scanner = new Scanner(System.in);
        userServices.creatUser(new User("Ashish", "admin123", Role.ADMIN));
        userServices.creatUser(new User("Abhay", "user123", Role.USER));
        logger.info("Enter the username :");
        String username = scanner.nextLine();
        logger.info("Enter the password :");
        String password = scanner.nextLine();

        try {
            if (userServices.validate(username, password)) {
                int choice;
                do {
                    logger.info("\nMain Menu:");
                    logger.info("1. Question operations");
                    logger.info("2. Quiz operations");
                    logger.info("3. Exit");
                    logger.info("Enter your choice: ");
                    choice = scanner.nextInt();
                    OperationsFactory operationsFactory = new OperationsFactory();
                    Operation operation = operationsFactory.getOperation(choice);
                    if (operation != null) {
                        operation.execute(questionServices, quizServices, scanner);
                    }

                } while (choice <= 3);
            } else {
                logger.info("Admin not present");
            }
        } catch (QuizNamePresentException e) {
            logger.error(e.getMessage());
        } catch (InputMismatchException e) {
            logger.info("Invalid input");
        }
    }
}
