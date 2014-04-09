package com.paragon.quickcast.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.dao.Recruit_InfoDAO;
import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.service.RecruitService;

@Service
public class RecruitinfoServiceImpl implements RecruitService {

	@Resource
	private Recruit_InfoDAO recruit_infodao;
	public boolean delete(int info_id) {
		recruit_infodao.delete(info_id);
		return false;
	}

	public boolean insert(Recruit_Info recruit_info) {
		recruit_infodao.insert(recruit_info);
		return false;
	}

	public boolean queryByInfoId(int info_id) {
		
		return false;
	}

	public boolean update(Recruit_Info recruit_info) {
	    recruit_infodao.update(recruit_info);
		return false;
	}

}
