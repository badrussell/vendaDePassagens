package br.univates.libraries;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class Util {

    //Metodo permite editar as JTField
    public static void edicaoJTField(boolean condicao, JTextField JT1, JTextField JT2, JTextField JT3, JTextField JT4, JTextField JT5, JTextField JT6, JTextField JT7, JTextField JT8, JTextField JT9, JTextField JT10) {
        Util.setEditableJText(condicao, JT1);
        Util.setEditableJText(condicao, JT2);
        Util.setEditableJText(condicao, JT3);
        Util.setEditableJText(condicao, JT4);
        Util.setEditableJText(condicao, JT5);
        Util.setEditableJText(condicao, JT6);
        Util.setEditableJText(condicao, JT7);
        Util.setEditableJText(condicao, JT8);
        Util.setEditableJText(condicao, JT9);
        Util.setEditableJText(condicao, JT10);
    }

    //Metodo permite editar as JTField
    public static void edicaoJTField(boolean condicao, JTextField JT1, JTextField JT2, JTextField JT3, JTextField JT4, JTextField JT5, JTextField JT6) {
        Util.setEditableJText(condicao, JT1);
        Util.setEditableJText(condicao, JT2);
        Util.setEditableJText(condicao, JT3);
        Util.setEditableJText(condicao, JT4);
        Util.setEditableJText(condicao, JT5);
        Util.setEditableJText(condicao, JT6);
    }

    //Metodo permite editar as JTField
    public static void edicaoJTField(boolean condicao, JTextField JT1, JTextField JT2, JTextField JT3, JTextField JT4, JTextField JT5) {
        Util.setEditableJText(condicao, JT1);
        Util.setEditableJText(condicao, JT2);
        Util.setEditableJText(condicao, JT3);
        Util.setEditableJText(condicao, JT4);
        Util.setEditableJText(condicao, JT5);
    }

    //Metodo permite editar as JTField
    public static void edicaoJTField(boolean condicao, JTextField JT1, JTextField JT2, JTextField JT3) {
        Util.setEditableJText(condicao, JT1);
        Util.setEditableJText(condicao, JT2);
        Util.setEditableJText(condicao, JT3);
    }

    //Metodo permite editar as JTField
    public static void edicaoJTField(boolean condicao, JTextField JT1, JTextField JT2, JTextField JT3, JTextField JT4) {
        Util.setEditableJText(condicao, JT1);
        Util.setEditableJText(condicao, JT2);
        Util.setEditableJText(condicao, JT3);
        Util.setEditableJText(condicao, JT4);
    }

    //Passando a condição de true/false ele habilita ou desabilita a edição das JTField
    public static void setEditableJText(boolean condicao, JTextField jT1) {
        jT1.setEditable(condicao);
    }

    //Passando as condições ele deixa a posição da tabela centralizada
    public static void posicaoTableCentralizado(JTable tabela, int coluna) {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(coluna).setCellRenderer(centralizado);
    }

    public static void mascaraData(JFormattedTextField campo) throws ParseException {

        MaskFormatter m = new MaskFormatter("##/##/####");
        m.setValidCharacters("0123456789");
        campo.setColumns(6);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);
    }

    public static void mascaraCpf(JFormattedTextField campo) throws ParseException {

        MaskFormatter m = new MaskFormatter("###.###.###-##");
        m.setValidCharacters("0123456789");
        campo.setColumns(11);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);
    }

    public static void mascaraCnpj(JFormattedTextField campo) throws ParseException {

        MaskFormatter m = new MaskFormatter("##.###.###/####-##");
        m.setValidCharacters("0123456789");
        campo.setColumns(14);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);
    }

    public static void mascaraPlaca(JFormattedTextField campo) throws ParseException {

        MaskFormatter m = new MaskFormatter("UUU-####");
        m.setValidCharacters("0123456789abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVXYWZ");
        campo.setColumns(7);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);

    }

    public static void mascaraTelefone(JFormattedTextField campo) throws ParseException {

        MaskFormatter m = new MaskFormatter("(##) ####-####");
        m.setValidCharacters("0123456789");
        campo.setColumns(10);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);

    }

    public static void mascaraNumeros(JFormattedTextField campo, String formato, int nCaracteres) throws ParseException {

        MaskFormatter m = new MaskFormatter(formato);
        m.setValidCharacters("0123456789");
        //campo.setColumns(nCaracteres);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);

    }

    public static void mascaraLetras(JFormattedTextField campo, String formato, int nCaracteres) throws ParseException {

        MaskFormatter m = new MaskFormatter(formato);
        m.setValidCharacters(" abcdefghiklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVXYWZ/-'");
        campo.setColumns(nCaracteres);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);

    }

    public static void mascaraLetrasNumeros(JFormattedTextField campo, String formato, int nCaracteres) throws ParseException {

        MaskFormatter m = new MaskFormatter(formato);
        m.setValidCharacters(" abcdefghiklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVXYWZ0123456789");
        campo.setColumns(nCaracteres);
        campo.setFormatterFactory(null);
        campo.setFormatterFactory(new DefaultFormatterFactory(m));
        campo.setValue(null);

    }

    //Retira espaços em brancos desnecessarios
    public static String retiraEspacos(String palavra) {

        String[] vet = palavra.split(" ");
        String[] vet2 = new String[vet.length];
        for (int i = 0; i < vet.length; i++) {
            vet2[i] = vet[i].replaceAll(" ", "");
        }
        palavra = "";
        for (int i = 0; i < vet.length; i++) {
            palavra = palavra + vet2[i] + " ";
        }

        return palavra;

    }

    public static Date formataData(String dataT) {

        if (dataT.replace("/", "").trim().equals("")) {
            return null;
        }

        String[] data = dataT.split("/");
        int ano = Integer.parseInt(data[2]) - 1900;
        int mes = Integer.parseInt(data[1]) - 1;
        int dia = Integer.parseInt(data[0]);
        java.sql.Date newDate = new java.sql.Date(ano, mes, dia);

        return newDate;
    }

    public static void posicaoTableEsquerda(JTable tabela, int coluna) {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tabela.getColumnModel().getColumn(coluna).setCellRenderer(esquerda);
    }

    public static void posicaoTableDireita(JTable tabela, int coluna) {
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        tabela.getColumnModel().getColumn(coluna).setCellRenderer(direita);
    }

    public static void zebraTable(JTable tabela) {
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Color myColor = new Color(240, 240, 240);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.white : myColor);
                }
                return c;
            }
        ;
    }

    );
    }
    
    public static String ajustaDataDMA(String data) {
        String dataFormatada = null;
        try {
            java.util.Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static boolean validarDataDMA(int d, int m, int a) {
        boolean correto = true;
        try {
            int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (m < 1 || m > 12) {
                correto = false;
            } else if (a < 1500 || a > 2500) {
                correto = false;
            } else {
                // valida o dia
                if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                    dias[1] = 29;
                }
                if (d < 1 || d > dias[m - 1]) {
                    correto = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            correto = false;
        }
        return correto;
    }

    public static boolean verificaNumeroInt(String s) {

        char[] c = s.toCharArray();
        boolean d = true;
        for (int i = 0; i < c.length; i++) // verifica se o char não é um dígito
        {
            if (!Character.isDigit(c[i])) {
                d = false;
                break;
            }
        }
        return d;
    }

    public static boolean isNumber(String string) {

        string = string.replaceAll("[,.]", "");
        char[] c = string.toCharArray();
        boolean result = true;
        for (int i = 0; i < c.length; i++) { // verifica se o char não é um dígito

            if (!Character.isDigit(c[i])) {
                result = false;
                break;
            }

        }

        return result;
    }

    public static boolean validarDataFormatada(String dataComFormato) {
        try {
            String[] data = dataComFormato.split("/");
            return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public static String returnDate() {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();
        calendar.setTime(date);
        return "" + out.format(calendar.getTime());
    }

    public static boolean validaCombobox(String cb) {

        if (cb.equals("<>") || cb.equals("Selecione")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validaJFormattedText(JFormattedTextField jt) {

        String dados = jt.getText().replaceAll("[.-/()]", "").replace("-", "");
        dados = retiraEspacos(dados);
        dados = dados.trim();

        if (dados.equals("") || dados.equals(" ")) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean validaJText(JTextField jt) {

        String dados = retiraEspacos(jt.getText());

        if (dados.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    //Método irá buscas os dados para popular a tabela
    public static void atualizaTabela(JTable tabela, ArrayList<String[]> list) {
        //Criação da tabela
        String[] nomeColunas = {"Cód.", "Descrição"};
        tabela.setModel(new DefaultTableModel(list.toArray(new String[list.size()][]), nomeColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        //Define o tipo de seleção da tabela
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Define o tamanho das colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        for (int i = 0; i < nomeColunas.length; i++) {
            Util.posicaoTableCentralizado(tabela, i);
        }
    }

    //Método irá buscas os dados para popular a tabela
    public static void atualizaTabela(JTable tabela, String[] nomeColunas, ArrayList<String[]> list) {
        //Criação da tabela
        tabela.setModel(new DefaultTableModel(list.toArray(new String[list.size()][]), nomeColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        //Define o tipo de seleção da tabela
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (int i = 0; i < nomeColunas.length; i++) {
            Util.posicaoTableCentralizado(tabela, i);
        }
    }

    //Método irá buscar os dados para popular a tabela utilizando algum filtro
    public static void atualizaTabelaFiltrando(JTable tabela, ArrayList<String[]> list) {
        //Criação da tabela
        String[] nomeColunas = {"Cód", "Descrição"};
        tabela.setModel(new DefaultTableModel(list.toArray(new String[list.size()][]), nomeColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        //Define o tipo de seleção da tabela
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Define o tamanho das colunas
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
        for (int i = 0; i < nomeColunas.length; i++) {
            Util.posicaoTableCentralizado(tabela, i);
        }
    }

    public static void atualizaTabelaDefault(JTable jtable, String[] nomeColunas) {

        jtable.setModel(new DefaultTableModel(null, nomeColunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

    }

    public static String formataPlaca(String placa) {

        String p[] = placa.split("");

        placa = "";
        for (int i = 0; i < p.length; i++) {
            placa += p[i];
            if (i == 2) {
                placa += "-";
            }
        }

        return placa;
    }

}
