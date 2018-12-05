package org.debugroom.mynavi.ib.monolithic.app.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RiskAnswer implements Serializable {

    private String questionId;
    private String answerId;
    private String answer;
    private ZonedDateTime lastUpdatedAt;

}
