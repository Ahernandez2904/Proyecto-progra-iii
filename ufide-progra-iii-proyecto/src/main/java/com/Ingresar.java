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


@Named(value = "ingresar")
@RequestScoped
public class Ingresar extends Chofer {

    /**
     * Creates a new instance of Ingresar
     */
    public Ingresar() {   
    }
    
    public String guardarInformacion(){   //ver varios valores
        ChoferRepositorio choferRepositorio = new ChoferRepositorio();  //lo llamamos del metodo ingresar.xhtml va a recibir los valores y lo va ir a guardar en Base de Datos, crearPersona ingresa los valores a DB 
        choferRepositorio.crearChofer(this);
        return "verChofer";
    }
}
