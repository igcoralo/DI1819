
package DTO;
import utils.Utiles;
import utils.Utiles.SDf;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Corredor implements Serializable, Comparable<Corredor>, Cloneable {
    //atributos
    private String nombre;
    private String dni;
    private Date fechanacimiento;
    private String direccion;
    private String telefono;
    public static final String[] DatosCorredor={"nombre", "DNI", "Fecha de nacimento", "Direccion", "Telefono"};
   
    //constructor por defecto
    public Corredor() {
    }
    //constructor con parametros

    public Corredor(String nombre, String dni, Date fechanacimiento, String direccion, String telefono) {
       if(dni ==null){
       throw new IllegalArgumentException("DNI obligatorio");
       }
        this.nombre = nombre;
        this.dni = dni;
        this.fechanacimiento = fechanacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    //array
    public String[] toArray() {
        String array[] = new String[5];
        array[0] = this.nombre;
        array[1] = this.dni;
        array[2] = Utiles.SDf.format(this.fechanacimiento);
        array[3] = this.direccion;
        array[4] = this.telefono;
        return array;
    }
    //metodos set y get

   public String[] getCorredor() {
        String[] datos = {this.dni, this.nombre, SDf.format(this.fechanacimiento), this.direccion, this.telefono};
        return datos;
    }
       

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

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
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
    //metodo para evitar duplicacion del dni
@Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.dni);
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
        if(getClass()!=obj.getClass()){
        return false;
        }
        //comparo un corredor con otro
     final Corredor other =(Corredor) obj;
     return Objects.equals(this.dni,other.dni);
     }

    //metodo para  realizar una ordenación natural en una cadena
    @Override
    public int compareTo(Corredor c) {
        return this.dni.compareToIgnoreCase(c.getDni());
                }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clon = null;
        try {
            clon = super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error al clonar");
        }
        return clon;
    } 

    @Override
    public String toString() {
        return "Corredor{" + "nombre=" + nombre + ", dni=" + dni + ", fechanacimiento=" + fechanacimiento + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
}
