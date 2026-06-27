package com.helpdeskapi.dto;

import jakarta.validation.constraints.*;

public class UsuarioRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "setor não pode estar em branco")
    private String setor;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "ramal não pode estar em branco")
    private String ramal;
    @NotBlank(message = "cargo não pode estar em branco")
    private String cargo;

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
