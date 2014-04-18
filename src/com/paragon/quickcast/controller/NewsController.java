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
import org.springframework.web.bind.annotation.RequestMapping;

import com.paragon.quickcast.dao.ToJson;
import com.paragon.quickcast.entity.News;
import com.paragon.quickcast.service.NewsService;

@Controller
@RequestMapping("/news.do")
public class NewsController {
	
	@Resource
	private NewsService newsservice;
	
	@RequestMapping(params="method=imp_news_insert")
	public String imp_news_insert(News news){
		//通过实体类来封装jsp页面
		
		newsservice.insert(news);
		System.out.println("-----------news_id:"+news.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+news.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+news.getPub_time()+"---------");
		System.out.println("-----------content:"+news.getContent()+"---------");

		String temp = "success";
		ToJson tojosn = new ToJson();		
		String result_temp = tojosn.tojson(temp);
		try {
			result_temp = URLEncoder.encode(temp, "utf-8");
			result_temp = URLEncoder.encode(temp, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}								
		return result_temp;	
	}
	
	
	@RequestMapping(params="method=imp_news_update")
	public String imp_news_update(News news){
		//通过实体类来封装jsp页面
		
		newsservice.update(news);
		System.out.println("-----------news_id:"+news.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+news.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+news.getPub_time()+"---------");
		System.out.println("-----------content:"+news.getContent()+"---------");

		return "index";
	}
	
	@RequestMapping(params="method=imp_news_queryByPubId")
	public String imp_news_queryByPubId(News news){
		//通过实体类来封装jsp页面
		
		List l = newsservice.queryByPubId(news.getPub_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		while(iter.hasNext()){
		News newsInstance = (News)iter.next();
		data.put("news_id", newsInstance.getNews_id());
		data.put("pub_id", newsInstance.getPub_id());
		data.put("pub_time", newsInstance.getPub_time());
		data.put("content", newsInstance.getContent());
		data.put("type", newsInstance.getType());
		json_result.put(data);
		System.out.println("-----------news_id:"+newsInstance.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+newsInstance.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+newsInstance.getPub_time()+"---------");
		System.out.println("-----------content:"+newsInstance.getContent()+"---------");
		System.out.println("-----------type:"+newsInstance.getType()+"---------");
		}

		String result = "{\"message\":"+ json_result +"}";
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
	public String imp_news_queryByNewId(News news){
		//通过实体类来封装jsp页面
		
		News newsInstance = newsservice.queryByNewsId(news.getNews_id());
		System.out.println("-----------news_id:"+newsInstance.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+newsInstance.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+newsInstance.getPub_time()+"---------");
		System.out.println("-----------content:"+newsInstance.getContent()+"---------");

		return "index";
	}
	
	
	@RequestMapping(params="method=imp_news_delete")
	public String imp_news_delete(News news){
		//通过实体类来封装jsp页面
		
		newsservice.delete(news);
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_news_deleteByPubId")
	public String imp_news_deleteByPubId(News news){
		
		newsservice.deleteByPubId(news.getPub_id());
		return "index";
		
	}
	
	
	@RequestMapping(params="method=imp_news_deleteByNewsId")
	public String imp_news_deleteByNewsId(News news){
		
		newsservice.deleteByNewsId(news.getNews_id());
		String temp = "success";
		ToJson tojosn = new ToJson();		
		String result_temp = tojosn.tojson(temp);
		try {
			result_temp = URLEncoder.encode(temp, "utf-8");
			result_temp = URLEncoder.encode(temp, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}								
		return result_temp;	
		
	}

	

	public NewsService getNewsservice() {
		return newsservice;
	}

	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
	}

}
