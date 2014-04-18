package com.paragon.quickcast.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.paragon.quickcast.entity.Friend_List;
import com.paragon.quickcast.entity.FriendsGroup;
import com.paragon.quickcast.entity.User_Reg;

@Repository
public class Friend_ListDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Resource
	private User_RegDAO user_regdao;
	
	@Resource
	private FriendsGroupDAO friendsgroupdao;


	//插入用户新注册信息；
	//以Friend_List类为传递参数；
	public boolean insert(Friend_List friend_list){
		//FriendsGroup friendsgroup = new FriendsGroup();
		//User_Reg user_reg = null;
		String Tempgrouptype = user_regdao.queryByUserId(friend_list.getPartner_id()).getUser_type();
		System.out.println("----"+Tempgrouptype+"------");
		/*friendsgroup.setGrouptype(Tempgrouptype);
		hibernateTemplate.save(friendsgroup);
		friend_list.setFriendsgroup(friendsgroup);
		hibernateTemplate.save(friend_list);*/
		FriendsGroup friendsgroup = (FriendsGroup)friendsgroupdao.findFriendsGroup(Tempgrouptype);
		friend_list.setFriendsgroup(friendsgroup);
		hibernateTemplate.save(friend_list);
		return true;
		
	}
	
	
	public void update(Friend_List friend_list){
			
		hibernateTemplate.update(friend_list);
		
	}
	
	
	public List queryByPartnerId(int partner_id){
		
		String hql = "FROM Friend_List as friend_list WHERE friend_list.partner_id=?";
		List l = hibernateTemplate.find(hql, partner_id);
		return l;
		
	}
	
	
	public List queryBySelfId(int self_id){
			
		String hql = "FROM Friend_List as friend_list WHERE friend_list.self_id=?";
		List l = hibernateTemplate.find(hql, self_id);
		return l;
			
	}
	
		
	public Friend_List queryByRltsId(int rlts_id){
			
		return hibernateTemplate.get(Friend_List.class, rlts_id);
			
	}
		

	public void delete(Friend_List friend_list){
			
		hibernateTemplate.delete(friend_list);
			
	}
		
	public void deleteByRltsId(int rlts_id){
			
		hibernateTemplate.delete(hibernateTemplate.get(Friend_List.class, rlts_id));
			
	}
		
	public void deleteByPartnerId(int partner_id){
			
		String hql = "FROM Friend_List WHERE partner_id=?";
		List l = hibernateTemplate.find(hql, partner_id);
		hibernateTemplate.deleteAll(l);
			
	}
		
	public void deleteBySelfId(int self_id){
			
		String hql = "FROM Friend_List WHERE self_id=?";
		List l = hibernateTemplate.find(hql, self_id);
		hibernateTemplate.deleteAll(l);
	}
		
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public User_RegDAO getUser_regdao() {
		return user_regdao;
	}


	public void setUser_regdao(User_RegDAO user_regdao) {
		this.user_regdao = user_regdao;
	}


	public FriendsGroupDAO getFriendsgroupdao() {
		return friendsgroupdao;
	}


	public void setFriendsgroupdao(FriendsGroupDAO friendsgroupdao) {
		this.friendsgroupdao = friendsgroupdao;
	}
}
