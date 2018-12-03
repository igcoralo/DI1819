
package interfaz.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Participante;


public class TableModelParticipantes extends AbstractTableModel {

    private List<Participante> listaParticipantes;
    private final String[] columnas = {"DNI", "Nombre", "Dorsal", "Timepo"};

    public TableModelParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return listaParticipantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listaParticipantes.get(row).getCorredor().getDni();
            case 1:
                return listaParticipantes.get(row).getCorredor().getNombre();
            case 2:
                return listaParticipantes.get(row).getDorsal();
            case 3:
                return listaParticipantes.get(row).getTimepoSegundos();
        }

        return null;
    }

}

