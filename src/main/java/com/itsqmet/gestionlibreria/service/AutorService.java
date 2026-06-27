package com.itsqmet.gestionlibreria.service;

import com.itsqmet.gestionlibreria.entity.Autor;
import com.itsqmet.gestionlibreria.entity.Perfil;
import com.itsqmet.gestionlibreria.repository.AutorRepository;
import com.itsqmet.gestionlibreria.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    // Listar todos
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    // Guardar o actualizar
    public Autor guardarAutor(Autor autor) {
        // Lógica para evitar el error de entidad desprendida al asociar un perfil existente
        if (autor.getPerfil() != null && autor.getPerfil().getId() != null) {
            Perfil perfilExistente = perfilRepository.findById(autor.getPerfil().getId())
                    .orElseThrow(() -> new RuntimeException("Perfil no encontrado con ID: " + autor.getPerfil().getId()));
            autor.setPerfil(perfilExistente);
        }
        return autorRepository.save(autor);
    }

    // Buscar por ID
    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    // Eliminar
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }
}