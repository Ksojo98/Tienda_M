/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author Moke
 */
public interface CategoriaService {
    //Se obtiene un arraylist con los registros de la tabla categoria
    //Todos los registros o solo activos
    
    public List<Categoria> getCategorias(boolean activos);
    
}
