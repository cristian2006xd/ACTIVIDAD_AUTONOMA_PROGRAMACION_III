package com.itsqmet.gestionlibreria.service;

import com.itsqmet.gestionlibreria.entity.Categoria;
import com.itsqmet.gestionlibreria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() { return categoriaRepository.findAll(); }
    public Categoria guardarCategoria(Categoria categoria) { return categoriaRepository.save(categoria); }
    public Optional<Categoria> buscarPorId(Long id) { return categoriaRepository.findById(id); }
    public void eliminarCategoria(Long id) { categoriaRepository.deleteById(id); }
}