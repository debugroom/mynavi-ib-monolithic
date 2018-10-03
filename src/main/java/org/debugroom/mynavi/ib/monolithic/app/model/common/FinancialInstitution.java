package org.debugroom.mynavi.ib.monolithic.app.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FinancialInstitution implements Serializable {

    private String financialCode;
    private String financialInstitutionName;
    private List<Branch> branches;

}
