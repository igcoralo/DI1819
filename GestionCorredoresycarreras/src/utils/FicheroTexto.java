
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class FicheroTexto {
    //atributos 
    private File fichero;
    private PrintWriter pw;
    private BufferedReader br;
//constructor 

    public FicheroTexto(File fichero) {
        this.fichero = fichero;
    }
 //abrir fichero
     public void abrirFicheroEscritor(boolean anadir) {
        try {
            pw = new PrintWriter(new FileWriter(fichero, anadir), true);
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException e) {
            System.out.println("No se pudo acceder al fichero.");
        }
    }
    public void abrirFicheroLector(){
    try{
    br = new BufferedReader(new FileReader(fichero));
    }catch (FileNotFoundException e) {
            System.out.println("El fichero no existe.");
        }
    
    }
    public void anadir() throws IOException {
        pw.flush();
        pw.close();
        try {
            pw = new PrintWriter(new FileWriter(fichero, true), true);
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException e) {
            System.out.println("No se pudo acceder al fichero.");
        }
    }
    //cerrar escritor
      public void cerrarFicheroEscritor() {
        pw.flush();
        pw.close();
    }
    //cerrar lector
       public void cerrarLector() {
        try {
            br.close();
        } catch (IOException e) {
            System.out.println("No se ha podido cerrar el fichero.");
        }
    }
      //grabar en ascci
        public void printAscii(int ascii) {
        pw.write(ascii);
        pw.flush();
        }
       //grabar como caracteres el valor string
         public void print(String x) {
        pw.print(x);
        pw.flush();
    }
         //grabar caracteres
         public void print(char x) {
        pw.print(x);
        pw.flush();
         }
         //grabar double
          public void print(double x) {
        pw.print(x);
        pw.flush();
    }

          //grabar float
          public void print(float x) {
        pw.print(x);
        pw.flush();
    }
          //grabar long
            public void print(long x) {
        pw.print(x);
        pw.flush();
    }
            //grabar int 
            public void print(int x) {
        pw.print(x);
        pw.flush();
    }
            //grabar short
             public void print(short x) {
        pw.print(x);
        pw.flush();
    }
             //grabar byte
             public void print(byte x) {
        pw.print(x);
        pw.flush();
    }
     public void print(boolean x) {
        pw.print(x);
        pw.flush();
    }
     public void println(String x) {
        pw.println(x);
        pw.flush();
    }
      public void println(char x) {
        pw.println(x);
        pw.flush();
    }
       public void println(double x) {
        pw.println(x);
        pw.flush();
    }
       public void println(float x) {
        pw.println(x);
        pw.flush();
    }
       public void println(long x) {
        pw.println(x);
        pw.flush();
    }
          public void println(int x) {
        pw.println(x);
        pw.flush();
    }
          public void println(short x) {
        pw.println(x);
        pw.flush();
    }
           public void println(byte x) {
        pw.println(x);
        pw.flush();
    }
            public void println(boolean x) {
        pw.println(x);
        pw.flush();
    }
            //leer
             public int contarFilas() {
        abrirFicheroLector();
        int contador = 0;
        while (leerString() != null) {
            contador++;
        }
        cerrarLector();
        return contador;
    }
             public String leerString() {
        String linea = "";
        try {
            linea = br.readLine();
            return linea;
        } catch (IOException e) {
            System.out.println("Error al leer la linea del fichero.");
            return null;
        }
    }
             public char leerChar() {
        char c;
        try {
            c = (char) br.read();
            return c;
        } catch (IOException e) {
            System.out.println("Error al leer el caracter.");
            return '\0';
        }
    }
             public int leerInt() {
        int num;
        try {
            num = Integer.parseInt(br.readLine());
            return num;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al leer el entero.");
            return Integer.MIN_VALUE;
        }
    }
              public short leerShort() {
        short numShort;
        try {
            numShort = Short.parseShort(br.readLine());
            return numShort;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al leer el número.");
            return Short.MIN_VALUE;
        }
    }
        public byte leerByte() {
        byte numByte;
        try {
            numByte = Byte.parseByte(br.readLine());
            return numByte;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al leer el número");
            return Byte.MIN_VALUE;
        }
    }
public long leerLong() {
        long numLong;
        try {
            numLong = Long.parseLong(br.readLine());
            return numLong;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error al leer el número");
            return Long.MIN_VALUE;
        }
    }
  public float leerFloat() {
        float numFloat = 0;
        try {
            numFloat = Float.parseFloat(br.readLine());
            return numFloat;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al leer el número.");
            return Float.MIN_VALUE;
        }
    }
    public double leerDouble() {
        double numDouble = 0;
        try {
            numDouble = Double.parseDouble(br.readLine());
            return numDouble;
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Error al leer el número.");
            return Double.MIN_VALUE;
        }
    }
    //Arrays
    public String[][] guardarCSVEnArray(String separadorTokens) {
        String[][] array;
        array = new String[contarFilas()][];
        StringTokenizer token;
        abrirFicheroLector();
        for (int fila = 0; fila < array.length; fila++) {
            token = new StringTokenizer(leerString(), separadorTokens);
            array[fila] = new String[token.countTokens()];
            for (int posicion = 0; posicion < array[fila].length; posicion++) {
                array[fila][posicion] = token.nextToken();
            }
        }
        cerrarLector();
        return array;
    }
     public List guardarLineasCSV() {
        LinkedList coleccion = new LinkedList();
        abrirFicheroLector();
        String linea;
        while ((linea = leerString()) != null) {
            coleccion.add(linea);
        }
        cerrarLector();
        return coleccion;
    }
     public List guardarTokensCSV(String separador) {
        LinkedList coleccion = new LinkedList();
        abrirFicheroLector();
        String linea;
        while ((linea = leerString()) != null) {
            StringTokenizer tokenizador = new StringTokenizer(linea, separador);
            while (tokenizador.hasMoreTokens()) {
                coleccion.add(tokenizador.nextToken().trim());
            }
        }
        cerrarLector();
        return coleccion;
    }
        public boolean guardarColeccionCSV(Collection coleccion, String separador, int elementosPorLinea) {
        int contador = 0;
        for (Object objeto : coleccion) {
            print(objeto.toString() + separador);
            contador++;
            if ((contador % elementosPorLinea) == 0) {
                print("\n");
            }
        }
        return false;
    }

    }


