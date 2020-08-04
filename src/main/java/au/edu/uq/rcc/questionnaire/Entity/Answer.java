package au.edu.uq.rcc.questionnaire.Entity;

import au.edu.uq.rcc.questionnaire.Util.MapToStringConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "q_answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(length = 40, nullable = false, name = "userId")
    private String userId;

    @Column(nullable = false, name = "questionId")
    private Long questionId;

    @Column(nullable = false, name = "questionnaireId")
    private Long questionnaireId;

    @Column(nullable = false, name = "selectedOptions", length = 700)
    @Convert(converter = MapToStringConverter.class)
    private Map<String, String> selectedOptions;

    @Column(name = "submittedTime")
    private LocalDateTime submittedTime = LocalDateTime.now();

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Map<String, String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(Map<String, String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public LocalDateTime getSubmittedTime() {
        return submittedTime;
    }

    public void setSubmittedTime(LocalDateTime submittedTime) {
        this.submittedTime = submittedTime;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
