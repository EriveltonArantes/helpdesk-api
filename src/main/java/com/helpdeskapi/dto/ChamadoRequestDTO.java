package com.helpdeskapi.dto;

import jakarta.validation.constraints.*;

public class ChamadoRequestDTO {

    @NotNull(message = "CategoriaId é obrigatório")
    @Positive(message = "CategoriaId deve ser um ID válido (positivo)")
    private Long categoriaId;
    @NotNull(message = "UsuarioId é obrigatório")
    @Positive(message = "UsuarioId deve ser um ID válido (positivo)")
    private Long usuarioId;
    @NotNull(message = "TecnicoId é obrigatório")
    @Positive(message = "TecnicoId deve ser um ID válido (positivo)")
    private Long tecnicoId;
    @NotBlank(message = "titulo não pode estar em branco")
    private String titulo;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @Min(value = 0, message = "prioridade não pode ser negativo")
    @NotNull(message = "prioridade não pode ser nulo")
    private Integer prioridade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @NotNull(message = "data abertura não pode ser nulo")
    private java.time.LocalDateTime dataAbertura;
    @NotNull(message = "data fechamento não pode ser nulo")
    private java.time.LocalDateTime dataFechamento;
    @NotBlank(message = "solucao não pode estar em branco")
    private String solucao;

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getTecnicoId() { return tecnicoId; }
    public void setTecnicoId(Long tecnicoId) { this.tecnicoId = tecnicoId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getPrioridade() { return prioridade; }
    public void setPrioridade(Integer prioridade) { this.prioridade = prioridade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.time.LocalDateTime getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(java.time.LocalDateTime dataAbertura) { this.dataAbertura = dataAbertura; }
    public java.time.LocalDateTime getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(java.time.LocalDateTime dataFechamento) { this.dataFechamento = dataFechamento; }
    public String getSolucao() { return solucao; }
    public void setSolucao(String solucao) { this.solucao = solucao; }
}
