package com.wi.pb.forum.category;

import com.wi.pb.forum.category.dto.CategoryDTO;
import com.wi.pb.forum.infrastructure.service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;


public class CategoryService implements CrudService<Category, CategoryDTO, Long> {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public JpaRepository<Category, Long> getRepo() {
        return categoryRepository;
    }

    @Override
    public String getEntityName() {
        return Category.class.getName();
    }

    @Override
    public Category mapToEntity(CategoryDTO categoryDTO) {
        return categoryMapper.toEntity(categoryDTO);
    }

    @Override
    public CategoryDTO mapToDto(Category entity) {
        return categoryMapper.toDto(entity);
    }
}
