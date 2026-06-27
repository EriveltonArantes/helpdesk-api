package com.helpdeskapi.mapper;

import com.helpdeskapi.dto.ChamadoRequestDTO;
import com.helpdeskapi.dto.ChamadoResponseDTO;
import com.helpdeskapi.model.Chamado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {

    @Mapping(target = "categoria", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "tecnico", ignore = true)
    Chamado toEntity(ChamadoRequestDTO dto);

    @Mapping(target = "categoriaId", source = "categoria.id")
    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "tecnicoId", source = "tecnico.id")
    ChamadoResponseDTO toResponseDTO(Chamado entity);
}
