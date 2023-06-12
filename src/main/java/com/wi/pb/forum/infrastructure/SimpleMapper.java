package com.wi.pb.forum.infrastructure;

import org.mapstruct.Context;

import java.util.List;
import java.util.Set;

public interface SimpleMapper<E, DTO> {
    E toEntity(DTO dto);

    List<E> toEntity(List<DTO> dto);

    Set<E> toEntity(Set<DTO> dto);

    DTO toDto(E entity);

    List<DTO> toDto(List<E> entity);

    Set<DTO> toDto(Set<E> entity);
}
