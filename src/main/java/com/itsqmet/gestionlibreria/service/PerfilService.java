package com.itsqmet.gestionlibreria.service;

import com.itsqmet.gestionlibreria.entity.Perfil;
import com.itsqmet.gestionlibreria.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> listarPerfiles() { return perfilRepository.findAll(); }
    public Perfil guardarPerfil(Perfil perfil) { return perfilRepository.save(perfil); }
    public Optional<Perfil> buscarPorId(Long id) { return perfilRepository.findById(id); }
    public void eliminarPerfil(Long id) { perfilRepository.deleteById(id); }
}