package br.viewer.cadastros;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.TelaPrincipal;

public class Financeiro extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con_financeiro, con_controle, con_planilha, con_boleto;
    //maskara para o JFormattedTextField
    MaskFormatter formatoPlanilha, formatoControle, formatoBoleto;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String planilha, boleto, controle, codPlan_backup, dataPlan_backup, obsPlan_backup, tipoPlan_backup,
            codBol_backup, dataBol_backup, obsBol_backup, tipoBol_backup,
            codCon_backup, dataCon_backup, obsCon_backup, tipoCon_backup;
    String processo=TelaPrincipal.txt_codigo.getText();
    
    public Financeiro() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        con_financeiro = new Conexao();
        con_financeiro.conecta();
        
        con_controle = new Conexao();
        con_controle.conecta();
        
        con_planilha = new Conexao();
        con_planilha.conecta();
        
        con_boleto = new Conexao();
        con_boleto.conecta();
        
        //chamando metodo que preencha as tabelas
        preencher_tabela_planilha();
        preencher_tabela_boleto();
        preencher_tabela_controle();
        //chamando metodo que preencha tela de status
        preencher_status();
        
        limpar_tela_planilha();
        limpar_tela_boleto();
        limpar_tela_controle();
        //chamando metodo que busca a data atual e envia para os campos de datas
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFiscal = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_cod = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        jtbGuiaFiscal = new javax.swing.JTabbedPane();
        jpSitFinan = new javax.swing.JPanel();
        lbTitFaseFinanceiro = new javax.swing.JLabel();
        lbTitStatusFiscal = new javax.swing.JLabel();
        lbplanilha = new javax.swing.JLabel();
        txt_status_planilha = new javax.swing.JLabel();
        lbboleto = new javax.swing.JLabel();
        txt_status_boleto = new javax.swing.JLabel();
        lbControle = new javax.swing.JLabel();
        txt_status_controle = new javax.swing.JLabel();
        txt_andamento_financeiro = new javax.swing.JLabel();
        jpPlanilha = new javax.swing.JPanel();
        lbcod_planilha = new javax.swing.JLabel();
        txt_cod_planilha = new javax.swing.JTextField();
        lb_andamento_planilha = new javax.swing.JLabel();
        lb_obs_planilha = new javax.swing.JLabel();
        try {
     formatoPlanilha = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local planilha: " +erro);
 }
        txt_data_planilha = new JFormattedTextField(formatoPlanilha);
        lb_tipo_planilha = new javax.swing.JLabel();
        cb_tipo_planilha = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txt_obs_planilha = new javax.swing.JTextArea();
        bt_novo_planilha = new javax.swing.JButton();
        bt_salvar_planilha = new javax.swing.JButton();
        bt_cancelar_planilha = new javax.swing.JButton();
        bt_excluir_planilha = new javax.swing.JButton();
        bt_fechar_planilha = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_planilha = new javax.swing.JTable();
        bt_alterar_planilha = new javax.swing.JButton();
        jpBoleto = new javax.swing.JPanel();
        lbcod_boleto = new javax.swing.JLabel();
        txt_cod_boleto = new javax.swing.JTextField();
        lb_data_boleto = new javax.swing.JLabel();
        try {
            formatoBoleto = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em Boleto: " +erro);
        }
        txt_data_boleto = new JFormattedTextField(formatoBoleto);
        lb_tipo_boleto = new javax.swing.JLabel();
        cb_tipo_boleto = new javax.swing.JComboBox();
        lb_obs_boleto = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_obs_boleto = new javax.swing.JTextArea();
        bt_alterar_boleto = new javax.swing.JButton();
        bt_salvar_boleto = new javax.swing.JButton();
        bt_cancelar_boleto = new javax.swing.JButton();
        bt_excluir_boleto = new javax.swing.JButton();
        bt_fechar_boleto = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_boleto = new javax.swing.JTable();
        bt_novo_boleto = new javax.swing.JButton();
        jpControle = new javax.swing.JPanel();
        lbcod_controle = new javax.swing.JLabel();
        txt_cod_controle = new javax.swing.JTextField();
        lbdata_controle = new javax.swing.JLabel();
        try {
            formatoControle = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em Controle: " +erro);
        }
        txt_data_controle = new JFormattedTextField(formatoControle);
        lbtipo_controle = new javax.swing.JLabel();
        cb_tipo_controle = new javax.swing.JComboBox();
        lb_obs_controle = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txt_obs_controle = new javax.swing.JTextArea();
        bt_novo_controle = new javax.swing.JButton();
        bt_salvar_controle = new javax.swing.JButton();
        bt_cancelar_controle = new javax.swing.JButton();
        bt_excluir_controle = new javax.swing.JButton();
        bt_fechar_controle = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tb_controle = new javax.swing.JTable();
        bt_alterar_controle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpFiscal.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Financeiro");
        lb_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lb_cod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_cod.setText("Nº:");

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Nome:");

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id.setText("ID:");

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtbGuiaFiscal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpSitFinan.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFaseFinanceiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFaseFinanceiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFaseFinanceiro.setText("Fase:");

        lbTitStatusFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatusFiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatusFiscal.setText("Status:");

        lbplanilha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbplanilha.setText("Lançamento na Planilha de Cobrança:");

        txt_status_planilha.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_planilha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_planilha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_planilha.setOpaque(true);

        lbboleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbboleto.setText("Emissão de Boleto:");

        txt_status_boleto.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_boleto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_boleto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_boleto.setOpaque(true);

        lbControle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbControle.setText("Lançar Controle de O.S no Control:");

        txt_status_controle.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_controle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_controle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_controle.setOpaque(true);

        txt_andamento_financeiro.setBackground(new java.awt.Color(245, 245, 245));
        txt_andamento_financeiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_andamento_financeiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_andamento_financeiro.setToolTipText("");
        txt_andamento_financeiro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_andamento_financeiro.setOpaque(true);

        javax.swing.GroupLayout jpSitFinanLayout = new javax.swing.GroupLayout(jpSitFinan);
        jpSitFinan.setLayout(jpSitFinanLayout);
        jpSitFinanLayout.setHorizontalGroup(
            jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitFinanLayout.createSequentialGroup()
                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitFinanLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lbTitFaseFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(lbTitStatusFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitFinanLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(txt_andamento_financeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitFinanLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpSitFinanLayout.createSequentialGroup()
                                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitFinanLayout.createSequentialGroup()
                                        .addComponent(lbplanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86))
                                    .addGroup(jpSitFinanLayout.createSequentialGroup()
                                        .addComponent(lbboleto, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121)))
                                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_status_boleto, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(txt_status_planilha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpSitFinanLayout.createSequentialGroup()
                                .addComponent(lbControle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(txt_status_controle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(60, 60, 60))
        );
        jpSitFinanLayout.setVerticalGroup(
            jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitFinanLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitFaseFinanceiro)
                    .addComponent(lbTitStatusFiscal))
                .addGap(12, 12, 12)
                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbplanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_status_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbboleto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitFinanLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_status_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpSitFinanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbControle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitFinanLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_status_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148)
                .addComponent(txt_andamento_financeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaFiscal.addTab("Situação", jpSitFinan);

        jpPlanilha.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_planilha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_planilha.setText("Cod:");

        lb_andamento_planilha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_andamento_planilha.setText("Data:");

        lb_obs_planilha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_planilha.setText("Observação:");

        lb_tipo_planilha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_planilha.setText("Tipo:");

        cb_tipo_planilha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        txt_obs_planilha.setColumns(20);
        txt_obs_planilha.setLineWrap(true);
        txt_obs_planilha.setRows(5);
        jScrollPane9.setViewportView(txt_obs_planilha);

        bt_novo_planilha.setText("Novo");
        bt_novo_planilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novo_planilhaActionPerformed(evt);
            }
        });

        bt_salvar_planilha.setText("Incluir");
        bt_salvar_planilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvar_planilhaActionPerformed(evt);
            }
        });

        bt_cancelar_planilha.setText("Cancelar");
        bt_cancelar_planilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar_planilhaActionPerformed(evt);
            }
        });

        bt_excluir_planilha.setText("Excluir");
        bt_excluir_planilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluir_planilhaActionPerformed(evt);
            }
        });

        bt_fechar_planilha.setText("Fechar");
        bt_fechar_planilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fechar_planilhaActionPerformed(evt);
            }
        });

        tb_planilha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Processo", "Data", "Tipo", "Observação", "Usuario"
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
        tb_planilha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_planilhaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_planilha);

        bt_alterar_planilha.setText("Alterar");
        bt_alterar_planilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_planilhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPlanilhaLayout = new javax.swing.GroupLayout(jpPlanilha);
        jpPlanilha.setLayout(jpPlanilhaLayout);
        jpPlanilhaLayout.setHorizontalGroup(
            jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_planilha)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_andamento_planilha)
                .addGap(111, 111, 111)
                .addComponent(txt_data_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_planilha)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_planilha)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(bt_novo_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_alterar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_salvar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_cancelar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_excluir_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_fechar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpPlanilhaLayout.setVerticalGroup(
            jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_planilha))
                    .addComponent(txt_cod_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_andamento_planilha))
                    .addComponent(txt_data_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_planilha))
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_planilha)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_salvar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_novo_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_cancelar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_excluir_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_fechar_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaFiscal.addTab("Planilha de Cobrança", jpPlanilha);

        jpBoleto.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_boleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_boleto.setText("Cod:");

        lb_data_boleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_data_boleto.setText("Data:");

        lb_tipo_boleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_boleto.setText("Tipo:");

        cb_tipo_boleto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        lb_obs_boleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_boleto.setText("Observação:");

        txt_obs_boleto.setColumns(20);
        txt_obs_boleto.setLineWrap(true);
        txt_obs_boleto.setRows(5);
        jScrollPane7.setViewportView(txt_obs_boleto);

        bt_alterar_boleto.setText("Alterar");
        bt_alterar_boleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_boletoActionPerformed(evt);
            }
        });

        bt_salvar_boleto.setText("Incluir");
        bt_salvar_boleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvar_boletoActionPerformed(evt);
            }
        });

        bt_cancelar_boleto.setText("Cancelar");
        bt_cancelar_boleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar_boletoActionPerformed(evt);
            }
        });

        bt_excluir_boleto.setText("Excluir");
        bt_excluir_boleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluir_boletoActionPerformed(evt);
            }
        });

        bt_fechar_boleto.setText("Fechar");
        bt_fechar_boleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fechar_boletoActionPerformed(evt);
            }
        });

        tb_boleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Processo", "Data", "Tipo", "Observação", "Usuario"
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
        tb_boleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_boletoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_boleto);

        bt_novo_boleto.setText("Novo");
        bt_novo_boleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novo_boletoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBoletoLayout = new javax.swing.GroupLayout(jpBoleto);
        jpBoleto.setLayout(jpBoletoLayout);
        jpBoletoLayout.setHorizontalGroup(
            jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBoletoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_boleto)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpBoletoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_data_boleto)
                .addGap(111, 111, 111)
                .addComponent(txt_data_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_boleto)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpBoletoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_boleto)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpBoletoLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(bt_novo_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_alterar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_salvar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_cancelar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_excluir_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_fechar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpBoletoLayout.setVerticalGroup(
            jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBoletoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_boleto))
                    .addComponent(txt_cod_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_data_boleto))
                    .addComponent(txt_data_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_boleto))
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_boleto)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_salvar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_novo_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_cancelar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_excluir_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_fechar_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpBoletoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_cod_boleto, txt_data_boleto});

        jtbGuiaFiscal.addTab("Emissão de Boleto", jpBoleto);

        jpControle.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_controle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_controle.setText("Cod:");

        lbdata_controle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbdata_controle.setText("Data:");

        lbtipo_controle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbtipo_controle.setText("Tipo:");

        cb_tipo_controle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cb_tipo_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipo_controleActionPerformed(evt);
            }
        });

        lb_obs_controle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_controle.setText("Observação:");

        txt_obs_controle.setColumns(20);
        txt_obs_controle.setLineWrap(true);
        txt_obs_controle.setRows(5);
        jScrollPane10.setViewportView(txt_obs_controle);

        bt_novo_controle.setText("Novo");
        bt_novo_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novo_controleActionPerformed(evt);
            }
        });

        bt_salvar_controle.setText("Incluir");
        bt_salvar_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvar_controleActionPerformed(evt);
            }
        });

        bt_cancelar_controle.setText("Cancelar");
        bt_cancelar_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar_controleActionPerformed(evt);
            }
        });

        bt_excluir_controle.setText("Excluir");
        bt_excluir_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluir_controleActionPerformed(evt);
            }
        });

        bt_fechar_controle.setText("Fechar");
        bt_fechar_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fechar_controleActionPerformed(evt);
            }
        });

        tb_controle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Processo", "Data", "Tipo", "Observação", "Usuario"
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
        tb_controle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_controleMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tb_controle);

        bt_alterar_controle.setText("Alterar");
        bt_alterar_controle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_controleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpControleLayout = new javax.swing.GroupLayout(jpControle);
        jpControle.setLayout(jpControleLayout);
        jpControleLayout.setHorizontalGroup(
            jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpControleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_controle)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpControleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbdata_controle)
                .addGap(111, 111, 111)
                .addComponent(txt_data_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lbtipo_controle)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpControleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_controle)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpControleLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(bt_novo_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_alterar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_salvar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_cancelar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_excluir_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_fechar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpControleLayout.setVerticalGroup(
            jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpControleLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_controle))
                    .addComponent(txt_cod_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbdata_controle))
                    .addComponent(txt_data_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbtipo_controle))
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_controle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_controle)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_salvar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_novo_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_cancelar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_excluir_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_fechar_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaFiscal.addTab("Controle de O.S - Control", jpControle);

        javax.swing.GroupLayout jpFiscalLayout = new javax.swing.GroupLayout(jpFiscal);
        jpFiscal.setLayout(jpFiscalLayout);
        jpFiscalLayout.setHorizontalGroup(
            jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFiscalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFiscalLayout.createSequentialGroup()
                        .addGroup(jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_cod)
                            .addComponent(lb_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbGuiaFiscal))
                .addContainerGap())
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpFiscalLayout.setVerticalGroup(
            jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFiscalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo)
                .addGap(18, 18, 18)
                .addGroup(jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_nome)
                        .addComponent(lb_cod)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jtbGuiaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFiscal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_excluir_boletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluir_boletoActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_boleto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
            return;
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from emissaoboleto where CodEmissaoBoleto= "+txt_cod_boleto.getText();
                con_boleto.executeSQL(sql);
                con_boleto.resultset.first();
                String nome = "Tem certeza que deseja excluir um cadastro da tabela Boleto com cliente : " +con_boleto.resultset.getString("Cliente")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM distribuirfuncionariointerno Where CodDistribuirFuncionarioInterno="+txt_cod_boleto.getText();
                    int conseguiu_excluir = con_boleto.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        
                    limpar_tabela_boleto();
                    preencher_tabela_boleto();
                    limpar_tela_boleto();
                    preencher_status();
                    atualizar_cadastro_cliente();
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro");
            }
        }
    }//GEN-LAST:event_bt_excluir_boletoActionPerformed

    private void bt_cancelar_boletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar_boletoActionPerformed
        if(txt_data_distribuir.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Digite uma data válida no campo novo andamento!");
        }
        else if(txt_cod_distribuir.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro para alteração!");
        }
        else if(cb_tipo_distribuir.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campo Tipo não pode ficar em branco!");
            cb_tipo_distribuir.requestFocus();
        }
        else{
            try{
               
                String dataandamento = txt_data_distribuir.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamento;
                if(cb_tipo_distribuir.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }else{
                    andamento = "Em Aberto";
                }
                String sql = "UPDATE distribuirfuncionariointerno set DatadeCadastroAndamento='"+
                new java.sql.Date(data.getTime())+"',"+
                "Obsevacao='"+txt_obs_distribuir.getText()+"',"+
                "Usuario= '"+txt_usuario.getText()+"',"+
                "AndamentoDistribuirFuncionarioInterno='"+andamento+"',"+
                "Tipo='"+cb_tipo_distribuir.getSelectedItem()+"' "+
                "where CodDistribuirFuncionarioInterno = "+txt_cod_distribuir.getText();

                con_distribuir.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Termo: \n " +erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
        atualiza_fiscal_distribuir();
        preencher_status();
        limpar_tabela_distribuir();
        preencher_jtable_distribuir();
        
        }
    }//GEN-LAST:event_bt_cancelar_boletoActionPerformed

    private void bt_salvar_boletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvar_boletoActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_distribuir.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
            return;
        }
        else if(cb_tipo_distribuir.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_distribuir.requestFocus();
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_distribuir.getText().isEmpty()){
            try{
                String dataandamento = txt_data_distribuir.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamentoarquivo;
                if(cb_tipo_distribuir.getSelectedItem().equals("Finalizado")){
                    andamentoarquivo = "Finalizado";
                }
                else{
                    andamentoarquivo = "Em Aberto";
                    }
                String gry = "insert into distribuirfuncionariointerno ("+
                "NumeroProcesso, DatadeCadastroAndamento, Obsevacao, "+
                "Cliente, Usuario, AndamentoDistribuirFuncionarioInterno, Tipo) values ('" +processo+"','"+
                new java.sql.Date(data.getTime())+"','"+
                txt_obs_distribuir.getText()+"','"+
                txt_nome.getText()+"','"+
                txt_usuario.getText()+"','"+
                andamentoarquivo+"','"+
                cb_tipo_distribuir.getSelectedItem()+"')";

                con_distribuir.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

            }catch(ParseException | HeadlessException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Arquivo: "+erro);
            }
        }
        else{
            //nao permitir cadastrar um novo se já constar um codigo preenchido
            JOptionPane.showMessageDialog(null, "Clique em novo para inserir um novo registro!");
            return;
        }
        atualiza_fiscal_distribuir();
        preencher_status();
        limpar_tabela_distribuir();
        preencher_jtable_distribuir();
        
    }//GEN-LAST:event_bt_salvar_boletoActionPerformed

    private void bt_fechar_boletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fechar_boletoActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fechar_boletoActionPerformed

    private void bt_alterar_boletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_boletoActionPerformed
        limpar_tela_distribuir();
    }//GEN-LAST:event_bt_alterar_boletoActionPerformed

    private void bt_excluir_planilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluir_planilhaActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_perfil.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
            return;
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from validarprefilfiscal where CodValidarPerfilFiscal= "+txt_cod_perfil.getText();
                con_perfil.executeSQL(sql);
                con_perfil.resultset.first();
                String nome = "Tem certeza que deseja excluir um cadastro da tabela Termo com cliente : " +con_perfil.resultset.getString("Cliente")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM validarprefilfiscal Where CodValidarPerfilFiscal = "+txt_cod_perfil.getText();
                    int conseguiu_excluir = con_perfil.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro");
            }
        }
        limpar_tela_perfil();
        limpar_tabela_perfil();
        preencher_jtable_perfil();
        preencher_status();

    }//GEN-LAST:event_bt_excluir_planilhaActionPerformed

    private void bt_cancelar_planilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar_planilhaActionPerformed
        if(txt_data_perfil.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Digite uma data válida no campo novo andamento!");
        }
        else if(txt_cod_perfil.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor selecione um registro para alteração!");
            return;
        }
        else if(cb_tipo_perfil.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_perfil.requestFocus();
        }
        else{
            try{
               
                String dataandamento = txt_data_perfil.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamentotermo;
                
                if(cb_tipo_perfil.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                    
                }
                else{
                    andamentotermo = "Em Aberto";
                    
                }
                String sql = "UPDATE validarprefilfiscal set DatadeCadastroAndamento='"+
                new java.sql.Date(datatermo.getTime())+"',"+
                "Obsevacao='"+txt_obs_perfil.getText()+"',"+
                "Usuario = '"+txt_usuario.getText()+"',"+
                "AndamentoValidarPerfilFiscal='"+andamentotermo+"',"+
                "Tipo='"+cb_tipo_perfil.getSelectedItem()+"' "+
                "where CodValidarPerfilFiscal = "+txt_cod_perfil.getText();

                con_perfil.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Termo: " +erro);
            }catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
        }
        atualiza_fiscal_perfil();
        preencher_status();
        limpar_tabela_perfil();
        preencher_jtable_perfil();
    }//GEN-LAST:event_bt_cancelar_planilhaActionPerformed

    private void bt_salvar_planilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvar_planilhaActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_planilha.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
            return;
        }
        else if(cb_tipo_planilha.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_planilha.requestFocus();
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_planilha.getText().isEmpty()){
            try{
                //convertendo a primeira data
                String dataandamento = txt_data_planilha.getText();
                Date dataplanilha = sdf.parse(dataandamento);

                String andamentoplanilha;
                if(cb_tipo_planilha.getSelectedItem().equals("Finalizado")){
                    andamentoplanilha = "Finalizado";
                    try{
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal='Finalizado' where Numerodoprocesso='"+txt_codigo.getText()+"'";
                        con_planilha.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Fiscal> Perfil Fiscal");
                    }
                }
                else{
                    andamentoplanilha = "Em Aberto";
                }

                    String gry = "insert into validarprefilfiscal ("+
                    "NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"+
                    "Cliente, Usuario, AndamentoValidarPerfilFiscal, Tipo) values ('"+processo+"','"+
                    new java.sql.Date(dataplanilha.getTime())+"','"+
                    txt_obs_planilha.getText()+"','"+
                    txt_nome.getText()+"','"+
                    txt_usuario.getText()+"','"+
                    andamentoplanilha+"','"+
                    cb_tipo_planilha.getSelectedItem()+"')";

                    con_planilha.exeQuery(gry);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                    
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Termo: "+add);
            }
        }
        else{
            //nao permitir cadastrar um novo se já constar um codigo preenchido
            JOptionPane.showMessageDialog(null, "Clique em novo para inserir um novo registro!");
            return;
        }
        atualiza
        preencher_status();
        limpar_tabela_planilha();
        preencher_jtable_perfil();
    }//GEN-LAST:event_bt_salvar_planilhaActionPerformed

    private void bt_fechar_planilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fechar_planilhaActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fechar_planilhaActionPerformed

    private void bt_novo_planilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novo_planilhaActionPerformed
        limpar_tela_planilha();
    }//GEN-LAST:event_bt_novo_planilhaActionPerformed

    private void tb_planilhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_planilhaMouseClicked
        Integer linha = tb_perfil.getSelectedRow();
        String codigo = (String)tb_perfil.getValueAt(linha, 0);
        String data = (String)tb_perfil.getValueAt(linha, 2);
        String tipo = (String)tb_perfil.getValueAt(linha, 3);
        String observacao = (String)tb_perfil.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_perfil.setText(recebedataTabela);
        
        txt_cod_perfil.setText(codigo);
        cb_tipo_perfil.setSelectedItem(tipo);
        txt_obs_perfil.setText(observacao);
        
        
        
    }//GEN-LAST:event_tb_planilhaMouseClicked

    private void tb_boletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_boletoMouseClicked
Integer linha = tb_distribuir.getSelectedRow();
        String codigo = (String)tb_distribuir.getValueAt(linha, 0);
        String data = (String)tb_distribuir.getValueAt(linha, 2);
        String tipo = (String)tb_distribuir.getValueAt(linha, 3);
        String observacao = (String)tb_distribuir.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_distribuir.setText(recebedataTabela);
        
        txt_cod_distribuir.setText(codigo);
        cb_tipo_distribuir.setSelectedItem(tipo);
        txt_obs_distribuir.setText(observacao);
    }//GEN-LAST:event_tb_boletoMouseClicked

    private void bt_novo_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novo_controleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_novo_controleActionPerformed

    private void bt_salvar_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvar_controleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_salvar_controleActionPerformed

    private void bt_cancelar_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar_controleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelar_controleActionPerformed

    private void bt_excluir_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluir_controleActionPerformed
    
    }//GEN-LAST:event_bt_excluir_controleActionPerformed

    private void bt_fechar_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fechar_controleActionPerformed
    
    }//GEN-LAST:event_bt_fechar_controleActionPerformed

    private void tb_controleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_controleMouseClicked
     
    }//GEN-LAST:event_tb_controleMouseClicked

    private void cb_tipo_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipo_controleActionPerformed
 
    }//GEN-LAST:event_cb_tipo_controleActionPerformed

    private void bt_alterar_planilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_planilhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_alterar_planilhaActionPerformed

    private void bt_novo_boletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novo_boletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_novo_boletoActionPerformed

    private void bt_alterar_controleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_controleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_alterar_controleActionPerformed
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            Financeiro reg = new Financeiro();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterar_boleto;
    private javax.swing.JButton bt_alterar_controle;
    private javax.swing.JButton bt_alterar_planilha;
    private javax.swing.JButton bt_cancelar_boleto;
    private javax.swing.JButton bt_cancelar_controle;
    private javax.swing.JButton bt_cancelar_planilha;
    private javax.swing.JButton bt_excluir_boleto;
    private javax.swing.JButton bt_excluir_controle;
    private javax.swing.JButton bt_excluir_planilha;
    private javax.swing.JButton bt_fechar_boleto;
    private javax.swing.JButton bt_fechar_controle;
    private javax.swing.JButton bt_fechar_planilha;
    private javax.swing.JButton bt_novo_boleto;
    private javax.swing.JButton bt_novo_controle;
    private javax.swing.JButton bt_novo_planilha;
    private javax.swing.JButton bt_salvar_boleto;
    private javax.swing.JButton bt_salvar_controle;
    private javax.swing.JButton bt_salvar_planilha;
    private javax.swing.JComboBox cb_tipo_boleto;
    private javax.swing.JComboBox cb_tipo_controle;
    private javax.swing.JComboBox cb_tipo_planilha;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpBoleto;
    private javax.swing.JPanel jpControle;
    public javax.swing.JPanel jpFiscal;
    private javax.swing.JPanel jpPlanilha;
    private javax.swing.JPanel jpSitFinan;
    private javax.swing.JTabbedPane jtbGuiaFiscal;
    private javax.swing.JLabel lbControle;
    private javax.swing.JLabel lbTitFaseFinanceiro;
    private javax.swing.JLabel lbTitStatusFiscal;
    private javax.swing.JLabel lb_andamento_planilha;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_data_boleto;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_obs_boleto;
    private javax.swing.JLabel lb_obs_controle;
    private javax.swing.JLabel lb_obs_planilha;
    private javax.swing.JLabel lb_tipo_boleto;
    private javax.swing.JLabel lb_tipo_planilha;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lbboleto;
    private javax.swing.JLabel lbcod_boleto;
    private javax.swing.JLabel lbcod_controle;
    private javax.swing.JLabel lbcod_planilha;
    private javax.swing.JLabel lbdata_controle;
    private javax.swing.JLabel lbplanilha;
    private javax.swing.JLabel lbtipo_controle;
    private javax.swing.JTable tb_boleto;
    private javax.swing.JTable tb_controle;
    private javax.swing.JTable tb_planilha;
    public static javax.swing.JLabel txt_andamento_financeiro;
    private javax.swing.JTextField txt_cod_boleto;
    private javax.swing.JTextField txt_cod_controle;
    private javax.swing.JTextField txt_cod_planilha;
    public static javax.swing.JLabel txt_codigo;
    private javax.swing.JFormattedTextField txt_data_boleto;
    private javax.swing.JFormattedTextField txt_data_controle;
    private javax.swing.JFormattedTextField txt_data_planilha;
    public static javax.swing.JLabel txt_id;
    public static javax.swing.JLabel txt_nome;
    private javax.swing.JTextArea txt_obs_boleto;
    private javax.swing.JTextArea txt_obs_controle;
    private javax.swing.JTextArea txt_obs_planilha;
    public static javax.swing.JLabel txt_status_boleto;
    public static javax.swing.JLabel txt_status_controle;
    public static javax.swing.JLabel txt_status_planilha;
    public static javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables
    public void preencher_tabela_planilha(){
        tb_planilha.getColumnModel().getColumn(0);
        tb_planilha.getColumnModel().getColumn(1);
        tb_planilha.getColumnModel().getColumn(2);
        tb_planilha.getColumnModel().getColumn(3);
        tb_planilha.getColumnModel().getColumn(4);
        tb_planilha.getColumnModel().getColumn(5);
        con_planilha.executeSQL("select * from lancamentodedadosnaplancobranca where NumeroProcesso='"+processo+"' order by CodValidarPerfilFiscal");

        DefaultTableModel modelo = (DefaultTableModel)tb_planilha.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con_planilha.resultset.next())
                modelo.addRow(new Object [] {
                    con_planilha.resultset.getString("CodLancamentoDeDadosNaPlanConbranca"),
                    con_planilha.resultset.getString("NumeroProcesso"),
                    sdf.format(con_planilha.resultset.getTime("DatadeCadastroAndamento")),
                    con_planilha.resultset.getString("Tipo"),                    
                    con_planilha.resultset.getString("Obsevacao"),
                    con_planilha.resultset.getString("Usuario")});
            con_planilha.resultset.first();
        }   catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na Tabela Planilha " +erro);
    }
}
    public void preencher_tabela_boleto(){
        tb_boleto.getColumnModel().getColumn(0);
        tb_boleto.getColumnModel().getColumn(1);
        tb_boleto.getColumnModel().getColumn(2);
        tb_boleto.getColumnModel().getColumn(3);
        tb_boleto.getColumnModel().getColumn(4);
        tb_boleto.getColumnModel().getColumn(5);
        con_boleto.executeSQL("select * from emissaoboleto WHERE NumeroProcesso='"+processo+"' order by CodDistribuirFuncionarioInterno");
        //
        DefaultTableModel modelo = (DefaultTableModel)tb_boleto.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con_boleto.resultset.next())
                modelo.addRow(new Object [] {
                    con_boleto.resultset.getString("CodEmissaoBoleto"),
                    con_boleto.resultset.getString("NumeroProcesso"),
                    sdf.format(con_boleto.resultset.getTime("DatadeCadastroAndamento")),
                    con_boleto.resultset.getString("Tipo"),
                    con_boleto.resultset.getString("Obsevacao"),
                    con_boleto.resultset.getString("Usuario")});
            con_boleto.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na Tabela Boleto "+erro);
        }
    }
    public void preencher_tabela_controle(){
        tb_controle.getColumnModel().getColumn(0);
        tb_controle.getColumnModel().getColumn(1);
        tb_controle.getColumnModel().getColumn(2);
        tb_controle.getColumnModel().getColumn(3);
        tb_controle.getColumnModel().getColumn(4);
        tb_controle.getColumnModel().getColumn(5);
        con_controle.executeSQL("select * from entrarnocontrolcontroleos where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tb_controle.getModel();
        
        try{
            while(con_controle.resultset.next())
                modelo.addRow(new Object [] {
                    con_controle.resultset.getString("CoEntrarNoControlControleOS"),
                    con_controle.resultset.getString("NumeroProcesso"),
                    sdf.format(con_controle.resultset.getString("DatadeCadastroAndamento")),
                    con_controle.resultset.getString("Tipo"),
                    con_controle.resultset.getString("Obsevacao"),
                    con_controle.resultset.getString("Usuario")});
            con_controle.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na Tabela Controle " +erro);
        }
    }
    public void limpar_tabela_planilha(){
        DefaultTableModel tbm = (DefaultTableModel)tb_planilha.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void limpar_tabela_boleto(){
        DefaultTableModel tbm = (DefaultTableModel)tb_boleto.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void limpar_tabela_controle(){
        DefaultTableModel tbm = (DefaultTableModel)tb_controle.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void preencher_status(){
        try{
            String sql = "select * from financeiro WHERE Numerodoprocesso='"+processo+"'";
            con_financeiro.executeSQL(sql);
            con_financeiro.resultset.first();
            
            planilha = con_financeiro.resultset.getString("AndamentoLancamentodeDadosPlanCobranca");
            boleto = con_financeiro.resultset.getString("AndamentoEmissaoBoleto");
            controle = con_financeiro.resultset.getString("AndamentoEntrarNoControlControleDoOs");
            
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao buscar tabela Financeiro!" +erro);
        }
    }
    public void atualizar_cadastrocliente(){
        
        if(txt_status_planilha.getText().equalsIgnoreCase("Em Aberto") &&
                txt_status_boleto.getText().equalsIgnoreCase("Em Aberto")&&
                txt_status_controle.getText().equalsIgnoreCase("Em Aberto")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='' where codNumerodoprocesso=" +processo;
                    con_financeiro.statement.executeUpdate(sql);

                    String andamento = "Não Iniciado";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(txt_status_planilha.getText().equalsIgnoreCase("Em Aberto") &&
                txt_status_boleto.getText().equalsIgnoreCase("Em Aberto")&&
                txt_status_controle.getText().equalsIgnoreCase("Finalizado")){
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFiscal='Lançamento na Planilha' where codNumerodoprocesso=" +processo;
                    con_financeiro.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(txt_status_planilha.getText().equalsIgnoreCase("Em Aberto") &&
                txt_status_boleto.getText().equalsIgnoreCase("Finalizado")&&
                txt_status_controle.getText().equalsIgnoreCase("Em Aberto")||
                //fazendo a verificação, sempre vai consultar a label anterior
                txt_status_planilha.getText().equalsIgnoreCase("Em Aberto") &&
                txt_status_boleto.getText().equalsIgnoreCase("Finalizado")&&
                txt_status_controle.getText().equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Lançamento na Planilha' where codNumerodoprocesso="+processo;
                    con_financeiro.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(txt_status_planilha.getText().equalsIgnoreCase("Finalizado") &&
                txt_status_boleto.getText().equalsIgnoreCase("Em Aberto")&&
                txt_status_controle.getText().equalsIgnoreCase("Em Aberto") ||
                //verificando status anterior pendente
                txt_status_planilha.getText().equalsIgnoreCase("Finalizado") &&
                txt_status_boleto.getText().equalsIgnoreCase("Em Aberto")&&
                txt_status_controle.getText().equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Emitir Boleto' where codNumerodoprocesso="+processo;
                    con_financeiro.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(txt_status_planilha.getText().equalsIgnoreCase("Finalizado") &&
                txt_status_boleto.getText().equalsIgnoreCase("Finalizado")&&
                txt_status_controle.getText().equalsIgnoreCase("Em Aberto")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Lançar Controle de OS' where codNumerodoprocesso="+processo;
                    con_financeiro.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(txt_status_planilha.getText().equalsIgnoreCase("Finalizado") &&
                txt_status_boleto.getText().equalsIgnoreCase("Finalizado")&&
                txt_status_controle.getText().equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Concluido' where codNumerodoprocesso="+processo;
                    con_financeiro.statement.executeUpdate(sql);

                    String andamento = "Concluido";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        distribuir_cores();
    }
    public void distribuir_cores(){
        if(txt_status_planilha.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_planilha.setBackground(Color.red);
        }
        else{
            txt_status_planilha.setBackground(Color.green);
        }
        if(txt_status_boleto.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_boleto.setBackground(Color.red);
        }
        else{
            txt_status_boleto.setBackground(Color.green);
        }
        if(txt_status_controle.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_controle.setBackground(Color.red);
        }
        else{
            txt_status_controle.setBackground(Color.green);    
            }
        if(txt_andamento_financeiro.getText().equalsIgnoreCase("Concluido")){
            txt_andamento_financeiro.setBackground(Color.green);
        }
        else if(txt_andamento_financeiro.getText().equalsIgnoreCase("Em Andamento")){
            txt_andamento_financeiro.setBackground(Color.orange);
        }
        else{
            txt_andamento_financeiro.setBackground(Color.red);
        }
    }
    public void limpar_tela_planilha(){
        txt_cod_planilha.setText("");
        txt_obs_planilha.setText("");
        txt_cod_planilha.setEditable(false);
        cb_tipo_planilha.setSelectedItem("Novo Andamento");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_planilha.setText(datahoje);
        
    }
    public void limpar_tela_boleto(){
        txt_cod_boleto.setEditable(false);
        txt_cod_boleto.setText("");
        cb_tipo_boleto.setSelectedItem("Novo Andamento");
        txt_obs_boleto.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_boleto.setText(datahoje);
    }
    public void limpar_tela_controle(){
        txt_cod_controle.setEditable(false);
        txt_cod_controle.setText("");
        cb_tipo_controle.setSelectedItem("Novo Andamento");
        txt_obs_controle.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_controle.setText(datahoje);
    }

    public void atualiza_financeiro_planilha(){
        if(cb_tipo_distribuir.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE fiscal set AndamenoDistribuirFuncionarioInterno ='Finalizado' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Distribuir a responsavel\n" +erro);
                    }
        }
        else{
            try{
                con_fiscal.executeSQL("select * from fiscal where Numerodoprocesso='" +txt_codigo.getText()+"' and AndamenoDistribuirFuncionarioInterno ='Finalizado'");
                if(con_fiscal.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados no painel Distribuição a Responsavel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_perfil.executeSQL("select * from DistribuirFuncionarioInterno where NumeroProcesso='"+txt_codigo.getText()+"'and AndamentoDistribuirFuncionarioInterno='Finalizado'");
                    
                    if(!con_perfil.resultset.last()){
                        try{
                
                        String sql = "UPDATE fiscal set AndamenoDistribuirFuncionarioInterno ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Distribuição\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE fiscal set AndamenoDistribuirFuncionarioInterno ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Distribuir a responsavel\n" +erro);
                    }
                }
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na Tabela Fiscal>Distribuição: \n" +erro);
            }
                    
        }
    }
    public void atualiza_financeiro_boleto(){
        if(cb_tipo_perfil.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Finalizado' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                    }
                }
        else{
            try{    
                    con_fiscal.executeSQL("select * from fiscal where Numerodoprocesso='" +txt_codigo.getText()+"' and AndamentoValidarPerfilFiscal ='Finalizado'");
                if(con_fiscal.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados no painel Perfil Fiscal\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_perfil.executeSQL("select * from validarprefilfiscal where NumeroProcesso='"+txt_codigo.getText()+"'and AndamentoValidarPerfilFiscal='Finalizado'");
                    
                    if(!con_perfil.resultset.last()){
                        try{
                
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                    }
                         
                }
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na Tabela Fiscal>Perfil Fiscal: \n" +erro);
            }
        }
    }
    public void atualiza_financeiro_controle(){
        if(cb_tipo_perfil.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Finalizado' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                    }
                }
        else{
            try{    
                    con_fiscal.executeSQL("select * from fiscal where Numerodoprocesso='" +txt_codigo.getText()+"' and AndamentoValidarPerfilFiscal ='Finalizado'");
                if(con_fiscal.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados no painel Perfil Fiscal\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_perfil.executeSQL("select * from validarprefilfiscal where NumeroProcesso='"+txt_codigo.getText()+"'and AndamentoValidarPerfilFiscal='Finalizado'");
                    
                    if(!con_perfil.resultset.last()){
                        try{
                
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                    }
                         
                }
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na Tabela Fiscal>Perfil Fiscal: \n" +erro);
            }
        }
    }
}