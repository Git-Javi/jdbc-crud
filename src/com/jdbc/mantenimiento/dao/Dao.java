package com.jdbc.mantenimiento.dao;

import java.util.ArrayList;

public interface Dao<T> {

	public T create(T t);
	public T read(int id);
	public T update(T t);
	public void delete(int id);
	public ArrayList<T> findAll();
}


