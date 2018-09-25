package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "buyable_fund_by_risk_answer", schema = "public", catalog = "mynavi_ib")
@IdClass(BuyableFundByRiskAnswerPK.class)
public class BuyableFundByRiskAnswer {
    private String questionId;
    private String answerId;
    private String fundId;
    private Boolean canBy;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private RiskAnswer riskAnswer;
    private Fund fundByFundId;

    @Id
    @Column(name = "question_id", nullable = false, length = 4)
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Id
    @Column(name = "answer_id", nullable = false, length = 4)
    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    @Id
    @Column(name = "fund_id", nullable = false, length = 8)
    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    @Basic
    @Column(name = "can_by", nullable = true)
    public Boolean getCanBy() {
        return canBy;
    }

    public void setCanBy(Boolean canBy) {
        this.canBy = canBy;
    }

    @Basic
    @Column(name = "last_updated_at", nullable = true)
    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Basic
    @Column(name = "ver", nullable = true)
    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyableFundByRiskAnswer that = (BuyableFundByRiskAnswer) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answerId, that.answerId) &&
                Objects.equals(fundId, that.fundId) &&
                Objects.equals(canBy, that.canBy) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, answerId, fundId, canBy, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false), @JoinColumn(name = "answer_id", referencedColumnName = "answer_id", nullable = false)})
    public RiskAnswer getRiskAnswer() {
        return riskAnswer;
    }

    public void setRiskAnswer(RiskAnswer riskAnswer) {
        this.riskAnswer = riskAnswer;
    }

    @ManyToOne
    @JoinColumn(name = "fund_id", referencedColumnName = "fund_id", nullable = false)
    public Fund getFundByFundId() {
        return fundByFundId;
    }

    public void setFundByFundId(Fund fundByFundId) {
        this.fundByFundId = fundByFundId;
    }
}
