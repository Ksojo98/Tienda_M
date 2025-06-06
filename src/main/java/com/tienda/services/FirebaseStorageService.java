package com.tienda.services;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    
    final String BucketName = "techshop-fbf53.appspot.com";
    //Esta es la ruta básica de este proyecto Techshop
    
    final String rutaSuperiorStorage = "techshop";
    //Ubicación donde se encuentra el archivo de configuración Json
    
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-fbf53-firebase-adminsdk-l0a8h-0b253e1704.json";
}