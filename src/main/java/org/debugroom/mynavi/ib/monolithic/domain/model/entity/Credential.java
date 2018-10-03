package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "credntial", schema = "public", catalog = "mynavi_ib")
@IdClass(CredentialPK.class)
public class Credential {
    private String userId;
    private String credentialKeyType;
    private String credentialKey;
    private Timestamp lastUpdatedAt;
    private Integer ver;
    private User userByUserId;
    private User usrByUserId;

    @Id
    @Column(name = "user_id", nullable = false, length = 8)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "credential_key_type", nullable = false, length = 50)
    public String getCredentialKeyType() {
        return credentialKeyType;
    }

    public void setCredentialKeyType(String credentialKeyType) {
        this.credentialKeyType = credentialKeyType;
    }

    @Basic
    @Column(name = "credential_key", nullable = true, length = 50)
    public String getCredentialKey() {
        return credentialKey;
    }

    public void setCredentialKey(String credentialKey) {
        this.credentialKey = credentialKey;
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
        Credential that = (Credential) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(credentialKeyType, that.credentialKeyType) &&
                Objects.equals(credentialKey, that.credentialKey) &&
                Objects.equals(lastUpdatedAt, that.lastUpdatedAt) &&
                Objects.equals(ver, that.ver);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, credentialKeyType, credentialKey, lastUpdatedAt, ver);
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
