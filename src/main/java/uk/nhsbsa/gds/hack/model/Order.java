package uk.nhsbsa.gds.hack.model;

import static uk.nhsbsa.gds.hack.model.OrderStatus.PENDING;

import java.math.BigDecimal;

public class 	Order {

	/**
	 * Unique ID for this order.
	 */
    private String id;

    /**
     * Key to GOV.UK payment.
     */
    private String paymentId;
    
    /**
     * You can buy anything you want - just describe it.
     */
    private String description;
    
	/**
     * You can say how much you want to pay.
     */
    private BigDecimal cost;
    
    private OrderStatus status = PENDING;

	public Order() {
	}

    public Order(String description, BigDecimal cost) {
		super();
		this.description = description;
		this.cost = cost;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
}
