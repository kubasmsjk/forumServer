package com.wi.pb.forum.infrastructure.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface DtoToEntityMapper<E, DTO>  {

    E mapToEntity(DTO dto);

    default List<E> mapToEntity(List<DTO> dtos) {
        return Stream.ofNullable(dtos).flatMap(Collection::stream).map(this::mapToEntity).collect(Collectors.toList());
    }
}
