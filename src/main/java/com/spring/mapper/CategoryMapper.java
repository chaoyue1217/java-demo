package com.spring.mapper;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.spring.entity.CategoryEntity;

@Repository("categoryMapper")
public interface CategoryMapper {
	public int CategoryUpdate(CategoryEntity category) throws IOException;
	public int CategoryDelete(@Param("id") int id) throws IOException;
	public CategoryEntity CategoryGet(@Param("id") int id) throws IOException;
	public List<CategoryEntity> CategoryGetAll() throws IOException;
}
