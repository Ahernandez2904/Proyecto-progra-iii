/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Persona;
import dao.PersonaRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "verPersonas")
@RequestScoped
public class VerPersonas extends Persona {  //herede de persona y se importan las respectivas librerias o clases
    private List<Persona> listaPersonas = new ArrayList<Persona>();    //arreglo de lista

    public List<Persona> getListaPersonas() {   //solo hacemos el get 
        return listaPersonas;
    }
    
    public VerPersonas() {
    }
    
    @PostConstruct    //agregar librerias, primera estancia de la clase
    public void init(){
        listaPersonas = PersonaRepositorio.getListaPersonas();    //
    }
    
}


//SourcPackages + New + JSF CDI Bean + Class Name: VerPersona + Package: com y Scope:Request y Finish
//Creamos la vista de verPersonas.xhtml