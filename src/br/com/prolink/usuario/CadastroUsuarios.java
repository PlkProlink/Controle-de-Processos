package br.com.prolink.usuario;

import javax.swing.table.*;
import java.sql.*;
import javax.swing.JOptionPane;
import br.com.prolink.factory.Conexao;
import br.com.prolink.model.UsuarioLogado;

/**
 *
 * @author Tiago Dias
 */
public class CadastroUsuarios extends javax.swing.JFrame {

    Conexao con = new Conexao();
    Conexao con_departamento = new Conexao();
   
    String privilegio, nivel_backup, codigo_backup, nome_backup, login_backup, senha_backup, email_backup, departamento_backup;
    
    int nivel=UsuarioLogado.getInstance().getUsuario().getNivel();
    String usuario=UsuarioLogado.getInstance().getUsuario().getUsuario(), 
            departamento=UsuarioLogado.getInstance().getUsuario().getDepartamento();
    
    /**
     *
     */
    public CadastroUsuarios() {
        initComponents();
                
                con.conecta();
                con_departamento.conecta();
                
                atualiza_combo_box_departamento();
                
                con_departamento.desconecta();
                
                nao_edita();
                
                
                preencher_tabela();
                
                if(nivel!=1){
                    btnAlterar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Você não tem autorização para alterar informações dos usuarios!"+
                            "\nPermitido apenas para gerentes e administradores de sistema");
                    cb_grupo.setEditable(false);
                    
                    try{
                        con.executeSQL("select * from login where Usuario='"+usuario+"' and Departamento='"+departamento+"'");
                        if(con.resultset.first()){
                            txt_codigo.setText(con.resultset.getString("cod"));
                            txt_nome.setText(con.resultset.getString("Nome"));
                            txt_login.setText(con.resultset.getString("Usuario"));
                            txt_senha.setText(con.resultset.getString("Senha"));
                            txt_senha2.setText(con.resultset.getString("Senha"));
                            txt_email.setText(con.resultset.getString("Email"));
                            cb_departamento.setSelectedItem(con.resultset.getString("Departamento"));
                            privilegio = con.resultset.getString("Nivel");
                            
                            if(privilegio.equals("1")){
                                cb_grupo.setSelectedItem("Privilegiado");
                            }
                            else
                                cb_grupo.setSelectedItem("Comum");
                        }
                    }catch(Exception ex){
                        
                    }
                    
                }
                

                
                
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
        cb_grupo = new javax.swing.JComboBox();
        lb_acesso = new javax.swing.JLabel();
        cb_departamento = new javax.swing.JComboBox();
        txt_login = new javax.swing.JTextField();
        lbSenha2 = new javax.swing.JLabel();
        txt_senha2 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_usuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        cb_grupo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_grupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Privilegiado", "Comun" }));

        lb_acesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_acesso.setText("Nivel de Acesso:");

        cb_departamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbSenha2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSenha2.setText("Confirmação:");

        txt_senha2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel_menuLayout.createSequentialGroup()
                            .addComponent(lbLogin)
                            .addGap(82, 82, 82)
                            .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbSenha)
                            .addGap(10, 10, 10)
                            .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbSenha2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_senha2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_menuLayout.createSequentialGroup()
                            .addComponent(lbDepartamento)
                            .addGap(32, 32, 32)
                            .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_acesso)
                            .addGap(10, 10, 10)
                            .addComponent(cb_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addGap(74, 74, 74)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addGap(79, 79, 79)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addGap(84, 84, 84)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbCodigo))
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbNome))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSenha2)
                        .addComponent(txt_senha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLogin)
                            .addComponent(lbSenha))))
                .addGap(14, 14, 14)
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbEmail))
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_menuLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDepartamento)
                                    .addComponent(lb_acesso)))))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        btnGravar.setText("Gravar");
        btnGravar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

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
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_novo, btnCancelar, btnExcluir, btnGravar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGravar)
                        .addComponent(btnExcluir)
                        .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_novo, btnCancelar, btnExcluir, btnGravar});

        btnGravar.getAccessibleContext().setAccessibleName("");
        btnExcluir.getAccessibleContext().setAccessibleName("");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(576, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        
        if (cb_grupo.getSelectedItem().equals("Privilegiado")){
            privilegio = "1";
        }
        else
            privilegio = "2";
        
        if(txt_nome.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo nome não pode fivar em branco!");
        }
        else if(txt_login.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo login não pode fivar em branco!");
        }
        else if(new String(txt_senha.getPassword()).trim().equals("")){
            JOptionPane.showMessageDialog(null, "Campo senha não pode fivar em branco!");
        }
        else if(!txt_codigo.getText().equals("")){
            
            try{
                if(nivel!=1 && !departamento.equals("Tecnologia") && txt_login.getText().equals(usuario)){
                    
                    if(cb_grupo.getSelectedItem().equals("Privilegiado")){
                    privilegio = "1";
                    }
                    else if(cb_grupo.getSelectedItem().equals("Comum")){
                    privilegio = "2";
                    }

                    String sql ="UPDATE login SET Usuario ='"+txt_login.getText()+"',"+
                            "Nome = '" +txt_nome.getText()+"',"+
                            "Departamento = '" +cb_departamento.getSelectedItem()+"',"+
                            "Email = '" +txt_email.getText()+"',"+
                            "Nivel = '" +privilegio+"' "+
                            "where cod = "+txt_codigo.getText();

                    con.statement.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"Alteração realizado com sucesso!");
                    limpar_tabela();
                    preencher_tabela();
                }
                else
                    JOptionPane.showMessageDialog(null,"Você não pode alterar o registro de outro usuario!");
                    
            } catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
            }
            
        }
        else if(txt_codigo.getText().equals("")){
            
            try{
                if(new String(txt_senha.getPassword()).equals(new String(txt_senha2.getPassword()))){
//                    if(txt_senha.getText().trim().equals("")){
//                        novasenha = senha_backup;
//                    }
//                    else{
//                        novasenha = txt_senha.getText();
//                    }
                    if(cb_grupo.getSelectedItem().equals("Privilegiado")){
                    privilegio = "1";
                    }
                    else if(cb_grupo.getSelectedItem().equals("Comum")){
                    privilegio = "2";
                    }
                    String gry = "insert into login (Usuario, Nome, Senha, Departamento, Email, Nivel) values ('"+
                                    txt_login.getText()+"','"+
                                    txt_nome.getText()+"','"+
                                    new String(txt_senha.getPassword())+"','"+
                                    cb_departamento.getSelectedItem()+"','"+
                                    txt_email.getText()+"','"+
                                    privilegio+"')";
                                    con.exeQuery(gry);

                    JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
                    limpar_tabela();
                    preencher_tabela();
                }
                else
                    JOptionPane.showMessageDialog(null,"Senhas não conferem!");
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
        txt_senha.setEditable(false);
        txt_senha2.setEditable(false);
        txt_senha.setText("********");
        txt_senha2.setText("********");
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Você não selecionou nenhum registro! Tente novamente! ");
        }
        else{
            
            try {
            String sql = "select * from login Where cod = "+txt_codigo.getText();
            con.executeSQL(sql);
            con.resultset.first();
            String nome = "Deletar o cadastro do funcionario : "+con.resultset.getString("Nome")+" ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION)
            {
                sql = "DELETE FROM login Where cod ="+txt_codigo.getText();
                int conseguiu_excluir = con.statement.executeUpdate(sql);
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
    }//GEN-LAST:event_btnExcluirActionPerformed

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
        String login = (String)tb_usuarios.getValueAt(linha, 2);
        String dp = (String)tb_usuarios.getValueAt(linha, 3);
        String email = (String)tb_usuarios.getValueAt(linha, 4);
        String grupo = (String)tb_usuarios.getValueAt(linha, 5);
        
        if(login.equalsIgnoreCase(usuario) && departamento.equalsIgnoreCase(dp)
                || nivel==1 || dp.equalsIgnoreCase("Tecnologia")){
            txt_codigo.setText(cod);
            txt_login.setText(usuario);
            txt_nome.setText(nome);
            txt_email.setText(email);
            cb_departamento.setSelectedItem(departamento);
			
			btnAlterar.setEnabled(true);
			
            if("1".equals(grupo)){
                cb_grupo.setSelectedItem("Privilegiado");
            }
            else
                cb_grupo.setSelectedItem("Comum");
            }
        else{
            JOptionPane.showMessageDialog(null, "Proibido alterar acesso de outra pessoa.");
        }
    }//GEN-LAST:event_tb_usuariosMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.desconecta();
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JComboBox cb_departamento;
    private javax.swing.JComboBox cb_grupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDepartamento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSenha2;
    private javax.swing.JLabel lb_acesso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JTable tb_usuarios;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JPasswordField txt_senha2;
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
    con.executeSQL("select * from login order by cod");
    
    DefaultTableModel modelo = (DefaultTableModel)tb_usuarios.getModel();
        //modelo.setNumRows(0);
        try{
            while (con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("cod"),
                    con.resultset.getString("Nome"),
                    con.resultset.getString("Usuario"),
                    con.resultset.getString("Departamento"),
                    con.resultset.getString("Email"),
                    con.resultset.getString("Nivel")});
                    con.resultset.first();
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
    txt_senha2.setText("");
    txt_email.setText("");
    cb_departamento.setSelectedItem("Comum");
        
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
    txt_senha2.setEditable(true);
}

    /**
     *
     */
    public void nao_edita(){
    txt_codigo.setEditable(false);
    txt_login.setEditable(false);
    txt_nome.setEditable(false);
    txt_senha.setEditable(false);
    txt_senha2.setEditable(false);
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
    senha_backup = new String(txt_senha.getPassword());
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
