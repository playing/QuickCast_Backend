package com.paragon.quickcast.service;

import org.springframework.stereotype.Service;
import com.paragon.quickcast.entity.Personal_Rsm;

@Service
public interface ResumeService {
	
	public boolean insert(Personal_Rsm personal_rsm);
	
	public void update(Personal_Rsm personal_rsm);
	

}
