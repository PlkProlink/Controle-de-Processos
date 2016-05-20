/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

import br.com.prolink.departamentos.Comercial;
import br.com.prolink.documentos.Documentos;
import br.com.prolink.inicio.Ativador;
import br.com.prolink.inicio.ConexaoStatement;
import br.com.prolink.inicio.TelaPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class InternoComercial extends javax.swing.JInternalFrame {
    /**
     * Creates new form InternoComercial
     */
    public InternoComercial() {
        initComponents();
        carregaCombo();
        btRelatorio.setVisible(false);
        String value = TelaPrincipal.txt_codigo.getText();
        if(value!=null && value!=""){
            comercial(TelaPrincipal.txt_codigo.getText());
            add(TelaPrincipal.txt_codigo.getText());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tbSolicitacao = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btAlerta = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btRelatorio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDkBody = new javax.swing.JDesktopPane();
        jLabel10 = new javax.swing.JLabel();
        jPDepartamento = new javax.swing.JPanel();
        lbTermo = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        lbDiagnose = new javax.swing.JLabel();
        lbGeral = new javax.swing.JLabel();
        lbProposta = new javax.swing.JLabel();
        lbRequisicao = new javax.swing.JLabel();
        lbTaxa = new javax.swing.JLabel();
        lbOS = new javax.swing.JLabel();
        lbDeposito = new javax.swing.JLabel();
        lbPesquisa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbRecebimento = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(860, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        tbSolicitacao.setBackground(new java.awt.Color(250, 250, 250));
        tbSolicitacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aguardando Solicitação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbSolicitacao);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setText("Gerar O.S");

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Requisição de Documentos:");

        jButton1.setText("Visualizar Tela");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Taxa de Implantação:");

        jButton2.setText("Visualizar Tela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setText("Recebimento de Depósito:");

        btAlerta.setText("Gerar Alerta");
        btAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlertaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel17.setText("Pesquisa de Certidões:");

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel18.setText("Termo de Responsabilidade:");

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel19.setText("Gravar Senhas Fiscais:");

        btRelatorio.setText("Relatório");
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Documentos:");

        jDkBody.setBackground(new java.awt.Color(250, 250, 250));
        jDkBody.setPreferredSize(new java.awt.Dimension(500, 245));

        javax.swing.GroupLayout jDkBodyLayout = new javax.swing.GroupLayout(jDkBody);
        jDkBody.setLayout(jDkBodyLayout);
        jDkBodyLayout.setHorizontalGroup(
            jDkBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jDkBodyLayout.setVerticalGroup(
            jDkBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Controle:");

        jPDepartamento.setBackground(new java.awt.Color(250, 250, 250));
        jPDepartamento.setAutoscrolls(true);

        lbTermo.setBackground(new java.awt.Color(250, 250, 250));
        lbTermo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTermo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTermo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTermo.setOpaque(true);
        lbTermo.setPreferredSize(new java.awt.Dimension(0, 22));

        lbSenha.setBackground(new java.awt.Color(250, 250, 250));
        lbSenha.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSenha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSenha.setOpaque(true);
        lbSenha.setPreferredSize(new java.awt.Dimension(0, 22));

        lbDiagnose.setBackground(new java.awt.Color(250, 250, 250));
        lbDiagnose.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDiagnose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiagnose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDiagnose.setOpaque(true);
        lbDiagnose.setPreferredSize(new java.awt.Dimension(0, 22));

        lbGeral.setBackground(new java.awt.Color(250, 250, 250));
        lbGeral.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbGeral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGeral.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbGeral.setOpaque(true);

        lbProposta.setBackground(new java.awt.Color(250, 250, 250));
        lbProposta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbProposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProposta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbProposta.setOpaque(true);
        lbProposta.setPreferredSize(new java.awt.Dimension(0, 22));

        lbRequisicao.setBackground(new java.awt.Color(250, 250, 250));
        lbRequisicao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbRequisicao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRequisicao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbRequisicao.setOpaque(true);
        lbRequisicao.setPreferredSize(new java.awt.Dimension(0, 22));

        lbTaxa.setBackground(new java.awt.Color(250, 250, 250));
        lbTaxa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbTaxa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTaxa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTaxa.setOpaque(true);
        lbTaxa.setPreferredSize(new java.awt.Dimension(0, 22));

        lbOS.setBackground(new java.awt.Color(250, 250, 250));
        lbOS.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbOS.setOpaque(true);
        lbOS.setPreferredSize(new java.awt.Dimension(0, 22));

        lbDeposito.setBackground(new java.awt.Color(250, 250, 250));
        lbDeposito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDeposito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDeposito.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDeposito.setOpaque(true);
        lbDeposito.setPreferredSize(new java.awt.Dimension(0, 22));

        lbPesquisa.setBackground(new java.awt.Color(250, 250, 250));
        lbPesquisa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbPesquisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPesquisa.setOpaque(true);
        lbPesquisa.setPreferredSize(new java.awt.Dimension(0, 22));

        javax.swing.GroupLayout jPDepartamentoLayout = new javax.swing.GroupLayout(jPDepartamento);
        jPDepartamento.setLayout(jPDepartamentoLayout);
        jPDepartamentoLayout.setHorizontalGroup(
            jPDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDepartamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbOS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPDepartamentoLayout.setVerticalGroup(
            jPDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDepartamentoLayout.createSequentialGroup()
                .addComponent(lbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(lbDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbOS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRequisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbRecebimento.setBackground(new java.awt.Color(250, 250, 250));
        tbRecebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aguardando Recebimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbRecebimento);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Envio Diagnose:");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Proposta Comercial:");

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comercial");
        jLabel1.setOpaque(true);

        jComboBox1.setBackground(new java.awt.Color(250, 250, 250));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jButton1))
                        .addGap(27, 27, 27)
                        .addComponent(jPDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel7)
                            .addComponent(jDkBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19))
                            .addComponent(jPDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAlerta)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDkBody, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlerta, btRelatorio, jButton1, jButton2});

        setBounds(0, 0, 860, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        this.setLocation(0,0);
    }//GEN-LAST:event_formComponentMoved

    private void btAlertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlertaActionPerformed
        abrirRelatorio("Alerta");
    }//GEN-LAST:event_btAlertaActionPerformed

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        
    }//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(!jComboBox1.getSelectedItem().equals("Clique aqui para Ativar!")){
            combo((String)jComboBox1.getSelectedItem());
            comercial(TelaPrincipal.txt_codigo.getText());
            add(TelaPrincipal.txt_codigo.getText());
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        abrirComercial();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        abrirDocumentos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        //abrirRelatorio("Relatorio");
    }//GEN-LAST:event_btRelatorioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlerta;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDkBody;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPDepartamento;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbDeposito;
    private javax.swing.JLabel lbDiagnose;
    private javax.swing.JLabel lbGeral;
    private javax.swing.JLabel lbOS;
    private javax.swing.JLabel lbPesquisa;
    private javax.swing.JLabel lbProposta;
    private javax.swing.JLabel lbRequisicao;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbTaxa;
    private javax.swing.JLabel lbTermo;
    private javax.swing.JTable tbRecebimento;
    private javax.swing.JTable tbSolicitacao;
    // End of variables declaration//GEN-END:variables
    Relatorios intRelatorio;    
    Comercial comercial;
    Documentos documentos;
    private void abrirRelatorio(String valor){
        jDkBody.removeAll();
        //if(intRelatorio==null){
        List<String> lista = new ArrayList<>();
            intRelatorio = new Relatorios(valor,"Comercial", lista);
            ((BasicInternalFrameUI)intRelatorio.getUI()).setNorthPane(null);
        //}
        jDkBody.add(intRelatorio);
        intRelatorio.setVisible(true);
        
    }
    private void abrirDocumentos(){
        if(TelaPrincipal.txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Para prosseguir ative um cadastro!");
            Ativador ativador = new Ativador();
            ativador.setVisible(true);
        }
        else{
            documentos = new Documentos();
            documentos.setVisible(true);
            
        }
    }
    
    private void abrirComercial(){
        if(TelaPrincipal.txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Para prosseguir ative um cadastro!");
            Ativador ma = new Ativador();
            ma.setVisible(true);
        }
        else{   
            comercial = new Comercial();
            comercial.setVisible(true);
        }
    }
    public void carregaCombo(){
        Connection con = null;
        try{
            String sql ="select SUBSTRING_INDEX(SUBSTRING_INDEX(Cliente, ' ', 3), ' ', -3) as Cliente from cadastrodeprocesso where Situacao=1";
            con = new ConexaoStatement().getConnetion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jComboBox1.removeAll();
            jComboBox1.addItem("Clique aqui para Ativar!");
                       
            if(rs!=null){
                while(rs.next()){
                    jComboBox1.addItem(rs.getString("Cliente"));
                }
                String valor = TelaPrincipal.txt_nome.getText();
                if(!valor.equals(null) && !valor.equals(""))
                    jComboBox1.setSelectedItem(valor);
                else
                    jComboBox1.setSelectedItem("Clique aqui para Ativar!");
 
            }
        }catch(SQLException e){
        }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    
    public void combo(String valor){
        Connection con = null;
        try{
            String sql ="select * from cadastrodeprocesso where Cliente like '"+valor+"%'";
            con = new ConexaoStatement().getConnetion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                if(rs.next()){
                    TelaPrincipal.txt_codigo.setText(rs.getString("codNumerodoprocesso"));
                    TelaPrincipal.txt_nome.setText(rs.getString("Cliente"));
                    TelaPrincipal.txt_id.setText(rs.getString("Apelido"));
                    TelaPrincipal.txt_classificacao.setText(rs.getString("Classificacao"));
                    TelaPrincipal.txt_ativada.setText("");
                    TelaPrincipal.txt_finalizada.setText("");
                }
            }
            
        }catch(SQLException e){
        }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    public void comercial(String processo){
        Connection con = new ConexaoStatement().getConnetion();
        
        String sql ="select B.AndamentoComercial AS GERAL," 
                        +"A.AndamentoTaxaDeImplantacaoEFormaDePagamento AS TAXA,"
                        +"A.AndamentoGravarSenhasFiscais AS SENHAS, "
                        +"A.AndamentoGerarOS AS OS,"
                        +"AndamentoEnviarTermoResponsaparacliente AS TERMO,"
                        +"A.AndamentoPropastaComercial AS PROPOSTA,"
                        +"A.AndamentoEnvioDiagnose AS DIAGNOSE,"
                        +"A.AndamentoChekList AS CHECKLIST,"
                        +"A.AndamentoPesquisaFiscal AS PESQUISA,"
                        +"A.AndamentoRequisicaoDocumentos AS DOCUMENTOS,"
                        +"A.AndamentoConfirmarRecebimentoDeposito AS DEPOSITO"
                        +" from comercial AS A "
                        +" inner join cadastrodeprocesso as B "
                        +" on A.Numerodoprocesso=B.codNumerodoprocesso "
                        +" where A.Numerodoprocesso='"+processo+"'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    lbGeral.setText(rs.getString("GERAL"));
                    lbDeposito.setText(rs.getString("DEPOSITO"));
                    lbDiagnose.setText(rs.getString("DIAGNOSE"));
                    lbOS.setText(rs.getString("OS"));
                    lbPesquisa.setText(rs.getString("PESQUISA"));
                    lbProposta.setText(rs.getString("PROPOSTA"));
                    lbRequisicao.setText(rs.getString("DOCUMENTOS"));
                    lbSenha.setText(rs.getString("GERAL"));
                    lbTaxa.setText(rs.getString("TAXA"));
                    lbTermo.setText(rs.getString("TERMO"));
                    
                }
            colorir(jPDepartamento);
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Diagnose " +erro);
            }finally{try{if(con!=null)con.close();}catch(Exception e){}}
}
private void colorir(JPanel jpanel){
    
    for(int i = 0; i<jpanel.getComponentCount();i++){
        if(jpanel.getComponent(i) instanceof JLabel){
            JLabel label =((JLabel)jpanel.getComponent(i));
            if(label.getText().equals("Concluido") || 
                label.getText().equals("Finalizado")){
                        label.setBackground(Color.GREEN);
                        label.setForeground(Color.WHITE);
            }else{
                label.setBackground(Color.RED);
                label.setForeground(Color.WHITE);
                
            }
        }
    }
}

private void add(String processo){
    
    limpar_tabela(tbRecebimento);
    limpar_tabela(tbSolicitacao);
    
    Connection con = new ConexaoStatement().getConnetion();
    String sql = "select * from documentos where Numerodoprocesso='"+processo+"'";
    try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    //area contratos
                    contexto("Ato Constitutivo",rs.getString("AtoConstitutivo"));
                    contexto("Documentos do Socio",rs.getString("RGeCPFSocio"));
                    contexto("Comprovantes dos Sócios",rs.getString("ComprovanteResidencia"));
                    contexto("Numero Pis",rs.getString("NumeroPIS"));
                    contexto("Habilitar NFe PMSP",rs.getString("AutorizacaoNotaFiscalEletronica"));
                    contexto("Senha Posto Fiscal",rs.getString("SenhaPostoFiscal"));
                    contexto("Senha Simples Nacional",rs.getString("SenhaSimplesNacional"));
                    contexto("Perfil Fiscal PMSP",rs.getString("ConfigurarPerfilFiscalNoSitePrefeituraDocumento"));
                    
                    //area contabil
                    contexto("Balanço e D.R.E",rs.getString("BalancoDRE"));
                    contexto("Contas Patrimoniais",rs.getString("ComposicaoDeContasPatrimoniais"));
                    contexto("Plano de Contas",rs.getString("PlanoDeContas"));
                    contexto("Balancete",rs.getString("BalanceteExercicio"));
                    //departamento pessoal
                    contexto("Folha de Pagamento",rs.getString("FolhadePagamentoDocumento"));
                    contexto("Fichs de Funcionários",rs.getString("LivroOuFichadeRegistroFuncionario"));
                    contexto("Caged",rs.getString("CAGED"));
                    contexto("Recisões",rs.getString("Recisao"));
                    contexto("Recibo de Férias",rs.getString("Ferias"));
                    contexto("Afastamentos",rs.getString("Afastamento"));
                    //regularizacao senhas
                    contexto("Senha Receita Federal",rs.getString("OutorgaSenhaEletronicaReceita"));
                    contexto("Termo Resp.Tecnica",rs.getString("TermodeResponsabilidadeDocumento"));
                    contexto("Senha do Inss",rs.getString("SenhaINSS"));
                    
                    }
//            statusTabel(tbRecebimento);
//            statusTabel(tbSolicitacao);
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Diagnose " +erro);
            }finally{try{if(con!=null)con.close();}catch(Exception e){}}
}
private void contexto(String nomeLabel, String valor){
    if(valor.trim().equals("") || valor.contains("Em Aberto")){
         criaLabel(tbSolicitacao, nomeLabel);
    }
    else if(valor.contains("Enviado")){
        criaLabel(tbRecebimento, nomeLabel);
    }
}
private void criaLabel(JTable tabela, String text){
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    int linha = modelo.getRowCount();
    modelo.addRow(new String[1]);
        tabela.setValueAt(text, linha, 0);
    
}
public static void limpar_tabela(JTable jtable){
  DefaultTableModel tbm = (DefaultTableModel)jtable.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
}
//private void statusTabel(JTable tabela){
//    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
//    if(modelo.getRowCount()==0){
//        modelo.addRow(new String[1]);
//        tabela.setValueAt("Nenhuma Pendência", 0, 0);
//    }
//}
}
