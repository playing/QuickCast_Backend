package com.paragon.quickcast.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paragon.quickcast.entity.Rsm_Deliver;
import com.paragon.quickcast.service.DeliverService;

@Controller
@RequestMapping("/rsm_deliver.do")
public class Rsm_DeliverController {
	
	@Resource
	private DeliverService deliverservice;
	
	@RequestMapping(params="method=imp_deliver_insert")	
	public String imp_deliver_insert(Rsm_Deliver rsm_deliver){
		//通过实体类来封装jsp页面
		System.out.println("投递编号：--------"+rsm_deliver.getDeliver_id());
		System.out.println("简历编号：--------"+rsm_deliver.getRsm_id());
		System.out.println("企业编号：--------"+rsm_deliver.getEtp_id());
		System.out.println("猎头编号：--------"+rsm_deliver.getHunter_id());
		deliverservice.insert(rsm_deliver);
		return "index";
	}
	
	@RequestMapping(params="method=imp_deliver_update")	
	public String imp_deliver_update(Rsm_Deliver rsm_deliver){
		//通过实体类来封装jsp页面
		deliverservice.update(rsm_deliver);
		System.out.println("投递编号：--------"+rsm_deliver.getDeliver_id());
		System.out.println("简历编号：--------"+rsm_deliver.getRsm_id());
		System.out.println("企业编号：--------"+rsm_deliver.getEtp_id());
		System.out.println("猎头编号：--------"+rsm_deliver.getHunter_id());
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_deliver_queryByDeliverId")	
	public String imp_deliver_queryByDeliverId(int deliver_id){
		//通过实体类来封装jsp页面
		Rsm_Deliver rsm_deliver = deliverservice.queryByDeliverId(deliver_id);
		System.out.println("投递编号：--------"+rsm_deliver.getDeliver_id());
		System.out.println("简历编号：--------"+rsm_deliver.getRsm_id());
		System.out.println("企业编号：--------"+rsm_deliver.getEtp_id());
		System.out.println("猎头编号：--------"+rsm_deliver.getHunter_id());		
		return "index";
	}
	
	@RequestMapping(params="method=imp_deliver_queryByRsmId")	
	public String imp_deliver_queryByRsmId(int rsm_id){
		//通过实体类来封装jsp页面
		List l = deliverservice.queryByRsmId(rsm_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver rsm_deliver = (Rsm_Deliver)iter.next();
			System.out.println("投递编号：--------"+rsm_deliver.getDeliver_id());
			System.out.println("简历编号：--------"+rsm_deliver.getRsm_id());
			System.out.println("企业编号：--------"+rsm_deliver.getEtp_id());
			System.out.println("猎头编号：--------"+rsm_deliver.getHunter_id());
		}
		return "index";
	}
	
	@RequestMapping(params="method=imp_deliver_queryByEtpId")	
	public String imp_deliver_queryByEtpId(int etp_id){
		//通过实体类来封装jsp页面
		List l = deliverservice.queryByEtpId(etp_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver rsm_deliver = (Rsm_Deliver)iter.next();
			System.out.println("投递编号：--------"+rsm_deliver.getDeliver_id());
			System.out.println("简历编号：--------"+rsm_deliver.getRsm_id());
			System.out.println("企业编号：--------"+rsm_deliver.getEtp_id());
			System.out.println("猎头编号：--------"+rsm_deliver.getHunter_id());
		}
		return "index";
	}
	
	@RequestMapping(params="method=imp_deliver_queryByHunterId")	
	public String imp_deliver_queryByHunterId(int hunter_id){
		//通过实体类来封装jsp页面
		List l = deliverservice.queryByHunterId(hunter_id);
		Iterator iter = l.iterator();
		while(iter.hasNext()){
			Rsm_Deliver rsm_deliver = (Rsm_Deliver)iter.next();
			System.out.println("投递编号：--------"+rsm_deliver.getDeliver_id());
			System.out.println("简历编号：--------"+rsm_deliver.getRsm_id());
			System.out.println("企业编号：--------"+rsm_deliver.getEtp_id());
			System.out.println("猎头编号：--------"+rsm_deliver.getHunter_id());
		}
		return "index";
	}
	
	
	@RequestMapping(params="method=imp_deliver_delete")
	public String imp_deliver_delete(Rsm_Deliver rsm_deliver){
		
		deliverservice.delete(rsm_deliver);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_deliver_deleteByDeliverId")
	public String imp_deliver_deleteByDeliverId(int deliver_id){
		
		deliverservice.deleteByDeliverId(deliver_id);
		return "index";
		
	}
	
	@RequestMapping(params="method=imp_deliver_deleteByRsmId")
	public String imp_deliver_deleteByRsmId(int rsm_id){
		
		deliverservice.deleteByRsmId(rsm_id);
		return "index";
		
	}
	
	

	public DeliverService getDeliverservice() {
		return deliverservice;
	}

	public void setDeliverservice(DeliverService deliverservice) {
		this.deliverservice = deliverservice;
	}

}
