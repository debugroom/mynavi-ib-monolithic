package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositAccountPK;

public interface FixedDepositAccountRepository
        extends JpaRepository<FixedDepositAccount, FixedDepositAccountPK> {

    public List<FixedDepositAccount> findByUserId(String userId);

}
