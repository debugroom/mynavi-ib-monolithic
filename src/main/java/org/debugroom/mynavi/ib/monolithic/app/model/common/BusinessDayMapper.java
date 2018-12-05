package org.debugroom.mynavi.ib.monolithic.app.model.common;

public interface BusinessDayMapper {

    public static BusinessDay createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.BusinessDay entity){
        return BusinessDay.builder()
                .yyyymmdd(entity.getYyyymmdd())
                .isBusinessDay(entity.getBusinessDay())
                .build();
    }

}
