package com.wi.pb.forum.infrastructure;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface SimpleController<DTO extends Identifiable<ID>, ID> {


    SimpleFacade<DTO, ID> getFacade();

    @GetMapping
    default List<DTO> getAllEntities(){
        return getFacade().findAllDto();
    }

    @GetMapping("/{id}")
    default Optional<DTO> getEntityById(@PathVariable ID id){
        return getFacade().findDtoById(id);
    }

    @PostMapping
    default DTO addEntity(@Valid @RequestBody DTO dto) {
        return getFacade().save(dto);
    }

    @DeleteMapping("/{id}")
    default void deleteEntityById(@PathVariable ID id) {
        getFacade().deleteById(id);
    }
 }
