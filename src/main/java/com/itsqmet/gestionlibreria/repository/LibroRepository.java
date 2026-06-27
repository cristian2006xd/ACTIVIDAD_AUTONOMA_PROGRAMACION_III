package com.itsqmet.gestionlibreria.repository;

import com.itsqmet.gestionlibreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}