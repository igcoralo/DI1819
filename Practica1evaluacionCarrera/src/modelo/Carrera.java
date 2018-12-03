
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Carrera implements Serializable {
     private String nombre;
    private String lugar;
    private int maxParticipante;
    private Date fecha;
    private boolean finalizada;
    private List<Participante> participantes;

    public Carrera(String nombre, String carrera, int maxParticipante, Date fecha) {
        this.participantes = new ArrayList<>();
        this.nombre = nombre;
        this.lugar = carrera;
        this.maxParticipante = maxParticipante;
        this.fecha = fecha;
        this.finalizada = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String carrera) {
        this.lugar = carrera;
    }

    public int getMaxParticipante() {
        return maxParticipante;
    }

    public void setMaxParticipante(int maxParticipante) {
        this.maxParticipante = maxParticipante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

}

    

