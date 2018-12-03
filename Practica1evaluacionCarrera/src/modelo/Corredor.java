
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Corredor implements Comparable<Corredor>, Serializable {
  //atributos
    String dni;
    String nombre;
    String telefono;
    String direccion;
    Date FehcaNacimiento;
//constructor
    public Corredor(String dni, String nombre, String telefono, String direccion, Date FehcaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.FehcaNacimiento = FehcaNacimiento;
    }
    
//set y get
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFehcaNacimiento() {
        return FehcaNacimiento;
    }

    public void setFehcaNacimiento(Date FehcaNacimiento) {
        this.FehcaNacimiento = FehcaNacimiento;
    }
//toString
    @Override
    public String toString() {
        return "Corredor{" + "dni=" + dni + ", nombre=" + nombre + '}';
    }
//metodos 
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) { 
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Corredor other = (Corredor) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Corredor t) {
        // Compara segun su fecha de nacimeinto para ordenarlos por edad.
        return this.FehcaNacimiento.compareTo(t.getFehcaNacimiento());
    }
     
    
}
