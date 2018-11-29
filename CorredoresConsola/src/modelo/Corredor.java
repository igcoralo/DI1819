package modelo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Corredor implements Comparable<Corredor> {
//atributos
   private String nombre;
   private String dni;
   private String fechaNacimiento; 
   private String direccion;
   private String telefono;
   private String dorsal;
   private List<Corredor>listaCorredores=new ArrayList<Corredor>();
   
//constructor
   //basico
   public Corredor() {
    }
   //complejo
    public Corredor(String nombre, String dni, String fechaNacimiento, String direccion, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    //metodo tocompare
     @Override
    public int compareTo(Corredor c) {
         return this.fechaNacimiento.compareTo(c.getFechaNacimiento());
    }
    //metodos set y get

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public List<Corredor> getListaCorredores() {
        return listaCorredores;
    }

    //toString  

    @Override
    public String toString() {
        return "Corredor{" + "nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", dorsal=" + dorsal + ", listaCorredores=" + listaCorredores + '}';
    }
}  
    
    
    
    
    

