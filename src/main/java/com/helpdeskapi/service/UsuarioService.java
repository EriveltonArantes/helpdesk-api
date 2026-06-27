package com.helpdeskapi.service;

import com.helpdeskapi.dto.UsuarioRequestDTO;
import com.helpdeskapi.dto.UsuarioResponseDTO;
import com.helpdeskapi.exception.ResourceNotFoundException;
import com.helpdeskapi.mapper.UsuarioMapper;
import com.helpdeskapi.model.Usuario;
import com.helpdeskapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscar(Long id) {
        Usuario entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario entity = mapper.toEntity(dto);
        Usuario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario não encontrado com id: " + id);
        }
        Usuario entity = mapper.toEntity(dto);
        entity.setId(id);
        Usuario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
