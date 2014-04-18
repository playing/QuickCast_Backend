package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Seeker_InfoDAO;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.service.InformationService;

@Service
public class SeekerinfoServiceImpl implements InformationService {

	@Resource
	private Seeker_InfoDAO seeker_infodao;
	
	//Seeker_InfoImpl
	public boolean insert(Seeker_Info seeker_info) {
		seeker_infodao.insert(seeker_info);
		return true;
	}

	public boolean update(Seeker_Info seeker_info) {
		seeker_infodao.update(seeker_info);
		return true;
	}

	public boolean delete(Seeker_Info seeker_info) {
		seeker_infodao.delete(seeker_info);
		return true;
	}

	public Seeker_Info queryBySeekerInfoId(int info_id) {
		return seeker_infodao.queryBySeekerInfoId(info_id);
	}

	public Seeker_Info queryBySeekerUserId(int user_id) {
		return seeker_infodao.queryBySeekerUserId(user_id);
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

	//Etp_Info
	public boolean insert(Etp_Info etp_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Etp_Info etp_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Etp_Info etp_info) {
		// TODO Auto-generated method stub
		return false;
	}

	public Etp_Info queryByEtpInfoId(int info_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Etp_Info queryByEtpUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	//Õ®”√
	public void deleteByUserId(int user_id) {
		seeker_infodao.deleteByUserId(user_id);
	}

	public void deleteByInfoId(int info_id) {
		seeker_infodao.deleteByInfoId(info_id);
	}

}
