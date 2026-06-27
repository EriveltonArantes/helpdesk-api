package com.helpdeskapi.controller;

import com.helpdeskapi.dto.UsuarioRequestDTO;
import com.helpdeskapi.dto.UsuarioResponseDTO;
import com.helpdeskapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Usuario", description = "Gerenciamento de usuarios")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Operation(summary = "Listar todos os Usuario")
    @GetMapping
    public List<UsuarioResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<UsuarioResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Usuario por ID")
    @GetMapping("/{id}")
    public UsuarioResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Usuario")
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioRequestDTO usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(usuario));
    }

    @Operation(summary = "Atualizar Usuario")
    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO usuario) {
        return service.atualizar(id, usuario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
