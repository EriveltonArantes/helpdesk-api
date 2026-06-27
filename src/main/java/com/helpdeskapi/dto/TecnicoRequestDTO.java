package com.helpdeskapi.dto;

import jakarta.validation.constraints.*;

public class TecnicoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "especialidade não pode estar em branco")
    private String especialidade;
    @NotNull(message = "disponivel não pode ser nulo")
    private Boolean disponivel;
    @NotNull(message = "nivel atendimento não pode ser nulo")
    private Integer nivelAtendimento;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
    public Integer getNivelAtendimento() { return nivelAtendimento; }
    public void setNivelAtendimento(Integer nivelAtendimento) { this.nivelAtendimento = nivelAtendimento; }
}
