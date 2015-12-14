package br.com.prolink.documentos.internas;

import br.com.prolink.documentos.*;
import br.com.prolink.controle.*;
import br.com.prolink.inicio.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Tiago Dias
 */
public class DocumentosIntDocumentosSocios extends javax.swing.JInternalFrame {
    
    Conexao conexao;
    
    MaskFormatter formatoData1, formatoData2, formatoData3;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Date novadata1, novadata2, novadata3;
    String acao, descricao, datahoje, data1, data2, data3, 
            data1_backup, data2_backup, data3_backup, obs_backup, codigo_backup;
    
    String nome=Ativador.nome, processo=Ativador.processo, usuario=Login.usuario;
    
    DocumentosDao doc = new DocumentosDao();
    LogUsuarioDao log = new LogUsuarioDao();
    LogUsuarioBean logb = new LogUsuarioBean();
    
    public DocumentosIntDocumentosSocios() {
        initComponents();
        
        conexao = new Conexao();
        conexao.conecta();
        
        tabela.setAutoCreateRowSorter(true);
        
        txtCodigo.setEditable(false);
        
        //bloquear_campos();
        
        btnAlterar.setEnabled(false);
        
        preencher_tabela();
        
        pegar_ultimo_registro();
       
        logb.setCliente(Ativador.nome);
        logb.setApelido(Ativador.id);
        logb.setProcesso(Ativador.processo);
        logb.setTela("Documentos dos Socios");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lbEnvio1 = new javax.swing.JLabel();
        try{
            formatoData1 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao receber data (Boleto)\n" +erro);
        }
        txtData1 = new JFormattedTextField(formatoData1);
        lbEnvio2 = new javax.swing.JLabel();
        try{
            formatoData2 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao receber data (Boleto)\n" +erro);
        }
        txtData2 = new JFormattedTextField(formatoData2);
        lbEnvio3 = new javax.swing.JLabel();
        try{
            formatoData3 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao receber data (Boleto)\n" +erro);
        }
        txtData3 = new JFormattedTextField(formatoData3);
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbObservacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        btnExcluir = new javax.swing.JButton();
        lbMensagem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setTitle("Contratos - Documentos do Socios(RG e CPF)");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        lbCodigo.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCodigo.setText("Codigo:");

        txtCodigo.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        lbEnvio1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbEnvio1.setText("1º Envio:");

        txtData1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        lbEnvio2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbEnvio2.setText("2º Envio:");

        txtData2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        lbEnvio3.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbEnvio3.setText("3º Envio:");

        txtData3.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        btnNovo.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbObservacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbObservacao.setText("Observação:");

        txtObservacao.setColumns(20);
        txtObservacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txtObservacao.setLineWrap(true);
        txtObservacao.setRows(5);
        jScrollPane2.setViewportView(txtObservacao);

        btnExcluir.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lbMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEnvio1)
                            .addComponent(lbEnvio2)
                            .addComponent(lbEnvio3)
                            .addComponent(lbCodigo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txtData2)
                            .addComponent(txtData1))
                        .addGap(121, 121, 121)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbObservacao)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGravar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnCancelar, btnGravar, btnNovo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEnvio1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEnvio2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEnvio3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlterar)
                    .addComponent(btnGravar)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAlterar, btnCancelar, btnGravar, btnNovo});

        tabela.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Envio p/ Cliente", "Recebido do Cliente", "Validação Depart.", "Obs:", "Usuario"
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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMaxWidth(50);
            tabela.getColumnModel().getColumn(4).setMaxWidth(50);
            tabela.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 500, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        this.setLocation(0,0);
    }//GEN-LAST:event_formComponentMoved

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        criar_backup();
        limpar_campos();
        desbloquear_campos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        criar_backup();
        desbloquear_campos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        data1 = txtData1.getText();
        data2 = txtData2.getText();
        data3 = txtData3.getText();
        
        //JOptionPane.showMessageDialog(null, "Data atual: "+datahoje+ "\nData1: "+new java.sql.Date(novadata1.getTime())+
        //                                "\nData2: "+ new java.sql.Date(novadata2.getTime())+
        //                                "\nData3: "+ new java.sql.Date(novadata3.getTime()));
        
        if(data1.trim().length()<10){
            JOptionPane.showMessageDialog(null, "1º data de envio não informado ou incorreto!");
        }
        else if(data2.trim().length()==10 && data1.trim().length()<10){
            JOptionPane.showMessageDialog(null, "2º data de envio não é permitido se a 1º não for informada");
        }
        else if(data3.trim().length()==10 && data1.trim().length()<10 || data2.trim().length()<10 && data3.trim().length()==10){
            JOptionPane.showMessageDialog(null, "3º data de envio não é permitido se a 1º e 2º não forem informadas");
        }
        
        else if(txtCodigo.getText().equals("")){
            
                if(data1.trim().length()==10 
                        && data2.trim().length()==10 
                        && data3.trim().length()==10){
                    try{
                        
                        converter_data1();
                        converter_data2();
                        converter_data3();
                        
                        String gry = "insert into rgecpfsocio "
                                + "(NumeroProcesso, Usuario, "
                                + "Obsevacao, DatadeCadastroAndamento, DataDevulucaoCliente, "
                                + "DataFinalAndamento, Andamento) values ('"
                                + processo+"','"
                                + usuario+"','"
                                + txtObservacao.getText()+"','"
                                + new java.sql.Date(novadata1.getTime())+"','"
                                + new java.sql.Date(novadata2.getTime())+"','"
                                + new java.sql.Date(novadata3.getTime())+"','"
                                + "Validação Efetuada')";
                                
                        conexao.exeQuery(gry);
                        
                        String mensagem = "Inserido com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        enviar_label1();
                        enviar_label2();
                        enviar_label3();
                        
                        atualizar_documentos3();
                        
                        acao = "Inclusão";
                        descricao = "1º, 2º e 3º "+logb.getTela()+" informado";
                        
                        gravar_log();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n"+erro);
                    }   
                }
                else if(data1.trim().length()==10
                    && data2.trim().length()==10
                    && data3.trim().length()<10){
                    try{
                        
                        converter_data1();
                        converter_data2();
                        
                        String gry = "insert into rgecpfsocio "
                                + "(NumeroProcesso, Usuario, "
                                + "Obsevacao, DatadeCadastroAndamento, "
                                + "DataFinalAndamento, Andamento) values ('"
                                + processo+"','"
                                + usuario+"','"
                                + txtObservacao.getText()+"','"
                                + new java.sql.Date(novadata1.getTime())+"','"
                                + new java.sql.Date(novadata2.getTime())+"','"
                                + "Aguardando Validação')";
                                
                        conexao.exeQuery(gry);
                        
                        String mensagem = "Inserido com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizar_documentos2();
                        
                        acao = "Inclusão";
                        descricao = "1º e 2º "+logb.getTela()+" informado";
                        
                        gravar_log();
                        
                        enviar_label1();
                        enviar_label2();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n"+erro);
                    }
                }
                else if(data1.trim().length()==10
                    && data2.trim().length()<10
                    && data3.trim().length()<10){
                    try{
                        converter_data1();
                        
                        String gry = "insert into rgecpfsocio "
                                + "(NumeroProcesso, Usuario, "
                                + "Obsevacao, DatadeCadastroAndamento, "
                                + "Andamento) values ('"
                                + processo+"','"
                                + usuario+"','"
                                + txtObservacao.getText()+"','"
                                + new java.sql.Date(novadata1.getTime())+"','"
                                + "Enviado para o Cliente')";
                                
                        conexao.exeQuery(gry);
                        
                        String mensagem = "Inserido com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizar_documentos1();
                        
                        acao = "Inclusão";
                        descricao = "1º "+logb.getTela()+" informado";
                        
                        gravar_log();
                        
                        enviar_label1();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n"+erro);
                    }
                }
        }
        else if (!txtCodigo.getText().equals("")){
            if(data1.trim().length()==10
                && data2.trim().length()==10
                && data3.trim().length()==10){
                    try{
                        converter_data1();
                        converter_data2();
                        converter_data3();
                        
                        String sql = "update rgecpfsocio set "
                                +"Usuario='" +usuario+"',"
                                +"Obsevacao='" +txtObservacao.getText()+"',"
                                +"DatadeCadastroAndamento='" +new java.sql.Date(novadata1.getTime())+"',"
                                +"DataDevulucaoCliente='" +new java.sql.Date(novadata2.getTime())+"',"
                                +"DataFinalAndamento='" +new java.sql.Date(novadata3.getTime())+"',"
                                +"Andamento='Validação Efetuada' where Cod="+txtCodigo.getText();
                        conexao.statement.executeUpdate(sql);
                        
                        String mensagem = "Atualizado com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizar_documentos3();
                        
                        acao = "Atualização";
                        descricao = "1º, 2º e 3º "+logb.getTela()+" informado";
                        
                        gravar_log();
                        
                        enviar_label1();
                        enviar_label2();
                        enviar_label3();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n"+erro);
                    }   
                }
                else if(data1.trim().length()==10
                    && data2.trim().length()==10
                    && data3.trim().length()<10){
                    try{
                        converter_data1();
                        converter_data2();
                        
                        String sql = "update rgecpfsocio set "
                                +"Usuario='" +usuario+"',"
                                +"Obsevacao='" +txtObservacao.getText()+"',"
                                +"DatadeCadastroAndamento='" +new java.sql.Date(novadata1.getTime())+"',"
                                +"DataDevulucaoCliente='" +new java.sql.Date(novadata2.getTime())+"',"
                                +"Andamento='Aguardando Validação' where Cod="+txtCodigo.getText();
                        conexao.statement.executeUpdate(sql);
                        
                        String mensagem = "Atualizado com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizar_documentos2();
                        
                        acao = "Atualização";
                        descricao = "1º, 2º "+logb.getTela()+" informado";
                        
                        gravar_log();
                        
                        enviar_label1();
                        enviar_label2();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n"+erro);
                    }
                }
                else if(data1.trim().length()==10
                    && data2.trim().length()<10
                    && data3.trim().length()<10){
                    try{
                        converter_data1();
                        
                        String sql = "update rgecpfsocio set "
                                +"Usuario='" +usuario+"',"
                                +"Obsevacao='" +txtObservacao.getText()+"',"
                                +"DatadeCadastroAndamento='" +new java.sql.Date(novadata1.getTime())+"',"
                                +"DataDevulucaoCliente='" +new java.sql.Date(novadata2.getTime())+"',"
                                +"Andamento='Enviado para o Cliente' where Cod="+txtCodigo.getText();
                        conexao.statement.executeUpdate(sql);
                        
                        atualizar_documentos1();
                        
                        String mensagem = "Atualizado com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        acao = "Atualização";
                        descricao = "1º "+logb.getTela()+" informado";
                        
                        gravar_log();
                        
                        enviar_label1();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                    }catch(Exception erro){
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar o registro\n"+erro);
                    }
                }
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restaurar_backup();
        //bloquear_campos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão");
        }
        else{
            String cliente = "Deseja excluir o registro do cliente "+Ativador.nome+"?";
            int escolha = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
            if(escolha==JOptionPane.YES_OPTION){
                try{
                    int excluiu = conexao.statement.executeUpdate("delete from rgecpfsocio where Cod="+txtCodigo.getText());
                    if(excluiu == 1){
                        String mensagem = "Removido com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizar_acompanhamento_exclusao();
                        
                        acao = "Exclusão";
                        descricao = "Registro removido";
                        
                        gravar_log();
                        
                        doc.docSocios();
                        
                        //bloquear_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                    }
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Erro na exclusão! \n"+erro);
                }
            }
            
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        Integer linha = tabela.getSelectedRow();
        String codigo = (String)tabela.getValueAt(linha, 0);
        String tdata1 = (String)tabela.getValueAt(linha, 1);
        String tdata2 = (String)tabela.getValueAt(linha, 2);
        String tdata3 = (String)tabela.getValueAt(linha, 3);
        String obs = (String)tabela.getValueAt(linha, 4);
        
        txtCodigo.setText(codigo);
        txtObservacao.setText(obs);
     
        
        try{
            if(tdata1.length()==10 && !tdata1.equals("1111-11-11")){
                String ano = tdata1.substring(0, 4);
                String mes = tdata1.substring(5, 7);
                String dia = tdata1.substring(8);
                String recebeData = dia+"/"+mes+"/"+ano;

                txtData1.setText(recebeData);
            }
        }catch(Exception erro){
            
        }
        try{
            if(tdata2.length()==10 && !tdata2.equals("1111-11-11")){
                String ano = tdata2.substring(0, 4);
                String mes = tdata2.substring(5, 7);
                String dia = tdata2.substring(8);
                String recebeData = dia+"/"+mes+"/"+ano;

                txtData2.setText(recebeData);
            }
        }catch(Exception erro){
            
        }
        try{
            if(tdata3.length()==10 && !tdata3.equals("1111-11-11")){
                String ano = tdata3.substring(0, 4);
                String mes = tdata3.substring(5, 7);
                String dia = tdata3.substring(8);
                String recebeData = dia+"/"+mes+"/"+ano;

                txtData3.setText(recebeData);
            }
        }catch(Exception erro){
        }
        
    }//GEN-LAST:event_tabelaMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        conexao.desconecta();
    }//GEN-LAST:event_formInternalFrameClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentosIntDocumentosSocios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbEnvio1;
    private javax.swing.JLabel lbEnvio2;
    private javax.swing.JLabel lbEnvio3;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JLabel lbObservacao;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    private javax.swing.JFormattedTextField txtData3;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables
public void pegar_ultimo_registro(){
        
        conexao.executeSQL("select * from rgecpfsocio where NumeroProcesso='"+processo+"'");
        try {
            if(conexao.resultset.last()){
                String novocodigo , ndata1, ndata2, ndata3;
                
                novocodigo = conexao.resultset.getString("Cod");
                
                data1 = conexao.resultset.getString("DatadeCadastroAndamento");
                data2 = conexao.resultset.getString("DataDevulucaoCliente");
                data3 = conexao.resultset.getString("DataFinalAndamento");
                
                if(!"".equals(novocodigo) || novocodigo != null){
                    
                    txtCodigo.setText(novocodigo);
                    txtObservacao.setText(conexao.resultset.getString("Obsevacao"));
                    
                    if(data1.trim().length()==10 && !data1.equals("1111-11-11") ){
                        
                        String ano = data1.substring(0, 4);
                        String mes = data1.substring(5, 7);
                        String dia = data1.substring(8);
                        ndata1 = dia+"/"+mes+"/"+ano;
                        txtData1.setText(ndata1);
                    }
                  if(data2.length()==10 && !data2.equals("1111-11-11") ){
                        String ano = data2.substring(0, 4);
                        String mes = data2.substring(5, 7);
                        String dia = data2.substring(8);
                        ndata2 = dia+"/"+mes+"/"+ano;
                        txtData2.setText(ndata2);
                    }
                    if(data3.length()==10 && !data3.equals("1111-11-11") ){
                        String ano = data3.substring(0, 4);
                        String mes = data3.substring(5, 7);
                        String dia = data3.substring(8);
                        ndata3 = dia+"/"+mes+"/"+ano;
                        txtData3.setText(ndata3);
                    }
                   
                }
            }
        } catch (Exception ex) {
        }
}
public void preencher_tabela(){
    tabela.getColumnModel().getColumn(0);
    tabela.getColumnModel().getColumn(1);
    tabela.getColumnModel().getColumn(2);
    tabela.getColumnModel().getColumn(3);
    tabela.getColumnModel().getColumn(4);
    tabela.getColumnModel().getColumn(5);
    
    conexao.executeSQL("select * from rgecpfsocio where NumeroProcesso='"+processo+"'");
    
    DefaultTableModel modelo =(DefaultTableModel)tabela.getModel();
    
    try{
        while(conexao.resultset.next())
            modelo.addRow(new Object []{
                conexao.resultset.getString("Cod"),
                conexao.resultset.getString("DatadeCadastroAndamento"),
                conexao.resultset.getString("DataDevulucaoCliente"),
                conexao.resultset.getString("DataFinalAndamento"),
                conexao.resultset.getString("Obsevacao"),
                conexao.resultset.getString("Usuario")});
                conexao.resultset.first();
    }catch(Exception erro){
        JOptionPane.showMessageDialog(null, "Erro ao preencher tabela da tela" +logb.getTela()+" !\n"+erro);
    }
            
}
public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)tabela.getModel();
    for(int i=tbm.getRowCount()-1; i>=0; i--){
        tbm.removeRow(i);
    }
}
public void criar_backup(){
    codigo_backup = txtCodigo.getText();
    data1_backup = txtData1.getText();
    data2_backup = txtData2.getText();
    data3_backup = txtData3.getText();
    obs_backup = txtObservacao.getText();
}
public void restaurar_backup(){
    txtCodigo.setText(codigo_backup);
    txtData1.setText(data1_backup);
    txtData2.setText(data2_backup);
    txtData3.setText(data3_backup);
    txtObservacao.setText(obs_backup);
}
public void bloquear_campos(){
    txtData1.setEditable(false);
    txtData2.setEditable(false);
    txtData3.setEditable(false);
    txtObservacao.setEditable(false);
}
public void desbloquear_campos(){
    txtData1.setEditable(true);
    txtData2.setEditable(true);
    txtData3.setEditable(true);
    txtObservacao.setEditable(true);
    lbMensagem.setText("");
}
public void limpar_campos(){
    txtCodigo.setText("");
    txtData1.setText("");
    txtData2.setText("");
    txtData3.setText("");
    txtObservacao.setText("");
}
public void converter_data_atual(){
    Date data = new Date();
    String dataatual = sdf.format(data);
    
    String dia = dataatual.substring(0, 2);
    String mes = dataatual.substring(3, 5);
    String ano = dataatual.substring(6);
    datahoje = ano+"-"+mes+"-"+dia;

}
public void converter_data1(){
    try{
        novadata1 = sdf.parse(data1);
   }catch(ParseException e){
        JOptionPane.showMessageDialog(null, "1ª data informada esta incorreta!");
    }
    /*
    String dia1 = data1.substring(0, 2);
    String mes1 = data1.substring(3, 5);
    String ano1 = data1.substring(6);
    novadata1 = ano1+"-"+mes1+"-"+dia1;
            */
}
public void converter_data2(){
    try{
        novadata2 = sdf.parse(data2);
    }catch(ParseException e){
        JOptionPane.showMessageDialog(null, "2ª data informada esta incorreta!");
    }
    /*
    String dia2 = data2.substring(0, 2);
    String mes2 = data2.substring(3, 5);
    String ano2 = data2.substring(6);
    novadata2 = ano2+"-"+mes2+"-"+dia2;
    */
}
public void converter_data3(){
    try{
        novadata3 = sdf.parse(data3);
    }catch(ParseException e){
        JOptionPane.showMessageDialog(null, "3ª data informada esta incorreta");
    }
    /*
    String dia3 = data3.substring(0, 2);
    String mes3 = data3.substring(3, 5);
    String ano3 = data3.substring(6);
    novadata3 = ano3+"-"+mes3+"-"+dia3;
            */
}
public void enviar_label1(){
    Documentos.lbDoc1.setText(data1);
}
public void enviar_label2(){
    Documentos.lbDoc2.setText(data2);
}
public void enviar_label3(){
    Documentos.lbDoc3.setText(data3);
}
public void gravar_log(){
    logb.setAcao(acao);
    logb.setDescricao(descricao);
    
    log.inserir(logb);
}
public void atualizar_documentos1(){
    try{
    conexao.statement.executeUpdate("update documentos set "
                                        + "RGeCPFSocio='Enviado para o Cliente' where Numerodoprocesso='"+processo+"'");
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +logb.getTela());
    }
}
public void atualizar_documentos2(){
    try{
    conexao.statement.executeUpdate("update documentos set "
                                        + "RGeCPFSocio='Aguardando Validação' where Numerodoprocesso='"+processo+"'");
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +logb.getTela());
    }
}
public void atualizar_documentos3(){
    try{
    conexao.statement.executeUpdate("update documentos set "
                                        + "RGeCPFSocio='Validação Efetuada' where Numerodoprocesso='"+processo+"'");
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ao atualizar documentos: tela>" +logb.getTela());
    }
}
public void atualizar_acompanhamento_exclusao(){
    if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()==10 &&
            txtData3.getText().trim().length()==10){
        atualizar_documentos3();
    }
    else if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()==10 &&
            txtData3.getText().trim().length()<10){
        atualizar_documentos2();
    }
    else if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()<10 &&
            txtData3.getText().trim().length()<10){
        atualizar_documentos1();
    }
}
}
