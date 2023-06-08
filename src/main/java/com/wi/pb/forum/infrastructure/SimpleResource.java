package com.wi.pb.forum.infrastructure;

import com.wi.pb.forum.infrastructure.service.CrudService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface SimpleResource<E extends Identifiable<ID>,DTO extends Identifiable<ID>, ID> {


    CrudService<E, DTO, ID> getService();

    @GetMapping
    default List<DTO> getAllEntities(){
        return getService().findAllDto();
    }

    @GetMapping("/{id}")
    default Optional<DTO> getEntityById(@PathVariable ID id){
        return getService().findDtoById(id);
    }

    @PostMapping
    default DTO addEntity(@Valid @RequestBody DTO dto) {
        return getService().save(dto);
    }

    @DeleteMapping("/{id}")
    default void deleteEntityById(@PathVariable ID id) {
        getService().deleteById(id);
    }
 }
