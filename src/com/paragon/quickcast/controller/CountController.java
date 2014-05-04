package com.paragon.quickcast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.Count_Rsmhandle;
import com.paragon.quickcast.entity.Count_User;
import com.paragon.quickcast.entity.Rsm_Deliver;
import com.paragon.quickcast.service.CountService;

@Controller
@RequestMapping("/count.do")
public class CountController {
	
	@Resource
	private CountService countservice;
	@Resource
    private Encoding encoding;
	
	//统计每类用户的人数
	//1 求职者
	//2 猎头
	//3 企业
	//4 未选类别
	@RequestMapping(params="method=imp_count_queryBycountUserId")
	public @ResponseBody String imp_count_queryBycountUserId(){
		
		Count_User count_user = countservice.queryBycountUserId(1);
		int[] count = new int[4];
		count[0] = count_user.getSeeker_num();
		count[1] = count_user.getHunter_num();
		count[2] = count_user.getEtp_num();
		count[3] = count_user.getUser_num();
		count[3] = count[3]-count[2]-count[1]-count[0];
		for(int i = 0;i < 4;i++){
			System.out.println(count[i]);
		}
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("count0", count[0]);
		data.put("count1", count[1]);
		data.put("count2", count[2]);
		data.put("count3", count[3]);
		json_result.put(data);
		
		String result = "{\"count\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}
	
	@RequestMapping(params="method=imp_count_queryByCountRsmhandleEtpId")
	public @ResponseBody String imp_count_queryByCountRsmhandleEtpId(Rsm_Deliver rsm_deliver){
		
		Count_Rsmhandle count_rsmhandle = countservice.queryByCountRsmhandleEtpId(rsm_deliver.getEtp_id());
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		data.put("handle_num",count_rsmhandle.getHandle_num());
		data.put("receive_num", count_rsmhandle.getReceive_num());
		json_result.put(data);
		
		String result = "{\"count\":"+ json_result +"}";
		String result_temp = encoding.encoding(result);		
		return result_temp;	
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

	public CountService getCountservice() {
		return countservice;
	}

	public void setCountservice(CountService countservice) {
		this.countservice = countservice;
	}

}
