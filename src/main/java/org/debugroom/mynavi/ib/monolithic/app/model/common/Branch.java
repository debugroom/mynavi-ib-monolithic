package org.debugroom.mynavi.ib.monolithic.app.model.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Branch implements Serializable {

    private String financialCode;
    private String branchId;
    private String branchName;

}
