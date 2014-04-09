package com.paragon.quickcast.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

		return "index";
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
		while(iter.hasNext()){
		News newsInstance = (News)iter.next();
		System.out.println("-----------news_id:"+newsInstance.getNews_id()+"---------");
		System.out.println("-----------pub_id:"+newsInstance.getPub_id()+"---------");
		System.out.println("-----------pub_time:"+newsInstance.getPub_time()+"---------");
		System.out.println("-----------content:"+newsInstance.getContent()+"---------");
		}

		return "index";
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
		return "index";
		
	}

	

	public NewsService getNewsservice() {
		return newsservice;
	}

	public void setNewsservice(NewsService newsservice) {
		this.newsservice = newsservice;
	}

}
