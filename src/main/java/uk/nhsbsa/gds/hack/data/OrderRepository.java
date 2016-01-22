package uk.nhsbsa.gds.hack.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import uk.nhsbsa.gds.hack.model.Order;

/**
 * Stub in-memory persistence.
 * @author pattu
 *
 */
@Repository
public class OrderRepository extends InMemoryRepository<Order, String> {

	Map<String, Order> orders = new LinkedHashMap<String, Order>();

	@Override
	protected String identify(Order entity) {
		if (entity.getId() == null) {
			entity.setId(UUID.randomUUID().toString());
		}
		return entity.getId();
	}
	
}
