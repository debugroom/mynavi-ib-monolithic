package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "risk_answer", schema = "public", catalog = "mynavi_ib")
@IdClass(RiskAnswerPK.class)
public class RiskAnswer {
    private String questionId;
    private String answerId;
    private String answer;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<AnswerOfUser> answerOfUsers;
    private Collection<BuyableFundByRiskAnswer> buyableFundByRiskAnswers;
    private RiskQuestion riskQuestionByQuestionId;

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

    @Basic
    @Column(name = "answer", nullable = true, length = 1024)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        RiskAnswer that = (RiskAnswer) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answerId, that.answerId) &&
                Objects.equals(answer, that.answer) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, answerId, answer, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "riskAnswer")
    public Collection<AnswerOfUser> getAnswerOfUsers() {
        return answerOfUsers;
    }

    public void setAnswerOfUsers(Collection<AnswerOfUser> answerOfUsers) {
        this.answerOfUsers = answerOfUsers;
    }

    @OneToMany(mappedBy = "riskAnswer")
    public Collection<BuyableFundByRiskAnswer> getBuyableFundByRiskAnswers() {
        return buyableFundByRiskAnswers;
    }

    public void setBuyableFundByRiskAnswers(Collection<BuyableFundByRiskAnswer> buyableFundByRiskAnswers) {
        this.buyableFundByRiskAnswers = buyableFundByRiskAnswers;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false, insertable = false, updatable = false)})
    public RiskQuestion getRiskQuestionByQuestionId() {
        return riskQuestionByQuestionId;
    }

    public void setRiskQuestionByQuestionId(RiskQuestion riskQuestionByQuestionId) {
        this.riskQuestionByQuestionId = riskQuestionByQuestionId;
    }
}
