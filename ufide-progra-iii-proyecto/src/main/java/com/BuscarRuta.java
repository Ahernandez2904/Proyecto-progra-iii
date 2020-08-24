/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.RutaRepositorio;
import dao.Ruta;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "buscarRuta")
@RequestScoped
public class BuscarRuta extends Ruta {

    private String identificacionBuscarRuta; //get y set solo a este
    private RutaRepositorio rutaRepositorio = new RutaRepositorio();  //agregamos esto

    public String getIdentificacionBuscarRuta() {
        return identificacionBuscarRuta;
    }

    public void setIdentificacionBuscarRuta(String identificacionBuscarRuta) {
        this.identificacionBuscarRuta = identificacionBuscarRuta;
    }

    public BuscarRuta() {
    }

    public String buscarIdentificacionRuta() {  //esto es para conectar el CRUD, "rodilla"
        Ruta ruta = rutaRepositorio.leerRuta(this.getIdentificacionBuscarRuta());  //leerPersona lo habiamos puesto en PersonaRepositorio
        this.setIdRuta(ruta.getIdRuta());
        this.setHorario(ruta.getHorario());
        this.setIdentRuta(ruta.getIdentRuta());
        this.setIdentificacionBuscarRuta("");
        return "buscarRuta";
    }

    public String eliminarRuta() {
        rutaRepositorio.eliminarRuta(this);
        return "buscarRuta";
    }

    public String actualizarRuta() {
        rutaRepositorio.actualizarRuta(this);
        return "buscarRuta";
    }
}
