
package br.com.prolink.recepcao;

import br.com.prolink.inicio.Conexao;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Tiago Dias
 */
public class ListagemDocumentos extends javax.swing.JFrame {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    MaskFormatter formatoData;
    
    Conexao con_lista, con_departamento, con_funcionario;
    
    public static String data,hora, codigo, id, nome, entreguepor, historico, para, departamento,
                    recebidopor, observacao, dataconfirmada;
            
    public ListagemDocumentos() {
        initComponents();
        
        con_lista = new Conexao();
        con_lista.conecta();
        
        con_funcionario = new Conexao();
        con_funcionario.conecta();

        preencher_combobox();
        
        
        tbLista.setAutoCreateRowSorter(true);
        
        bloquear_tela();
        
        try{
            con_lista.executeSQL("select * from documentos_recebidos order by Data_Recebimento desc limit 300");
            preencher_tabela();
        }catch(Exception erro){
            
        }
        
        cbPesqFuncionario.setSelectedItem("");
        cbPesqDepartamento.setSelectedItem("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnPesqTodos = new javax.swing.JButton();
        cbPesqDepartamento = new javax.swing.JComboBox();
        lbPesqDepartamento = new javax.swing.JLabel();
        btnPesqAberto = new javax.swing.JButton();
        lbInfobusca = new javax.swing.JLabel();
        lbPesqId = new javax.swing.JLabel();
        txtPesqId = new javax.swing.JTextField();
        lbPesqEmpresa = new javax.swing.JLabel();
        txtPesqEmpresa = new javax.swing.JTextField();
        lbPesqFuncionario = new javax.swing.JLabel();
        cbPesqFuncionario = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        txtPara = new javax.swing.JTextField();
        btnSeleciona = new javax.swing.JButton();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        try{
            formatoData = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao receber  a data" +erro);
        }
        txtData = new JFormattedTextField(formatoData);
        lbEmpresa = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbEntreguePor = new javax.swing.JLabel();
        txtEntreguePor = new javax.swing.JTextField();
        lbPara = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtConfirmacao = new javax.swing.JTextField();
        lbHora = new javax.swing.JLabel();
        try{
            formatoData = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao receber  a data" +erro);
        }
        txtHora = new JFormattedTextField(formatoData);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa");
        setIconImages(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Data", "Hora", "ID", "Empresa", "Entregue por", "Historico", "Para Quem", "Departamento", "Recebido por", "Observacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLista);
        if (tbLista.getColumnModel().getColumnCount() > 0) {
            tbLista.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(0).setMaxWidth(70);
            tbLista.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(1).setMaxWidth(100);
            tbLista.getColumnModel().getColumn(2).setMaxWidth(80);
            tbLista.getColumnModel().getColumn(3).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(3).setMaxWidth(70);
            tbLista.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbLista.getColumnModel().getColumn(5).setMaxWidth(120);
            tbLista.getColumnModel().getColumn(7).setMaxWidth(70);
            tbLista.getColumnModel().getColumn(8).setPreferredWidth(100);
            tbLista.getColumnModel().getColumn(8).setMaxWidth(120);
            tbLista.getColumnModel().getColumn(9).setPreferredWidth(100);
            tbLista.getColumnModel().getColumn(9).setMaxWidth(100);
        }

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        btnPesqTodos.setText("Todos");
        btnPesqTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqTodosActionPerformed(evt);
            }
        });

        cbPesqDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPesqDepartamentoActionPerformed(evt);
            }
        });

        lbPesqDepartamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPesqDepartamento.setText("Departamento:");

        btnPesqAberto.setText("Em Aberto");
        btnPesqAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqAbertoActionPerformed(evt);
            }
        });

        lbInfobusca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbInfobusca.setText("Filtrar por:");

        lbPesqId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPesqId.setText("ID:");

        txtPesqId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqIdActionPerformed(evt);
            }
        });

        lbPesqEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPesqEmpresa.setText("Empresa:");

        txtPesqEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqEmpresaActionPerformed(evt);
            }
        });

        lbPesqFuncionario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPesqFuncionario.setText("Funcionario:");

        cbPesqFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPesqFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPesqDepartamento)
                            .addComponent(lbPesqFuncionario)
                            .addComponent(lbPesqEmpresa)
                            .addComponent(lbPesqId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPesqFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPesqDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPesqEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbInfobusca)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPesqAberto)
                        .addGap(30, 30, 30)
                        .addComponent(btnPesqTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPesqAberto, btnPesqTodos});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbInfobusca, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPesqEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesqEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesqFuncionario)
                    .addComponent(cbPesqFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesqDepartamento)
                    .addComponent(cbPesqDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesqTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtPara.setOpaque(false);

        btnSeleciona.setText("Selecionar");
        btnSeleciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionaActionPerformed(evt);
            }
        });

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Codigo:");

        txtCodigo.setOpaque(false);

        lbData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbData.setText("Data:");

        txtData.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        txtData.setOpaque(false);

        lbEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEmpresa.setText("Empresa:");

        txtEmpresa.setOpaque(false);

        lbId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbId.setText("ID:");

        txtId.setOpaque(false);

        lbEntreguePor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEntreguePor.setText("Entregue por:");

        txtEntreguePor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEntreguePor.setOpaque(false);

        lbPara.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPara.setText("Para:");

        txtHistorico.setColumns(20);
        txtHistorico.setLineWrap(true);
        txtHistorico.setRows(5);
        jScrollPane2.setViewportView(txtHistorico);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Foi confirmado?");

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbHora.setText("Hora:");

        txtHora.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        txtHora.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodigo)
                            .addComponent(lbId)
                            .addComponent(lbEmpresa)
                            .addComponent(lbEntreguePor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(lbPara)
                                .addGap(34, 34, 34)
                                .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbData)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbHora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(210, 210, 210))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbCodigo)
                                .addGap(16, 16, 16)
                                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbData)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbHora)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbEntreguePor))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbPara, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesqTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqTodosActionPerformed
       try{
            String pesquisa = "select * from documentos_recebidos order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            con_lista.resultset.first();
            preencher_tabela();
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados geral da tabela!" +erro);
        }
    }//GEN-LAST:event_btnPesqTodosActionPerformed

    private void btnPesqAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqAbertoActionPerformed
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where Quem_recebeu='' order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            con_lista.resultset.first();
            preencher_tabela();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados geral da tabela!" +erro);
        }
    }//GEN-LAST:event_btnPesqAbertoActionPerformed

    private void cbPesqDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPesqDepartamentoActionPerformed
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where Departamento='"+cbPesqDepartamento.getSelectedItem()+"' order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            con_lista.resultset.first();
            preencher_tabela();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados geral da tabela!" +erro);
        }
    }//GEN-LAST:event_cbPesqDepartamentoActionPerformed

    private void cbPesqFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPesqFuncionarioActionPerformed
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where Para_Quem like '"+cbPesqFuncionario.getSelectedItem()+"' order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            con_lista.resultset.first();
            preencher_tabela();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados geral da tabela!" +erro);
        }
    }//GEN-LAST:event_cbPesqFuncionarioActionPerformed

    private void txtPesqEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqEmpresaActionPerformed
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where Empresa like '"+txtEmpresa.getText()+"%'";
            con_lista.executeSQL(pesquisa);
            if(con_lista.resultset.first())
            {
                preencher_tabela();
            }
            else
                JOptionPane.showMessageDialog(null, "Não existe dados com "+txtEmpresa.getText().toUpperCase());
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
        }
    }//GEN-LAST:event_txtPesqEmpresaActionPerformed

    private void txtPesqIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqIdActionPerformed
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where ID like '"+txtPesqId.getText()+"%'";
            con_lista.executeSQL(pesquisa);
            if(con_lista.resultset.first())
            {
                preencher_tabela();
            }
            else
                JOptionPane.showMessageDialog(null, "Não existe dados com "+txtPesqId.getText().toUpperCase());
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
        }
    }//GEN-LAST:event_txtPesqIdActionPerformed

    private void tbListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaMouseClicked
        //*Quando clicado na linha da tabela, os dados serão enviados para os campos
        
        Integer linha =  tbLista.getSelectedRow();
        String codigo = (String)tbLista.getValueAt(linha, 0);
        String data = (String)tbLista.getValueAt(linha, 1);
        String hora = (String)tbLista.getValueAt(linha,2);
        String id = (String)tbLista.getValueAt(linha, 3);
        String empresa = (String)tbLista.getValueAt(linha, 4);
        String entreguepor = (String)tbLista.getValueAt(linha, 5);
        String historico = (String)tbLista.getValueAt(linha, 6); 
        String para = (String)tbLista.getValueAt(linha, 7);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebeMysql = dia+mes+ano;
        
        txtCodigo.setText(codigo);
        txtData.setText(recebeMysql);
        txtEmpresa.setText(empresa);
        txtId.setText(id);
        txtEntreguePor.setText(entreguepor);
        txtPara.setText(para);
        //passar a hora para a tela, senão for nula
        //tranformar hhmmss para hhmm
        if(!hora.trim().equals("")){
        
            String horaf = hora.substring(0, 2);
            String minuto = hora.substring(3, 5);
            txtHora.setText(horaf+":"+minuto);
        }
        
        if(!historico.trim().equals("")){
            txtConfirmacao.setText("Sim");
        }
        else{
            txtConfirmacao.setText("Não");
            txtConfirmacao.setBackground(Color.red);
        }
    }//GEN-LAST:event_tbListaMouseClicked

    private void btnSelecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaActionPerformed
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Selecione um regisro!");
        }
        else{
            try{
                con_lista.executeSQL("select * from documentos_recebidos where cod="+txtCodigo);
                if(con_lista.resultset.first()){
                    codigo = con_lista.resultset.getString("cod");
                    data = sdf.format(con_lista.resultset.getDate("Data_Recebimento"));
                    hora = con_lista.resultset.getString("Hora");
                    id = con_lista.resultset.getString("ID");
                    nome = con_lista.resultset.getString("Empresa");
                    entreguepor = con_lista.resultset.getString("Quem_Entregou");
                    historico = con_lista.resultset.getString("Historico");
                    para= con_lista.resultset.getString("Para_Quem");
                    departamento = con_lista.resultset.getString("Departamento");
                    recebidopor = con_lista.resultset.getString("Quem_recebeu");
                    observacao = con_lista.resultset.getString("Observacao");
                    dataconfirmada = con_lista.resultset.getString("Data_Funcionario_Recebeu");
                                        
                    ConfirmarDocumento confirmar = new ConfirmarDocumento();
                    confirmar.setVisible(true);
                }
                
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Falha ao recuperar registro! \n"+erro+ "\n" +evt);
            }
        }
    }//GEN-LAST:event_btnSelecionaActionPerformed

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
            java.util.logging.Logger.getLogger(ListagemDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListagemDocumentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesqAberto;
    private javax.swing.JButton btnPesqTodos;
    private javax.swing.JButton btnSeleciona;
    private javax.swing.JComboBox cbPesqDepartamento;
    private javax.swing.JComboBox cbPesqFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEmpresa;
    private javax.swing.JLabel lbEntreguePor;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbInfobusca;
    private javax.swing.JLabel lbPara;
    private javax.swing.JLabel lbPesqDepartamento;
    private javax.swing.JLabel lbPesqEmpresa;
    private javax.swing.JLabel lbPesqFuncionario;
    private javax.swing.JLabel lbPesqId;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtConfirmacao;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEntreguePor;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPara;
    private javax.swing.JTextField txtPesqEmpresa;
    private javax.swing.JTextField txtPesqId;
    // End of variables declaration//GEN-END:variables

    private void preencher_tabela(){
        tbLista.getColumnModel().getColumn(0);
        tbLista.getColumnModel().getColumn(1);
        tbLista.getColumnModel().getColumn(2);
        tbLista.getColumnModel().getColumn(3);
        tbLista.getColumnModel().getColumn(4);
        tbLista.getColumnModel().getColumn(5);
        tbLista.getColumnModel().getColumn(6);
        tbLista.getColumnModel().getColumn(7);
        tbLista.getColumnModel().getColumn(8);
        tbLista.getColumnModel().getColumn(9);
        
        DefaultTableModel modelo =(DefaultTableModel)tbLista.getModel();
        modelo.setNumRows(0);
        try{
            while (con_lista.resultset.next())
                modelo.addRow(new Object [] {
                    con_lista.resultset.getString("cod"),
                    sdf.format(con_lista.resultset.getDate("Data_Recebimento")),
                    con_lista.resultset.getString("ID"),
                    con_lista.resultset.getString("Empresa"),
                    con_lista.resultset.getString("Quem_Entregou"),
                    con_lista.resultset.getString("Historico"),
                    con_lista.resultset.getString("Para_Quem"),
                    con_lista.resultset.getString("Departamento"),
                    con_lista.resultset.getString("Quem_recebeu"),
                    con_lista.resultset.getString("Observacao")});
                
            con_lista.resultset.first();    
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null," Erro ao listar tabela" +erro);
        }
    }
    
    private void limpar_tabela(){
        DefaultTableModel tbm = (DefaultTableModel)tbLista.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
    }

    private void bloquear_tela() {
        txtCodigo.setEditable(false);
        txtHistorico.setEditable(false);
        txtData.setEditable(false);
        txtEmpresa.setEditable(false);
        txtId.setEditable(false);
        txtEntreguePor.setEditable(false);
        txtPara.setEditable(false);
        txtConfirmacao.setEditable(false);
    }
    private void preencher_combobox() {
        
        con_funcionario.executeSQL("select * from departamento order by nome");
        
        try{
            while(con_funcionario.resultset.next())
                cbPesqDepartamento.addItem(con_funcionario.resultset.getString("nome"));
            con_funcionario.resultset.first();
        }catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com a tabela departamento:\n" +erro);
        }
        
        con_funcionario.executeSQL("select * from login order by Usuario");
        
        try{
            while(con_funcionario.resultset.next())
                cbPesqFuncionario.addItem(con_funcionario.resultset.getString("Usuario"));
            con_funcionario.resultset.first();
        }catch(Exception erro)
        {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com a tabela funcionário:\n" +erro);
        }
    }
}
