package com.itsqmet.gestionlibreria.service;

import com.itsqmet.gestionlibreria.entity.Libro;
import com.itsqmet.gestionlibreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarLibros() { return libroRepository.findAll(); }
    public Libro guardarLibro(Libro libro) { return libroRepository.save(libro); }
    public Optional<Libro> buscarPorId(Long id) { return libroRepository.findById(id); }
    public void eliminarLibro(Long id) { libroRepository.deleteById(id); }
}