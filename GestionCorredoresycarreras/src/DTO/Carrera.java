
package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import utils.Utiles;


public class Carrera implements Serializable, Comparable<Carrera> {

  private String id;
  private String nombre;
  private Date fecha;
  private String lugar;
  private boolean carrCerrada;
  private int maxCorredor;
  private List<TiemposCorredor> listacorredores;
 
  
  public static final String[]
          DatosCarrera ={ "ID","Nombre","Fecha","Lugar","maxcorredores","Corredores","Estado"};
 //constructor

    public Carrera(String id, String nombre, Date fecha, String lugar, int maxCorredor) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.maxCorredor = maxCorredor;
        this.carrCerrada=false;
        this.listacorredores= new ArrayList<>();
        
    }

    @Override
    public int compareTo(Carrera c ) {
        Integer i =Integer.parseInt(id);
        return i.compareTo(Integer.parseInt(c.getId()));
        }
  
  @Override
  public int hashCode(){
  int hash=7;
  hash=37*hash+ Objects.hashCode(this.id);
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
        final Carrera other = (Carrera) obj;
         return Objects.equals(this.id, other.id);
        }
    public String[] toArray(){
    String array[]= new String[7];
    array[0]=this.id;
    array[1]=this.nombre;
    array[2]=Utiles.SDf.format(this.fecha);
    array[3]=this.lugar;
    array[4]=Integer.toString(this.maxCorredor);
    array[5]=Integer.toString(getListacorredores().size());
    array[6]=((this.carrCerrada)?("Cerrada"):("Abierta"));
    return array;
        }
    //set y get

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

   
    public void setMaxCorredor(int maxCorredor) {
        if(maxCorredor <=0){
        throw new IllegalArgumentException("Se necesitan corredores");
         }else if(maxCorredor < this.listacorredores.size()){
         throw new IllegalArgumentException("numero actual de corredores es mayor ,borra corredores o indica un numero mas alto ");
         }
    this.maxCorredor= maxCorredor;
    }
    public void cerrarCarrera(){
    this.carrCerrada=true;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public boolean isCarrCerrada() {
        return carrCerrada;
    }

    public int getMaxCorredor() {
        return maxCorredor;
    }

    public List<TiemposCorredor> getListacorredores() {
        return new ArrayList<>(listacorredores);
    }
    //metodo toString

    @Override
    public String toString() {
       String string = "Carrera{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", carreraCerrada=" + carrCerrada + ", maxCorredores=" + maxCorredor + '}';
          string += "\tCorredores{\n";
        for (TiemposCorredor c : listacorredores) {
            string.concat("\n\t\t" + c.toString());
        }
        string += "\t}";
        return string;
    }
  //corredores
    public boolean contenedorCorredor(String dniCorredor){
    for (TiemposCorredor corredor: listacorredores){
    if(corredor.getCorredor().getDni().equalsIgnoreCase(dniCorredor)){
    return true;
    }
    }
    return false;
    }
   public boolean aceptarCorredor(TiemposCorredor corredor){
   return this.listacorredores.add(corredor);
   } 

public boolean borrarCorredor(TiemposCorredor corredor){
return this.listacorredores.remove(corredor);
}
public boolean borrarCorredor(String dni){
if(this.contenedorCorredor(dni)){
Iterator<TiemposCorredor> iteratorCorredor = listacorredores.iterator();
while (iteratorCorredor.hasNext()){
TiemposCorredor corredor =iteratorCorredor.next();
if(corredor.getCorredor().getDni().equalsIgnoreCase(dni)){
return this.listacorredores.remove(corredor);
}
}
}
return false;
}
}