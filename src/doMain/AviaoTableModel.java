package doMain;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AviaoTableModel extends AbstractTableModel {
    
    private static final int COL_ID = 0;
    private static final int COL_X = 1;
    private static final int COL_Y = 2;
    private static final int COL_R = 3;
    private static final int COL_A = 4;
    private static final int COL_V = 5;
    private static final int COL_D = 6;
    
    private final String[] colunas = new String[] {"ID", "X", "Y", "R", "A", "V", "D"};
    private List<Airplane> linhas;
    
    public AviaoTableModel() {
        this.linhas = new ArrayList<>();
    }
    
    public AviaoTableModel(List<Airplane> lista) {
        this.linhas = lista;
    }

    @Override
    public int getRowCount() {
        return this.linhas.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
 
    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == COL_ID) {
            return Integer.class;
        }
        return Double.class;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    @Override
    public Object getValueAt(int row, int column) {
        Airplane m = linhas.get(row);
 
        switch (column) {
            case COL_ID:
                return m.getId();
            case COL_X:
                return m.getX();
            case COL_Y:
                return m.getY();
            case COL_R:
                return m.getRaio();
            case COL_A:
                return m.getAngulo();
            case COL_V:
                return m.getVelocidade();
            case COL_D:
                return m.getDirecao();
            default:
                break;
        }
        
        return 0.0;
    }
 
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Airplane u = linhas.get(row);
        
        switch (column) {
            case COL_ID:
                u.setId((Integer) aValue);
                break;
            case COL_X:
                u.setX((float) aValue);
                break;
            case COL_Y:
                u.setY((float) aValue);
                break;
            case COL_R:
                u.setRaio((float) aValue);
                break;
            case COL_A:
                u.setAngulo((float) aValue);
                break;
            case COL_V:
                u.setVelocidade((float) aValue);
                break;
            case COL_D:
                u.setDirecao((float) aValue);
                break;
            default:
                break;
        }
    }
    
    public Airplane getAviao(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
 
    public void addAviao(Airplane aviao) {
        aviao.setId(getProximoCodigo());
        linhas.add(aviao);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    public void atualizar() {
        fireTableRowsInserted(0, linhas.size() - 1);
    }
 
    public void removeAviao(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    private int getProximoCodigo() {
        int proximoCodigo = 1;
        
        if (linhas.size() == 0) {
            return proximoCodigo;
        }
        
        for (Airplane a : linhas) {
            if (a.getId() >= proximoCodigo) {
                proximoCodigo = a.getId() + 1;
            }
        }
        
        return proximoCodigo;
    }
    
}
