
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import modelo.Excepciones;


public class GestionArchivos implements Serializable{
     public  GestionArchivos() {
    }


    public static void guardarInstancia(LogicaAplicacion la) {
        
        File archivo = new File("gestion_corredores.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(la);
        } catch (IOException e) {
            Exceptions.printStackTrace(e);
        }
    }

    public static LogicaAplicacion cargarInstancia() {
        
        File archivo = new File("gestion_corredores.dat");
        LogicaAplicacion logicaAplicacion = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            logicaAplicacion = (LogicaAplicacion) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Exceptions.printStackTrace(e);
        }
        return logicaAplicacion;
    }
    
    public static void importarCsvCorredores(){
    
    }
    

    
}
