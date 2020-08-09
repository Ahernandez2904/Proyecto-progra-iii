/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepositorio {  //esta lista es para guardar la informacion que se vaya guardando

    private static List<Persona> listaPersonas = new ArrayList<>();  //arreglo y hacemos el get and set para esta lista estatica

    public static List<Persona> getListaPersonas() {   //get
        return listaPersonas;
    }

    public static void setListaPersonas(List<Persona> listaPersonas) {   //set
        PersonaRepositorio.listaPersonas = listaPersonas;
    }

    public static void agregarPersona(Persona persona) {   //hacemos esta funcion para agregar persona
        //Agrega un onjeto de tipo persona, Persona es la clase y persona el objeto
        listaPersonas.add(persona);
    }

    public static boolean existeIndentificacion(String identificacion) {
        /*for (Persona persona : listaPersonas) {  
            if (persona.getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;*/    //se hace esto para que recorra las identificaciones y que ninguna sea igual
        return listaPersonas.stream().anyMatch((persona)-> (persona.getIdentificacion().equals(identificacion)));  //esto es lo mismo de arriba pero resumido
    }
}

//Clase normal en el Package dao
//Despues de aqui hacemos la com junto con Ingresar
