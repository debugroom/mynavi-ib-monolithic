package org.debugroom.mynavi.ib.monolithic.app.service.common;

import java.util.List;

import org.debugroom.mynavi.ib.monolithic.app.model.common.Branch;
import org.debugroom.mynavi.ib.monolithic.app.model.common.FinancialInstitution;

public interface FinancialInstitutionService {

    public List<FinancialInstitution> getFinancialInstitions();
    public List<Branch> getBranches(String financialCode);

}
