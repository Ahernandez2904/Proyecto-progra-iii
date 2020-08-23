/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Chofer;
import dao.ChoferRepositorio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "buscar")
@RequestScoped
public class BuscarChofer extends Chofer {

    private String identificacionBuscar; //get y set solo a este
    private ChoferRepositorio choferRepositorio = new ChoferRepositorio();  //agregamos esto

    public String getIdentificacionBuscar() {
        return identificacionBuscar;
    }

    public void setIdentificacionBuscar(String identificacionBuscar) {
        this.identificacionBuscar = identificacionBuscar;
    }

    public BuscarChofer() {
    }

    public String buscarIdentificacion() {  //esto es para conectar el CRUD, "rodilla"
        Chofer chofer = choferRepositorio.leerChofer(this.getIdentificacionBuscar());  //leerPersona lo habiamos puesto en PersonaRepositorio
        this.setIdChofer(chofer.getIdChofer());
        this.setNombre(chofer.getNombre());
        this.setApellido1(chofer.getApellido1());
        this.setApellido2(chofer.getApellido2());
        this.setIdentificacion(chofer.getIdentificacion());
        this.setIdentificacionBuscar("");
        return "buscar";
    }

    public String eliminarChofer() {
        choferRepositorio.eliminarChofer(this);
        return "buscar";
    }

    public String actualizarChofer() {
        choferRepositorio.actualizarChofer(this);
        return "buscar";
    }
}
