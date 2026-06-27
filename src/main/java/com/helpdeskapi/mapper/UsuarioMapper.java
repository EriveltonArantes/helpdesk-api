package com.helpdeskapi.mapper;

import com.helpdeskapi.dto.UsuarioRequestDTO;
import com.helpdeskapi.dto.UsuarioResponseDTO;
import com.helpdeskapi.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioRequestDTO dto);

    UsuarioResponseDTO toResponseDTO(Usuario entity);
}
