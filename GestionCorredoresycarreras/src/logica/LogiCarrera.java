
package logica;

import DTO.Carrera;
import DTO.Corredor;
import DTO.TiemposCorredor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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
  private void checkAniadirCorredor(Carrera carrera,TiemposCorredor corredor) throws MisExcepciones.CarrCerrada,MisExcepciones.TooCorredores,MisExcepciones.CorredorIgual{
  if(corredor == null){
  throw new IllegalArgumentException("corredor imposible de ser null");
  }else if(carrera.getListacorredores().contains(corredor)){
  throw new MisExcepciones.CorredorIgual();
  }else if(carrera.isCarrCerrada()){
  throw new MisExcepciones.CarrCerrada();
  }else if(carrera.getListacorredores().size()>=carrera.getMaxCorredor()){
  throw new MisExcepciones.TooCorredores();
  }
  }
  public boolean anadirCorredor(Carrera carrera,Corredor corredor) throws MisExcepciones.CarrCerrada,MisExcepciones.TooCorredores,MisExcepciones.CorredorIgual{
  List<TiemposCorredor>corredoresDorsal = new ArrayList<>(carrera.getListacorredores());
  Collections.sort(corredoresDorsal);
  String dorsal=" ";
  if(corredoresDorsal.isEmpty()){
  dorsal="1";
  }else{
  TiemposCorredor ultimoCorredor=corredoresDorsal.get(corredoresDorsal.size()-1);
  dorsal=Integer.toString(Integer.parseInt(ultimoCorredor.getDorsal())+1);
  }
  TiemposCorredor tiemposCorredor= new TiemposCorredor(carrera.getId(),corredor,dorsal);
  checkAniadirCorredor(carrera,tiemposCorredor);
  return carrera.aceptarCorredor(tiemposCorredor);
  }
  public boolean anadirCorredores(Carrera carrera,List<Corredor>corredores) throws MisExcepciones.CarrCerrada,MisExcepciones.TooCorredores,MisExcepciones.CorredorIgual{
  boolean ok= true;
  for (Corredor corredor:corredores){
  if(!anadirCorredor(carrera,corredor)){
  ok=false;
  }
  }
  return ok;
  }
  private void checkCorredor(Carrera carrera,TiemposCorredor corredor) throws MisExcepciones.NoCorredor,MisExcepciones.CarrCerrada{
  if(!carrera.getListacorredores().contains(corredor)){
  throw new MisExcepciones.NoCorredor();
  }else if(carrera.isCarrCerrada()){
  throw new MisExcepciones.CarrCerrada();
  }
  }
  public boolean deCorredor(Carrera carrera,TiemposCorredor corredor) throws MisExcepciones.NoCorredor,MisExcepciones.CarrCerrada{
  checkCorredor(carrera,corredor);
  return carrera.borrarCorredor(corredor);
  }

public boolean deCorredores(Carrera carrera,List<TiemposCorredor>corredores) throws MisExcepciones.NoCorredor,MisExcepciones.CarrCerrada{
Iterator<TiemposCorredor> it=corredores.iterator();
while(it.hasNext()){
TiemposCorredor corredor=it.next();
checkCorredor(carrera,corredor);
carrera.borrarCorredor(corredor);

}
return true;
}
//baja corredor
public static boolean bajaCorredor(Corredor corredor){
boolean ok=true;
Iterator<Carrera> iteratorCarrera=LogiCarrera.getInstance().getCarreras().iterator();
while(iteratorCarrera.hasNext()){
Carrera carrera=iteratorCarrera.next();
if(!carrera.isCarrCerrada()&& carrera.contenedorCorredor(corredor.getDni())){
if(!carrera.borrarCorredor(corredor.getDni())){
ok=false;
}
}
}
return ok;
}

}