package com;

import dao.Chofer;
import dao.ChoferRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "verChofer")
@RequestScoped
public class VerChofer extends Chofer{
    private List<Chofer> listaChoferes = new ArrayList<Chofer>();

    public List<Chofer> getListaChoferes() {
        return listaChoferes;
    }
   
    public VerChofer() {
    }
    
    @PostConstruct //esteroides a un metodo
    public void init(){ //este es para ver todos
        ChoferRepositorio choferRepositorio = new ChoferRepositorio();
        this.listaChoferes = choferRepositorio.leerChofer();
    }
    
}

    

