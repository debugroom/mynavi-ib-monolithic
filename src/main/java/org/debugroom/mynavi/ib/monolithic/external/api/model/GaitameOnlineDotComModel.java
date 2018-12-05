package org.debugroom.mynavi.ib.monolithic.external.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GaitameOnlineDotComModel {

    private List<Quote> quotes;

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Quote {
        private String currencyPairCode;
        private BigDecimal open;
        private BigDecimal high;
        private BigDecimal bid;
        private BigDecimal low;
        private BigDecimal ask;
    }

}
