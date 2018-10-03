package org.debugroom.mynavi.ib.monolithic.domain.component.investment.trusts;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FundAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FundOrder;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;

public interface FundAccountManipulator {

    public void addFundOrderTo(FundAccount fundAccount, FundOrder addFundOrder);
    public void cancelFundOrderFrom(FundAccount fundAccount, FundOrder cancelOrder);
    public void changeRelatedSavingsAccount(
            SavingsAccount fromSavingsAccount, SavingsAccount toSavingsAccount);

}
