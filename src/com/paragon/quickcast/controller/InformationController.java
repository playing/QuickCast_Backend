package com.paragon.quickcast.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.service.InformationService;

@Controller
@RequestMapping("/seekerinfo.do")
public class InformationController extends MultiActionController{

	//求职者个人信息管理模块
	@Resource
	private InformationService informationservice;
	@RequestMapping(params="method=seekerinfo_insert")
	public String seekerinfo_insert(Seeker_Info seeker_info){
		
		informationservice.insert(seeker_info);
		return "seekerinfo_object";
	}
	
    @RequestMapping(params="method=seekerinfo_delete")
    public String seekerinfo_delete(int info_id){
    	informationservice.delete(info_id);
    	return "index";
    }
    
    @RequestMapping(params="method=seekerinfo_update")
    public String seekerinfo_update(Seeker_Info seeker_info){
    	informationservice.update(seeker_info);
     return "index";
    }
    
    //猎头个人信息管理模块
    @RequestMapping(params="method=hunterinfo_insert")
    public String hunterinfo_insert(Hunter_Info hunter_info){
    	informationservice.add(hunter_info);
    	return "seekerinfo_object";
    }
    
	public InformationService getInformationservice() {
		return informationservice;
	}    

	public void setInformationservice(InformationService informationservice) {
		this.informationservice = informationservice;
	}

}

