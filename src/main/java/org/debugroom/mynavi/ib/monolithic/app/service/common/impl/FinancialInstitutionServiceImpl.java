package org.debugroom.mynavi.ib.monolithic.app.service.common.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.debugroom.mynavi.ib.monolithic.app.model.common.Branch;
import org.debugroom.mynavi.ib.monolithic.app.model.common.FinancialInstitution;
import org.debugroom.mynavi.ib.monolithic.app.model.common.FinancialInstitutionMapper;
import org.debugroom.mynavi.ib.monolithic.app.service.common.FinancialInstitutionService;
import org.debugroom.mynavi.ib.monolithic.domain.repository.jpa.FinancialInstitutionRepository;

@Service("financialInstitutionService")
public class FinancialInstitutionServiceImpl implements FinancialInstitutionService {

    @Autowired
    FinancialInstitutionRepository financialInstitutionRepository;

    @Override
    public List<FinancialInstitution> getFinancialInstitions() {
        return financialInstitutionRepository.findAll()
                .stream().map(FinancialInstitutionMapper::createFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Branch> getBranches(String financialCode) {
        return FinancialInstitutionMapper.createFromEntityWithBranches(
                financialInstitutionRepository.getOne(financialCode)).getBranches();
    }

}
