/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Moke
 */
@EnableJpaRepositories
public interface ProductoDao extends JpaRepository<Producto, Long> {

    // ConsultaAmpliada
// Recupera los productos que están en un rango de precios ordenados por descripción
    public List<Producto> findByPrecioBetweenOrderByDescripcion(
            double precioInf, double precioSup);

// ConsultaJPQL
// Recupera los productos que están en un rango de precios ordenados por descripción
    @Query(value = "SELECT a FROM Producto a "
            + "WHERE a.precio "
            + "BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Producto> consultaJPQL(
            @Param("precioInf") double precioInf,
            @Param("precioSup") double precioSup);

// ConsultaSQL
// Recupera los productos que están en un rango de precios ordenados por descripción
    @Query(nativeQuery = true, value = "SELECT * FROM producto a "
            + "WHERE a.precio "
            + "BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Producto> consultaSQL(
            @Param("precioInf") double precioInf,
            @Param("precioSup") double precioSup);

    public List<Producto> findAllByOrderByDescripcionAsc();

}
