package org.debugroom.mynavi.ib.monolithic.app.model.foreign.currency.deposit;

public enum ForeginCurrencyDepositType {

    FOREGIN_CURRENCY_ORDINARY_DEPOSIT("FOREGIN_CURRENCY_ORDINARY_DEPOSIT"),
    FOREGIN_CURRENCY_ONE_YEAR_FIXED_DEPOSIT("FOREGIN_CURRENCY_ONE_YEAR_FIXED_DEPOSIT"),
    FOREGIN_CURRENCY_HALF_YEAR_FIXED_DEPOSIT("FOREGIN_CURRENCY_HALF_YEAR_FIXED_DEPOSIT"),
    FOREGIN_CURRENCY_THREE_MONTH_FIXED_DEPOSIT("FOREGIN_CURRENCY_THREE_MONTH_FIXED_DEPOSIT"),
    FOREGIN_CURRENCY_ONE_MONTH_FIXED_DEPOSIT("FOREGIN_CURRENCY_ONE_MONTH_FIXED_DEPOSIT");

    private String VALUE;

    ForeginCurrencyDepositType(String value) {VALUE = value;}

}