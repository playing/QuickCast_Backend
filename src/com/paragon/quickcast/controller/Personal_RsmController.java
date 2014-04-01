package com.paragon.quickcast.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paragon.quickcast.entity.Personal_Rsm;
import com.paragon.quickcast.service.ResumeService;

@Controller
@RequestMapping("/personal_rsm.do")
public class Personal_RsmController {
	
	@Resource
	private ResumeService resumeservice;
	
	@RequestMapping(params="method=personal_rsm")	
	public String imp_resume_insert(Personal_Rsm personal_rsm){
		//通过实体类来封装jsp页面
		System.out.println("简历编号：--------"+personal_rsm.getRsm_id());
		System.out.println("用户编号：--------"+personal_rsm.getUser_id());
		System.out.println("编辑时间：--------"+personal_rsm.getEdit_time());
		System.out.println("谁看过我的简历：--------"+personal_rsm.getRead_status());
		resumeservice.insert(personal_rsm);
		return "index";
	}

	public ResumeService getResumeservice() {
		return resumeservice;
	}

	public void setResumeservice(ResumeService resumeservice) {
		this.resumeservice = resumeservice;
	}

}
