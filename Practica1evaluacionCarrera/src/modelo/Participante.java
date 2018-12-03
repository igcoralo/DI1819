
package modelo;

import java.io.Serializable;


public class Participante implements Serializable{
    private Corredor corredor;
    private int dorsal;
    private int timepoSegundos;

    public Participante(Corredor corredor, int dorsal) {
        this.corredor = corredor;
        this.dorsal = dorsal;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getTimepoSegundos() {
        return timepoSegundos;
    }

    public void setTimepoSegundos(int timepoSegundos) {
        this.timepoSegundos = timepoSegundos;
    }
    
    
} 

