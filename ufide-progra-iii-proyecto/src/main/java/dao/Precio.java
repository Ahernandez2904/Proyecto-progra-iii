package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "costo")
@RequestScoped
public class Precio {

    private String mayor;
    private String menor;
    private String oro;
    private String costo;
    private String costoCiudadano;
    private String costoAdulto;

    public String getCostoCiudadano() {
        return costoCiudadano;
    }

    public void setCostoCiudadano(String costoCiudadano) {
        this.costoCiudadano = costoCiudadano;
    }

    public String getCostoAdulto() {
        return costoAdulto;
    }

    public void setCostoAdulto(String costoAdulto) {
        this.costoAdulto = costoAdulto;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    public String getMenor() {
        return menor;
    }

    public void setMenor(String menor) {
        this.menor = menor;
    }

    public String getOro() {
        return oro;
    }

    public void setOro(String oro) {
        this.oro = oro;
    }

    public void cobrar() {

        int menor = Integer.parseInt(this.getMenor());
        this.costo = String.valueOf(menor * 350);

        int oro = Integer.parseInt(this.getOro());
        this.costoCiudadano = String.valueOf(oro * 450);

        int mayor = Integer.parseInt(this.getMayor());
        this.costoAdulto = String.valueOf(mayor * 550);
    }
}
