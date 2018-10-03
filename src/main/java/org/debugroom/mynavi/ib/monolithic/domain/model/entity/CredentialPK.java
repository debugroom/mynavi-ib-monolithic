package org.debugroom.mynavi.ib.monolithic.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CredentialPK implements Serializable {
    private String userId;
    private String credentialKeyType;

    @Column(name = "user_id", nullable = false, length = 8)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "credential_key_type", nullable = false, length = 50)
    @Id
    public String getCredentialKeyType() {
        return credentialKeyType;
    }

    public void setCredentialKeyType(String credentialKeyType) {
        this.credentialKeyType = credentialKeyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialPK that = (CredentialPK) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(credentialKeyType, that.credentialKeyType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, credentialKeyType);
    }
}
