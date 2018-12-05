package org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ExchangeRate implements Serializable {

   private BigDecimal exchangeRate;
   private LocalDateTime recordDate;

}
