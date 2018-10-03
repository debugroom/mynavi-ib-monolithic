package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccount;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.SavingsAccountPK;

public interface SavingsAccountRepository
        extends JpaRepository<SavingsAccount, SavingsAccountPK> {
}
