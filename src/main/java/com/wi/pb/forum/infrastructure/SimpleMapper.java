package com.wi.pb.forum.infrastructure;

import org.mapstruct.Context;

import java.util.List;
import java.util.Set;

public interface SimpleMapper<E, DTO> {
    E toEntity(DTO dto, @Context CycleAvoidingMappingContext context);

    List<E> toEntity(List<DTO> dto, @Context CycleAvoidingMappingContext context);

    Set<E> toEntity(Set<DTO> dto, @Context CycleAvoidingMappingContext context);

    DTO toDto(E entity, @Context CycleAvoidingMappingContext context);

    List<DTO> toDto(List<E> entity, @Context CycleAvoidingMappingContext context);

    Set<DTO> toDto(Set<E> entity, @Context CycleAvoidingMappingContext context);
}
