package com.wi.pb.forum.infrastructure;

import com.wi.pb.forum.infrastructure.service.CrudService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface SimpleFacade<E extends Identifiable<ID>, DTO, ID>{

    CrudService<E, DTO, ID> getService();

    default List<DTO> findAllDto(){
        return getService().findAllDto();
    }

    default Optional<DTO> findDtoById(ID id){
        return getService().findDtoById(id);
    }

    default DTO save(DTO dto) {
        return getService().save(dto);
    }

    default void deleteById(ID id) {
        getService().deleteById(id);
    }

}
