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
	
	@RequestMapping(params="method=imp_resume_insert")	
	public String imp_resume_insert(Personal_Rsm personal_rsm){
		//通过实体类来封装jsp页面
		System.out.println("简历编号：--------"+personal_rsm.getRsm_id());
		System.out.println("用户编号：--------"+personal_rsm.getUser_id());
		System.out.println("编辑时间：--------"+personal_rsm.getEdit_time());
		System.out.println("谁看过我的简历：--------"+personal_rsm.getRead_status());
		resumeservice.insert(personal_rsm);
		return "index";
	}
	
	@RequestMapping(params="method=imp_resume_update")
	public String imp_resume_update(Personal_Rsm personal_rsm){
		
		resumeservice.update(personal_rsm);
		System.out.println("简历编号：--------"+personal_rsm.getRsm_id());
		System.out.println("用户编号：--------"+personal_rsm.getUser_id());
		System.out.println("编辑时间：--------"+personal_rsm.getEdit_time());
		System.out.println("谁看过我的简历：--------"+personal_rsm.getRead_status());
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_resume_queryByUserId")
	public String imp_resume_queryByUserId(int user_id){
		
		Personal_Rsm personal_rsm = resumeservice.queryByUserId(user_id);
		System.out.println("简历编号：--------"+personal_rsm.getRsm_id());
		System.out.println("用户编号：--------"+personal_rsm.getUser_id());
		System.out.println("编辑时间：--------"+personal_rsm.getEdit_time());
		System.out.println("谁看过我的简历：--------"+personal_rsm.getRead_status());
		return "index";
		
	}
	

	@RequestMapping(params="method=imp_resume_queryByRsmId")
	public String imp_resume_queryByRsmId(int rsm_id){
		
		Personal_Rsm personal_rsm = resumeservice.queryByRsmId(rsm_id);
		System.out.println("简历编号：--------"+personal_rsm.getRsm_id());
		System.out.println("用户编号：--------"+personal_rsm.getUser_id());
		System.out.println("编辑时间：--------"+personal_rsm.getEdit_time());
		System.out.println("谁看过我的简历：--------"+personal_rsm.getRead_status());
		return "index";
		
	}
	
	
	@RequestMapping(params="method=imp_resume_delete")
	public String imp_resume_delete(Personal_Rsm personal_rsm){
		
		resumeservice.delete(personal_rsm);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_resume_deleteByUserId")
	public String imp_resume_deleteUserId(int user_id){
		
		resumeservice.deleteByUserId(user_id);
		return "index";
		
	}
	
	
	@RequestMapping(params="method=imp_resume_deleteByRsmId")
	public String imp_resume_deleteRsmId(int rsm_id){
		
		resumeservice.deleteByUserId(rsm_id);
		return "index";
		
	}
	
	
	public ResumeService getResumeservice() {
		return resumeservice;
	}

	public void setResumeservice(ResumeService resumeservice) {
		this.resumeservice = resumeservice;
	}

}
