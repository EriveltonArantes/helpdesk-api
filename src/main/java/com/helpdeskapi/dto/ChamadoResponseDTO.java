package com.helpdeskapi.dto;

public class ChamadoResponseDTO {

    private Long id;
    private Long categoriaId;
    private Long usuarioId;
    private Long tecnicoId;
    private String titulo;
    private String descricao;
    private Integer prioridade;
    private String status;
    private java.time.LocalDateTime dataAbertura;
    private java.time.LocalDateTime dataFechamento;
    private String solucao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
