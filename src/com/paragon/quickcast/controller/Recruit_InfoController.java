package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.Recruit_Info;
import com.paragon.quickcast.serviceImpl.RecruitinfoServiceImpl;


//’–∆∏–≈œ¢
@Controller
@RequestMapping("/recruitinfo.do")
public class Recruit_InfoController {

	@Resource
    private RecruitinfoServiceImpl recruitserviceimpl;
	@Resource 
	private Encoding encoding;
	
	@RequestMapping(params="method=recruitinfo_insert")
	public @ResponseBody String recruitinfo_insert(@RequestBody Recruit_Info recruit_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			recruitserviceimpl.insert(recruit_info);
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
	
	@RequestMapping(params="method=recruitinfo_delete")
	public @ResponseBody String recruitinfo_delete(@RequestBody Recruit_Info recruit_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			recruitserviceimpl.delete(recruit_info.getInfo_id());
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
	
	@RequestMapping(params="method=recruitinfo_update")
	public @ResponseBody String recruitinfo_update(@RequestBody Recruit_Info recruit_info){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			recruitserviceimpl.update(recruit_info);
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
	
	@RequestMapping(params="method=recruitinfo_queryByInfoId")
	public @ResponseBody String recruitinfo_queryByInfoId(@RequestBody Recruit_Info recruit_info){
		
		Recruit_Info info = recruitserviceimpl.queryByInfoId(recruit_info.getInfo_id());
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
    	data.put("info_id", info.getInfo_id());
    	data.put("info_id", info.getIssue_time());
    	data.put("info_id", info.getRecruit_detail());
    	data.put("info_id", info.getRecruit_job());
    	data.put("info_id", info.getRecruit_time());
    	data.put("info_id", info.getSalary());
    	data.put("info_id", info.getRecruit_num());
    	data.put("info_id", info.getUser_id());
    	String result = "{\"recruit_info\":"+ json_result +"}";
		String result_temp = "error";
		result_temp = encoding.encoding(result_temp);						
		return result_temp;	
	}

	public RecruitinfoServiceImpl getRecruitserviceimpl() {
		return recruitserviceimpl;
	}

	public void setRecruitserviceimpl(RecruitinfoServiceImpl recruitserviceimpl) {
		this.recruitserviceimpl = recruitserviceimpl;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}
	
	
}
