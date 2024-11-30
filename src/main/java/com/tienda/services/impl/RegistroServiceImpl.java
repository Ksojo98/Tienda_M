/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.services.impl;

import com.tienda.domain.Usuario;
import com.tienda.services.RegistroService;
import com.tienda.services.UsuarioService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Moke
 */
public class RegistroServiceImpl implements RegistroService {
    
    @Autowired
    
    private UsuarioService usuarioService;  

    @Override
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException {
      String mensaje; 
        if (!usuarioService.existeUsuarioPorUsernameOCorreo(usuario.getUsername(), usuario.getCorreo())) {
            String clave="xyz";
            usuario.setPassword(clave);
            usuario.setActivo(false);
            usuarioService.save(usuario, true);
            enviarCorreoActivacion(usuario);
            
        } else {
        
        }
        return null;
    }

    @Override
    public Model activarUsuario(Model model, String username, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Model habilitarUsuario(Usuario usuario, MultipartFile imagenFile) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     private void enviarCorreoActivacion(Usuario usuario) throws MessagingException {
        //String mensaje=messageSource.getMessage("registro.correo.activar",null,Locale.getDefault());
    }
    
    
    
}
