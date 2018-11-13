package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.model.LogUsuarioBean;
import br.com.prolink.model.LogUsuarioDao;
import br.com.prolink.enviodocumentos.*;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import br.com.prolink.model.UsuarioLogado;

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
public class EnviadosIntModelo extends javax.swing.JInternalFrame {
    MaskFormatter formatoData1, formatoData2, formatoData3;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdb = new SimpleDateFormat("yyyy/MM/dd");
    String acao, descricao,data1,data2,data3;
    String campoDocumentos; //campo da tabela documentos
    String tabela; //tabela do formulario
    String tela;
    Date dataConvertida;
    
    Processo p = ProcessoLogado.getInstance().getProcesso();
    String processo=p.getId()+"",
            nome=p.getCliente(), 
            id=p.getApelido(), 
            usuario=UsuarioLogado.getInstance().getUsuario().getUsuario();
    AtualizacaoEnviados atualizaDoc;
    
    DocumentosEnviadosDao doc;
    LogUsuarioDao log;
    LogUsuarioBean logb;
    
    Connection con;
    private Connection getConnection(){
        this.con = ConexaoStatement.getInstance().getConnetion();
        return con;
    }
    private void closeConnection(){
        try{con.close();}catch(SQLException e){}
    }    
    public EnviadosIntModelo() {
        initComponents();
        
        table.setAutoCreateRowSorter(true);
        
        txtCodigo.setEditable(false);
        
        //bloquear_campos();
        
        btnAlterar.setEnabled(false);
        
//        preencher_tabela();
//        
//        pegar_ultimo_registro();
//        doc = new DocumentosEnviadosDao();
//        log = new LogUsuarioDao();
//        logb = new LogUsuarioBean();
//        logb.setCliente(nome);
//        logb.setApelido(ProcessoLogado.getInstance().getProcesso().getApelido());
//        logb.setProcesso(processo);
//        logb.setTela(tela);
       
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

        txtData1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbEnvio2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEnvio2.setText("Recebido:");

        txtData2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbEnvio3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEnvio3.setText("Validado:");

        txtData3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(22, Short.MAX_VALUE))
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
        limpar_campos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        data1 = txtData1.getText();
        data2 = txtData2.getText();
        data3 = txtData3.getText();
        
        setTela();
        setCampoDocumentos();
        setTabela();
        String texto;
        if(data1.trim().length()<10 && !converter_data(data1)){
            JOptionPane.showMessageDialog(null, "1º data de envio não informado ou incorreto!");
            return;
        }
        else{
            texto =  "1º Envio Realizado";
        }
        if(data2.trim().length()==10 && !converter_data(data2) || !converter_data(data1) && !converter_data(data2)){
            JOptionPane.showMessageDialog(null, "2º data de envio incorreto ou não é permitido se a 1º não for informada");
            return;
        }
        else{
            texto =  "1º e 2º Envio Realizado";
        }
        if(data3.trim().length()==10 && data2.trim().length()<10){
            JOptionPane.showMessageDialog(null, "3º data de envio não é permitido se a 1º e 2º não forem informadas");
            return;
        }
        else{
            texto =  "1º,2º e 3º Envio Realizado";
        }
        if(txtCodigo.getText().equals("")){
            try {
                String gry = "insert into " + tabela
                        + "(DataAndamento, NumeroProcesso, Usuario, "
                        + "Observacao, Data1Envio, Data2Envio, "
                        + "Data3Envio, Andamento) values (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = getConnection().prepareStatement(gry);
                ps.setDate(1, new java.sql.Date(new Date().getTime()));
                ps.setString(2, processo);
                ps.setString(3, usuario);
                ps.setString(4, txtObservacao.getText().trim());
                ps.setDate(5, converter_data(txtData1.getText())?new java.sql.Date(sdf.parse(txtData1.getText()).getTime()):null);
                ps.setDate(6, converter_data(txtData2.getText())?new java.sql.Date(sdf.parse(txtData2.getText()).getTime()):null);
                ps.setDate(7, converter_data(txtData3.getText())?new java.sql.Date(sdf.parse(txtData3.getText()).getTime()):null);
                ps.setString(8, texto);
                ps.executeUpdate();
                //
                atualizaDoc = new AtualizacaoEnviados();
                atualizaDoc.atualizar_acompanhamento(tela, campoDocumentos,texto,con);

                String mensagem = "Atualizado com sucesso!";
                lbMensagem.setText(mensagem);
                descricao = texto;
                acao = "Inserir";
                gravar_log(con);
            } catch (SQLException | ParseException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n" + erro);
                return;
            } finally{
                closeConnection();
            }
        }
        else if (!txtCodigo.getText().equals("")) {
             try {
                String sql = "update " + tabela + " set "
                        + "DataAndamento=?,"
                        + "Usuario=?,"
                        + "Observacao=?,"
                        + "Data1Envio=?,"
                        + "Data2Envio=?,"
                        + "Data3Envio=?,"
                        + "Andamento=? where Cod=?";
                PreparedStatement ps = getConnection().prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(new Date().getTime()));
                ps.setString(2, usuario);
                ps.setString(3, txtObservacao.getText().trim());
                ps.setDate(4, converter_data(txtData1.getText())?new java.sql.Date(sdf.parse(txtData1.getText()).getTime()):null);
                ps.setDate(5, converter_data(txtData2.getText())?new java.sql.Date(sdf.parse(txtData2.getText()).getTime()):null);
                ps.setDate(6, converter_data(txtData3.getText())?new java.sql.Date(sdf.parse(txtData3.getText()).getTime()):null);
                ps.setString(7, texto);
                ps.setInt(8, p.getId());
                ps.executeUpdate();
                atualizaDoc = new AtualizacaoEnviados();
                atualizaDoc.atualizar_acompanhamento(tela, campoDocumentos, texto, con);

                String mensagem = "Atualizado com sucesso!";
                lbMensagem.setText(mensagem);

                acao = "Inserir";
                descricao = texto;
                gravar_log(con);
            } catch (SQLException | ParseException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o registro\n" + erro);
                return;
            }finally{
                closeConnection();
            }
        }
        preencher_tabela();
        pegar_ultimo_registro();
        enviar_label1();
        enviar_label2();
        enviar_label3();

    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão");
        }
        else{
            setTela();
            setCampoDocumentos();
            setTabela();
            
            String cliente = "Deseja excluir o registro do cliente "+nome+"?";
            int escolha = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
            if(escolha==JOptionPane.YES_OPTION){
                try{
                    PreparedStatement ps = getConnection().prepareStatement("delete from "+tabela+" where Cod="+txtCodigo.getText());
                    if(ps.executeUpdate()>0){
                        String mensagem = "Removido com sucesso!";
                        lbMensagem.setText(mensagem);
                        atualizar_acompanhamento_exclusao(con);
                        acao = "Exclusão";
                        descricao = "Registro removido";
                        gravar_log(con);
                        atualizaExclusao(con);
                    }
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Erro na exclusão! \n"+erro);
                    return;
                }finally{
                    closeConnection();
                }
                limpar_campos();
                preencher_tabela();
                pegar_ultimo_registro();        
            }
        
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        String codigo = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
        String tdata1 = String.valueOf(table.getValueAt(table.getSelectedRow(), 1));
        String tdata2 = String.valueOf(table.getValueAt(table.getSelectedRow(), 2));
        String tdata3 = String.valueOf(table.getValueAt(table.getSelectedRow(), 3));
        String obs = (String)table.getValueAt(table.getSelectedRow(), 4);
        txtCodigo.setText(codigo);
        txtData1.setText(tdata1);
        txtData2.setText(tdata2);
        txtData3.setText(tdata3);
        txtObservacao.setText(obs);        
    }//GEN-LAST:event_tableMouseClicked

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

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
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviadosIntModelo().setVisible(true);
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
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    private javax.swing.JFormattedTextField txtData3;
    private javax.swing.JTextArea txtObservacao;
    // End of variables declaration//GEN-END:variables
public void pegar_ultimo_registro(){
        setTela();
        setCampoDocumentos();
        setTabela();
        try {
            PreparedStatement ps = getConnection().prepareCall("select * from "+tabela+" where NumeroProcesso=?");
            ps.setString(1,processo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(rs.last()){
                    txtCodigo.setText(rs.getString("Cod"));
                    txtData1.setText(rs.getDate("Data1Envio")==null?"":(sdf.format(rs.getDate("Data1Envio")).equals("11/11/1111")?"":sdf.format(rs.getDate("Data1Envio"))));
                    txtData2.setText(rs.getDate("Data2Envio")==null?"":(sdf.format(rs.getDate("Data2Envio")).equals("11/11/1111")?"":sdf.format(rs.getDate("Data2Envio"))));
                    txtData3.setText(rs.getDate("Data3Envio")==null?"":(sdf.format(rs.getDate("Data3Envio")).equals("11/11/1111")?"":sdf.format(rs.getDate("Data3Envio"))));
                    txtObservacao.setText(rs.getString("Obsevacao"));
                }
            }
        }catch(SQLException ex) {
        }finally{
            closeConnection();
        }
        
}
public void preencher_tabela(){
    setTela();
    setCampoDocumentos();
    setTabela();
    limpar_tabela();
    DefaultTableModel modelo =(DefaultTableModel)table.getModel();
    try{
        PreparedStatement ps = getConnection().prepareStatement("select * from "+tabela+" where NumeroProcesso=?");
        ps.setString(1, processo);
        ResultSet rs  = ps.executeQuery();
        while(rs.next()){
            Object[] o = new Object[6];
            o[0]=rs.getInt("Cod");
            o[1]=rs.getDate("Data1Envio")==null?"":(sdf.format(rs.getDate("Data1Envio")).equals("11/11/1111")?"":sdf.format(rs.getDate("Data1Envio")));
            o[2]=rs.getDate("Data2Envio")==null?"":(sdf.format(rs.getDate("Data2Envio")).equals("11/11/1111")?"":sdf.format(rs.getDate("Data2Envio")));
            o[3]=rs.getDate("Data3Envio")==null?"":(sdf.format(rs.getDate("Data3Envio")).equals("11/11/1111")?"":sdf.format(rs.getDate("Data3Envio")));
            o[4]=rs.getString("Observacao");
            o[5]=rs.getString("Usuario");
            modelo.addRow(o);
        }
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Erro ao preencher tabela da tela" +logb.getTela()+" !\n"+erro);
    }finally{
        closeConnection();
    }
            
}
public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)table.getModel();
    for(int i=tbm.getRowCount()-1; i>=0; i--){
        tbm.removeRow(i);
    }
}
public void limpar_campos(){
    txtCodigo.setText("");
    txtData1.setText("");
    txtData2.setText("");
    txtData3.setText("");
    txtObservacao.setText("");
}
public boolean converter_data(String data){
    try{
        dataConvertida = sdf.parse(data);
        return true;
    }catch(ParseException e){
        return false;
    }
}
public void enviar_label1(){
    DocumentosEnviados.lbBol1.setText(txtData1.getText().trim().length()==10?txtData1.getText():"");
}
public void enviar_label2(){
    DocumentosEnviados.lbBol1.setText(txtData2.getText().trim().length()==10?txtData2.getText():"");
}
public void enviar_label3(){
    DocumentosEnviados.lbBol1.setText(txtData3.getText().trim().length()==10?txtData3.getText():"");
}
public void gravar_log(Connection con){
    logb.setAcao(acao);
    logb.setDescricao(descricao);
    logb.setMenu("Acompanhamento de Envios");
    log.inserir(logb,con);
}
public void atualizar_acompanhamento_exclusao(Connection con){
    setTela();
    setCampoDocumentos();
    setTabela();
     //1º Envio Realizado,2º Envio Realizado,Finalizado
    String status = "";
    atualizaDoc = new AtualizacaoEnviados();
    if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()==10 &&
            txtData3.getText().trim().length()==10){
        status = "Finalizado";
    }
    else if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()==10 &&
            txtData3.getText().trim().length()<10){
        status = "2º Envio Realizado";
    }
    else if(txtData1.getText().trim().length()==10 &&
            txtData2.getText().trim().length()<10 &&
            txtData3.getText().trim().length()<10){
        status = "1º Envio Realizado";
    }
    atualizaDoc.atualizar_acompanhamento(tela, campoDocumentos,status,con);
    
}
public void atualizaExclusao(Connection con){
    //doc.boleto();
}
public void inicializacao(String campoDocumentos,String tabela, String tela){
    this.campoDocumentos = campoDocumentos; //campo da tabela documentos
    this.tabela = tabela; //tabela do formulario
    this.tela = tela; //nome da tela
}
public void setTabela(){}
public void setCampoDocumentos(){}
public void setTela(){}
}
