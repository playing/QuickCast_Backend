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

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/count.do")
public class CountController {
	
	@Resource
	private UserService userservice;
	@Resource
    private Encoding encoding;
	
	//统计每类用户的人数
	//1 求职者
	//2 猎头
	//3 企业
	//4 未选类别
	@RequestMapping(params="method=imp_count_queryByUserType")
	public @ResponseBody String imp_count_queryByUserType(){

		int[] count = new int[4];
		count[0] = userservice.countByUserType("1");
		count[1] = userservice.countByUserType("2");
		count[2] = userservice.countByUserType("3");
		count[3] = userservice.countByUserType("");
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

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public Encoding getEncoding() {
		return encoding;
	}

	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}

}
