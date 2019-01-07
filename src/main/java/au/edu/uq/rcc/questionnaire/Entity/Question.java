package au.edu.uq.rcc.questionnaire.Entity;

import au.edu.uq.rcc.questionnaire.Util.MapToStringConverter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name="q_question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, name = "questionnaireId")
    private Long questionnaireId;

    @Column(length = 700, nullable = false, name = "questionText")
    private String questionText;

    @Column(length = 100, name = "questionImgUrl")
    private String questionImgUrl;

    @Column(nullable = false, name = "questionOptionalOptionNum")
    private Integer questionOptionalOptionNum;

    @Column(nullable = false, name = "questionOptions", length=700)
    @Convert(converter = MapToStringConverter.class)
    private Map<String,String> questionOptions;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionImgUrl() {
        return questionImgUrl;
    }

    public void setQuestionImgUrl(String questionImgUrl) {
        this.questionImgUrl = questionImgUrl;
    }

    public Integer getQuestionOptionalOptionNum() {
        return questionOptionalOptionNum;
    }

    public void setQuestionOptionalOptionNum(Integer questionOptionalOptionNum) {
        this.questionOptionalOptionNum = questionOptionalOptionNum;
    }

    public Map<String, String> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(Map<String, String> questionOptions) {
        this.questionOptions = questionOptions;
    }
}
