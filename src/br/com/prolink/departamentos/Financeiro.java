package br.com.prolink.departamentos;

import br.com.prolink.factory.Conexao;
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

import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import br.com.prolink.model.UsuarioLogado;
/**
 *
 * @author Tiago Dias
 */

public class Financeiro extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con = new Conexao();
    Conexao con_geral = new Conexao();
    
//maskara para o JFormattedTextField
    MaskFormatter formatoPlanilha, formatoControle, formatoBoleto;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String planilha, boleto, controle, codPlan_backup, dataPlan_backup, obsPlan_backup, tipoPlan_backup,
            codBol_backup, dataBol_backup, obsBol_backup, tipoBol_backup,
            codCon_backup, dataCon_backup, obsCon_backup, tipoCon_backup;
    
     Processo p = ProcessoLogado.getInstance().getProcesso();
    String processo=p.getId()+"",
            nome=p.getCliente(), 
            id=p.getApelido(), 
            usuario=UsuarioLogado.getInstance().getUsuario().getUsuario();
    
    public Financeiro() {
        initComponents();
        
        con.conecta();
        con_geral.conecta();
        
        //chamando metodo que preencha as tabelas
        preencher_tabela_planilha();
        preencher_tabela_boleto();
        preencher_tabela_controle();
        //chamando metodo que preencha tela de status
        preencher_status();
        atualizar_cadastro_cliente();
        
        bloquear_tela_planilha();
        bloquear_tela_boleto();
        bloquear_tela_controle();
        
        limpar_tela_planilha();
        limpar_tela_boleto();
        limpar_tela_controle();
        
        tb_planilha.setAutoCreateRowSorter(true);
        tb_boleto.setAutoCreateRowSorter(true);
        tb_controle.setAutoCreateRowSorter(true);
        
        txt_codigo.setText(processo);
        txt_nome.setText(nome);
        txt_id.setText(id);
        txt_usuario.setText(usuario);
        
        if(UsuarioLogado.getInstance().getUsuario().getNivel()!=1 && !UsuarioLogado.getInstance().getUsuario().getDepartamento().equalsIgnoreCase("Financeiro")){
            
            btnExcluirPlanilha.setEnabled(false);
            btnSalvarPlanilha.setEnabled(false);
            
            btnExcluirBoleto.setEnabled(false);
            btnSalvarBoleto.setEnabled(false);
            
            btnExcluirControle.setEnabled(false);
            btnSalvarControle.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "Você não tem permissão para editar os registros dessa tela!");
        }
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
        btnNovoPlanilha = new javax.swing.JButton();
        btnSalvarPlanilha = new javax.swing.JButton();
        btnCancelarPlanilha = new javax.swing.JButton();
        btnExcluirPlanilha = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_planilha = new javax.swing.JTable();
        btnAlterarPlanilha = new javax.swing.JButton();
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
        btnAlterarBoleto = new javax.swing.JButton();
        btnSalvarBoleto = new javax.swing.JButton();
        btnCancelarBoleto = new javax.swing.JButton();
        btnExcluirBoleto = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_boleto = new javax.swing.JTable();
        btnNovoBoleto = new javax.swing.JButton();
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
        btnNovoControle = new javax.swing.JButton();
        btnSalvarControle = new javax.swing.JButton();
        btnCancelarControle = new javax.swing.JButton();
        btnExcluirControle = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tb_controle = new javax.swing.JTable();
        btnAlterarControle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financeiro");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        cb_tipo_planilha.setToolTipText("Se desejar finalizar o andamento, selecione finalizar!");

        txt_obs_planilha.setColumns(20);
        txt_obs_planilha.setLineWrap(true);
        txt_obs_planilha.setRows(5);
        jScrollPane9.setViewportView(txt_obs_planilha);

        btnNovoPlanilha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoPlanilha.setText("Novo");
        btnNovoPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPlanilhaActionPerformed(evt);
            }
        });

        btnSalvarPlanilha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarPlanilha.setText("Salvar");
        btnSalvarPlanilha.setFocusable(false);
        btnSalvarPlanilha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvarPlanilha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvarPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPlanilhaActionPerformed(evt);
            }
        });

        btnCancelarPlanilha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarPlanilha.setText("Cancelar");
        btnCancelarPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPlanilhaActionPerformed(evt);
            }
        });

        btnExcluirPlanilha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirPlanilha.setText("Excluir");
        btnExcluirPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPlanilhaActionPerformed(evt);
            }
        });

        tb_planilha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Data", "Processo", "Observação", "Situação", "Usuario"
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
        if (tb_planilha.getColumnModel().getColumnCount() > 0) {
            tb_planilha.getColumnModel().getColumn(0).setMaxWidth(30);
            tb_planilha.getColumnModel().getColumn(1).setMaxWidth(70);
            tb_planilha.getColumnModel().getColumn(2).setMaxWidth(90);
            tb_planilha.getColumnModel().getColumn(4).setMaxWidth(150);
            tb_planilha.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        btnAlterarPlanilha.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarPlanilha.setText("Alterar");
        btnAlterarPlanilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarPlanilhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPlanilhaLayout = new javax.swing.GroupLayout(jpPlanilha);
        jpPlanilha.setLayout(jpPlanilhaLayout);
        jpPlanilhaLayout.setHorizontalGroup(
            jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addComponent(lbcod_planilha)
                        .addGap(115, 115, 115)
                        .addComponent(txt_cod_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addComponent(lb_andamento_planilha)
                        .addGap(111, 111, 111)
                        .addComponent(txt_data_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lb_tipo_planilha)
                        .addGap(18, 18, 18)
                        .addComponent(cb_tipo_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addComponent(lb_obs_planilha)
                        .addGap(73, 73, 73)
                        .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpPlanilhaLayout.createSequentialGroup()
                                .addComponent(btnNovoPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9)))))
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
                    .addComponent(cb_tipo_planilha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_planilha)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPlanilhaLayout.createSequentialGroup()
                        .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpPlanilhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluirPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAlterarPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        cb_tipo_boleto.setToolTipText("Se desejar finalizar o andamento, selecione finalizar!");

        lb_obs_boleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_boleto.setText("Observação:");

        txt_obs_boleto.setColumns(20);
        txt_obs_boleto.setLineWrap(true);
        txt_obs_boleto.setRows(5);
        jScrollPane7.setViewportView(txt_obs_boleto);

        btnAlterarBoleto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarBoleto.setText("Alterar");
        btnAlterarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarBoletoActionPerformed(evt);
            }
        });

        btnSalvarBoleto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarBoleto.setText("Salvar");
        btnSalvarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarBoletoActionPerformed(evt);
            }
        });

        btnCancelarBoleto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarBoleto.setText("Cancelar");
        btnCancelarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarBoletoActionPerformed(evt);
            }
        });

        btnExcluirBoleto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirBoleto.setText("Excluir");
        btnExcluirBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirBoletoActionPerformed(evt);
            }
        });

        tb_boleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Data", "Processo", "Observação", "Situação", "Usuario"
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
        if (tb_boleto.getColumnModel().getColumnCount() > 0) {
            tb_boleto.getColumnModel().getColumn(0).setMaxWidth(30);
            tb_boleto.getColumnModel().getColumn(1).setMaxWidth(70);
            tb_boleto.getColumnModel().getColumn(2).setMaxWidth(90);
            tb_boleto.getColumnModel().getColumn(4).setMaxWidth(150);
            tb_boleto.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        btnNovoBoleto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoBoleto.setText("Novo");
        btnNovoBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoBoletoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBoletoLayout = new javax.swing.GroupLayout(jpBoleto);
        jpBoleto.setLayout(jpBoletoLayout);
        jpBoletoLayout.setHorizontalGroup(
            jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpBoletoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addComponent(lbcod_boleto)
                        .addGap(115, 115, 115)
                        .addComponent(txt_cod_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addComponent(lb_data_boleto)
                        .addGap(111, 111, 111)
                        .addComponent(txt_data_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lb_tipo_boleto)
                        .addGap(18, 18, 18)
                        .addComponent(cb_tipo_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addComponent(lb_obs_boleto)
                        .addGap(73, 73, 73)
                        .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpBoletoLayout.createSequentialGroup()
                                .addComponent(btnNovoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7)))))
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
                    .addComponent(cb_tipo_boleto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_boleto)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBoletoLayout.createSequentialGroup()
                        .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluirBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAlterarBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        cb_tipo_controle.setToolTipText("Se desejar finalizar o andamento, selecione finalizar!");

        lb_obs_controle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_controle.setText("Observação:");

        txt_obs_controle.setColumns(20);
        txt_obs_controle.setLineWrap(true);
        txt_obs_controle.setRows(5);
        jScrollPane10.setViewportView(txt_obs_controle);

        btnNovoControle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoControle.setText("Novo");
        btnNovoControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoControleActionPerformed(evt);
            }
        });

        btnSalvarControle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarControle.setText("Salvar");
        btnSalvarControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarControleActionPerformed(evt);
            }
        });

        btnCancelarControle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarControle.setText("Cancelar");
        btnCancelarControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarControleActionPerformed(evt);
            }
        });

        btnExcluirControle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirControle.setText("Excluir");
        btnExcluirControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirControleActionPerformed(evt);
            }
        });

        tb_controle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Data", "Processo", "Observação", "Situação", "Usuario"
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
        if (tb_controle.getColumnModel().getColumnCount() > 0) {
            tb_controle.getColumnModel().getColumn(0).setMaxWidth(30);
            tb_controle.getColumnModel().getColumn(1).setMaxWidth(70);
            tb_controle.getColumnModel().getColumn(2).setMaxWidth(90);
            tb_controle.getColumnModel().getColumn(4).setMaxWidth(150);
            tb_controle.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        btnAlterarControle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarControle.setText("Alterar");
        btnAlterarControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarControleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpControleLayout = new javax.swing.GroupLayout(jpControle);
        jpControle.setLayout(jpControleLayout);
        jpControleLayout.setHorizontalGroup(
            jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpControleLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addComponent(lbcod_controle)
                        .addGap(115, 115, 115)
                        .addComponent(txt_cod_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addComponent(lbdata_controle)
                        .addGap(111, 111, 111)
                        .addComponent(txt_data_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbtipo_controle)
                        .addGap(18, 18, 18)
                        .addComponent(cb_tipo_controle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addComponent(lb_obs_controle)
                        .addGap(73, 73, 73)
                        .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpControleLayout.createSequentialGroup()
                                .addComponent(btnNovoControle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirControle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10)))))
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
                    .addComponent(cb_tipo_controle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_controle)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpControleLayout.createSequentialGroup()
                        .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoControle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancelarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluirControle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAlterarControle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void btnExcluirBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirBoletoActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_boleto.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from emissaoboleto where CodEmissaoBoleto= "+txt_cod_boleto.getText();
                con.executeSQL(sql);
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir um registro do cliente : " +nome+"?";
                    String operacao = con.resultset.getString("AndamentoEmissaoBoleto");
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        sql = "DELETE FROM emissaoboleto Where CodEmissaoBoleto="+txt_cod_boleto.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1){
                            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                            limpar_tabela_boleto();
                            preencher_tabela_boleto();
                            limpar_tela_boleto();
                            
                            if("Finalizado".equals(operacao)){
                                try{
                                    con.executeSQL("select * from emissaoboleto where NumeroProcesso='"+processo+"' and AndamentoEmissaoBoleto='Finalizado'");
                                    //se não existir mais um em situação finalizada ele ira atualizar o status

                                    if(!con.resultset.first()){
                                        try{
                                        con.statement.executeUpdate("UPDATE financeiro set AndamentoEmissaoBoleto ='Em Aberto' where Numerodoprocesso='" +processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                        }catch(SQLException erro){
                                            JOptionPane.showMessageDialog(null, " Falha ao atualizar a tabela Plano de Contas:\n" +erro);
                                        }
                                    }
                                }catch(SQLException erro){
                                    JOptionPane.showMessageDialog(null, "Erro ao buscar registro!\n"+erro);
                                }
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirBoletoActionPerformed

    private void btnCancelarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarBoletoActionPerformed
       restaurar_backup_boleto();
       bloquear_tela_boleto();
    }//GEN-LAST:event_btnCancelarBoletoActionPerformed

    private void btnSalvarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarBoletoActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_boleto.getText().equals("  /  /    ") || txt_data_boleto.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cb_tipo_boleto.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_boleto.getText().equals("")){
            
            try{
                String dataandamento = txt_data_boleto.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamentoboleto;
                if(cb_tipo_boleto.getSelectedItem().equals("Finalizado")){
                    andamentoboleto = "Finalizado";
                }
                else{
                    andamentoboleto = "Em Aberto";
                    }
                String gry = "insert into emissaoboleto ("+
                "NumeroProcesso, DatadeCadastroAndamento, Obsevacao, "+
                "Usuario, AndamentoEmissaoBoleto) values ('" +processo+"','"+
                new java.sql.Date(data.getTime())+"','"+
                txt_obs_boleto.getText()+"','"+
                usuario+"','"+
                andamentoboleto+"')";

                con.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                
                
                atualizar_financeiro_boleto();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_boleto();
                preencher_tabela_boleto();
                
            }catch(ParseException | HeadlessException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Boleto: "+erro);
            }
            
        }
        else if(!txt_cod_boleto.getText().equals("")){
            
            try{
               
                String dataandamento = txt_data_boleto.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamento;
                if(cb_tipo_boleto.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }else{
                    andamento = "Em Aberto";
                }
                String sql = "UPDATE emissaoboleto set DatadeCadastroAndamento='"+
                new java.sql.Date(data.getTime())+"',"+
                "Obsevacao='"+txt_obs_boleto.getText()+"',"+
                "Usuario= '"+usuario+"',"+
                "AndamentoEmissaoBoleto='"+andamento+"' "+
                "where CodEmissaoBoleto= "+txt_cod_boleto.getText();

                con.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_financeiro_boleto();
                preencher_status();
                limpar_tabela_boleto();
                preencher_tabela_boleto();
                atualizar_cadastro_cliente();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Boleto: \n " +erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
            
        }
    }//GEN-LAST:event_btnSalvarBoletoActionPerformed

    private void btnAlterarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarBoletoActionPerformed
        desbloquear_tela_boleto();
    }//GEN-LAST:event_btnAlterarBoletoActionPerformed

    private void btnExcluirPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPlanilhaActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_planilha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            
            try{
                String sql = "select * from lancamentodedadosnaplancobranca  "
                        + "where CodLancamentoDeDadosNaPlanConbranca= "+txt_cod_planilha.getText();
                con.executeSQL(sql);
                con.resultset.first();
                String cliente = "Tem certeza que deseja excluir um registro do cliente : " +nome+"?";
                String operacao = con.resultset.getString("AndamentoLancamentoDeDadosPlanCobranca");
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM lancamentodedadosnaplancobranca Where CodLancamentoDeDadosNaPlanConbranca="+txt_cod_planilha.getText();
                    int conseguiu_excluir = con.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        
                        limpar_tela_planilha();
                        limpar_tabela_planilha();
                        preencher_tabela_planilha();
                        //verificar se não existe outro registro com o status finalizado nesse cliente
                        if("Finalizado".equals(operacao)){
                            con.executeSQL("select * from lancamentodedadosnaplancobranca where NumeroProcesso='"+processo+"' and AndamentoLancamentoDeDadosPlanCobranca='Finalizado'");
                            if(!con.resultset.first()){
                                try{
                                    con.statement.executeUpdate("update financeiro set AndamentoLancamentodeDadosPlanCobranca='Em Aberto' where"
                                    +"Numerodoprocesso='"+processo+"'");
                                                                        
                                    preencher_status();
                                    atualizar_cadastro_cliente();
                                    
                                }catch(SQLException erro){
                                    JOptionPane.showMessageDialog(null,"Falha ao atualizar a tabela Financeiro\n" +erro);
                                }
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirPlanilhaActionPerformed

    private void btnCancelarPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPlanilhaActionPerformed
        restaurar_backup_planilha();
        bloquear_tela_planilha();
    }//GEN-LAST:event_btnCancelarPlanilhaActionPerformed

    private void btnSalvarPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPlanilhaActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_planilha.getText().equals("  /  /    ") || txt_data_planilha.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cb_tipo_planilha.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_planilha.getText().equals("")){
            
            try{
                //convertendo a primeira data
                String dataandamento = txt_data_planilha.getText();
                Date dataplanilha = sdf.parse(dataandamento);

                String andamentoplanilha;
                
                if(cb_tipo_planilha.getSelectedItem().equals("Finalizado")){
                    andamentoplanilha = "Finalizado";
                }
                else{
                    andamentoplanilha = "Em Aberto";
                }

                    String gry = "insert into lancamentodedadosnaplancobranca  ("
                    +"NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"
                    +"Usuario, AndamentoLancamentoDeDadosPlanCobranca) "
                    +"values ('"+processo+"','"
                    +new java.sql.Date(dataplanilha.getTime())+"','"
                    +txt_obs_planilha.getText()+"','"
                    +usuario+"','"
                    +andamentoplanilha+"')";

                    con.exeQuery(gry);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                    
                    atualizar_financeiro_planilha();
                    preencher_status();
                    atualizar_cadastro_cliente();
                    limpar_tabela_planilha();
                    preencher_tabela_planilha();
                    
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Planilha de Cobrança: "+add);
            }
            
        }
        else if(!txt_cod_planilha.getText().equals("")){
            
            try{
               
                String dataandamento = txt_data_planilha.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamentoplanilha;
                
                if(cb_tipo_planilha.getSelectedItem().equals("Finalizado")){
                    andamentoplanilha = "Finalizado";
                }
                else{
                    andamentoplanilha = "Em Aberto";
                }
                String sql = "UPDATE lancamentodedadosnaplancobranca set DatadeCadastroAndamento='"+
                new java.sql.Date(datatermo.getTime())+"',"+
                "Obsevacao='"+txt_obs_planilha.getText()+"',"+
                "Usuario = '"+usuario+"',"+
                "AndamentoLancamentoDeDadosPlanCobranca='"+andamentoplanilha+"' "+
                "where CodLancamentoDeDadosNaPlanConbranca = "+txt_cod_planilha.getText();

                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_financeiro_planilha();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_planilha();
                preencher_tabela_planilha();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Termo: " +erro);
            }catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
            
        }
    }//GEN-LAST:event_btnSalvarPlanilhaActionPerformed

    private void btnNovoPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPlanilhaActionPerformed
        criar_backup_planilha();
        limpar_tela_planilha();
        desbloquear_tela_planilha();
    }//GEN-LAST:event_btnNovoPlanilhaActionPerformed

    private void tb_planilhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_planilhaMouseClicked
        Integer linha = tb_planilha.getSelectedRow();
        String codigo = (String)tb_planilha.getValueAt(linha, 0);
        String data = (String)tb_planilha.getValueAt(linha, 1);
        String observacao = (String)tb_planilha.getValueAt(linha, 3);
        String tipo = (String)tb_planilha.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_planilha.setText(recebedataTabela);
        
        txt_cod_planilha.setText(codigo);
        txt_obs_planilha.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cb_tipo_planilha.setSelectedItem("Finalizado");
        }
        else
            cb_tipo_planilha.setSelectedItem("Novo Andamento");
        
    }//GEN-LAST:event_tb_planilhaMouseClicked

    private void tb_boletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_boletoMouseClicked
        Integer linha = tb_boleto.getSelectedRow();
        String codigo = (String)tb_boleto.getValueAt(linha, 0);
        String data = (String)tb_boleto.getValueAt(linha, 1);
        String observacao = (String)tb_boleto.getValueAt(linha, 3);
        String tipo = (String)tb_boleto.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_boleto.setText(recebedataTabela);
        
        txt_cod_boleto.setText(codigo);
        txt_obs_boleto.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cb_tipo_boleto.setSelectedItem("Finalizado");
        }
        else
            cb_tipo_boleto.setSelectedItem("Novo Andamento");
        
    }//GEN-LAST:event_tb_boletoMouseClicked

    private void btnNovoControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoControleActionPerformed
        criar_backup_controle();
        limpar_tela_controle();
        desbloquear_tela_controle();
    }//GEN-LAST:event_btnNovoControleActionPerformed

    private void btnSalvarControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarControleActionPerformed
        if(txt_data_controle.getText().equals("  /  /    ") || txt_data_controle.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Data informada é invalida!");
        }
        else if(txt_cod_controle.getText().equals("")){
            
            try{
                String novadata = txt_data_controle.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cb_tipo_controle.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into entrarnocontrolcontroleos (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoEntrarNControlControleOS)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txt_obs_controle.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_financeiro_controle();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_controle();
                preencher_tabela_controle();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
            
        }
        else if(!txt_cod_controle.getText().equals("")){
            
            try{
                String novadata = txt_data_controle.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cb_tipo_controle.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update entrarnocontrolcontroleos set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"', "
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txt_obs_controle.getText()+"', "
                        +"AndamentoEntrarNControlControleOS='"+andamento+"' "
                        +"where CodEntrarNoControlControleOS="+txt_cod_controle.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_financeiro_controle();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_controle();
                preencher_tabela_controle();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
            
        }
        
        
    }//GEN-LAST:event_btnSalvarControleActionPerformed

    private void btnCancelarControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarControleActionPerformed
        restaurar_backup_controle();
        bloquear_tela_controle();
    }//GEN-LAST:event_btnCancelarControleActionPerformed

    private void btnExcluirControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirControleActionPerformed
        if(txt_cod_controle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            
            try{
                con.executeSQL(("select * from entrarnocontrolcontroleos where CodEntrarNoControlControleOS="+txt_cod_controle.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +con.resultset.getString("Cliente")+"?";
                    String andamento = con.resultset.getString("AndamentoEntrarNControlControleOS");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from entrarnocontrolcontroleos where CodEntrarNoControlControleOS="+txt_cod_controle.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_controle();
                            preencher_tabela_controle();
                            limpar_tela_controle();
                            
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from entrarnocontrolcontroleos where NumeroProcesso="+processo+" and AndamentoEntrarNControlControleOS='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con.statement.executeUpdate("update financeiro set AndamentoEntrarNoControlControleDoOs='Em Aberto'"
                                                + "where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Financeiro!\n"+erro);
                                    }
                                }
                            }
                            
                        }
                    }
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Controle!\n"+erro);
            }
        
        }
    }//GEN-LAST:event_btnExcluirControleActionPerformed

    private void tb_controleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_controleMouseClicked
        Integer linha = tb_controle.getSelectedRow();
        String codigo = (String)tb_controle.getValueAt(linha, 0);
        String data = (String)tb_controle.getValueAt(linha, 1);
        String observacao = (String)tb_controle.getValueAt(linha, 3);
        String tipo = (String)tb_controle.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_controle.setText(recebedataTabela);
        
        txt_cod_controle.setText(codigo);
        txt_obs_controle.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cb_tipo_controle.setSelectedItem("Finalizado");
        }
        else
            cb_tipo_controle.setSelectedItem("Novo Andamento");
        
    }//GEN-LAST:event_tb_controleMouseClicked

    private void btnAlterarPlanilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarPlanilhaActionPerformed
        criar_backup_planilha();
        desbloquear_tela_planilha();
    }//GEN-LAST:event_btnAlterarPlanilhaActionPerformed

    private void btnNovoBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoBoletoActionPerformed
        criar_backup_boleto();
        limpar_tela_boleto();
        desbloquear_tela_boleto();
    }//GEN-LAST:event_btnNovoBoletoActionPerformed

    private void btnAlterarControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarControleActionPerformed
        criar_backup_controle();
        desbloquear_tela_controle();
    }//GEN-LAST:event_btnAlterarControleActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.desconecta();
        con_geral.desconecta();
    }//GEN-LAST:event_formWindowClosing
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            Financeiro reg = new Financeiro();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarBoleto;
    private javax.swing.JButton btnAlterarControle;
    private javax.swing.JButton btnAlterarPlanilha;
    private javax.swing.JButton btnCancelarBoleto;
    private javax.swing.JButton btnCancelarControle;
    private javax.swing.JButton btnCancelarPlanilha;
    private javax.swing.JButton btnExcluirBoleto;
    private javax.swing.JButton btnExcluirControle;
    private javax.swing.JButton btnExcluirPlanilha;
    private javax.swing.JButton btnNovoBoleto;
    private javax.swing.JButton btnNovoControle;
    private javax.swing.JButton btnNovoPlanilha;
    private javax.swing.JButton btnSalvarBoleto;
    private javax.swing.JButton btnSalvarControle;
    private javax.swing.JButton btnSalvarPlanilha;
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
        con.executeSQL("select * from lancamentodedadosnaplancobranca where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tb_planilha.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("CodLancamentoDeDadosNaPlanConbranca"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoLancamentoDeDadosPlanCobranca"),
                    con.resultset.getString("Usuario")});
            con.resultset.first();
        }   catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Planilha " +erro);
    }
}
    public void preencher_tabela_boleto(){
        tb_boleto.getColumnModel().getColumn(0);
        tb_boleto.getColumnModel().getColumn(1);
        tb_boleto.getColumnModel().getColumn(2);
        tb_boleto.getColumnModel().getColumn(3);
        tb_boleto.getColumnModel().getColumn(4);
        tb_boleto.getColumnModel().getColumn(5);
        con.executeSQL("select * from emissaoboleto WHERE NumeroProcesso='"+processo+"'");
        //
        DefaultTableModel modelo = (DefaultTableModel)tb_boleto.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("CodEmissaoBoleto"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoEmissaoBoleto"),
                    con.resultset.getString("Usuario")});
            con.resultset.first();
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
        con.executeSQL("select * from entrarnocontrolcontroleos where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tb_controle.getModel();
        
        try{
            while(con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("CodEntrarNoControlControleOS"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoEntrarNControlControleOS"),
                    con.resultset.getString("Usuario")});
            con.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Controle " +erro);
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
            con_geral.executeSQL(sql);
            con_geral.resultset.first();
            
            planilha = con_geral.resultset.getString("AndamentoLancamentodeDadosPlanCobranca");
            boleto = con_geral.resultset.getString("AndamentoEmissaoBoleto");
            controle = con_geral.resultset.getString("AndamentoEntrarNoControlControleDoOs");
            
            txt_status_planilha.setText(planilha);
            txt_status_boleto.setText(boleto);
            txt_status_controle.setText(controle);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao buscar tabela Financeiro!" +erro);
        }
    }
    public void atualizar_cadastro_cliente(){
        
        if(planilha.equalsIgnoreCase("Em Aberto") &&
                boleto.equalsIgnoreCase("Em Aberto") &&
                controle.equalsIgnoreCase("Em Aberto")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Em Aberto' where codNumerodoprocesso=" +processo;
                    con_geral.statement.executeUpdate(sql);

                    String andamento = "Em Aberto";
                    txt_andamento_financeiro.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else if(planilha.equalsIgnoreCase("Finalizado") &&
                boleto.equalsIgnoreCase("Finalizado") &&
                controle.equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Concluido' where codNumerodoprocesso="+processo;
                    con_geral.statement.executeUpdate(sql);

                    String andamento = "Concluido";
                    txt_andamento_financeiro.setText(andamento);
                    
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
        else{
            try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFinanceiro='Em Aberto' where codNumerodoprocesso="+processo;
                    con_geral.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
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
        cb_tipo_planilha.setSelectedItem("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_planilha.setText(datahoje);
        
    }
    public void limpar_tela_boleto(){
        txt_cod_boleto.setEditable(false);
        txt_cod_boleto.setText("");
        cb_tipo_boleto.setSelectedItem("");
        txt_obs_boleto.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_boleto.setText(datahoje);
    }
    public void limpar_tela_controle(){
        txt_cod_controle.setEditable(false);
        txt_cod_controle.setText("");
        cb_tipo_controle.setSelectedItem("");
        txt_obs_controle.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_controle.setText(datahoje);
    }

    public void atualizar_financeiro_planilha(){
        if(cb_tipo_planilha.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE financeiro set AndamentoLancamentodeDadosPlanCobranca='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Planilha\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from financeiro where Numerodoprocesso='" +processo+"' and AndamentoLancamentodeDadosPlanCobranca ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //con_geralsulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from lancamentodedadosnaplancobranca where NumeroProcesso='"+processo+"'and AndamentoLancamentoDeDadosPlanCobranca='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE financeiro set AndamentoLancamentodeDadosPlanCobranca ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Planilha\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE financeiro set AndamentoLancamentodeDadosPlanCobranca ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Planilha:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Financeiro>Planilha: \n" +erro);
            }
                    
        }
    }
    public void atualizar_financeiro_boleto(){
        if(cb_tipo_boleto.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE financeiro set AndamentoEmissaoBoleto='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Boleto\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from financeiro where Numerodoprocesso='" +processo+"' and AndamentoEmissaoBoleto ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from emissaoboleto where NumeroProcesso='"+processo+"'and AndamentoEmissaoBoleto='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE financeiro set AndamentoEmissaoBoleto='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Boleto\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE financeiro set AndamentoEmissaoBoleto ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Boleto:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Financeiro>Boleto: \n" +erro);
            }
                    
        }
    }
    public void atualizar_financeiro_controle(){
        if(cb_tipo_controle.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE financeiro set AndamentoEntrarNoControlControleDoOs='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Controle\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from financeiro where Numerodoprocesso='" +processo+"' and AndamentoEntrarNoControlControleDoOs ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from entrarnocontrolcontroleos where NumeroProcesso='"+processo+"'and AndamentoEntrarNControlControleOS='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE financeiro set AndamentoEntrarNoControlControleDoOs='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Controle\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE financeiro set AndamentoEntrarNoControlControleDoOs ='Em Aberto' where Numerodoprocesso='" +txt_codigo.getText()+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Controle:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Financeiro>Controle: \n" +erro);
            }
                    
        }
    }
    public void bloquear_tela_boleto(){
        txt_cod_boleto.setEditable(false);
        txt_data_boleto.setEditable(false);
        cb_tipo_boleto.setEditable(false);
        txt_obs_boleto.setEditable(false);
    }

    public void desbloquear_tela_boleto(){
        txt_data_boleto.setEditable(true);
        cb_tipo_boleto.setEditable(true);
        txt_obs_boleto.setEditable(true);
    }
    public void bloquear_tela_planilha(){
        txt_cod_planilha.setEditable(false);
        txt_data_planilha.setEditable(false);
        cb_tipo_planilha.setEditable(false);
        txt_obs_planilha.setEditable(false);
    }

    public void desbloquear_tela_planilha(){
        txt_data_planilha.setEditable(true);
        cb_tipo_planilha.setEditable(true);
        txt_obs_planilha.setEditable(true);
    }
    public void bloquear_tela_controle(){
        txt_cod_controle.setEditable(false);
        txt_data_controle.setEditable(false);
        cb_tipo_controle.setEditable(false);
        txt_obs_controle.setEditable(false);
    }

    public void desbloquear_tela_controle(){
        txt_data_controle.setEditable(true);
        cb_tipo_controle.setEditable(true);
        txt_obs_controle.setEditable(true);
    }
    public void criar_backup_planilha(){
        codPlan_backup = txt_cod_planilha.getText();
        tipoPlan_backup = (String)cb_tipo_planilha.getSelectedItem();
        dataPlan_backup = txt_data_planilha.getText();
        obsPlan_backup = txt_obs_planilha.getText();
    }
    public void restaurar_backup_planilha(){
        txt_cod_planilha.setText(codPlan_backup);
        cb_tipo_planilha.setSelectedItem(tipoPlan_backup);
        txt_data_planilha.setText(dataPlan_backup);
        txt_obs_planilha.setText(obsPlan_backup);
    }
    public void criar_backup_boleto(){
        codBol_backup = txt_cod_boleto.getText();
        tipoBol_backup = (String)cb_tipo_boleto.getSelectedItem();
        dataBol_backup = txt_data_boleto.getText();
        obsBol_backup = txt_obs_boleto.getText();
    }
    public void restaurar_backup_boleto(){
        txt_cod_boleto.setText(codBol_backup);
        cb_tipo_boleto.setSelectedItem(tipoBol_backup);
        txt_data_boleto.setText(dataBol_backup);
        txt_obs_boleto.setText(obsBol_backup);
    }
    public void criar_backup_controle(){
        codCon_backup = txt_cod_controle.getText();
        tipoCon_backup = (String)cb_tipo_controle.getSelectedItem();
        dataCon_backup = txt_data_controle.getText();
        obsCon_backup = txt_obs_controle.getText();
    }
    public void restaurar_backup_controle(){
        txt_cod_controle.setText(codCon_backup);
        cb_tipo_controle.setSelectedItem(tipoCon_backup);
        txt_data_controle.setText(dataCon_backup);
        txt_obs_controle.setText(obsCon_backup);
    }
}