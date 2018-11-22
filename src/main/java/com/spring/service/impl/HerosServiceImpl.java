package com.spring.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.entity.HerosEntity;
import com.spring.mapper.HerosMapper;
import com.spring.service.HerosService;

@Service
@Transactional
public class HerosServiceImpl implements HerosService{
	
	@Resource
	private HerosMapper herosMapper;
	
	@Override
	public int HerosAdd(HerosEntity heros) throws IOException {
		return herosMapper.HerosAdd(heros);
	}

	@Override
	public int HerosUpdate(HerosEntity heros) throws IOException {
		return herosMapper.HerosUpdate(heros);
	}

	@Override
	public int HerosDelete(int id) throws IOException {
		return herosMapper.HerosDelete(id);
	}

	@Override
	public HerosEntity HerosGet(int id) throws IOException {
		return herosMapper.HerosGet(id);
	}

	@Override
	public List<HerosEntity> HerosGetAll(int categoryId) throws IOException {
		return herosMapper.HerosGetAll(categoryId);
	}
	
}
