package br.com.prolink.recepcao;

import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.UsuarioLogado;
import br.com.prolink.view.Login;
import br.com.prolink.protocolos.ProtocoloView;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
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

    Connection con;
    
    public Connection getCon(){
        this.con=ConexaoStatement.getInstance().getConnetion();
        return this.con;
    }
    /**
     * @return the comando
     */
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Date dataatual = new Date();
    /**
     * Creates new form Listagem
     */
    MaskFormatter formatoData, formatoData1, formatoData2;
    
    String para, recebido="", departamento, usuario = UsuarioLogado.getInstance().getUsuario().getUsuario()
            , devolucao="";
    
    public static String situacao=("Recebido = 'N'"), pegaAno ="", statusRecebido="N", pesquisa="ParaQuem"; 
    public static boolean relatorio = false, statusData = false;
    private String comando;
    private String backupComando;
    int codigo;

    int[] positivo = new int[10];
    int[] negativo = new int[10];
    String[] usuarioPos = new String[10];
    String[] usuarioNeg = new String[10];
    String recebeu, naoRecebeu;
    Double qtdN = 0.0, qtdY = 0.0;
    
    int i = 0;
    
    int codigoInicial = 5445;
    
    public Listagem() {
        initComponents();
    
        criaGraficos();
        
        ListagemBean lb = new ListagemBean();
        bloquear_tela();
        bloqueia_data();
        
        lb.carrega_usuario();
        comando = lb.getComando();
        preencher_tabela(comando);
        rbEmAberto.setSelected(true);
        rbUsuario.setSelected(true);
        carregarComboNome();
        cbNome.setSelectedItem(usuario);
        btProtocolar.setEnabled(false);
        btAdiarDevolucao.setEnabled(false);
        //tbLista.setAutoCreateRowSorter(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ordenacao = new javax.swing.ButtonGroup();
        situação = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnTopGreat = new javax.swing.JPanel();
        pnTopBad = new javax.swing.JPanel();
        pnPizza = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
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
        lbEmpresa = new javax.swing.JLabel();
        lbHistorico = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        lbHistorico1 = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();
        btnConstestar = new javax.swing.JButton();
        btProtocolar = new javax.swing.JButton();
        lbId1 = new javax.swing.JLabel();
        btAdiarDevolucao = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbUsuario = new javax.swing.JRadioButton();
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
        rbApelido = new javax.swing.JRadioButton();
        rbEmAberto = new javax.swing.JRadioButton();
        rbFechado = new javax.swing.JRadioButton();
        btnOK = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        rbGeral = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        btRelatorio = new javax.swing.JButton();
        btRelatorio1 = new javax.swing.JButton();
        rbProtocolo = new javax.swing.JRadioButton();
        cbNome = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista =     tbLista = new javax.swing.JTable();
        {
            /*@Override
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
            }*/
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnTopGreat.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout pnTopGreatLayout = new javax.swing.GroupLayout(pnTopGreat);
        pnTopGreat.setLayout(pnTopGreatLayout);
        pnTopGreatLayout.setHorizontalGroup(
            pnTopGreatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnTopGreatLayout.setVerticalGroup(
            pnTopGreatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnTopBad.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout pnTopBadLayout = new javax.swing.GroupLayout(pnTopBad);
        pnTopBad.setLayout(pnTopBadLayout);
        pnTopBadLayout.setHorizontalGroup(
            pnTopBadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        pnTopBadLayout.setVerticalGroup(
            pnTopBadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnPizza.setBackground(new java.awt.Color(250, 250, 250));
        pnPizza.setPreferredSize(new java.awt.Dimension(430, 250));

        javax.swing.GroupLayout pnPizzaLayout = new javax.swing.GroupLayout(pnPizza);
        pnPizza.setLayout(pnPizzaLayout);
        pnPizzaLayout.setHorizontalGroup(
            pnPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        pnPizzaLayout.setVerticalGroup(
            pnPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setOpaque(false);

        lbData.setText("Data:");

        txtData.setOpaque(false);

        lbEmpresa.setText("Empresa:");

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
        txtObservacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtObservacao.setLineWrap(true);
        txtObservacao.setRows(5);
        txtObservacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(txtObservacao);

        lbHistorico1.setText("Observação:");

        btnValidar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnValidar.setText("Validar");
        btnValidar.setToolTipText("Baixar Documento Pendente");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnConstestar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnConstestar.setText("Contestar Entrega");
        btnConstestar.setToolTipText("Contestar Documento não Recebido ou destino incorreto");
        btnConstestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConstestarActionPerformed(evt);
            }
        });

        btProtocolar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btProtocolar.setText("Protocolar Devolução");
        btProtocolar.setToolTipText("Gera um Protocolo de devolução de documentos a partir de documentos que foram recebidos");
        btProtocolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProtocolarActionPerformed(evt);
            }
        });

        lbId1.setText("Protocolo:");
        lbId1.setToolTipText("");

        btAdiarDevolucao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btAdiarDevolucao.setText("Adiar Devolução");
        btAdiarDevolucao.setToolTipText("Se uma documentação deveria ser devolvida, você pode adiar a sua saída");
        btAdiarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdiarDevolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEntreguePor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbId)
                    .addComponent(lbId1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(lbHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(lbPara))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmpresa)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(lbEntreguePor1)
                                .addGap(18, 18, 18)
                                .addComponent(txtRecebidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lbHistorico1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConstestar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btProtocolar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdiarDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbData)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHora)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbId1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEntreguePor)
                            .addComponent(txtEntreguePor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPara, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecebidoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEntreguePor1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btProtocolar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAdiarDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnConstestar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lbHistorico1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel4);

        jPanel6.setBackground(new java.awt.Color(250, 250, 250));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar:"));

        rbUsuario.setBackground(new java.awt.Color(255, 255, 255));
        ordenacao.add(rbUsuario);
        rbUsuario.setText("Usuario:");
        rbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("De:");

        jLabel3.setText("Até:");

        rbApelido.setBackground(new java.awt.Color(255, 255, 255));
        ordenacao.add(rbApelido);
        rbApelido.setText("ID:");
        rbApelido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbApelidoActionPerformed(evt);
            }
        });

        rbEmAberto.setBackground(new java.awt.Color(255, 255, 255));
        situação.add(rbEmAberto);
        rbEmAberto.setText("Em Aberto");
        rbEmAberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEmAbertoActionPerformed(evt);
            }
        });

        rbFechado.setBackground(new java.awt.Color(255, 255, 255));
        situação.add(rbFechado);
        rbFechado.setText("Fechado");
        rbFechado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFechadoActionPerformed(evt);
            }
        });

        btnOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(255, 255, 255));
        check.setText("Periodo");
        check.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkStateChanged(evt);
            }
        });

        rbGeral.setBackground(new java.awt.Color(255, 255, 255));
        ordenacao.add(rbGeral);
        rbGeral.setText("Geral");
        rbGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGeralActionPerformed(evt);
            }
        });

        rbTodos.setBackground(new java.awt.Color(255, 255, 255));
        situação.add(rbTodos);
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
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

        rbProtocolo.setBackground(new java.awt.Color(255, 255, 255));
        ordenacao.add(rbProtocolo);
        rbProtocolo.setText("Protocolo");
        rbProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProtocoloActionPerformed(evt);
            }
        });

        cbNome.setEditable(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbEmAberto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(rbApelido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbFechado, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbTodos)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btRelatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbEmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbFechado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(check)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btRelatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOK)
                            .addComponent(cbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 650, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pesquisa", jPanel6);

        tbLista.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Data", "Hora", "Cliente", "Nome", "De", "Historico", "Para", "Departamento", "Quem Recebeu", "Observacao", "Recebido?", "Devolver p/ Cliente?", "Data de Devolução"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLista.setRowHeight(22);
        TableCellRenderer tcr = new Colorir();
        TableColumn column = tbLista.getColumnModel().getColumn(11);
        column.setCellRenderer(tcr);

        TableCellRenderer tcr2 = new Colorir();
        TableColumn column2 = tbLista.getColumnModel().getColumn(12);
        column2.setCellRenderer(tcr2);
        tbLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLista);
        if (tbLista.getColumnModel().getColumnCount() > 0) {
            tbLista.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbLista.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbLista.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbLista.getColumnModel().getColumn(3).setPreferredWidth(30);
            tbLista.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbLista.getColumnModel().getColumn(5).setPreferredWidth(90);
            tbLista.getColumnModel().getColumn(7).setPreferredWidth(50);
            tbLista.getColumnModel().getColumn(8).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(9).setPreferredWidth(70);
            tbLista.getColumnModel().getColumn(12).setPreferredWidth(110);
            tbLista.getColumnModel().getColumn(13).setPreferredWidth(90);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnTopGreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(pnTopBad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTopBad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTopGreat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if(Integer.parseInt(txtCodigo.getText())<=codigoInicial){
                gravar();
                criaGraficos();
            }
            else if(recebido.trim().length()>0 && !recebido.equalsIgnoreCase(usuario) && !"Devolução Efetuada".equals(devolucao)){
                String aviso="Esse registro ja foi baixado! Deseja alterar quem recebeu?";
                JOptionPane.showMessageDialog(null, aviso, "Atenção!",JOptionPane.INFORMATION_MESSAGE);
                int escolha = JOptionPane.showConfirmDialog(null, aviso, "Atenção!", JOptionPane.YES_NO_OPTION);
                if(escolha==JOptionPane.YES_OPTION){
                    ProtocoloDialog dialog = new ProtocoloDialog(this, true, txtObservacao.getText(),codigo );
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                    dialog.addWindowListener(new FecharProtocolo());
                    //gravar();
                }
            }
            else if(recebido.trim().length()==0 || recebido==null){
                this.backupComando = comando;
                ProtocoloDialog dialog = new ProtocoloDialog(this, true, txtObservacao.getText(),codigo );
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
                dialog.addWindowListener(new FecharProtocolo());
                // gravar();
                // criaGraficos();
            }
            else if("Devolução Efetuada".equals(devolucao)){
                String aviso="Um protocolo de saída foi expedido para esse registro, não é possível alterar esse registro?";
                JOptionPane.showMessageDialog(null, aviso, "Atenção!",JOptionPane.INFORMATION_MESSAGE);
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
        jTabbedPane1.setSelectedIndex(0);//selecionar indice 1
        
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
        devolucao = (String)tbLista.getValueAt(linha, 12);
        
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
        txtRecebidoPor.setText(recebido);
        txtObservacao.setText(observacao);
        //passar a hora para a tela, senão for nula
        //tranformar hhmmss para hhmm
        if(!hora.trim().equals("")){
            String horaf = hora.substring(0, 2);
            String minuto = hora.substring(3, 5);
            txtHora.setText(horaf+":"+minuto);
        }
        if(!"".equals(historico))
            txtHistorico.setText(historico);
        else{
            try{
                String sql = "select item_quantidade,item_nome,item_detalhe from protocolo_item where item_prot_entrada_id=?";
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.setInt(1, codigo);
                ResultSet rs = ps.executeQuery();
                txtHistorico.setText("");
                while(rs.next()){
                    txtHistorico.append(rs.getString(1));
                    txtHistorico.append(" - ");
                    txtHistorico.append(rs.getString(2));
                    txtHistorico.append(" - ");
                    txtHistorico.append(rs.getString(3));
                    txtHistorico.append("\n");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                try{if(con!=null) con.close();}catch(SQLException e){}
            }
        }
        btnConstestar.setEnabled(true);
        btnValidar.setEnabled(true);
        if("".equals(recebido)){
            btProtocolar.setEnabled(false);
            btAdiarDevolucao.setEnabled(false);
        }
        else{
            btProtocolar.setEnabled(true);
            if("Não necessário".equals(devolucao)){
                btAdiarDevolucao.setEnabled(false);
            }
            else
                btAdiarDevolucao.setEnabled(true);
        }
    }//GEN-LAST:event_tbListaMouseClicked

    private void rbEmAbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEmAbertoActionPerformed
        situacao = ("Recebido = 'N' or passivel_devolucao=1 and devolvido=0");
    }//GEN-LAST:event_rbEmAbertoActionPerformed

    private void rbFechadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechadoActionPerformed
        situacao = ("Recebido = 'S'");
    }//GEN-LAST:event_rbFechadoActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
//        situacao = "'S' or Recebido='N' ";
        situacao = ("Recebido is not null");
    }//GEN-LAST:event_rbTodosActionPerformed
        
    private void rbApelidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbApelidoActionPerformed
        cbNome.setEnabled(true);
        pesquisa = ("ID");
        carregarComboNome();
    }//GEN-LAST:event_rbApelidoActionPerformed

    private void rbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsuarioActionPerformed
        cbNome.setEnabled(true);
        pesquisa =("ParaQuem");
        carregarComboNome();
    }//GEN-LAST:event_rbUsuarioActionPerformed

    private void rbGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGeralActionPerformed
        cbNome.setEnabled(false);
        pesquisa=("Geral");
    }//GEN-LAST:event_rbGeralActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        ListagemBean lb = new ListagemBean();
        if(lb.buscar(txtData1.getText(), txtData2.getText(), (String)cbNome.getSelectedItem())==true){
            this.comando=lb.getComando();
            preencher_tabela(this.comando);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorioActionPerformed
        ListagemBean lb = new ListagemBean();
        lb.buscar(txtData1.getText(), txtData2.getText(), (String)cbNome.getSelectedItem());
        lb.gerarRelatorioPDF();
    }//GEN-LAST:event_btRelatorioActionPerformed

    private void btRelatorio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorio1ActionPerformed
        //envia comando para o metodo gerar printView dentro de listagem bean
        ListagemBean lb = new ListagemBean();
        lb.buscar(txtData1.getText(), txtData2.getText(), (String)cbNome.getSelectedItem());
        lb.gerarRelatorioExcel();
    }//GEN-LAST:event_btRelatorio1ActionPerformed

    private void rbProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProtocoloActionPerformed
        cbNome.setEnabled(true);
        pesquisa = "Protocolo";
        carregarComboNome();
    }//GEN-LAST:event_rbProtocoloActionPerformed

    private void btnConstestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConstestarActionPerformed
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro para contestar!");
        }
        else if(!txtPara.getText().equals("") && !txtPara.getText().equals(usuario)){
            JOptionPane.showMessageDialog(null, "Esse documento não foi registrado para você receber, somente o responsável pode Contestar!");
        }
        else if(!txtRecebidoPor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Esse registro ja foi baixado!!");
        }
        else{
            ListagemPopUp popUp = new ListagemPopUp();
            popUp.setVisible(true);
        }
    }//GEN-LAST:event_btnConstestarActionPerformed

    private void btProtocolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProtocolarActionPerformed
        if(!txtCodigo.getText().equals("")){
            codigo = Integer.parseInt(txtCodigo.getText());
            DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
            String value = (String)model.getValueAt(tbLista.getSelectedRow(), 11);
            if("Sim".equals(value)){
                    ProtocoloView protocolo = new ProtocoloView(codigo);
                    protocolo.setVisible(true);
                    protocolo.addWindowListener(new FecharProtocolo());
            }
            else
                JOptionPane.showMessageDialog(null, "Recebimento ainda não foi confirmado, clique em Validar e depois tente novamente!");
        }
        else
            JOptionPane.showMessageDialog(null, "Nenhum registro foi selecionado!");
       
    }//GEN-LAST:event_btProtocolarActionPerformed

    private void btAdiarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdiarDevolucaoActionPerformed
        String data = (String)tbLista.getValueAt(tbLista.getSelectedRow(), 13);
        Date novaData;
        try{
            novaData = sdf.parse(data);
        }catch(ParseException e){
            novaData=null;
        }
        AlterarPrazoDialog prazo = new AlterarPrazoDialog(novaData, codigo);
        prazo.setVisible(true);
        prazo.addWindowListener(new FecharProtocolo());
    }//GEN-LAST:event_btAdiarDevolucaoActionPerformed
    private void gerarPizza() {

        // create a dataset...
        PieDataset dataset = createSampleDataset();

        // create the chart...
        JFreeChart chart = createChart(dataset);
        // add the chart to a panel...
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(pnPizza.getWidth(), pnPizza.getHeight());
        chartPanel.setVisible(true);
        pnPizza.removeAll();
        pnPizza.add(chartPanel);
        pnPizza.revalidate();
        pnPizza.repaint();

//        File filePie = new File("batChart3D.jpeg");
//        try {
//            ChartUtilities.saveChartAsJPEG(filePie, chart, 430, 250);
//        } catch (IOException ex) {
//            Logger.getLogger(Versao2.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private PieDataset createSampleDataset() {

        final DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Aberto", qtdN);
        result.setValue("Fechado", qtdY);
        return result;

    }

    private JFreeChart createChart(final PieDataset dataset) {

        final JFreeChart chart = ChartFactory.createPieChart3D(
                "Meu Status", // chart title
                dataset, // data
                true, // include legend
                true,
                false
        );

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1} ({2})"));
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setBackgroundPaint(Color.white);
        //plot.setNoDataMessage("No data to display");
        return chart;

    }

    //grafico de barras bad
    private CategoryDataset createDatasetGreat() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int j = 0;
        while(j<10){
            if(usuarioPos[j]!=null)
                dataset.addValue(positivo[j], usuarioPos[j], "Documentos Baixados");
            j++;
        }
        return dataset;

    }

    private CategoryDataset createDatasetBad() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int j=0;
        while(j<10){
            if(usuarioNeg[j]!=null)
                dataset.addValue(negativo[j], usuarioNeg[j], "Documentos não Baixados");
            j++;
        }
        return dataset;

    }
    
    private void criaGraficoBad() {
        CategoryDataset cds = createDatasetBad();
        String titulo = "Ranking - Top Pendentes";
        String eixoy = "Quantidade";
        String txt_legenda = "Legenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        graf.setBackgroundPaint(Color.white);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(pnTopBad.getWidth(), pnTopBad.getHeight());
        myChartPanel.setVisible(true);
        pnTopBad.removeAll();
        pnTopBad.add(myChartPanel);
        pnTopBad.revalidate();
        pnTopBad.repaint();
    }

    private void criaGraficoGreat() {
        CategoryDataset cds = createDatasetGreat();
        String titulo = "Ranking - Top Finalizadores";
        String eixoy = "Quantidade";
        String txt_legenda = "Legenda:";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart graf = ChartFactory.createBarChart3D(titulo, txt_legenda, eixoy, cds, PlotOrientation.VERTICAL, legenda, tooltips, urls);
        graf.setBackgroundPaint(Color.white);
        ChartPanel myChartPanel = new ChartPanel(graf, true);
        myChartPanel.setSize(pnTopGreat.getWidth(), pnTopGreat.getHeight());
        myChartPanel.setVisible(true);
        pnTopGreat.removeAll();
        pnTopGreat.add(myChartPanel);
        pnTopGreat.revalidate();
        pnTopGreat.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdiarDevolucao;
    private javax.swing.JButton btProtocolar;
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton btRelatorio1;
    private javax.swing.JButton btnConstestar;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> cbNome;
    public static javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEmpresa;
    private javax.swing.JLabel lbEntreguePor;
    private javax.swing.JLabel lbEntreguePor1;
    private javax.swing.JLabel lbHistorico;
    private javax.swing.JLabel lbHistorico1;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbId1;
    private javax.swing.JLabel lbPara;
    private javax.swing.ButtonGroup ordenacao;
    public static javax.swing.JPanel pnPizza;
    private javax.swing.JPanel pnTopBad;
    private javax.swing.JPanel pnTopGreat;
    private javax.swing.JRadioButton rbApelido;
    private javax.swing.JRadioButton rbEmAberto;
    private javax.swing.JRadioButton rbFechado;
    private javax.swing.JRadioButton rbGeral;
    private javax.swing.JRadioButton rbProtocolo;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JRadioButton rbUsuario;
    private javax.swing.ButtonGroup situação;
    public static javax.swing.JTable tbLista;
    public static javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    public static javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtEntreguePor;
    public static javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextField txtPara;
    private javax.swing.JTextField txtRecebidoPor;
    // End of variables declaration//GEN-END:variables
    public void criaGraficos(){
        pegaPior();
        pegaMelhor();
        gerarResultPizza();
        criaGraficoBad();
        criaGraficoGreat();
        gerarPizza();
    }
    
    public static void preencher_tabela(String comando){
        Connection con = ConexaoStatement.getInstance().getConnetion();
        ListagemDAO td = new ListagemDAO(con);
        
        List<ListagemBean> listarTabela = td.listarTodos(comando);
        DefaultTableModel tbm = (DefaultTableModel)tbLista.getModel();
        
        limpar_tabela();
        
        int i = 0;
        
        if(!listarTabela.isEmpty()){
            
        for(ListagemBean tb : listarTabela){
            tbm.addRow(new String[1]);
            tbLista.setValueAt(tb.getCod(), i, 0);
            tbLista.setValueAt(tb.getData(), i, 1);
            tbLista.setValueAt(tb.getHora(), i, 2);
            tbLista.setValueAt(tb.getId(), i, 3);
            tbLista.setValueAt(tb.getEmpresa(), i, 4);
            tbLista.setValueAt(tb.getEntreguePor(), i, 5);
            tbLista.setValueAt(tb.getHistorico()==null?"":tb.getHistorico(), i, 6);
            tbLista.setValueAt(tb.getPara(), i, 7);
            tbLista.setValueAt(tb.getDepartamento(), i, 8);
            tbLista.setValueAt(tb.getQuemrecebeu(), i, 9);
            tbLista.setValueAt(tb.getObservacao(), i, 10);
            String recebido1;
            if("N".equals(tb.getRecebido()))
                recebido1 = "Não";
            else
                recebido1 = "Sim";
            tbLista.setValueAt(recebido1, i, 11);
            
            String devolvido;
            if(tb.getPassivelDevolucao()==1 && tb.getDevolvido()==1){
                devolvido="Devolução Efetuada";
            }
            else if(tb.getDevolvido()==0 && tb.getPassivelDevolucao()==1){
                devolvido="Devolução Pendente";
            }
            else if(tb.getDevolvido()==0 && tb.getDataFuncionarioRecebeu()==null){
                devolvido="Recebimento Pendente";
            }
            else devolvido = "Não necessário";
            tbLista.setValueAt(devolvido,i,12);
            tbLista.setValueAt(tb.getDataDevolucao()==null?"":sdf.format(tb.getDataDevolucao()), i, 13);
            i++;
        }
        tbLista.getColumnModel().getColumn(7).setPreferredWidth(70);
        tbLista.getColumnModel().getColumn(7).setPreferredWidth(80);
        }
        try{if(con!=null) con.close();}catch(SQLException e){}
}
public static void limpar_tabela(){
  DefaultTableModel tbm = (DefaultTableModel)tbLista.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
}

private void bloquear_tela() {
    
    for(int i=0; i<jPanel3.getComponentCount(); i++){
        if(jPanel3.getComponent(i) instanceof JTextField)
            ((JTextField)jPanel3.getComponent(i)).setEnabled(false);
        if(jPanel3.getComponent(i) instanceof JFormattedTextField)
            ((JFormattedTextField)jPanel3.getComponent(i)).setEnabled(false);
        if(jPanel3.getComponent(i) instanceof JTextArea)
            ((JTextArea)jPanel3.getComponent(i)).setEnabled(false);
    }
    txtHistorico.setEditable(false);
}
public static void limpar_tela(){
    
    for(int i=0; i<jPanel3.getComponentCount();i++){
        if(jPanel3.getComponent(i) instanceof JTextField)
            ((JTextField)jPanel3.getComponent(i)).setText("");
        if(jPanel3.getComponent(i) instanceof JFormattedTextField)
            ((JFormattedTextField)jPanel3.getComponent(i)).setText("");
        txtHistorico.setText("");
        txtObservacao.setText("");
    }
}
private void bloqueia_data(){
    
    for(int j=0; j<jPanel2.getComponentCount();j++)
        if(jPanel2.getComponent(j) instanceof JFormattedTextField){
            ((JFormattedTextField)jPanel2.getComponent(j)).setEditable(false);
            ((JFormattedTextField)jPanel2.getComponent(j)).setBackground(Color.lightGray);
        }    
    
//    txtData1.setEditable(false);
//    txtData1.setBackground(Color.lightGray);
//    txtData2.setEditable(false);
//    txtData2.setBackground(Color.lightGray);
}
    public void gravar(){
        Connection cont = ConexaoStatement.getInstance().getConnetion();
        ListagemDAO ld = new ListagemDAO(cont);
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
        fecharConexao(cont);
        preencher_tabela(this.backupComando);
        limpar_tela();
        
        
    }
    private void fecharConexao(Connection con){
        try{if(con!=null) con.close();}catch(SQLException e){}
    }
    private void pegaMelhor() {
        //ocultando usuarios não ativos
        String sql = "select A.Para_Quem, count(A.Recebido) as Quantidade "
                + "from documentos_recebidos as A "
                + "inner join login as B "
                + "on A.Para_Quem=B.Usuario "
                + "and A.Recebido='S' and B.Ativo=1 "
                + "group by A.Para_Quem "
                + "order by count(A.Recebido) desc limit 10";
        /*
    comando anterior 
    select Para_Quem, count(Recebido) as Quantidade from documentos_recebidos where Recebido like 's' group by Para_Quem order by count(Recebido) desc limit 10
         */
        con = null;
        PreparedStatement ps;
        try {
            ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                i = 0;
                while (rs.next()) {
                    usuarioPos[i] = (rs.getString("Para_Quem"));
                    positivo[i] = (rs.getInt("Quantidade"));
                    i++;
                }
            }
            con.close();
        } catch (SQLException ex) {
        }
    }

    private void pegaPior() {
        //String sql = "select Para_Quem, count(Recebido) as Quantidade from documentos_recebidos where Recebido like 'n' group by Para_Quem order by count(Recebido) desc limit 10";
        String sql = "select A.Para_Quem, count(A.Recebido) as Quantidade " +
                            "from documentos_recebidos as A " +
                            "inner join login as B on " +
                            "A.Para_Quem = B.Usuario " +
                            "where A.Recebido like 'n' and B.Ativo='1' " +
                            "group by A.Para_Quem " +
                            "order by count(A.Recebido) " +
                            "desc limit 10";
        
        con = null;
        PreparedStatement ps;
        try {
            ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                i = 0;
                while (rs.next()) {
                    usuarioNeg[i] = (rs.getString("Para_Quem"));
                    negativo[i] = (rs.getInt("Quantidade"));
                    i++;
                }
            }
            con.close();
        } catch (SQLException ex) {
        }
    }

    private void gerarResultPizza() {
        String sql = "select count(Recebido) as QtdY, "
                + "(select count(Recebido) from documentos_recebidos "
                + "where Recebido='N' and Para_Quem=?) as QtdN from documentos_recebidos "
                + "where Recebido='S' and Para_Quem=?";
        con = null;
        PreparedStatement ps;
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    qtdY = (rs.getDouble("QtdY"));
                    qtdN = (rs.getDouble("QtdN"));
                }
            }
            con.close();
        } catch (SQLException ex) {
        }
    }

    private void carregarComboNome() {
        switch(pesquisa){
            case "ParaQuem":
                preencherComboNome("login", "Usuario");
                break;
            case "Protocolo":
                preencherComboNome("documentos_recebidos", "cod");
                break;
            case "ID":
                preencherComboNome("cliente", "id");
                break;
            default:
                break;
        }
    }
    private void preencherComboNome(String tabela, String campoNome){
        cbNome.removeAllItems();
        try{
            con = null;
            PreparedStatement ps = getCon().prepareStatement("select distinct("+campoNome+") from "+tabela+" order by "+campoNome);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbNome.addItem(rs.getString(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public class FecharProtocolo implements WindowListener{
        @Override
        public void windowOpened(WindowEvent e) {
         }

        @Override
        public void windowClosing(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
            Connection cont = ConexaoStatement.getInstance().getConnetion();
            ListagemBean lb = new ListagemBean();
            limpar_tabela();
            lb.carrega_usuario();
            comando=lb.getComando();
            fecharConexao(cont);
            preencher_tabela(backupComando);
            limpar_tela();
            criaGraficos();
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }
}
class Colorir extends JLabel implements TableCellRenderer{
    public Colorir(){
        setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(
        JTable table, 
        Object value, boolean isSelected, boolean hasFocus,
           int row, int column){
        setForeground(Color.WHITE);
        switch(value.toString()){
            case "Sim":
            case "Devolução Efetuada":
            case "Não necessário":
                setBackground(Color.GREEN);
                break;
            case "Não":
            case "Devolução Pendente":
            case "Recebimento Pendente":
                setBackground(Color.RED);
                break;
            default:
                setForeground(Color.BLACK);
                setBackground(table.getBackground());
                break;
        }
        setText(value.toString());
        return this;   	
    }
  
    @Override
  public void validate() {}
    @Override
  public void revalidate() {}
    @Override
  protected void firePropertyChange(String propertyName,
     Object ldValue, Object newValue) {}
    @Override
  public void firePropertyChange(String propertyName,
     boolean oldValue, boolean newValue) {}

}