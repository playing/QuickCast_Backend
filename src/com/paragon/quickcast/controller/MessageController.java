package com.paragon.quickcast.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paragon.quickcast.dao.MessageDAO;
import com.paragon.quickcast.entity.Message;

@Controller
@RequestMapping("/message.do")
public class MessageController {
	
	@Resource
	private MessageDAO messagedao;
	
	@RequestMapping(params="method=imp_message_insert")
	public String imp_news_insert(Message message){
		
		messagedao.insert(message);
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
		
		messagedao.update(message);
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
		
		List l = messagedao.queryByDispatchId(message.getDispatch_id());
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
	public String imp_message_queryByReceiveId(Message message){
		
		List l = messagedao.queryByReceiveId(message.getReceive_id());
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
	
	@RequestMapping(params="method=imp_message_queryByMsgId")
	public String imp_message_queryByMsgId(Message message){
		
		Message messageInstance = messagedao.queryByMsgId(message.getMsg_id());
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
		
		messagedao.delete(message);
					
		return "index";
	}
	
	@RequestMapping(params="method=imp_message_deleteByMsgId")
	public String imp_message_deleteByMsgId(Message message){
		
		messagedao.deleteByMsgId(message.getMsg_id());
					
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_deleteByDispatchId")
	public String imp_message_deleteByDispatchId(Message message){
		
		messagedao.deleteByDispatchId(message.getDispatch_id());
					
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_message_deleteByReceiveId")
	public String imp_message_deleteByReceiveId(Message message){
		
		messagedao.deleteByReceiveId(message.getReceive_id());
					
		return "index";
	}
	

	public MessageDAO getMessagedao() {
		return messagedao;
	}

	public void setMessagedao(MessageDAO messagedao) {
		this.messagedao = messagedao;
	}
	

}
