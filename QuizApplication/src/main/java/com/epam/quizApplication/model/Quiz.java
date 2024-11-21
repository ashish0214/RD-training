package com.epam.quizApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Quiz")
public class Quiz {
    @Id
    @Column(name = "Title" ,unique = true)
    private String quizTitle;

    @Column(name = "Description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Question_InQuiz"
            ,joinColumns = @JoinColumn(name = "Quiz_id")
            ,inverseJoinColumns = @JoinColumn(name = "Question_Id"))
    private List<Question> questionsList;

}
