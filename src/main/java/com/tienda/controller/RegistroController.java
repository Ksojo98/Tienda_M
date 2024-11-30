package com.tienda.controller;

import com.tienda.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    
    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario)   { 
        return "/registro/nuevo";
    }
    
      @GetMapping("/crear")
    public String crear(Model model, Usuario usuario) throws MessagingException  { 
        //Se crea el proceso para crear usuario y enviar coreo
        
        
        return "/registro/salida";
    }

   
}

