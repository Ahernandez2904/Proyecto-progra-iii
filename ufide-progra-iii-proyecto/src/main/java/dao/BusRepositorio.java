/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;


public class BusRepositorio {    //metodo junto con su get y set 
    private static List<Bus> listaBus = new ArrayList<Bus>();

    public static List<Bus> getListaBus() {
        return listaBus;
    }

    public static void setListaBus(List<Bus> listaBus) {
        BusRepositorio.listaBus = listaBus;
    }
    
    public static void agregarListaBus(Bus bus){    
        listaBus.add(bus);
    }
}
//despues de esto en carpetas de com.mycompany.bla bla dice JAXRSConfiguracion y JAVAEE8R se eliminan
//En Source Packages deberiamos de tener solo un dao hasta el momento
//Luego vamos a crear nuestros servicios en Source Packages + new + Other + Java Class (Una clase normal) + Next + JAXRSConfiguration (Esto tiene que ser escrito bien, despues me puede dar problemas)y en Package: serviciosWeb
//Ahora nos vamos a JAXRSConfiguration
