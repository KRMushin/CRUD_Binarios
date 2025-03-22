/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudbinarios;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author KRMUSHIN
 */
public interface TemplateCrud<T, ID> {
        
    String generarNombreArchivo(Bloque modelo);
    
    Optional<T> create(T modelo);
    
    Optional<T> read(ID identificador);
    
    Optional<T> update(T modelo);

    boolean delete();
    
}
