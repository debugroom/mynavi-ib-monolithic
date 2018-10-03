package org.debugroom.mynavi.ib.monolithic.domain.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.debugroom.mynavi.ib.monolithic.domain.model.entity.BusinessDay;

public interface BusinessDayRepository extends JpaRepository<BusinessDay, String> {
}
