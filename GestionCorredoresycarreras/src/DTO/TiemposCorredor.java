
package DTO;

import java.io.Serializable;
import java.time.Duration;
import utils.Duracion;
import utils.Utiles;
import java.util.Date;
import java.util.Objects;


public class TiemposCorredor  implements Serializable, Comparable<TiemposCorredor>{
    //atributos 
    private final String idCarrera;
    private final Corredor corredor;
    private final String dorsal;
    private Duration temp;
    public static final String[] Datos={"DNI","Nombre","Fecha de nacimiento","direccion","telefono","dorsal","tiempo"};
    
    //constructor

    public TiemposCorredor(String idCarrera, Corredor corredor, String dorsal) {
        this.idCarrera = idCarrera;
        this.corredor = corredor;
        this.dorsal = dorsal;
        temp=Duration.ZERO;
    }
    //get y set

    public String getIdCarrera() {
        return idCarrera;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public String getDorsal() {
        return dorsal;
    }

    public Duration getTemp() {
        return temp;
    }

    public void setTemp(Duration temp) {
        this.temp = temp;
    }
       
    //metodos

    @Override
    public int compareTo(TiemposCorredor c) {
        return this.dorsal.compareTo(c.getDorsal());
    }
    
    public String[] toArray(){
    String array[] = new String[7];
    array[0]=this.corredor.getDni();
    array[1]=this.corredor.getNombre();
    array[2]=Utiles.SDf.format(this.corredor.getFechanacimiento());
    array[3]=this.corredor.getDireccion();
    array[4]=this.corredor.getTelefono();
    array[5]=this.dorsal;
    array[6]=Duracion.duracionFormaCorto(this.temp);
    return array;
            
    }
    @Override
    public int hashCode(){
    int hash=3;
    hash=47*hash+Objects.hashCode(this.corredor);
    hash=47*hash+Objects.hashCode(this.idCarrera);
  return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TiemposCorredor other = (TiemposCorredor) obj;
        if (!Objects.equals(this.idCarrera, other.idCarrera)) {
            return false;
        }
        if (!Objects.equals(this.corredor, other.corredor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TiemposCorredor{" + "idCarrera=" + idCarrera + ", corredor=" + corredor + ", dorsal=" + dorsal + ", temp=" + Duracion.duracionFormaLargo(this.temp)+ '}';
    }
    
    
}
