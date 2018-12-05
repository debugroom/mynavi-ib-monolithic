package org.debugroom.mynavi.ib.monolithic.app.model.common;

import org.debugroom.mynavi.ib.monolithic.app.AppConsts;

import java.time.ZoneId;

public interface RiskAnswerMapper {

    public static RiskAnswer createByEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.RiskAnswer entity){
        return RiskAnswer.builder()
                .questionId(entity.getQuestionId())
                .answerId(entity.getAnswerId())
                .answer(entity.getAnswer())
                .lastUpdatedAt(entity.getLastUpdatedAt().toLocalDateTime()
                    .atZone(ZoneId.of(ZoneId.SHORT_IDS.get(AppConsts.TIMEZONE_SHORT_ID))))
                .build();
    }

}
