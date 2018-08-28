package com.computech.dto;

public class AccoutAntCondition {
	
	private String accNo;
	private String carCard;
	private String custName;
	private String custTel;
	private String jdr;
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getCarCard() {
		return carCard;
	}
	public void setCarCard(String carCard) {
		this.carCard = carCard;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustTel() {
		return custTel;
	}
	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}
	public String getJdr() {
		return jdr;
	}
	public void setJdr(String jdr) {
		this.jdr = jdr;
	}
	
	
	@Override
	public String toString() {
		return "AccoutAntCondition [accNo=" + accNo + ", carCard=" + carCard + ", custName=" + custName + ", custTel="
				+ custTel + ", jdr=" + jdr + "]";
	}

}
