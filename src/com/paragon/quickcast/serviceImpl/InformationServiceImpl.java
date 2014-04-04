package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Hunter_InfoDAO;
import com.paragon.quickcast.dao.Seeker_InfoDAO;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {
	@Resource
	private Seeker_InfoDAO seeker_infodao; 
	@Resource
	private Hunter_InfoDAO hunter_infodao;
	public boolean insert(Seeker_Info seeker_info){
		//System.out.println("UserServiceImpl.add()");
		seeker_infodao.insert(seeker_info);
		return true;
	}
	
	//继承删除方法
	public boolean delete(int info_id){
		seeker_infodao.delete(info_id);
		return true;
	}
	
	public boolean delete1(String email){
		seeker_infodao.deleteEmail(email);
		return true;
	}
	//继承更新方法
	public boolean update(Seeker_Info seeker_info){
		seeker_infodao.update(seeker_info);
		return true;
	}
	
	public boolean insert(Hunter_Info hunter_info){
		return false;
	}
	
	public boolean insert(Etp_Info etp_info){
		return false;
	}
	public Seeker_InfoDAO getSeeker_infodao() {
		return seeker_infodao;
	}
	public void setSeeker_infodao(Seeker_InfoDAO seeker_infodao) {
		this.seeker_infodao = seeker_infodao;
	}

	public Hunter_InfoDAO getHunter_infodao() {
		return hunter_infodao;
	}

	public void setHunter_infodao(Hunter_InfoDAO hunter_infodao) {
		this.hunter_infodao = hunter_infodao;
	}
	

}
