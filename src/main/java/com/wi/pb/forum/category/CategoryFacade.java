package com.wi.pb.forum.category;

import com.wi.pb.forum.category.dto.CategoryDTO;
import com.wi.pb.forum.infrastructure.SimpleFacade;

public class CategoryFacade implements SimpleFacade<CategoryDTO, Long> {

    private final CategoryService categoryService;

    public CategoryFacade(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryService getService() {
        return categoryService;
    }
}
