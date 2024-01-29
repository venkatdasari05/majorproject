package com.vasu.response;

public class DashboardResponse {
	
	private Long plansCount;
	
	private Long citizenApprovedCount;
	
	private Long citizenDnCount;
	
	private Double benefitAmtTotal;

	public Long getPlansCount() {
		return plansCount;
	}

	public void setPlansCount(Long plansCount) {
		this.plansCount = plansCount;
	}

	public Long getCitizenApprovedCount() {
		return citizenApprovedCount;
	}

	public void setCitizenApprovedCount(Long citizenApprovedCount) {
		this.citizenApprovedCount = citizenApprovedCount;
	}

	public Long getCitizenDnCount() {
		return citizenDnCount;
	}

	public void setCitizenDnCount(Long citizenDnCount) {
		this.citizenDnCount = citizenDnCount;
	}

	public Double getBenefitAmtTotal() {
		return benefitAmtTotal;
	}

	public void setBenefitAmtTotal(Double benefitAmtTotal) {
		this.benefitAmtTotal = benefitAmtTotal;
	}
	
	


}
