/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;


import dao.Ruta;
import dao.RutaRepositorio;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "ingresarRuta")
@RequestScoped
public class IngresarRuta extends Ruta{

    /**
     * Creates a new instance of Ingresar
     */
    public IngresarRuta() {   
    }
    
    public String guardarInformacionRuta(){   //ver varios valores
        RutaRepositorio rutaRepositorio = new RutaRepositorio();  //lo llamamos del metodo ingresar.xhtml va a recibir los valores y lo va ir a guardar en Base de Datos, crearPersona ingresa los valores a DB 
        rutaRepositorio.crearRuta(this);
        return "verRuta";
    }
}
