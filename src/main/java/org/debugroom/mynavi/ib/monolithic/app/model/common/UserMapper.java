package org.debugroom.mynavi.ib.monolithic.app.model.common;

import org.debugroom.mynavi.ib.monolithic.app.AppConsts;
import org.debugroom.mynavi.ib.monolithic.app.model.ordinary.deposit.SavingsAccountMapper;

import java.time.ZoneId;
import java.util.stream.Collectors;

public interface UserMapper {

    public static User createByEntity(org.debugroom.mynavi.ib.monolithic.domain.model.entity.User entity){
        return User.builder()
                .userId(entity.getUserId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .loginId(entity.getLoginId())
                .birthday(entity.getBirthday())
                .sex(Sex.valueOf(entity.getSex()))
                .lastUpdatedAt(entity.getLastUpdatedAt()
                        .toLocalDateTime().atZone(
                                ZoneId.of(ZoneId.SHORT_IDS.get(
                                        AppConsts.TIMEZONE_SHORT_ID))))
                .build();
    }

    public static User createByEntityWithSavingsAccounts(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.User entity){
        User user = createByEntity(entity);
        user.setSavingsAccounts(entity.getSavingsAccountsByUserId()
        .stream().map(SavingsAccountMapper::createFromEntity)
        .collect(Collectors.toList()));
        return user;
    }

    public static User createByEntityWithCredentials(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.User entity){
        User user = createByEntity(entity);
        user.setCredentials(entity.getCredentialsByUserId().stream()
        .map(CredentialMapper::createByEntity)
        .collect(Collectors.toList()));
        return user;
    }

}
