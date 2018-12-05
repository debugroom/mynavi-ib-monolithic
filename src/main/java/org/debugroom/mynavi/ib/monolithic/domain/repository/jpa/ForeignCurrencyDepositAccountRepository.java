package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.ForeignCurrencyDepositAccountPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignCurrencyDepositAccountRepository
        extends JpaRepository<ForeignCurrencyDepositAccount, ForeignCurrencyDepositAccountPK> {

    public List<ForeignCurrencyDepositAccount> findByUserId(String userId);

}
