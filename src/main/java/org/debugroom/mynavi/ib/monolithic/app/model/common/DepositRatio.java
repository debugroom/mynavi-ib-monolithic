package org.debugroom.mynavi.ib.monolithic.app.model.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DepositRatio implements Serializable {

    private DepositType depositType;
    private String validStartDay;
    private BigDecimal ratio;
    private ZonedDateTime zonedDateTime;

}
