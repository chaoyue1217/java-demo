package com.spring.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.entity.CategoryEntity;
import com.spring.mapper.CategoryMapper;
import com.spring.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Resource
	private CategoryMapper mapper;
		
	@Override
	public int CategoryUpdate(CategoryEntity category) throws IOException {
		return mapper.CategoryUpdate(category);
	}

	@Override
	public int CategoryDelete(int id) throws IOException {
		return mapper.CategoryDelete(id);
	}

	@Override
	public CategoryEntity CategoryGet(int id) throws IOException {
		return mapper.CategoryGet(id);
	}

	@Override
	public List<CategoryEntity> CategoryGetAll() throws IOException {
		return mapper.CategoryGetAll();
	}
	
}
