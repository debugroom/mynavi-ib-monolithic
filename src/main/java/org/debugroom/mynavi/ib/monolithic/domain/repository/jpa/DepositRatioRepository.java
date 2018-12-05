package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.DepositRatio;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.DepositRatioPK;

import java.util.List;

public interface DepositRatioRepository
        extends JpaRepository<DepositRatio, DepositRatioPK> {

    public List<DepositRatio> findByDepositType(String depositType);

}
