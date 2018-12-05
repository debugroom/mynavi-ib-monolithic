package org.debugroom.mynavi.ib.monolithic.app.model.common;

public enum TransactionStatus implements Status{

    COMPLETE("COMPLETE"),
    DEPOSIT("DEPOSIT"),
    CANCELED("CANCELED"),
    RESERVED("RESERVED");

    public final String VALUE;

    TransactionStatus(String value){
        VALUE = value;
    }
}

