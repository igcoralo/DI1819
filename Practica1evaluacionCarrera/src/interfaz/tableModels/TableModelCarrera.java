/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Carrera;
import static modelo.Utils.sdf;

/**
 *
 * @author usuario
 */
public class TableModelCarrera extends AbstractTableModel{
    
    List<Carrera> listaCarreras;
    private final String[] columnas = {"Nombre","Lugar","Maximo Participantes", "Fecha", "Participantes Inscritos"};
    
    public TableModelCarrera(List<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return listaCarreras.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listaCarreras.get(row).getNombre();
            case 1:
                return listaCarreras.get(row).getLugar();
            case 2:
                return listaCarreras.get(row).getMaxParticipante();
            case 3:
                return sdf.format(listaCarreras.get(row).getFecha());
            case 4:
                return listaCarreras.get(row).getParticipantes().size();
        }
        
        return null;
    }
}
