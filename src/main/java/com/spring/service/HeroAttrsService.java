package com.spring.service;

import java.io.IOException;

import org.apache.ibatis.annotations.Param;

import com.spring.entity.HeroAttrsEntity;

public interface HeroAttrsService {
	public int AddAttrs(HeroAttrsEntity heroAttrs) throws IOException;
	public int DeleteAttrs(@Param("id") int id) throws IOException;
	public int UpdateAttrs(HeroAttrsEntity heroAttrs) throws IOException;
	public HeroAttrsEntity GetAttrs(@Param("heroId") int heroId) throws IOException;
}
