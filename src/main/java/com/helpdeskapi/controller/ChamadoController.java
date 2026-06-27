package com.helpdeskapi.controller;

import com.helpdeskapi.dto.ChamadoRequestDTO;
import com.helpdeskapi.dto.ChamadoResponseDTO;
import com.helpdeskapi.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Chamado", description = "Gerenciamento de chamados")
@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService service;

    @Operation(summary = "Listar todos os Chamado")
    @GetMapping
    public List<ChamadoResponseDTO> listar(@RequestParam(required = false) String titulo, @RequestParam(required = false) Long categoriaId, @RequestParam(required = false) Long usuarioId, @RequestParam(required = false) Long tecnicoId) {
        List<ChamadoResponseDTO> resultado = service.listar();
        if (titulo != null && !titulo.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTitulo() != null &&
                item.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (categoriaId != null) {
            resultado = resultado.stream().filter(item -> categoriaId.equals(item.getCategoriaId())).collect(java.util.stream.Collectors.toList());
        }
        if (usuarioId != null) {
            resultado = resultado.stream().filter(item -> usuarioId.equals(item.getUsuarioId())).collect(java.util.stream.Collectors.toList());
        }
        if (tecnicoId != null) {
            resultado = resultado.stream().filter(item -> tecnicoId.equals(item.getTecnicoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Chamado por ID")
    @GetMapping("/{id}")
    public ChamadoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Chamado")
    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> criar(@Valid @RequestBody ChamadoRequestDTO chamado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(chamado));
    }

    @Operation(summary = "Atualizar Chamado")
    @PutMapping("/{id}")
    public ChamadoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ChamadoRequestDTO chamado) {
        return service.atualizar(id, chamado);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Chamado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
