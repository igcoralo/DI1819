
package logica;

import DTO.Carrera;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import utils.MisExcepciones;


public class LogiCarrera implements Serializable {
    private static LogiCarrera instance;
    //atributos
    private List<Carrera> carreras;
    //constructor

    private LogiCarrera() {
        this.carreras= new ArrayList<>();
         }
    //set y get

    public static LogiCarrera getInstance() {
        if(instance== null){
        instance = new LogiCarrera();
        }
        return instance;
    }

    public static void setInstance(LogiCarrera logicarrera) {
        instance = logicarrera;
    }
    //coleccion carreras
    public List<Carrera> getCarreras(){
    return carreras;
    }
    public boolean altaCarrera(String nombre, Date fecha, String lugar, int plazas) throws MisExcepciones.Carreraigual{
    List<Carrera> carrerasID = new ArrayList<>(carreras);
    Collections.sort(carrerasID);
    String id=" ";
    if(carrerasID.isEmpty()){
    id="1";
    }else{
    Carrera ultimaCarrera =carrerasID.get(carrerasID.size()-1);
    id=Integer.toString(Integer.parseInt(ultimaCarrera.getId())+1);
    }
    Carrera c= new Carrera(id,nombre,fecha,lugar,plazas);
    if(!this.carreras.contains(c)){
    return this.carreras.add(c);
    }else{
    throw new MisExcepciones.Carreraigual();
    }
    }
  public boolean bajaCarrera(Carrera carrera)throws MisExcepciones.NoCarrera {
  if(!this.carreras.contains(carrera)) {
  throw new MisExcepciones.NoCarrera();
  }
  return carreras.remove(carrera);
  } 
  public boolean modificarCarrera(Carrera c_original, Carrera c_modificada) throws MisExcepciones.CarrCerrada,MisExcepciones.NoCarrera, MisExcepciones.Carreraigual {
  if(c_original.isCarrCerrada()){
  throw new MisExcepciones.CarrCerrada();
  }else if(!carreras.contains(c_original)){
  throw new MisExcepciones.NoCarrera();
  }else if((!c_original.equals(c_modificada))&& carreras.contains(c_modificada)){
  throw new MisExcepciones.Carreraigual();
  }
  carreras.remove(c_original);
  carreras.add(c_modificada);
  return true;
  }
  //colecion corredores en la carrera
  
  
  
  
}
