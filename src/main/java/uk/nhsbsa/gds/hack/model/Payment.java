package uk.nhsbsa.gds.hack.model;

import static uk.nhsbsa.gds.hack.model.PaymentStatus.PENDING;



public class Payment {

    private String id;
    
    private PaymentStatus status = PENDING;

    public Payment() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

}
