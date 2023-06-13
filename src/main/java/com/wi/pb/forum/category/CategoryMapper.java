package com.wi.pb.forum.category;

import com.wi.pb.forum.category.dto.CategoryDTO;
import com.wi.pb.forum.infrastructure.SimpleMapper;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper extends SimpleMapper<Category, CategoryDTO> {
}
