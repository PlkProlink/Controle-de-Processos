package br.com.prolink.login;
//importando os pacotes essencias da classe

import java.sql.*;
import javax.swing.JOptionPane;
//importando as outras classes importantes
import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.Login;
import br.com.prolink.inicio.TelaPrincipal;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tiago Dias
 */
public class LoginTrocadeAcesso extends javax.swing.JFrame {
    int conta=0;
    Conexao con_usuario = new Conexao();;
//inicializando um metodo da classe conexao para validação no banco de dados   

    /**
     *
     */
        public LoginTrocadeAcesso() {
        initComponents();
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txt_nome = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Troca de Acesso");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbUsuario.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbUsuario.setText("Nome:");

        lbSenha.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbSenha.setText("Senha:");

        btnEntrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txt_nome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_nome.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_senha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_senha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSenha)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsuario)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSenha)
                .addGap(4, 4, 4)
                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(240, 201));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        logar();       
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txt_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                logar();
        }
    }//GEN-LAST:event_txt_senhaKeyPressed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
               java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables

    public void logar(){
        //validação simples para não permitir campos vazios
        if(txt_nome.getText().equals("") || txt_senha.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Os campos não podem ser vazios!\n Tente Novamente!");
        else{
            con_usuario.conecta();
            try{      
                //string sql para buscar no banco a informação necessaria
                String sql = "select * from login Where Usuario like '"+
                txt_nome.getText()+"' and Senha like '"+
                txt_senha.getText()+"'";
                con_usuario.executeSQL(sql);
                //se  encontrado o primeiro resultado, e se encontrar...   
                if (con_usuario.resultset.first()){
                    //agora a parte legal, será enviado para a tela principal o usuario logado e seu departamento
                    TelaPrincipal inicio = new TelaPrincipal();
                    inicio.setVisible(true);

                    Login.usuario = con_usuario.resultset.getString("Usuario");
                    Login.departamento = con_usuario.resultset.getString("Departamento");
                    Login.nivel = con_usuario.resultset.getString("Nivel");
                    Login.senha = con_usuario.resultset.getString("Senha");
                    
                    TelaPrincipal.txt_usuario.setText(Login.usuario);
                    TelaPrincipal.txt_departamento.setText(Login.departamento);
                    
                    dispose();
                    }
                else{
                    JOptionPane.showMessageDialog(null, "Usuario ou Senha incorreto!\n");
                }
            }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Erro na busca do cadastro do usuario!\n" +erro);
            }
            con_usuario.desconecta();
        }
    }

}
