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
	
	//Seeker_Info
	public boolean insert(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Seeker_Info seeker_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public Seeker_Info queryBySeekerInfoId(int info_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Seeker_Info queryBySeekerUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Hunter_Info
	public boolean insert(Hunter_Info hunter_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Hunter_Info hunter_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Hunter_Info hunter_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public Hunter_Info queryByHunterInfoId(int info_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Hunter_Info queryByHunterUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Etp_InfoImpl
	public boolean insert(Etp_Info etp_info) {
		etp_infodao.insert(etp_info);
		return true;
	}

	public boolean update(Etp_Info etp_info) {
		etp_infodao.update(etp_info);
		return true;
	}

	public boolean delete(Etp_Info etp_info) {
		etp_infodao.delete(etp_info);
		return true;
	}

	public Etp_Info queryByEtpInfoId(int info_id) {
		return etp_infodao.queryByEtpInfoId(info_id);
	}

	public Etp_Info queryByEtpUserId(int user_id) {
		return etp_infodao.queryByEtpUserId(user_id);
	}
	
	
	//ͨ��
	public void deleteByUserId(int user_id) {
		etp_infodao.deleteByUserId(user_id);
	}

	public void deleteByInfoId(int info_id) {
		etp_infodao.deleteByInfoId(info_id);
	}

}
