
package GestionCarreraConsola.log;

import GestionCarreraConsola.modelo.Corredor;

import java.util.ArrayList;
import java.util.List;


public class MainGestionCorredor {

   
    public static void main(String[] args) {
     final String FICHERO="corredores.csv";
         int opcion;
         int contador=0;
         boolean ingresado=false;
         Corredor corredor=new Corredor();
         List<Corredor>listaCorredores=new ArrayList<Corredor>();        
         LogicaAplicacion la=new LogicaAplicacion();
         LogicaFicheros lf=new LogicaFicheros();
         //lanzamos menu
          do{
             opcion = la.menu();
              switch(opcion){
                  case 1: //alta
                    corredor=la.datosCorredor();
                   ingresado= la.altaCorredor(corredor, listaCorredores);
                   if(ingresado==true){
                      corredor.setDorsal(la.asignarDorsal());
                   }
                    break;
                  case 2:   //baja                
                      la.bajaCorredor(la.buscarCorredor(listaCorredores), listaCorredores);
                    break;
                  case 3: //ver y modificar
                      Corredor c= new Corredor();
                      c=la.buscarCorredor(listaCorredores);
                      int pos=listaCorredores.indexOf(c);
                      corredor=la.modificarCorredor(c);
                      listaCorredores.set(pos, corredor);                
                      break;
                  case 4://mostrar
                      la.listarCorredores(listaCorredores);
                      break;
                  case 5://salvar 
                      lf.guardarDatosCSV(listaCorredores, FICHERO);
                      break;
                  case 6://ordenar
                      break;
                  case 7://cargar
                         listaCorredores=lf.leerFicheroCSV(FICHERO);
                      if(listaCorredores!=null){
                          System.out.println("El fichero se ha cargado");
                      }else{
                          System.out.println("El fichero está vacío");
                      }
                      break;
                  case 8:   
               System.out.println("salir\n");
                      break;
                  default :
                      System.out.println("\nError repita  (1-8).\n");
                      break;
              
                      }             
          }while(opcion!=8);    
    }
}
