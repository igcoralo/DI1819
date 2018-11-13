
package utils;

//gestiona la transferencia de objetos .abrir antes cerrarlo despues

import java.io.*;







public class FicheroObjetos<T extends Object> {
    //atributos
  private File fichero;
  private ObjectInputStream sio;
  private FileOutputStream sof;
  private ObjectOutputStream soo;
  private ADD ad;
  //constructor

    public FicheroObjetos(File fichero) {
        this.fichero=fichero;
    }
  //metodos 
    //abrir fichero
    public void abrirFicheroLector() {
    try{
    sio= new ObjectInputStream(new FileInputStream(fichero));
    }catch(FileNotFoundException e){
        System.out.println("el fichero no existe");
    }catch(IOException e){
        System.out.println("Error al abrir el fichero:"+e.getMessage());
    }
    }
    
    public void abrirFicheroEscritor(boolean anadir) {
    try{
    sof=new FileOutputStream(fichero,anadir);
    soo=new ObjectOutputStream(sof);
    ad=new ADD(sof);
       }catch(FileNotFoundException e){
        System.out.println("El fichero no existe");
       }catch(IOException e){
        System.out.println("Error al abrir fichero:"+fichero.getName());
       }
    }
    //cerrar fichero
    public void cerrarFicheroLector(){
    try{
    sio.close();
    }catch(IOException e){
        System.out.println("Error al cerrar fichero");
    }
    }
    public void cerrarFicheroEscritor(){
    try{
    sof.close();
    soo.close();
    ad.close();
        }catch(IOException e){
        System.out.println("Error al cerrar fichero");
        }
    }
    //leer un objeto del fichero
    public T leerObjeto() {
    try{
    return(T) sio.readObject();
    }catch(ClassNotFoundException e){
        System.out.println("no se ha encontrado");
        return null;
    }catch (EOFException e){
    return null;
    }catch (IOException e){
    return null;
    }
    }
    //grabar
    public void grabarPrimerObjeto(T x){
    try{
    soo.writeObject(x);
    }catch (IOException e){
        System.out.println("Error al grabar el objeto: "+e.getMessage());
    }
     }
    public void grabarObjeto(T x){
    try{
    ad.writeObject(x);
    } catch (IOException e){
        System.out.println("Error al grabar : "+e.getMessage());
    }
    }
    //transferir
    public void TransferirObjeto(File entrada,File salida) throws IOException{
    FicheroObjetos<T> lector= new FicheroObjetos<>(entrada);
    lector.abrirFicheroLector();
    FicheroObjetos<T> escritor= new FicheroObjetos<>(salida);
    escritor.abrirFicheroEscritor(false);
    T ob=lector.leerObjeto();
    if(ob !=null){
    escritor.grabarPrimerObjeto(ob);
    while((ob=lector.leerObjeto()) !=null){
    escritor.grabarObjeto(ob);
    }
    }
    lector.cerrarFicheroLector();
    escritor.cerrarFicheroEscritor();
    }
    public class ADD extends ObjectOutputStream{
 //constructor
        public ADD(OutputStream os)throws IOException {
        super(os);
        }
        public ADD()throws IOException{
        super();
        }
        
        @Override
        protected void writeStreamHeader()throws IOException{
        }
        
    
    }
}
