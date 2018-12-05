package org.debugroom.mynavi.ib.monolithic.app.model.fixed.deposit;

import org.debugroom.mynavi.ib.monolithic.app.model.common.DepositType;

public enum  FixedDepositType implements DepositType {

    HALF_YEAR_FIXED_DEPOSIT("HALF_YEAR_FIXED_DEPOSIT"),
    ONE_YEAR_FIXED_DEPOSIT("ONE_YEAR_FIXED_DEPOSIT"),
    THREE_YEAR_FIXED_DEPOSIT("THREE_YEAR_FIXED_DEPOSIT"),
    FIVE_YEAR_FIXED_DEPOSIT("FIVE_YEAR_FIXED_DEPOSIT");

    private String VALUE;

    FixedDepositType(String value){
        VALUE = value;
    }

}
