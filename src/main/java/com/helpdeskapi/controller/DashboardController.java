package com.helpdeskapi.controller;

import com.helpdeskapi.model.Usuario;
import com.helpdeskapi.model.Tecnico;
import com.helpdeskapi.model.Chamado;
import com.helpdeskapi.model.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.helpdeskapi.repository.UsuarioRepository usuarioRepository;

    @Autowired
    private com.helpdeskapi.repository.TecnicoRepository tecnicoRepository;

    @Autowired
    private com.helpdeskapi.repository.ChamadoRepository chamadoRepository;

    @Autowired
    private com.helpdeskapi.repository.CategoriaRepository categoriaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalUsuario", usuarioRepository.count());
        resumo.put("totalTecnico", tecnicoRepository.count());
        resumo.put("totalChamado", chamadoRepository.count());
        resumo.put("somaPrioridadeChamado", chamadoRepository.findAll().stream().filter(e -> e.getPrioridade() != null).mapToInt(e -> e.getPrioridade()).sum());
        resumo.put("graficoChamado", chamadoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCategoria", categoriaRepository.count());
        resumo.put("somaSlaCategoria", categoriaRepository.findAll().stream().filter(e -> e.getSla() != null).mapToInt(e -> e.getSla()).sum());
        return resumo;
    }
}
