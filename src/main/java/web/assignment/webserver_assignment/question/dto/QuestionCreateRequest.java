package web.assignment.webserver_assignment.question.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionCreateRequest {
    private String subject;
    private String content;
}
