package org.debugroom.mynavi.ib.monolithic.app.service.investment.trusts;

import java.util.List;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Fund;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FundAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Prospectus;

public interface FundOrderService {

    public List<FundAccount> getFundAccounts(String userId);
    public List<Fund> getBuyableFunds(String userId);
    public Fund getFund(String fundId);
    public Prospectus getProspectus(String fundId);

}
