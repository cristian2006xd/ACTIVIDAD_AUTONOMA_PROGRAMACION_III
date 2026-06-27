package com.itsqmet.gestionlibreria.repository;

import com.itsqmet.gestionlibreria.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}