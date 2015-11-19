/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.cadastros;

import java.awt.Component;  
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import br.com.prolink.inicio.Conexao;
import br.com.prolink.controle.*;
/**
 *
 * @author User
 */
public class CadastroClassificacao extends javax.swing.JFrame {
    
    Conexao con_classificacao, con_log;
    //variavel para recuperar valores do campo
    String codigo_backup, nome_backup;
    
    LogUsuarioBean logbean = new LogUsuarioBean();
    LogUsuarioDao logdao = new LogUsuarioDao();
    /**
     *
     */
    public CadastroClassificacao() {
        initComponents();
        
        con_classificacao = new Conexao();
        con_classificacao.conecta();
        
        con_log = new Conexao();
        
        preencher_jtable();
        bloqueia_campos();
        
        tb_classificacao.setAutoCreateRowSorter(true);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPlaca = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        lblDescricao1 = new javax.swing.JLabel();
        btn_novo = new javax.swing.JButton();
        btn_Gravar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        btn_fechar = new javax.swing.JButton();
        txt_usuario = new javax.swing.JLabel();
        btn_Alterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_classificacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Classificação");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        lblTitulo.setBackground(new java.awt.Color(245, 245, 245));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Classificação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        lblPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPlaca.setText("Codigo:");

        lblDescricao1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDescricao1.setText("Nome:");

        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_Gravar.setText("Gravar");
        btn_Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GravarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_fechar.setText("Fechar");
        btn_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecharActionPerformed(evt);
            }
        });

        btn_Alterar.setText("Alterar");
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaca)
                    .addComponent(lblDescricao1))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_fechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Gravar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPlaca)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao1)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Gravar)
                    .addComponent(btn_novo)
                    .addComponent(btn_Alterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fechar)
                    .addComponent(btn_excluir)
                    .addComponent(btn_Cancelar)))
        );

        tb_classificacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_classificacao.setOpaque(false);
        tb_classificacao.setRequestFocusEnabled(false);
        tb_classificacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_classificacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_classificacao);
        if (tb_classificacao.getColumnModel().getColumnCount() > 0) {
            tb_classificacao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_classificacao.getColumnModel().getColumn(0).setMaxWidth(50);
        }
        tb_classificacao.getAccessibleContext().setAccessibleName("");
        tb_classificacao.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    private void btn_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_btn_fecharActionPerformed

    private void btn_GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GravarActionPerformed
        if(txt_nome.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Campo nome não pode ficar em branco!");
        txt_nome.requestFocus(true);
        }
        else if(txt_codigo.getText().isEmpty()){
        con_classificacao.conecta();
             try{
                String gry = "insert into classificacao (Status) values ('"+
                               // txt_data.setDate(2, new java.sql.Date(data.getTime()));
                                txt_nome.getText()+"')";
                                con_classificacao.exeQuery(gry);
                    JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
                    
                    logbean.setTela("Cadastro de Classificação");
                    logbean.setAcao("Inclusão");
                    logbean.setDescricao("Incluido a classificação: "+txt_nome.getText());
  
                    logdao.inserir(logbean);
                    
                    limpar_tabela();
                    limpar_campos();
                    //atualizando tabela
                    preencher_jtable();
                } catch(Exception add){
                         JOptionPane.showMessageDialog(null,"Falha ao gravar o registro " +add);
                }
        }//area para impossibilitar duplicar cadastros de empresas de mesmo nome
        else if(!txt_codigo.getText().isEmpty()){
                try{
                String sql ="UPDATE classificacao SET Status ='" 
                                        +txt_nome.getText()+
                            "' where cod = "+txt_codigo.getText();
                con_classificacao.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Alteração realizado com sucesso!");
                
                    logbean.setTela("Cadastro de Classificação");
                    logbean.setAcao("Alteração");
                    logbean.setDescricao("Atualizado de : "+nome_backup+"para: "+txt_nome.getText());
  
                    logdao.inserir(logbean);
                    
                bloqueia_campos();
                limpar_tabela();
                preencher_jtable();
               } catch (SQLException erro){
                JOptionPane.showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
            }
        }

        
    }//GEN-LAST:event_btn_GravarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        restaura_backup();
        bloqueia_campos();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        cria_backup();
        if(txt_codigo.getText().equals("") || txt_codigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        } 
        try{
            String sql = "select * from classificacao where cod=" +txt_codigo.getText();
            con_classificacao.executeSQL(sql);
            con_classificacao.resultset.first();
            String nome = "Tem certeza que deseja excluir o cadastro da classificacao " +con_classificacao.resultset.getString("Status")+"?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION)
            {
            sql = "DELETE FROM classificacao Where cod ="+txt_codigo.getText();
                int conseguiu_excluir = con_classificacao.statement.executeUpdate(sql);
                if (conseguiu_excluir == 1){
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                
                logbean.setTela("Cadastro de Classificacao");
                logbean.setAcao("Exclusao");
                logbean.setDescricao("Excluido o registro: "+txt_nome.getText());
                logdao.inserir(logbean);

                    //*chamando tres metodos, um que limpa a tabela, campo, e o outro que atualiza
                limpar_campos();
                limpar_tabela();
                preencher_jtable();
                }
            }
            }catch (SQLException erro){
                    JOptionPane.showMessageDialog(null,"Erro a tentar excluir o registro..."+erro);
            }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        codigo_backup = txt_codigo.getText();
        nome_backup = txt_nome.getText();

        limpar_campos();
    }//GEN-LAST:event_btn_novoActionPerformed

    private void tb_classificacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_classificacaoMouseClicked
        Integer linha =  tb_classificacao.getSelectedRow();
        String codigo = (String)tb_classificacao.getValueAt(linha, 0);
        String classificacao = (String)tb_classificacao.getValueAt(linha, 1);
        
        txt_codigo.setText(codigo);
        txt_nome.setText(classificacao);
        

    }//GEN-LAST:event_tb_classificacaoMouseClicked

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhum registro foi selecionado!");
        }
        else{
        cria_backup();
        desbloqueia_campos();        
        }
        
    }//GEN-LAST:event_btn_AlterarActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClassificacao().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Alterar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Gravar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_fechar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tb_classificacao;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables
    public void cria_backup(){
        codigo_backup = txt_codigo.getText();
        nome_backup = txt_nome.getText();
    }
    public void restaura_backup(){
        txt_codigo.setText(codigo_backup);
        txt_nome.setText(nome_backup);
        
    }
    /**
     *
     */
    public void preencher_jtable()
{
        tb_classificacao.getColumnModel().getColumn(0);
        tb_classificacao.getColumnModel().getColumn(1);
        
        con_classificacao.executeSQL("select * from classificacao order by cod");
        
        DefaultTableModel modelo = (DefaultTableModel)tb_classificacao.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con_classificacao.resultset.next())
                modelo.addRow(new Object [] {
                    con_classificacao.resultset.getString("cod"),
                    con_classificacao.resultset.getString("Status")});
                      con_classificacao.resultset.first();
        }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar tabela "+erro);
}
}

    /**
     *
     */
    public void limpar_tabela()
{
    DefaultTableModel tbm = (DefaultTableModel)tb_classificacao.getModel();
        for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
}
}

    /**
     *
     */
    public void limpar_campos(){
    txt_codigo.setEditable(false);
    txt_nome.setEditable(true);
    txt_codigo.setText("");
    txt_nome.setText("");
}
    public void desbloqueia_campos(){
    txt_codigo.setEditable(false);  
    txt_nome.setEditable(true);
    }
    /**
     *
     */
    public void bloqueia_campos(){
    txt_codigo.setEditable(false);
    txt_nome.setEditable(false);    
}
}

