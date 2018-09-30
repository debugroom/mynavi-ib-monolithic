package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

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
    private Collection<Credential> credntialsByUserId;

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

    @OneToMany(mappedBy = "usrByUserId")
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

    @OneToMany(mappedBy = "usrByUserId")
    public Collection<SavingsAccount> getSavingsAccountsByUserId() {
        return savingsAccountsByUserId;
    }

    public void setSavingsAccountsByUserId(Collection<SavingsAccount> savingsAccountsByUserId) {
        this.savingsAccountsByUserId = savingsAccountsByUserId;
    }

    @OneToMany(mappedBy = "usrByUserId")
    public Collection<Credential> getCredntialsByUserId() {
        return credntialsByUserId;
    }

    public void setCredntialsByUserId(Collection<Credential> credntialsByUserId) {
        this.credntialsByUserId = credntialsByUserId;
    }
}
