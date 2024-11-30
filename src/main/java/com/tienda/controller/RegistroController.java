package com.tienda.controller;

import com.tienda.domain.Usuario;
import com.tienda.services.RegistroService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        return "/registro/nuevo";
    }

    @Autowired
    private RegistroService registroService;
    
    @PostMapping("/crear")
    public String crear(Model model, Usuario usuario) throws MessagingException {
        model=registroService.crearUsuario(model, usuario);

        return "/registro/salida";
    }

}
