package au.edu.uq.rcc.questionnaire.Controller;

import au.edu.uq.rcc.questionnaire.Entity.Answer;
import au.edu.uq.rcc.questionnaire.Respository.AnswerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerController {

    @Autowired
    private AnswerRespository answerRespository;

    @GetMapping(value = "/answers")
    public List<Answer> answerList() {
        return answerRespository.findAll();
    }

    @PostMapping(value = "/answer")
    public Answer saveAnswer(@RequestParam("question_id") Long questionId,
                             @RequestParam("questionnaire_id") Long questionnaireId,
                             @RequestParam("user_id") String userId,
                             @RequestParam("selected_options") String selectedOptions) {
        Map<String, String> selectedOptionsMap = new HashMap<>();
        //reslove String, transfer String into Map
        //System.out.println(selectedOptions);
        selectedOptions = selectedOptions.replace("{", "");
        selectedOptions = selectedOptions.replace("}", "");
        String[] options = selectedOptions.split(", ");
        for (int i = 0; i < options.length; i++) {
            String[] optionsSplit = options[i].split("=");
            selectedOptionsMap.put(optionsSplit[0], optionsSplit[1]);
        }
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setQuestionnaireId(questionnaireId);
        answer.setSelectedOptions(selectedOptionsMap);
        answer.setUserId(userId);
        return answerRespository.save(answer);
    }


    @GetMapping(value = "/answers/{uid}/{qid}")
    public List<Answer> findAnswersByUserId(@PathVariable(value = "uid") String uid,
                                            @PathVariable(value = "qid") Long qid) {
        return answerRespository.findAnswersByUserIdAndQuestionnaireId(uid, qid);
    }


}
