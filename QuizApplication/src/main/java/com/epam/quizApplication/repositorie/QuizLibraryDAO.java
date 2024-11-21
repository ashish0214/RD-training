package com.epam.quizApplication.repositorie;

import com.epam.quizApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizLibraryDAO extends JpaRepository<Quiz,String> {
}
