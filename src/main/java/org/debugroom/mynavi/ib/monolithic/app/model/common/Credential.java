package org.debugroom.mynavi.ib.monolithic.app.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Credential implements Serializable {

    private String userId;
    private String credentialKeyType;
    private String credentialKey;

}
