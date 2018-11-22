package com.spring.mapper;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.spring.entity.HerosEntity;

@Repository("herosMapper")
public interface HerosMapper {
	public int HerosAdd(HerosEntity heros) throws IOException;
	public int HerosUpdate(HerosEntity heros) throws IOException;
	public int HerosDelete(@Param("id") int id) throws IOException;
	public HerosEntity HerosGet(@Param("id") int id) throws IOException;
	public List<HerosEntity> HerosGetAll(@Param("categoryId") int categoryId) throws IOException;
}
