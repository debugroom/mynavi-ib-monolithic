package org.debugroom.mynavi.ib.monolithic.app.model.common;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccount;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {

    private String userId;
    private String firstName;
    private String lastName;
    private String loginId;
    private String birthday;
    private Sex sex;
    private ZonedDateTime lastUpdatedAt;
    private List<Credential> credentials;
    private List<SavingsAccount> savingsAccounts;

    public static User createFromEntity(org.debugroom.mynavi.ib.monolithic.domain.model.entity.User entity){
        return UserMapper.createByEntity(entity);
    }

}
