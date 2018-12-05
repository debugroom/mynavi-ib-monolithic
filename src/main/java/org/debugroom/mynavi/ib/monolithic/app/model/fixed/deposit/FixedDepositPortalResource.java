package org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import org.debugroom.mynavi.ib.monolithic.app.model.common.User;
import org.debugroom.mynavi.ib.monolithic.app.model.common.PortalResource;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FixedDepositPortalResource implements PortalResource {

    private User user;
    private List<FixedDepositAccount> fixedDepositAccounts;

}
