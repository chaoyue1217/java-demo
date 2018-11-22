package com.spring.service.impl;

import java.io.IOException;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.entity.HeroAttrsEntity;
import com.spring.mapper.HeroAttrsMapper;
import com.spring.service.HeroAttrsService;

@Service
@Transactional
public class HeroAttrsServiceImpl implements HeroAttrsService{
	
	@Resource
	private HeroAttrsMapper heroAttrsMapper;
	
	@Override
	public int AddAttrs(HeroAttrsEntity heroAttrs) throws IOException {
		return heroAttrsMapper.AddAttrs(heroAttrs);
	}

	@Override
	public int DeleteAttrs(int id) throws IOException {
		// TODO Auto-generated method stub
		return heroAttrsMapper.DeleteAttrs(id);
	}

	@Override
	public int UpdateAttrs(HeroAttrsEntity heroAttrs) throws IOException {
		// TODO Auto-generated method stub
		return heroAttrsMapper.UpdateAttrs(heroAttrs);
	}

	@Override
	public HeroAttrsEntity GetAttrs(int heroId) throws IOException {
		// TODO Auto-generated method stub
		return heroAttrsMapper.GetAttrs(heroId);
	}

}
