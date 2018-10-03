package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "answer_of_user", schema = "public", catalog = "mynavi_ib")
@IdClass(AnswerOfUserPK.class)
public class AnswerOfUser {
    private String questionId;
    private String answerId;
    private String userId;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private RiskAnswer riskAnswer;
    private User userByUserId;
    private User usrByUserId;

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
    @Column(name = "user_id", nullable = false, length = 8)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        AnswerOfUser that = (AnswerOfUser) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(answerId, that.answerId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionId, answerId, userId, lastUpdatedAt, ver);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "answer_id", referencedColumnName = "answer_id", nullable = false, insertable = false, updatable = false)})
    public RiskAnswer getRiskAnswer() {
        return riskAnswer;
    }

    public void setRiskAnswer(RiskAnswer riskAnswer) {
        this.riskAnswer = riskAnswer;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    public User getUsrByUserId() {
        return usrByUserId;
    }

    public void setUsrByUserId(User usrByUserId) {
        this.usrByUserId = usrByUserId;
    }
}
