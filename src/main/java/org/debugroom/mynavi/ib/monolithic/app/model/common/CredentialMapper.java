package org.debugroom.mynavi.ib.monolithic.app.model.common;

public interface CredentialMapper {

    public static Credential createByEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.Credential entity){
        return Credential.builder()
                .userId(entity.getUserId())
                .credentialKey(entity.getCredentialKey())
                .credentialKey(entity.getCredentialKeyType())
                .build();
    }

}
