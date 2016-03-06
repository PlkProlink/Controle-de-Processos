package br.com.prolink.recepcao;

import br.com.prolink.inicio.ConexaoStatement;
import br.com.prolink.login.Login;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class Listagem extends javax.swing.JFrame {

    /**
     * @return the comando
     */
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Date dataatual = new Date();
    /**
     * Creates new form Listagem
     */
    MaskFormatter formatoData, formatoData1, formatoData2;
    
    String para, recebido="", departamento, usuario=Login.usuario;
    
    public static String situacao="", pegaAno ="", statusRecebido="N", pesquisa=""; 
    public static boolean relatorio = false, statusData = false;
    private String comando;
    int codigo;

    public Listagem() {
        initComponents();
    
        ListagemBean lb = new ListagemBean();
       
        bloquear_tela();
        bloqueia_data();
        
        lb.carrega_usuario();
        comando = lb.getComando();
        preencher_tabela();
        
        //tbLista.setAutoCreateRowSorter(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ordenacao = new javax.swing.ButtonGroup();
        situação = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista =     tbLista = new javax.swing.JTable() {
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                //component.setBackground(Color.ORANGE); //muda cor para toda a tabela
                //component.setBackground(row % 2 == 0 ? Color.ORANGE : Color.WHITE);
                if (!isRowSelected(row)) {
                    component.setBackground(getBackground());
                    int linha = convertRowIndexToModel(row);

                    //as 3 linhas abaixo mudam a cor de todos os que sua idade seja maior ou igual a 30 anos
                    String valor = (String) getModel().getValueAt(linha, 11);
                    if (valor.equals("N"))
                    component.setBackground(Color.RED);
                    else
                    component.setBackground(Color.BLUE);

                    //muda as cores conforme se cliente é ativo ou não
                    //boolean ativo = (boolean) getModel().getValueAt(linha, 3);
                    //if (ativo == true)
                    //	component.setBackground(Color.CYAN);          		
                }

                return component;
            }
        };
        jPanel2 = new javax.swing.JPanel();
        Usuario = new javax.swing.JRadioButton();
        txtPesquisa = new javax.swing.JTextField();
        try{
            formatoData1 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na data1");
        }
        txtData1 = new JFormattedTextField(formatoData1);
        try{
            formatoData2 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na data2");
        }
        txtData2 = new JFormattedTextField(formatoData2);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JRadioButton();
        Aberto = new javax.swing.JRadioButton();
        Fechado = new javax.swing.JRadioButton();
        btnOK = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        Geral = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        btRelatorio = new javax.swing.JButton();
        btRelatorio1 = new javax.swing.JButton();
        Protocolo = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        lbHora = new javax.swing.JLabel();
        lbPara = new javax.swing.JLabel();
        txtEntreguePor = new javax.swing.JTextField();
        lbEntreguePor = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtRecebidoPor = new javax.swing.JTextField();
        txtPara = new javax.swing.JTextField();
        lbEntreguePor1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        try{
            formatoData = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao receber  a data" +erro);
        }
        txtData = new JFormattedTextField(formatoData);
        lbCodigo = new javax.swing.JLabel();
        lbEmpresa = new javax.swing.JLabel();
        lbHistorico = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        lbHistorico1 = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        tbLista.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbLista.setForeground(new java.awt.Color(255, 255, 255));
        tbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Data", "Hora", "ID", "Empresa", "Recebido Por", "Historico", "Para", "Departamento", "Quem Recebeu", "Observacao", "Recebido?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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
            tbLista.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbLista.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbLista.getColumnModel().getColumn(3).setPreferredWidth(40);
            tbLista.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbLista.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbLista.getColumnModel().getColumn(7).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(8).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(9).setPreferredWidth(70);
        }

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar:"));

        Usuario.setBackground(new java.awt.Color(245, 245, 245));
        ordenacao.add(Usuario);
        Usuario.setText("Usuario:");
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPesquisa.setToolTipText("Informe aqui o valor correspondente a sua pesquisa!");
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        jLabel2.setText("De:");

        jLabel3.setText("Até:");

        ID.setBackground(new java.awt.Color(245, 245, 245));
        ordenacao.add(ID);
        ID.setText("ID:");
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        Aberto.setBackground(new java.awt.Color(245, 245, 245));
        situação.add(Aberto);
        Aberto.setText("Em Aberto");
        Aberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbertoActionPerformed(evt);
            }
        });

        Fechado.setBackground(new java.awt.Color(245, 245, 245));
        situação.add(Fechado);
        Fechado.setText("Fechado");
        Fechado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechadoActionPerformed(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(245, 245, 245));
        check.setText("Periodo");
        check.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkStateChanged(evt);
            }
        });

        Geral.setBackground(new java.awt.Color(245, 245, 245));
        ordenacao.add(Geral);
        Geral.setText("Geral");
        Geral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeralActionPerformed(evt);
            }
        });

        jRadioButton7.setBackground(new java.awt.Color(245, 245, 245));
        situação.add(jRadioButton7);
        jRadioButton7.setText("Todos");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        btRelatorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/relatorio_icon.png"))); // NOI18N
        btRelatorio.setToolTipText("Exportar resultados para leitura em tela");
        btRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorioActionPerformed(evt);
            }
        });

        btRelatorio1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btRelatorio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/excel_icon.png"))); // NOI18N
        btRelatorio1.setToolTipText("Exportar resultados para leitura em Excel(.xls)");
        btRelatorio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorio1ActionPerformed(evt);
            }
        });

        Protocolo.setBackground(new java.awt.Color(245, 245, 245));
        ordenacao.add(Protocolo);
        Protocolo.setText("Protocolo");
        Protocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProtocoloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Protocolo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Aberto)
                                    .addComponent(Fechado))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtData1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton7)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRelatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(Protocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Aberto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(Fechado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Geral, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btRelatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        lbHora.setText("Hora:");

        lbPara.setText("Para:");

        txtEntreguePor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEntreguePor.setOpaque(false);

        lbEntreguePor.setText("Entregue por:");

        txtId.setOpaque(false);

        lbId.setText("ID:");

        txtEmpresa.setOpaque(false);

        txtRecebidoPor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRecebidoPor.setOpaque(false);

        txtPara.setOpaque(false);

        lbEntreguePor1.setText("Recebido por:");

        txtHora.setOpaque(false);

        txtCodigo.setOpaque(false);

        lbData.setText("Data:");

        txtData.setOpaque(false);

        lbCodigo.setText("Codigo:");

        lbEmpresa.setText("Nome:");

        lbHistorico.setText("Historico:");

        txtHistorico.setBackground(new java.awt.Color(245, 245, 245));
        txtHistorico.setColumns(20);
        txtHistorico.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtHistorico.setLineWrap(true);
        txtHistorico.setRows(5);
        txtHistorico.setWrapStyleWord(true);
        txtHistorico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(txtHistorico);

        txtObservacao.setColumns(20);
        txtObservacao.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtObservacao.setLineWrap(true);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(txtObservacao);

        lbHistorico1.setText("Observação:");

        btnValidar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnValidar.setText("Validar");
        btnValidar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbHistorico)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbId)
                            .addComponent(lbCodigo))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbData)
                            .addComponent(lbPara)
                            .addComponent(lbEmpresa))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbHora)
                                .addGap(3, 3, 3)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbEntreguePor1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRecebidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmpresa)))
                    .addComponent(lbEntreguePor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 116, Short.MAX_VALUE)
                        .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbHistorico1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHora)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHistorico1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEntreguePor)
                            .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPara, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecebidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEntreguePor1))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed

        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro!");
        }
        else{
            
            if(recebido.trim().length()>0 && !recebido.equalsIgnoreCase(usuario)){
                String aviso="Esse registro ja foi baixado! Deseja alterar quem recebeu?";
                int escolha = JOptionPane.showConfirmDialog(null, aviso, "Atenção!", JOptionPane.YES_NO_OPTION);
                if(escolha==JOptionPane.YES_OPTION){
                    gravar();
                }
            }
            else if(recebido.trim().length()==0 || recebido==null){
                gravar();
            }
        }
        
    }//GEN-LAST:event_btnValidarActionPerformed

    private void checkStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkStateChanged
        if(check.isSelected()){
            txtData1.setEditable(true);
            txtData1.setBackground(Color.WHITE);
            txtData2.setEditable(true);
            txtData2.setBackground(Color.WHITE);
            statusData=true;
        }
        else{
            statusData=false;
            bloqueia_data();
        }
    }//GEN-LAST:event_checkStateChanged

    private void tbListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaMouseClicked
        //*Quando clicado na linha da tabela, os dados serão enviados para os campos
        
        Integer linha =  tbLista.getSelectedRow();
        codigo = (int) tbLista.getValueAt(linha, 0);
        String data = (String)tbLista.getValueAt(linha, 1);
        String hora = (String)tbLista.getValueAt(linha,2);
        String id = (String)tbLista.getValueAt(linha, 3);
        String empresa = (String)tbLista.getValueAt(linha, 4);
        String entreguepor = (String)tbLista.getValueAt(linha, 5);
        String historico = (String)tbLista.getValueAt(linha, 6);
        para = (String)tbLista.getValueAt(linha, 7);
        departamento = (String)tbLista.getValueAt(linha, 8);
        recebido = (String)tbLista.getValueAt(linha, 9);
        String observacao = (String)tbLista.getValueAt(linha, 10);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebeMysql = dia+mes+ano;
        
        txtCodigo.setText(String.valueOf(codigo));
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

    private void AbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbertoActionPerformed
        situacao = ("Recebido = 'N'");
    }//GEN-LAST:event_AbertoActionPerformed

    private void FechadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechadoActionPerformed
        situacao = ("Recebido = 'S'");
    }//GEN-LAST:event_FechadoActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
//        situacao = "'S' or Recebido='N' ";
        situacao = ("Recebido is not null");
    }//GEN-LAST:event_jRadioButton7ActionPerformed
        
    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        pesquisa = ("ID");
    }//GEN-LAST:event_IDActionPerformed

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        pesquisa =("ParaQuem");
    }//GEN-LAST:event_UsuarioActionPerformed

    private void GeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeralActionPerformed
        txtPesquisa.setText("");
        pesquisa=("Geral");
    }//GEN-LAST:event_GeralActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        ListagemBean lb = new ListagemBean();
        if(lb.buscar(txtData1.getText(), txtData2.getText(), txtPesquisa.getText())==true){
            comando=lb.getComando();
            preencher_tabela();
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ListagemBean lb = new ListagemBean();
            if(lb.buscar(txtData1.getText(), txtData2.getText(), txtPesquisa.getText())==true){
                comando=lb.getComando();
                preencher_tabela();
            }
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        ListagemBean lb = new ListagemBean();
        lb.buscar(txtData1.getText(), txtData2.getText(), txtPesquisa.getText());
        lb.gerarRelatorioPDF();
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void btRelatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorio1ActionPerformed
        //envia comando para o metodo gerar printView dentro de listagem bean
        ListagemBean lb = new ListagemBean();
        lb.buscar(txtData1.getText(), txtData2.getText(), txtPesquisa.getText());
        lb.gerarRelatorioExcel();
    }//GEN-LAST:event_btRelatorio1ActionPerformed

    private void ProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProtocoloActionPerformed
        pesquisa = "Protocolo";
    }//GEN-LAST:event_ProtocoloActionPerformed

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
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Aberto;
    private javax.swing.JRadioButton Fechado;
    private javax.swing.JRadioButton Geral;
    private javax.swing.JRadioButton ID;
    private javax.swing.JRadioButton Protocolo;
    private javax.swing.JRadioButton Usuario;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btRelatorio1;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnValidar;
    public static javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton7;
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
    private javax.swing.JLabel lbPara;
    private javax.swing.ButtonGroup ordenacao;
    private javax.swing.ButtonGroup situação;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEntreguePor;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPara;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtRecebidoPor;
    // End of variables declaration//GEN-END:variables

    public void preencher_tabela(){
        Connection con = ConexaoStatement.abrirConexao();
        ListagemDAO td = new ListagemDAO(con);
        
        List<ListagemBean> listarTabela = new ArrayList<ListagemBean>();
        listarTabela = td.listarTodos(this.comando);
        DefaultTableModel tbm = (DefaultTableModel)tbLista.getModel();
        
        limpar_tabela();
        
        int i = 0;
        
        for(ListagemBean tb : listarTabela){
            
            tbm.addRow(new String[1]);
            tbLista.setValueAt(tb.getCod(), i, 0);
            tbLista.setValueAt(tb.getData(), i, 1);
            tbLista.setValueAt(tb.getHora(), i, 2);
            tbLista.setValueAt(tb.getId(), i, 3);
            tbLista.setValueAt(tb.getEmpresa(), i, 4);
            tbLista.setValueAt(tb.getEntreguePor(), i, 5);
            tbLista.setValueAt(tb.getHistorico(), i, 6);
            tbLista.setValueAt(tb.getPara(), i, 7);
            tbLista.setValueAt(tb.getDepartamento(), i, 8);
            tbLista.setValueAt(tb.getQuemrecebeu(), i, 9);
            tbLista.setValueAt(tb.getObservacao(), i, 10);
            tbLista.setValueAt(tb.getRecebido(), i, 11);
            i++;
        }
        ConexaoStatement.fecharConexao(con);
}
public void limpar_tabela(){
  DefaultTableModel tbm = (DefaultTableModel)tbLista.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
}

private void bloquear_tela() {
    
    for(int i=0; i<jPanel3.getComponentCount(); i++)
        if(jPanel3.getComponent(i) instanceof JTextField)
            ((JTextField)jPanel3.getComponent(i)).setEnabled(false);
}
private void limpar_tela(){
    
    for(int i=0; i<jPanel3.getComponentCount();i++)
        if(jPanel3.getComponent(i) instanceof JTextField)
            ((JTextField)jPanel3.getComponent(i)).setText("");
}
private void bloqueia_data(){
    
    for(int i=0; i<jPanel2.getComponentCount();i++)
        if(jPanel2.getComponent(i) instanceof JFormattedTextField){
            ((JFormattedTextField)jPanel2.getComponent(i)).setEditable(false);
            ((JFormattedTextField)jPanel2.getComponent(i)).setBackground(Color.lightGray);
        }    
    
//    txtData1.setEditable(false);
//    txtData1.setBackground(Color.lightGray);
//    txtData2.setEditable(false);
//    txtData2.setBackground(Color.lightGray);
}
    public void gravar(){
        Connection con = ConexaoStatement.abrirConexao();
        ListagemDAO ld = new ListagemDAO(con);
        ListagemBean lb = new ListagemBean();
        
        lb.setCod(codigo);
        lb.setQuemrecebeu(usuario);
        lb.setRecebido("S");
        lb.setDataRecebimento(String.valueOf(dataatual));
        lb.setObservacao(txtObservacao.getText());
            
        JOptionPane.showMessageDialog(null, ld.alterar(lb));
        limpar_tabela();
        lb.carrega_usuario();
        this.comando=lb.getComando();
        ConexaoStatement.fecharConexao(con);
        preencher_tabela();
        limpar_tela();
        
        
    }

        
}
