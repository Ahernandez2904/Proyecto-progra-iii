//CRUD: CREATE, READ (SELECT), UPDATE, DELETE 
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Conexion conexion;  //ESTATICO PARA QUE HAYA SOLO UNA CONEXION
    private static final String BASEDEDATOSURL = "jdbc:derby://localhost:1527/transporte;user=administrador;password=admin";  //String de conexion, el URL es el archivo quebrado, Properties, click derecho, Database URL copiar y pegar aqui, ademas agregar el user y el password
    private static Connection connectionBD = null;  //Importar Connection
    
    private Conexion() throws Exception{  
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").getDeclaredConstructor().newInstance();   //poner Driver que estamos utilizando, en archivo quebrado click derecho, Properties, y dice Driver class copiamos y pegamos aqui
            connectionBD = DriverManager.getConnection(BASEDEDATOSURL); 
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public static synchronized Connection getConexion(){ //hacer conexion con la variable estatica para que las conexiones no se abran a lo loco
        try
        {
            if(connectionBD == null)
                conexion = new Conexion();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connectionBD;
    }

}
//Clase normal llamada Conexion
//

