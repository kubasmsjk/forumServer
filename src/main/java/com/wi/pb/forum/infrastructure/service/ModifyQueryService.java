package com.wi.pb.forum.infrastructure.service;

import com.wi.pb.forum.infrastructure.Identifiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface ModifyQueryService <E extends Identifiable<ID>, DTO, ID>
        extends EntityToDtoMapper<E, DTO>, DtoToEntityMapper<E, DTO> {

    JpaRepository<E, ID> getRepo();

    @Transactional(rollbackFor = Throwable.class)
    default DTO saveAndFlush(DTO dto) {
        return save(dto, true);
    }

    @Transactional(rollbackFor = Throwable.class)
    default DTO save(DTO dto) {
        return save(dto, false);
    }

    default DTO save(DTO dto, boolean flush) {
        E entity = mapToEntity(dto);
        E savedEntity = save(entity);

        if (flush) {
            getRepo().flush();
        }
        return mapToDto(savedEntity);
    }

    @Transactional(rollbackFor = Throwable.class)
    default E saveAndFlush(E entity) {
        return getRepo().saveAndFlush(entity);
    }

    @Transactional(rollbackFor = Throwable.class)
    default E save(E entity) {
        return getRepo().save(entity);
    }

    @Transactional(rollbackFor = Throwable.class)
    default List<DTO> saveAllDto(List<DTO> dtos) {
        List<E> entities = mapToEntity(dtos);
        List<E> savedEntities = saveAll(entities);
        return mapToDto(savedEntities);
    }

    @Transactional(rollbackFor = Throwable.class)
    default <S extends E> List<S> saveAllAndFlush(Collection<S> entities) {
        List<S> saved = saveAll(entities);
        getRepo().flush();
        return saved;
    }

    @Transactional(rollbackFor = Throwable.class)
    default <S extends E> List<S> saveAll(Collection<S> entities) {
        return getRepo().saveAll(entities);
    }
}
