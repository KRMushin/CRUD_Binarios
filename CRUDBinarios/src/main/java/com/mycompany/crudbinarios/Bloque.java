/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudbinarios;

import java.io.Serializable;

/**
 *
 * @author KRMUSHIN
 */
public class Bloque implements Serializable{
 
    private String nombreBloques;

    public Bloque() {
    }
    
    public Bloque(String nombreBloques) {
        this.nombreBloques = nombreBloques;
    }
    
    public String getNombreBloques() {
        return nombreBloques;
    }

    public void setNombreBloques(String nombreBloques) {
        this.nombreBloques = nombreBloques;
    }
    
    
    
}
