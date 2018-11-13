
package logica;

import DTO.Corredor;
import java.io.File;
import java.io.IOException;
import utils.FicheroObjetos;
import utils.FicheroTexto;


public class LogicGuardado {
      private final boolean usarFichero = true;
  
    private FicheroObjetos<LogiCarrera> gestorFicheroCarreras;
    private final File ficheroCarreras = new File("fichero_carreras.dat");
    
    private FicheroObjetos<LogiCorredor> gestorFicheroCorredores;
    private final File ficheroCorredores = new File("fichero_corredores.dat");
    
    private FicheroTexto gestorCSVCorredores;
    private final File ficheroCSVCorredores = new File("fichero_corredores.csv");

    private static LogicGuardado instance;

    public static LogicGuardado getInstance() {
        if (instance == null) {
            instance = new LogicGuardado();
        }
        return instance;
    }
    //cargar y guardar datos
    public void cargarDatos() {
        if (usarFichero) {
            leerLogicaCarreras();
            leerLogicaCorredores();
        }else{}
    }
    public void guardarDatos() {
        if (usarFichero) {
            guardarLogicaCarreras();
            guardarLogicaCorredores();
            guardarCorredoresCSV();
        }else{}
    }
    //ficheroCarreras
     private boolean leerLogicaCarreras() {
        if (checkFicheroCarreras()) {
            LogiCarrera logicaCarreras = null;
            if (ficheroCarreras.length() > 0) {
                this.gestorFicheroCarreras.abrirFicheroLector();
                logicaCarreras = gestorFicheroCarreras.leerObjeto();
                this.gestorFicheroCarreras.cerrarFicheroLector();
            }
            LogiCarrera.setInstance(logicaCarreras);
            return true;
        } else {
            return false;
        }
    }
    private boolean guardarLogicaCarreras()  {
        if (checkFicheroCarreras()) {
            gestorFicheroCarreras.abrirFicheroEscritor(false);
            gestorFicheroCarreras.grabarPrimerObjeto(LogiCarrera.getInstance());
            gestorFicheroCarreras.cerrarFicheroEscritor();
            return true;
        } else {
            return false;
        }
    }
private boolean checkFicheroCarreras() {
        if (!ficheroCarreras.exists()) {
            try {
                ficheroCarreras.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        this.gestorFicheroCarreras = new FicheroObjetos<>(ficheroCarreras);
        return true;
    }
//fichero Corredores
 private boolean leerLogicaCorredores() {
        if (checkFicheroCorredores()) {
            LogiCorredor logicaCorredores = null;
            if (ficheroCorredores.length() > 0) {
                this.gestorFicheroCorredores.abrirFicheroLector();
                logicaCorredores = gestorFicheroCorredores.leerObjeto();
                this.gestorFicheroCorredores.cerrarFicheroLector();
            }
            LogiCorredor.setInstance(logicaCorredores);
            return true;
        } else {
            return false;
        }
    }
  private boolean guardarLogicaCorredores()  {
        if (checkFicheroCorredores()) {
            gestorFicheroCorredores.abrirFicheroEscritor(false);
            gestorFicheroCorredores.grabarPrimerObjeto(LogiCorredor.getInstance());
            gestorFicheroCorredores.cerrarFicheroEscritor();
            return true;
        } else {
            return false;
        }
    }
      private boolean checkFicheroCorredores() {
        if (!ficheroCorredores.exists()) {
            try {
                ficheroCorredores.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        this.gestorFicheroCorredores = new FicheroObjetos<>(ficheroCorredores);
        return true;
    }
//csv
       private boolean guardarCorredoresCSV(){
        if (!ficheroCSVCorredores.exists()) {
            try {
                ficheroCSVCorredores.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        this.gestorCSVCorredores = new FicheroTexto(ficheroCSVCorredores);
        this.gestorCSVCorredores.abrirFicheroEscritor(false);
for(String nombreAtributo : Corredor.Datos){
            gestorCSVCorredores.print(nombreAtributo+",");
        }
 gestorCSVCorredores.print("\n");
 
  for (Corredor corredor : LogiCorredor.getInstance().getCorredores()){
            for (String atributo : corredor.toArray()){
                gestorCSVCorredores.print(atributo+",");
            }
            gestorCSVCorredores.print("\n");
        }
  this.gestorCSVCorredores.cerrarFicheroEscritor();
        return true;
    }
}


