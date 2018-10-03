package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.Branch;
import org.debugroom.mynavi.ib.monolithic.domain.model.entity.BranchPK;

public interface BranchRepository extends JpaRepository<Branch, BranchPK> {
}
