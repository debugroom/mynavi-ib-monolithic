package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.FinancialInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialInstitutionRepository
        extends JpaRepository<FinancialInstitution, String> {
}
