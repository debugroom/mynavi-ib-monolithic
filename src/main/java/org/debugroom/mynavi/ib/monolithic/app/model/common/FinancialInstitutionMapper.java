package org.debugroom.mynavi.ib.monolithic.app.model.common;

import java.util.stream.Collectors;

public interface FinancialInstitutionMapper {

    public static FinancialInstitution createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.FinancialInstitution entity){
        return FinancialInstitution.builder()
                .financialCode(entity.getFinancialCode())
                .financialInstitutionName(entity.getFinancialInstitutionName())
                .build();
    }

    public static FinancialInstitution createFromEntityWithBranches(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.FinancialInstitution entity){
        FinancialInstitution financialInstitution = createFromEntity(entity);
        financialInstitution.setBranches(entity.getBranchesByFinancialCode()
        .stream().map(BranchMapper::createFromEntity).collect(Collectors.toList()));
        return  financialInstitution;
    }

}
