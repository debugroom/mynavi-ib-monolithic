package org.debugroom.mynavi.ib.monolithic.app.model.common;

public enum AccountType {

    SAVINGS_ACCOUNT("SAVINGS_ACCOUNT"),                   // 普通預金口座
    CURRENT_ACCOUNT("CURRENT_ACCOUNT"),                   // 当座預金口座
    FIXED_DEPOSIT_ACCOUNT("FIXED_DEPOSIT_ACCOUNT"),       // 定期預金口座
    INSTALLMENT_TIME_DEPOSIT_ACCOUNT
            ("INSTALLMNET_TIME_DEPOSIT_ACCOUNT"),         // 積立定期預金口座
    FOREIGN_CURRENCY_DEPOSIT_ACCOUNT
            ("FOREIGN_CURRENCY_DEPOSIT_ACCOUNT"),         // 外貨普通預金口座
    FOREIGN_CURRENCY_FIXED_DEPOSIT_ACCOUNT
            ("FOREIGN_CURRENCY_FIXED_DEPOSIT_ACCOUNT"),   // 外貨定期預金口座
    INVESTMENT_TRUSTS_GENERAL_ACCOUNT
            ("INVESTMENT_TRUSTS_GENERAL_ACCOUNT"),        // 投資信託一般口座
    INVESTMENT_TRUSTS_SPECIFIC_ACCOUNT
            ("INVESTMENT_TRUSTS_SPECIFIC_ACCOUNT") ;      // 投資信託特定口座

    private String VALUE;

    AccountType(String value){
        VALUE = value;
    }

}
