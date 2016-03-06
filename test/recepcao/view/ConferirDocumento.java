package recepcao.view;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author Tiago Dias
 */
public class ConferirDocumento extends javax.swing.JFrame {
     
    MaskFormatter formatoData1, formatoData2;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    String codigo_backup,remetente_backup,idempresa_backup,nome_backup,
    resumo_backup,recebidopor_backup,observacao_backup,
    departamento_backup,para_backup, email;
 
    public ConferirDocumento() {
        initComponents();
        
        
        bloqueia_tela();
        desbloqueia_tela();
        limpa_tela();
        data_atual();
 }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpGeral = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lb_resumo = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_resumo = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        lb_destino = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_para = new javax.swing.JComboBox();
        txt_idempresa = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        cb_departamento = new javax.swing.JComboBox();
        lb_idempresa = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        btnAlerta = new javax.swing.JButton();
        lb_remetente = new javax.swing.JLabel();
        txt_remetente = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        lb_codigo = new javax.swing.JLabel();
        try {       
            formatoData1 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
        }
        txt_data = new JFormattedTextField(formatoData1);
        lb_data = new javax.swing.JLabel();
        lb_recebidopor = new javax.swing.JLabel();
        txt_recebidopor = new javax.swing.JTextField();
        try {
      formatoData2 = new MaskFormatter("##/##/####");
}catch(Exception erro){
      JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
}
        txt_recebidoem = new JFormattedTextField(formatoData2);
        lb_recebidoem = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacao = new javax.swing.JTextArea();
        lb_observacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Documentos");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Controle de Documentos");

        javax.swing.GroupLayout jpTituloLayout = new javax.swing.GroupLayout(jpTitulo);
        jpTitulo.setLayout(jpTituloLayout);
        jpTituloLayout.setHorizontalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpTituloLayout.setVerticalGroup(
            jpTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpGeral.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Data", "Hora", "ID", "Empresa", "Historico", "Para Quem", "Departamento", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
        }

        lb_resumo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_resumo.setText("Historico");
        lb_resumo.setAlignmentY(0.8F);

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

        lb_destino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_destino.setText("Destino:");
        lb_destino.setAlignmentY(0.8F);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Funcionário:");

        cb_para.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_paraItemStateChanged(evt);
            }
        });
        cb_para.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_paraActionPerformed(evt);
            }
        });

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

        lb_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_idempresa.setText("Empresa ID:");
        lb_idempresa.setAlignmentY(0.8F);

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Emp. Nome:");
        lb_nome.setAlignmentY(0.8F);

        btnAlerta.setText("Disparar Alerta!");
        btnAlerta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlertaActionPerformed(evt);
            }
        });

        lb_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_remetente.setText("Entregue por:");
        lb_remetente.setAlignmentY(0.8F);

        txt_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_remetente.setAlignmentY(0.8F);

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_codigo.setAlignmentY(0.8F);

        lb_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_codigo.setText("Código:");
        lb_codigo.setAlignmentY(0.8F);

        txt_data.setAlignmentY(0.8F);
        txt_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_data.setText("Data:");
        lb_data.setAlignmentY(0.8F);

        lb_recebidopor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_recebidopor.setText("Recebido por:");
        lb_recebidopor.setAlignmentY(0.8F);

        txt_recebidopor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_recebidopor.setAlignmentY(0.8F);

        txt_recebidoem.setAlignmentY(0.8F);
        txt_recebidoem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lb_recebidoem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_recebidoem.setText("Em:");
        lb_recebidoem.setAlignmentY(0.8F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlerta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lb_codigo)
                                        .addGap(54, 54, 54)
                                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lb_nome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lb_destino)
                                        .addGap(50, 50, 50)
                                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel2)
                                        .addGap(30, 30, 30)
                                        .addComponent(cb_para, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lb_remetente)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_nome)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addComponent(lb_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_resumo)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_recebidoem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_recebidopor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_para, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_data))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_recebidoem)
                                .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(lb_codigo))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_resumo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lb_remetente)
                                                .addComponent(lb_idempresa)))
                                        .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(16, 16, 16)
                                            .addComponent(lb_nome))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jScrollPane2))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel1);

        txt_observacao.setColumns(20);
        txt_observacao.setLineWrap(true);
        txt_observacao.setRows(5);
        jScrollPane1.setViewportView(txt_observacao);

        lb_observacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_observacao.setText("Observacao:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_observacao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_observacao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Observação", jPanel2);

        javax.swing.GroupLayout jpGeralLayout = new javax.swing.GroupLayout(jpGeral);
        jpGeral.setLayout(jpGeralLayout);
        jpGeralLayout.setHorizontalGroup(
            jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpGeralLayout.setVerticalGroup(
            jpGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeralLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1021, 630));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        criar_backup();
        desbloqueia_tela();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restaurar_backup();
        bloqueia_tela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        criar_backup();
        desbloqueia_tela();
        limpa_tela();
        data_atual();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txt_idempresa.getText().length()<=4){
            
        }
        else
            JOptionPane.showMessageDialog(null, "O Apelido não pode ficar em branco");    
        //bloqueia_tela();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cb_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departamentoActionPerformed
       
    }//GEN-LAST:event_cb_departamentoActionPerformed

    private void cb_paraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_paraItemStateChanged

    }//GEN-LAST:event_cb_paraItemStateChanged

    private void btnAlertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlertaActionPerformed
        
    }//GEN-LAST:event_btnAlertaActionPerformed

    private void cb_paraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_paraActionPerformed
        
    }//GEN-LAST:event_cb_paraActionPerformed

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
    private javax.swing.JButton btnAlerta;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cb_departamento;
    private javax.swing.JComboBox cb_para;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpGeral;
    private javax.swing.JPanel jpTitulo;
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
    public static javax.swing.JTextField txt_codigo;
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
    
    for(int i=0; i<jPanel1.getComponentCount(); i++)
        if(jPanel1.getComponent(i) instanceof JTextField)
            ((JTextField)jPanel1.getComponent(i)).setText("");
        else if (jPanel1.getComponent(i) instanceof JFormattedTextField)
            ((JFormattedTextField)jPanel1.getComponent(i)).setText("");
        else if (jPanel1.getComponent(i) instanceof JComboBox)
            ((JComboBox)jPanel1.getComponent(i)).setSelectedItem("");
    txt_resumo.setText("");
    txt_observacao.setText("");
    
    }
public void bloqueia_tela(){
    
    for(int i=0; i<jPanel1.getComponentCount(); i++)
        if(jPanel1.getComponent(i) instanceof JTextField)
            ((JTextField)jPanel1.getComponent(i)).setEnabled(false);
        else if(jPanel1.getComponent(i) instanceof JComboBox)
            ((JComboBox)jPanel1.getComponent(i)).setEditable(false);
    
    txt_observacao.setEnabled(false);
    btnAlterar.setEnabled(false);
}
public void desbloqueia_tela(){
    
    Component campos[] = {txt_remetente,txt_idempresa,txt_nome,txt_resumo};
    
        for (Component campo : campos) {
            campo.setEnabled(true);
        }
    
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
}
