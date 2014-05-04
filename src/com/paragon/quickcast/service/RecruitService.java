package com.paragon.quickcast.service;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Recruit_Info;

@Service
public interface RecruitService {

	public boolean insert(Recruit_Info recruit_info);
	public boolean delete(int info_id);
	public Recruit_Info queryByInfoId(int info_id);
	public boolean update(Recruit_Info recruit_info);
}
