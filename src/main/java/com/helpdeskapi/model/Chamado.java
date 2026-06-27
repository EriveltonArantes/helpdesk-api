package com.helpdeskapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chamados")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
    @Column(nullable = false)
    private String titulo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private Integer prioridade;
    @Column(nullable = false)
    private String status;
    private java.time.LocalDateTime dataAbertura;
    private java.time.LocalDateTime dataFechamento;
    @Column(nullable = false)
    private String solucao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
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
