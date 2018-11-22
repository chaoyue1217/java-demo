package com.spring.mapper;

import java.io.IOException;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.HeroAttrsEntity;

@Repository("heroAttrsMapper")
public interface HeroAttrsMapper {
	public int AddAttrs(HeroAttrsEntity heroAttrs) throws IOException;
	public int DeleteAttrs(@Param("id") int id) throws IOException;
	public int UpdateAttrs(HeroAttrsEntity heroAttrs) throws IOException;
	public HeroAttrsEntity GetAttrs(@Param("heroId") int heroId) throws IOException;
}
