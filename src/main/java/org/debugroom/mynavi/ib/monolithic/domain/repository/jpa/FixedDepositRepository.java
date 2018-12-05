package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDeposit;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FixedDepositPK;

public interface FixedDepositRepository
        extends JpaRepository<FixedDeposit, FixedDepositPK> {
}
