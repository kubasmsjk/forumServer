package com.wi.pb.forum.category.controllers;

import com.wi.pb.forum.category.CategoryFacade;
import com.wi.pb.forum.category.dto.CategoryDTO;
import com.wi.pb.forum.infrastructure.SimpleController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryController implements SimpleController<CategoryDTO, Long> {

    private final CategoryFacade categoryFacade;

    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @Override
    public CategoryFacade getFacade() {
        return categoryFacade;
    }
}
