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
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.Message;
import com.paragon.quickcast.service.MessageService;

@Controller
@RequestMapping("/message.do")
public class MessageController {
	
	@Resource
	private MessageService messageservice;
	
	@RequestMapping(params="method=imp_message_insert")
	public String imp_news_insert(Message message){
		
		messageservice.insert(message);
		System.out.println("-----------msg_id:"+message.getMsg_id()+"---------");
		System.out.println("-----------dispatch_id:"+message.getDispatch_id()+"---------");
		System.out.println("-----------receive_id:"+message.getReceive_id()+"---------");
		System.out.println("-----------dispatch_time:"+message.getDispatch_time()+"---------");
		System.out.println("-----------status:"+message.getStatus()+"---------");
		System.out.println("-----------content:"+message.getContent()+"---------");
		System.out.println("-----------title:"+message.getTitle()+"---------");
			
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_update")
	public String imp_message_update(Message message){
		
		messageservice.update(message);
		System.out.println("-----------msg_id:"+message.getMsg_id()+"---------");
		System.out.println("-----------dispatch_id:"+message.getDispatch_id()+"---------");
		System.out.println("-----------receive_id:"+message.getReceive_id()+"---------");
		System.out.println("-----------dispatch_time:"+message.getDispatch_time()+"---------");
		System.out.println("-----------status:"+message.getStatus()+"---------");
		System.out.println("-----------content:"+message.getContent()+"---------");
		System.out.println("-----------title:"+message.getTitle()+"---------");
			
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_queryByDispatchId")
	public String imp_message_queryByDispatchId(Message message){
		
		List l = messageservice.queryByDispatchId(message.getDispatch_id());
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Message messageInstance = (Message)iter.next();
			System.out.println("-----------msg_id:"+messageInstance.getMsg_id()+"---------");
			System.out.println("-----------dispatch_id:"+messageInstance.getDispatch_id()+"---------");
			System.out.println("-----------receive_id:"+messageInstance.getReceive_id()+"---------");
			System.out.println("-----------dispatch_time:"+messageInstance.getDispatch_time()+"---------");
			System.out.println("-----------status:"+messageInstance.getStatus()+"---------");
			System.out.println("-----------content:"+messageInstance.getContent()+"---------");
			System.out.println("-----------title:"+messageInstance.getTitle()+"---------");
		}
					
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_queryByReceiveId")
	public @ResponseBody String imp_message_queryByReceiveId(Message message){
		
		List l = messageservice.queryByReceiveId(message.getReceive_id());
		Iterator iter = l.iterator();
		Map data = new HashMap();
		JSONArray json_result = new JSONArray();
		
		while(iter.hasNext()){
			Message messageInstance = (Message)iter.next();
			data.put("msg_id", messageInstance.getMsg_id());
			data.put("dispatch_id", messageInstance.getDispatch_id());
			data.put("receive_id", messageInstance.getReceive_id());
			data.put("dispatch_time", messageInstance.getDispatch_time());
			data.put("status", messageInstance.getStatus());
			data.put("title", messageInstance.getTitle());
			data.put("content", messageInstance.getContent());
			json_result.put(data);
			System.out.println("-----------msg_id:"+messageInstance.getMsg_id()+"---------");
			System.out.println("-----------dispatch_id:"+messageInstance.getDispatch_id()+"---------");
			System.out.println("-----------receive_id:"+messageInstance.getReceive_id()+"---------");
			System.out.println("-----------dispatch_time:"+messageInstance.getDispatch_time()+"---------");
			System.out.println("-----------status:"+messageInstance.getStatus()+"---------");
			System.out.println("-----------content:"+messageInstance.getContent()+"---------");
			System.out.println("-----------title:"+messageInstance.getTitle()+"---------");
		
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
	
	@RequestMapping(params="method=imp_message_queryByMsgId")
	public String imp_message_queryByMsgId(Message message){
		
		Message messageInstance = messageservice.queryByMsgId(message.getMsg_id());
		System.out.println("-----------msg_id:"+messageInstance.getMsg_id()+"---------");
		System.out.println("-----------dispatch_id:"+messageInstance.getDispatch_id()+"---------");
		System.out.println("-----------receive_id:"+messageInstance.getReceive_id()+"---------");
		System.out.println("-----------dispatch_time:"+messageInstance.getDispatch_time()+"---------");
		System.out.println("-----------status:"+messageInstance.getStatus()+"---------");
		System.out.println("-----------content:"+messageInstance.getContent()+"---------");
		System.out.println("-----------title:"+messageInstance.getTitle()+"---------");
		
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_delete")
	public String imp_message_delete(Message message){
		
		messageservice.delete(message);
					
		return "index";
	}
	
	@RequestMapping(params="method=imp_message_deleteByMsgId")
	public String imp_message_deleteByMsgId(Message message){
		
		messageservice.deleteByMsgId(message.getMsg_id());
					
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_deleteByDispatchId")
	public String imp_message_deleteByDispatchId(Message message){
		
		messageservice.deleteByDispatchId(message.getDispatch_id());
					
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_deleteByReceiveId")
	public String imp_message_deleteByReceiveId(Message message){
		
		messageservice.deleteByReceiveId(message.getReceive_id());
					
		return "index";
	}


	public MessageService getMessageservice() {
		return messageservice;
	}


	public void setMessageservice(MessageService messageservice) {
		this.messageservice = messageservice;
	}
	

	

}
