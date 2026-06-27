package com.helpdeskapi.mapper;

import com.helpdeskapi.dto.CategoriaRequestDTO;
import com.helpdeskapi.dto.CategoriaResponseDTO;
import com.helpdeskapi.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaRequestDTO dto);

    CategoriaResponseDTO toResponseDTO(Categoria entity);
}
