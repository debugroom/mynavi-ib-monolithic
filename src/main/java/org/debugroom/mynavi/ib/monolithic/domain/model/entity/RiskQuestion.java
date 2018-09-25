package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "risk_question", schema = "public", catalog = "mynavi_ib")
public class RiskQuestion {
    private String questionId;
    private String question;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<RiskAnswer> riskAnswersByQuestionId;

    @Id
    @Column(name = "question_id", nullable = false, length = 4)
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "question", nullable = true, length = 1024)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
        RiskQuestion that = (RiskQuestion) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(question, that.question) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, question, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "riskQuestionByQuestionId")
    public Collection<RiskAnswer> getRiskAnswersByQuestionId() {
        return riskAnswersByQuestionId;
    }

    public void setRiskAnswersByQuestionId(Collection<RiskAnswer> riskAnswersByQuestionId) {
        this.riskAnswersByQuestionId = riskAnswersByQuestionId;
    }
}
