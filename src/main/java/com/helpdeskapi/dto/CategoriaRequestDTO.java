package com.helpdeskapi.dto;

import jakarta.validation.constraints.*;

public class CategoriaRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotNull(message = "sla não pode ser nulo")
    private Integer sla;
    @NotNull(message = "nivel não pode ser nulo")
    private Integer nivel;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getSla() { return sla; }
    public void setSla(Integer sla) { this.sla = sla; }
    public Integer getNivel() { return nivel; }
    public void setNivel(Integer nivel) { this.nivel = nivel; }
}
