package web.assignment.webserver_assignment.question.dto;

import lombok.Getter;
import lombok.Setter;
import web.assignment.webserver_assignment.question.domain.Question;

@Getter
@Setter
public class QuestionResponse {
    private Long id;
    private String subject;
    private String content;
    private String crestDate;

    public QuestionResponse(Question question) {
        this.id = question.getId();
        this.subject = question.getSubject();
        this.content = question.getContent();
        this.crestDate = question.getCreateDate().toString();
    }
}
