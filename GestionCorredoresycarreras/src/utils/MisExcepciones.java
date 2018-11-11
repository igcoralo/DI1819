
package utils;


public class MisExcepciones {
    public static class CarrCerrada extends Exception{
    public CarrCerrada(){
    super("Suspension de la carrera");
    }
    
    }
    public static class TooCorredores extends Exception {
    
        public TooCorredores(){
        super("Se excede el numero maximo de corredores");
        }
    
    }
    public static class CorredorIgual extends Exception {
    public CorredorIgual(){
    super("No se puede corredores con el mismo DNI");
    }
    }
    public static class NoCorredor extends Exception {
    public NoCorredor(){
    super("No esta el corredor");
    }
    }
    public static class NoCarrera extends Exception {
    public NoCarrera(){
    super("No esta la carrera");
    }
    }
    public static class Carreraigual extends Exception{
    public Carreraigual (){
    super("No se puede repetir la carrera");
    }
    }
    }

