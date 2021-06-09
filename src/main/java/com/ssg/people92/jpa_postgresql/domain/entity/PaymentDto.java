package com.ssg.people92.jpa_postgresql.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDto {

	private String pmtId;

	private String mbrId;

	private String pmtCode;

	private String pmtType;

	private String succYn;

	private String succMsg;

	private String aprvType;

	private Timestamp aprvTime;

	private Long pmtAmt;


	private String bfPmtCode;

	private String regpeId; //등록자

	private String modpeId; //수정자

	public PaymentDto(String mbrId, String pmtCode, String pmtType, long pmtAmt, String aprvType){
		this.mbrId = mbrId;
		this.pmtCode = pmtCode;
		this.pmtType = pmtType;
		this.pmtAmt = pmtAmt;
		this.aprvType = aprvType;
	}

	public PaymentDto(String mbrId, String pmtCode, String pmtType, long pmtAmt, String aprvType, String bfPmtId){
		this.mbrId = mbrId;
		this.pmtCode = pmtCode;
		this.pmtType = pmtType;
		this.pmtAmt = pmtAmt;
		this.aprvType = aprvType;
		this.bfPmtCode = bfPmtId;
	}
}
