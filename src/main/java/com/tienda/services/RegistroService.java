/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.services;

import com.tienda.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Moke
 */
public interface RegistroService {
    //Metodo para crear inicialmente un usuario de manera parcial
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;
     //Metodo para activar un usuario desde enlace enviado
    public Model activarUsuario(Model model, String username, String clave); 
    
       //Metodo para habilitar inicialmente un usuario de manera parcial
    public Model habilitarUsuario(Usuario usuario, MultipartFile imagenFile);
    
      //Metodo para recordar la clave de un usuario 
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
            
}
