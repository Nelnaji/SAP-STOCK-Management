package com.nelnaji.sapstockmanagement.dl.enums;

public enum VAT {
    SiX(6),
    TWELVE(12),
    TWENTY_ONE(21);


    public final int value;
    VAT(int value){
        this.value = value;
    }
}
