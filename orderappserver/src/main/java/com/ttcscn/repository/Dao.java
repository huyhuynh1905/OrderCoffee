package com.ttcscn.repository;

import java.util.List;

import javax.transaction.Transactional;

public interface Dao<T> {

	List<T> getAll();
 
    String save(T t);
 
    String update(T t);
 
    String delete(T t);
    
    T findById(String id);
    
}
