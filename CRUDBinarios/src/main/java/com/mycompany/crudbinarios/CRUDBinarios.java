/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudbinarios;

import java.io.File;
import java.util.Optional;

/**
 *
 * @author KRMUSHIN
 */
public class CRUDBinarios {

    public static void main(String[] args) {
        
        /*
            USO DEL CRUD DE BINARIOS
        */
        
        File dir = new File("");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        
        // CREAR
        ImplementacionCrud miCrud = new ImplementacionCrud();
        
        Bloque mapa1 = new Bloque("Mundo1");
        Optional<Bloque> creacion = miCrud.create(mapa1);
        
        System.out.println(" nombre mapa: " + creacion.get().getNombreBloques());
        
        // LEER
        Bloque nuevoMapa = new Bloque("Mundo2");
        miCrud.create(nuevoMapa);
        Optional<Bloque> mapaLeido = miCrud.read("Mundo1");
        
        if (mapaLeido.isPresent()) {
            Bloque m = mapaLeido.get();
            System.out.println(" mapa recuperado" + m.getNombreBloques());
            m.setNombreBloques("se mejoro la vaina");
            // ACTUALIZAR
            miCrud.update(m);
        }
        
        Optional<Bloque> mapaActualizado = miCrud.read("Mundo1");
        if (mapaActualizado.isPresent()) {
            System.out.println("        SE LEYO EL MAPA" + mapaActualizado.get().getNombreBloques());
        }
        
        // BORRAR, DESCOMENTAR PARA PROBAR EL BORRADO DE MAPAS
        
//        boolean borrado = miCrud.delete();
//        if (borrado) {
//            System.out.println("SE BORRO");
//        }else{
//            System.out.println("NO SE BORRO");
//        }
    }
}
