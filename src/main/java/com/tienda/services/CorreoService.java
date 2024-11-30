/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.services;

import jakarta.mail.MessagingException;

/**
 *
 * @author Moke
 */
public interface CorreoService {
    public void enviarCorreoHtml( String para, String asunto, String contenido) throws MessagingException;
    
}
