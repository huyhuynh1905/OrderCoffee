package com.ttcscn.repository;

import java.util.List;

import javax.transaction.Transactional;

public interface Dao<T> {

	List<T> getAll();
 
    void save(T t);
 
    void update(T t);
 
    void delete(T t);
    
    T findById(String id);
    
}
