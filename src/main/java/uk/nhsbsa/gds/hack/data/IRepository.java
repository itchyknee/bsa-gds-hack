package uk.nhsbsa.gds.hack.data;

import java.util.List;

public interface IRepository <T, I> {

	List<T> findAll();

	T find(I id);

	void add(T entity);

	
}
