package org.debugroom.mynavi.ib.monolithic.app.service.investment.trusts.impl;

import org.debugroom.mynavi.ib.monolithic.app.service.investment.trusts.FundOrderService;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Fund;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FundAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Prospectus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fundOrderService")
public class FundOrderServiceImpl implements FundOrderService {

    @Override
    public List<FundAccount> getFundAccounts(String userId) {
        return null;
    }

    @Override
    public List<Fund> getBuyableFunds(String userId) {
        return null;
    }

    @Override
    public Fund getFund(String fundId) {
        return null;
    }

    @Override
    public Prospectus getProspectus(String fundId) {
        return null;
    }

}
