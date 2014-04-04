package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Hunter_InfoDAO;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.service.InformationService;

@Service
public class HunterinfoServiceImpl implements InformationService {

	@Resource 
	private Hunter_InfoDAO hunter_infodao;
	public boolean delete(int info_id) {
		hunter_infodao.delete(info_id);
		return false;
	}


	public boolean insert(Hunter_Info hunter_info) {
		hunter_infodao.insert(hunter_info);
		return false;
	}

	public boolean update(Seeker_Info seeker_info) {
		return false;
	}

	public boolean delete1(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insert(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean insert(Etp_Info etp_info){
		// TODO Auto-generated method stub
		return false;
	}
	public Hunter_InfoDAO getHunter_infodao() {
		return hunter_infodao;
	}

	public void setHunter_infodao(Hunter_InfoDAO hunter_infodao) {
		this.hunter_infodao = hunter_infodao;
	}

}
