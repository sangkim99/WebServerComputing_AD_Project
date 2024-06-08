package web.assignment.webserver_assignment.question.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.assignment.webserver_assignment.question.dto.QuestionCreateRequest;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    public Question(QuestionCreateRequest request) {
        this.subject = request.getSubject();
        this.content = request.getContent();
        this.createDate = LocalDateTime.now();
    }
}
