package br.com.prolink.departamentos;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prolink.inicio.*;

/**
 *
 * @author User
 */
public class Contabil extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con_contabil, con_todos;
    //maskara para o JFormattedTextField
    MaskFormatter formatoTodos;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    String todos, processo = Ativador.processo, id = Ativador.id, nome = Ativador.nome,
            usuario = Login.usuario, codigo_backup, obs_backup, data_backup, tipo_backup;
    /**
     *
     */
    public Contabil() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        con_todos = new Conexao();
        con_todos.conecta();
        
        con_contabil = new Conexao();
        con_contabil.conecta();
        
        
        //chamando metodo que preencha as tabelas
        preencher_tabela_todos();
        //chamando metodo que preencha tela de status
        preencher_status();
        atualiza_cadastrocliente();
        limpar_tela_todos();
        bloqueia_tela();
        //chamando metodo que busca a data atual e envia para os campos de datas
                
        tb_todos.setAutoCreateRowSorter(true);
        
        txt_codigo.setText(processo);
        txt_nome.setText(nome);
        txt_id.setText(id);
        txt_usuario.setText(usuario);
        
        if(!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Contabil")){
            
            btnExcluir.setEnabled(false);
            btnSalvar.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "Você não tem permissão para editar os registros dessa tela!");
        }
        

    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContabil = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_cod = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        jtbGuiaContabil = new javax.swing.JTabbedPane();
        jpSitCont = new javax.swing.JPanel();
        lbTitFaseContabil = new javax.swing.JLabel();
        lbTitStatusContabil = new javax.swing.JLabel();
        lb_todos = new javax.swing.JLabel();
        txt_status_todos = new javax.swing.JLabel();
        txt_andamento_contabil = new javax.swing.JLabel();
        jpPerfil = new javax.swing.JPanel();
        lbcod_todos = new javax.swing.JLabel();
        txt_codigo_todos = new javax.swing.JTextField();
        lb_andamento_todos = new javax.swing.JLabel();
        lb_obs_todos = new javax.swing.JLabel();
        try {
     formatoTodos = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local termo: " +erro);
 }
        txt_data_todos = new JFormattedTextField(formatoTodos);
        lb_tipo_todos = new javax.swing.JLabel();
        cb_tipo_todos = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txt_obs_todos = new javax.swing.JTextArea();
        btNovos = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_todos = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle Contabil");

        jpContabil.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Contabil");
        lb_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lb_cod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_cod.setText("Nº:");

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Nome:");

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id.setText("ID:");

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtbGuiaContabil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpSitCont.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFaseContabil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFaseContabil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFaseContabil.setText("Fase:");

        lbTitStatusContabil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatusContabil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatusContabil.setText("Status:");

        lb_todos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_todos.setText("Todos os documentos Validados(Gerar Plano de Contas):");

        txt_status_todos.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_todos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_todos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_todos.setOpaque(true);

        txt_andamento_contabil.setBackground(new java.awt.Color(245, 245, 245));
        txt_andamento_contabil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_andamento_contabil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_andamento_contabil.setToolTipText("");
        txt_andamento_contabil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_andamento_contabil.setOpaque(true);

        javax.swing.GroupLayout jpSitContLayout = new javax.swing.GroupLayout(jpSitCont);
        jpSitCont.setLayout(jpSitContLayout);
        jpSitContLayout.setHorizontalGroup(
            jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitContLayout.createSequentialGroup()
                .addGroup(jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitContLayout.createSequentialGroup()
                        .addGroup(jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpSitContLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(lbTitFaseContabil, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpSitContLayout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(txt_andamento_contabil, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitContLayout.createSequentialGroup()
                        .addComponent(lb_todos)
                        .addGap(56, 56, 56)))
                .addGroup(jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTitStatusContabil, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_status_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jpSitContLayout.setVerticalGroup(
            jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitContLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitFaseContabil)
                    .addComponent(lbTitStatusContabil))
                .addGap(12, 12, 12)
                .addGroup(jpSitContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_status_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(237, 237, 237)
                .addComponent(txt_andamento_contabil, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaContabil.addTab("Situação", jpSitCont);

        jpPerfil.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_todos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_todos.setText("Cod:");

        lb_andamento_todos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_andamento_todos.setText("Data:");

        lb_obs_todos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_todos.setText("Observação:");

        lb_tipo_todos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_todos.setText("Tipo:");

        cb_tipo_todos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        txt_obs_todos.setColumns(20);
        txt_obs_todos.setLineWrap(true);
        txt_obs_todos.setRows(5);
        jScrollPane9.setViewportView(txt_obs_todos);

        btNovos.setText("Novo");
        btNovos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovosActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        tb_todos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Processo", "Data", "Tipo", "Observação", "Usuario"
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
        tb_todos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_todosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_todos);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPerfilLayout = new javax.swing.GroupLayout(jpPerfil);
        jpPerfil.setLayout(jpPerfilLayout);
        jpPerfilLayout.setHorizontalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_todos)
                .addGap(115, 115, 115)
                .addComponent(txt_codigo_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_andamento_todos)
                .addGap(111, 111, 111)
                .addComponent(txt_data_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_todos)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_todos)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btNovos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpPerfilLayout.setVerticalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_todos))
                    .addComponent(txt_codigo_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_andamento_todos))
                    .addComponent(txt_data_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_todos))
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_todos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_todos)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btNovos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaContabil.addTab("Todos Documentos Validados", jpPerfil);

        javax.swing.GroupLayout jpContabilLayout = new javax.swing.GroupLayout(jpContabil);
        jpContabil.setLayout(jpContabilLayout);
        jpContabilLayout.setHorizontalGroup(
            jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContabilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContabilLayout.createSequentialGroup()
                        .addGroup(jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_cod)
                            .addComponent(lb_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbGuiaContabil))
                .addContainerGap())
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpContabilLayout.setVerticalGroup(
            jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContabilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo)
                .addGap(18, 18, 18)
                .addGroup(jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_nome)
                        .addComponent(lb_cod)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpContabilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jtbGuiaContabil, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContabil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpContabil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_todosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_todosMouseClicked
        Integer linha = tb_todos.getSelectedRow();
        String codigo = (String)tb_todos.getValueAt(linha, 0);
        String data = (String)tb_todos.getValueAt(linha, 2);
        String tipo = (String)tb_todos.getValueAt(linha, 3);
        String observacao = (String)tb_todos.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;

        txt_data_todos.setText(recebedataTabela);

        txt_codigo_todos.setText(codigo);
        cb_tipo_todos.setSelectedItem(tipo);
        txt_obs_todos.setText(observacao);

    }//GEN-LAST:event_tb_todosMouseClicked

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_codigo_todos.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão!");
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from gerarplanodecontas where CodGerarPlanoDeContas= "+txt_codigo_todos.getText();
                con_todos.executeSQL(sql);
                con_todos.resultset.first();
                String cliente = "Tem certeza que deseja excluir um cadastro da tabela principal com cliente : " +con_todos.resultset.getString("Cliente")+"?";
                //pegando o processo sendo excluido
                String operacao = con_todos.resultset.getString("Tipo");
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM gerarplanodecontas Where CodGerarPlanoDeContas = "+txt_codigo_todos.getText();
                    int conseguiu_excluir = con_todos.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        //se excluir um cadastro finalizado ele vai atualizar o status e reabrir
                        if("Finalizado".equals(operacao)){
                            try{
                            con_todos.executeSQL("select * from gerarplanodecontas where NumeroProcesso='"+processo+"' and AndamentoGerarPlanoDeContas='Finalizado'");
                            //se não existir mais um em situação finalizada ele ira atualizar o status
                            if(!con_todos.resultset.last()){
                                try{
                                con_contabil.statement.executeUpdate("UPDATE contabil set AndamentoGerarPlanoDeContas ='Em Aberto' where Numerodoprocesso='" +processo+"'");
                                
                                limpar_tela_todos();
                                limpar_tabela_todos();
                                preencher_tabela_todos();
                                preencher_status();
                                atualiza_cadastrocliente();
                                
                                }catch(SQLException erro){
                                    JOptionPane.showMessageDialog(null, " Falha ao atualizar a tabela Plano de Contas:\n" +erro);
                                }
                            }
                            }catch(SQLException erro){
                                JOptionPane.showMessageDialog(null, "Falha ao abrir o status!\n"+erro);
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro!\n"+erro);
            }
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restaura_backup();
        bloqueia_tela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_todos.getText().equals("  /  /    ") || txt_data_todos.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
            txt_data_todos.requestFocus(true);
        }
        else if(cb_tipo_todos.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_todos.requestFocus();
        }
        else if(!txt_codigo_todos.getText().equals("")){
            try{

                String dataandamento = txt_data_todos.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamentotermo;

                if(cb_tipo_todos.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                }
                else{
                    andamentotermo = "Em Aberto";

                }
                String sql = "UPDATE gerarplanodecontas set DatadeCadastroAndamento='"+
                new java.sql.Date(datatermo.getTime())+"',"+
                "Obsevacao='"+txt_obs_todos.getText()+"',"+
                "Usuario = '"+txt_usuario.getText()+"',"+
                "AndamentoGerarPlanoDeContas='"+andamentotermo+"',"+
                "Tipo='"+cb_tipo_todos.getSelectedItem()+"' "+
                "where CodGerarPlanoDeContas = "+txt_codigo_todos.getText();

                con_todos.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

                atualiza_contabil_todos();
                preencher_status();
                atualiza_cadastrocliente();
                limpar_tabela_todos();
                preencher_tabela_todos();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados da tabela Plano de Contas: " +erro);
            }catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conversao da data ou data invalida!\n"+ex);
            }
        }
        else if(txt_codigo_todos.getText().equals("")){
            try{
                //convertendo a primeira data
                String dataandamento = txt_data_todos.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamentotermo;
                if(cb_tipo_todos.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                }
                else{
                    andamentotermo = "Em Aberto";
                }

                String gry = "insert into gerarplanodecontas ("+
                "NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"+
                "Cliente, Usuario, AndamentoGerarPlanodeContas, Tipo) values ('"+processo+"','"+
                new java.sql.Date(datatermo.getTime())+"','"+
                txt_obs_todos.getText()+"','"+
                txt_nome.getText()+"','"+
                txt_usuario.getText()+"','"+
                andamentotermo+"','"+
                cb_tipo_todos.getSelectedItem()+"')";

                con_todos.exeQuery(gry);

                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                atualiza_contabil_todos();
                preencher_status();
                atualiza_cadastrocliente();
                limpar_tabela_todos();
                preencher_tabela_todos();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Plano de Contas: "+add);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btNovosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovosActionPerformed
        cria_backup();
        desbloqueia_tela();
        limpar_tela_todos();
    }//GEN-LAST:event_btNovosActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        cria_backup();
        desbloqueia_tela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            Contabil reg = new Contabil();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNovos;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cb_tipo_todos;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JPanel jpContabil;
    private javax.swing.JPanel jpPerfil;
    private javax.swing.JPanel jpSitCont;
    private javax.swing.JTabbedPane jtbGuiaContabil;
    private javax.swing.JLabel lbTitFaseContabil;
    private javax.swing.JLabel lbTitStatusContabil;
    private javax.swing.JLabel lb_andamento_todos;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_obs_todos;
    private javax.swing.JLabel lb_tipo_todos;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lb_todos;
    private javax.swing.JLabel lbcod_todos;
    private javax.swing.JTable tb_todos;
    public static javax.swing.JLabel txt_andamento_contabil;
    public static javax.swing.JLabel txt_codigo;
    private javax.swing.JTextField txt_codigo_todos;
    private javax.swing.JFormattedTextField txt_data_todos;
    public static javax.swing.JLabel txt_id;
    public static javax.swing.JLabel txt_nome;
    private javax.swing.JTextArea txt_obs_todos;
    public static javax.swing.JLabel txt_status_todos;
    public static javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables


        public void preencher_tabela_todos(){
        tb_todos.getColumnModel().getColumn(0);
        tb_todos.getColumnModel().getColumn(1);
        tb_todos.getColumnModel().getColumn(2);
        tb_todos.getColumnModel().getColumn(3);
        tb_todos.getColumnModel().getColumn(4);
        tb_todos.getColumnModel().getColumn(5);
        con_todos.executeSQL("select * from gerarplanodecontas where NumeroProcesso='"+processo+"' order by CodGerarPlanoDeContas");

        DefaultTableModel modelo = (DefaultTableModel)tb_todos.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con_todos.resultset.next())
                modelo.addRow(new Object [] {
                    con_todos.resultset.getString("CodGerarPlanoDeContas"),
                    con_todos.resultset.getString("NumeroProcesso"),
                    sdf.format(con_todos.resultset.getTime("DatadeCadastroAndamento")),
                    con_todos.resultset.getString("Tipo"),                    
                    con_todos.resultset.getString("Obsevacao"),
                    con_todos.resultset.getString("Usuario")});
            con_todos.resultset.first();
        }   catch (SQLException erro){
                JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Perfil "+erro);
        }
}

    /**
     *
     */
    public void limpar_tabela_todos(){
        DefaultTableModel tbm = (DefaultTableModel)tb_todos.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    /**
     *
     */
    public void preencher_status(){
        try{
            String sql = "select * from contabil WHERE Numerodoprocesso='"+processo+"'";
            con_contabil.executeSQL(sql);
            con_contabil.resultset.first();
            
            todos = con_contabil.resultset.getString("AndamentoGerarPlanoDeContas");
            
            txt_status_todos.setText(todos);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a tabela Contabil!" +erro);
        }
    }

    /**
     *
     */
    public void atualiza_cadastrocliente(){
        if(txt_status_todos.getText().equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoContabil='Concluido' where codNumerodoprocesso="+processo;
                    con_contabil.statement.executeUpdate(sql);

                    String andamento = "Concluido";
                    txt_andamento_contabil.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(txt_status_todos.getText().equalsIgnoreCase("Em Aberto")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoContabil='Em Aberto' where codNumerodoprocesso=" +processo;
                    con_contabil.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txt_andamento_contabil.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else{
                    String andamento = "Em Aberto";
                    txt_andamento_contabil.setText(andamento);
        }
                
        distribuir_cores();
    }


    public void distribuir_cores(){
        if(txt_status_todos.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_todos.setBackground(Color.red);
        }
        else{
            txt_status_todos.setBackground(Color.green);
        }
        if(txt_andamento_contabil.getText().equalsIgnoreCase("Concluido")){
            txt_andamento_contabil.setBackground(Color.green);
        }
        else if(txt_andamento_contabil.getText().equalsIgnoreCase("Em Andamento")){
            txt_andamento_contabil.setBackground(Color.orange);
        }
        else{
            txt_andamento_contabil.setBackground(Color.red);
        }
    }

    /**
     *
     */
    public void limpar_tela_todos(){
        txt_codigo_todos.setText("");
        txt_obs_todos.setText("");
        txt_codigo_todos.setEditable(false);
        cb_tipo_todos.setSelectedItem("Novo Andamento");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_todos.setText(datahoje);
        
    }

    /**
     *
     */
    public void atualiza_contabil_todos(){
        if(cb_tipo_todos.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE contabil set AndamentoGerarPlanoDeContas ='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_contabil.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contabil>Plano de Contas\n" +erro);
                    }
                }
        else{
            try{    
                    con_contabil.executeSQL("select * from contabil where Numerodoprocesso='" +processo+"' and AndamentoGerarPlanoDeContas ='Finalizado'");
                if(con_contabil.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados no painel Todos Documentos\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_todos.executeSQL("select * from gerarplanodecontas where NumeroProcesso='"+processo+"'and AndamentoGerarPlanoDeContas='Finalizado'");
                    
                    if(!con_todos.resultset.last()){
                        try{
                
                        String sql = "UPDATE contabil set AndamentoGerarPlanoDeContas ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_contabil.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contabil>Plano de Contas\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                
                        String sql = "UPDATE contabil set AndamentoGerarPlanoDeContas ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_contabil.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contabil>Plano de Contas\n" +erro);
                    }
                         
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao buscar status na tabela Contabil>Plano de Contas: \n" +erro);
            }
        }
    }

    public void bloqueia_tela(){
        txt_obs_todos.setEditable(false);
        cb_tipo_todos.setEditable(false);
        txt_data_todos.setEditable(false);
    }

    public void desbloqueia_tela(){
        txt_obs_todos.setEditable(true);
        cb_tipo_todos.setEditable(true);
        txt_data_todos.setEditable(true);
    }

    public void cria_backup(){
        codigo_backup = txt_codigo_todos.getText();
        tipo_backup = (String)cb_tipo_todos.getSelectedItem();
        data_backup = txt_data_todos.getText();
        obs_backup = txt_obs_todos.getText();
    }

    public void restaura_backup(){
        txt_codigo_todos.setText(codigo_backup);
        cb_tipo_todos.setSelectedItem(tipo_backup);
        txt_data_todos.setText(data_backup);
        txt_obs_todos.setText(obs_backup);
    }
}