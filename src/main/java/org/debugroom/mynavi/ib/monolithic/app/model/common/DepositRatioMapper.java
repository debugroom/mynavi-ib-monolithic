package org.debugroom.mynavi.ib.monolithic.app.model.common;

public interface DepositRatioMapper {

    public static DepositRatio createByEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.DepositRatio entity){
       return DepositRatio.builder()
               .build();
    }

}
