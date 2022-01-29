package com.sample.demo.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.sample.demo.model.Question;

public abstract class Repository<T> {

	
	AtomicLong atomicLong = new AtomicLong(0);
	//Map<String, Obj> db
	Map<Long,T> db = new ConcurrentHashMap<Long, T>();;
	

	
	public T getById(Long id) {
		return db.get(id);
	}

	
	
	public T add( T t) {
		Long id = atomicLong.incrementAndGet();
		return db.put(id, t);
	}
	
	public boolean remove(Long id, T t) {
		return db.remove(id, t);
	}
}
