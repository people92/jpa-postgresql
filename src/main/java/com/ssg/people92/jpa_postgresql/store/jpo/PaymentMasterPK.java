package com.ssg.people92.jpa_postgresql.store.jpo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentMasterPK implements Serializable {

    private String pmtCode; //결제코드

    private String pmtName; //결제코드명
}
