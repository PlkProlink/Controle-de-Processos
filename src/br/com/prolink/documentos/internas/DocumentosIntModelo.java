package br.com.prolink.documentos.internas;

import br.com.prolink.documentos.*;
import br.com.prolink.controle.*;
import br.com.prolink.inicio.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import com.towel.swing.calendar.CalendarView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Tiago Dias
 */
public class DocumentosIntModelo extends javax.swing.JInternalFrame {
    
    Conexao conexao;
    
    MaskFormatter formatoData1, formatoData2, formatoData3;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Date novadata1, novadata2, novadata3;
    String acao, descricao, datahoje, data1, data2, data3, 
            data1_backup, data2_backup, data3_backup, obs_backup, codigo_backup;
    
    String campoDocumentos; //campo da tabela documentos
    String tabela; //tabela do formulario
    String tela;
    
    String nome=TelaPrincipal.txt_nome.getText(), processo=TelaPrincipal.txt_codigo.getText(), usuario=TelaPrincipal.txt_usuario.getText();
    
    AtualizaDocumentos atualizaDoc;
    
    DocumentosDao doc;
    LogUsuarioDao log;
    LogUsuarioBean logb;
    JDialog dialog;
    
    public DocumentosIntModelo() {
        initComponents();
    
        table.setAutoCreateRowSorter(true);
        
        txtCodigo.setEditable(false);
        
        //bloquear_campos();
        
        btnAlterar.setEnabled(false);
        
//        preencher_tabela();
//        
//        pegar_ultimo_registro();
        
        doc = new DocumentosDao();
        log = new LogUsuarioDao();
        logb = new LogUsuarioBean();
        
        logb.setCliente(nome);
        logb.setApelido(TelaPrincipal.txt_id.getText());
        logb.setProcesso(processo);
        logb.setTela(tela);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lbEnvio1 = new javax.swing.JLabel();
        lbEnvio2 = new javax.swing.JLabel();
        lbEnvio3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbObservacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        btnExcluir = new javax.swing.JButton();
        lbMensagem = new javax.swing.JLabel();
        txtData1 = new com.towel.swing.calendar.CalendarView();
        txtData2 = new com.towel.swing.calendar.CalendarView();
        txtData3 = new com.towel.swing.calendar.CalendarView();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setTitle("Contratos - Ato Constitutivo");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Codigo:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbEnvio1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEnvio1.setText("Solicitado:");

        lbEnvio2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEnvio2.setText("Recebido:");

        lbEnvio3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEnvio3.setText("Validado:");

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNovo.setContentAreaFilled(false);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.setContentAreaFilled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGravar.setContentAreaFilled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbObservacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObservacao.setText("Observação:");

        txtObservacao.setColumns(20);
        txtObservacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtObservacao.setLineWrap(true);
        txtObservacao.setRows(5);
        txtObservacao.setToolTipText("");
        jScrollPane2.setViewportView(txtObservacao);

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lbMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtData1.setOpaque(false);

        txtData2.setOpaque(false);

        txtData3.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbEnvio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lbEnvio3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbEnvio2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtData2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbObservacao)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtData1, txtData2, txtData3});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbCodigo)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lbObservacao)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbEnvio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbEnvio2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbEnvio3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Solicitação Enviada", "Recebido do Cliente", "Validação Depart.", "Obs:", "Usuario"
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
        table.setRowSelectionAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(4).setMaxWidth(50);
            table.getColumnModel().getColumn(5).setMaxWidth(70);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        
        setTela();
        setCampoDocumentos();
        setTabela();
        
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
                        
                        String gry = "insert into "+tabela
                                + " (NumeroProcesso, Usuario, "
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
                        
                        atualizaDoc = new AtualizaDocumentos();
                        atualizaDoc.atualizar_documentos3(tela, campoDocumentos);
                        
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
                        
                        String gry = "insert into "+tabela
                                + " (NumeroProcesso, Usuario, "
                                + "Obsevacao, DatadeCadastroAndamento, "
                                + "DataDevulucaoCliente, Andamento) values ('"
                                + processo+"','"
                                + usuario+"','"
                                + txtObservacao.getText()+"','"
                                + new java.sql.Date(novadata1.getTime())+"','"
                                + new java.sql.Date(novadata2.getTime())+"','"
                                + "Aguardando Validação')";
                                
                        conexao.exeQuery(gry);
                        
                        String mensagem = "Inserido com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizaDoc = new AtualizaDocumentos();
                        atualizaDoc.atualizar_documentos2(tela, campoDocumentos);
                        
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
                        
                        String gry = "insert into "+tabela
                                + " (NumeroProcesso, Usuario, "
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
                        
                        atualizaDoc = new AtualizaDocumentos();
                        atualizaDoc.atualizar_documentos1(tela, campoDocumentos);
                        
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
                        
                        String sql = "update "+tabela+" set "
                                +"Usuario='" +usuario+"',"
                                +"Obsevacao='" +txtObservacao.getText()+"',"
                                +"DatadeCadastroAndamento='" +new java.sql.Date(novadata1.getTime())+"',"
                                +"DataDevulucaoCliente='" +new java.sql.Date(novadata2.getTime())+"',"
                                +"DataFinalAndamento='" +new java.sql.Date(novadata3.getTime())+"',"
                                +"Andamento='Validação Efetuada' where Cod="+txtCodigo.getText();
                        conexao.statement.executeUpdate(sql);
                        
                        String mensagem = "Atualizado com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizaDoc = new AtualizaDocumentos();
                        atualizaDoc.atualizar_documentos3(tela, campoDocumentos);
                        
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
                        
                        
                        String sql = "update "+tabela+" set "
                                +"Usuario='" +usuario+"',"
                                +"Obsevacao='" +txtObservacao.getText()+"',"
                                +"DatadeCadastroAndamento='" +new java.sql.Date(novadata1.getTime())+"',"
                                +"DataDevulucaoCliente='" +new java.sql.Date(novadata2.getTime())+"',"
                                +"Andamento='Aguardando Validação' where Cod="+txtCodigo.getText();
                        conexao.statement.executeUpdate(sql);
                        
                        String mensagem = "Atualizado com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizaDoc = new AtualizaDocumentos();
                        atualizaDoc.atualizar_documentos2(tela, campoDocumentos);
                        
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
                        
                        String sql = "update "+tabela+" set "
                                +"Usuario='" +usuario+"',"
                                +"Obsevacao='" +txtObservacao.getText()+"',"
                                +"DatadeCadastroAndamento='" +new java.sql.Date(novadata1.getTime())+"',"
                                +"Andamento='Enviado para o Cliente' where Cod="+txtCodigo.getText();
                        conexao.statement.executeUpdate(sql);
                        
                        atualizaDoc = new AtualizaDocumentos();
                        atualizaDoc.atualizar_documentos1(tela, campoDocumentos);
                        
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
        pegar_ultimo_registro();
        
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
            setTela();
            setCampoDocumentos();
            setTabela();
            
            String cliente = "Deseja excluir o registro do cliente "+Ativador.nome+"?";
            int escolha = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
            if(escolha==JOptionPane.YES_OPTION){
                try{
                    
                    
                    int excluiu = conexao.statement.executeUpdate("delete from "+tabela+" where Cod="+txtCodigo.getText());
                    if(excluiu == 1){
                        String mensagem = "Removido com sucesso!";
                        lbMensagem.setText(mensagem);
                        
                        atualizar_acompanhamento_exclusao();
                        
                        acao = "Exclusão";
                        descricao = "Registro removido";
                        
                        gravar_log();
                        
                        atualizaExclusao();
                        
                        //bloquear_campos
                        limpar_campos();
                        limpar_tabela();
                        preencher_tabela();
                        
                        pegar_ultimo_registro();
                        
                    }
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Erro na exclusão! \n"+erro);
                }
            }
        
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        txtData1.setText("__/__/____");
        txtData2.setText("__/__/____");
        txtData3.setText("__/__/____");
        
        Integer linha = table.getSelectedRow();
        String codigo = (String)table.getValueAt(linha, 0);
        String tdata1 = (String)table.getValueAt(linha, 1);
        String tdata2 = (String)table.getValueAt(linha, 2);
        String tdata3 = (String)table.getValueAt(linha, 3);
        String obs = (String)table.getValueAt(linha, 4);
        
        txtCodigo.setText(codigo);
        txtObservacao.setText(obs);
     
        
        try{
            if(tdata1.length()==10 && !tdata1.equals("1111-11-11")){
                String ano = tdata1.substring(0, 4);
                String mes = tdata1.substring(5, 7);
                String dia = tdata1.substring(8);
                data1 = dia+"/"+mes+"/"+ano;

                txtData1.setText(data1);
            }
            else data1="";
        }catch(Exception erro){
            
        }
        try{
            if(tdata2.length()==10 && !tdata2.equals("1111-11-11")){
                String ano = tdata2.substring(0, 4);
                String mes = tdata2.substring(5, 7);
                String dia = tdata2.substring(8);
                data2 = dia+"/"+mes+"/"+ano;

                txtData2.setText(data2);
            }
            else data2="";
        }catch(Exception erro){
            
        }
        try{
            if(tdata3.length()==10 && !tdata3.equals("1111-11-11")){
                String ano = tdata3.substring(0, 4);
                String mes = tdata3.substring(5, 7);
                String dia = tdata3.substring(8);
                data3 = dia+"/"+mes+"/"+ano;

                txtData3.setText(data3);
            }
            else data3="";
        }catch(Exception erro){
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        //if(dialog!=null){
            dialog.dispose();
        //}
        try{
            conexao.desconecta();
        }catch(Exception e){}
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        conexao.desconecta();
        
    }//GEN-LAST:event_formInternalFrameClosed
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
                new DocumentosIntModelo().setVisible(true);
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
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCodigo;
    private com.towel.swing.calendar.CalendarView txtData1;
    private com.towel.swing.calendar.CalendarView txtData2;
    private com.towel.swing.calendar.CalendarView txtData3;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables
public void pegar_ultimo_registro(){
        setTela();
        setCampoDocumentos();
        setTabela();
        if(conexao == null){
            conexao.conecta();
        }
        conexao.executeSQL("select * from "+tabela+" where NumeroProcesso='"+processo+"'");
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
    table.getColumnModel().getColumn(0);
    table.getColumnModel().getColumn(1);
    table.getColumnModel().getColumn(2);
    table.getColumnModel().getColumn(3);
    table.getColumnModel().getColumn(4);
    table.getColumnModel().getColumn(5);
    setTela();
    setCampoDocumentos();
    setTabela();
    if(conexao == null){
            conexao.conecta();
        }
    conexao.executeSQL("select * from "+tabela+" where NumeroProcesso='"+processo+"'");
    
    DefaultTableModel modelo =(DefaultTableModel)table.getModel();
    
    try{
        while(conexao.resultset.next())
            modelo.addRow(new Object []{
                conexao.resultset.getString("Cod"),
                conexao.resultset.getString("DatadeCadastroAndamento"),
                limparData(conexao.resultset.getString("DataDevulucaoCliente")),
                limparData(conexao.resultset.getString("DataFinalAndamento")),
                conexao.resultset.getString("Obsevacao"),
                conexao.resultset.getString("Usuario")});
                conexao.resultset.first();
    }catch(Exception erro){
        JOptionPane.showMessageDialog(null, "Erro ao preencher tabela da tela" +logb.getTela()+" !\n"+erro);
    }
            
}
private String limparData(String valor){
    if( valor!=null && !valor.equals("1111-11-11")) 
        return valor;
    else 
        return "";
}
public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)table.getModel();
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
    txtData1.setEnabled(false);
    txtData2.setEnabled(false);
    txtData3.setEnabled(false);
    txtObservacao.setEditable(false);
}
public void desbloquear_campos(){
    txtData1.setEnabled(true);
    txtData2.setEnabled(true);
    txtData3.setEnabled(true);
    txtObservacao.setEditable(true);
    lbMensagem.setText("");
}
public void limpar_campos(){
    txtCodigo.setText("");
    txtData1.setText("__/__/____");
    txtData2.setText("__/__/____");
    txtData3.setText("__/__/____");
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
    Documentos.lbAto1.setText(data1);
}
public void enviar_label2(){
    Documentos.lbAto2.setText(data2);
}
public void enviar_label3(){
    Documentos.lbAto3.setText(data3);
}
public void gravar_log(){
    logb.setAcao(acao);
    logb.setDescricao(descricao);
    logb.setMenu("Documentos");
    log.inserir(logb);
}

        

public void atualizar_acompanhamento_exclusao(){
    setTela();
    setCampoDocumentos();
    setTabela();
    if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()==10 &&
            txtData3.getText().trim().length()==10){
        atualizaDoc = new AtualizaDocumentos();
        atualizaDoc.atualizar_documentos3(tela, campoDocumentos);
    }
    else if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()==10 &&
            txtData3.getText().trim().length()<10){
        atualizaDoc = new AtualizaDocumentos();
        atualizaDoc.atualizar_documentos2(tela, campoDocumentos);
    }
    else if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()<10 &&
            txtData3.getText().trim().length()<10){
        atualizaDoc = new AtualizaDocumentos();
        atualizaDoc.atualizar_documentos1(tela, campoDocumentos);
    }
}
public void atualizaExclusao(){
    doc.ato();
}
public void inicializacao(String campoDocumentos,String tabela, String tela){
    this.campoDocumentos = campoDocumentos; //campo da tabela documentos
    this.tabela = tabela; //tabela do formulario
    this.tela = tela; //nome da tela
}
public void setTabela(){
    this.tabela="";
}
public void setCampoDocumentos(){
    this.campoDocumentos = "";
}
public void setTela(){
    this.tela = "";
}
}
