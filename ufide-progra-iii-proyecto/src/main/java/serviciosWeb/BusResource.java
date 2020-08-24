/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosWeb;

import dao.Bus;
import dao.BusRepositorio;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 */   //este lo usamos en el URL de POSTMAN
@Path("bus")  //union de api y path (bus) crea el url para entrar a usar los servicios, se elimina el get y put
@RequestScoped
public class BusResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonaResource
     */
    public BusResource() {
    }

    @POST  //importar librerias
    @Path("/agregarBus")   
    @Consumes(MediaType.APPLICATION_JSON)  //se trabaja con json
    @Produces(MediaType.APPLICATION_JSON)
    public Response ingresarBus(String content){  //obtengo info bus
        try{   //try and catch
            JsonObject jsonObject;
            JsonReader jsonReader = Json.createReader(new StringReader(content));
            
            jsonObject = jsonReader.readObject();   //sacar cuerpo y setarlo aqui
            
            Bus bus = new Bus();   //con los mismos atributos de persona 
            bus.setMarca(jsonObject.getString("marca"));
            bus.setPlaca(jsonObject.getString("placa"));

            
            BusRepositorio.agregarListaBus(bus);
            return Response.ok("{ \"operacionExitosa\": 1 }").build();
        }
        catch(Exception e){
            System.out.println(e.getMessage());  //mensaje internal server
            String resultado = "{ \"error\": \"Ocurrió un error inesperado\"" + e.getMessage().toString() + "}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
        }
    }
    
    @GET
    @Path("/buses")   //otro path que utilizamos en URL de POSTMAN
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBus(){    //guardo info bus
        try{
            List<Bus> listaBus = BusRepositorio.getListaBus();
            JsonArrayBuilder arregloBus = Json.createArrayBuilder();
            for(Bus bus : listaBus){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                JsonObject jsonObject = jsonObjectBuilder
                        .add("marca", bus.getMarca())
                        .add("placa", bus.getPlaca())                 
                        .build();
                arregloBus.add(jsonObject);
            }
            JsonObjectBuilder jsonObjectBuilder2 = Json.createObjectBuilder();
            JsonObject jsonFinal = jsonObjectBuilder2.add("buses", arregloBus).build();  //poner toda la info
            StringWriter jsonString = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(jsonString);
            jsonWriter.writeObject(jsonFinal);
            return Response.ok(jsonString.toString()).build();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            String resultado = "{ \"error\": \"Ocurrió un error inesperado\"" + e.getMessage().toString() + "}";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resultado).build();
        }
    }
}
//despues de aqui ponemos a correr la app, POSTMAN lo que hace es probar los servicios, es un simulador
//vamos a ver cuantas personas tenemos registrados en el sistema, agarramos la URL principalla que me sale en el Hello World! y la vamos a pegar en Postman en donde dice Enter Request URL
//para ver un metodo en especifico nos vamos a JAXRSConfiguration y en PathApplication copiamos el nombre de este "miApi"
//miApi lo pegamos en el URL que habiamos puesto anteriormente en el POSTMAN, quedaria asi: http://localhost:8080/ServiciosWeb/miApi
//y agregamos el path de PersonaResource que pusimos arriba, quedaria asi: http://localhost:8080/ServiciosWeb/miApi/persona
//y ahora agregamos las personas que estan en el sistema, en el metodo de getPersonas viene otro path  http://localhost:8080/ServiciosWeb/miApi/persona/personas
//en el status deberia de decir 200 OK y el arreglo en este momento no deberia de haber algo
//por medio del URL es que podemos llamar al metodo en Postman, utilizando el GET
//Si es en el POST, vamos a utilizar el de agregar personas http://localhost:8080/ServiciosWeb/miApi/persona/agregarPersona
//y metemos este codigo, POST y en Body, en la ultima opcion poner que es de JSON
/*{
 {
    "nombre": "Valeria",
    "apellido1": "Matamoros",
    "apellido2": "Navarro"
}
*/
//Esto nos deberia dar operacionExitosa
//Si volvemos al enlace de antes en el que era de personas, deberia de salirme los datos que pusimos antes

//Ahora vamos a crear la interfaz



