package br.univates.models;

import br.univates.entity.Ofertas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class modeloTabelaOfertas extends AbstractTableModel
{
    private List<Ofertas> linhas;
    private String colunas[] = new String[]{"Nome do Avião","Data","Valor"};
    
    private static final int NOME = 0;
    private static final int DATA = 1;
    private static final int VALOR = 2;

    public modeloTabelaOfertas() {
        this.linhas = new ArrayList<Ofertas>();
    }

    public modeloTabelaOfertas(List<Ofertas> linhas) {
        this.linhas = linhas;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    //Retorna o tipo de dado de cada coluna
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOME:
                return String.class;
            case DATA:
                return String.class;
            case VALOR:
                return Float.class;
            default:
                //Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    //Retorno o conteúdo de uma célula
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Pega o nome referente a linha especificada.
        Ofertas oferta = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                return oferta.getNome();
            case VALOR:
                return oferta.getValor();
            case DATA:
                return oferta.getData();
            default:
                //Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    //Define o conteúdo de uma célula
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Pega o nome referente a linha especificada.
        Ofertas oferta = linhas.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                oferta.setNome((String) aValue);
                break;
            case VALOR:
                oferta.setValor((Float) aValue);
                break;
            case DATA:
                oferta.setData((String) aValue);
                break;
            default:
                //Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); //Notifica a atualização da célula
    }
    
    //Retorna a oferta referente a linha especificada
    public Ofertas getOferta(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    //Adiciona a oferta especificado ao modelo
    public void addOferta(Ofertas oferta) {
        //Adiciona o registro.
        linhas.add(oferta);

        //Pega a quantidade de registros e subtrai 1 para
        //achar o último índice. A subtração é necessária
        //porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        //Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    //Remove o nome da linha especificada.
    public void removeOferta(int indiceLinha) {
        //Remove o registro.
        linhas.remove(indiceLinha);

        //Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    //Adiciona uma lista de nomes no final da lista.
    public void addListaDeOferta(List<Ofertas> ofertas) {
        //Pega o tamanho antigo da tabela, que servirá
        //como índice para o primeiro dos novos registros
        int indice = getRowCount();

        //Adiciona os registros.
        linhas.addAll(ofertas);

        //Notifica a mudança.
        fireTableRowsInserted(indice, indice + ofertas.size());
    }

    //Remove todos os registros.
    public void limpar() {
        //Remove todos os elementos da lista de ofertas.
        linhas.clear();

        //Notifica a mudança.
        fireTableDataChanged();
    }
    
}
