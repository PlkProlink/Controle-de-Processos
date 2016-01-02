/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.inicio;

import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.Conexao;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.table.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago Dias
 */
public class Ativador extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    
    Conexao con_cliente = new Conexao();
    
    public static String id;
    public static String nome;
    public static String processo;
    public static String classificacao;
    public static String dataativacao;
    public static String datafinalizacao;
    
    String codigo, pesquisa;
    
    public Ativador() {
        initComponents();
        
        con_cliente.conecta();
        tb_ativacao.setAutoCreateRowSorter(true);
        cb_organizar.setSelectedItem("");
        
        try{
            con_cliente.executeSQL("select * from cadastrodeprocesso order by codNumerodoprocesso");
            preencher_jtable();
        }
        catch(Exception erro){
            erro.printStackTrace();
        }
        
        
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
        tb_ativacao = new javax.swing.JTable();
        lbProcesso = new javax.swing.JLabel();
        txt_processo = new javax.swing.JTextField();

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
        lb_organizar2.setText("Nome:");

        txtPesqNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqNomeKeyPressed(evt);
            }
        });

        cb_organizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_organizar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Apelido", "Nome" }));
        cb_organizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_organizarActionPerformed(evt);
            }
        });

        lb_organizar.setBackground(new java.awt.Color(255, 255, 255));
        lb_organizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_organizar.setText("Organizar por:");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lb_organizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_organizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_organizar2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_organizar1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPesqNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesqId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                "Codigo", "Apelido", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        lbProcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbProcesso.setText("Processo:");

        txt_processo.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                                .addComponent(txt_processo, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addGap(202, 202, 202)
                                .addComponent(btnSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nome))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(238, 238, 238))
        );

        setSize(new java.awt.Dimension(563, 509));
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
        if(codigo.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma empresa!");
        }
        else{
            
            try{
                String sql = "select * from cadastrodeprocesso Where codNumerodoprocesso = "+
                        codigo;
                con_cliente.executeSQL(sql);
                
                if(con_cliente.resultset.first()){
                    
                    processo = con_cliente.resultset.getString("codNumerodoprocesso");
                    id = con_cliente.resultset.getString("Apelido");
                    nome = con_cliente.resultset.getString("Cliente");
                    classificacao = con_cliente.resultset.getString("Classificacao");
                    dataativacao = con_cliente.resultset.getString("DatadeAtivacao");
                    datafinalizacao = con_cliente.resultset.getString("DataDeArquivamentodoProcesso");
                    
                    envia_para_menu();
                    
                    con_cliente.desconecta();
                    this.dispose();
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel ativar o cliente informado : " +erro);
            } catch (Exception ex) {
                Logger.getLogger(Ativador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void cb_organizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_organizarActionPerformed
         if(cb_organizar.getSelectedItem().equals("Nome")){
            limpar_tabela();
            
            try{
            con_cliente.executeSQL("select * from cadastrodeprocesso order by Cliente");
            preencher_jtable();
            }catch(Exception erro){
            erro.printStackTrace();
            }
            
        }
        else if(cb_organizar.getSelectedItem().equals("Codigo")){
            limpar_tabela();
            
            try{
            con_cliente.executeSQL("select * from cadastrodeprocesso order by codNumerodoprocesso");
            preencher_jtable();
        }
        catch(Exception erro){
            erro.printStackTrace();
        }
            
         }
        else if(cb_organizar.getSelectedItem().equals("Apelido")){
            limpar_tabela();
            try{
            con_cliente.executeSQL("select * from cadastrodeprocesso order by Apelido");
            preencher_jtable();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_cb_organizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con_cliente.desconecta();
        //this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtPesqIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqIdKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String st;
            if(!txtPesqId.getText().equals("")){
                st="";  
            }
            else{
                st=" where Apelido='"+txtPesqId.getText().trim()+"'";
            }
            limpar_tabela();    
            try{
                con_cliente.executeSQL("select * from cadastrodeprocesso"+st);
                    if(con_cliente.resultset.first()){
                        preencher_jtable();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não encontrado registro com: "+txtPesqId.getText());
                    }
                }catch(SQLException | HeadlessException erro){
                    JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
                }
        }
    }//GEN-LAST:event_txtPesqIdKeyPressed

    private void txtPesqNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqNomeKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            limpar_tabela();
            try{
            con_cliente.executeSQL("select * from cadastrodeprocesso where Cliente like '"+txtPesqNome.getText()+"%' order by Cliente");
                if(con_cliente.resultset.first()){
                    preencher_jtable();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Não encontrado registro com: "+txtPesqNome.getText().toUpperCase());
                }
            }catch(SQLException | HeadlessException erro){
                JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
            }
        }
    }//GEN-LAST:event_txtPesqNomeKeyPressed

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
     */
    public void preencher_jtable(){
        tb_ativacao.getColumnModel().getColumn(0);
        tb_ativacao.getColumnModel().getColumn(1);
        tb_ativacao.getColumnModel().getColumn(2);
        DefaultTableModel modelo = (DefaultTableModel)tb_ativacao.getModel();
    
        try{
            while(con_cliente.resultset.next())
                modelo.addRow(new Object []{
                    con_cliente.resultset.getString("codNumerodoprocesso"),
                    con_cliente.resultset.getString("Apelido"),
                    con_cliente.resultset.getString("Cliente")});
                    con_cliente.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao lista tabela: " +erro);
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
            TelaPrincipal.txt_codigo.setText(processo);
            TelaPrincipal.txt_id.setText(id);
            TelaPrincipal.txt_nome.setText(nome);
            TelaPrincipal.txt_classificacao.setText(classificacao);
        
            if(dataativacao.trim().length()==10 && !"0000-00-00".equals(dataativacao)
                    && !"1111-11-11".equals(dataativacao)){
                String ano = dataativacao.substring(0, 4);
                String mes = dataativacao.substring(5, 7);
                String dia = dataativacao.substring(8);
                datainicio = dia+"/"+mes+"/"+ano;
                dataativacao = datainicio;
                TelaPrincipal.txt_ativada.setText(dataativacao);
            }
            if(datafinalizacao.trim().length()==10 && !"0000-00-00".equals(datafinalizacao)
                    && !"1111-11-11".equals(datafinalizacao)){
                String ano = datafinalizacao.substring(0, 4);
                String mes = datafinalizacao.substring(5, 7);
                String dia = datafinalizacao.substring(8);
                datafim = dia+"/"+mes+"/"+ano;
                datafinalizacao = datafim;
                TelaPrincipal.txt_finalizada.setText(datafinalizacao);
            }
        }catch(Exception erro){
        }
    }
}