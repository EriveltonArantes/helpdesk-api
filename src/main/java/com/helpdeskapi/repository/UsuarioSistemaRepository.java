package com.helpdeskapi.repository;

import com.helpdeskapi.model.UsuarioSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioSistemaRepository extends JpaRepository<UsuarioSistema, Long> {
    Optional<UsuarioSistema> findByUsername(String username);
}
