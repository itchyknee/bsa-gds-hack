package uk.nhsbsa.gds.hack.model;

/**
 * Encapsulates a state transition for an order status
 * @author pattu
 *
 */
public class OrderStatusTransition {

	private String id;
	private String target;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	@Override
	public String toString() {
		return "OrderStatusTransition [id=" + id + ", target=" + target + "]";
	}
}
