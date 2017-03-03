package br.com.prolink.recepcao;

/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
import br.com.prolink.inicio.ConexaoStatement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

/**
 *
 * @author Tiago
 */
public class ControleRecepcao extends javax.swing.JFrame {

    Connection con;

    public Connection getCon() {
        this.con = new ConexaoStatement().getConnetion();
        return this.con;
    }

    MaskFormatter formatoData1, formatoData2, formatoData3, formatoData4, formatoHora;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Date dataatual = new Date();

    String para, recebido = "";//, departamento, usuario=Login.usuario;

    public static String situacao = "", pegaAno = "", statusRecebido = "N", pesquisa = "";
    public static boolean relatorio = false, statusData = false;
    private String comando;

    int[] positivo = new int[10];
    int[] negativo = new int[10];
    String[] usuarioPos = new String[10];
    String[] usuarioNeg = new String[10];
    String recebeu, naoRecebeu, transferido;
    Double qtdN = 0.0, qtdY = 0.0, qtdTransfer = 0.0;

    int i = 0;

    String codigo_backup, remetente_backup, idempresa_backup, nome_backup,
            resumo_backup, recebidopor_backup, observacao_backup,
            departamento_backup, para_backup, hora_backup, email;

    public ControleRecepcao() {
        initComponents();
        criaGraficos();
        
        //Thread();

        setEditable(jPrincipal, false);

        btnCancelar.setEnabled(false);

        setEditable(jpAux, false);
        setEditable(jpObs, false);

        limpaCarregaCombo();

        setHora();

        bloqueia_data();

        preencherTabela("select * from documentos_recebidos where Recebido='N' order by cod desc");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPrincipal = new javax.swing.JPanel();
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
        lb_remetente = new javax.swing.JLabel();
        txt_remetente = new javax.swing.JTextField();
        lb_codigo = new javax.swing.JLabel();
        btEnviarAlerta = new javax.swing.JButton();
        txtAlerta = new javax.swing.JLabel();
        jpAux = new javax.swing.JPanel();
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
        lb_hora = new javax.swing.JLabel();
        try {
      formatoHora = new MaskFormatter("##:##");
}catch(Exception erro){
      JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
}
        txt_hora = new JFormattedTextField(formatoHora);
        txt_codigo = new javax.swing.JTextField();
        jpObs = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacao = new javax.swing.JTextArea();
        lb_observacao = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jpPesquisa = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Usuario1 = new javax.swing.JRadioButton();
        txtPesquisa = new javax.swing.JTextField();
        try{
            formatoData3 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na data1");
        }
        txtData3 = new JFormattedTextField(formatoData3);
        try{
            formatoData4 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro na data2");
        }
        txtData4 = new JFormattedTextField(formatoData4);
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ID1 = new javax.swing.JRadioButton();
        Aberto1 = new javax.swing.JRadioButton();
        Fechado1 = new javax.swing.JRadioButton();
        btnOK1 = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        Geral1 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        btRelatorio2 = new javax.swing.JButton();
        btRelatorio3 = new javax.swing.JButton();
        Protocolo1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable =  jTable = new javax.swing.JTable(); {
            /*@Override
            public Component prepareRenderer (TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                //component.setBackground(Color.ORANGE); //muda cor para toda a tabela
                //component.setBackground(row % 2 == 0 ? Color.ORANGE : Color.WHITE);
                if (!isRowSelected(row)) {
                    component.setBackground(getBackground());
                    int linha = convertRowIndexToModel(row);

                    //as 3 linhas abaixo mudam a cor de todos os que sua idade seja maior ou igual a 30 anos
                    String valor = (String) getModel().getValueAt(linha, 9);
                    if (valor.equals("N"))
                    component.setBackground(Color.RED);
                    else if(valor.equals("S"))
                    component.setBackground(Color.BLUE);
                    else
                    component.setBackground(Color.ORANGE);
                    //muda as cores conforme se cliente é ativo ou não
                    //boolean ativo = (boolean) getModel().getValueAt(linha, 3);
                    //if (ativo == true)
                    //	component.setBackground(Color.CYAN);
                }

                return component;
            }*/

        };
        pnPizza = new javax.swing.JPanel();
        pnTopBad = new javax.swing.JPanel();
        pnTopGreat = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de Documentos");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jPrincipal.setBackground(new java.awt.Color(250, 250, 250));

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

        cb_para.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_paraFocusGained(evt);
            }
        });

        txt_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_idempresa.setAlignmentY(0.8F);
        txt_idempresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idempresaActionPerformed(evt);
            }
        });

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nome.setAlignmentY(0.8F);
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        cb_departamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_departamento.setAlignmentY(0.8F);
        cb_departamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_departamentoItemStateChanged(evt);
            }
        });
        cb_departamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_departamentoFocusLost(evt);
            }
        });

        lb_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_idempresa.setText("Empresa ID:");
        lb_idempresa.setAlignmentY(0.8F);

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Emp. Nome:");
        lb_nome.setAlignmentY(0.8F);

        lb_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_remetente.setText("Entregue por:");
        lb_remetente.setAlignmentY(0.8F);

        txt_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_remetente.setAlignmentY(0.8F);

        lb_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_codigo.setText("Código:");
        lb_codigo.setAlignmentY(0.8F);

        btEnviarAlerta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btEnviarAlerta.setText("Alerta");
        btEnviarAlerta.setAlignmentY(0.8F);
        btEnviarAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarAlertaActionPerformed(evt);
            }
        });

        txtAlerta.setBackground(new java.awt.Color(255, 255, 255));
        txtAlerta.setForeground(new java.awt.Color(255, 255, 255));
        txtAlerta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAlerta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtAlerta.setOpaque(true);
        txtAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAlertaMouseClicked(evt);
            }
        });

        jpAux.setOpaque(false);

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

        lb_hora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_hora.setText("Hora");
        lb_hora.setAlignmentY(0.8F);

        txt_hora.setAlignmentY(0.8F);
        txt_hora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jpAuxLayout = new javax.swing.GroupLayout(jpAux);
        jpAux.setLayout(jpAuxLayout);
        jpAuxLayout.setHorizontalGroup(
            jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAuxLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpAuxLayout.createSequentialGroup()
                        .addComponent(lb_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAuxLayout.createSequentialGroup()
                        .addComponent(lb_recebidoem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAuxLayout.createSequentialGroup()
                        .addComponent(lb_recebidopor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAuxLayout.createSequentialGroup()
                        .addComponent(lb_hora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpAuxLayout.setVerticalGroup(
            jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAuxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_recebidoem)
                    .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_hora)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPrincipalLayout = new javax.swing.GroupLayout(jPrincipal);
        jPrincipal.setLayout(jPrincipalLayout);
        jPrincipalLayout.setHorizontalGroup(
            jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPrincipalLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addComponent(lb_codigo)
                        .addGap(329, 329, 329)
                        .addComponent(lb_resumo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAlerta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
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
                                .addGap(6, 6, 6)
                                .addComponent(btEnviarAlerta))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPrincipalLayout.createSequentialGroup()
                                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_remetente)
                                    .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_destino))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPrincipalLayout.createSequentialGroup()
                                        .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addGap(12, 12, 12)
                                        .addComponent(cb_para, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPrincipalLayout.createSequentialGroup()
                                            .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lb_idempresa)
                                            .addGap(12, 12, 12)
                                            .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        jPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btEnviarAlerta, btExcluir, btSair, bt_novo, btnAlterar, btnCancelar, btnSalvar});

        jPrincipalLayout.setVerticalGroup(
            jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPrincipalLayout.createSequentialGroup()
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lb_resumo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPrincipalLayout.createSequentialGroup()
                        .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPrincipalLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lb_remetente)
                                .addGap(22, 22, 22)
                                .addComponent(lb_nome)
                                .addGap(18, 18, 18)
                                .addComponent(lb_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPrincipalLayout.createSequentialGroup()
                                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPrincipalLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(lb_idempresa))
                                    .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_para, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEnviarAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(txtAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPrincipal);

        jpObs.setBackground(new java.awt.Color(250, 250, 250));

        txt_observacao.setColumns(20);
        txt_observacao.setLineWrap(true);
        txt_observacao.setRows(5);
        jScrollPane1.setViewportView(txt_observacao);

        lb_observacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_observacao.setText("Observacao:");

        javax.swing.GroupLayout jpObsLayout = new javax.swing.GroupLayout(jpObs);
        jpObs.setLayout(jpObsLayout);
        jpObsLayout.setHorizontalGroup(
            jpObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpObsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                    .addGroup(jpObsLayout.createSequentialGroup()
                        .addComponent(lb_observacao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpObsLayout.setVerticalGroup(
            jpObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpObsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_observacao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Observação", jpObs);

        jpPesquisa.setBackground(new java.awt.Color(250, 250, 250));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar:"));
        jPanel3.setOpaque(false);

        Usuario1.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup1.add(Usuario1);
        Usuario1.setText("Usuario:");
        Usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Usuario1ActionPerformed(evt);
            }
        });

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPesquisa.setToolTipText("Informe aqui o valor correspondente a sua pesquisa!");
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
        });

        jLabel6.setText("De:");

        jLabel7.setText("Até:");

        ID1.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup1.add(ID1);
        ID1.setText("ID:");
        ID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID1ActionPerformed(evt);
            }
        });

        Aberto1.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup2.add(Aberto1);
        Aberto1.setText("Em Aberto");
        Aberto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aberto1ActionPerformed(evt);
            }
        });

        Fechado1.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup2.add(Fechado1);
        Fechado1.setText("Fechado");
        Fechado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fechado1ActionPerformed(evt);
            }
        });

        btnOK1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOK1.setText("OK");
        btnOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOK1ActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(245, 245, 245));
        check.setText("Periodo");
        check.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkStateChanged(evt);
            }
        });

        Geral1.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup1.add(Geral1);
        Geral1.setText("Geral");
        Geral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Geral1ActionPerformed(evt);
            }
        });

        jRadioButton8.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("Todos");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        btRelatorio2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btRelatorio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/relatorio_icon.png"))); // NOI18N
        btRelatorio2.setToolTipText("Exportar resultados para leitura em tela");
        btRelatorio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorio2ActionPerformed(evt);
            }
        });

        btRelatorio3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btRelatorio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/excel_icon.png"))); // NOI18N
        btRelatorio3.setToolTipText("Exportar resultados para leitura em Excel(.xls)");
        btRelatorio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRelatorio3ActionPerformed(evt);
            }
        });

        Protocolo1.setBackground(new java.awt.Color(245, 245, 245));
        buttonGroup1.add(Protocolo1);
        Protocolo1.setText("Protocolo");
        Protocolo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Protocolo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Usuario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ID1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Protocolo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Geral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Aberto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Fechado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtData4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(check, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(txtData3, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOK1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRelatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRelatorio3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Protocolo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(check)
                                        .addGap(7, 7, 7)
                                        .addComponent(txtData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtData4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Geral1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Aberto1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(Fechado1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRelatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK1)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRelatorio3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPesquisaLayout = new javax.swing.GroupLayout(jpPesquisa);
        jpPesquisa.setLayout(jpPesquisaLayout);
        jpPesquisaLayout.setHorizontalGroup(
            jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        jpPesquisaLayout.setVerticalGroup(
            jpPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pesquisa", jPanel5);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Controle de Documentos");

        jTable.setBackground(new java.awt.Color(250, 250, 250));
        jTable.setForeground(new java.awt.Color(0, 0, 0));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Data", "Hora", "ID", "Empresa", "Historico", "Para Quem", "Departamento", "Observação", "Recebeu?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCellRenderer tcr = new ColorirJTable();
        TableColumn column = jTable.getColumnModel().getColumn(9);
        column.setCellRenderer(tcr);
        jTable.setRowHeight(22);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        pnPizza.setBackground(new java.awt.Color(250, 250, 250));
        pnPizza.setPreferredSize(new java.awt.Dimension(430, 250));

        javax.swing.GroupLayout pnPizzaLayout = new javax.swing.GroupLayout(pnPizza);
        pnPizza.setLayout(pnPizzaLayout);
        pnPizzaLayout.setHorizontalGroup(
            pnPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnPizzaLayout.setVerticalGroup(
            pnPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        pnTopBad.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout pnTopBadLayout = new javax.swing.GroupLayout(pnTopBad);
        pnTopBad.setLayout(pnTopBadLayout);
        pnTopBadLayout.setHorizontalGroup(
            pnTopBadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        pnTopBadLayout.setVerticalGroup(
            pnTopBadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );

        pnTopGreat.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout pnTopGreatLayout = new javax.swing.GroupLayout(pnTopGreat);
        pnTopGreat.setLayout(pnTopGreatLayout);
        pnTopGreatLayout.setHorizontalGroup(
            pnTopGreatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnTopGreatLayout.setVerticalGroup(
            pnTopGreatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnTopGreat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnPizza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(pnTopBad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnTopGreat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnTopBad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (cb_departamento.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo departamento informado é invalido");
        } else if (cb_para.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo destino informado é invalido");
        } else if (txt_codigo.getText().equals("")) {

            try {
                String datarec = txt_data.getText();
                Date data = sdf.parse(datarec);

                Date date = new Date();
                SimpleDateFormat sh = new SimpleDateFormat("HH:mm:ss");
                String hora = sh.format(date);
                txt_hora.setText(hora);

                String sql = "insert into documentos_recebidos "
                        + "(Data_Recebimento, Hora, Quem_Entregou, Empresa, ID, "
                        + "Historico, Departamento, Para_Quem, Observacao, Recebido) values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = getCon().prepareStatement(sql);

                ps.setDate(1, new java.sql.Date(data.getTime()));
                ps.setString(2, hora);
                ps.setString(3, txt_remetente.getText());
                ps.setString(4, txt_nome.getText());
                ps.setString(5, txt_idempresa.getText());
                ps.setString(6, txt_resumo.getText());
                ps.setString(7, (String) cb_departamento.getSelectedItem());
                ps.setString(8, (String) cb_para.getSelectedItem());
                ps.setString(9, "");
                ps.setString(10, "N");
                if (ps.executeUpdate() > 0) {
                    String aviso = "Deseja enviar alerta por e-mail?";
                    int escolha = JOptionPane.showConfirmDialog(null, aviso, "Envio de Alerta!", JOptionPane.YES_NO_OPTION);
                        if(escolha==JOptionPane.YES_OPTION){
                        if(enviarEmail()){
                            setEnabledAlterar(true);
                            setEnabledNovo(true);
                            setEditable(jPrincipal, false);
                            JOptionPane.showMessageDialog(null, "Sucesso!");
                            criaGraficos();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Não consegui enviar o seu e-mail, talvez por problema no servidor,"
                                    + "\nMas o seu lançamento esta salvo; \naguarde um pouco e tente enviar o alerta mais tarde!");
                        }
                        preencherTabela("select * from documentos_recebidos where Recebido='N' order by cod desc");
                }
                con.close();
            } catch (SQLException | ParseException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o registro!" + erro);
            }
        } else if (!txt_codigo.getText().equals("")) {
            try {

                String datarec = txt_data.getText();
                Date data = sdf.parse(datarec);
                String sql = "update documentos_recebidos set "
                        + "Quem_Entregou=?,"
                        + "Empresa=?,"
                        + "ID=?,"
                        + "Historico=?,"
                        + "Departamento=?,"
                        + "Para_Quem=?,"
                        + "Observacao=?, "
                        + "Recebido=? "
                        + "where cod=?";
                String valor;
                if(recebido.equals("C"))
                    valor = "N";
                else
                    valor = recebido;
                
                PreparedStatement ps = getCon().prepareStatement(sql);

                ps.setString(1, txt_remetente.getText());
                ps.setString(2, txt_nome.getText());
                ps.setString(3, txt_idempresa.getText());
                ps.setString(4, txt_resumo.getText());
                ps.setString(5, (String) cb_departamento.getSelectedItem());
                ps.setString(6, (String) cb_para.getSelectedItem());
                ps.setString(7, txt_observacao.getText());
                ps.setString(8, valor);
                ps.setInt(9, Integer.parseInt(txt_codigo.getText()));

                if (ps.executeUpdate() > 0) {
                    String aviso = "Deseja enviar alerta por e-mail?";
                    int escolha = JOptionPane.showConfirmDialog(null, aviso, "Envio de Alerta!", JOptionPane.YES_NO_OPTION);
                    if(escolha==JOptionPane.YES_OPTION){
                        if(enviarEmail()){
                            Thread.interrupted();
                            Thread();
                        }
                    }
                    preencherTabela("select * from documentos_recebidos where Recebido='N' order by cod desc");
                    criaGraficos();        
                }
                setEnabledAlterar(true);
                con.close();
            } catch (SQLException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel " + ex);
            }
        }
        setEnabledNovo(true);
        setEditable(jPrincipal, false);
        salvarCancelar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        criar_backup();
        setEditable(jPrincipal, true);
        limparTela(jPrincipal);
        limparTela(jpAux);
        limparTela(jpObs);
        setEnabledNovo(false);
        setHora();
        novoEditar();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restaurar_backup();
        setEditable(jPrincipal, false);
        setEnabledAlterar(true);
        setEnabledNovo(true);
        salvarCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (!txt_codigo.getText().equals("")) {
            try {
                this.comando = "select * from documentos_recebidos where cod=" + txt_codigo.getText();
                PreparedStatement ps = getCon().prepareStatement(comando);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        String cliente = "Deseja excluir o registro do cliente " + rs.getString("Empresa") + "?";
                        int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
                        if (opcao_escolhida == JOptionPane.YES_OPTION) {
                            if (excluir(Integer.parseInt(txt_codigo.getText())) == true) {
                                JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
                                preencherTabela("select * from documentos_recebidos where Recebido='N' order by cod desc");
                                criaGraficos();
                            }
                        }
                    }
                }
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao tentar excluir o registro!\n(Documentos Recebidos>Cadastro)\n" + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusao!");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        criar_backup();
        if (!txt_codigo.getText().equals("")) {
            setEditable(jPrincipal, true);
            setEnabledAlterar(false);
            novoEditar();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para alteração!");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btEnviarAlertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarAlertaActionPerformed
        if (txt_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Não há nada selecionado para ser enviado!");
        } else {
            String aviso = "Deseja enviar alerta por e-mail?";
            int escolha = JOptionPane.showConfirmDialog(null, aviso, "Envio de Alerta!", JOptionPane.YES_NO_OPTION);
            if(escolha==JOptionPane.YES_OPTION){
                if(enviarEmail()){
                    JOptionPane.showMessageDialog(null, "Sucesso!");
                }
            }
        }
    }//GEN-LAST:event_btEnviarAlertaActionPerformed

    private void Usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Usuario1ActionPerformed
        pesquisa = ("ParaQuem");
    }//GEN-LAST:event_Usuario1ActionPerformed

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ControleRecepcaoBean lb = new ControleRecepcaoBean();
            if (lb.buscar(txtData3.getText(), txtData4.getText(), txtPesquisa.getText()) == true) {
                comando = lb.getComando();
                preencherTabela(comando);
            }
        }
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void ID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID1ActionPerformed
        pesquisa = ("ID");
    }//GEN-LAST:event_ID1ActionPerformed

    private void Aberto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aberto1ActionPerformed
        situacao = ("Recebido = 'N'");
    }//GEN-LAST:event_Aberto1ActionPerformed

    private void Fechado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fechado1ActionPerformed
        situacao = ("Recebido = 'S'");
    }//GEN-LAST:event_Fechado1ActionPerformed

    private void btnOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOK1ActionPerformed
        ControleRecepcaoBean lb = new ControleRecepcaoBean();
        if (lb.buscar(txtData3.getText(), txtData4.getText(), txtPesquisa.getText()) == true) {
            comando = lb.getComando();
            preencherTabela(comando);
        }
    }//GEN-LAST:event_btnOK1ActionPerformed

    private void checkStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkStateChanged
        if (check.isSelected()) {
            txtData3.setEditable(true);
            txtData3.setBackground(Color.WHITE);
            txtData4.setEditable(true);
            txtData4.setBackground(Color.WHITE);
            statusData = true;
        } else {
            statusData = false;
            bloqueia_data();
        }
    }//GEN-LAST:event_checkStateChanged

    private void Geral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Geral1ActionPerformed
//        txtPesquisa.setText("");
        pesquisa = ("Geral");
    }//GEN-LAST:event_Geral1ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        //        situacao = "'S' or Recebido='N' ";
        situacao = ("Recebido is not null");
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void btRelatorio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorio2ActionPerformed
        ControleRecepcaoBean lb = new ControleRecepcaoBean();
        lb.buscar(txtData3.getText(), txtData4.getText(), txtPesquisa.getText());
        lb.gerarRelatorioPDF();
    }//GEN-LAST:event_btRelatorio2ActionPerformed

    private void btRelatorio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRelatorio3ActionPerformed
//        //envia comando para o metodo gerar printView dentro de listagem bean
        ControleRecepcaoBean lb = new ControleRecepcaoBean();
        lb.buscar(txtData3.getText(), txtData4.getText(), txtPesquisa.getText());
        lb.gerarRelatorioExcel();
    }//GEN-LAST:event_btRelatorio3ActionPerformed

    private void Protocolo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Protocolo1ActionPerformed
        pesquisa = "Protocolo";
    }//GEN-LAST:event_Protocolo1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int linha = jTable.getSelectedRow();
        String codigo = (String) jTable.getValueAt(linha, 0);
        txt_codigo.setText(codigo);
        
        if(!txt_codigo.getText().equals("")){
        try {
                String sql = "select * from documentos_recebidos where cod=" +txt_codigo.getText();

                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                String cbpara = "", quemrecebeu = "";
                cb_para.removeAllItems();
                if (rs != null) {
                    while (rs.next()) {
                        txt_codigo.setText(rs.getString("cod"));
                        txt_data.setText(tratamento(rs.getString("Data_Recebimento")));
                        txt_remetente.setText(rs.getString("Quem_Entregou"));
                        txt_nome.setText(rs.getString("Empresa"));
                        txt_idempresa.setText(rs.getString("ID"));
                        txt_resumo.setText(rs.getString("Historico"));
                        quemrecebeu = (rs.getString("Quem_recebeu"));
                        cbpara = (rs.getString("Para_Quem"));
                        cb_departamento.setSelectedItem(rs.getString("Departamento"));
                        txt_recebidoem.setText(tratamento(rs.getString("Data_Funcionario_Recebeu")));
                        txt_hora.setText(trataHora(rs.getString("Hora")));
                        txt_observacao.setText(rs.getString("Observacao"));
                        
                        if(cbpara!=null && !cbpara.equals("")){
                            cb_para.addItem(cbpara);
                            cb_para.setSelectedItem(cbpara);
                        }
                        if(quemrecebeu!=null && !quemrecebeu.equals(""))
                            txt_recebidopor.setText(quemrecebeu);
                        recebido = rs.getString("Recebido");
                    }
                }
                con.close();
            } catch (SQLException e) {
                //JOptionPane.showMessageDialog(null, "Problema ao selecionar linha!");
            }
        }

    }//GEN-LAST:event_jTableMouseClicked

    private void cb_paraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_paraFocusGained

    }//GEN-LAST:event_cb_paraFocusGained

    private void cb_departamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_departamentoFocusLost
        
    }//GEN-LAST:event_cb_departamentoFocusLost

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_idempresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idempresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idempresaActionPerformed

    private void txtAlertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAlertaMouseClicked
        if("".equals(txtAlerta.getText())){
            this.comando = "select * from documentos_recebidos where Recebido='C'";
            preencherTabela(this.comando);
        }
    }//GEN-LAST:event_txtAlertaMouseClicked

    private void cb_departamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_departamentoItemStateChanged
        cb_para.removeAllItems();
        switch ((String) cb_departamento.getSelectedItem()) {
            case "":
                setUsuario("");
                break;
            default:
                setUsuario((String) cb_departamento.getSelectedItem());
                break;
        }
    }//GEN-LAST:event_cb_departamentoItemStateChanged
    public class pesquisaTransferidos implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Executando thead");
                preencherTranferidos();
                Thread.sleep(1800 * 1000);
                Thread();
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Falha na executação da thread:" + ex);
            }
        }
    }

    private void preencherTranferidos() {
        try {
            this.comando = "select * from documentos_recebidos where Recebido='C'";
            PreparedStatement ps = getCon().prepareStatement(this.comando);
            ResultSet rs = ps.executeQuery();
            int j = 0;
            if (rs != null) {
                while (rs.next()) {
                    j++;
                }
                String text = "";
                if (j == 1) {
                    txtAlerta.setText("1 - Documento foi constestado, e sua entrega não foi completa! Clique aqui para visualizar!");
                    txtAlerta.setBackground(Color.red);
                } else if (j > 1) {
                    txtAlerta.setText(j + " - Documentos foram constestados, e suas entregas não foram completadas! Clique aqui para visualizar!");
                    txtAlerta.setBackground(Color.red);
                }
            } else {
                txtAlerta.setBackground(Color.white);
                txtAlerta.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar pesquisa de tranferidos");
        }
    }

    private void Thread() {
        pesquisaTransferidos pesquisar = new pesquisaTransferidos();
        Thread transferidos = new Thread(pesquisar);
        transferidos.start();
    }

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
        result.setValue("Abertos", new Double(qtdN));
        result.setValue("Fechados", new Double(qtdY));
        result.setValue("Transferidos", new Double(qtdTransfer));
        return result;

    }

    private JFreeChart createChart(final PieDataset dataset) {

        final JFreeChart chart = ChartFactory.createPieChart3D(
                "Visão Geral", // chart title
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
        String titulo = "Ranking - Top 10 Pendentes";
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
        String titulo = "Ranking - Top 10 Finalizadores";
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
            java.util.logging.Logger.getLogger(ControleRecepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControleRecepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControleRecepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControleRecepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleRecepcao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Aberto1;
    private javax.swing.JRadioButton Fechado1;
    private javax.swing.JRadioButton Geral1;
    private javax.swing.JRadioButton ID1;
    private javax.swing.JRadioButton Protocolo1;
    private javax.swing.JRadioButton Usuario1;
    private javax.swing.JButton btEnviarAlerta;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btRelatorio2;
    private javax.swing.JButton btRelatorio3;
    private javax.swing.JButton btSair;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cb_departamento;
    private javax.swing.JComboBox cb_para;
    public static javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPrincipal;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JPanel jpAux;
    private javax.swing.JPanel jpObs;
    private javax.swing.JPanel jpPesquisa;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_data;
    private javax.swing.JLabel lb_destino;
    private javax.swing.JLabel lb_hora;
    private javax.swing.JLabel lb_idempresa;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_observacao;
    private javax.swing.JLabel lb_recebidoem;
    private javax.swing.JLabel lb_recebidopor;
    private javax.swing.JLabel lb_remetente;
    private javax.swing.JLabel lb_resumo;
    private javax.swing.JPanel pnPizza;
    private javax.swing.JPanel pnTopBad;
    private javax.swing.JPanel pnTopGreat;
    private javax.swing.JLabel txtAlerta;
    private javax.swing.JFormattedTextField txtData3;
    private javax.swing.JFormattedTextField txtData4;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JFormattedTextField txt_hora;
    private javax.swing.JTextField txt_idempresa;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextArea txt_observacao;
    private javax.swing.JFormattedTextField txt_recebidoem;
    private javax.swing.JTextField txt_recebidopor;
    private javax.swing.JTextField txt_remetente;
    private javax.swing.JTextArea txt_resumo;
    // End of variables declaration//GEN-END:variables
    public void criaGraficos(){
         pegaPior();
         pegaMelhor();
         gerarResultPizza();
         criaGraficoBad();
         criaGraficoGreat();
         gerarPizza();
    }
    
    private void preencherTabela(String sql) {
        DefaultTableModel tb = (DefaultTableModel)jTable.getModel();
        while(tb.getRowCount()>0)
            tb.removeRow(0);
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                int j = 0;
                while (rs.next()) {
                    tb.addRow(new Object[1]);
                    tb.setValueAt(rs.getString("cod"), j, 0);
                    tb.setValueAt(tratamento(rs.getString("Data_Recebimento")), j, 1);
                    tb.setValueAt(rs.getString("Hora"), j, 2);
                    tb.setValueAt(rs.getString("ID"), j, 3);
                    tb.setValueAt(rs.getString("Empresa"), j, 4);
                    tb.setValueAt(rs.getString("Historico"), j, 5);
                    tb.setValueAt(rs.getString("Para_Quem"), j, 6);
                    tb.setValueAt(rs.getString("Departamento"), j, 7);
                    tb.setValueAt(rs.getString("Observacao"), j, 8);
                    String foiRecebido;
                    if("N".equals(rs.getString("Recebido")))
                        foiRecebido="Não";
                    else
                        foiRecebido="Sim";
                    tb.setValueAt(foiRecebido, j, 9);
                    j++;
                }
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela!");
        }
    }

    public void limpar_tabela() {
        DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();
        for (int j = tbm.getRowCount() - 1; j >= 0; j--) {
            tbm.removeRow(i);
        }
    }

    private void pegaMelhor() {
        //ocultando usuarios não ativos
        String sql = "select A.Para_Quem, count(A.Recebido) as Quantidade "
                + "from documentos_recebidos as A "
                + "inner join login as B "
                + "on A.Para_Quem=B.Usuario "
                + "and A.Recebido='S' and B.Ativo=1 "
                + "group by A.Para_Quem "
                + "order by count(A.Recebido) desc limit 10;";
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
                + "where Recebido='N') as QtdN, "
                + "(select count(Recebido) from documentos_recebidos "
                + "where Recebido='T') as QtdT from documentos_recebidos "
                + "where Recebido='S'";
        con = null;
        PreparedStatement ps;
        try {
            ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    qtdY = (rs.getDouble("QtdY"));
                    qtdN = (rs.getDouble("QtdN"));
                    qtdTransfer = (rs.getDouble("QtdT"));
                }
            }
            con.close();
        } catch (SQLException ex) {
        }
    }

    private void limparTela(Object painel) {
        int qtdComponentes;
        Container container = null;
        if (painel instanceof JPanel) {
            container = (JPanel) painel;
        }
        if (painel instanceof JScrollPane) {
            container = (JScrollPane) painel;
        }
        if (painel instanceof JViewport) {
            container = (JViewport) painel;
        }
        qtdComponentes = container.getComponentCount();
        for (int i = 0; i < qtdComponentes; i++) {
            Component c = container.getComponent(i);
            if (c instanceof JScrollPane || c instanceof JPanel || c instanceof JViewport) {
                limparTela(c);
                continue;
            }
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            }
            if (c instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c;
                field.setText("");
            }
            if (c instanceof JTextArea) {
                JTextArea field = (JTextArea) c;
                field.setText("");
            }
            if (c instanceof JComboBox) {
                JComboBox field = (JComboBox) c;
//                field.setSelectedIndex(0);
                field.setSelectedItem("");
            }

        }

    }

    private void setEditable(Object painel, boolean editar) {
        int qtdComponentes;
        Container container = null;
        if (painel instanceof JPanel) {
            container = (JPanel) painel;
        }
        if (painel instanceof JScrollPane) {
            container = (JScrollPane) painel;
        }
        if (painel instanceof JViewport) {
            container = (JViewport) painel;
        }
        qtdComponentes = container.getComponentCount();
        for (int i = 0; i < qtdComponentes; i++) {
            Component c = container.getComponent(i);
            if (c instanceof JScrollPane || c instanceof JPanel || c instanceof JViewport) {
                setEditable(c, editar);
                continue;
            }
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setEditable(editar);
                txt_recebidopor.setEditable(false);
                txt_recebidopor.setEditable(false);
                txt_codigo.setEditable(false);
            }
            if (c instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) c;
                field.setEditable(editar);
                txt_data.setEditable(false);
                txt_hora.setEditable(false);
                txt_recebidoem.setEditable(false);
            }
            if (c instanceof JTextArea) {
                JTextArea field = (JTextArea) c;
                field.setEditable(editar);
                txt_observacao.setEditable(false);
            }
            if (c instanceof JComboBox) {
                JComboBox field = (JComboBox) c;
//                field.setSelectedIndex(0);
                field.setEnabled(editar);
            }
        }
    }

    private void setHora() {
        Date data = new Date();
        String datatela = sdf.format(data);
        txt_data.setText(datatela);
    }

    private void setEnabledNovo(boolean status) {
        JButton[] botoes = {btnAlterar, btExcluir, btSair, btEnviarAlerta};
        for (int i = 0; i < botoes.length; i++) {
            botoes[i].setEnabled(status);
        }
        if (status == false) {
            btnCancelar.setEnabled(true);
        } else {
            btnCancelar.setEnabled(false);
        }
    }

    private void setEnabledAlterar(boolean status) {
        JButton[] botoes = {bt_novo, btExcluir, btSair, btEnviarAlerta};
        for (JButton botoe : botoes) {
            botoe.setEnabled(status);
        }
        if (status == false) {
            btnCancelar.setEnabled(true);
        } else {
            btnCancelar.setEnabled(false);
        }
        if (txt_codigo.getText().equals("")) {
            btEnviarAlerta.setEnabled(false);
        } else {
            btEnviarAlerta.setEnabled(false);
        }
    }

    private void setUsuario(String departamento) {
        String sql, dep = "";
        if (!departamento.equals("")) 
                dep = "Departamento='" + departamento + "' and ";
            sql = "select Usuario from login where " + dep + "Ativo=1 order by Usuario";
            try {
                PreparedStatement ps = getCon().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        cb_para.addItem(rs.getString("Usuario"));
                    }
                }
                con.close();

            } catch (SQLException erro) {

            }
    }

    private void setDepartamento(String usuario) {
        String sql;
        if (!usuario.equals("") && !usuario.equals(null)) {
            sql = "select A.nome as Nome from departamento as A inner join login as B on A.nome = B.Departamento and B.Usuario like '" + usuario + "'";
        } else {
            sql = "select nome as Nome from departamento";
        }
        try {

            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    cb_departamento.addItem(rs.getString("Nome"));
                }
            }
            con.close();
        } catch (SQLException erro) {

        }
    }

    private void limpaCarregaCombo() {
        setDepartamento("");
        //setUsuario("");
    }

    private String tratamento(String data) {
        if (data == null) {
            return "";
        } else {
            int posForForm = data.indexOf("-");
            int posForDB = data.indexOf("/");
            if (data.length() == 10 && posForForm != -1) {
                String ano = data.substring(0, 4);
                String mes = data.substring(5, 7);
                String dia = data.substring(8);
                String recebeMysql = dia + "/" + mes + "/" + ano;
                return recebeMysql;
            } else if (data.length() == 10 && posForDB != -1) {
                String dia = data.substring(0, 2);
                String mes = data.substring(3, 5);
                String ano = data.substring(6);
                String recebeDaTela = ano + "-" + mes + "-" + dia;
                return recebeDaTela;
            }
        }
        return "";
    }

    private String trataHora(String hora) {
        if (hora.length() >= 6) {
            String novaHora = hora.substring(0, 2);
            String minuto = hora.substring(3, 5);
            return novaHora + ":" + minuto;
        } else {
            return "";
        }
    }

    public void criar_backup() {
        codigo_backup = txt_codigo.getText();
        remetente_backup = txt_remetente.getText();
        idempresa_backup = txt_idempresa.getText();
        nome_backup = txt_nome.getText();
        resumo_backup = txt_resumo.getText();
        recebidopor_backup = txt_recebidopor.getText();
        remetente_backup = txt_remetente.getText();
        observacao_backup = txt_observacao.getText();
        departamento_backup = (String) cb_departamento.getSelectedItem();
        para_backup = (String) cb_para.getSelectedItem();
        hora_backup = txt_hora.getText();
    }

    public void restaurar_backup() {
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
        txt_hora.setText(hora_backup);
    }

    private void bloqueia_data() {

        for (int j = 0; j < jPanel3.getComponentCount(); j++) {
            if (jPanel3.getComponent(j) instanceof JFormattedTextField) {
                ((JFormattedTextField) jPanel3.getComponent(j)).setEditable(false);
                ((JFormattedTextField) jPanel3.getComponent(j)).setBackground(Color.lightGray);
            }
        }

//    txtData1.setEditable(false);
//    txtData1.setBackground(Color.lightGray);
//    txtData2.setEditable(false);
//    txtData2.setBackground(Color.lightGray);
    }

    boolean excluir(int codigo) {
        String sql = "DELETE from documentos_recebidos where cod=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, codigo);
            if (ps.executeUpdate() > 0) {
                limparTela(jPrincipal);
                limparTela(jpAux);
                limparTela(jpObs);
            }
            con.close();
            return true;
        } catch (SQLException erro) {
            return false;
        }
    }

    private boolean enviarEmail(){
        AvisoEmail aviso = new AvisoEmail();
        HtmlEntities html = new HtmlEntities();
        String nomeCliente = html.Converter(txt_nome.getText());
        String mensagem = html.Converter(txt_resumo.getText());
        String a = (String) cb_para.getSelectedItem();
        String aux = "Foi lan&ccedil;ado na recep&ccedil;&atilde;o,";
        String novoemail = (buscarEmail(a));
        try{
            if(aviso.enviaAlerta(aux, txt_hora.getText(), nomeCliente, txt_idempresa.getText(), novoemail, a, mensagem)==true)
                return true;
        }catch(Exception e){
            changeRecebido();
            return false;
        }
        return false;
    }
        

    private String buscarEmail(String usuario) {
        try {
            String sql = "select Email from login where Usuario=?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    String emailUser = rs.getString("Email");
                    return emailUser;

                }
            } else {
                return "";
            }
        } catch (Exception e) {
            System.out.print("Erro ao buscar email do usuario");
            return "";
        }
        return "";
    }

    private boolean changeRecebido() {
        try {
            String sql = "update documentos_recebidos set Alerta='N' where cod=?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, txt_codigo.getText());
            if (ps.executeUpdate() > 0) {
                preencherTabela("select * from documentos_recebidos where Alerta='N' order by cod desc");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.print("Erro ao alterar status do alerta");
            return false;
        }
    }
    public void salvarCancelar(){
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        if(!txt_codigo.getText().equals("")){    
            btExcluir.setEnabled(true);
            btEnviarAlerta.setEnabled(true);
        }
    }
    public void novoEditar(){
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btEnviarAlerta.setEnabled(false);
    }

}
class ColorirJTable extends JLabel implements TableCellRenderer{
    public ColorirJTable(){
        this.setOpaque(true);
    }
    @Override
    public Component getTableCellRendererComponent(
        JTable table, 
        Object value, boolean isSelected, boolean hasFocus,
           int row, int column){

        if(value!=null && value.toString().equalsIgnoreCase("Não")){
          setBackground(Color.RED);	
        }
        else{
          setBackground(Color.GREEN);		
        }
        setForeground(Color.WHITE);
        setText(value!=null?value.toString():"");
        return this;   	
    }
  
    @Override
  public void validate() {}
    @Override
  public void revalidate() {}
    @Override
  protected void firePropertyChange(String propertyName,
     Object oldValue, Object newValue) {}
    @Override
  public void firePropertyChange(String propertyName,
     boolean oldValue, boolean newValue) {}
}

