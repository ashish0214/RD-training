package com.epam.quizApplication.model;

import com.epam.quizApplication.constant.DifficultyLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Title")
    private String questionTitle;

    @ElementCollection()
    @CollectionTable(name = "question_options", joinColumns = {@JoinColumn(name = "questions_id", referencedColumnName = "id")})
    private Set<String> options;

    @Enumerated(EnumType.STRING)
    @Column(name = "Difficulty_Level")
    private DifficultyLevel difficulty_Level;

    @Column(name = "Category")
    private String category;

    @Column(name = "Marks")
    private Integer marks;

    @ElementCollection
    @CollectionTable(name = "Correct_Options", joinColumns = {@JoinColumn(name = "questions_id", referencedColumnName = "id")})
    private Set<String> correctOption;


}
