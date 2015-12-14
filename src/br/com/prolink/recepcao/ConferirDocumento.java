package br.com.prolink.recepcao;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import br.com.prolink.inicio.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tiago Dias
 */
public class ConferirDocumento extends javax.swing.JFrame {
     
    MaskFormatter formatoData1, formatoData2;
    
    Conexao con_departamento = new Conexao();
    Conexao con_documentos = new Conexao();
    Conexao con_para = new Conexao();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    String codigo_backup,remetente_backup,idempresa_backup,nome_backup,
    resumo_backup,recebidopor_backup,observacao_backup,
    departamento_backup,para_backup, email;
    
    EmailView enviaemail = new EmailView();
    
    public ConferirDocumento() {
        initComponents();
        
        con_departamento.conecta();
        try{
            con_departamento.executeSQL("select * from departamento order by nome");
            while(con_departamento.resultset.next())
                cb_departamento.addItem(con_departamento.resultset.getString("nome"));
              

        }catch(Exception add){
            JOptionPane.showMessageDialog(null,"Erro ao buscar tabela de departamento\n" + add);
        }
        con_departamento.desconecta();
        
        con_para.conecta();
        try{  
            con_para.executeSQL("select * from login order by Usuario");
            while(con_para.resultset.next())
                cb_para.addItem(con_para.resultset.getString("Usuario"));
            
        }catch(Exception add){
            JOptionPane.showMessageDialog(null,"Erro ao buscar tabela de funcionario\n" + add);
        }
        con_para.desconecta();
        
        data_atual();
        bloqueia_tela();
        desbloqueia_tela();
        limpa_tela();
 }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp_Geral = new javax.swing.JPanel();
        lb_codigo = new javax.swing.JLabel();
        lb_data = new javax.swing.JLabel();
        lb_remetente = new javax.swing.JLabel();
        lb_idempresa = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        lb_destino = new javax.swing.JLabel();
        lb_recebidopor = new javax.swing.JLabel();
        lb_recebidoem = new javax.swing.JLabel();
        lb_resumo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        try {       
            formatoData1 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
        }
        txt_data = new JFormattedTextField(formatoData1);
        txt_remetente = new javax.swing.JTextField();
        txt_idempresa = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        cb_departamento = new javax.swing.JComboBox();
        txt_recebidopor = new javax.swing.JTextField();
        try {
      formatoData2 = new MaskFormatter("##/##/####");
}catch(Exception erro){
      JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
}
        txt_recebidoem = new JFormattedTextField(formatoData2);
        btnSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_resumo = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacao = new javax.swing.JTextArea();
        lb_observacao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_para = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Documentos");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Controle de Documentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jp_Geral.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lb_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_codigo.setText("Código:");
        lb_codigo.setAlignmentY(0.8F);

        lb_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_data.setText("Data:");
        lb_data.setAlignmentY(0.8F);

        lb_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_remetente.setText("Entregue por:");
        lb_remetente.setAlignmentY(0.8F);

        lb_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_idempresa.setText("Empresa ID:");
        lb_idempresa.setAlignmentY(0.8F);

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Emp. Nome:");
        lb_nome.setAlignmentY(0.8F);

        lb_destino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_destino.setText("Destino:");
        lb_destino.setAlignmentY(0.8F);

        lb_recebidopor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_recebidopor.setText("Recebido por:");
        lb_recebidopor.setAlignmentY(0.8F);

        lb_recebidoem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_recebidoem.setText("Em:");
        lb_recebidoem.setAlignmentY(0.8F);

        lb_resumo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_resumo.setText("Historico");
        lb_resumo.setAlignmentY(0.8F);

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_codigo.setAlignmentY(0.8F);

        txt_data.setAlignmentY(0.8F);
        txt_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txt_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_remetente.setAlignmentY(0.8F);

        txt_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_idempresa.setAlignmentY(0.8F);

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nome.setAlignmentY(0.8F);

        cb_departamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_departamento.setAlignmentY(0.8F);
        cb_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_departamentoActionPerformed(evt);
            }
        });

        txt_recebidopor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_recebidopor.setAlignmentY(0.8F);

        txt_recebidoem.setAlignmentY(0.8F);
        txt_recebidoem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setAlignmentY(0.8F);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSair.setText("Sair");
        btSair.setAlignmentY(0.8F);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        bt_novo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_novo.setText("Novo");
        bt_novo.setAlignmentY(0.8F);
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        txt_resumo.setColumns(20);
        txt_resumo.setLineWrap(true);
        txt_resumo.setRows(5);
        jScrollPane2.setViewportView(txt_resumo);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setAlignmentY(0.8F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setAlignmentY(0.8F);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setAlignmentY(0.8F);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        txt_observacao.setColumns(20);
        txt_observacao.setLineWrap(true);
        txt_observacao.setRows(5);
        jScrollPane1.setViewportView(txt_observacao);

        lb_observacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_observacao.setText("Observacao:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Funcionário:");

        cb_para.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_paraItemStateChanged(evt);
            }
        });

        jButton1.setText("Disparar Alerta!");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_GeralLayout = new javax.swing.GroupLayout(jp_Geral);
        jp_Geral.setLayout(jp_GeralLayout);
        jp_GeralLayout.setHorizontalGroup(
            jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_GeralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_remetente)
                    .addComponent(lb_idempresa))
                .addGap(18, 18, 18)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_GeralLayout.createSequentialGroup()
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_codigo)
                        .addGap(54, 54, 54)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(324, 324, 324)
                        .addComponent(lb_data)
                        .addGap(21, 21, 21)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_nome)
                        .addGap(27, 27, 27)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_destino)
                        .addGap(50, 50, 50)
                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(cb_para, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_resumo)
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_recebidopor)
                        .addGap(18, 18, 18)
                        .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lb_recebidoem)
                        .addGap(18, 18, 18)
                        .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_observacao)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_GeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(15, 15, 15))
        );
        jp_GeralLayout.setVerticalGroup(
            jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GeralLayout.createSequentialGroup()
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_GeralLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(lb_codigo))
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp_GeralLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_GeralLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lb_data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lb_remetente)
                                .addGap(21, 21, 21)
                                .addComponent(lb_idempresa))
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lb_nome))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_destino))
                    .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_para, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_resumo)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_recebidopor)
                            .addComponent(lb_recebidoem))))
                .addGap(10, 10, 10)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_observacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(642, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        criar_backup();
        desbloqueia_tela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        criar_backup();
        if(txt_codigo.getText().equals("")){
            con_documentos.conecta();
            try {
                String sql = "select * from documentos_recebidos where cod="+txt_codigo.getText();
                con_documentos.executeSQL(sql);
                
                String cliente = "Deseja excluir o registro do cliente "+con_documentos.resultset.getString("Nome")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    String sql2 = "DELETE from documentos_recebidos where cod="+txt_codigo.getText();
                    int conseguiu_excluir = con_documentos.statement.executeUpdate(sql2);
                    if(conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o registro!\n(Documentos Recebidos>Cadastro)\n" +ex);
            }
            con_documentos.desconecta();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restaurar_backup();
        bloqueia_tela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        criar_backup();
        desbloqueia_tela();
        limpa_tela();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        criar_backup();
        if(cb_departamento.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campo departamento informado é invalido");
        }
        else if (cb_para.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campo destino informado é invalido");
        }
        
        else if(txt_codigo.getText().equals("")){
            
            con_documentos.conecta();
            try{
                String datarec = txt_data.getText();
                Date data = sdf.parse(datarec);
                
                Date date = new Date();
                SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
                String hora = sh.format(date);
                
                
                String gry = "insert into documentos_recebidos "
                        + "(Data_Recebimento, Hora, Quem_Entregou, Empresa, ID, "
                        + "Historico, Departamento, Para_Quem, Alerta) values ('"
                        + new java.sql.Date(data.getTime())+"','"
                        + hora+"','"
                        + txt_remetente.getText()+"','"
                        + txt_nome.getText()+"','"
                        + txt_idempresa.getText()+"','"
                        + txt_resumo.getText()+"','"
                        + cb_departamento.getSelectedItem()+"','"
                        + cb_para.getSelectedItem()+"','S')";
                con_documentos.exeQuery(gry);
                
                enviar_email();
                
                //JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
            }catch(Exception add){
                JOptionPane.showMessageDialog(null,"Erro ao inserir novo registro!" +add);
            }
            con_documentos.desconecta();
        }
        else if(!txt_codigo.getText().equals("")){
            
            try {
                con_documentos.conecta();
                String datarec = txt_data.getText();
                Date data = sdf.parse(datarec);
                String gry = "update documentos_recebidos set "
                        + "Data_Recebimento='"+ new java.sql.Date(data.getTime())+"',"
                        + "Quem_Entregou='"+ txt_remetente.getText()+"',"
                        + "Empresa='"+ txt_nome.getText()+"',"
                        + "ID='" + txt_idempresa.getText()+"',"
                        + "Historico='"+ txt_resumo.getText()+"',"
                        + "Departamento='"+ cb_departamento.getSelectedItem()+"',"
                        + "Para_Quem='"+ cb_para.getSelectedItem()+"'"
                        + "where cod=" +txt_codigo.getText();
                con_documentos.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso");
                con_documentos.desconecta();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro na data informada, conversão não foi possivel" +ex);
            }
        }
        
        bloqueia_tela();
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departamentoActionPerformed
        /*if(!cb_departamento.getSelectedItem().equals("")){
            try {
                con_departamento.executeSQL("select * from login where Departamento='"+cb_departamento.getSelectedItem()+"'");
                cb_para.removeAllItems();
                while(con_departamento.resultset.next()){
                    cb_para.addItem(con_departamento.resultset.getString("Usuario"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro em na seleção Usuario/Departamento\n!" +ex);
            }
        }*/
    }//GEN-LAST:event_cb_departamentoActionPerformed

    private void cb_paraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_paraItemStateChanged
//        if(!cb_para.getSelectedItem().equals("")){
//            try {
//                con_para.executeSQL("select * from login where Usuario='"+cb_para.getSelectedItem()+"'");
//                String departamento = con_para.resultset.getString("Departamento");
//                cb_departamento.setSelectedItem(departamento);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Erro na seleção Usuario/Departamento\n!" +ex);
//            }
//        }
    }//GEN-LAST:event_cb_paraItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        enviar_email();
        con_para.desconecta();
//        String escolha = "Deseja enviar um alerta para o funcionário "+cb_para.getSelectedItem()+"?";
//        int opcao = JOptionPane.showConfirmDialog(null, escolha, "Enviar Alerta!", JOptionPane.YES_NO_OPTION);
//        if(opcao == JOptionPane.YES_OPTION){
//            enviaemail.txt_destinatario.setText(email);
//            enviaemail.txt_assunto.setText(""+txt_idempresa.getText()+" - Novo Documento Pendente de Validação");
//            enviaemail.txt_mensagem.setText("Olá "+cb_para.getSelectedItem()+
//                    "\nNova documentação do cliente disponivel foi entregue na recepção!\n\nCliente: "+txt_idempresa.getText()+" - "+txt_nome.getText()+
//                    "\nDescrição: "+txt_resumo.getText()+
//                    "\n\nÉ de extrema importancia que você valide o recebimento"+
//                    " através do Controle de Processos!"
//            );
//
//            enviaemail.setVisible(true);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConferirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConferirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConferirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConferirDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConferirDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSair;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cb_departamento;
    private javax.swing.JComboBox cb_para;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jp_Geral;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_data;
    private javax.swing.JLabel lb_destino;
    private javax.swing.JLabel lb_idempresa;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_observacao;
    private javax.swing.JLabel lb_recebidoem;
    private javax.swing.JLabel lb_recebidopor;
    private javax.swing.JLabel lb_remetente;
    private javax.swing.JLabel lb_resumo;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JTextField txt_idempresa;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextArea txt_observacao;
    private javax.swing.JFormattedTextField txt_recebidoem;
    private javax.swing.JTextField txt_recebidopor;
    private javax.swing.JTextField txt_remetente;
    private javax.swing.JTextArea txt_resumo;
    // End of variables declaration//GEN-END:variables
public void limpa_tela(){
    txt_codigo.setText("");
    txt_remetente.setText("");
    txt_idempresa.setText("");
    txt_nome.setText("");
    txt_resumo.setText("");
    txt_recebidopor.setText("");
    txt_remetente.setText("");
    txt_observacao.setText("");
//    cb_departamento.setSelectedItem("");
//    cb_para.setSelectedItem("");
    }
public void data_atual(){
    
    Date data = new Date();
    String datatela = sdf.format(data);
    txt_data.setText(datatela);
    
}
public void criar_backup(){
    codigo_backup=txt_codigo.getText();
    remetente_backup=txt_remetente.getText();
    idempresa_backup=txt_idempresa.getText();
    nome_backup=txt_nome.getText();
    resumo_backup=txt_resumo.getText();
    recebidopor_backup=txt_recebidopor.getText();
    remetente_backup=txt_remetente.getText();
    observacao_backup=txt_observacao.getText();
    departamento_backup=(String)cb_departamento.getSelectedItem();
    para_backup=(String)cb_para.getSelectedItem();
}
public void restaurar_backup(){
    txt_codigo.setText(codigo_backup);
    txt_remetente.setText(remetente_backup);
    txt_idempresa.setText(idempresa_backup);
    txt_nome.setText(nome_backup);
    txt_resumo.setText(resumo_backup);
    txt_recebidopor.setText(recebidopor_backup);
    txt_remetente.setText(remetente_backup);
    txt_observacao.setText(observacao_backup);
    cb_departamento.setSelectedItem(departamento_backup);
    cb_para.setSelectedItem(para_backup);
}
public void bloqueia_tela(){
    txt_codigo.setEditable(false); 
    txt_data.setEditable(false);
    txt_remetente.setEditable(false);
    txt_idempresa.setEditable(false);
    txt_nome.setEditable(false);
    cb_para.setEditable(false);
    cb_departamento.setEditable(false);
    txt_resumo.setEditable(false);
    
    btnAlterar.setEnabled(false);
    txt_recebidopor.setEditable(false);
    txt_recebidoem.setEditable(false);
    txt_observacao.setEditable(false);
}
public void desbloqueia_tela(){
    txt_remetente.setEditable(true);
    txt_idempresa.setEditable(true);
    txt_nome.setEditable(true);
    cb_para.setEditable(true);
    cb_departamento.setEditable(true);
    txt_resumo.setEditable(true);
}
public void enviar_email(){
    con_para.conecta();
        try{
            con_para.executeSQL("select * from login where Usuario='"+cb_para.getSelectedItem()+"'");
            if(con_para.resultset.first()){
            email = con_para.resultset.getString("Email");

            enviaemail.txt_destinatario.setText(email);
            enviaemail.txt_assunto.setText(""+txt_idempresa.getText()+" - Novo Documento Pendente de Validação");
            enviaemail.txt_mensagem.setText("Olá "+cb_para.getSelectedItem()+
                    ",\n\nNova documentação do cliente disponivel foi entregue na recepção!\n\nCliente: "+txt_idempresa.getText()+" - "+txt_nome.getText()+
                    "\n\nDescrição: "+txt_resumo.getText()+
                    "\n\nÉ de extrema importancia que você valide o recebimento"+
                    " através do Controle de Processos!"
            );

            enviaemail.setVisible(true);
            }
        }catch(Exception erro){
        }
    con_para.desconecta();
}
}
