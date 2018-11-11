
package logica;

import DTO.Corredor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import utils.MisExcepciones;


public class LogiCorredor implements Serializable{
    private static LogiCorredor instance;
    //atributos
    private List<Corredor> corredores;
    private final String[] OrdenCorredores = {"Dni", "Nombre", "Fecha de nacimiento"};
//constructor

    private LogiCorredor() {
        this.corredores= new ArrayList<>();
    }
//metodos set y get 

    public static  LogiCorredor getInstance() {
      if(instance== null){
    instance = new LogiCorredor();
      }
    return instance;
        
    }

    public static void setInstance(LogiCorredor logicorredor) {
       if( logicorredor!= null){
       instance= logicorredor;
       }else{
           instance= new LogiCorredor();
       }
    }
   //coleccion
    public List<Corredor>getCorredores(){
    return corredores;
    }
    public boolean tieneCorredor(String dni){
     return corredores.stream().anyMatch((corredor) -> (corredor.getDni().equalsIgnoreCase(dni)));
    }
    public Corredor busCorredor(Corredor c){
    return this.corredores.get(this.corredores.indexOf(c));
    }
    public boolean altaCorredor(String dni, String nombre, Date fechanacimiento, String direccion, String telefono) throws MisExcepciones.CorredorIgual{
    Corredor c= new Corredor(nombre,dni,fechanacimiento,direccion,telefono);
   if(!this.corredores.contains(c)){
   corredores.add(c);
   return true;
      }else{
   throw new MisExcepciones.CorredorIgual();
   }
   }

    public boolean bajaCorredor(Corredor c)throws MisExcepciones.NoCorredor{
    if(!corredores.contains(c)){
    throw new MisExcepciones.NoCorredor();
    }
    return corredores.remove(c);
    }
    public void modificarCorredor(Corredor c_original,Corredor c_modificado){
    corredores.remove(c_original);
    corredores.add(c_modificado);
}
//orden
    public String[] getOrdenCorredores(){
    return OrdenCorredores;
    }
    public void ordeDNI(){
    Collections.sort(this.corredores);
    }
    public void ordeFechaNacimiento(){
   Collections.sort(corredores, (Corredor c1, Corredor c2) -> c1.getFechanacimiento().compareTo(c2.getFechanacimiento()));
    }
   public void ordeNombre(){
   Collections.sort(corredores,(Corredor c1,Corredor c2) -> c1.getNombre().compareTo(c2.getNombre()));
   } 
}
