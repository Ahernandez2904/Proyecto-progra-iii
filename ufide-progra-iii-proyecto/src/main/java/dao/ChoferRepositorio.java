
package dao;

import java.sql.PreparedStatement;    //importar
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASE CRUD SOBRE TABLA PERSONA
public class ChoferRepositorio {
    
    public int obtenerIdChofer(){   //para leer una unica persona
        int idChofer = 1;
        try{
            String consulta = "SELECT IDCHOFER FROM CHOFER ORDER BY IDCHOFER DESC FETCH FIRST ROW ONLY";  //ontenga IDPERSONA con Persona ordenar de forma descendente  
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);  //Agarre esta consulta y mande a ejecutar a BD
            ResultSet rs = sentencia.executeQuery();  //ejecute Query
            while(rs.next() != false){  //cambia llave primaria I1, ID2, ID2 etc
                idChofer = rs.getInt("idchofer");
                idChofer += 1;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return idChofer;
    }
    
    //CREATE
    public Boolean crearChofer(Chofer chofer){  //clase persona, en clase persona vienen los mismas variables
        try{
            String consulta = "INSERT INTO CHOFER (IDCHOFER, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION)"
                    + " VALUES(?, ?, ?, ?, ?)";   //los ? es para agregar valores
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, obtenerIdChofer());   //setear id, primer ? obtener valor
            sentencia.setString(2, chofer.getNombre());  //estos es para obtener valores ? segundo
            sentencia.setString(3, chofer.getApellido1());  //? tercerp
            sentencia.setString(4, chofer.getApellido2());  //? cuarto
            sentencia.setString(5, chofer.getIdentificacion());  //? quinto 
            sentencia.executeUpdate(); //ejecute Update
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    //READ
    public Chofer leerChofer(String identificacion){  //(String identificacion)vamos a obtener de la fila que coincida con el valor que le estemos poniendo en en string y en sentencia.setString
        Chofer chofer = null;
        try{
            String consulta = "SELECT IDCHOFER, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION"
                    + " FROM CHOFER WHERE IDENTIFICACION = ?";   //buscar de persona donde la id sea a ? (lo que se ponga en los datos de abajo)
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, identificacion);  //leer esta fila con el unico 1 de identificacion
            ResultSet rs = sentencia.executeQuery();   //ejecute Query
            while(rs.next()){  //loop para que recorra todas las filas con identificacion
                chofer = new Chofer(); 
                chofer.setIdChofer(rs.getInt("IDCHOFER"));  //obtener datos IDPersona, abajo,nombre, apellido1 y asi con los otros y los datos que deseemos
                chofer.setNombre(rs.getString("NOMBRE"));
                chofer.setApellido1(rs.getString("APELLIDO1"));
                chofer.setApellido2(rs.getString("APELLIDO2"));
                chofer.setIdentificacion(rs.getString("IDENTIFICACION"));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());            
        }
        return chofer;
    }
    
    //READ   
    public List<Chofer> leerChofer(){   //este es para obtener varias personas
        List<Chofer> listaChoferes = new ArrayList<>();
        try{
            String consulta = "SELECT IDCHOFER, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION FROM CHOFER";  //poner from siempre para saber que tabla vamos a usar
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                Chofer chofer = new Chofer();
                chofer.setIdChofer(rs.getInt("IDCHOFER"));
                chofer.setNombre(rs.getString("NOMBRE"));
                chofer.setApellido1(rs.getString("APELLIDO1"));
                chofer.setApellido2(rs.getString("APELLIDO2"));
                chofer.setIdentificacion(rs.getString("IDENTIFICACION"));
                listaChoferes.add(chofer);  //objeto persona que instanciamos arriba
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());            
        }
        return listaChoferes;
    }
    
    //UPDATE
    public Boolean actualizarChofer(Chofer chofer){ //para actualizar
        try{
            String consulta = "UPDATE CHOFER SET NOMBRE = ?, APELLIDO1 = ?, APELLIDO2 = ?, IDENTIFICACION = ?"
                + " WHERE IDCHOFER = ?";   //con los ? porque los vamos a actualizar, poner where siempre
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, chofer.getNombre());
            sentencia.setString(2, chofer.getApellido1());
            sentencia.setString(3, chofer.getApellido2());
            sentencia.setString(4, chofer.getIdentificacion());
            sentencia.setInt(5, chofer.getIdChofer());
            sentencia.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    //DELETE
    public Boolean eliminarChofer(Chofer chofer){   //para borrar, poner el Where siempre
        try{
            String consulta = "DELETE FROM CHOFER WHERE IDCHOFER = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, chofer.getIdChofer());   //borrar de Primary Key el 1 
            sentencia.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
