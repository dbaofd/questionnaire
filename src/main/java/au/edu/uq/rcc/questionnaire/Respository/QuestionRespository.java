package au.edu.uq.rcc.questionnaire.Respository;

import au.edu.uq.rcc.questionnaire.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRespository extends JpaRepository<Question, Long> {
    public List<Question> findQuestionsByQuestionnaireId(Long questionnaireId);

    public List<Question> findQuestionsByQuestionnaireIdOrderByQuestionId(Long questionnaireId);
}
