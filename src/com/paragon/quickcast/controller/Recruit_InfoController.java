package com.paragon.quickcast.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.serviceImpl.RecruitinfoServiceImpl;

@Controller
@RequestMapping("/recruitinfo.do")
public class Recruit_InfoController {

	@Resource
    private RecruitinfoServiceImpl recruitserviceimpl = new RecruitinfoServiceImpl();
	
	@RequestMapping(params="method=recruitinfo_insert")
	public String recruitinfo_insert(Recruit_Info recruit_info){
		recruitserviceimpl.insert(recruit_info);
		return "recruit_info";
	}
	
	@RequestMapping(params="method=recruitinfo_delete")
	public String recruitinfo_delete(int info_id){
		recruitserviceimpl.delete(info_id);
		return "recruit_info";
	}
	
	@RequestMapping(params="method=recruitinfo_update")
	public String recruitinfo_update(Recruit_Info recruit_info){
		recruitserviceimpl.update(recruit_info);
		return "recruit_info";
	}
}
