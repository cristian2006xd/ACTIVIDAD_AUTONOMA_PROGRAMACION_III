package com.itsqmet.gestionlibreria.controller;

import com.itsqmet.gestionlibreria.entity.Categoria;
import com.itsqmet.gestionlibreria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() { return categoriaService.listarCategorias(); }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) { return categoriaService.guardarCategoria(categoria); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { categoriaService.eliminarCategoria(id); }
}