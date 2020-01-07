package com.jdbc.mantenimiento.dao;

import java.util.ArrayList;

public interface Dao<T> {

	public void create(T t);
	public T read(int id);
	public void update(T t);
	public void delete(int id);
	public ArrayList<T> findAll();
	public T createAndRead(T t);
	public T updateAndRead(T t);
}


