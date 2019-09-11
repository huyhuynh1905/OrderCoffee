package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.HoanThanh;
import com.ttcscn.repository.HoanThanhDAO;

@Service("hoanthanhService")
public class HoanThanhService {

	@Autowired
	HoanThanhDAO hoanthanhDao;
	
	@Transactional
	public List<HoanThanh> getAllList(){
		return hoanthanhDao.getAll();
	}
	
	@Transactional
	public void saveHt(HoanThanh ht) {
		hoanthanhDao.save(ht);
	}
	
	@Transactional
	public void updateHt(HoanThanh ht) {
		hoanthanhDao.update(ht);
	}
	
	@Transactional
	public void deleteHt(HoanThanh ht) {
		hoanthanhDao.delete(ht);
	}
	
	@Transactional
	public HoanThanh findHtById(String maOrder) {
		return hoanthanhDao.findById(maOrder);
	}
}
