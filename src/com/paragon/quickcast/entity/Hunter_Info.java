package com.paragon.quickcast.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hunter_Info {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int info_id;
	
	@Column(name="user_id",unique=true,nullable=false)
	private int user_id;
	
	private String eng_name;
	
	@Column(name="cn_tname",unique=false,nullable=false)
	private String cn_tname;
	
	@Column(name="etp_name",unique=false,nullable=false)
	private String etp_name;
	
	@Column(name="gender",unique=false,nullable=false)
	private String gender;
	
	@Column(name="mobile",unique=false,nullable=false)
	private String mobile;
	
	@Column(name="work_phone",unique=false,nullable=false)
	private String work_phone;
	
	@Column(name="hunter_fax",unique=false,nullable=false)
	private String hunter_fax;
	
	@Column(name="work_email",unique=false,nullable=false)
	private String work_email;
	
	private String work_time;
	
	@Column(name="t_area",unique=false,nullable=false)
	private String t_area;
	
	@Column(name="work_city",nullable=false)
	private String work_city;
	
	private String self_intro;
	
	private String suc_case;
	
	private String etp_intro;
	
	private String business_card;
	
	@Column(name="certificate",unique=false,nullable=false)
	private String certificate;
	
	@Column(name="check_status",unique=false,nullable=false)
	private String check_status;
	

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getCn_tname() {
		return cn_tname;
	}

	public void setCn_tname(String cn_tname) {
		this.cn_tname = cn_tname;
	}

	public String getEtp_name() {
		return etp_name;
	}

	public void setEtp_name(String etp_name) {
		this.etp_name = etp_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork_phone() {
		return work_phone;
	}

	public void setWork_phone(String work_phone) {
		this.work_phone = work_phone;
	}

	public String getHunter_fax() {
		return hunter_fax;
	}

	public void setHunter_fax(String hunter_fax) {
		this.hunter_fax = hunter_fax;
	}

	public String getWork_email() {
		return work_email;
	}

	public void setWork_email(String work_email) {
		this.work_email = work_email;
	}

	public String getWork_time() {
		return work_time;
	}

	public void setWork_time(String work_time) {
		this.work_time = work_time;
	}

	public String getT_area() {
		return t_area;
	}

	public void setT_area(String t_area) {
		this.t_area = t_area;
	}

	public String getWork_city() {
		return work_city;
	}

	public void setWork_city(String work_city) {
		this.work_city = work_city;
	}

	public String getSelf_intro() {
		return self_intro;
	}

	public void setSelf_intro(String self_intro) {
		this.self_intro = self_intro;
	}

	public String getSuc_case() {
		return suc_case;
	}

	public void setSuc_case(String suc_case) {
		this.suc_case = suc_case;
	}

	public String getEtp_intro() {
		return etp_intro;
	}

	public void setEtp_intro(String etp_intro) {
		this.etp_intro = etp_intro;
	}

	public String getBusiness_card() {
		return business_card;
	}

	public void setBusiness_card(String business_card) {
		this.business_card = business_card;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCheck_status() {
		return check_status;
	}

	public void setCheck_status(String check_status) {
		this.check_status = check_status;
	}
		
}
