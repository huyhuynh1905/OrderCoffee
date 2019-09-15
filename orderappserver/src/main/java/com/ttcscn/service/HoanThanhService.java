package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.HoanThanh;
import com.ttcscn.repository.HoanThanhDAO;

@Service("hoanthanhService")
@Transactional
public class HoanThanhService {

	@Autowired
	HoanThanhDAO hoanthanhDao;
	
	public List<HoanThanh> getAllList(){
		return hoanthanhDao.getAll();
	}
	
	public String saveHt(HoanThanh ht) {
		return hoanthanhDao.save(ht);
	}
	
	public String updateHt(HoanThanh ht) {
		return hoanthanhDao.update(ht);
	}
	
	public String deleteHt(HoanThanh ht) {
		return hoanthanhDao.delete(ht);
	}
	
	public HoanThanh findHtById(String maDaOrder) {
		return hoanthanhDao.findById(maDaOrder);
	}
}
