package web.assignment.webserver_assignment.question;

import org.springframework.data.jpa.repository.JpaRepository;
import web.assignment.webserver_assignment.question.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
}
