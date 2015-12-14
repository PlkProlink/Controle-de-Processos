
package br.com.prolink.recepcao;

import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.Login;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    Conexao con_lista = new Conexao();
    Conexao con_funcionario= new Conexao();
    
    String codigo, departamento, usuario = Login.usuario;
    
    ConfirmarDocumento confirmar;
            
    public ListagemDocumentos() {
        initComponents();
        
        con_funcionario.conecta();
        con_lista.conecta();
        
        tbLista.setAutoCreateRowSorter(true);
        
        carrega_usuario();
        
        bloquear_tela();
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnPesqTodos = new javax.swing.JButton();
        btnPesqAberto = new javax.swing.JButton();
        lbInfobusca = new javax.swing.JLabel();
        lbPesqId = new javax.swing.JLabel();
        txtPesqId = new javax.swing.JTextField();
        lbPesqEmpresa = new javax.swing.JLabel();
        txtPesqEmpresa = new javax.swing.JTextField();
        lbPesqFuncionario = new javax.swing.JLabel();
        txtPesqFuncionario = new javax.swing.JTextField();
        lbInfobusca1 = new javax.swing.JLabel();
        btnPesqID = new javax.swing.JButton();
        btnPesqEmpresa = new javax.swing.JButton();
        btnPesqFuncionario = new javax.swing.JButton();
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
        lbHora = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lbHistorico = new javax.swing.JLabel();
        lbHistorico1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        lbEntreguePor1 = new javax.swing.JLabel();
        txtRecebidoPor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa");
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        tbLista.setToolTipText("Para confirmar o recebimento, clique na linha tabela e a seguir preencha o campo Observação(se necessário) e clique em Validar!");
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

        btnPesqTodos.setText("Geral");
        btnPesqTodos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesqTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqTodosActionPerformed(evt);
            }
        });

        btnPesqAberto.setText("Tudo Em Aberto");
        btnPesqAberto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        txtPesqFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqFuncionarioActionPerformed(evt);
            }
        });

        lbInfobusca1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbInfobusca1.setText("Em Aberto:");

        btnPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPesqID.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesqID.setContentAreaFilled(false);
        btnPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqIDActionPerformed(evt);
            }
        });

        btnPesqEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPesqEmpresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesqEmpresa.setContentAreaFilled(false);
        btnPesqEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqEmpresaActionPerformed(evt);
            }
        });

        btnPesqFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPesqFuncionario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesqFuncionario.setContentAreaFilled(false);
        btnPesqFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnPesqAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnPesqTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPesqFuncionario)
                                    .addComponent(lbPesqEmpresa)
                                    .addComponent(lbPesqId))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPesqEmpresa)
                                    .addComponent(txtPesqFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPesqID, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(btnPesqEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(btnPesqFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 20, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbInfobusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbInfobusca1)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInfobusca, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbInfobusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesqId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesqEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPesqEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPesqFuncionario)
                    .addComponent(txtPesqFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesqTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesqAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtPara.setOpaque(false);

        btnSeleciona.setText("Validar");
        btnSeleciona.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        txtHistorico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(txtHistorico);

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbHora.setText("Hora:");

        lbHistorico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbHistorico.setText("Historico:");

        lbHistorico1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbHistorico1.setText("Observação:");

        txtObservacao.setColumns(20);
        txtObservacao.setLineWrap(true);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(txtObservacao);

        lbEntreguePor1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbEntreguePor1.setText("Recebido por:");

        txtRecebidoPor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRecebidoPor.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCodigo)
                                    .addComponent(lbId)
                                    .addComponent(lbEmpresa))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbEntreguePor)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbData)
                                    .addComponent(lbHora))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(txtHora)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(lbPara)
                                .addGap(34, 34, 34)
                                .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmpresa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbHistorico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbHistorico1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbEntreguePor1)
                        .addGap(18, 18, 18)
                        .addComponent(txtRecebidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbCodigo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbData))
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbHora)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmpresa)
                            .addComponent(lbEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbHistorico1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbEntreguePor))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbPara, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRecebidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbEntreguePor1)))
                .addGap(9, 9, 9))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
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
        
        limpar_tabela();
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

    private void txtPesqEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqEmpresaActionPerformed
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where Empresa like '"+txtEmpresa.getText()+"%' order by Data_Recebimento desc";
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
            String pesquisa = "select * from documentos_recebidos where ID like '"+txtPesqId.getText()+"' order by Data_Recebimento desc";
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
        codigo = (String)tbLista.getValueAt(linha, 0);
        String data = (String)tbLista.getValueAt(linha, 1);
        String hora = (String)tbLista.getValueAt(linha,2);
        String id = (String)tbLista.getValueAt(linha, 3);
        String empresa = (String)tbLista.getValueAt(linha, 4);
        String entreguepor = (String)tbLista.getValueAt(linha, 5);
        String historico = (String)tbLista.getValueAt(linha, 6);
        String para = (String)tbLista.getValueAt(linha, 7);
        departamento = (String)tbLista.getValueAt(linha, 8);
        String recebido = (String)tbLista.getValueAt(linha, 9);
        String observacao = (String)tbLista.getValueAt(linha, 10);
        
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
        txtHistorico.setText(historico);
        txtRecebidoPor.setText(recebido);
        txtObservacao.setText(observacao);
        //passar a hora para a tela, senão for nula
        //tranformar hhmmss para hhmm
        if(!hora.trim().equals("")){
        
            String horaf = hora.substring(0, 2);
            String minuto = hora.substring(3, 5);
            txtHora.setText(horaf+":"+minuto);
        }
        
    }//GEN-LAST:event_tbListaMouseClicked

    private void btnSelecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaActionPerformed
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        }
        else{
        
            try{
                
                Date data2 = new Date();
                String datarec = sdf.format(data2);

                String dia = datarec.substring(0, 2);
                String mes = datarec.substring(3, 5);
                String ano = datarec.substring(6);
                String enviaSQL= ano+"-"+mes+"-"+dia;

                con_lista.statement.executeUpdate("UPDATE documentos_recebidos "
                        + "set Quem_recebeu='"+usuario+"',"+
                        "Data_Funcionario_Recebeu='"+enviaSQL+"',"+
                        "Observacao='"+txtObservacao.getText()+"'"+
                        "where cod="+codigo);
                
                limpar_tabela();
                carrega_usuario();
                
                JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a tabela de documentos :\n" +erro);
            }
        }
//        if(txtCodigo.getText().equals("")){
//            JOptionPane.showMessageDialog(null,"Selecione um regisro!");
//        }
//        else{
//            confirmar = new ConfirmarDocumento();
//            confirmar.setVisible(true);
//            
//            ConfirmarDocumento.codigo = codigo;
//            ConfirmarDocumento.txtCodigo.setText(codigo);
//            ConfirmarDocumento.txt_data.setText(txtData.getText());
//            ConfirmarDocumento.txt_hora.setText(txtHora.getText());
//            ConfirmarDocumento.txt_idempresa.setText(txtId.getText());
//            ConfirmarDocumento.txt_nome.setText(txtEmpresa.getText());
//            ConfirmarDocumento.txt_remetente.setText(txtEntreguePor.getText());
//            ConfirmarDocumento.txt_para.setText(txtPara.getText());
//            ConfirmarDocumento.txt_departamento.setText(departamento);
//            ConfirmarDocumento.txt_historico.setText(txtHistorico.getText());
//            
//        }
    }//GEN-LAST:event_btnSelecionaActionPerformed

    private void txtPesqFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqFuncionarioActionPerformed
        limpar_tabela();
        if(txtPesqFuncionario.getText().trim().length()<1){
            JOptionPane.showMessageDialog(null,"Digite um nome de um funcionario para pesquisar!");
        }
        else{
            try{
            String pesquisa = "select * from documentos_recebidos where Para_Quem like '"+
                    txtPesqFuncionario.getText()+"' order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            if(con_lista.resultset.first()){
                preencher_tabela();
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados geral da tabela!" +erro);
        }
        }
        
    }//GEN-LAST:event_txtPesqFuncionarioActionPerformed

    private void btnPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqIDActionPerformed
        if(!txtPesqId.getText().equals("")){
        limpar_tabela();
        
        try{
            String pesquisa = "select * from documentos_recebidos where ID='"+
                    txtPesqId.getText()+"' and Quem_recebeu is null or ID='"+txtPesqId.getText()+"' and Quem_recebeu='' order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            if(con_lista.resultset.first())
            {
                preencher_tabela();
            }
            else
                JOptionPane.showMessageDialog(null, "Não existe documentos pendentes em 'Aberto' com "+txtPesqId.getText());
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
        }
        
    }
    else
        JOptionPane.showMessageDialog(null, "Informe no campo id empresa para pesquisa");
    }//GEN-LAST:event_btnPesqIDActionPerformed

    private void btnPesqEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqEmpresaActionPerformed
    if(!txtPesqEmpresa.getText().equals("")){
        limpar_tabela();
        
        try{
            String pesquisa = "select * from documentos_recebidos where Empresa like '"+
                    txtPesqEmpresa.getText()+"%' and Quem_recebeu is null or Empresa like '"+txtPesqEmpresa.getText()+
                    "%' and Quem_recebeu='' order by Data_Recebimento desc";
            con_lista.executeSQL(pesquisa);
            if(con_lista.resultset.first())
            {
                preencher_tabela();
            }
            else
                JOptionPane.showMessageDialog(null, "Não existe dados em aberto com "+txtPesqEmpresa.getText().toUpperCase());
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
        }
        
    }
    else
        JOptionPane.showMessageDialog(null, "Informe no campo empresa um nome para pesquisa");
    }//GEN-LAST:event_btnPesqEmpresaActionPerformed

    private void btnPesqFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqFuncionarioActionPerformed
    if(!txtPesqFuncionario.getText().equals("")){
        limpar_tabela();
        try{
            String pesquisa = "select * from documentos_recebidos where Para_Quem like '"+
                    txtPesqFuncionario.getText()+"' and Quem_recebeu is null or Para_Quem like '"+
                    txtPesqFuncionario.getText()+"' and Quem_recebeu='' order by Data_Recebimento desc";
            
            con_lista.executeSQL(pesquisa);
            if(con_lista.resultset.first())
            {
                preencher_tabela();
            }
            else
                JOptionPane.showMessageDialog(null, "Não existe documentos pendentes para "+txtPesqFuncionario.getText().toUpperCase());
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
        }
        
    }
    else
        JOptionPane.showMessageDialog(null, "Informe no campo empresa um nome para pesquisa");
    }//GEN-LAST:event_btnPesqFuncionarioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con_funcionario.desconecta();
        con_lista.desconecta();
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JButton btnPesqEmpresa;
    private javax.swing.JButton btnPesqFuncionario;
    private javax.swing.JButton btnPesqID;
    private javax.swing.JButton btnPesqTodos;
    private javax.swing.JButton btnSeleciona;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEmpresa;
    private javax.swing.JLabel lbEntreguePor;
    private javax.swing.JLabel lbEntreguePor1;
    private javax.swing.JLabel lbHistorico;
    private javax.swing.JLabel lbHistorico1;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbInfobusca;
    private javax.swing.JLabel lbInfobusca1;
    private javax.swing.JLabel lbPara;
    private javax.swing.JLabel lbPesqEmpresa;
    private javax.swing.JLabel lbPesqFuncionario;
    private javax.swing.JLabel lbPesqId;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEntreguePor;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPara;
    private javax.swing.JTextField txtPesqEmpresa;
    private javax.swing.JTextField txtPesqFuncionario;
    private javax.swing.JTextField txtPesqId;
    private javax.swing.JTextField txtRecebidoPor;
    // End of variables declaration//GEN-END:variables

    public void preencher_tabela(){
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
        tbLista.getColumnModel().getColumn(10);
        //con_lista.executeSQL("select * from documentos_recebidos order by Data_Recebimento desc limit 300");
          
        DefaultTableModel modelo =(DefaultTableModel)tbLista.getModel();
        modelo.setNumRows(0);
        try{
            while (con_lista.resultset.next())
                modelo.addRow(new Object [] {
                    con_lista.resultset.getString("cod"),
                    sdf.format(con_lista.resultset.getDate("Data_Recebimento")),
                    con_lista.resultset.getString("Hora"),
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
        txtHora.setEditable(false);
        txtEmpresa.setEditable(false);
        txtId.setEditable(false);
        txtEntreguePor.setEditable(false);
        txtPara.setEditable(false);
        txtRecebidoPor.setEditable(false);
    }
//    private void preencher_combobox() {
//        
//        try{
//            cbPesqFuncionario.removeAll();
//            con_funcionario.executeSQL("select * from login order by Usuario");
//            while(con_funcionario.resultset.next())
//                cbPesqFuncionario.addItem(con_funcionario.resultset.getString("Usuario"));
//        }catch(Exception erro)
//        {
//            JOptionPane.showMessageDialog(null, "Não foi possivel conectar com a tabela funcionário:\n" +erro);
//        }
//        
//    }
    public void todos(){
        
        limpar_tabela();
        try{
            con_lista.executeSQL("select * from documentos_recebidos order by Data_Recebimento desc limit 300");
            if(con_lista.resultset.first()){
                preencher_tabela();
            }
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados geral da tabela!" +erro);
        }
        
    }

    public void carrega_usuario() {
    
        try{
            con_lista.executeSQL("select * from documentos_recebidos Where Para_Quem like '"+
                    usuario+"' and Quem_recebeu is null or Para_Quem like '"+
                    usuario+"' and Quem_recebeu='' order by Data_Recebimento desc");
            if(con_lista.resultset.first()){
                preencher_tabela();
            }
            else
                JOptionPane.showMessageDialog(null, "Nenhum documento pendente aguardado sua validação!");
            

        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar carregar com os critérios informados. "+erro);
        }
    
    }
}
