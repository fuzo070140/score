package com.score.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.score.persistence.MainDAO;

@Service
public class MainServiceImpl implements MainService{
	
	@Inject
	MainDAO dao;

	@Override
	public int select() throws Exception {
		return dao. select();
	}

}
