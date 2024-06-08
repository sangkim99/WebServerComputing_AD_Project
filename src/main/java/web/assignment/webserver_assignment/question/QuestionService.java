package web.assignment.webserver_assignment.question;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.assignment.webserver_assignment.question.domain.Question;
import web.assignment.webserver_assignment.question.dto.QuestionCreateRequest;
import web.assignment.webserver_assignment.question.dto.QuestionResponse;
import web.assignment.webserver_assignment.sbb.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;


    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("Question not found");
        }
    }

    public ResponseEntity<QuestionResponse> save(QuestionCreateRequest request) {
        Question question = questionRepository.save(new Question(request));
        return ResponseEntity.ok(new QuestionResponse(question));
    }

    public void create(String subject, String content) {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        questionRepository.save(question);
    }

}
