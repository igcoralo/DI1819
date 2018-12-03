
package GestionCarreraConsola.log;

import GestionCarreraConsola.modelo.Corredor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogicaFicheros {
     List<Corredor> corredoresList = new ArrayList<>();
     
     
      public void guardarDatosCSV(List<Corredor> lista,String f){
        
        File fichero = new File(f);
        FileWriter fw=null;
        try {
            BufferedWriter BW=new BufferedWriter(new FileWriter(fichero));
             for(Corredor c: lista){
                  BW.write(c.getNombre()+","+c.getDni()+","+c.getFechaNacimiento()+","+
                         c.getDireccion()+","+c.getTelefono()+","+c.getDorsal()+"\r\n");           
             }
             BW.close();
             
             System.out.println("El fichero ha sido modificado");
            
        } catch (IOException ex) {
            Logger.getLogger(LogicaFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public List<Corredor> leerFicheroCSV(String f){
        Corredor corredor = new Corredor();
        File fichero = new File(f);
        if(fichero.exists()){
            try {
                BufferedReader BR = new BufferedReader(new FileReader(fichero));
                String cadena=BR.readLine();
                while(cadena!=null){
                corredor=tokenizar(cadena);
                corredoresList.add(corredor);
                cadena=BR.readLine();
                }
                BR.close();
            } catch (FileNotFoundException ex) {
                 System.out.println("Fichero no encontrado");
            } catch (IOException ex) {
                Logger.getLogger(LogicaFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }                    
        }else{
            corredoresList=null;
        }
        return corredoresList;
      }
        public Corredor tokenizar(String linea){
        Corredor c=null;
        StringTokenizer token=new StringTokenizer(linea,",");
        while(token.hasMoreTokens()){
            String nombre=token.nextToken();
            String dni=token.nextToken();
            String fecha=token.nextToken();
            String direccion=token.nextToken();
            String telefono=token.nextToken();
            String dorsal=token.nextToken();
            c=new Corredor(nombre, dni, fecha, direccion, telefono);
            c.setDorsal(dorsal);
        }
        return c;
    }
   
}

