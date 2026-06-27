package com.helpdeskapi.service;

import com.helpdeskapi.dto.ChamadoRequestDTO;
import com.helpdeskapi.dto.ChamadoResponseDTO;
import com.helpdeskapi.exception.ResourceNotFoundException;
import com.helpdeskapi.mapper.ChamadoMapper;
import com.helpdeskapi.model.Chamado;
import com.helpdeskapi.repository.ChamadoRepository;
import com.helpdeskapi.repository.CategoriaRepository;
import com.helpdeskapi.model.Categoria;
import com.helpdeskapi.repository.UsuarioRepository;
import com.helpdeskapi.model.Usuario;
import com.helpdeskapi.repository.TecnicoRepository;
import com.helpdeskapi.model.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private ChamadoMapper mapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Transactional(readOnly = true)
    public List<ChamadoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ChamadoResponseDTO buscar(Long id) {
        Chamado entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Chamado não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ChamadoResponseDTO criar(ChamadoRequestDTO dto) {
        Chamado entity = mapper.toEntity(dto);
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrado com id: " + dto.getCategoriaId()));
        entity.setCategoria(categoria);
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado com id: " + dto.getUsuarioId()));
        entity.setUsuario(usuario);
        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
            .orElseThrow(() -> new ResourceNotFoundException("Tecnico não encontrado com id: " + dto.getTecnicoId()));
        entity.setTecnico(tecnico);
        Chamado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ChamadoResponseDTO atualizar(Long id, ChamadoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Chamado não encontrado com id: " + id);
        }
        Chamado entity = mapper.toEntity(dto);
        entity.setId(id);
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrado com id: " + dto.getCategoriaId()));
        entity.setCategoria(categoria);
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado com id: " + dto.getUsuarioId()));
        entity.setUsuario(usuario);
        Tecnico tecnico = tecnicoRepository.findById(dto.getTecnicoId())
            .orElseThrow(() -> new ResourceNotFoundException("Tecnico não encontrado com id: " + dto.getTecnicoId()));
        entity.setTecnico(tecnico);
        Chamado salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Chamado não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
