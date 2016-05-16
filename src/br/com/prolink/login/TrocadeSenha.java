package br.com.prolink.login;

import br.com.prolink.inicio.Conexao;
import com.sun.glass.events.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
/**
 *
 * @author Tiago Dias
 */
public class TrocadeSenha extends javax.swing.JFrame {

    Conexao con_senha;
    
    public TrocadeSenha() {
        initComponents();
        
        con_senha = new Conexao();
        con_senha.conecta();
        
        
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbSenha = new javax.swing.JLabel();
        lbSenhaNova = new javax.swing.JLabel();
        lbSenhaConfirma = new javax.swing.JLabel();
        txtSenhaNova = new javax.swing.JPasswordField();
        txtSenha = new javax.swing.JPasswordField();
        txtSenhaConfirma = new javax.swing.JPasswordField();
        lbTitulo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Troca de Senha");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbSenha.setText("Senha Atual:");

        lbSenhaNova.setText("Nova Senha:");

        lbSenhaConfirma.setText("Confirme:");

        txtSenhaConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaConfirmaActionPerformed(evt);
            }
        });
        txtSenhaConfirma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaConfirmaKeyPressed(evt);
            }
        });

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Alterar Senha");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbSenhaNova)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbSenhaConfirma)
                                    .addGap(28, 28, 28)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbSenha)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSenhaNova)
                                .addComponent(txtSenha)
                                .addComponent(txtSenhaConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenhaNova)
                    .addComponent(txtSenhaNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenhaConfirma)
                    .addComponent(txtSenhaConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtSenhaConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaConfirmaActionPerformed

    }//GEN-LAST:event_txtSenhaConfirmaActionPerformed

    private void txtSenhaConfirmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaConfirmaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            salvar();
            
        }
    }//GEN-LAST:event_txtSenhaConfirmaKeyPressed
    private void salvar(){
        if(txtSenha.getText().trim().equals("") || txtSenhaConfirma.getText().trim().equals("")
                || txtSenhaNova.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Nenhum campo pode ficar em branco!");
        }
        else if(txtSenhaNova.getText().trim().length()<6){
            JOptionPane.showMessageDialog(null,"Nova senha não pode ser menor que 6 digitos!");
        }
        else if(!txtSenhaNova.getText().trim().equals(txtSenhaConfirma.getText().trim())){
            JOptionPane.showMessageDialog(null, "Confirmação de senha não confere com a primeira informada!");
        }
        else if(txtSenha.getText().trim().equals(txtSenhaNova.getText().trim())){
            JOptionPane.showMessageDialog(null, "Nova senha não pode ser igual a anterior!");
        }
        else{
            if(txtSenha.getText().trim().equalsIgnoreCase(Login.senha)){
                try{
                    con_senha.executeSQL("select * from login where Usuario like '"+Login.usuario+"'");
                    if(con_senha.resultset.first()){
                        con_senha.statement.executeUpdate("update login set Senha='"+txtSenhaNova.getText()+"' where Usuario='"+Login.usuario+"'");
                        JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso");
                        
                        Login.senha = txtSenhaNova.getText();
                        limpar_campos();
                        this.dispose();
                        
                    }
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar o cadastro!\n"+erro);
                }
            }
            else{
                    JOptionPane.showMessageDialog(null, "Senha atual informada esta incorreta!");   
            }
        }
        limpar_campos();    
    }
    private void limpar_campos(){
        for(int i=0; i<jPanel1.getComponentCount(); i++){
            if(jPanel1.getComponent(i) instanceof JPasswordField)
                ((JPasswordField)jPanel1.getComponent(i)).setText("");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TrocadeSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrocadeSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrocadeSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrocadeSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrocadeSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSenhaConfirma;
    private javax.swing.JLabel lbSenhaNova;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaConfirma;
    private javax.swing.JPasswordField txtSenhaNova;
    // End of variables declaration//GEN-END:variables
}