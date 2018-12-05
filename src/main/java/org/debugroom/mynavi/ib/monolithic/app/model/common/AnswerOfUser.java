package org.debugroom.mynavi.ib.monolithic.app.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnswerOfUser {

    private String questionId;
    private String answerId;
    private String userId;
    private ZonedDateTime lastUpdatedAt;
    private RiskAnswer riskAnswer;

}
