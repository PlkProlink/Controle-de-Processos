package br.com.prolink.departamentos;

import br.com.prolink.inicio.Ativador;
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

import br.com.prolink.inicio.*;


public class Regularizacao extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con_cliente, con_regularizacao, con_termo, con_arquivo;
    //maskara para o JFormattedTextField
    MaskFormatter formatoArquivo, formatoTermo;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    String processo=Ativador.processo, id = Ativador.id, nome = Ativador.nome, usuario = Login.usuario,
           termo, arquivo, codTermo_backup, obsTermo_backup, dataTermo_backup, tipoTermo_backup,
           codArquivo_backup, obsArquivo_backup, dataArquivo_backup, tipoArquivo_backup;
    
    /**
     *
     */
    public Regularizacao() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        con_cliente = new Conexao();
        con_cliente.conecta();
        
        con_termo = new Conexao();
        con_termo.conecta();
        
        con_arquivo = new Conexao();
        con_arquivo.conecta();
        
        con_regularizacao = new Conexao();
        con_regularizacao.conecta();
        
        //chamando metodo que preencha as tabelas
        preencher_jtable_termo();
        preencher_jtable_arquivo();
        //chamando metodo que preencha tela de status
        bloqueia_tela_termo();
        bloqueia_tela_arquivo();
        preencher_status();
        atualizar_cadastro_cliente();
        //bloqueando edição do campo codigo
        limpar_tela_arquivo();
        limpar_tela_termo();
        tb_arquivo.setAutoCreateRowSorter(true);
        tb_termo.setAutoCreateRowSorter(true);
        
        //txt_codigo.setText(processo);
        //txt_nome.setText(nome);
        //txt_id.setText(id);
        //txt_usuario.setText(usuario);
        
        if(!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Regularização")){
            
            btnExcluirTermo.setEnabled(false);
            btnSalvarTermo.setEnabled(false);
            btnExcluirArquivo.setEnabled(false);
            btnSalvarArquivo.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Você não tem permissão para editar os registros dessa tela!");
        }
        
        //chamando metodo que busca a data atual e envia para os campos de datas
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpRegularizacao = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_cod = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        jtbGuiaRegularizacao = new javax.swing.JTabbedPane();
        jpSitReg = new javax.swing.JPanel();
        lbTitFaseFiscal = new javax.swing.JLabel();
        lbTitStatusFiscal = new javax.swing.JLabel();
        lb_enviodetermo = new javax.swing.JLabel();
        lb_encaminhadoaoarquivo = new javax.swing.JLabel();
        txt_status_termo = new javax.swing.JLabel();
        txt_status_arquivo = new javax.swing.JLabel();
        txt_andamento_regularizacao = new javax.swing.JLabel();
        jpEnvioTermo = new javax.swing.JPanel();
        lbcod_termo = new javax.swing.JLabel();
        txt_cod_termo = new javax.swing.JTextField();
        lb_andamento_arquivo1 = new javax.swing.JLabel();
        lb_obs_termo = new javax.swing.JLabel();
        try {
     formatoTermo = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local termo: " +erro);
 }
        txt_data_termo = new JFormattedTextField(formatoTermo);
        lb_tipo_termo = new javax.swing.JLabel();
        cb_tipo_termo = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txt_obs_termo = new javax.swing.JTextArea();
        btnAlterarTermo = new javax.swing.JButton();
        btnSalvarTermo = new javax.swing.JButton();
        btnCancelarTermo = new javax.swing.JButton();
        btnExcluirTermo = new javax.swing.JButton();
        btnFecharTermo = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_termo = new javax.swing.JTable();
        btnNovoTermo = new javax.swing.JButton();
        jpArquivo = new javax.swing.JPanel();
        lbcod_arquivo = new javax.swing.JLabel();
        txt_cod_arquivo = new javax.swing.JTextField();
        lb_data_arquivo = new javax.swing.JLabel();
        try {
            formatoArquivo = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em Arquivo: " +erro);
        }
        txt_data_arquivo = new JFormattedTextField(formatoArquivo);
        lb_tipo_arquivo = new javax.swing.JLabel();
        cb_tipo_arquivo = new javax.swing.JComboBox();
        lb_obs_arquivo = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_obs_arquivo = new javax.swing.JTextArea();
        btnAlterarArquivo = new javax.swing.JButton();
        btnSalvarArquivo = new javax.swing.JButton();
        btnCancelarArquivo = new javax.swing.JButton();
        btnExcluirArquivo = new javax.swing.JButton();
        btnFecharArquivo = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_arquivo = new javax.swing.JTable();
        btnNovoArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Regularização");

        jpRegularizacao.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Regularização");
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

        jtbGuiaRegularizacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpSitReg.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFaseFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFaseFiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFaseFiscal.setText("Fase:");

        lbTitStatusFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatusFiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatusFiscal.setText("Status:");

        lb_enviodetermo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_enviodetermo.setText("Envio de Termo de Responsabilidade Técnica:");

        lb_encaminhadoaoarquivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_encaminhadoaoarquivo.setText("Encaminhado ao Arquivo:");

        txt_status_termo.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_termo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_termo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_termo.setOpaque(true);

        txt_status_arquivo.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_arquivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_arquivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_arquivo.setOpaque(true);

        txt_andamento_regularizacao.setBackground(new java.awt.Color(245, 245, 245));
        txt_andamento_regularizacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_andamento_regularizacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_andamento_regularizacao.setToolTipText("");
        txt_andamento_regularizacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_andamento_regularizacao.setOpaque(true);

        javax.swing.GroupLayout jpSitRegLayout = new javax.swing.GroupLayout(jpSitReg);
        jpSitReg.setLayout(jpSitRegLayout);
        jpSitRegLayout.setHorizontalGroup(
            jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitRegLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(txt_andamento_regularizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 258, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitRegLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitRegLayout.createSequentialGroup()
                        .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitFaseFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_enviodetermo))
                        .addGap(64, 64, 64)
                        .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitStatusFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpSitRegLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_status_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_status_termo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lb_encaminhadoaoarquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jpSitRegLayout.setVerticalGroup(
            jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitRegLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitStatusFiscal)
                    .addComponent(lbTitFaseFiscal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_enviodetermo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitRegLayout.createSequentialGroup()
                        .addComponent(txt_status_termo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(15, 15, 15)
                .addGroup(jpSitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_encaminhadoaoarquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_status_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(txt_andamento_regularizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jtbGuiaRegularizacao.addTab("Situação", jpSitReg);

        jpEnvioTermo.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_termo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_termo.setText("Cod:");

        lb_andamento_arquivo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_andamento_arquivo1.setText("Data:");

        lb_obs_termo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_termo.setText("Observação:");

        lb_tipo_termo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_termo.setText("Tipo:");

        cb_tipo_termo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        txt_obs_termo.setColumns(20);
        txt_obs_termo.setLineWrap(true);
        txt_obs_termo.setRows(5);
        jScrollPane9.setViewportView(txt_obs_termo);

        btnAlterarTermo.setText("Alterar");
        btnAlterarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTermoActionPerformed(evt);
            }
        });

        btnSalvarTermo.setText("Salvar");
        btnSalvarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarTermoActionPerformed(evt);
            }
        });

        btnCancelarTermo.setText("Cancelar");
        btnCancelarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTermoActionPerformed(evt);
            }
        });

        btnExcluirTermo.setText("Excluir");
        btnExcluirTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTermoActionPerformed(evt);
            }
        });

        btnFecharTermo.setText("Fechar");
        btnFecharTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharTermoActionPerformed(evt);
            }
        });

        tb_termo.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_termo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_termoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_termo);

        btnNovoTermo.setText("Novo");
        btnNovoTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTermoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEnvioTermoLayout = new javax.swing.GroupLayout(jpEnvioTermo);
        jpEnvioTermo.setLayout(jpEnvioTermoLayout);
        jpEnvioTermoLayout.setHorizontalGroup(
            jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_termo)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_termo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_andamento_arquivo1)
                .addGap(111, 111, 111)
                .addComponent(txt_data_termo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_termo)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_termo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_termo)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnNovoTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFecharTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpEnvioTermoLayout.setVerticalGroup(
            jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_termo))
                    .addComponent(txt_cod_termo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_andamento_arquivo1))
                    .addComponent(txt_data_termo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_termo))
                    .addGroup(jpEnvioTermoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_termo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_termo)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnvioTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaRegularizacao.addTab("Termo de Responsabilidade", jpEnvioTermo);

        jpArquivo.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_arquivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_arquivo.setText("Cod:");

        lb_data_arquivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_data_arquivo.setText("Data:");

        lb_tipo_arquivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_arquivo.setText("Tipo:");

        cb_tipo_arquivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        lb_obs_arquivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_arquivo.setText("Observação:");

        txt_obs_arquivo.setColumns(20);
        txt_obs_arquivo.setLineWrap(true);
        txt_obs_arquivo.setRows(5);
        jScrollPane7.setViewportView(txt_obs_arquivo);

        btnAlterarArquivo.setText("Alterar");
        btnAlterarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarArquivoActionPerformed(evt);
            }
        });

        btnSalvarArquivo.setText("Salvar");
        btnSalvarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarArquivoActionPerformed(evt);
            }
        });

        btnCancelarArquivo.setText("Cancelar");
        btnCancelarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarArquivoActionPerformed(evt);
            }
        });

        btnExcluirArquivo.setText("Excluir");
        btnExcluirArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirArquivoActionPerformed(evt);
            }
        });

        btnFecharArquivo.setText("Fechar");
        btnFecharArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharArquivoActionPerformed(evt);
            }
        });

        tb_arquivo.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_arquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_arquivoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_arquivo);

        btnNovoArquivo.setText("Novo");
        btnNovoArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpArquivoLayout = new javax.swing.GroupLayout(jpArquivo);
        jpArquivo.setLayout(jpArquivoLayout);
        jpArquivoLayout.setHorizontalGroup(
            jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArquivoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_arquivo)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpArquivoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_data_arquivo)
                .addGap(111, 111, 111)
                .addComponent(txt_data_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_arquivo)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpArquivoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_arquivo)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpArquivoLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnNovoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFecharArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpArquivoLayout.setVerticalGroup(
            jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArquivoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArquivoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_arquivo))
                    .addComponent(txt_cod_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArquivoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_data_arquivo))
                    .addComponent(txt_data_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpArquivoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_arquivo))
                    .addGroup(jpArquivoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_arquivo)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFecharArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpArquivoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_cod_arquivo, txt_data_arquivo});

        jtbGuiaRegularizacao.addTab("Envio ao Arquivo", jpArquivo);

        javax.swing.GroupLayout jpRegularizacaoLayout = new javax.swing.GroupLayout(jpRegularizacao);
        jpRegularizacao.setLayout(jpRegularizacaoLayout);
        jpRegularizacaoLayout.setHorizontalGroup(
            jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegularizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRegularizacaoLayout.createSequentialGroup()
                        .addGroup(jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_cod)
                            .addComponent(lb_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbGuiaRegularizacao))
                .addContainerGap())
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpRegularizacaoLayout.setVerticalGroup(
            jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegularizacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo)
                .addGap(18, 18, 18)
                .addGroup(jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_nome)
                        .addComponent(lb_cod)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRegularizacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jtbGuiaRegularizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegularizacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpRegularizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirArquivoActionPerformed
        if(txt_cod_arquivo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from arquivamentodoprocesso where CodArquivamento= "+txt_cod_arquivo.getText();
                con_arquivo.executeSQL(sql);
                con_arquivo.resultset.first();
                
                String cliente = "Tem certeza que deseja excluir um cadastro da tabela Arquivo com cliente : " +con_arquivo.resultset.getString("Cliente")+"?";
                //pegando o status atual do cliente Em aberto ou Finalizado
                String operacao = con_arquivo.resultset.getString("Tipo");
                
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM arquivamentodoprocesso Where CodArquivamento="+txt_cod_arquivo.getText();
                    int conseguiu_excluir = con_arquivo.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        if("Finalizado".equals(operacao)){
                            try{
                                con_arquivo.executeSQL("select * from arquivamentodoprocesso where NumeroProcesso='"+processo+"' and Andamentoarquivar='Finalizado'");
                            if(!con_arquivo.resultset.first()){
                                con_regularizacao.statement.executeUpdate("UPDATE regularizacao set AndamentoArquivarProcesso='Em Aberto' where Numerodoprocesso="+processo);
                            }
                            }catch(SQLException erro){
                                JOptionPane.showMessageDialog(null, "Erro ao localizar dados na tabela Regularização>Arquivo.\n"+erro);
                            }
                        }
                        
                    limpar_tela_arquivo();
                    limpar_tabela_arquivo();
                    preencher_jtable_arquivo();
                    preencher_status();
                    atualizar_cadastro_cliente();
                        
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro da tabela Regularização!\n" +erro);
            }
        }
        
    }//GEN-LAST:event_btnExcluirArquivoActionPerformed

    private void btnCancelarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarArquivoActionPerformed
        restaura_backup_arquivo();
        bloqueia_tela_arquivo();
    }//GEN-LAST:event_btnCancelarArquivoActionPerformed

    private void btnSalvarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarArquivoActionPerformed
        if(txt_data_arquivo.getText().equals("  /  /    ") || txt_data_arquivo.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data válida no campo novo andamento!");
        }
        else if(cb_tipo_arquivo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campo Tipo não pode ficar em branco!");
            cb_tipo_arquivo.requestFocus();
        }
        else if(!txt_cod_arquivo.getText().equals("")){
            try{
                String dataandamento = txt_data_arquivo.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamento;
                if(cb_tipo_arquivo.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }else{
                    andamento = "Em Aberto";
                }
                String sql = "UPDATE arquivamentodoprocesso set DatadeCadastroAndamento='"+
                new java.sql.Date(data.getTime())+"',"+
                "Obsevacao='"+txt_obs_arquivo.getText()+"',"+
                "Usuario= '"+usuario+"',"+
                "Andamentoarquivar='"+andamento+"',"+
                "Tipo='"+cb_tipo_arquivo.getSelectedItem()+"' "+
                "where CodArquivamento = "+txt_cod_arquivo.getText();

                con_arquivo.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

                atualizar_regularizacao_arquivo();
                limpar_tabela_arquivo();
                preencher_jtable_arquivo();
                preencher_status();
                atualizar_cadastro_cliente();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados da tabela Arquivo: \n " +erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conversão da data ou data incorreta!\n"+ex);
            }
        }//evitando erros com cadastro ja salvo antes
        else if(txt_cod_arquivo.getText().equals("")){
            try{
                String dataandamento = txt_data_arquivo.getText();
                Date dataarquivo = sdf.parse(dataandamento);
                
                String andamentoarquivo;
                if(cb_tipo_arquivo.getSelectedItem().equals("Finalizado")){
                    andamentoarquivo = "Finalizado";
                }
                else{
                    andamentoarquivo = "Em Aberto";
                }
                String gry = "insert into arquivamentodoprocesso ("+
                "NumeroProcesso, Departamento, DatadeCadastroAndamento, Obsevacao, "+
                "Cliente, Usuario, AndamentoArquivar, Tipo) values ('"+
                processo+"','"+
                "Envio Arquivamento de Processo','"+
                new java.sql.Date(dataarquivo.getTime())+"','"+
                txt_obs_arquivo.getText()+"','"+
                nome+"','"+
                usuario+"','"+
                andamentoarquivo+"','"+
                cb_tipo_arquivo.getSelectedItem()+"')";

                con_arquivo.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                
                atualizar_regularizacao_arquivo();
                limpar_tabela_arquivo();
                preencher_jtable_arquivo();
                preencher_status();
                atualizar_cadastro_cliente();
                
            }catch(Exception add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Arquivo: \n"+add);
            }
        }
        
    }//GEN-LAST:event_btnSalvarArquivoActionPerformed

    private void btnFecharArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharArquivoActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharArquivoActionPerformed

    private void btnAlterarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarArquivoActionPerformed
        cria_backup_arquivo();
        desbloqueia_tela_arquivo();
    }//GEN-LAST:event_btnAlterarArquivoActionPerformed

    private void btnExcluirTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTermoActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_termo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from enviartermoderesponsabilidadeparacomercial where CodEnviartermoderesponsaparaComercial= "+txt_cod_termo.getText();
                con_termo.executeSQL(sql);
                con_termo.resultset.first();
                String cliente = "Tem certeza que deseja excluir um cadastro da tabela Termo com cliente : " +con_termo.resultset.getString("Cliente")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM enviartermoderesponsabilidadeparacomercial Where CodEnviartermoderesponsaparaComercial ="+txt_cod_termo.getText();
                    int conseguiu_excluir = con_termo.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                    
                    limpar_tela_termo();
                    limpar_tabela_termo();
                    preencher_jtable_termo();
                    preencher_status();
                    atualizar_cadastro_cliente();
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao excluir o registro da tabela Arquivo!\n" +erro);
            }
        }

    }//GEN-LAST:event_btnExcluirTermoActionPerformed

    private void btnCancelarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTermoActionPerformed
        restaura_backup_termo();
        bloqueia_tela_termo();
    }//GEN-LAST:event_btnCancelarTermoActionPerformed

    private void btnSalvarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTermoActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_termo.getText().equals("  /  /    ") || txt_data_termo.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cb_tipo_termo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_termo.requestFocus();
        }
        else if(!txt_codigo.getText().equals("")){
            try{
                String dataandamento = txt_data_termo.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamentotermo;
                
                if(cb_tipo_termo.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                }
                else{
                    andamentotermo = "Em Aberto";
                }
                String sql = "UPDATE enviartermoderesponsabilidadeparacomercial set DataCadastroAndamento='"+
                new java.sql.Date(datatermo.getTime())+"',"+
                "Obsevacao='"+txt_obs_termo.getText()+"',"+
                "Usuario= '"+usuario+"',"+
                "AndamentoEnvioTermoResponsabiidadeparaComercial='"+andamentotermo+"',"+
                "Tipo='"+cb_tipo_termo.getSelectedItem()+"' "+
                "where CodEnviartermoderesponsaparaComercial = "+txt_cod_termo.getText();

                con_termo.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_regularizacao_termo();
                limpar_tabela_termo();
                preencher_jtable_termo();
                preencher_status();
                atualizar_cadastro_cliente();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados da tabela Termo: " +erro);
            }catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conversao da data ou data incorreta!\n"+ex);
            }
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_termo.getText().equals("")){
            try{
                //convertendo a primeira data
                String dataandamento = txt_data_termo.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamentotermo;
                if(cb_tipo_termo.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                }
                else{
                    andamentotermo = "Em Aberto";
                }

                    String gry = "insert into enviartermoderesponsabilidadeparacomercial ("+
                    "NumeroProcesso, Departamento, DataCadastroAndamento, Obsevacao,"+
                    "Cliente, Usuario, AndamentoEnvioTermoResponsabiidadeparaComercial, Tipo) values ('"+
                    processo+"','"+
                    "Envio Termo para Comercial','"+
                    new java.sql.Date(datatermo.getTime())+"','"+
                    txt_obs_termo.getText()+"','"+
                    txt_nome.getText()+"','"+
                    txt_usuario.getText()+"','"+
                    andamentotermo+"','"+
                    cb_tipo_termo.getSelectedItem()+"')";

                    con_termo.exeQuery(gry);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                    atualizar_regularizacao_termo();
                    limpar_tabela_termo();
                    preencher_jtable_termo();
                    preencher_status();
                    atualizar_cadastro_cliente();
                   
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Termo: "+add);
            }
        }

    }//GEN-LAST:event_btnSalvarTermoActionPerformed

    private void btnFecharTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharTermoActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharTermoActionPerformed

    private void btnAlterarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTermoActionPerformed
        cria_backup_termo();
        desbloqueia_tela_termo();
    }//GEN-LAST:event_btnAlterarTermoActionPerformed

    private void tb_termoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_termoMouseClicked
        Integer linha = tb_termo.getSelectedRow();
        String codigo = (String)tb_termo.getValueAt(linha, 0);
        String data = (String)tb_termo.getValueAt(linha, 2);
        String tipo = (String)tb_termo.getValueAt(linha, 3);
        String observacao = (String)tb_termo.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_termo.setText(recebedataTabela);
        
        txt_cod_termo.setText(codigo);
        cb_tipo_termo.setSelectedItem(tipo);
        txt_obs_termo.setText(observacao);
        
        
        
    }//GEN-LAST:event_tb_termoMouseClicked

    private void tb_arquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_arquivoMouseClicked
        Integer linha = tb_arquivo.getSelectedRow();
        String codigo = (String)tb_arquivo.getValueAt(linha, 0);
        String data = (String)tb_arquivo.getValueAt(linha, 2);
        String tipo = (String)tb_arquivo.getValueAt(linha, 3);
        String observacao = (String)tb_arquivo.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txt_data_arquivo.setText(recebedataTabela);
        
        txt_cod_arquivo.setText(codigo);
        cb_tipo_arquivo.setSelectedItem(tipo);
        txt_obs_arquivo.setText(observacao);
    }//GEN-LAST:event_tb_arquivoMouseClicked

    private void btnNovoTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTermoActionPerformed
        cria_backup_termo();
        limpar_tela_termo();
        desbloqueia_tela_termo();
    }//GEN-LAST:event_btnNovoTermoActionPerformed

    private void btnNovoArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoArquivoActionPerformed
        cria_backup_arquivo();
        limpar_tela_arquivo();
        desbloqueia_tela_arquivo();
    }//GEN-LAST:event_btnNovoArquivoActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            Regularizacao reg = new Regularizacao();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarArquivo;
    private javax.swing.JButton btnAlterarTermo;
    private javax.swing.JButton btnCancelarArquivo;
    private javax.swing.JButton btnCancelarTermo;
    private javax.swing.JButton btnExcluirArquivo;
    private javax.swing.JButton btnExcluirTermo;
    private javax.swing.JButton btnFecharArquivo;
    private javax.swing.JButton btnFecharTermo;
    private javax.swing.JButton btnNovoArquivo;
    private javax.swing.JButton btnNovoTermo;
    private javax.swing.JButton btnSalvarArquivo;
    private javax.swing.JButton btnSalvarTermo;
    private javax.swing.JComboBox cb_tipo_arquivo;
    private javax.swing.JComboBox cb_tipo_termo;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpArquivo;
    private javax.swing.JPanel jpEnvioTermo;
    public javax.swing.JPanel jpRegularizacao;
    private javax.swing.JPanel jpSitReg;
    private javax.swing.JTabbedPane jtbGuiaRegularizacao;
    private javax.swing.JLabel lbTitFaseFiscal;
    private javax.swing.JLabel lbTitStatusFiscal;
    private javax.swing.JLabel lb_andamento_arquivo1;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_data_arquivo;
    private javax.swing.JLabel lb_encaminhadoaoarquivo;
    private javax.swing.JLabel lb_enviodetermo;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_obs_arquivo;
    private javax.swing.JLabel lb_obs_termo;
    private javax.swing.JLabel lb_tipo_arquivo;
    private javax.swing.JLabel lb_tipo_termo;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lbcod_arquivo;
    private javax.swing.JLabel lbcod_termo;
    private javax.swing.JTable tb_arquivo;
    private javax.swing.JTable tb_termo;
    public static javax.swing.JLabel txt_andamento_regularizacao;
    private javax.swing.JTextField txt_cod_arquivo;
    private javax.swing.JTextField txt_cod_termo;
    public static javax.swing.JLabel txt_codigo;
    private javax.swing.JFormattedTextField txt_data_arquivo;
    private javax.swing.JFormattedTextField txt_data_termo;
    public static javax.swing.JLabel txt_id;
    public static javax.swing.JLabel txt_nome;
    private javax.swing.JTextArea txt_obs_arquivo;
    private javax.swing.JTextArea txt_obs_termo;
    public static javax.swing.JLabel txt_status_arquivo;
    public static javax.swing.JLabel txt_status_termo;
    public static javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
        public void preencher_jtable_termo(){
        tb_termo.getColumnModel().getColumn(0);
        tb_termo.getColumnModel().getColumn(1);
        tb_termo.getColumnModel().getColumn(2);
        tb_termo.getColumnModel().getColumn(3);
        tb_termo.getColumnModel().getColumn(4);
        tb_termo.getColumnModel().getColumn(5);
        con_termo.executeSQL("select * from enviartermoderesponsabilidadeparacomercial WHERE NumeroProcesso='"+processo+"' order by CodEnviartermoderesponsaparaComercial");
        //
        DefaultTableModel modelo = (DefaultTableModel)tb_termo.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con_termo.resultset.next())
                modelo.addRow(new Object [] {
                    con_termo.resultset.getString("CodEnviartermoderesponsaparaComercial"),
                    con_termo.resultset.getString("NumeroProcesso"),
                    sdf.format(con_termo.resultset.getTime("DataCadastroAndamento")),
                    con_termo.resultset.getString("Tipo"),                    
                    con_termo.resultset.getString("Obsevacao"),
                    con_termo.resultset.getString("Usuario")});
            con_termo.resultset.first();
        }   catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Termo "+erro);
    }
}

    /**
     *
     */
    public void preencher_jtable_arquivo(){
        tb_arquivo.getColumnModel().getColumn(0);
        tb_arquivo.getColumnModel().getColumn(1);
        tb_arquivo.getColumnModel().getColumn(2);
        tb_arquivo.getColumnModel().getColumn(3);
        tb_arquivo.getColumnModel().getColumn(4);
        tb_arquivo.getColumnModel().getColumn(5);
        con_arquivo.executeSQL("select * from arquivamentodoprocesso WHERE NumeroProcesso='"+processo+"' order by CodArquivamento");
        //
        DefaultTableModel modelo = (DefaultTableModel)tb_arquivo.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con_arquivo.resultset.next())
                modelo.addRow(new Object [] {
                    con_arquivo.resultset.getString("CodArquivamento"),
                    con_arquivo.resultset.getString("NumeroProcesso"),
                    sdf.format(con_arquivo.resultset.getTime("DatadeCadastroAndamento")),
                    con_arquivo.resultset.getString("Tipo"),
                    con_arquivo.resultset.getString("Obsevacao"),
                    con_arquivo.resultset.getString("Usuario")});
            con_arquivo.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Arquivo "+erro);
        }
    }

    /**
     *
     */
    public void limpar_tabela_termo(){
        DefaultTableModel tbm = (DefaultTableModel)tb_termo.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    /**
     *
     */
    public void limpar_tabela_arquivo(){
        DefaultTableModel tbm = (DefaultTableModel)tb_arquivo.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    /**
     *
     */
    public void preencher_status(){
        try{
            String sql = "select * from regularizacao WHERE Numerodoprocesso='"+processo+"'";
            //
            con_regularizacao.executeSQL(sql);
            con_regularizacao.resultset.first();
            
            txt_status_termo.setText(con_regularizacao.resultset.getString("AndamentoEnviarTernoReponsaParaComercial"));
            txt_status_arquivo.setText(con_regularizacao.resultset.getString("AndamentoArquivarProcesso"));
        
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao atualizar status!" +erro);
        }
        if(txt_status_termo.getText().equals("Finalizado") && txt_status_arquivo.getText().equals("Finalizado"))
        {
            try{
                String sql = "UPDATE cadastrodeprocesso set AndamentoRegularizacao ='Concluido' "+
                             "where Numerodoprocesso = " +processo;
                             con_cliente.statement.executeUpdate(sql);

                             txt_andamento_regularizacao.setText("Concluido");
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar status geral!" +erro);
                }
        }
        else if(txt_status_termo.getText().equals("Em Aberto") || txt_status_arquivo.getText().equals("Em Aberto"))
        {
            txt_andamento_regularizacao.setText("Em andamento");
        }
    }

    /**
     *
     */
    public void limpar_tela_termo(){
        txt_cod_termo.setText("");
        txt_obs_termo.setText("");
        txt_cod_termo.setEditable(false);
        cb_tipo_termo.setSelectedItem("Novo Andamento");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_termo.setText(datahoje);
        
    }

    /**
     *
     */
    public void limpar_tela_arquivo(){
        txt_cod_arquivo.setEditable(false);
        txt_cod_arquivo.setText("");
        cb_tipo_arquivo.setSelectedItem("Novo Andamento");
        txt_obs_arquivo.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_arquivo.setText(datahoje);
    }

    /**
     *
     */
    public void atualizar_regularizacao_arquivo(){
        if(cb_tipo_arquivo.getSelectedItem().equals("Finalizado")){
            try{
                con_regularizacao.statement.executeUpdate("Update regularizacao set AndamentoArquivarProcesso='Finalizado' where Numerodoprocesso="+processo );
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Regularização>Arquivo: \n" +erro);
            }
        }
        else{
            try{    
                    con_regularizacao.executeSQL("select * from regularizacao where Numerodoprocesso='" +processo+"' and AndamentoArquivarProcesso ='Finalizado'");
                if(con_regularizacao.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados \n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_arquivo.executeSQL("select * from arquivamentodoprocesso where NumeroProcesso='"+processo+"'and Andamentoarquivar='Finalizado'");
                    
                    if(!con_arquivo.resultset.first()){
                        try{
                
                        String sql = "UPDATE regularizacao set AndamentoArquivarProcesso ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_regularizacao.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Regularização>Arquivo: \n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                
                        String sql = "UPDATE regularizacao set AndamentoArquivarProcesso ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_regularizacao.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Regularização>Arquivo: \n" +erro);
                    }
                         
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na Tabela Regularização>Arquivo: \n" +erro);
            }
    }
}

    /**
     *
     */
    public void atualizar_regularizacao_termo(){
    if(cb_tipo_termo.getSelectedItem().equals("Finalizado")){
            try{
                con_regularizacao.statement.executeUpdate("Update regularizacao set AndamentoEnviarTernoReponsaParaComercial='Finalizado' where Numerodoprocesso="+processo );
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Regularização>Termo: \n" +erro);
            }
        }
        else{
            try{    
                    con_regularizacao.executeSQL("select * from regularizacao where Numerodoprocesso='" +processo+"' and AndamentoEnviarTernoReponsaParaComercial ='Finalizado'");
                if(con_regularizacao.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados \n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_arquivo.executeSQL("select * from enviartermoderesponsabilidadeparacomercial where NumeroProcesso='"+processo+"'and AndamentoEnvioTermoResponsabiidadeparaComercial='Finalizado'");
                    
                    if(!con_arquivo.resultset.first()){
                        try{
                
                        String sql = "UPDATE regularizacao set AndamentoEnviarTernoReponsaParaComercial ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_regularizacao.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Regularização>Termo: \n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                
                        String sql = "UPDATE regularizacao set AndamentoEnviarTernoReponsaParaComercial ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_regularizacao.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Regularização>Termo: \n" +erro);
                    }
                         
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Regularização>Termo: \n" +erro);
            }
    }
}
    private void atualizar_cadastro_cliente() {
    if(txt_status_termo.getText().equals("Em Aberto") || txt_status_arquivo.getText().equals("Em Aberto")){
        try{
                String sql = "update cadastrodeprocesso set AndamentoRegularizacao='Em Aberto' where codNumerodoProcesso="+processo;
                con_cliente.statement.executeUpdate(sql);
                
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao atualizar o cadastro do cliente!\n"+erro);
        }
    }
    else if(txt_status_termo.getText().equals("Finalizado") || txt_status_arquivo.getText().equals("Finalizado")){
        try{
                String sql = "update cadastrodeprocesso set AndamentoRegularizacao='Finalizado' where codNumerodoProcesso="+processo;
                con_cliente.statement.executeUpdate(sql);
                
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao atualizar o cadastro do cliente!\n"+erro);
        }
    }
    else{
        txt_andamento_regularizacao.setText("Em andamento");
    }
    distribuir_cores();
    }

    /**
     *
     */
    public void distribuir_cores(){
        if(txt_status_arquivo.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_arquivo.setBackground(Color.red);
        }
        else{
            txt_status_arquivo.setBackground(Color.green);
        }
        if(txt_status_termo.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_termo.setBackground(Color.red);
        }
        else{
            txt_status_termo.setBackground(Color.green);
        }
        if(txt_andamento_regularizacao.getText().equalsIgnoreCase("Em Aberto")){
           txt_andamento_regularizacao.setBackground(Color.red); 
        }
        else if(txt_andamento_regularizacao.getText().equalsIgnoreCase("Em Andamento")){
           txt_andamento_regularizacao.setBackground(Color.orange); 
        }
        else{
           txt_andamento_regularizacao.setBackground(Color.green); 
        }
            
}

    /**
     *
     */
    public void bloqueia_tela_arquivo(){
        txt_obs_arquivo.setEditable(false);
        cb_tipo_arquivo.setEditable(false);
        txt_data_arquivo.setEditable(false);
    }

    /**
     *
     */
    public void desbloqueia_tela_arquivo(){
        txt_obs_arquivo.setEditable(true);
        cb_tipo_arquivo.setEditable(true);
        txt_data_arquivo.setEditable(true);
    }

    /**
     *
     */
    public void cria_backup_arquivo(){
        codArquivo_backup = txt_cod_arquivo.getText();
        tipoArquivo_backup = (String)cb_tipo_arquivo.getSelectedItem();
        dataArquivo_backup = txt_data_arquivo.getText();
        obsArquivo_backup = txt_obs_arquivo.getText();
    }

    /**
     *
     */
    public void restaura_backup_arquivo(){
        txt_cod_arquivo.setText(codArquivo_backup);
        cb_tipo_arquivo.setSelectedItem(tipoArquivo_backup);
        txt_data_arquivo.setText(dataArquivo_backup);
        txt_obs_arquivo.setText(obsArquivo_backup);
    }

    /**
     *
     */
    public void bloqueia_tela_termo(){
        txt_obs_termo.setEditable(false);
        cb_tipo_termo.setEditable(false);
        txt_data_termo.setEditable(false);
    }

    /**
     *
     */
    public void desbloqueia_tela_termo(){
        txt_obs_termo.setEditable(true);
        cb_tipo_termo.setEditable(true);
        txt_data_termo.setEditable(true);
    }

    /**
     *
     */
    public void cria_backup_termo(){
        codTermo_backup = txt_cod_termo.getText();
        tipoTermo_backup = (String)cb_tipo_termo.getSelectedItem();
        dataTermo_backup = txt_data_termo.getText();
        obsTermo_backup = txt_obs_termo.getText();
    }

    /**
     *
     */
    public void restaura_backup_termo(){
        txt_cod_termo.setText(codTermo_backup);
        cb_tipo_termo.setSelectedItem(tipoTermo_backup);
        txt_data_termo.setText(dataTermo_backup);
        txt_obs_termo.setText(obsTermo_backup);
    }
}