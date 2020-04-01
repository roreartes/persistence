package ar.com.ada.sb.api.persistence.persistence.model.mapper;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface DataMapper<E, D> {
    E toEntity (D dto);
    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);
    List<D> toDto(List<E> entityList);
}
