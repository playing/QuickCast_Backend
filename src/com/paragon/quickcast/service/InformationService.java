package com.paragon.quickcast.service;

import org.springframework.stereotype.Service;

import com.paragon.quickcast.entity.Hunter_Info;
import com.paragon.quickcast.entity.Seeker_Info;

@Service
public interface InformationService {
 
	public boolean insert(Seeker_Info seeker_info);
	public boolean delete(int info_id);
	public boolean update(Seeker_Info seeker_info);
	public boolean add(Hunter_Info hunter_info);
}
