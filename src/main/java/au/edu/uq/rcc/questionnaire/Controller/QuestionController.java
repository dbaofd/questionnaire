package au.edu.uq.rcc.questionnaire.Controller;

import au.edu.uq.rcc.questionnaire.Entity.Question;
import au.edu.uq.rcc.questionnaire.Respository.QuestionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRespository questionRespository;

    @GetMapping(value="/questions")
    public List<Question> questionList(){
        return questionRespository.findAll();
    }

    @GetMapping(value="/questions/{qid}")
    public List<Question> getQuestionsByQuestionnaireId(@PathVariable(value="qid") Long qid){
        return questionRespository.findQuestionsByQuestionnaireIdOrderByQuestionId(qid);
    }
}
