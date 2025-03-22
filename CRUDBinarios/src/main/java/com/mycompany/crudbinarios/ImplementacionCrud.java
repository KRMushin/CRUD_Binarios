/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudbinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author KRMUSHIN
 */
public class ImplementacionCrud implements TemplateCrud<Bloque, String>{

     private static final String rutaMapas = "rutaMapaXD";

     @Override
    public String generarNombreArchivo(Bloque modelo) {
            if(modelo.getNombreBloques().equals("")) {
                return "MAPA_NUEVO.bin";
            }
            return modelo.getNombreBloques() + ".bin";
    }
    
    @Override
    public Optional<Bloque> create(Bloque modelo) {
        if (modelo == null) {
            return Optional.empty();
        }
        
        String nombreArchivo = generarNombreArchivo(modelo);
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(rutaMapas + File.separator + nombreArchivo))) {
            output.writeObject(modelo);
            return Optional.of(modelo);
        } catch (Exception e) {
            System.err.println("eerror creando la vaina " + e.getMessage());
            return Optional.empty();
        }
    }
    
    @Override
    public Optional<Bloque> read(String identificador) {
        
        if (identificador == null || identificador.isEmpty()) {
            return Optional.empty();
        }
        
        String nombreArchivo = identificador;
        if (!identificador.endsWith(".bin")) {
            nombreArchivo = identificador + ".bin";
        }
        
            File archivo = new File(rutaMapas + File.separator + nombreArchivo);
    
            if (!archivo.exists() || !archivo.isFile()) {
                return Optional.empty();
            }
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo))) {
                Object objetoInpit = input.readObject();
            
                if (objetoInpit instanceof Bloque) {
                    return Optional.of((Bloque) objetoInpit);

                } else {
                    return Optional.empty();
                }
            
        } catch (Exception e) {
            System.err.println("error leyendo archivo: " + e.getMessage());
            return Optional.empty();
        }
    }
    
    @Override
    public Optional<Bloque> update(Bloque modelo) {
        if (modelo == null) {
            return Optional.empty();
        }
        
        String nombreArchivo = generarNombreArchivo(modelo);
        File archivo = new File(rutaMapas + File.separator + nombreArchivo);
        
        if (!archivo.exists()) {
            return Optional.empty();
        }
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(archivo))) {
            output.writeObject(modelo);
            
            return Optional.of(modelo);
        } catch (Exception e) {
            System.err.println("error actualizando la vaina" + e.getMessage());
            return Optional.empty();
        }
    }
    
    @Override
    public boolean delete() {
        try {
            Files.walk(Paths.get(rutaMapas))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(File::delete);
            return true;
        } catch (IOException e) {
            System.err.println("Error eliminando las vainas jej" + e.getMessage());
            return false;
        }
    }
}