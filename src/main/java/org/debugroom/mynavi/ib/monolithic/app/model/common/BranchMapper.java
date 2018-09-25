package org.debugroom.mynavi.ib.monolithic.app.model.common;

public interface BranchMapper {

    public static Branch createFromEntity(
            org.debugroom.mynavi.ib.monolithic.domain.model.entity.Branch entity){
        return Branch.builder()
                .financialCode(entity.getFinancialCode())
                .branchId(entity.getBranchId())
                .branchName(entity.getBranchName())
                .build();
    }

}
