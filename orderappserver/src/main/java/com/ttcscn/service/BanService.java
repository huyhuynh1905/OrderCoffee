package com.ttcscn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ttcscn.entity.Ban;
import com.ttcscn.repository.BanDAO;

@Service("banService")
@Transactional
public class BanService {

	@Autowired
	BanDAO banDao;
	
	public List<Ban> getAllList(){
		return banDao.getAll();
	}
	
	public String saveBan(Ban ban) {
		return banDao.save(ban);
	}
	
	public String updateBan(Ban ban) {
		return banDao.update(ban);
	}
	
	public String deleteBan(Ban ban) {
		return banDao.delete(ban);
	}
	
	@Transactional
	public Ban findBanById(String maBan) {
		return banDao.findById(maBan);
	}
}
