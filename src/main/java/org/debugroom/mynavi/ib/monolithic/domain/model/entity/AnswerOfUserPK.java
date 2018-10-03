package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AnswerOfUserPK implements Serializable {
    private String questionId;
    private String answerId;
    private String userId;

    @Column(name = "question_id", nullable = false, length = 4)
    @Id
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Column(name = "answer_id", nullable = false, length = 4)
    @Id
    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    @Column(name = "user_id", nullable = false, length = 8)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerOfUserPK that = (AnswerOfUserPK) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answerId, that.answerId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, answerId, userId);
    }
}
