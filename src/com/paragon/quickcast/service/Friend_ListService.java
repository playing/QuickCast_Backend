package com.paragon.quickcast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Friend_List;

@Service
public interface Friend_ListService {
	
	public boolean insert(Friend_List friend_list);
	
	public void update(Friend_List friend_list);
	
	public List queryByPartnerId(int partner_id);
	
	public List queryBySelfId(int self_id);
	
	public Friend_List queryByRltsId(int rlts_id);
	
	public void delete(Friend_List friend_list);
	
	public void deleteByRltsId(int rlts_id);
	
	public void deleteByPartnerId(int partner_id);
	
	public void deleteBySelfId(int self_id);
	
	

}
