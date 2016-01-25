package uk.nhsbsa.gds.hack.model;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

import static uk.nhsbsa.gds.hack.model.PaymentStatus.PENDING;



public class PaymentRequest extends ResourceSupport{

    private String id;

	private String returnURL;

	private int accountId;

	private String description;

	private String reference;

	private BigDecimal amount;

    public PaymentRequest() {
    }

	public String getReturnURL() {
		return returnURL;
	}

	public void setReturnURL(String returnURL) {
		this.returnURL = returnURL;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
