package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Ban;
import com.ttcscn.repository.BanDAO;

@Service("banService")
public class BanService {

	@Autowired
	BanDAO banDao;
	
	public List<Ban> getAllList(){
		return banDao.getAll();
	}
	
	@Transactional
	public void saveBan(Ban ban) {
		banDao.save(ban);
	}
	
	@Transactional
	public void updateBan(Ban ban) {
		banDao.update(ban);
	}
	
	@Transactional
	public void deleteBan(Ban ban) {
		banDao.delete(ban);
	}
	
	@Transactional
	public Ban findBanById(String maBan) {
		return banDao.findById(maBan);
	}
}
