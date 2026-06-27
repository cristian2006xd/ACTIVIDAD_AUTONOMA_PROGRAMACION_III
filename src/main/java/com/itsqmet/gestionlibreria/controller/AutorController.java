package com.itsqmet.gestionlibreria.controller;

import com.itsqmet.gestionlibreria.entity.Autor;
import com.itsqmet.gestionlibreria.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/index")
    public String listar(Model model) {
        model.addAttribute("autores", autorService.listarAutores());
        if (!model.containsAttribute("autor")) {
            model.addAttribute("autor", new Autor());
        }
        return "index";
    }

    @PostMapping("/autores/guardar")
    public String guardar(@Valid @ModelAttribute Autor autor, BindingResult result, Model model) {
        // Si hay errores de validación (ej. nombre vacío o muy corto)
        if (result.hasErrors()) {
            model.addAttribute("autores", autorService.listarAutores());
            return "index"; // Recarga la vista con los mensajes de error
        }

        autorService.guardarAutor(autor);
        return "redirect:/index";
    }

    @GetMapping("/autores/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("autor", autorService.buscarPorId(id).orElse(new Autor()));
        model.addAttribute("autores", autorService.listarAutores());
        return "index";
    }

    @GetMapping("/autores/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        autorService.eliminarAutor(id);
        return "redirect:/index";
    }
}