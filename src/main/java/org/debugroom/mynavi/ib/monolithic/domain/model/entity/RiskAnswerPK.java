package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RiskAnswerPK implements Serializable {
    private String questionId;
    private String answerId;

    @Column(name = "question_id", nullable = false, insertable = false, updatable = false,  length = 4)
    @Id
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Column(name = "answer_id", nullable = false, insertable = false, updatable = false,  length = 4)
    @Id
    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskAnswerPK that = (RiskAnswerPK) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answerId, that.answerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, answerId);
    }
}
