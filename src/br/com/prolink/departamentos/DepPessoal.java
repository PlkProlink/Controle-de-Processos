package br.com.prolink.departamentos;

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

import br.com.prolink.controle.*;
import br.com.prolink.inicio.*;
/**
 *
 * @author Tiago Dias
 */

public class DepPessoal extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con_dp, con_folha, con_socio, con_dependentes;
    //maskara para o JFormattedTextField
    MaskFormatter formatoSocio, formatoDependentes, formatoFolha;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String socio, dependentes, folha, codSocio_backup, dataSocio_backup, obsSocio_backup, tipoSocio_backup,
            codDep_backup, dataDep_backup, obsDep_backup, tipoDep_backup,
            codFolha_backup, dataFolha_backup, obsFolha_backup, tipoFolha_backup;
    
    String processo=Ativador.processo, nome=Ativador.nome, id=Ativador.id, usuario=Login.usuario;
    
    public DepPessoal() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        con_dp = new Conexao();
        con_dp.conecta();
        
        con_folha = new Conexao();
        con_folha.conecta();
        
        con_socio = new Conexao();
        con_socio.conecta();
        
        con_dependentes = new Conexao();
        con_dependentes.conecta();
        
        //chamando metodo que preencha as tabelas
        preencher_tabela_socio();
        preencher_tabela_dependentes();
        preencher_tabela_folha();
        //chamando metodo que preencha tela de status
        preencher_status();
        
        atualizar_cadastro_cliente();
        
        bloquear_tela_socio();
        bloquear_tela_dependentes();
        bloquear_tela_folha();
        
        limpar_tela_socio();
        limpar_tela_dependentes();
        limpar_tela_folha();
        
        tbSocio.setAutoCreateRowSorter(true);
        tbDependentes.setAutoCreateRowSorter(true);
        tbFolha.setAutoCreateRowSorter(true);
        
        txtCodigo.setText(processo);
        txtNome.setText(nome);
        txtId.setText(id);
        txtUsuario.setText(usuario);
        
        if(!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Pessoal")){
            
            btnExcluirSocio.setEnabled(false);
            btnSalvarSocio.setEnabled(false);
            
            btnExcluirDependentes.setEnabled(false);
            btnSalvarDependentes.setEnabled(false);
            
            btnExcluirFolha.setEnabled(false);
            btnSalvarFolha.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "Você não tem permissão para editar os registros dessa tela!");
        }
        //chamando metodo que busca a data atual e envia para os campos de datas
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDP = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_cod = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jtbGuiaDP = new javax.swing.JTabbedPane();
        jpSitDP = new javax.swing.JPanel();
        lbTitFaseDP = new javax.swing.JLabel();
        lbTitStatusDP = new javax.swing.JLabel();
        lbCadSocio = new javax.swing.JLabel();
        txtStatusSocio = new javax.swing.JLabel();
        lbDependentes = new javax.swing.JLabel();
        txtStatusDependentes = new javax.swing.JLabel();
        lbControle = new javax.swing.JLabel();
        txtStatusFolha = new javax.swing.JLabel();
        txtAndamentoDP = new javax.swing.JLabel();
        jpCadSocio = new javax.swing.JPanel();
        lbCodSocio = new javax.swing.JLabel();
        txtCodSocio = new javax.swing.JTextField();
        lbDataSocio = new javax.swing.JLabel();
        lbObsSocio = new javax.swing.JLabel();
        try {
     formatoSocio = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local planilha: " +erro);
 }
        txtDataSocio = new JFormattedTextField(formatoSocio);
        lbTipoSocio = new javax.swing.JLabel();
        cbTipoSocio = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtObsSocio = new javax.swing.JTextArea();
        btnNovoSocio = new javax.swing.JButton();
        btnAlterarSocio = new javax.swing.JButton();
        btnSalvarSocio = new javax.swing.JButton();
        btnCancelarSocio = new javax.swing.JButton();
        btnExcluirSocio = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbSocio = new javax.swing.JTable();
        jpDependentes = new javax.swing.JPanel();
        lbCodDependentes = new javax.swing.JLabel();
        txtCodDependentes = new javax.swing.JTextField();
        lbDataDependetes = new javax.swing.JLabel();
        try {
            formatoDependentes = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em Boleto: " +erro);
        }
        txtDataDependentes = new JFormattedTextField(formatoDependentes);
        lbTipoDependentes = new javax.swing.JLabel();
        cbTipoDependentes = new javax.swing.JComboBox();
        lbObsDependentes = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtObsDependentes = new javax.swing.JTextArea();
        btnNovoDependentes = new javax.swing.JButton();
        btnAlterarDependentes = new javax.swing.JButton();
        btnSalvarDependentes = new javax.swing.JButton();
        btnCancelarDependentes = new javax.swing.JButton();
        btnExcluirDependentes = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbDependentes = new javax.swing.JTable();
        jpFolha = new javax.swing.JPanel();
        lbCodFolha = new javax.swing.JLabel();
        txtCodFolha = new javax.swing.JTextField();
        lbDataFolha = new javax.swing.JLabel();
        try {
     formatoFolha = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data: " +erro);
 }
        txtDataFolha = new JFormattedTextField(formatoFolha);
        lbTipoFolha = new javax.swing.JLabel();
        cbTipoFolha = new javax.swing.JComboBox();
        lbObsFolha = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtObsFolha = new javax.swing.JTextArea();
        btnNovoFolha = new javax.swing.JButton();
        btnAlterarFolha = new javax.swing.JButton();
        btnSalvarFolha = new javax.swing.JButton();
        btnCancelarFolha = new javax.swing.JButton();
        btnExcluirFolha = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbFolha = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpDP.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Folha");
        lb_titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lb_cod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_cod.setText("Nº:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lb_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_id.setText("ID:");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtbGuiaDP.setToolTipText("");
        jtbGuiaDP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpSitDP.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFaseDP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFaseDP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFaseDP.setText("Fase:");

        lbTitStatusDP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatusDP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatusDP.setText("Status:");

        lbCadSocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCadSocio.setText("Cadastro do Sócio:");

        txtStatusSocio.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusSocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusSocio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusSocio.setOpaque(true);

        lbDependentes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDependentes.setText("Registro de Dependentes:");

        txtStatusDependentes.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusDependentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusDependentes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusDependentes.setOpaque(true);

        lbControle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbControle.setText("Implantação dos Dados na Folha de Pagamento:");

        txtStatusFolha.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusFolha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusFolha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusFolha.setOpaque(true);

        txtAndamentoDP.setBackground(new java.awt.Color(245, 245, 245));
        txtAndamentoDP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAndamentoDP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAndamentoDP.setToolTipText("");
        txtAndamentoDP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAndamentoDP.setOpaque(true);

        javax.swing.GroupLayout jpSitDPLayout = new javax.swing.GroupLayout(jpSitDP);
        jpSitDP.setLayout(jpSitDPLayout);
        jpSitDPLayout.setHorizontalGroup(
            jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitDPLayout.createSequentialGroup()
                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitDPLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lbTitFaseDP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(lbTitStatusDP, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitDPLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(txtAndamentoDP, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitDPLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpSitDPLayout.createSequentialGroup()
                                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitDPLayout.createSequentialGroup()
                                        .addComponent(lbCadSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86))
                                    .addGroup(jpSitDPLayout.createSequentialGroup()
                                        .addComponent(lbDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121)))
                                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtStatusDependentes, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(txtStatusSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jpSitDPLayout.createSequentialGroup()
                                .addComponent(lbControle, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtStatusFolha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(60, 60, 60))
        );
        jpSitDPLayout.setVerticalGroup(
            jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitDPLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitFaseDP)
                    .addComponent(lbTitStatusDP))
                .addGap(12, 12, 12)
                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCadSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitDPLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpSitDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbControle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitDPLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148)
                .addComponent(txtAndamentoDP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaDP.addTab("Situação", jpSitDP);

        jpCadSocio.setBackground(new java.awt.Color(245, 245, 245));

        lbCodSocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodSocio.setText("Cod:");

        lbDataSocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataSocio.setText("Data:");

        lbObsSocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsSocio.setText("Observação:");

        lbTipoSocio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoSocio.setText("Tipo:");

        cbTipoSocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoSocio.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsSocio.setColumns(20);
        txtObsSocio.setLineWrap(true);
        txtObsSocio.setRows(5);
        jScrollPane9.setViewportView(txtObsSocio);

        btnNovoSocio.setText("Novo");
        btnNovoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoSocioActionPerformed(evt);
            }
        });

        btnAlterarSocio.setText("Alterar");
        btnAlterarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarSocioActionPerformed(evt);
            }
        });

        btnSalvarSocio.setText("Salvar");
        btnSalvarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarSocioActionPerformed(evt);
            }
        });

        btnCancelarSocio.setText("Cancelar");
        btnCancelarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSocioActionPerformed(evt);
            }
        });

        btnExcluirSocio.setText("Excluir");
        btnExcluirSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirSocioActionPerformed(evt);
            }
        });

        tbSocio.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSocioMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbSocio);
        if (tbSocio.getColumnModel().getColumnCount() > 0) {
            tbSocio.getColumnModel().getColumn(0).setMaxWidth(30);
            tbSocio.getColumnModel().getColumn(1).setMaxWidth(70);
            tbSocio.getColumnModel().getColumn(2).setMaxWidth(90);
            tbSocio.getColumnModel().getColumn(4).setMaxWidth(150);
            tbSocio.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadSocioLayout = new javax.swing.GroupLayout(jpCadSocio);
        jpCadSocio.setLayout(jpCadSocioLayout);
        jpCadSocioLayout.setHorizontalGroup(
            jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadSocioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSocioLayout.createSequentialGroup()
                        .addComponent(lbCodSocio)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadSocioLayout.createSequentialGroup()
                        .addComponent(lbDataSocio)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoSocio)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadSocioLayout.createSequentialGroup()
                        .addComponent(lbObsSocio)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadSocioLayout.createSequentialGroup()
                                .addComponent(btnNovoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9)))))
        );
        jpCadSocioLayout.setVerticalGroup(
            jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadSocioLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSocioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodSocio))
                    .addComponent(txtCodSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSocioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataSocio))
                    .addComponent(txtDataSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadSocioLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoSocio))
                    .addComponent(cbTipoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsSocio)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaDP.addTab("Cadastro do Sócio", jpCadSocio);

        jpDependentes.setBackground(new java.awt.Color(245, 245, 245));

        lbCodDependentes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodDependentes.setText("Cod:");

        lbDataDependetes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataDependetes.setText("Data:");

        lbTipoDependentes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoDependentes.setText("Tipo:");

        cbTipoDependentes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoDependentes.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        lbObsDependentes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsDependentes.setText("Observação:");

        txtObsDependentes.setColumns(20);
        txtObsDependentes.setLineWrap(true);
        txtObsDependentes.setRows(5);
        jScrollPane7.setViewportView(txtObsDependentes);

        btnNovoDependentes.setText("Novo");
        btnNovoDependentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDependentesActionPerformed(evt);
            }
        });

        btnAlterarDependentes.setText("Alterar");
        btnAlterarDependentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDependentesActionPerformed(evt);
            }
        });

        btnSalvarDependentes.setText("Salvar");
        btnSalvarDependentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDependentesActionPerformed(evt);
            }
        });

        btnCancelarDependentes.setText("Cancelar");
        btnCancelarDependentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDependentesActionPerformed(evt);
            }
        });

        btnExcluirDependentes.setText("Excluir");
        btnExcluirDependentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDependentesActionPerformed(evt);
            }
        });

        tbDependentes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDependentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDependentesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbDependentes);
        if (tbDependentes.getColumnModel().getColumnCount() > 0) {
            tbDependentes.getColumnModel().getColumn(0).setMaxWidth(30);
            tbDependentes.getColumnModel().getColumn(1).setMaxWidth(70);
            tbDependentes.getColumnModel().getColumn(2).setMaxWidth(90);
            tbDependentes.getColumnModel().getColumn(4).setMaxWidth(150);
            tbDependentes.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpDependentesLayout = new javax.swing.GroupLayout(jpDependentes);
        jpDependentes.setLayout(jpDependentesLayout);
        jpDependentesLayout.setHorizontalGroup(
            jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpDependentesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDependentesLayout.createSequentialGroup()
                        .addComponent(lbCodDependentes)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDependentesLayout.createSequentialGroup()
                        .addComponent(lbDataDependetes)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoDependentes)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDependentesLayout.createSequentialGroup()
                        .addComponent(lbObsDependentes)
                        .addGap(73, 73, 73)
                        .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpDependentesLayout.createSequentialGroup()
                                .addComponent(btnNovoDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7)))))
        );
        jpDependentesLayout.setVerticalGroup(
            jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDependentesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDependentesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodDependentes))
                    .addComponent(txtCodDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDependentesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataDependetes))
                    .addComponent(txtDataDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDependentesLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoDependentes))
                    .addComponent(cbTipoDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsDependentes)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDependentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpDependentesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCodDependentes, txtDataDependentes});

        jtbGuiaDP.addTab("Registro de Dependentes", jpDependentes);

        jpFolha.setBackground(new java.awt.Color(245, 245, 245));

        lbCodFolha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodFolha.setText("Cod:");

        lbDataFolha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataFolha.setText("Data:");

        txtDataFolha.setToolTipText("");

        lbTipoFolha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoFolha.setText("Tipo:");

        cbTipoFolha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoFolha.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        lbObsFolha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsFolha.setText("Observação:");

        txtObsFolha.setColumns(20);
        txtObsFolha.setLineWrap(true);
        txtObsFolha.setRows(5);
        jScrollPane10.setViewportView(txtObsFolha);

        btnNovoFolha.setText("Novo");
        btnNovoFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoFolhaActionPerformed(evt);
            }
        });

        btnAlterarFolha.setText("Alterar");
        btnAlterarFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarFolhaActionPerformed(evt);
            }
        });

        btnSalvarFolha.setText("Salvar");
        btnSalvarFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarFolhaActionPerformed(evt);
            }
        });

        btnCancelarFolha.setText("Cancelar");
        btnCancelarFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFolhaActionPerformed(evt);
            }
        });

        btnExcluirFolha.setText("Excluir");
        btnExcluirFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFolhaActionPerformed(evt);
            }
        });

        tbFolha.setModel(new javax.swing.table.DefaultTableModel(
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
        tbFolha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFolhaMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbFolha);
        if (tbFolha.getColumnModel().getColumnCount() > 0) {
            tbFolha.getColumnModel().getColumn(0).setMaxWidth(30);
            tbFolha.getColumnModel().getColumn(1).setMaxWidth(70);
            tbFolha.getColumnModel().getColumn(2).setMaxWidth(90);
            tbFolha.getColumnModel().getColumn(4).setMaxWidth(150);
            tbFolha.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpFolhaLayout = new javax.swing.GroupLayout(jpFolha);
        jpFolha.setLayout(jpFolhaLayout);
        jpFolhaLayout.setHorizontalGroup(
            jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpFolhaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFolhaLayout.createSequentialGroup()
                        .addComponent(lbCodFolha)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFolhaLayout.createSequentialGroup()
                        .addComponent(lbDataFolha)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoFolha)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFolhaLayout.createSequentialGroup()
                        .addComponent(lbObsFolha)
                        .addGap(73, 73, 73)
                        .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpFolhaLayout.createSequentialGroup()
                                .addComponent(btnNovoFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10)))))
        );
        jpFolhaLayout.setVerticalGroup(
            jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFolhaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFolhaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodFolha))
                    .addComponent(txtCodFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFolhaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataFolha))
                    .addComponent(txtDataFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFolhaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoFolha))
                    .addComponent(cbTipoFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsFolha)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovoFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAlterarFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaDP.addTab("Implantação de Dados na Folha", jpFolha);

        javax.swing.GroupLayout jpDPLayout = new javax.swing.GroupLayout(jpDP);
        jpDP.setLayout(jpDPLayout);
        jpDPLayout.setHorizontalGroup(
            jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDPLayout.createSequentialGroup()
                        .addGroup(jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_cod)
                            .addComponent(lb_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbGuiaDP))
                .addContainerGap())
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpDPLayout.setVerticalGroup(
            jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo)
                .addGap(18, 18, 18)
                .addGroup(jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_nome)
                        .addComponent(lb_cod)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jtbGuiaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirDependentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDependentesActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txtCodDependentes.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from cadastrodosdependentesdosociaadm where CodCadastroDependentesSocioADM= "+txtCodDependentes.getText();
                con_dependentes.executeSQL(sql);
                if(con_dependentes.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir um registro do cliente : "+nome+"?";
                    String operacao = con_dependentes.resultset.getString("AndamentoCadastroDependentesSocioADM");
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        sql = "DELETE FROM cadastrodosdependentesdosociaadm Where CodCadastroDependentesSocioADM="+txtCodDependentes.getText();
                        int conseguiu_excluir = con_dependentes.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1){
                            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                            
                            limpar_tabela_dependentes();
                            preencher_tabela_dependentes();
                            limpar_tela_dependentes();
                            
                            if("Finalizado".equals(operacao)){
                               con_dependentes.executeSQL("select * from cadastrodosdependentesdosociaadm where NumerodoProcesso='"+processo+ "and AndamentoCadastroDependentesSocioADM='Finalizado'");
                               if(!con_dependentes.resultset.first()){
                                    try{
                                        con_dp.statement.executeUpdate("update dp AndamentoCadastroDependentesdoSocioADM='Em Aberto' where Numerodoprocesso='"+processo);
                                    
                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar\n"+erro);
                                    }
                               }
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro\n"+erro);
            }
        }
    }//GEN-LAST:event_btnExcluirDependentesActionPerformed

    private void btnCancelarDependentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDependentesActionPerformed
       restaurar_backup_dependentes();
       bloquear_tela_dependentes();
    }//GEN-LAST:event_btnCancelarDependentesActionPerformed

    private void btnSalvarDependentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDependentesActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txtDataDependentes.getText().equals("  /  /    ") || txtDataDependentes.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cbTipoDependentes.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");        }
        //evitando erros com cadastro ja salvo antes
        else if(txtCodDependentes.getText().equals("")){
            try{
                String dataandamento = txtDataDependentes.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamentoboleto;
                if(cbTipoDependentes.getSelectedItem().equals("Finalizado")){
                    andamentoboleto = "Finalizado";
                }
                else{
                    andamentoboleto = "Em Aberto";
                    }
                String gry = "insert into cadastrodosdependentesdosociaadm ("+
                "NumeroProcesso, DatadeCadastroAndamento, Obsevacao, "+
                "Usuario, AndamentoCadastroDependentesSocioADM) values ('" +processo+"','"+
                new java.sql.Date(data.getTime())+"','"+
                txtObsDependentes.getText()+"','"+
                usuario+"','"+
                andamentoboleto+"')";

                con_dependentes.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                
                
                atualizar_dependentes();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_dependentes();
                preencher_tabela_dependentes();
                
            }catch(ParseException | HeadlessException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Dependentes: "+erro);
            }
        }
        else if(!txtCodDependentes.getText().equals("")){
            try{
               
                String dataandamento = txtDataDependentes.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamento;
                if(cbTipoDependentes.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }else{
                    andamento = "Em Aberto";
                }
                String sql = "UPDATE cadastrodosdependentesdosociaadm set DatadeCadastroAndamento='"+
                new java.sql.Date(data.getTime())+"',"+
                "Obsevacao='"+txtObsDependentes.getText()+"',"+
                "Usuario= '"+usuario+"',"+
                "AndamentoCadastroDependentesSocioADM='"+andamento+"' "+
                "where CodCadastroDependentesSocioADM = "+txtCodDependentes.getText();

                con_dependentes.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_dependentes();
                preencher_status();
                limpar_tabela_dependentes();
                preencher_tabela_dependentes();
                atualizar_cadastro_cliente();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Dependentes: \n " +erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
        
        }
    }//GEN-LAST:event_btnSalvarDependentesActionPerformed

    private void btnAlterarDependentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDependentesActionPerformed
        desbloquear_tela_dependentes();
    }//GEN-LAST:event_btnAlterarDependentesActionPerformed

    private void btnExcluirSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirSocioActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txtCodSocio.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                String sql = "select * from cadastrosocioadmcontrol  "
                        + "where CodCadastroSocioADMControl="+txtCodSocio.getText();
                con_socio.executeSQL(sql);
                con_socio.resultset.first();
                String cliente = "Tem certeza que deseja excluir um registro do cliente : "+nome+"?";
                String operacao = con_socio.resultset.getString("AndamentoCadastroSocioADMControl");
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM cadastrosocioadmcontrol Where CodCadastroSocioADMControl = "+txtCodSocio.getText();
                    int conseguiu_excluir = con_socio.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        
                        limpar_tela_socio();
                        limpar_tabela_socio();
                        preencher_tabela_socio();
                        //verificar se não existe outro registro com o status finalizado nesse cliente
                        if("Finalizado".equals(operacao)){
                            con_socio.executeSQL("select * from cadastrosocioadmcontrol where NumeroProcesso="+processo+" and AndamentoCadastroSocioADMControl='Finalizado'");
                            if(!con_socio.resultset.first()){
                                try{
                                    con_dp.statement.executeUpdate("update dp set AndamentoCadastroDoSocioNoControl='Em Aberto'"
                                    +"Numerodoprocesso="+processo);
                                   
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
    }//GEN-LAST:event_btnExcluirSocioActionPerformed

    private void btnCancelarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSocioActionPerformed
        restaurar_backup_socio();
        bloquear_tela_socio();
    }//GEN-LAST:event_btnCancelarSocioActionPerformed

    private void btnSalvarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarSocioActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txtDataSocio.getText().equals("  /  /    ") || txtDataSocio.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cbTipoSocio.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
        }
        //evitando erros com cadastro ja salvo antes
        else if(txtCodSocio.getText().equals("")){
            try{
                //convertendo a primeira data
                String dataandamento = txtDataSocio.getText();
                Date data = sdf.parse(dataandamento);

                String andamento;
                
                if(cbTipoSocio.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }

                    String gry = "insert into cadastrosocioadmcontrol("
                    +"NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"
                    +"Usuario, AndamentoCadastroSocioADMControl) "
                    +"values ('"+processo+"','"
                    +new java.sql.Date(data.getTime())+"','"
                    +txtObsSocio.getText()+"','"
                    +usuario+"','"
                    +andamento+"')";

                    con_socio.exeQuery(gry);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                    
                    atualizar_socios();
                    preencher_status();
                    atualizar_cadastro_cliente();
                    limpar_tabela_socio();
                    preencher_tabela_socio();
                    
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Socios: "+add);
            }
        }
        else if(!txtCodSocio.getText().equals("")){
            try{
               
                String dataandamento = txtDataSocio.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamento;
                
                if(cbTipoSocio.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "UPDATE cadastrosocioadmcontrol set DatadeCadastroAndamento='"+
                new java.sql.Date(datatermo.getTime())+"',"+
                "Obsevacao='"+txtObsSocio.getText()+"',"+
                "Usuario = '"+usuario+"',"+
                "AndamentoCadastroSocioADMControl='"+andamento+"' "+
                "where CodCadastroSocioADMControl = "+txtCodSocio.getText();

                con_socio.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_socios();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_socio();
                preencher_tabela_socio();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Socios: " +erro);
            }catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conversão da data ou valor incorreto!\n"+ex);
            }
        }
    }//GEN-LAST:event_btnSalvarSocioActionPerformed

    private void btnNovoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoSocioActionPerformed
        criar_backup_socio();
        limpar_tela_socio();
    }//GEN-LAST:event_btnNovoSocioActionPerformed

    private void tbSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSocioMouseClicked
        Integer linha = tbSocio.getSelectedRow();
        String codigo = (String)tbSocio.getValueAt(linha, 0);
        String data = (String)tbSocio.getValueAt(linha, 1);
        String observacao = (String)tbSocio.getValueAt(linha, 3);
        String tipo = (String)tbSocio.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataSocio.setText(recebedataTabela);
        
        txtCodSocio.setText(codigo);
        txtObsSocio.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoSocio.setSelectedItem("Finalizado");
        }
        else
            cbTipoSocio.setSelectedItem("Novo Andamento");
        
    }//GEN-LAST:event_tbSocioMouseClicked

    private void tbDependentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDependentesMouseClicked
        Integer linha = tbDependentes.getSelectedRow();
        String codigo = (String)tbDependentes.getValueAt(linha, 0);
        String data = (String)tbDependentes.getValueAt(linha, 1);
        String observacao = (String)tbDependentes.getValueAt(linha, 3);
        String tipo = (String)tbDependentes.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataDependentes.setText(recebedataTabela);
        
        txtCodDependentes.setText(codigo);
        txtObsDependentes.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoDependentes.setSelectedItem("Finalizado");
        }
        else
            cbTipoDependentes.setSelectedItem("Novo Andamento");
    }//GEN-LAST:event_tbDependentesMouseClicked

    private void btnNovoFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoFolhaActionPerformed
        criar_backup_folha();
        limpar_tela_folha();
        desbloquear_tela_folha();
    }//GEN-LAST:event_btnNovoFolhaActionPerformed

    private void btnSalvarFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFolhaActionPerformed
        if(txtDataFolha.getText().equals("  /  /    ") || txtDataFolha.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Data informada é invalida!");
        }
        else if(txtCodFolha.getText().equals("")){
            try{
                String novadata = txtDataFolha.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoFolha.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into implantardadosfolhapg (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Observacao, AndamentoImplantarDadosFolhaPG)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsFolha.getText()+"','"
                        +andamento+"')";
                con_folha.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_folha();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_folha();
                preencher_tabela_folha();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodFolha.getText().equals("")){
            try{
                String novadata = txtDataFolha.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoFolha.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update implantardadosfolhapg set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"','"
                        +"Usuario='"+usuario+"','"
                        +"Observacao='"+txtObsFolha.getText()+"','"
                        +"AndamentoImplantarDadosFolhaPG='"+andamento+"' "
                        +" where CodImplantarDadosFolhaPG="+txtCodFolha.getText();
                
                con_folha.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_folha();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_folha();
                preencher_tabela_folha();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
        
        
    }//GEN-LAST:event_btnSalvarFolhaActionPerformed

    private void btnCancelarFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFolhaActionPerformed
        restaurar_backup_folha();
        bloquear_tela_folha();
    }//GEN-LAST:event_btnCancelarFolhaActionPerformed

    private void btnExcluirFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFolhaActionPerformed
        if(txtCodFolha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            try{
                con_folha.executeSQL(("select * from implantardadosfolhapg where CodImplantarDadosFolhaPG="+txtCodFolha.getText()));
                if(con_folha.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con_folha.resultset.getString("AndamentoImplantarDadosFolhaPG");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from implantardadosfolhapg where CodImplantarDadosFolhaPG="+txtCodFolha.getText();
                        int conseguiu_excluir = con_folha.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            preencher_status();
                            atualizar_cadastro_cliente();
                            limpar_tabela_folha();
                            
                            if("Finalizado".equals(andamento)){
                                con_folha.executeSQL("select * from implantardadosfolhapg where NumeroProcesso="+processo+" and AndamentoImplantarDadosFolhaPG='Finalizado'");
                                
                                if(!con_folha.resultset.first()){
                                    try{
                                        con_dp.statement.executeUpdate("update dp set AndamentoIplantacaodadosFolhaPg='Em Aberto'");

                                        preencher_tabela_folha();
                                        limpar_tela_folha();
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela dp!\n"+erro);
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
    }//GEN-LAST:event_btnExcluirFolhaActionPerformed

    private void tbFolhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFolhaMouseClicked
        Integer linha = tbFolha.getSelectedRow();
        String codigo = (String)tbFolha.getValueAt(linha, 0);
        String data = (String)tbFolha.getValueAt(linha, 1);
        String observacao = (String)tbFolha.getValueAt(linha, 3);
        String tipo = (String)tbFolha.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataFolha.setText(recebedataTabela);
        
        txtCodFolha.setText(codigo);
        txtObsFolha.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoFolha.setSelectedItem("Finalizado");
        }
        else
            cbTipoFolha.setSelectedItem("Novo Andamento");
    }//GEN-LAST:event_tbFolhaMouseClicked

    private void btnAlterarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarSocioActionPerformed
        criar_backup_socio();
        desbloquear_tela_socio();
    }//GEN-LAST:event_btnAlterarSocioActionPerformed

    private void btnNovoDependentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDependentesActionPerformed
        criar_backup_dependentes();
        limpar_tela_dependentes();
        desbloquear_tela_dependentes();
    }//GEN-LAST:event_btnNovoDependentesActionPerformed

    private void btnAlterarFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarFolhaActionPerformed
        criar_backup_folha();
        desbloquear_tela_folha();
    }//GEN-LAST:event_btnAlterarFolhaActionPerformed
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            DepPessoal reg = new DepPessoal();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarDependentes;
    private javax.swing.JButton btnAlterarFolha;
    private javax.swing.JButton btnAlterarSocio;
    private javax.swing.JButton btnCancelarDependentes;
    private javax.swing.JButton btnCancelarFolha;
    private javax.swing.JButton btnCancelarSocio;
    private javax.swing.JButton btnExcluirDependentes;
    private javax.swing.JButton btnExcluirFolha;
    private javax.swing.JButton btnExcluirSocio;
    private javax.swing.JButton btnNovoDependentes;
    private javax.swing.JButton btnNovoFolha;
    private javax.swing.JButton btnNovoSocio;
    private javax.swing.JButton btnSalvarDependentes;
    private javax.swing.JButton btnSalvarFolha;
    private javax.swing.JButton btnSalvarSocio;
    private javax.swing.JComboBox cbTipoDependentes;
    private javax.swing.JComboBox cbTipoFolha;
    private javax.swing.JComboBox cbTipoSocio;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpCadSocio;
    public javax.swing.JPanel jpDP;
    private javax.swing.JPanel jpDependentes;
    private javax.swing.JPanel jpFolha;
    private javax.swing.JPanel jpSitDP;
    private javax.swing.JTabbedPane jtbGuiaDP;
    private javax.swing.JLabel lbCadSocio;
    private javax.swing.JLabel lbCodDependentes;
    private javax.swing.JLabel lbCodFolha;
    private javax.swing.JLabel lbCodSocio;
    private javax.swing.JLabel lbControle;
    private javax.swing.JLabel lbDataDependetes;
    private javax.swing.JLabel lbDataFolha;
    private javax.swing.JLabel lbDataSocio;
    private javax.swing.JLabel lbDependentes;
    private javax.swing.JLabel lbObsDependentes;
    private javax.swing.JLabel lbObsFolha;
    private javax.swing.JLabel lbObsSocio;
    private javax.swing.JLabel lbTipoDependentes;
    private javax.swing.JLabel lbTipoFolha;
    private javax.swing.JLabel lbTipoSocio;
    private javax.swing.JLabel lbTitFaseDP;
    private javax.swing.JLabel lbTitStatusDP;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTable tbDependentes;
    private javax.swing.JTable tbFolha;
    private javax.swing.JTable tbSocio;
    public static javax.swing.JLabel txtAndamentoDP;
    private javax.swing.JTextField txtCodDependentes;
    private javax.swing.JTextField txtCodFolha;
    private javax.swing.JTextField txtCodSocio;
    public static javax.swing.JLabel txtCodigo;
    private javax.swing.JFormattedTextField txtDataDependentes;
    private javax.swing.JFormattedTextField txtDataFolha;
    private javax.swing.JFormattedTextField txtDataSocio;
    public static javax.swing.JLabel txtId;
    public static javax.swing.JLabel txtNome;
    private javax.swing.JTextArea txtObsDependentes;
    private javax.swing.JTextArea txtObsFolha;
    private javax.swing.JTextArea txtObsSocio;
    public static javax.swing.JLabel txtStatusDependentes;
    public static javax.swing.JLabel txtStatusFolha;
    public static javax.swing.JLabel txtStatusSocio;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    public void preencher_tabela_socio(){
        tbSocio.getColumnModel().getColumn(0);
        tbSocio.getColumnModel().getColumn(1);
        tbSocio.getColumnModel().getColumn(2);
        tbSocio.getColumnModel().getColumn(3);
        tbSocio.getColumnModel().getColumn(4);
        tbSocio.getColumnModel().getColumn(5);
        con_socio.executeSQL("select * from cadastrosocioadmcontrol WHERE NumeroProcesso='"+processo+"'");
        

        DefaultTableModel modelo = (DefaultTableModel)tbSocio.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con_socio.resultset.next())
                modelo.addRow(new Object [] {
                    con_socio.resultset.getString("CodCadastroSocioADMControl"),
                    sdf.format(con_socio.resultset.getTime("DatadeCadastroAndamento")),
                    con_socio.resultset.getString("NumeroProcesso"),
                    con_socio.resultset.getString("Obsevacao"),
                    con_socio.resultset.getString("AndamentoCadastroSocioADMControl"),
                    con_socio.resultset.getString("Usuario")});
            con_socio.resultset.first();
        }   catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Socio " +erro);
    }
}
    public void preencher_tabela_dependentes(){
        tbDependentes.getColumnModel().getColumn(0);
        tbDependentes.getColumnModel().getColumn(1);
        tbDependentes.getColumnModel().getColumn(2);
        tbDependentes.getColumnModel().getColumn(3);
        tbDependentes.getColumnModel().getColumn(4);
        tbDependentes.getColumnModel().getColumn(5);
        con_dependentes.executeSQL("select * from cadastrodosdependentesdosociaadm WHERE NumeroProcesso='"+processo+"'");
        //
        DefaultTableModel modelo = (DefaultTableModel)tbDependentes.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con_dependentes.resultset.next())
                modelo.addRow(new Object [] {
                    con_dependentes.resultset.getString("CodCadastroDependentesSocioADM"),
                    sdf.format(con_dependentes.resultset.getTime("DatadeCadastroAndamento")),
                    con_dependentes.resultset.getString("NumeroProcesso"),
                    con_dependentes.resultset.getString("Obsevacao"),
                    con_dependentes.resultset.getString("AndamentoCadastroDependentesSocioADM"),
                    con_dependentes.resultset.getString("Usuario")});
            con_dependentes.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Dependentes "+erro);
        }
    }
    public void preencher_tabela_folha(){
        tbFolha.getColumnModel().getColumn(0);
        tbFolha.getColumnModel().getColumn(1);
        tbFolha.getColumnModel().getColumn(2);
        tbFolha.getColumnModel().getColumn(3);
        tbFolha.getColumnModel().getColumn(4);
        tbFolha.getColumnModel().getColumn(5);
        con_folha.executeSQL("select * from implantardadosfolhapg where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbFolha.getModel();
        
        try{
            while(con_folha.resultset.next())
                modelo.addRow(new Object [] {
                    con_folha.resultset.getString("CodImplantarDadosFolhaPG"),
                    sdf.format(con_folha.resultset.getString("DatadeCadastroAndamento")),
                    con_folha.resultset.getString("NumeroProcesso"),
                    con_folha.resultset.getString("Obsevacao"),
                    con_folha.resultset.getString("AndamentoImplantarDadosFolhaPG"),
                    con_folha.resultset.getString("Usuario")});
            con_folha.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Folha " +erro);
        }
    }
    public void limpar_tabela_socio(){
        DefaultTableModel tbm = (DefaultTableModel)tbSocio.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void limpar_tabela_dependentes(){
        DefaultTableModel tbm = (DefaultTableModel)tbDependentes.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void limpar_tabela_folha(){
        DefaultTableModel tbm = (DefaultTableModel)tbFolha.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void preencher_status(){
        try{
            String sql = "select * from dp WHERE Numerodoprocesso='"+processo+"'";
            con_dp.executeSQL(sql);
            con_dp.resultset.first();
            
            socio = con_dp.resultset.getString("AndamentoCadastroDoSocioNoControl");
            dependentes = con_dp.resultset.getString("AndamentoCadastroDependentesdoSocioADM");
            folha = con_dp.resultset.getString("AndamentoIplantacaodadosFolhaPg");
            
            txtStatusSocio.setText(socio);
            txtStatusDependentes.setText(dependentes);
            txtStatusFolha.setText(folha);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao preencher status!" +erro);
        }
    }
    public void atualizar_cadastro_cliente(){
        
        if(txtStatusSocio.getText().equalsIgnoreCase("Em Aberto") &&
                txtStatusDependentes.getText().equalsIgnoreCase("Em Aberto") &&
                txtStatusFolha.getText().equalsIgnoreCase("Em Aberto")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoDP='' where codNumerodoprocesso=" +processo;
                    con_dp.statement.executeUpdate(sql);

                    String andamento = "Não Iniciado";
                    txtAndamentoDP.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" +erro);
                }
        }
        else if(txtStatusSocio.getText().equalsIgnoreCase("Em Aberto") ||
                txtStatusDependentes.getText().equalsIgnoreCase("Em Aberto") ||
                txtStatusFolha.getText().equalsIgnoreCase("Em Aberto")){
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoDP='Em Aberto' where codNumerodoprocesso=" +processo;
                    con_dp.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txtAndamentoDP.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" +erro);
                }
        }
        else if(txtStatusSocio.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusDependentes.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusFolha.getText().equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoDP='Finalizado' where codNumerodoprocesso="+processo;
                    con_dp.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txtAndamentoDP.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" +erro);
                }
        }
        distribuir_cores();
    }
    public void distribuir_cores(){
        if(txtStatusSocio.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusSocio.setBackground(Color.red);
        }
        else{
            txtStatusSocio.setBackground(Color.green);
        }
        if(txtStatusDependentes.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusDependentes.setBackground(Color.red);
        }
        else{
            txtStatusDependentes.setBackground(Color.green);
        }
        if(txtStatusFolha.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusFolha.setBackground(Color.red);
        }
        else{
            txtStatusFolha.setBackground(Color.green);    
            }
        if(txtAndamentoDP.getText().equalsIgnoreCase("Concluido")){
            txtAndamentoDP.setBackground(Color.green);
        }
        else if(txtAndamentoDP.getText().equalsIgnoreCase("Em Andamento")){
            txtAndamentoDP.setBackground(Color.orange);
        }
        else{
            txtAndamentoDP.setBackground(Color.red);
        }
    }
    public void limpar_tela_socio(){
        txtCodSocio.setText("");
        txtObsSocio.setText("");
        txtCodSocio.setEditable(false);
        cbTipoSocio.setSelectedItem("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataSocio.setText(datahoje);
        
    }
    public void limpar_tela_dependentes(){
        txtCodDependentes.setEditable(false);
        txtCodDependentes.setText("");
        cbTipoDependentes.setSelectedItem("");
        txtObsDependentes.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataDependentes.setText(datahoje);
    }
    public void limpar_tela_folha(){
        txtCodFolha.setEditable(false);
        txtCodFolha.setText("");
        cbTipoFolha.setSelectedItem("");
        txtObsFolha.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataFolha.setText(datahoje);
    }

    public void atualizar_socios(){
        if(cbTipoSocio.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE dp set AndamentoCadastroDoSocioNoControl='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_dp.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Planilha\n" +erro);
                    }
        }
        else{
            try{
                con_dp.executeSQL("select * from dp where Numerodoprocesso='" +processo+"' and AndamentoCadastroDoSocioNoControl ='Finalizado'");
                if(con_dp.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_dp.executeSQL("select * from cadastrosocioadmcontrol  where NumeroProcesso='"+processo+"'and AndamentoCadastroSocioADMControl='Finalizado'");
                    
                    if(!con_dp.resultset.first()){
                        try{
                
                        String sql = "UPDATE dp set AndamentoCadastroDoSocioNoControl='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_dp.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Planilha\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE dp set AndamentoCadastroDoSocioNoControl ='Em Aberto' where Numerodoprocesso='" +txtCodigo.getText()+"'";
                        con_dp.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Financeiro>Planilha:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Financeiro>Planilha: \n" +erro);
            }
                    
        }
    }
    public void atualizar_dependentes(){
        if(cbTipoDependentes.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE dp set AndamentoCadastroDependentesdoSocioADM='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_dp.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Pessoal>Dependentes\n" +erro);
                    }
        }
        else{
            try{
                con_dp.executeSQL("select * from dp where Numerodoprocesso='" +processo+"' and AndamentoCadastroDependentesdoSocioADM ='Finalizado'");
                if(con_dp.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_dp.executeSQL("select * from cadastrodosdependentesdosociaadm where NumeroProcesso='"+processo+"'and AndamentoCadastroDependentesSocioADM='Finalizado'");
                    
                    if(!con_dp.resultset.first()){
                        try{
                
                        String sql = "UPDATE dp set AndamentoCadastroDependentesdoSocioADM='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_dp.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Pessoal>Dependentes\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE dp set AndamentoCadastroDependentesdoSocioADM ='Em Aberto' where Numerodoprocesso='" +txtCodigo.getText()+"'";
                        con_dp.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Pessoal>Dependentes\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Pessoal>Dependentes\n" +erro);
            }
                    
        }
    }
    public void atualizar_folha(){
        if(cbTipoFolha.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE dp set AndamentoIplantacaodadosFolhaPg='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_dp.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Pessoal>Folha\n" +erro);
                    }
        }
        else{
            try{
                con_dp.executeSQL("select * from dp where Numerodoprocesso='" +processo+"' and AndamentoIplantacaodadosFolhaPg ='Finalizado'");
                if(con_dp.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_dp.executeSQL("select * from implantardadosfolhapg where NumeroProcesso='"+processo+"'and AndamentoImplantarDadosFolhaPG='Finalizado'");
                    
                    if(!con_dp.resultset.first()){
                        try{
                
                        String sql = "UPDATE dp set AndamentoIplantacaodadosFolhaPg='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_dp.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Pessoal>Folha\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE dp set AndamentoIplantacaodadosFolhaPg ='Em Aberto' where Numerodoprocesso='" +txtCodigo.getText()+"'";
                        con_dp.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Pessoal>Folha\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Pessoal>Folha\n" +erro);
            }
                    
        }
    }
    public void bloquear_tela_dependentes(){
        txtCodDependentes.setEditable(false);
        txtDataDependentes.setEditable(false);
        cbTipoDependentes.setEditable(false);
        txtObsDependentes.setEditable(false);
    }

    public void desbloquear_tela_dependentes(){
        txtDataDependentes.setEditable(true);
        cbTipoDependentes.setEditable(true);
        txtObsDependentes.setEditable(true);
    }
    public void bloquear_tela_socio(){
        txtCodSocio.setEditable(false);
        txtDataSocio.setEditable(false);
        cbTipoSocio.setEditable(false);
        txtObsSocio.setEditable(false);
    }

    public void desbloquear_tela_socio(){
        txtDataSocio.setEditable(true);
        cbTipoSocio.setEditable(true);
        txtObsSocio.setEditable(true);
    }
    public void bloquear_tela_folha(){
        txtCodFolha.setEditable(false);
        txtDataFolha.setEditable(false);
        cbTipoFolha.setEditable(false);
        txtObsFolha.setEditable(false);
    }

    public void desbloquear_tela_folha(){
        txtDataFolha.setEditable(true);
        cbTipoFolha.setEditable(true);
        txtObsFolha.setEditable(true);
    }
    public void criar_backup_socio(){
        codSocio_backup = txtCodSocio.getText();
        tipoSocio_backup = (String)cbTipoSocio.getSelectedItem();
        dataSocio_backup = txtDataSocio.getText();
        obsSocio_backup = txtObsSocio.getText();
    }
    public void restaurar_backup_socio(){
        txtCodSocio.setText(codSocio_backup);
        cbTipoSocio.setSelectedItem(tipoSocio_backup);
        txtDataSocio.setText(dataSocio_backup);
        txtObsSocio.setText(obsSocio_backup);
    }
    public void criar_backup_dependentes(){
        codDep_backup = txtCodDependentes.getText();
        tipoDep_backup = (String)cbTipoDependentes.getSelectedItem();
        dataDep_backup = txtDataDependentes.getText();
        obsDep_backup = txtObsDependentes.getText();
    }
    public void restaurar_backup_dependentes(){
        txtCodDependentes.setText(codDep_backup);
        cbTipoDependentes.setSelectedItem(tipoDep_backup);
        txtDataDependentes.setText(dataDep_backup);
        txtObsDependentes.setText(obsDep_backup);
    }
    public void criar_backup_folha(){
        codFolha_backup = txtCodFolha.getText();
        tipoFolha_backup = (String)cbTipoFolha.getSelectedItem();
        dataFolha_backup = txtDataFolha.getText();
        obsFolha_backup = txtObsFolha.getText();
    }
    public void restaurar_backup_folha(){
        txtCodFolha.setText(codFolha_backup);
        cbTipoFolha.setSelectedItem(tipoFolha_backup);
        txtDataFolha.setText(dataFolha_backup);
        txtObsFolha.setText(obsFolha_backup);
    }
}