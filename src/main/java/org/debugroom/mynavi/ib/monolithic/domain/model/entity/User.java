package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.AppConsts;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usr", schema = "public", catalog = "mynavi_ib")
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String loginId;
    private String birthday;
    private String sex;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private Collection<AnswerOfUser> answerOfUsersByUserId;
    private Collection<Credential> credentialsByUserId;
    private Collection<SavingsAccount> savingsAccountsByUserId;

    @Id
    @Column(name = "user_id", nullable = false, length = 8)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "login_id", nullable = true, length = 32)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "birthday", nullable = true, length = 8)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 50)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(loginId, user.loginId) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(lastUpdatedAt, user.lastUpdatedAt) &&
                Objects.equals(ver, user.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, firstName, lastName, loginId, birthday, sex, lastUpdatedAt, ver);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<AnswerOfUser> getAnswerOfUsersByUserId() {
        return answerOfUsersByUserId;
    }

    public void setAnswerOfUsersByUserId(Collection<AnswerOfUser> answerOfUsersByUserId) {
        this.answerOfUsersByUserId = answerOfUsersByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Credential> getCredentialsByUserId() {
        return credentialsByUserId;
    }

    public void setCredentialsByUserId(Collection<Credential> credentialsByUserId) {
        this.credentialsByUserId = credentialsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<SavingsAccount> getSavingsAccountsByUserId() {
        return savingsAccountsByUserId;
    }

    public void setSavingsAccountsByUserId(Collection<SavingsAccount> savingsAccountsByUserId) {
        this.savingsAccountsByUserId = savingsAccountsByUserId;
    }

    public Credential findSecondaryPassword(){
        return getCredentialsByUserId().stream().filter(credential ->
                AppConsts.CREDENTIAL_SECONDARY_PASSWORD_LOGICAL_NAME.equals(
                        credential.getCredentialKey())).findFirst().get();
    }

    public RiskAnswer inquireRiskAnswer(RiskQuestion riskQuestion){
        return  getAnswerOfUsersByUserId().stream().filter(
                answerOfUser -> answerOfUser.getRiskAnswer().getQuestionId()
                .equals(riskQuestion.getQuestionId()))
                .map(answerOfUser -> answerOfUser.getRiskAnswer()).findFirst().get();
    }

    public List<RiskAnswer> inquireRiskAnswers(){
        return getAnswerOfUsersByUserId().stream().map(
                answerOfUser -> answerOfUser.getRiskAnswer())
                .collect(Collectors.toList());
    }

}
