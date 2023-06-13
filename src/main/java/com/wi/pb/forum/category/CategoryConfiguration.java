package com.wi.pb.forum.category;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CategoryConfiguration {

    @Bean
    public CategoryFacade categoryFacade(CategoryRepository categoryRepository) {
        return new CategoryFacade(
                new CategoryService(categoryRepository, Mappers.getMapper(CategoryMapper.class))
        );
    }
}
