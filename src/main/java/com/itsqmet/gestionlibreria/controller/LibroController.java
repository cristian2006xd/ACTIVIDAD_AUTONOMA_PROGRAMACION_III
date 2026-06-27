package com.itsqmet.gestionlibreria.controller;

import com.itsqmet.gestionlibreria.entity.Libro;
import com.itsqmet.gestionlibreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listar() { return libroService.listarLibros(); }

    @PostMapping
    public Libro guardar(@RequestBody Libro libro) { return libroService.guardarLibro(libro); }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { libroService.eliminarLibro(id); }
}