/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Persona;
import dao.PersonaRepositorio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "buscar")
@RequestScoped
public class BuscarChofer extends Persona{
    private String identificacionBuscar; //get y set solo a este
    private PersonaRepositorio personaRepositorio = new PersonaRepositorio();  //agregamos esto

    public String getIdentificacionBuscar() {
        return identificacionBuscar;
    }

    public void setIdentificacionBuscar(String identificacionBuscar) {
        this.identificacionBuscar = identificacionBuscar;
    }

   
    public BuscarChofer() {
    }
    
    public String buscarIdentificacion(){  //esto es para conectar el CRUD, "rodilla"
        Persona persona = personaRepositorio.leerPersona(this.getIdentificacionBuscar());  //leerPersona lo habiamos puesto en PersonaRepositorio
        this.setIdPersona(persona.getIdPersona());
        this.setNombre(persona.getNombre());
        this.setApellido1(persona.getApellido1());
        this.setApellido2(persona.getApellido2());
        this.setIdentificacion(persona.getIdentificacion());
        this.setIdentificacionBuscar("");
        return "buscar";
    }
    
    public String eliminarPersona(){
        personaRepositorio.eliminarPersona(this);
        return "buscar";
    }
    
    public String actualizarPersona(){
        personaRepositorio.actualizarPersona(this);
        return "buscar";
    }
}
