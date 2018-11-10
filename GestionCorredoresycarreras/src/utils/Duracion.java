
package utils;

import java.time.Duration;


public class Duracion {
    
  //metodos 
  private static int getHora(Duration duracion){
 return (int) Math.floor(duracion.toHours());
    }
  private static int getMin(Duration duracion){
        return (int) Math.floor(duracion.toMinutes() - getHora(duracion) * 60);
    }
  private static int getSeg(Duration duracion){
        return (int) Math.floor(duracion.getSeconds() - getHora(duracion) * 3600 - getMin(duracion) * 60);
    }
   public static Duration nueDuracion(int minSeg, int maxSeg) {
        return Duration.ofSeconds(minSeg+((int)(Math.random()*(maxSeg-minSeg))));
    }
  
public static double segentre(Duration duracion1,Duration duracion2){
return duracion2.getSeconds()- duracion1.getSeconds();
    }

public static double minentre(Duration duracion1,Duration duracion2){
return duracion2.toMinutes()-duracion1.toMinutes();
}
public static double horaentre(Duration duracion1,Duration duracion2){
return duracion2.toHours()-duracion1.toHours();
}
public static String duracionFormaLargo(Duration duracion){
return getHora(duracion) + " horas  " + getMin(duracion) + " minutos  " + getSeg(duracion) + " segundos  ";
}
public static String duracionFormaCorto(Duration duracion) {
 return getHora(duracion) + ":" + getMin(duracion) + ":" + getSeg(duracion);
    }

}