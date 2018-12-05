package org.debugroom.mynavi.ib.monolithic.domain;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="domain")
public class DomainProperties {

    private final BigDecimal transferFeeBoundaryPrice;
    private final BigDecimal transferFeeHignForOtherFinancialInstition;
    private final BigDecimal transferFeeHighForSameFinancialInstition;
    private final BigDecimal transferFeeLowForOtherFinancialInstition;
    private final BigDecimal transferFeeLowForSameFinancialInstition;

}
