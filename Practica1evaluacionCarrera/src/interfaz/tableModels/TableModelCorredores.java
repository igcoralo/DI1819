
package interfaz.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Corredor;
import static modelo.Utils.sdf;


public class TableModelCorredores extends AbstractTableModel{
    
    List<Corredor> listaCorredores;
    private final String[] columnas = {"DNI","Nombre","Telefono", "Direccion", "Fecha Nacimiento"};
    public TableModelCorredores(List<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return listaCorredores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listaCorredores.get(row).getDni();
            case 1:
                return listaCorredores.get(row).getNombre();
            case 2:
                return listaCorredores.get(row).getTelefono();
            case 3:
                return listaCorredores.get(row).getDireccion();
            case 4:
                return sdf.format(listaCorredores.get(row).getFehcaNacimiento()) ;
        }
        
        return null;
    }
    
}

    

