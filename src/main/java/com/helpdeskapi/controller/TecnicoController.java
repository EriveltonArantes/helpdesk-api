package com.helpdeskapi.controller;

import com.helpdeskapi.dto.TecnicoRequestDTO;
import com.helpdeskapi.dto.TecnicoResponseDTO;
import com.helpdeskapi.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Tecnico", description = "Gerenciamento de tecnicos")
@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService service;

    @Operation(summary = "Listar todos os Tecnico")
    @GetMapping
    public List<TecnicoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<TecnicoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Tecnico por ID")
    @GetMapping("/{id}")
    public TecnicoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Tecnico")
    @PostMapping
    public ResponseEntity<TecnicoResponseDTO> criar(@Valid @RequestBody TecnicoRequestDTO tecnico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(tecnico));
    }

    @Operation(summary = "Atualizar Tecnico")
    @PutMapping("/{id}")
    public TecnicoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody TecnicoRequestDTO tecnico) {
        return service.atualizar(id, tecnico);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Tecnico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
