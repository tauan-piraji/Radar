package doMain;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.util.ArrayList;
import java.util.List;

public class AirPlaneTableModel extends AbstractTableModel {

    private final String[] colunas = new String[] {"CB", "ID", "X", "Y", "R", "A", "V", "D"};
    private List<Airplane> airplaneList;

    public AirPlaneTableModel() {
        this.airplaneList = new ArrayList<>();
    }

    public AirPlaneTableModel(List<Airplane> lista) {
        this.airplaneList = lista;
    }

    @Override
    public int getRowCount() {
        return this.airplaneList.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0){
            return true;
        }
        return false;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex!=0){
            return String.class;
        }else{
            return Boolean.class;
        }
    }


    @Override
    public Object getValueAt(int row, int column) {
        Airplane m = airplaneList.get(row);

        switch (column) {
            case 0:
                return m.isCheckBoxSelected();
            case 1:
                return m.getId();
            case 2:
                return m.getCordX();
            case 3:
                return m.getCordY();
            case 4:
                return m.getRaio();
            case 5:
                return m.getAngulo();
            case 6:
                return m.getVelocidade();
            case 7:
                return m.getDirecao();
            default:
                System.err.println("Índice inválido para propriedade do bean Usuario.class");
                break;
        }

        return 0.0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Airplane Aeronave = airplaneList.get(rowIndex);
        try{
            switch (columnIndex) {
                case 0:
                    Aeronave.setCheckBox(Boolean.valueOf(aValue.toString()));
                case 1:
                    Aeronave.setId(Integer.parseInt(aValue.toString()));
                case 2:
                    Aeronave.setCordX(Float.parseFloat(aValue.toString()));
                case 3:
                    Aeronave.setCordY(Float.parseFloat(aValue.toString()));
                case 4:
                    Aeronave.setRaio(Float.parseFloat(aValue.toString()));
                case 5:
                    Aeronave.setAngulo(Float.parseFloat(aValue.toString()));
                case 6:
                    Aeronave.setVelocidade(Float.parseFloat(aValue.toString()));
                case 7:
                    Aeronave.setDirecao(Float.parseFloat(aValue.toString()));

                default:
                    System.err.println("Índice da coluna inválido");
            }
        }catch (NumberFormatException e){
            System.out.printf(e.getMessage());
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Airplane getAviao(int indiceLinha) {
        return airplaneList.get(indiceLinha);
    }

    public void addAviao(Airplane aviao) {
        if(aviao.getId() == null) {
            aviao.setId(getProximoCodigo());
        }
        airplaneList.add(aviao);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeAviao(int indiceLinha) {
        airplaneList.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    private int getProximoCodigo() {
        int proximoCodigo = 1;

        if (airplaneList.size() == 0) {
            return proximoCodigo;
        }

        for (Airplane a : airplaneList) {
            if (a.getId() >= proximoCodigo) {
                proximoCodigo = a.getId() + 1;
            }
        }

        return proximoCodigo;
    }

    public void addCheckBox(int column, JTable table) {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);
        tableColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
        tableColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public boolean isSelected(int row, int column, JTable table) {
        return table.getValueAt(row, column) != null;
    }

}