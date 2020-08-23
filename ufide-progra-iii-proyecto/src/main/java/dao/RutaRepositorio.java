package dao;

import java.sql.PreparedStatement;    //importar
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CLASE CRUD SOBRE TABLA PERSONA
public class RutaRepositorio {

    public int obtenerIdRuta() {   //para leer una unica persona
        int idRuta = 1;
        try {
            String consulta = "SELECT IDRUTA FROM RUTA ORDER BY IDRUTA DESC FETCH FIRST ROW ONLY";  //ontenga IDPERSONA con Persona ordenar de forma descendente  
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);  //Agarre esta consulta y mande a ejecutar a BD
            ResultSet rs = sentencia.executeQuery();  //ejecute Query
            while (rs.next() != false) {  //cambia llave primaria I1, ID2, ID2 etc
                idRuta = rs.getInt("idruta");
                idRuta += 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idRuta;
    }

    //CREATE
    public Boolean crearRuta(Ruta ruta) {  //clase persona, en clase persona vienen los mismas variables
        try {
            String consulta = "INSERT INTO Ruta (IDRuta, HORARIO, CHOFER)"
                    + " VALUES(?, ?, ?)";   //los ? es para agregar valores
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, obtenerIdRuta());   //setear id, primer ? obtener valor
            sentencia.setString(2, ruta.getHorario());  //estos es para obtener valores ? segundo
            sentencia.setInt(3, ruta.getChofer());  //? tercerp

            sentencia.executeUpdate(); //ejecute Update           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //READ
    public Ruta leerId(String identificacion) {  //(String identificacion)vamos a obtener de la fila que coincida con el valor que le estemos poniendo en en string y en sentencia.setString
        Ruta ruta = null;
        try {
            String consulta = "SELECT IDRUTA, HORARIO, CHOFER"
                    + " FROM RUTA WHERE IDRUTA = ?";   //buscar de persona donde la id sea a ? (lo que se ponga en los datos de abajo)
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, identificacion);  //leer esta fila con el unico 1 de identificacion
            ResultSet rs = sentencia.executeQuery();   //ejecute Query
            while (rs.next()) {  //loop para que recorra todas las filas con identificacion
                ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("IDRUTA"));  //obtener datos IDPersona, abajo,nombre, apellido1 y asi con los otros y los datos que deseemos
                ruta.setHorario(rs.getString("HORARIO"));
                ruta.setChofer(rs.getInt("CHOFER"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ruta;
    }

    //READ   
    public List<Ruta> leerRuta() {   //este es para obtener varias personas
        List<Ruta> listaRuta = new ArrayList<>();
        try {
            String consulta = "SELECT IDRUTA, HORARIO, CHOFER FROM RUTA";  //poner from siempre para saber que tabla vamos a usar
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setIdRuta(rs.getInt("IDRUTA"));  //obtener datos IDPersona, abajo,nombre, apellido1 y asi con los otros y los datos que deseemos
                ruta.setHorario(rs.getString("HORARIO"));
                ruta.setChofer(rs.getInt("CHOFER"));
                listaRuta.add(ruta);  //objeto persona que instanciamos arriba
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaRuta;
    }

    //UPDATE
    public Boolean actualizarRuta(Ruta ruta) { //para actualizar
        try {
            String consulta = "UPDATE RUTA SET IDRUTA= ?, HORARIO = ?, CHOFER = ?"
                    + " WHERE IDRUTA = ?";   //con los ? porque los vamos a actualizar, poner where siempre
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, ruta.getIdRuta());
            sentencia.setString(2, ruta.getHorario());
            sentencia.setInt(3, ruta.getChofer());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    //DELETE
    public Boolean eliminarRuta(Ruta ruta) {   //para borrar, poner el Where siempre
        try {
            String consulta = "DELETE FROM RUTA WHERE IDRUTA = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, ruta.getIdRuta());   //borrar de Primary Key el 1 
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
