package com.paragon.quickcast.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.service.Friend_ListService;

@Controller
@RequestMapping("/friend_list.do")
public class Friend_ListController {
	
	@Resource
	private Friend_ListService friend_listservice;
	
	@RequestMapping(params="method=imp_friend_list_insert")
	@ResponseBody
	public String imp_friend_list_insert(Friend_List friend_list){
		
		friend_listservice.insert(friend_list);
		System.out.println("-----------rlts_id:"+friend_list.getRlts_id()+"---------");
		System.out.println("-----------partner_id:"+friend_list.getPartner_id()+"---------");
		System.out.println("-----------self_id:"+friend_list.getSelf_id()+"---------");
		System.out.println("-----------status:"+friend_list.getStatus()+"---------");
		return "true";

	}
	
	
	
	
	@RequestMapping(params="method=imp_friend_list_update")
	public String imp_friend_list_update(Friend_List friend_list){
		
		friend_listservice.update(friend_list);
		System.out.println("-----------rlts_id:"+friend_list.getRlts_id()+"---------");
		System.out.println("-----------partner_id:"+friend_list.getPartner_id()+"---------");
		System.out.println("-----------self_id:"+friend_list.getSelf_id()+"---------");
		System.out.println("-----------status:"+friend_list.getStatus()+"---------");
			
		return "index";
	}
	
	@RequestMapping(params="method=imp_friend_list_queryByPartnerId")
	public String imp_friend_list_queryByPartnerId(Friend_List friend_list){
		
		List l = friend_listservice.queryByPartnerId(friend_list.getPartner_id());
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			
			Friend_List friend_listInstance = (Friend_List)iter.next();
		    System.out.println("-----------rlts_id:"+friend_listInstance.getRlts_id()+"---------");
		    System.out.println("-----------partner_id:"+friend_listInstance.getPartner_id()+"---------");
		    System.out.println("-----------self_id:"+friend_listInstance.getSelf_id()+"---------");
		    System.out.println("-----------status:"+friend_listInstance.getStatus()+"---------");
		
		}	
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_friend_list_queryBySelfId")
	public String imp_friend_list_queryBySelfId(Friend_List friend_list){
		
		List l = friend_listservice.queryBySelfId(friend_list.getSelf_id());
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			
			Friend_List friend_listInstance = (Friend_List)iter.next();
		    System.out.println("-----------rlts_id:"+friend_listInstance.getRlts_id()+"---------");
		    System.out.println("-----------partner_id:"+friend_listInstance.getPartner_id()+"---------");
		    System.out.println("-----------self_id:"+friend_listInstance.getSelf_id()+"---------");
		    System.out.println("-----------status:"+friend_listInstance.getStatus()+"---------");
		
		}	
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_friend_list_queryByRltsId")
	public String imp_friend_list_queryByRltsId(Friend_List friend_list){
		
		Friend_List friend_listInstance = friend_listservice.queryByRltsId(friend_list.getRlts_id());
			
		System.out.println("-----------rlts_id:"+friend_listInstance.getRlts_id()+"---------");
		System.out.println("-----------partner_id:"+friend_listInstance.getPartner_id()+"---------");
		System.out.println("-----------self_id:"+friend_listInstance.getSelf_id()+"---------");
		System.out.println("-----------status:"+friend_listInstance.getStatus()+"---------");
		
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_friend_list_delete")
	public String imp_friend_list_delete(Friend_List friend_list){
		
		friend_listservice.delete(friend_list);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_friend_list_deleteByRltsId")
	public String imp_friend_list_deleteByRltsId(Friend_List friend_list){
		
		friend_listservice.deleteByRltsId(friend_list.getRlts_id());
		return "index";
		
	}

	
	@RequestMapping(params="method=imp_friend_list_deleteByPartnerId")
	public String imp_friend_list_deleteByPartnerId(Friend_List friend_list){
		
		friend_listservice.deleteByPartnerId(friend_list.getPartner_id());
		return "index";
		
	}
	
	
	@RequestMapping(params="method=imp_friend_list_deleteBySelfId")
	public String imp_friend_list_deleteBySelfId(Friend_List friend_list){
		
		friend_listservice.deleteBySelfId(friend_list.getSelf_id());
		return "index";
		
	}
	
	
	

	public Friend_ListService getFriend_listservice() {
		return friend_listservice;
	}

	public void setFriend_listservice(Friend_ListService friend_listservice) {
		this.friend_listservice = friend_listservice;
	}

}
