package com.wi.pb.forum.infrastructure.service;

import com.wi.pb.forum.infrastructure.Identifiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SearchQueryService<E extends Identifiable<ID>, DTO, ID> extends EntityToDtoMapper<E, DTO> {

    JpaRepository<E, ID> getRepo();

    @Transactional(readOnly = true)
    default long count() {
        return getRepo().count();
    }

    @Transactional(readOnly = true)
    default Optional<DTO> findDtoById(ID id) {
        return findById(id).map(e -> mapToDto(e));
    }
    @Transactional(readOnly = true)
    default Optional<E> findById(ID id) {
        return getRepo().findById(id);
    }

    @Transactional(readOnly = true)
    default E findByIdOrThrow(ID id) {
        return getRepo().findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Entity not found by id %d", id)));
    }

    default DTO findDtoByIdOrThrow(ID id) {
        return mapToDto(findByIdOrThrow(id));
    }

    @Transactional(readOnly = true)
    default List<DTO> findAllDtoById(Collection<ID> ids) {
        return mapToDto(getRepo().findAllById(ids));
    }

    @Transactional(readOnly = true)
    default List<E> findAllById(Collection<ID> ids) {
        return getRepo().findAllById(ids);
    }

    @Transactional(readOnly = true)
    default List<E> findAll() {
        return getRepo().findAll();
    }

    @Transactional(readOnly = true)
    default List<DTO> findAllDto() {
        return mapToDto(getRepo().findAll());
    }
}
