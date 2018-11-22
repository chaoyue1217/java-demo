package com.spring.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.entity.HerosEntity;

public interface HerosService {
	public int HerosAdd(HerosEntity heros) throws IOException;
	public int HerosUpdate(HerosEntity heros) throws IOException;
	public int HerosDelete(@Param("id") int id) throws IOException;
	public HerosEntity HerosGet(@Param("id") int id) throws IOException;
	public List<HerosEntity> HerosGetAll(@Param("categoryId") int categoryId) throws IOException;
}
