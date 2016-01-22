package uk.nhsbsa.gds.hack.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class InMemoryRepository <T, I> implements IRepository<T, I> {

	Map<I, T> entities = new LinkedHashMap<I, T>();
	
	@Override
	public List<T> findAll() {
		return new ArrayList<T>(entities.values());
	}

	@Override
	public void add(T entity) {
		entities.put(identify(entity), entity);
	}

	@Override
	public T find(I id) {
		return entities.get(id);
	}
	
	protected abstract I identify(T entity);
	
}
