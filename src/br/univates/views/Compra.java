package br.univates.views;

import br.univates.entity.Aviao;
import br.univates.entity.Cliente;
import br.univates.entity.Passagem;
import br.univates.entity.Session;
import br.univates.entity.Voo;
import br.univates.persistencia.Dao;
import br.univates.persistencia.clauses.Where;
import br.univates.persistencia.query.Insert;
import br.univates.persistencia.query.Select;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import br.univates.views.comprar.util.*;
import java.nio.channels.SeekableByteChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Compra extends javax.swing.JFrame {

    AssentosUtil mapaAssentos = new AssentosUtil();
    PassagensUtil mapaPassagens = new PassagensUtil();
    Voo voo = null;
    Aviao aviao = null;
    Cliente cliente = null;
    ArrayList<Passagem> passagens = new ArrayList();

    private PassagensTableModel tModel = new PassagensTableModel();
    

    public Compra() {
        //Excluir!!!!
//        Voo v = new Voo();
//        v.setAvioes_id(2);
//        v.setChegada(32);
//        v.setData_voo("2017-03-02");
//        v.setHorario_chegada("2017-03-02 09:46");
//        v.setHorario_partida("2017-03-02 01:16");
//        v.setId(16);
//        v.setValor(77.00);
//        v.setPartida(4);
//        Session.setVoo(v);
//
//        Aviao a = new Aviao();
//        a.setId(2);
//        a.setNome("B737-700");
//        a.setDescricao("");
//        a.setCompanhias_aereas_id(1);
//        a.setNumero_assentos(160);
//        a.setValor_aviao(681.00);
//        Session.setAviao(a);
//        
//        Cliente c = new Cliente();
//        c.setId(2);
//        c.setIdade(18);
//        c.setNome("Carlos");
//        c.setSenha("12345");
//        c.setSexo('M');
//        c.setUsuario("Carlao69");
//        Session.setCliente(c);
        //Excluir!!!  
        inicializa();
    }
    
    public void inicializa(){
        voo = Session.getVoo();
        aviao = Session.getAviao();
        cliente = Session.getCliente();

        initComponents();
        initAssentos();

        tabela.setModel(tModel);
        checaAssentos();
        
        jtCliente.setText(cliente.getNome());
        jtVoo.setText(voo.getId() + "");
        jtValorTotal.setText("R$: 0,00");
        jtNPassagens.setText("0");
    }
    
    private void limpa() {
        painelA.removeAll();
        painelB.removeAll();
        painelC.removeAll();
        
        mapaAssentos = new AssentosUtil();
        mapaPassagens = new PassagensUtil();
        tModel.limpa();
        
        jtCliente.setText("");
        jtVoo.setText("");
        jtValorTotal.setText("R$: 0,00");
        jtNPassagens.setText("0");
    }
    
    private void checaAssentos() {

        ArrayList<String[]> poltronasOcupadas = Dao.get(new Select(
                "passagens",
                new String[]{"poltronas"},
                new Where("voo_id = " + voo.getId())));

        for (int i = 0; i < poltronasOcupadas.size(); i++) {
            JCheckBox poltrona = mapaAssentos.getAssentoAt(Integer.parseInt(poltronasOcupadas.get(i)[0]));
            poltrona.setSelected(true);
            poltrona.setEnabled(false);
        }
    }

    private void initAssentos() {
        int quantidade = aviao.getNumero_assentos();
        int cont = 1;
        int classC = (quantidade / 2);
        int classB = ((classC / 2) + 10);
        int classA = ((classC / 2) - 10);
        initPaineis(classC, classB, classA);
        for (int i = 1; i <= classA; i++) {
            JCheckBox assento = new JCheckBox();
            assento.setText(cont + "");
            initActionCheckBox(assento);
            mapaAssentos.add(cont, assento, 1);
            painelA.add(assento);
            cont++;
        }
        for (int i = 1; i <= classB; i++) {
            JCheckBox assento = new JCheckBox();
            assento.setText(cont + "");
            initActionCheckBox(assento);
            mapaAssentos.add(cont, assento, 2);
            painelB.add(assento);
            cont++;
        }
        for (int i = 1; i <= classC; i++) {
            JCheckBox assento = new JCheckBox();
            assento.setText(cont + "");
            initActionCheckBox(assento);
            mapaAssentos.add(cont, assento, 3);
            painelC.add(assento);
            cont++;
        }

    }

    private void initPaineis(int classC, int classB, int classA) {
        painelA.setLayout(new java.awt.GridLayout((classA / 10), 10));
        painelB.setLayout(new java.awt.GridLayout((classB / 10), 10));
        painelC.setLayout(new java.awt.GridLayout((classC / 10), 10));
    }

    private double getValor(int id) {
        int categoria = mapaAssentos.getCetegoriasId(id);

        double taxa = 0;
        double valor = (aviao.getValor_aviao() + voo.getValor());

        ArrayList<String[]> array = Dao.get(new Select(
                "categorias",
                new String[]{"taxa"},
                new Where("id = " + categoria)));

        taxa = Double.parseDouble(array.get(0)[0]) / 100;

        valor = valor + (taxa * valor);

        return valor;

    }

    public Passagem geradorDePassagem(JCheckBox assento) {
        Integer numeroPoltrona = Integer.parseInt(assento.getText());
        double valor = getValor(numeroPoltrona);

        Passagem passagem = new Passagem();
        passagem.setCliente_id(cliente.getId());
        passagem.setPoltronas(numeroPoltrona);
        passagem.setValidade(voo.getData_voo());
        passagem.setVoo_id(voo.getId());
        passagem.setValor(getValor(numeroPoltrona));
        passagem.setCategorias_id(mapaAssentos.getCetegoriasId(numeroPoltrona));

        return passagem;
    }
    
    

    private void initActionCheckBox(JCheckBox assento) {
        assento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (assento.isSelected()) {
                    Passagem passagem = geradorDePassagem(assento);
                    mapaPassagens.add(passagem.getPoltronas(), passagem);
                } else {
                    Integer id = Integer.parseInt(assento.getText());
                    mapaPassagens.remove(id);
                }
                tModel.limpa();
                tModel.addPassagens(mapaPassagens.listaDePassagens());

                double valorTotal = 0.0;
                int numeroPassagens = 0;
                for (Integer i : mapaPassagens.getPassagens().keySet()) {
                    valorTotal += mapaPassagens.getPassagens().get(i).getValor();
                    numeroPassagens++;
                }

                jtValorTotal.setText("R$: " + (String.format("%.2f", valorTotal)).replace(".", ","));
                jtNPassagens.setText(numeroPassagens + "");
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        painelAS = new javax.swing.JScrollPane();
        painelA = new javax.swing.JPanel();
        painelBS = new javax.swing.JScrollPane();
        painelB = new javax.swing.JPanel();
        painelCS = new javax.swing.JScrollPane();
        painelC = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtCliente = new javax.swing.JTextField();
        jtVoo = new javax.swing.JTextField();
        jtValorTotal = new javax.swing.JTextField();
        jtNPassagens = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(827, 640));
        setResizable(false);

        jButton1.setText("Finalizar Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecione o assento desejado:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Classe A:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Classe B:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Classe C:");

        javax.swing.GroupLayout painelALayout = new javax.swing.GroupLayout(painelA);
        painelA.setLayout(painelALayout);
        painelALayout.setHorizontalGroup(
            painelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        painelALayout.setVerticalGroup(
            painelALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        painelAS.setViewportView(painelA);

        javax.swing.GroupLayout painelBLayout = new javax.swing.GroupLayout(painelB);
        painelB.setLayout(painelBLayout);
        painelBLayout.setHorizontalGroup(
            painelBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
        );
        painelBLayout.setVerticalGroup(
            painelBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        painelBS.setViewportView(painelB);

        javax.swing.GroupLayout painelCLayout = new javax.swing.GroupLayout(painelC);
        painelC.setLayout(painelCLayout);
        painelCLayout.setHorizontalGroup(
            painelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
        );
        painelCLayout.setVerticalGroup(
            painelCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        painelCS.setViewportView(painelC);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jLabel5.setText("Cliente:");

        jLabel6.setText("Vôo:");

        jLabel7.setText("Valor Total:");

        jLabel8.setText("Nº. Passagens:");

        jtCliente.setEditable(false);

        jtVoo.setEditable(false);

        jtValorTotal.setEditable(false);

        jtNPassagens.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(338, 338, 338))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painelCS)
                    .addComponent(painelAS, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelBS, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 960, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtValorTotal)
                        .addComponent(jtNPassagens, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtCliente)
                        .addComponent(jtVoo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAS, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelCS, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtVoo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNPassagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (cliente != null) {
            for (Integer i : mapaPassagens.getPassagens().keySet()) {
                Dao.set(new Insert(mapaPassagens.getPassagens().get(i)));
                JOptionPane.showMessageDialog(rootPane, "Comrpa efetuada com sucesso");
                limpa();
            }
        }else{
           JOptionPane.showMessageDialog(rootPane, "É preciso estar logado para comprar"); 
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtCliente;
    private javax.swing.JTextField jtNPassagens;
    private javax.swing.JTextField jtValorTotal;
    private javax.swing.JTextField jtVoo;
    private javax.swing.JPanel painelA;
    private javax.swing.JScrollPane painelAS;
    private javax.swing.JPanel painelB;
    private javax.swing.JScrollPane painelBS;
    private javax.swing.JPanel painelC;
    private javax.swing.JScrollPane painelCS;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}
