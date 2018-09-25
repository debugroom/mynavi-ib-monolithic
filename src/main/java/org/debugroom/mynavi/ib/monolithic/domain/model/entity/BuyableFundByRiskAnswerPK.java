package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class BuyableFundByRiskAnswerPK implements Serializable {
    private String questionId;
    private String answerId;
    private String fundId;

    @Column(name = "question_id", nullable = false, insertable = false, updatable = false,  length = 4)
    @Id
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Column(name = "answer_id", nullable = false,  insertable = false, updatable = false, length = 4)
    @Id
    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    @Column(name = "fund_id", nullable = false,  insertable = false, updatable = false, length = 8)
    @Id
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyableFundByRiskAnswerPK that = (BuyableFundByRiskAnswerPK) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answerId, that.answerId) &&
                Objects.equals(fundId, that.fundId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, answerId, fundId);
    }
}
