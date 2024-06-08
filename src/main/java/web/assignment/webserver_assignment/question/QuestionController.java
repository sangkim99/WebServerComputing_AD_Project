package web.assignment.webserver_assignment.question;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.assignment.webserver_assignment.question.dto.QuestionCreateRequest;
import web.assignment.webserver_assignment.question.dto.QuestionResponse;

@RequestMapping("question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    // 데이터 넣기용 테스트 코드
    @PostMapping("")
    public ResponseEntity<QuestionResponse> save(@RequestBody QuestionCreateRequest request) {
       return questionService.save(request);

    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("questionList", questionService.findAll());
        return "question_list";
    }

    @GetMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        model.addAttribute("question", questionService.getQuestion(id));
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@RequestParam(value = "subject") String subject,
                                 @RequestParam(value = "content") String content){
        questionService.create(subject, content);
        return "redirect:/question/list";
    }
}
