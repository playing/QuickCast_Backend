package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Etp_InfoDAO;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.service.InformationService;

@Service
public class EtpinfoServiceImpl implements InformationService {

	@Resource
	private Etp_InfoDAO etp_infodao;
	public boolean delete(int info_id) {
		etp_infodao.delete(info_id);
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

	public boolean insert(Hunter_Info hunter_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insert(Etp_Info etp_info) {
		etp_infodao.insert(etp_info);
		return false;
	}

	public boolean update(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public Etp_InfoDAO getEtp_infodao() {
		return etp_infodao;
	}

	public void setEtp_infodao(Etp_InfoDAO etp_infodao) {
		this.etp_infodao = etp_infodao;
	}

}
