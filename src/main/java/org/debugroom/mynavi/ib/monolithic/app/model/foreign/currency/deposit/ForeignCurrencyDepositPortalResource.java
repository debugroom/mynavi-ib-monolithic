package org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;
import org.debugroom.mynavi.ib.monolithic.app.model.common.User;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ForeignCurrencyDepositPortalResource implements PortalResource {

    private User user;
    private List<ForeignCurrencyDepositAccount> foreignCurrencyDepositAccounts;

}
