package com.helpdeskapi.dto;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String setor;
    private String telefone;
    private String ramal;
    private String cargo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getRamal() { return ramal; }
    public void setRamal(String ramal) { this.ramal = ramal; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
}
