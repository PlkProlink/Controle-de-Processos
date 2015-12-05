package br.com.prolink.usuario;



import br.com.prolink.inicio.Conexao;
import java.awt.Component;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Tiago Dias
 */
public class CadastroDepartamento extends javax.swing.JFrame {
   
    Conexao con_departamento;
    
    String codigo_backup, nome_backup;
    
    /**
     *
     */
    public CadastroDepartamento() {
        initComponents();
        
        con_departamento = new Conexao();
        con_departamento.conecta();
    
        limpar_tela();
        preencher_tabela();
        
        tb_departamento.setAutoCreateRowSorter(true);
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
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_departamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Departamento");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        lblTitulo.setBackground(new java.awt.Color(245, 245, 245));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Departamento");

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
                .addGap(6, 6, 6))
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        lblPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPlaca.setText("Codigo");

        lblDescricao1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDescricao1.setText("Nome");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlaca)
                    .addComponent(lblDescricao1))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGravar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnCancelar, btnExcluir, btnFechar, btnGravar, btnNovo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao1)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnGravar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnFechar)))
        );

        tb_departamento.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_departamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_departamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_departamento);
        if (tb_departamento.getColumnModel().getColumnCount() > 0) {
            tb_departamento.getColumnModel().getColumn(0).setResizable(false);
            tb_departamento.getColumnModel().getColumn(1).setResizable(false);
        }

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

    private void tb_departamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_departamentoMouseClicked
        int linha = tb_departamento.getSelectedRow();
        String codigo = (String)tb_departamento.getValueAt(linha, 0);
        String nome = (String)tb_departamento.getValueAt(linha, 1);
        
        txt_codigo.setText(codigo);
        txt_nome.setText(nome);
    }//GEN-LAST:event_tb_departamentoMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        criar_backup();
        limpar_tela();
        desbloqueia_tela();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(txt_codigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum registro foi selecionado!");
        }
        else{
        criar_backup();
        txt_nome.setEditable(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if(txt_nome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo nome não pode ficar em branco");
            txt_nome.requestFocus();
        }
        else if(txt_codigo.getText().trim().isEmpty()){
            try{
                String gry = "insert into departamento (nome) values ('"+txt_nome.getText()+"')";
                con_departamento.exeQuery(gry);
            }catch(Exception add){
                JOptionPane.showMessageDialog(null, "Não foi possivel gravar o novo registro\n" +add);
            
            }
        }
        else if(!txt_codigo.getText().trim().equals("")){
            try{
                String sql = "update departamento set nome='"+txt_nome.getText()+"' where cod="+txt_codigo.getText();
                con_departamento.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Não foi possivel alterar o novo registro\n" +erro);
            
            }
        }
        limpar_tela();
        limpar_tabela();
        preencher_tabela();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       restaura_backup();
       bloqueia_tela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(txt_codigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Você selecione um registro para exclusão!");
        }
        else{
            try{
                con_departamento.executeSQL("select * from departamento where cod="+txt_codigo.getText());
                con_departamento.resultset.first();
                
                String nome = "Tem certeza que deseja excluir o registro "+con_departamento.resultset.getString("nome");
                int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "Exclusão", JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    try{
                    String sql = "delete from departamento where cod="+txt_codigo.getText();
                    int excluir = con_departamento.statement.executeUpdate(sql);
                    if(excluir == 1){
                        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                        limpar_tela();
                        limpar_tabela();
                        preencher_tabela();
                    }
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Erro ao excluir o registro");
                    }
                }
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar o registro");
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroDepartamento().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tb_departamento;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void criar_backup(){
    codigo_backup = txt_codigo.getText();
    nome_backup = txt_nome.getText();
}

    /**
     *
     */
    public void restaura_backup(){
    txt_codigo.setText(codigo_backup);
    txt_nome.setText(nome_backup);
}    

    /**
     *
     */
    public void limpar_tela(){
    txt_codigo.setText("");
    txt_codigo.setEditable(false);
    txt_nome.setText("");
    txt_nome.setEditable(false);
    
}

    /**
     *
     */
    public void preencher_tabela(){
    tb_departamento.getColumnModel().getColumn(0);
    tb_departamento.getColumnModel().getColumn(1);
    try{
    con_departamento.executeSQL("select * from departamento order by nome");
    
    DefaultTableModel modelo = (DefaultTableModel)tb_departamento.getModel();
    
    while(con_departamento.resultset.next())
        modelo.addRow(new Object[]{
            con_departamento.resultset.getString("cod"),
            con_departamento.resultset.getString("nome")});
            con_departamento.resultset.first();
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null,"Listagem com erro na tabela\n" +erro);
    }
}

    /**
     *
     */
    public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)tb_departamento.getModel();
    for(int i = tbm.getRowCount()-1; i>=0; i--){
        tbm.removeRow(i);
    }
   
}

    /**
     *
     */
    public void desbloqueia_tela(){
    txt_nome.setEditable(true);
}

    /**
     *
     */
    public void bloqueia_tela(){
    txt_nome.setEditable(false);
}
}
