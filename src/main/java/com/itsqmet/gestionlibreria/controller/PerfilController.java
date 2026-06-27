package com.itsqmet.gestionlibreria.controller;

import com.itsqmet.gestionlibreria.entity.Perfil;
import com.itsqmet.gestionlibreria.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @GetMapping("/perfiles")
    public List<Perfil> listar() { return perfilService.listarPerfiles(); }

    @PostMapping("/perfiles")
    public Perfil guardar(@RequestBody Perfil perfil) { return perfilService.guardarPerfil(perfil); }

    @DeleteMapping("/perfiles/{id}")
    public void eliminar(@PathVariable Long id) { perfilService.eliminarPerfil(id); }
}