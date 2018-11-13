/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.inicio;

import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.factory.Conexao;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.table.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago Dias
 */
public class Ativador extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    
    Conexao con_cliente = new Conexao();
    
    private static String id;
    private static String nome;
    private static String processo;
    private static String classificacao;
    private static String dataativacao;
    private static String datafinalizacao;
    private static int status;
    String codigo, pesquisa, comando, ativada, desativada;
    
    boolean ativo=true, inativo=false;
    
    Connection con;
    
    public Connection getCon(){
        this.con = new ConexaoStatement().getConnetion();
        return this.con;
    }
    
    public Ativador() {
        initComponents();
        
        tb_ativacao.setAutoCreateRowSorter(true);
        
        ckAtivada.setSelected(true);
        cb_organizar.setSelectedItem("");
        comando = "select * from cadastrodeprocesso"+verificaStatus()+" order by codNumerodoprocesso";
        preencher_jtable(comando);
        
        txt_apelido.setEditable(false);
        txt_nome.setEditable(false);
        
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_apelido = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        btnSelecionar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lb_organizar2 = new javax.swing.JLabel();
        txtPesqNome = new javax.swing.JTextField();
        cb_organizar = new javax.swing.JComboBox();
        lb_organizar = new javax.swing.JLabel();
        txtPesqId = new javax.swing.JTextField();
        lb_organizar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ativacao = new javax.swing.JTable(){
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                //component.setBackground(Color.ORANGE); //muda cor para toda a tabela
                //component.setBackground(row % 2 == 0 ? Color.ORANGE : Color.WHITE);
                if (!isRowSelected(row)) {
                    component.setBackground(getBackground());
                    int linha = convertRowIndexToModel(row);

                    //as 3 linhas abaixo mudam a cor de todos os que sua idade seja maior ou igual a 30 anos
                    String valor = (String) getModel().getValueAt(linha, 3);
                    if (valor.equals("Finalizada"))
                    component.setBackground(Color.GREEN);

                    //muda as cores conforme se cliente é ativo ou não
                    //boolean ativo = (boolean) getModel().getValueAt(linha, 3);
                    //if (ativo == true)
                    //	component.setBackground(Color.CYAN);
                }

                return component;
            }

        };
        lbProcesso = new javax.swing.JLabel();
        txt_processo = new javax.swing.JTextField();
        ckAtivada = new javax.swing.JCheckBox();
        ckFinalizada = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ativador");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        lblTitulo.setBackground(new java.awt.Color(245, 245, 245));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ativação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome:");

        txt_nome.setEditable(false);

        txt_apelido.setEditable(false);

        lbID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbID.setText("Apelido:");

        btnSelecionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSelecionar.setText("Ativar");
        btnSelecionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        lb_organizar2.setBackground(new java.awt.Color(255, 255, 255));
        lb_organizar2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_organizar2.setText("Nome: (inicia com)");

        txtPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqNomeActionPerformed(evt);
            }
        });
        txtPesqNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqNomeKeyPressed(evt);
            }
        });

        cb_organizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_organizar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Apelido", "Nome", "Status" }));
        cb_organizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_organizarActionPerformed(evt);
            }
        });

        lb_organizar.setBackground(new java.awt.Color(255, 255, 255));
        lb_organizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_organizar.setText("Organizar por:");

        txtPesqId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqIdActionPerformed(evt);
            }
        });
        txtPesqId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqIdKeyPressed(evt);
            }
        });

        lb_organizar1.setBackground(new java.awt.Color(255, 255, 255));
        lb_organizar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_organizar1.setText("Id(Apelido)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_organizar)
                    .addComponent(lb_organizar1)
                    .addComponent(lb_organizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_organizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_organizar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_organizar2)
                    .addComponent(txtPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_organizar)
                    .addComponent(cb_organizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        tb_ativacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Apelido", "Nome", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ativacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ativacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ativacao);
        if (tb_ativacao.getColumnModel().getColumnCount() > 0) {
            tb_ativacao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_ativacao.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_ativacao.getColumnModel().getColumn(1).setPreferredWidth(75);
            tb_ativacao.getColumnModel().getColumn(1).setMaxWidth(75);
            tb_ativacao.getColumnModel().getColumn(3).setPreferredWidth(80);
            tb_ativacao.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        lbProcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbProcesso.setText("Processo:");

        txt_processo.setEditable(false);

        ckAtivada.setBackground(new java.awt.Color(245, 245, 245));
        ckAtivada.setText("Ativada");
        ckAtivada.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ckAtivadaStateChanged(evt);
            }
        });

        ckFinalizada.setBackground(new java.awt.Color(245, 245, 245));
        ckFinalizada.setText("Finalizada");
        ckFinalizada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckFinalizadaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbID, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_processo, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addGap(202, 202, 202)
                                .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nome)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(125, 125, 125)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ckAtivada, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(ckFinalizada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ckAtivada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckFinalizada)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbID)
                    .addComponent(txt_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbProcesso)
                    .addComponent(txt_processo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(563, 534));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ativacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ativacaoMouseClicked
        Integer linha =  tb_ativacao.getSelectedRow();
        codigo = (String)tb_ativacao.getValueAt(linha, 0);
        String apelido = (String)tb_ativacao.getValueAt(linha, 1);
        String empresa = (String)tb_ativacao.getValueAt(linha, 2);
        
        txt_processo.setText(codigo);
        txt_apelido.setText(apelido);
        txt_nome.setText(empresa);
    }//GEN-LAST:event_tb_ativacaoMouseClicked

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if(txt_processo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione uma empresa!");
        }
        else
            try{
                
                String sql = "select * from cadastrodeprocesso Where codNumerodoprocesso = "+txt_processo.getText();
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if(rs!=null){
                    while(rs.next()){
                        processo = rs.getString("codNumerodoprocesso");
                        id = rs.getString("Apelido")==null?"":rs.getString("Apelido");
                        nome = rs.getString("Cliente");
                        classificacao = rs.getString("Classificacao");
                        dataativacao = rs.getString("DatadeAtivacao");
                        datafinalizacao = rs.getString("DataDeArquivamentodoProcesso");
                        status = rs.getInt("Situacao");
                    }
                }
                con.close();
                envia_para_menu();
                this.dispose();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel ativar o cliente informado : " +erro);
            }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void cb_organizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_organizarActionPerformed
        if(cb_organizar.getSelectedItem().equals("Nome")){
                String valor = "Cliente";
                ordenar(valor);
        }
        else if(cb_organizar.getSelectedItem().equals("Codigo")){
                String valor =  "codNumerodoprocesso";
                ordenar(valor);
        }
        else if(cb_organizar.getSelectedItem().equals("Apelido")){
                String valor =  "Apelido";
                ordenar(valor);
        }
        else if(cb_organizar.getSelectedItem().equals("Status")){
                String valor =  "Situacao";
                ordenar(valor);
        }
            
    }//GEN-LAST:event_cb_organizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
    }//GEN-LAST:event_formWindowClosing

    private void txtPesqIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqIdKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String st;
            if(txtPesqId.getText().equals("")){
                st="";  
            }
            else{
                st=" where Apelido like '"+txtPesqId.getText().trim()+"'";
            }
                preencher_jtable("select * from cadastrodeprocesso"+st);
            }
    }//GEN-LAST:event_txtPesqIdKeyPressed

    private void txtPesqNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqNomeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                preencher_jtable("select * from cadastrodeprocesso where Cliente like '"+txtPesqNome.getText()+"%' order by Cliente");         
        }
    }//GEN-LAST:event_txtPesqNomeKeyPressed

    private void txtPesqIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqIdActionPerformed
              String st;
              if(txtPesqId.getText().equals("")){
                       st="";  
              }else{
                       st=" where Apelido like '"+txtPesqId.getText().trim()+"'";
              }
                       preencher_jtable("select * from cadastrodeprocesso"+st);
    }//GEN-LAST:event_txtPesqIdActionPerformed

    private void txtPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqNomeActionPerformed
         preencher_jtable("select * from cadastrodeprocesso where Cliente like '"+txtPesqNome.getText()+"%' order by Cliente");
    }//GEN-LAST:event_txtPesqNomeActionPerformed

    private void ckAtivadaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ckAtivadaStateChanged
        ordenar("codNumerodoprocesso");
    }//GEN-LAST:event_ckAtivadaStateChanged

    private void ckFinalizadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckFinalizadaItemStateChanged
        // TODO add your handling code here:
        ordenar("codNumerodoprocesso");
    }//GEN-LAST:event_ckFinalizadaItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ativador().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cb_organizar;
    private javax.swing.JCheckBox ckAtivada;
    private javax.swing.JCheckBox ckFinalizada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbProcesso;
    private javax.swing.JLabel lb_organizar;
    private javax.swing.JLabel lb_organizar1;
    private javax.swing.JLabel lb_organizar2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tb_ativacao;
    private javax.swing.JTextField txtPesqId;
    private javax.swing.JTextField txtPesqNome;
    private javax.swing.JTextField txt_apelido;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_processo;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param valor
     */
    public void preencher_jtable(String valor){
        tb_ativacao.getColumnModel().getColumn(0);
        tb_ativacao.getColumnModel().getColumn(1);
        tb_ativacao.getColumnModel().getColumn(2);
        DefaultTableModel modelo = (DefaultTableModel)tb_ativacao.getModel();
        
        limpar_tabela();
        
        int i=0;
        
        try{
        
            PreparedStatement ps = getCon().prepareStatement(valor);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    modelo.addRow(new String[1]);
                        modelo.setValueAt(rs.getString("codNumerodoprocesso"), i, 0);
                        modelo.setValueAt(rs.getString("Apelido"), i, 1);
                        modelo.setValueAt(rs.getString("Cliente"), i, 2);
                        modelo.setValueAt(converter(rs.getString("Situacao")), i, 3);
                        i++;
                    
                }
            }
        con.close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao lista tabela: " +erro);
        }finally{
        }
    }
    public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)tb_ativacao.getModel();
        for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
    }
    public void envia_para_menu(){
        String datafim, datainicio;
        try{
            ProcessoLogado p = ProcessoLogado.getInstance();
            Processo novoProcesso = new Processo();
            novoProcesso.setId(Integer.parseInt(processo));
            novoProcesso.setCliente(nome);
            novoProcesso.setApelido(id);
            novoProcesso.setClassificacao(classificacao);
            novoProcesso.setSituacao(status);
            p.setAtributos(new String[]{processo,id,nome,classificacao,
                String.valueOf(status)});
            p.setProcesso(novoProcesso);
        }catch(Exception erro){
        }
    }
    public void ordenar(String valor){
            comando = "select * from cadastrodeprocesso"+verificaStatus()+" order by "+valor;
            preencher_jtable(comando);
    }
    public String verificaStatus(){
        if(ckAtivada.isSelected()){
            if(ckFinalizada.isSelected()){
                return "";
            }
            else{
                return " where Situacao=1";
            }
        }
        else if(ckFinalizada.isSelected())
            return " where Situacao=0";
        return "";
    }
    public String converter(String valor){
        int v = Integer.parseInt(valor);
        if(v==0){
            return "Finalizada";
        }else
            return "Ativada";
    }
}