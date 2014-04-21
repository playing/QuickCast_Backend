package com.paragon.quickcast.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Index;

/**
 * 
 * ���������������ʵ�ֺ���Ȧ
 * ����partner_id���ҵ��������¼partner_id�ĺ��ѣ�ͳ��ÿ�����ѳ��ֵĴ������ҳ���������ǰ20λ
 * �㷨ʵ�֣�hash_map�Ժ���_id��Ϊkeyֵ��valueֵ�Ǻ���_id���ֵĴ���
 * 
 * **/
@Entity
public class Friend_List {
	
	private int rlts_id;
	
	private int partner_id;
	private int self_id;
	
	private String reason;
	private String status;
  
	private FriendsGroup friendsgroup;
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="deptid")
	public FriendsGroup getFriendsgroup() {
		return friendsgroup;
	}
		
	public void setFriendsgroup(FriendsGroup friendsgroup) {
		this.friendsgroup = friendsgroup;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRlts_id() {
		return rlts_id;
	}

	public void setRlts_id(int rlts_id) {
		this.rlts_id = rlts_id;
	}

	@Column(nullable=false)
	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	@Column(nullable=false)
	@Index(name="SelfID_Index")
	public int getSelf_id() {
		return self_id;
	}

	public void setSelf_id(int self_id) {
		this.self_id = self_id;
	}

	@Column(nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
