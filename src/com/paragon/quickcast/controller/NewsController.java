package com.paragon.quickcast.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.entity.News;
import com.paragon.quickcast.entity.User_Reg;
import com.paragon.quickcast.service.Friend_ListService;
import com.paragon.quickcast.service.NewsService;
import com.paragon.quickcast.service.UserService;

@Controller
@RequestMapping("/news.do")
public class NewsController {
	
	@Resource
	private NewsService newsservice;
	@Resource
	private UserService userservice;
	@Resource 
	private Friend_ListService friend_listservice;
	@Resource
    private Encoding encoding;
	
	@RequestMapping(params="method=imp_news_insert")
	public @ResponseBody String imp_news_insert(@RequestBody News news){
		//通过实体类来封装jsp页面
		
		
		System.out.println("-----------news_id:"+news.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+news.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+news.getPub_time()+"---------");
		System.out.println("-----------content:"+news.getContent()+"---------");

		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			newsservice.insert(news);
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
	
	
	@RequestMapping(params="method=imp_news_update")
	public @ResponseBody String imp_news_update(@RequestBody News news){
		//通过实体类来封装jsp页面
		
		newsservice.update(news);
		System.out.println("-----------news_id:"+news.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+news.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+news.getPub_time()+"---------");
		System.out.println("-----------content:"+news.getContent()+"---------");

		return "index";
	}
	
	@RequestMapping(params="method=imp_news_queryByPubId")
	public @ResponseBody String imp_news_queryByPubId(@RequestBody News news){
		//通过实体类来封装jsp页面		
		User_Reg user_reg = userservice.queryByUserId(news.getPub_id());
		List l = newsservice.queryByPubId(news.getPub_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		while(iter.hasNext()){
		News newsInstance = (News)iter.next();
		data.put("news_id", newsInstance.getNews_id());
		data.put("pub_id", newsInstance.getPub_id());
		data.put("pub_name",user_reg.getCn_tname());
		data.put("pub_time", newsInstance.getPub_time());
		data.put("content", newsInstance.getContent());
		data.put("pub_type", newsInstance.getPub_type());
		json_result.put(data);
		System.out.println("-----------news_id:"+newsInstance.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+newsInstance.getPub_id()+"---------");
		System.out.println("-----------pub_name:"+user_reg.getCn_tname()+"---------");
		System.out.println("-----------pub_time:"+newsInstance.getPub_time()+"---------");
		System.out.println("-----------content:"+newsInstance.getContent()+"---------");
		System.out.println("-----------type:"+newsInstance.getPub_type()+"---------");
		}

		String result = "{\"news\":"+ json_result +"}";
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
	
	@RequestMapping(params="method=imp_news_display")
	public @ResponseBody String imp_news_display(@RequestBody News news){
		
		List friend_list = friend_listservice.queryBySelfId(news.getPub_id());
		User_Reg user_reg = userservice.queryByUserId(news.getPub_id());
		List l = newsservice.queryByPubId(news.getPub_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		while(iter.hasNext()){
		News newsInstance = (News)iter.next();
		data.put("news_id", newsInstance.getNews_id());
		data.put("pub_id", newsInstance.getPub_id());
		data.put("pub_name",user_reg.getCn_tname());
		data.put("pub_time", newsInstance.getPub_time());
		data.put("content", newsInstance.getContent());
		data.put("pub_type", newsInstance.getPub_type());
		json_result.put(data);
		System.out.println("-----------news_id:"+newsInstance.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+newsInstance.getPub_id()+"---------");
		System.out.println("-----------pub_name:"+user_reg.getCn_tname()+"---------");
		System.out.println("-----------pub_time:"+newsInstance.getPub_time()+"---------");
		System.out.println("-----------content:"+newsInstance.getContent()+"---------");
		System.out.println("-----------type:"+newsInstance.getPub_type()+"---------");
		}

		String result = "{\"news\":"+ json_result +"}";
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
	
	
	
	@RequestMapping(params="method=imp_news_queryByNewsId")
	public @ResponseBody String imp_news_queryByNewId(@RequestBody News news){
		//通过实体类来封装jsp页面
		
		News newsInstance = newsservice.queryByNewsId(news.getNews_id());
		System.out.println("-----------news_id:"+newsInstance.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+newsInstance.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+newsInstance.getPub_time()+"---------");
		System.out.println("-----------content:"+newsInstance.getContent()+"---------");

		return "index";
	}
	
	
	@RequestMapping(params="method=imp_news_delete")
	public @ResponseBody String imp_news_delete(@RequestBody News news){
		//通过实体类来封装jsp页面
		
		newsservice.delete(news);
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_news_deleteByPubId")
	public @ResponseBody String imp_news_deleteByPubId(@RequestBody News news){
		
		newsservice.deleteByPubId(news.getPub_id());
		return "index";
		
	}
	
	
	@RequestMapping(params="method=imp_news_deleteByNewsId")
	public @ResponseBody String imp_news_deleteByNewsId(@RequestBody News news){
		
		String temp = "success";
		ToJson tojosn = new ToJson();	
		try {
			newsservice.deleteByNewsId(news.getNews_id());
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

	

	public NewsService getNewsservice() {
		return newsservice;
	}

	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
	}


	public Encoding getEncoding() {
		return encoding;
	}


	public void setEncoding(Encoding encoding) {
		this.encoding = encoding;
	}


	public UserService getUserservice() {
		return userservice;
	}


	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	

}
