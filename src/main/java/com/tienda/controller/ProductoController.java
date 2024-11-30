package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.services.CategoriaService;
import com.tienda.services.ProductoService;
import com.tienda.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

   
  @GetMapping("/listado")
    public String listado(
            @RequestParam(value = "ofertas", required = false, defaultValue = "false") boolean ofertas,
            Model model) {
        var productos = ofertas 
                ? productoService.consultaAmpliada(0, 0)
                : productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("ofertas", ofertas);
        
        // También añadimos las categorías para usarlas en la vista si es necesario
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "producto/listado"; // Corrección: sin el prefijo "/"
    }

    @GetMapping("/ofertas")
    public String productosEnOferta(Model model) {
        var productos = productoService.consultaAmpliada(0, 0);
        model.addAttribute("productos", productos);
        return "producto/ofertas"; // Corrección: sin el prefijo "/"
    }
    
    

    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

   
    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

  
    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "producto/modifica"; // Corrección: sin el prefijo "/"
    }
}
