package uk.nhsbsa.gds.hack.model;



public class Order {

	/**
	 * Unique ID for this order.
	 */
    private String id;

    /**
     * Key to GOV.UK payment.
     */
    private Payment payment;
    
    /**
     * You can buy anything you want - just describe it.
     */
    private String description;
    
	/**
     * You can say how much you want to pay
     */
    private Integer cost;

	public Order() {
	}

    public Order(String description, Integer cost) {
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

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getPaymentStatus() {
		return payment.getStatus().toString();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", payment=" + payment + ", description=" + description + ", cost=" + cost + "]";
	}

}
