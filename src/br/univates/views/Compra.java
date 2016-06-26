package br.univates.views;

import br.univates.entity.Passagem;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import br.univates.views.comprar.util.*;

public class Compra extends javax.swing.JFrame {

    AssentosUtil mapaAssentos = new AssentosUtil();
    PassagensUtil mapaPassagens = new PassagensUtil();
    
    private PassagensTableModel tModel = new PassagensTableModel();

    public Compra() {
        initComponents();
        initAssentos();
        //checaAssentos();
        tabela.setModel(tModel);
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
            .addGap(0, 989, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAS)
            .addComponent(painelBS)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(painelCS, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        checaAssentos();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
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

    private void checaAssentos() {
        //List<Integer> ocupados = dao.getAssentosOcupados();
        //for(Integer i : ocupados){
            //JCheckBox poltrona = mapaAssentos.getAssentoAt(id);
            //poltrona.setEnabled(false);
        //}
        
        for (Integer id : mapaAssentos.getAssentos().keySet()) {
            JCheckBox poltrona = mapaAssentos.getAssentoAt(id);
            if (poltrona.isSelected()) {
                poltrona.setEnabled(false);
            }
        }
    }

    private void initAssentos() {
        //int quantidade = dao.getQuantidadeAviao();
        int quantidade = 160;
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelA;
    private javax.swing.JScrollPane painelAS;
    private javax.swing.JPanel painelB;
    private javax.swing.JScrollPane painelBS;
    private javax.swing.JPanel painelC;
    private javax.swing.JScrollPane painelCS;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    private void initPaineis(int classC, int classB, int classA) {
        painelA.setLayout(new java.awt.GridLayout((classA/10), 10));
        painelB.setLayout(new java.awt.GridLayout((classB/10), 10));
        painelC.setLayout(new java.awt.GridLayout((classC/10), 10));
    }
    
    private double getValor(Integer id) {
        Integer categoria = mapaAssentos.getCetegoriasId(id);
        //double valor = (dao.getValorAviao * dao.getValorVoo);
        if(categoria  == 1){
            //return valor += (valor * (dao.getTaxaCategoria1()));
            return 600;
        }else if(categoria == 2){
            //return valor += (valor * (dao.getTaxaCategoria2()));
            return 500;
        }    
        //return valor += (valor * (dao.getTaxaCategoria3()));
        return 300;
    }
    
    public Passagem geradorDePassagem(JCheckBox assento){
        Integer id = Integer.parseInt(assento.getText());
        double valor = getValor(id);
        Passagem passagem = new Passagem()
                            .setId(id)
                            .setValor(valor)
                            .setValidade(Calendar.getInstance());
        return passagem;
    }
    
    private void initActionCheckBox(JCheckBox assento){
        assento.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if(assento.isSelected()){
                        Passagem passagem = geradorDePassagem(assento);
                        System.out.println(passagem.getId()+" - "+passagem.getValidade().getTime()+" - "+passagem.getValor());
                        mapaPassagens.add(passagem.getId(), passagem);
                    }else{
                        Integer id = Integer.parseInt(assento.getText());
                        mapaPassagens.remove(id);
                    }
                    tModel.limpa();
                    tModel.addPassagens(mapaPassagens.listaDePassagens());
                }

            
         });
    }
}
