package com.paragon.quickcast.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.serviceImpl.EtpinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.HunterinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.InformationServiceImpl;

@Controller
@RequestMapping("/seekerinfo.do")
public class InformationController extends MultiActionController{
	//@Resource
	//private InformationService informationservice; 
	
	@Resource 
	private InformationServiceImpl seekerinfoImpl = new InformationServiceImpl();
	@Resource 
	private HunterinfoServiceImpl hunterinfoImpl = new HunterinfoServiceImpl();
	@Resource
	private EtpinfoServiceImpl etpinfoservice = new EtpinfoServiceImpl();
	
	//求职者个人信息管理模块
	@RequestMapping(params="method=seekerinfo_insert")
	public String seekerinfo_insert(@RequestBody Seeker_Info seeker_info){
		seekerinfoImpl.insert(seeker_info);
		return "seekerinfo_object";
	}
	
    @RequestMapping(params="method=seekerinfo_delete")
    public String seekerinfo_delete(@RequestBody int info_id){
    	seekerinfoImpl.delete(info_id);
    	return "index";
    }
    
    @RequestMapping(params="method=seekerinfo_update")
    public String seekerinfo_update(@RequestBody Seeker_Info seeker_info){
    	seekerinfoImpl.update(seeker_info);
     return "index";
    }
    
    @RequestMapping(params="method=seekeremail_delete")
    public String seekeremail_delete(@RequestBody String email){
    	seekerinfoImpl.delete1(email);
    	return "index";
    }
    
  //猎头个人信息管理模块
    @RequestMapping(params="method=hunterinfo_insert")
    public String hunterinfo_insert(@RequestBody Hunter_Info hunter_info){
    	hunterinfoImpl.insert(hunter_info);
    	return "seekerinfo_object";
    }
    
    @RequestMapping(params="method=hunterinfodelete")
    public String hunterinfodelete(@RequestBody int info_id){
    	hunterinfoImpl.delete(info_id);
    	return "index";
    }

    //企业信息管理模块
    @RequestMapping(params="method=editetpinfo")
    public String editetpinfo(@RequestBody Etp_Info etp_info){
    	etpinfoservice.insert(etp_info);
    	return "index";
    }
    
    @RequestMapping(params="method=deleteetpinfo")
    public String deleteetpinfo(@RequestBody int info_id){
    	etpinfoservice.delete(info_id);
    	return "index";
    }
    @RequestMapping(params="method=updateetpinfo")
    public String updateetpinfo(@RequestBody Etp_Info etp_info){
    	//etpinfoservice.update(seeker_info);
    	return "index";
    }
    
	public InformationServiceImpl getSeekerinfoImpl() {
		return seekerinfoImpl;
	}

	public void setSeekerinfoImpl(InformationServiceImpl seekerinfoImpl) {
		this.seekerinfoImpl = seekerinfoImpl;
	}

	public HunterinfoServiceImpl getHunterinfoImpl() {
		return hunterinfoImpl;
	}

	public void setHunterinfoImpl(HunterinfoServiceImpl hunterinfoImpl) {
		this.hunterinfoImpl = hunterinfoImpl;
	}

}

