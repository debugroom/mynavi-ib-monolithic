package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Transfer;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.TransferPK;

public interface TransferRepository extends JpaRepository<Transfer, TransferPK>{
}
