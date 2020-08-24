/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosWeb;

import javax.ws.rs.ApplicationPath;  //hacer estos dos importes
import javax.ws.rs.core.Application;

@ApplicationPath("miApi")   //anotacion
public class JAXRSConfiguration extends Application {    //ponemos el extends
}

//clase queda vacia, es para crear la URL

//Luego creamos en serviciosWeb + New + Other + WebServices y el que dice RESTful Web Services from Patterns + Next
//Lo dejamos igual, Next, Path: persona y el automaticament le cambia el class name y el NIME Type: application/json + Finish
//Nos vamos para PersonaResource