package com.helpdeskapi.mapper;

import com.helpdeskapi.dto.TecnicoRequestDTO;
import com.helpdeskapi.dto.TecnicoResponseDTO;
import com.helpdeskapi.model.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    Tecnico toEntity(TecnicoRequestDTO dto);

    TecnicoResponseDTO toResponseDTO(Tecnico entity);
}
