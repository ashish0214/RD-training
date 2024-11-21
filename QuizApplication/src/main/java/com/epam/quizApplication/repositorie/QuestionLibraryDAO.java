package com.epam.quizApplication.repositorie;

import com.epam.quizApplication.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionLibraryDAO extends JpaRepository<Question,Integer> {

    @Query("SELECT q FROM Question q WHERE q.category = :category")
    public List<Question> findByCategory(@Param("category") String category);

    @Query("SELECT q FROM Question q WHERE q.questionTitle = :title")
    public Optional<Question> findByQuestionTitle(String title);
}
