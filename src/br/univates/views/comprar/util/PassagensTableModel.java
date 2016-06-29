package br.univates.views.comprar.util;

import br.univates.entity.Passagem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;


public class PassagensTableModel extends AbstractTableModel{
    
    String [] colunas = {"Poltrona","Classe","Valor"};
    List<Passagem> passagens = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return passagens.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException();
        }
        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return passagens.get(rowIndex).getPoltronas();
            case 1:
                switch (passagens.get(rowIndex).getCategorias_id()){
                    case 1: 
                        return "A";
                    case 2:
                        return "B";
                    case 3:
                        return "C";
                    default:
                        return "E";
                }
            case 2:
                return "R$: " + (passagens.get(rowIndex).getValor()+"").replace(".", ",");
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public void addPassagens(List<Passagem> passagens){
        this.passagens.addAll(passagens);
        fireTableRowsInserted(passagens.size() - 1, passagens.size() - 1);
    }
    
    public void limpa(){
        this.passagens.clear();
        fireTableRowsDeleted(passagens.size() - 1, passagens.size() - 1);
    }
    
}
