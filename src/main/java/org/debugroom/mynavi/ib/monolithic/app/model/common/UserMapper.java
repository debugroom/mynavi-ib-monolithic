package org.debugroom.mynavi.ib.monolithic.app.model.common;

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
                .savingsAccounts(entity.getSavingsAccountsByUserId()
                        .stream().map(SavingsAccountMapper::createFromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
