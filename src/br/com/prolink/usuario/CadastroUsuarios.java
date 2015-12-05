package br.com.prolink.usuario;

import br.com.prolink.inicio.Conexao;

import java.awt.Component;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.TelaPrincipal;

/**
 *
 * @author Tiago Dias
 */
public class CadastroUsuarios extends javax.swing.JFrame {

    Conexao con_usuario, con_grupo, con_departamento;
   
    String nivel, nivel_backup, codigo_backup, nome_backup, login_backup, senha_backup, email_backup, departamento_backup;
    
    /**
     *
     */
    public CadastroUsuarios() {
        initComponents();
                con_usuario = new Conexao();
                con_usuario.conecta();

                con_departamento = new Conexao();
                con_departamento.conecta();
                
                
                /*con_departamento.executeSQL("select * from departamento order by nome");
        
                try{
                    while(con_departamento.resultset.next())
                        cb_departamento.addItem(con_departamento.resultset.getString("nome"));
                    atualiza_combo_box_departamento();
                    con_departamento.resultset.first();
                }catch(Exception erro)
                {
                    JOptionPane.showMessageDialog(null, "Não foi possivel conectar com a tabela classificacao:" +erro);
                }*/
                atualiza_combo_box_departamento();
                nao_edita();
                
                txt_grupo.setSelectedItem("");
                
                preencher_tabela();
                  
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panel_menu = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        lbDepartamento = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();
        lbEmail = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_grupo = new javax.swing.JComboBox();
        lb_acesso = new javax.swing.JLabel();
        cb_departamento = new javax.swing.JComboBox();
        txt_login = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_usuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        lblTitulo.setBackground(new java.awt.Color(245, 245, 245));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Controle de Usuários");

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

        panel_menu.setBackground(new java.awt.Color(245, 245, 245));

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Codigo:");

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome:");

        lbSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSenha.setText("Senha:");

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbDepartamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDepartamento.setText("Departamento:");

        txt_senha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEmail.setText("Email:");

        lbLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbLogin.setText("Login:");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_grupo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_grupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Privilegiado", "Comun" }));

        lb_acesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_acesso.setText("Nivel de Acesso:");

        cb_departamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNome)
                            .addComponent(lbEmail))
                        .addGap(79, 79, 79)
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(txt_email))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_menuLayout.createSequentialGroup()
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_menuLayout.createSequentialGroup()
                                .addComponent(lbLogin)
                                .addGap(82, 82, 82)
                                .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbSenha)
                                .addGap(44, 44, 44)
                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_menuLayout.createSequentialGroup()
                                .addComponent(lbCodigo)
                                .addGap(74, 74, 74)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel_menuLayout.createSequentialGroup()
                                .addComponent(lbDepartamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_acesso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbLogin)
                        .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSenha)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_acesso)
                        .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbDepartamento)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        btnGravar.setBackground(new java.awt.Color(245, 245, 245));
        btnGravar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btn_excluir.setBackground(new java.awt.Color(245, 245, 245));
        btn_excluir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btn_excluir.setText("Excluir");
        btn_excluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        bt_novo.setBackground(new java.awt.Color(245, 245, 245));
        bt_novo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        bt_novo.setText("Novo");
        bt_novo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_novo.setMaximumSize(new java.awt.Dimension(65, 30));
        bt_novo.setMinimumSize(new java.awt.Dimension(65, 30));
        bt_novo.setPreferredSize(new java.awt.Dimension(65, 30));
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(245, 245, 245));
        btnCancelar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setMaximumSize(new java.awt.Dimension(65, 30));
        btnCancelar.setMinimumSize(new java.awt.Dimension(65, 30));
        btnCancelar.setPreferredSize(new java.awt.Dimension(90, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnFechar.setBackground(new java.awt.Color(245, 245, 245));
        btnFechar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFechar.setMaximumSize(new java.awt.Dimension(65, 30));
        btnFechar.setMinimumSize(new java.awt.Dimension(65, 30));
        btnFechar.setPreferredSize(new java.awt.Dimension(90, 40));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(245, 245, 245));
        btnAlterar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_novo, btnCancelar, btnGravar, btn_excluir});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGravar)
                        .addComponent(btn_excluir)
                        .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, btnCancelar, btnGravar, btn_excluir});

        btnGravar.getAccessibleContext().setAccessibleName("");
        btn_excluir.getAccessibleContext().setAccessibleName("");
        bt_novo.getAccessibleContext().setAccessibleName("");
        btnCancelar.getAccessibleContext().setAccessibleName("");
        btnFechar.getAccessibleContext().setAccessibleName("");
        btnAlterar.getAccessibleContext().setAccessibleName("");

        jScrollPane1.setBackground(java.awt.Color.white);

        tb_usuarios.setBackground(new java.awt.Color(245, 245, 245));
        tb_usuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Login", "Departamento", "Email", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_usuarios);
        if (tb_usuarios.getColumnModel().getColumnCount() > 0) {
            tb_usuarios.getColumnModel().getColumn(0).setMinWidth(75);
            tb_usuarios.getColumnModel().getColumn(0).setMaxWidth(75);
            tb_usuarios.getColumnModel().getColumn(2).setMaxWidth(75);
            tb_usuarios.getColumnModel().getColumn(3).setMinWidth(100);
            tb_usuarios.getColumnModel().getColumn(3).setMaxWidth(100);
            tb_usuarios.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(panel_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(568, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if(txt_nome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo nome não pode fivar em branco!");
            txt_nome.requestFocus(true);
        }
        if(txt_login.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo login não pode fivar em branco!");
            txt_login.requestFocus(true);
        }
        if(txt_senha.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo senha não pode fivar em branco!");
            txt_senha.requestFocus(true);
        }
        if(cb_departamento.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campo departamento não pode fivar em branco!");
            cb_departamento.requestFocus(true);
        }
        if(txt_grupo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Defina um grupo para esse usuário!");
        }
        else if (txt_grupo.getSelectedItem().equals("Privilegiado")){
            nivel = "1";
        }
        else if(txt_grupo.getSelectedItem().equals("Comum")){
            nivel = "2";
        }
        if(!txt_login.getText().equals("")){
            try{
                String novasenha;
                if(txt_senha.getText().trim().equals("")){
                    novasenha = senha_backup;
                }
                else{
                    novasenha = txt_senha.getText();
                }
                String sql ="UPDATE login SET Usuario ='"+txt_login.getText()+"',"+
                        "Nome = '" +txt_nome.getText()+"',"+
                        "Senha = ' " +novasenha+"',"+
                        "Departamento = '" +cb_departamento.getSelectedItem()+"',"+
                        "Email = '" +txt_email.getText()+
                        "Nivel = '" +nivel+
                        "' where cod = "+txt_codigo.getText();

                con_usuario.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Alteração realizado com sucesso!");
                limpar_tabela();
                preencher_tabela();
        } catch (SQLException erro){
        JOptionPane.showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
            }
        }
        else if(txt_login.getText().equals("")){
            try{
                String gry = "insert into login (Usuario, Nome, Senha, Departamento, Email, Nivel) values ('"+
                                txt_login.getText()+"','"+
                                txt_nome.getText()+"','"+
                                txt_senha.getText()+"','"+
                                cb_departamento.getSelectedItem()+"','"+
                                txt_email.getText()+
                                nivel+"')";
                                con_usuario.exeQuery(gry);
                                
                JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
                limpar_tabela();
                preencher_tabela();
            }catch(Exception add){
                JOptionPane.showMessageDialog(null,"Falha ao gravar o registro " +add);
            }
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        cria_backup();
        limpar_tela();
        pode_editar();
        txt_login.setEditable(true);
    }//GEN-LAST:event_bt_novoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        cria_backup();
        pode_editar();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Você não selecionou nenhum registro! Tente novamente! ");
        }
        else{
            try {
            String sql = "select * from login Where cod = "+txt_codigo.getText();
            con_usuario.executeSQL(sql);
            con_usuario.resultset.first();
            String nome = "Deletar o cadastro do funcionario : "+con_usuario.resultset.getString("Nome")+" ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION)
            {
                sql = "DELETE FROM login Where cod ="+txt_codigo.getText();
                int conseguiu_excluir = con_usuario.statement.executeUpdate(sql);
                if (conseguiu_excluir == 1)
                {
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                limpar_tela();
                limpar_tabela();
                preencher_tabela();
                //atualiza o ResultSet
                 /*   con_funcionario.executeSQL("Select * from funcionario  order by "+ordenacao);
                    atualiza_combo_box_funcionario();
                    con_funcionario.resultset.first(); //posiciona no primeiro registro
                    mostrar_dados(); //irá chamar a função em que irá mstrar os dados no form
                */}
            }
        else
        return;
            }catch (SQLException erro){
                JOptionPane.showMessageDialog(null,"Erro a tentar excluir o registro..."+erro);
            }
        }
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        nao_edita();
        recupera_backup();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tb_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_usuariosMouseClicked
        Integer linha = tb_usuarios.getSelectedRow();
        String cod = (String)tb_usuarios.getValueAt(linha, 0);
        String nome = (String)tb_usuarios.getValueAt(linha, 1);
        String usuario = (String)tb_usuarios.getValueAt(linha, 2);
        String departamento = (String)tb_usuarios.getValueAt(linha, 3);
        String email = (String)tb_usuarios.getValueAt(linha, 4);
        String grupo = (String)tb_usuarios.getValueAt(linha, 5);
        
        txt_codigo.setText(cod);
        txt_login.setText(usuario);
        txt_nome.setText(nome);
        txt_email.setText(email);
        cb_departamento.setSelectedItem(departamento);
        
        if("1".equals(grupo)){
            txt_grupo.setSelectedItem("Privilegiado");
        }
        else
            txt_grupo.setSelectedItem("Comum");
    
    }//GEN-LAST:event_tb_usuariosMouseClicked

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuarios().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JComboBox cb_departamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDepartamento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lb_acesso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JTable tb_usuarios;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_email;
    private javax.swing.JComboBox txt_grupo;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void atualiza_combo_box_departamento()
    {
        try
        {
            cb_departamento.removeAllItems();
            con_departamento.executeSQL("select * from departamento  order by nome");
            while(con_departamento.resultset.next())
                cb_departamento.addItem(con_departamento.resultset.getString("nome"));
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não localizou dados "+erro);
        }
        
    }

    /**
     *
     */
    public void preencher_tabela(){
    tb_usuarios.getColumnModel().getColumn(0);
    tb_usuarios.getColumnModel().getColumn(1);
    tb_usuarios.getColumnModel().getColumn(2);
    tb_usuarios.getColumnModel().getColumn(3);
    tb_usuarios.getColumnModel().getColumn(4);
    con_usuario.executeSQL("select * from login order by cod");
    
    DefaultTableModel modelo = (DefaultTableModel)tb_usuarios.getModel();
        //modelo.setNumRows(0);
        try{
            while (con_usuario.resultset.next())
                modelo.addRow(new Object [] {
                    con_usuario.resultset.getString("cod"),
                    con_usuario.resultset.getString("Nome"),
                    con_usuario.resultset.getString("Usuario"),
                    con_usuario.resultset.getString("Departamento"),
                    con_usuario.resultset.getString("Email")});
                    con_usuario.resultset.first();
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao listar tabela "+erro);
        }
}

    /**
     *
     */
    public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)tb_usuarios.getModel();
        for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
}

    /**
     *
     */
    public void limpar_tela(){
    txt_codigo.setText("");
    txt_login.setText("");
    txt_nome.setText("");
    txt_senha.setText("");
    txt_email.setText("");
    cb_departamento.setSelectedItem("");
        
}

    /**
     *
     */
    public void pode_editar(){
    txt_codigo.setEditable(false);
    txt_nome.setEditable(true);
    txt_senha.setEditable(true);
    txt_email.setEditable(true);    
    cb_departamento.setEditable(true);
}

    /**
     *
     */
    public void nao_edita(){
    txt_codigo.setEditable(false);
    txt_login.setEditable(false);
    txt_nome.setEditable(false);
    txt_senha.setEditable(false);
    txt_email.setEditable(false);    
    cb_departamento.setEditable(false);
}

    /**
     *
     */
    public void cria_backup(){
    codigo_backup = txt_codigo.getText();
    nome_backup = txt_nome.getText();
    login_backup = txt_login.getText();
    senha_backup = txt_senha.getText();
    email_backup = txt_email.getText();
    departamento_backup = (String) cb_departamento.getSelectedItem();

}

    /**
     *
     */
    public void recupera_backup(){
    txt_codigo.setText(codigo_backup);
    txt_nome.setText(nome_backup);
    txt_login.setText(login_backup);
    txt_senha.setText(senha_backup);
    txt_email.setText(email_backup);
    cb_departamento.setSelectedItem(departamento_backup);

}
}
