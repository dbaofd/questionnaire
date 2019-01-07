package au.edu.uq.rcc.questionnaire.Respository;

import au.edu.uq.rcc.questionnaire.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRespository extends JpaRepository<Answer,Long> {
    public List<Answer> findAnswersByUserId(String userId);
    public List<Answer> findAnswersByUserIdAndQuestionnaireId(String userId, Long questionnaireId);
}
