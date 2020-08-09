//Presenter
package com;

import dao.Persona;   //importar
import dao.PersonaRepositorio;   //importar
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "ingresar")   //anotaciones que cambian funcionamiento de la clase
@RequestScoped
public class Ingresar extends Persona {  //extiende a clase persona y si sale bombillo se importa la clase

    private String mensajeIdentificacion;   //***AGREGO ESTOS DOS ATRIBUTOS***
    private Boolean bloquearBoton;  //**ESTE TAMBIEN JUNTO CON LOS GET AND SET

    public String getMensajeIdentificacion() {
        return mensajeIdentificacion;
    }

    public void setMensajeIdentificacion(String mensajeIdentificacion) {
        this.mensajeIdentificacion = mensajeIdentificacion;
    }

    public Boolean getBloquearBoton() {
        return bloquearBoton;
    }

    public void setBloquearBoton(Boolean bloquearBoton) {
        this.bloquearBoton = bloquearBoton;
    }

    public Ingresar() {
    }

    public String guardarInformacion() {  //Metodo para 
        PersonaRepositorio.agregarPersona(this);
        return "verPersonas";
    }
    
    public void validar(){    //****TAMBIEN AGREGO ESTE METODO**** PARA VALIDAR QUE LA IDENTIFICACION NO EXISTA
       String identificacion = this.getIdentificacion();
        if (PersonaRepositorio.existeIndentificacion(identificacion)) {
            this.mensajeIdentificacion = "Identificaci[on ya existe";
            this.bloquearBoton=true;
            
        }else{
            this.bloquearBoton = false;
        }
    }
}

//SourcPackages +New+ JSF CDI Bean + Class Name: Ingresar + Package: com y Scope:Request y Finish
//Una vista para un Presentar, vista ingresar junto con com:Ingresar
//creamos la vista ingresar.xhtml

