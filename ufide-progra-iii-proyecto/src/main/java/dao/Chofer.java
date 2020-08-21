package dao;

// POJO = Plain Old Java Object: Proposito tener atributos y metodos, anotaciones son las que viene con el @ 
public class Chofer {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private int IdChofer;
    private String identificacion;
    private String ruta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getIdChofer() {
        return IdChofer;
    }

    public void setIdChofer(int IdChofer) {
        this.IdChofer = IdChofer;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

}
