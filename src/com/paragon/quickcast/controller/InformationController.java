package com.paragon.quickcast.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.Etp_Info;
import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;
import com.paragon.quickcast.serviceImpl.EtpinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.HunterinfoServiceImpl;
import com.paragon.quickcast.serviceImpl.SeekerinfoServiceImpl;

@Controller
@RequestMapping("/info.do")
public class InformationController extends MultiActionController{ 
	
	@Resource 
	private SeekerinfoServiceImpl seekerinfoImpl = new SeekerinfoServiceImpl();
	@Resource 
	private HunterinfoServiceImpl hunterinfoImpl = new HunterinfoServiceImpl();
	@Resource
	private EtpinfoServiceImpl etpinfoImpl = new EtpinfoServiceImpl();
	@Resource
    private Encoding encoding;
	
	
	
	
	//Seeker_Info
	@RequestMapping(params="method=seekerinfo_insert")
	public @ResponseBody String seekerinfo_insert(@RequestBody Seeker_Info seeker_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			seekerinfoImpl.insert(seeker_info);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);
								
		return result_temp;	
	}
	
    @RequestMapping(params="method=seekerinfo_update")
    public @ResponseBody String seekerinfo_update(Seeker_Info seeker_info){
    	seekerinfoImpl.update(seeker_info);
    	return "seekerinfo_update OK";
    }
    
    @RequestMapping(params="method=seekerinfo_delete")
    public @ResponseBody String seekerinfo_delete(Seeker_Info seeker_info){
    	seekerinfoImpl.delete(seeker_info);
    	return "seekerinfo_delete OK";
    }
    
    @RequestMapping(params="method=queryBySeekerInfoId")
    public @ResponseBody String queryBySeekerInfoId(@RequestBody Seeker_Info seeker_info){
    	Seeker_Info seeker_infoInstance = seekerinfoImpl.queryBySeekerInfoId(seeker_info.getInfo_id());
    	System.out.println("-----------seekerinfo_id:"+seeker_info.getInfo_id()+"---------");
		System.out.println("-----------user_id:"+seeker_info.getUser_id()+"---------");
    	
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
    	data.put("seekerinfo_id", seeker_infoInstance.getInfo_id());
    	data.put("user_id", seeker_infoInstance.getUser_id());
    	data.put("age", seeker_infoInstance.getAge());
    	data.put("edu_type", seeker_infoInstance.getEdu_type());
    	data.put("end_time", seeker_infoInstance.getEnd_time());
    	data.put("etp_industry", seeker_infoInstance.getEtp_industry());
    	data.put("etp_name", seeker_infoInstance.getEtp_name());
    	data.put("gender", seeker_infoInstance.getGender());
    	data.put("highest_edu", seeker_infoInstance.getHighest_edu());
    	data.put("job_status", seeker_infoInstance.getJob_status());
    	data.put("marital_status", seeker_infoInstance.getMarital_status());
    	data.put("mobile", seeker_infoInstance.getMobile());
    	data.put("seeker_photo", seeker_infoInstance.getSeeker_photo());
    	data.put("seeker_profession", seeker_infoInstance.getSeeker_profession());
    	data.put("self_intro", seeker_infoInstance.getSelf_intro());
    	data.put("start_time", seeker_infoInstance.getStart_time());
    	data.put("tech_direction", seeker_infoInstance.getTech_direction());
    	data.put("work_place", seeker_infoInstance.getWork_place());
    	
    	String result = "{\"seeker_info\":"+ json_result +"}";
		String result_temp = "error";
		try {
			result_temp = URLEncoder.encode(result, "utf-8");
			result_temp = URLEncoder.encode(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
									
		return result_temp;
    }
    
    @RequestMapping(params="method=queryBySeekerUserId")
    public @ResponseBody String queryBySeekerUserId(@RequestBody Seeker_Info seeker_info){
    	Seeker_Info seeker_infoInstance = seekerinfoImpl.queryBySeekerUserId(seeker_info.getUser_id());
    	System.out.println("-----------seekerinfo_id:"+seeker_infoInstance.getInfo_id()+"---------");
		System.out.println("-----------user_id:"+seeker_infoInstance.getUser_id()+"---------");

    	Map data = new HashMap();
		JSONArray json_result = new JSONArray();
    	data.put("seekerinfo_id", seeker_infoInstance.getInfo_id());
    	data.put("user_id", seeker_infoInstance.getUser_id());
    	data.put("age", seeker_infoInstance.getAge());
    	data.put("edu_type", seeker_infoInstance.getEdu_type());
    	data.put("end_time", seeker_infoInstance.getEnd_time());
    	data.put("etp_industry", seeker_infoInstance.getEtp_industry());
    	data.put("etp_name", seeker_infoInstance.getEtp_name());
    	data.put("gender", seeker_infoInstance.getGender());
    	data.put("highest_edu", seeker_infoInstance.getHighest_edu());
    	data.put("job_status", seeker_infoInstance.getJob_status());
    	data.put("marital_status", seeker_infoInstance.getMarital_status());
    	data.put("mobile", seeker_infoInstance.getMobile());
    	data.put("seeker_photo", seeker_infoInstance.getSeeker_photo());
    	data.put("seeker_profession", seeker_infoInstance.getSeeker_profession());
    	data.put("self_intro", seeker_infoInstance.getSelf_intro());
    	data.put("start_time", seeker_infoInstance.getStart_time());
    	data.put("tech_direction", seeker_infoInstance.getTech_direction());
    	data.put("work_place", seeker_infoInstance.getWork_place());
    	
    	String result = "{\"seeker_info\":"+ json_result +"}";
		String result_temp = "error";
		try {
			result_temp = URLEncoder.encode(result, "utf-8");
			result_temp = URLEncoder.encode(result, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
									
		return result_temp;
    }
    
    @RequestMapping(params="method=deleteBySeekerInfoId")
	public @ResponseBody String deleteBySeekerInfoId(int info_id){
    	seekerinfoImpl.deleteByInfoId(info_id);
	    return "deleteBySeekerInfoId OK";
	    }
	
	@RequestMapping(params="method=deleteBySeekerUserId")
	public @ResponseBody String deleteBySeekerUserId(int user_id){
		seekerinfoImpl.deleteByUserId(user_id);
	    return "deleteBySeekerUserId OK";
	    }
	
	
    //Hunter_Info
	@RequestMapping(params="method=hunterinfo_insert")
	public @ResponseBody String hunterinfo_insert(Hunter_Info hunter_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			hunterinfoImpl.insert(hunter_info);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			temp = "fail";
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);			
			e.printStackTrace();			
			e.printStackTrace();
			return result_temp;
		}
		String result_temp = tojosn.tojson(temp);
		result_temp = encoding.encoding(result_temp);
								
		return result_temp;	
	}
	
    @RequestMapping(params="method=hunterinfo_update")
    public @ResponseBody String hunterinfo_update(Hunter_Info hunter_info){
    	hunterinfoImpl.update(hunter_info);
    	return "hunterinfo_update OK";
    }
    
    @RequestMapping(params="method=hunterinfo_delete")
    public @ResponseBody String hunterinfo_delete(Hunter_Info hunter_info){
    	hunterinfoImpl.delete(hunter_info);
    	return "hunterinfo_delete OK";
    }
    
    @RequestMapping(params="method=queryByHunterInfoId")
    public @ResponseBody String queryByHunterInfoId(int info_id){
    	Hunter_Info hunter_info = hunterinfoImpl.queryByHunterInfoId(info_id);
    	System.out.println("-----------hunterinfo_id:"+hunter_info.getInfo_id()+"---------");
		System.out.println("-----------user_id:"+hunter_info.getUser_id()+"---------");
    	return "queryByHunterInfoId OK";
    }
    
    @RequestMapping(params="method=queryByHunterUserId")
    public @ResponseBody String queryByHunterUserId(int user_id){
    	Hunter_Info hunter_info = hunterinfoImpl.queryByHunterUserId(user_id);
    	System.out.println("-----------hunterinfo_id:"+hunter_info.getInfo_id()+"---------");
    	System.out.println("-----------user_id:"+hunter_info.getUser_id()+"---------");
    	return "queryByHunterUserId OK";
    }
    
    @RequestMapping(params="method=deleteByHunterInfoId")
	public @ResponseBody String deleteByHunterInfoId(int info_id){
    	hunterinfoImpl.deleteByInfoId(info_id);
	    return "deleteByHunterInfoId OK";
	    }
	
	@RequestMapping(params="method=deleteByHunterUserId")
	public @ResponseBody String deleteByHunterUserId(int user_id){
		hunterinfoImpl.deleteByUserId(user_id);
	    return "deleteByHunterUserId OK";
	    }
	
	//Etp_Info
		@RequestMapping(params="method=etpinfo_insert")
		public @ResponseBody String etpinfo_insert(@RequestBody Etp_Info etp_info){
			
			String temp = "success";
			ToJson tojosn = new ToJson();	
			try {
				etpinfoImpl.insert(etp_info);
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				temp = "fail";
				String result_temp = tojosn.tojson(temp);
				result_temp = encoding.encoding(result_temp);			
				e.printStackTrace();			
				e.printStackTrace();
				return result_temp;
			}
			String result_temp = tojosn.tojson(temp);
			result_temp = encoding.encoding(result_temp);
									
			return result_temp;	
			
		}
		
	    @RequestMapping(params="method=etpinfo_update")
	    public @ResponseBody String etpinfo_update(@RequestBody Etp_Info etp_info){
	    	etpinfoImpl.update(etp_info);
	    	return "etpinfo_update OK";
	    }
	    
	    @RequestMapping(params="method=etpinfo_delete")
	    public @ResponseBody String etpinfo_delete(Etp_Info etp_info){
	    	etpinfoImpl.delete(etp_info);
	    	return "etpinfo_delete OK";
	    }
	    
	    @RequestMapping(params="method=queryByEtpInfoId")
	    public @ResponseBody String queryByEtpInfoId(int info_id){
	    	Etp_Info etp_info = etpinfoImpl.queryByEtpInfoId(info_id);
	    	System.out.println("-----------etpinfo_id:"+etp_info.getInfo_id()+"---------");
			System.out.println("-----------user_id:"+etp_info.getUser_id()+"---------");
	    	return "queryByEtpInfoId OK";
	    }
	    
	    @RequestMapping(params="method=queryByEtpUserId")
	    public @ResponseBody String queryByEtpUserId(int user_id){
	    	Etp_Info etp_info = etpinfoImpl.queryByEtpUserId(user_id);
	    	System.out.println("-----------etpinfo_id:"+etp_info.getInfo_id()+"---------");
			System.out.println("-----------user_id:"+etp_info.getUser_id()+"---------");
	    	return "queryByEtpUserId OK";
	    }
	    
	    @RequestMapping(params="method=deleteByEtpInfoId")
		public @ResponseBody String deleteByEtpInfoId(int info_id){
	    	etpinfoImpl.deleteByInfoId(info_id);
		    return "deleteByEtpInfoId OK";
		    }
		
		@RequestMapping(params="method=deleteByEtpUserId")
		public @ResponseBody String deleteByEtpUserId(int user_id){
			etpinfoImpl.deleteByUserId(user_id);
		    return "deleteByEtpUserId OK";
		    }

		
		
		
		
		
		public SeekerinfoServiceImpl getSeekerinfoImpl() {
			return seekerinfoImpl;
		}

		public void setSeekerinfoImpl(SeekerinfoServiceImpl seekerinfoImpl) {
			this.seekerinfoImpl = seekerinfoImpl;
		}

		public HunterinfoServiceImpl getHunterinfoImpl() {
			return hunterinfoImpl;
		}

		public void setHunterinfoImpl(HunterinfoServiceImpl hunterinfoImpl) {
			this.hunterinfoImpl = hunterinfoImpl;
		}

		public EtpinfoServiceImpl getEtpinfoImpl() {
			return etpinfoImpl;
		}

		public void setEtpinfoImpl(EtpinfoServiceImpl etpinfoImpl) {
			this.etpinfoImpl = etpinfoImpl;
		}
		
		public Encoding getEncoding() {
			return encoding;
		}


		public void setEncoding(Encoding encoding) {
			this.encoding = encoding;
		}	
}

