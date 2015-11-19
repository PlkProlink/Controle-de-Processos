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

import br.com.prolink.inicio.*;
/**
 *
 * @author User
 */
public class Fiscal extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con_fiscal, con_distribuir, con_perfil;
    //maskara para o JFormattedTextField
    MaskFormatter formatoPerfil, formatoDistribuir;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String perfil, distribuir, usuario = Login.usuario,
            processo=Ativador.processo, nome=Ativador.nome, id=Ativador.id,
           codPerfil_backup, codDist_backup, dataDist_backup, dataPerfil_backup,
           obsPerfil_backup, obsDist_backup, tipoPerfil_backup, tipoDist_backup;
    
    /**
     *
     */
    public Fiscal() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        con_distribuir = new Conexao();
        con_distribuir.conecta();
        
        con_perfil = new Conexao();
        con_perfil.conecta();
        
        con_fiscal = new Conexao();
        con_fiscal.conecta();
        
        //chamando metodo que preencha as tabelas
        preencher_jtable_perfil();
        preencher_jtable_distribuir();
        
        bloquear_tela_perfil();
        bloquear_tela_distribuir();
        //chamando metodo que preencha tela de status
        preencher_status();
        atualiza_cadastrocliente();
        limpar_tela_distribuir();
        limpar_tela_perfil();
        
        txt_codigo.setText(processo);
        txt_id.setText(id);
        txt_nome.setText(nome);
        txt_usuario.setText(usuario);
        
        tb_perfil.setAutoCreateRowSorter(true);
        tb_distribuir.setAutoCreateRowSorter(true);

        if(!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Fiscal")){
            
            bt_excluir_distribuir.setEnabled(false);
            btnSalvarDistribuir.setEnabled(false);
            btExcluirPerfil.setEnabled(false);
            btnSalvarPerfil.setEnabled(false);
            
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
        jpSitFisc = new javax.swing.JPanel();
        lbTitFaseFiscal = new javax.swing.JLabel();
        lbTitStatusFiscal = new javax.swing.JLabel();
        lb_distribuir = new javax.swing.JLabel();
        lb_validar = new javax.swing.JLabel();
        txt_status_perfil = new javax.swing.JLabel();
        txt_status_distribuir = new javax.swing.JLabel();
        txt_andamento_fiscal = new javax.swing.JLabel();
        jpPerfil = new javax.swing.JPanel();
        lbcod_perfil = new javax.swing.JLabel();
        txt_cod_perfil = new javax.swing.JTextField();
        lb_andamento_perfil = new javax.swing.JLabel();
        lb_obs_perfil = new javax.swing.JLabel();
        try {
     formatoPerfil = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local Perfil: " +erro);
 }
        txt_data_perfil = new JFormattedTextField(formatoPerfil);
        lb_tipo_perfil = new javax.swing.JLabel();
        cb_tipo_perfil = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txt_obs_perfil = new javax.swing.JTextArea();
        btCancelarPerfil = new javax.swing.JButton();
        btnSalvarPerfil = new javax.swing.JButton();
        bt_alterar_perfil = new javax.swing.JButton();
        btExcluirPerfil = new javax.swing.JButton();
        btnFecharPerfil = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tb_perfil = new javax.swing.JTable();
        btNovoPerfil = new javax.swing.JButton();
        jpDistribuir = new javax.swing.JPanel();
        lbcod_distribuir = new javax.swing.JLabel();
        txt_cod_distribuir = new javax.swing.JTextField();
        lb_data_distribuir = new javax.swing.JLabel();
        try {
            formatoDistribuir = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em Distribuir: " +erro);
        }
        txt_data_distribuir = new JFormattedTextField(formatoDistribuir);
        lb_tipo_distribuir = new javax.swing.JLabel();
        cb_tipo_distribuir = new javax.swing.JComboBox();
        lb_obs_distribuir = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_obs_distribuir = new javax.swing.JTextArea();
        btnSalvarDistribuir = new javax.swing.JButton();
        btnAlterarDist = new javax.swing.JButton();
        btnCancelarDistribuir = new javax.swing.JButton();
        bt_excluir_distribuir = new javax.swing.JButton();
        bt_fechar_distribuir = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_distribuir = new javax.swing.JTable();
        btnNovoDist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle Fiscal");

        jpFiscal.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Fiscal");
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

        jpSitFisc.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFaseFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFaseFiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFaseFiscal.setText("Fase:");

        lbTitStatusFiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatusFiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatusFiscal.setText("Status:");

        lb_distribuir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_distribuir.setText("Distribuir para Funcionario Responsavel:");

        lb_validar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_validar.setText("Validar Perfil Fiscal:");

        txt_status_perfil.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_perfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_perfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_perfil.setOpaque(true);

        txt_status_distribuir.setBackground(new java.awt.Color(245, 245, 245));
        txt_status_distribuir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_status_distribuir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_status_distribuir.setOpaque(true);

        txt_andamento_fiscal.setBackground(new java.awt.Color(245, 245, 245));
        txt_andamento_fiscal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_andamento_fiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_andamento_fiscal.setToolTipText("");
        txt_andamento_fiscal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_andamento_fiscal.setOpaque(true);

        javax.swing.GroupLayout jpSitFiscLayout = new javax.swing.GroupLayout(jpSitFisc);
        jpSitFisc.setLayout(jpSitFiscLayout);
        jpSitFiscLayout.setHorizontalGroup(
            jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitFiscLayout.createSequentialGroup()
                .addGroup(jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitFiscLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(lbTitFaseFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(lbTitStatusFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitFiscLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(txt_andamento_fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitFiscLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitFiscLayout.createSequentialGroup()
                                .addComponent(lb_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addGroup(jpSitFiscLayout.createSequentialGroup()
                                .addComponent(lb_validar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)))
                        .addGroup(jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_status_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txt_status_distribuir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(60, 60, 60))
        );
        jpSitFiscLayout.setVerticalGroup(
            jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitFiscLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitFaseFiscal)
                    .addComponent(lbTitStatusFiscal))
                .addGap(12, 12, 12)
                .addGroup(jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_status_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpSitFiscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_validar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitFiscLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_status_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(194, 194, 194)
                .addComponent(txt_andamento_fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaFiscal.addTab("Situação", jpSitFisc);

        jpPerfil.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_perfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_perfil.setText("Cod:");

        lb_andamento_perfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_andamento_perfil.setText("Data:");

        lb_obs_perfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_perfil.setText("Observação:");

        lb_tipo_perfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_perfil.setText("Tipo:");

        cb_tipo_perfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        txt_obs_perfil.setColumns(20);
        txt_obs_perfil.setLineWrap(true);
        txt_obs_perfil.setRows(5);
        jScrollPane9.setViewportView(txt_obs_perfil);

        btCancelarPerfil.setText("Cancelar");
        btCancelarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarPerfilActionPerformed(evt);
            }
        });

        btnSalvarPerfil.setText("Salvar");
        btnSalvarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPerfilActionPerformed(evt);
            }
        });

        bt_alterar_perfil.setText("Alterar");
        bt_alterar_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterar_perfilActionPerformed(evt);
            }
        });

        btExcluirPerfil.setText("Excluir");
        btExcluirPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirPerfilActionPerformed(evt);
            }
        });

        btnFecharPerfil.setText("Fechar");
        btnFecharPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharPerfilActionPerformed(evt);
            }
        });

        tb_perfil.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_perfilMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tb_perfil);

        btNovoPerfil.setText("Novo");
        btNovoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPerfilLayout = new javax.swing.GroupLayout(jpPerfil);
        jpPerfil.setLayout(jpPerfilLayout);
        jpPerfilLayout.setHorizontalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_perfil)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_andamento_perfil)
                .addGap(111, 111, 111)
                .addComponent(txt_data_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_perfil)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_perfil)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btNovoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_alterar_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btCancelarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExcluirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFecharPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpPerfilLayout.setVerticalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_perfil))
                    .addComponent(txt_cod_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_andamento_perfil))
                    .addComponent(txt_data_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_perfil))
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_perfil)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt_alterar_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCancelarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnFecharPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtbGuiaFiscal.addTab("Validar Perfil Fiscal", jpPerfil);

        jpDistribuir.setBackground(new java.awt.Color(245, 245, 245));

        lbcod_distribuir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbcod_distribuir.setText("Cod:");

        lb_data_distribuir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_data_distribuir.setText("Data:");

        lb_tipo_distribuir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_tipo_distribuir.setText("Tipo:");

        cb_tipo_distribuir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));

        lb_obs_distribuir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_obs_distribuir.setText("Observação:");

        txt_obs_distribuir.setColumns(20);
        txt_obs_distribuir.setLineWrap(true);
        txt_obs_distribuir.setRows(5);
        jScrollPane7.setViewportView(txt_obs_distribuir);

        btnSalvarDistribuir.setText("Salvar");
        btnSalvarDistribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDistribuirActionPerformed(evt);
            }
        });

        btnAlterarDist.setText("Alterar");
        btnAlterarDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDistActionPerformed(evt);
            }
        });

        btnCancelarDistribuir.setText("Cancelar");
        btnCancelarDistribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDistribuirActionPerformed(evt);
            }
        });

        bt_excluir_distribuir.setText("Excluir");
        bt_excluir_distribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluir_distribuirActionPerformed(evt);
            }
        });

        bt_fechar_distribuir.setText("Fechar");
        bt_fechar_distribuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fechar_distribuirActionPerformed(evt);
            }
        });

        tb_distribuir.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_distribuir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_distribuirMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_distribuir);

        btnNovoDist.setText("Novo");
        btnNovoDist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDistribuirLayout = new javax.swing.GroupLayout(jpDistribuir);
        jpDistribuir.setLayout(jpDistribuirLayout);
        jpDistribuirLayout.setHorizontalGroup(
            jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDistribuirLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbcod_distribuir)
                .addGap(115, 115, 115)
                .addComponent(txt_cod_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpDistribuirLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_data_distribuir)
                .addGap(111, 111, 111)
                .addComponent(txt_data_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lb_tipo_distribuir)
                .addGap(18, 18, 18)
                .addComponent(cb_tipo_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpDistribuirLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_obs_distribuir)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpDistribuirLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btnNovoDist, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterarDist, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnSalvarDistribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarDistribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_excluir_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_fechar_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpDistribuirLayout.setVerticalGroup(
            jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDistribuirLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDistribuirLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbcod_distribuir))
                    .addComponent(txt_cod_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDistribuirLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_data_distribuir))
                    .addComponent(txt_data_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDistribuirLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lb_tipo_distribuir))
                    .addGroup(jpDistribuirLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cb_tipo_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_obs_distribuir)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovoDist, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpDistribuirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarDistribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvarDistribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarDist, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_excluir_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_fechar_distribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpDistribuirLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_cod_distribuir, txt_data_distribuir});

        jtbGuiaFiscal.addTab("Distribuir para Responsável", jpDistribuir);

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

    private void bt_excluir_distribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluir_distribuirActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_distribuir.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
            return;
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from distribuirfuncionariointerno where CodDistribuirFuncionarioInterno= "+txt_cod_distribuir.getText();
                con_distribuir.executeSQL(sql);
                con_distribuir.resultset.first();
                String operacao = con_distribuir.resultset.getString("Tipo");
                String cliente = "Tem certeza que deseja excluir um cadastro da tabela Distribuição com cliente : " +con_perfil.resultset.getString("Cliente")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM distribuirfuncionariointerno Where CodDistribuirFuncionarioInterno="+txt_cod_distribuir.getText();
                    int conseguiu_excluir = con_distribuir.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        if("Finalizado".equalsIgnoreCase(operacao)){
                            try{
                                con_distribuir.executeSQL("select * from distribuirfuncionariointerno where Numerodoprocesso='"+processo+"' and Tipo='Finalizado'");
                                if(!con_distribuir.resultset.first()){
                                    try{
                                        con_fiscal.statement.executeUpdate("UPDATE fiscal set AndamenoDistribuirFuncionarioInterno='Em Aberto' where Numerodoprocesso='" +processo+"'");

                                        limpar_tabela_distribuir();
                                        preencher_jtable_distribuir();
                                        limpar_tela_distribuir();
                                        preencher_status();
                                        atualiza_cadastrocliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar o status em Distribuir: \n" +erro);
                                    }
                                }
                            }catch(SQLException erro){
                                JOptionPane.showMessageDialog(null, "Falha ao buscar o status em Distribuir: \n" +erro);
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro: /n"+erro);
            }
        }
    }//GEN-LAST:event_bt_excluir_distribuirActionPerformed

    private void btnCancelarDistribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDistribuirActionPerformed
        restaurar_backup_distribuir();
        bloquear_tela_distribuir();
        
    }//GEN-LAST:event_btnCancelarDistribuirActionPerformed

    private void btnAlterarDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDistActionPerformed
        criar_backup_distribuir();
        desbloquear_tela_distribuir();
        
    }//GEN-LAST:event_btnAlterarDistActionPerformed

    private void bt_fechar_distribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fechar_distribuirActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fechar_distribuirActionPerformed

    private void btnSalvarDistribuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDistribuirActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_distribuir.getText().equals("  /  /    ") || txt_data_distribuir.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cb_tipo_distribuir.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_distribuir.requestFocus();
        }
        else if(!txt_cod_distribuir.getText().isEmpty()){
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
                "Usuario= '"+usuario+"',"+
                "AndamentoDistribuirFuncionarioInterno='"+andamento+"',"+
                "Tipo='"+cb_tipo_distribuir.getSelectedItem()+"' "+
                "where CodDistribuirFuncionarioInterno = "+txt_cod_distribuir.getText();

                con_distribuir.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                

                atualiza_fiscal_distribuir();
                preencher_status();
                atualiza_cadastrocliente();
                limpar_tabela_distribuir();
                preencher_jtable_distribuir();    
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Termo: \n " +erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_distribuir.getText().equals("")){
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
                nome+"','"+
                usuario+"','"+
                andamentoarquivo+"','"+
                cb_tipo_distribuir.getSelectedItem()+"')";

                con_distribuir.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                atualiza_fiscal_distribuir();
                preencher_status();
                atualiza_cadastrocliente();
                limpar_tabela_distribuir();
                preencher_jtable_distribuir();
            }catch(ParseException | HeadlessException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Arquivo: "+erro);
            }
        }
    }//GEN-LAST:event_btnSalvarDistribuirActionPerformed

    private void btExcluirPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirPerfilActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txt_cod_perfil.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from validarprefilfiscal where CodValidarPerfilFiscal= "+txt_cod_perfil.getText();
                con_perfil.executeSQL(sql);
                con_perfil.resultset.first();
                String operacao = con_perfil.resultset.getString("Tipo");
                String cliente = "Tem certeza que deseja excluir um cadastro da tabela Perfil com cliente : " +con_perfil.resultset.getString("Cliente")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){
                    sql = "DELETE FROM validarprefilfiscal Where CodValidarPerfilFiscal = "+txt_cod_perfil.getText();
                    int conseguiu_excluir = con_perfil.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        if("Finalizado".equalsIgnoreCase(operacao)){
                            try{
                                con_perfil.executeSQL("select * validarprefilfiscal where NumeroProcesso='"+processo+"' and Tipo='Finalizado'");
                                if(!con_perfil.resultset.first()){
                                    try{
                                    con_fiscal.statement.executeUpdate("UPDATE fiscal set AndamentoValidarPerfilFiscal='Em Aberto' where Numerodoprocesso='" +processo+"'");

                                    limpar_tela_perfil();
                                    limpar_tabela_perfil();
                                    preencher_jtable_perfil();
                                    preencher_status();
                                    atualiza_cadastrocliente();
                                    
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar o status do processo em Perfil Fiscal:\n " +erro);
                                    }
                                }
                            }catch(SQLException erro){
                                 JOptionPane.showMessageDialog(null, "Falha ao abrir o status do processo em Perfil Fiscal:\n " +erro);
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro");
            }
        }

    }//GEN-LAST:event_btExcluirPerfilActionPerformed

    private void bt_alterar_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterar_perfilActionPerformed
        criar_backup_perfil();
        desbloquear_tela_perfil();
    }//GEN-LAST:event_bt_alterar_perfilActionPerformed

    private void btnSalvarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPerfilActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txt_data_perfil.getText().equals("  /  /    ") || txt_data_perfil.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cb_tipo_perfil.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
            cb_tipo_perfil.requestFocus();
        }
        //evitando erros com cadastro ja salvo antes
        else if(txt_cod_perfil.getText().equals("")){
            try{
                //convertendo a primeira data
                String dataandamento = txt_data_perfil.getText();
                Date dataperfil = sdf.parse(dataandamento);

                String andamentotermo;
                if(cb_tipo_perfil.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                }
                else{
                    andamentotermo = "Em Aberto";
                }

                    String gry = "insert into validarprefilfiscal ("+
                    "NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"+
                    "Cliente, Usuario, AndamentoValidarPerfilFiscal, Tipo) values ('"+processo+"','"+
                    new java.sql.Date(dataperfil.getTime())+"','"+
                    txt_obs_perfil.getText()+"','"+
                    nome+"','"+
                    usuario+"','"+
                    andamentotermo+"','"+
                    cb_tipo_perfil.getSelectedItem()+"')";

                    con_perfil.exeQuery(gry);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                    atualiza_fiscal_perfil();
                    preencher_status();
                    atualiza_cadastrocliente();
                    limpar_tabela_perfil();
                    preencher_jtable_perfil();
                    
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Termo: "+add);
            }
        }
        else if(!txt_cod_perfil.getText().equals("")){
            try{
                //convertendo a primeira data
                String dataandamento = txt_data_perfil.getText();
                Date dataperfil = sdf.parse(dataandamento);

                String andamentotermo;
                if(cb_tipo_perfil.getSelectedItem().equals("Finalizado")){
                    andamentotermo = "Finalizado";
                }
                else{
                    andamentotermo = "Em Aberto";
                }
                    String sql = "UPDATE validarprefilfiscal set DatadeCadastroAndamento='"+
                    new java.sql.Date(dataperfil.getTime())+"',"+
                    "Obsevacao='"+txt_obs_perfil.getText()+"',"+
                    "Cliente='"+nome+"',"+
                    "Usuario='"+usuario+"',"+
                    "AndamentoValidarPerfilFiscal='"+andamentotermo+"',"+
                    "Tipo"+cb_tipo_perfil.getSelectedItem()+"'"+
                    "where NumeroProcesso="+processo;
                    con_perfil.statement.executeUpdate(sql);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                    atualiza_fiscal_perfil();
                    preencher_status();
                    atualiza_cadastrocliente();
                    limpar_tabela_perfil();
                    preencher_jtable_perfil();
                    
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Perfil: "+erro);
            }catch(ParseException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Perfil (Campo data) "+erro);
            }
        }
    }//GEN-LAST:event_btnSalvarPerfilActionPerformed

    private void btnFecharPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPerfilActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharPerfilActionPerformed
    
    private void btCancelarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarPerfilActionPerformed
        restaurar_backup_perfil();
        limpar_tela_perfil();
    }//GEN-LAST:event_btCancelarPerfilActionPerformed

    private void tb_perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_perfilMouseClicked
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
        
        
        
    }//GEN-LAST:event_tb_perfilMouseClicked

    private void tb_distribuirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_distribuirMouseClicked
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
    }//GEN-LAST:event_tb_distribuirMouseClicked

    private void btNovoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoPerfilActionPerformed
        criar_backup_perfil();
        limpar_tela_perfil();
        desbloquear_tela_perfil();
    }//GEN-LAST:event_btNovoPerfilActionPerformed

    private void btnNovoDistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDistActionPerformed
        criar_backup_distribuir();
        limpar_tela_distribuir();
        desbloquear_tela_distribuir();
    }//GEN-LAST:event_btnNovoDistActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            Fiscal reg = new Fiscal();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelarPerfil;
    private javax.swing.JButton btExcluirPerfil;
    private javax.swing.JButton btNovoPerfil;
    private javax.swing.JButton bt_alterar_perfil;
    private javax.swing.JButton bt_excluir_distribuir;
    private javax.swing.JButton bt_fechar_distribuir;
    private javax.swing.JButton btnAlterarDist;
    private javax.swing.JButton btnCancelarDistribuir;
    private javax.swing.JButton btnFecharPerfil;
    private javax.swing.JButton btnNovoDist;
    private javax.swing.JButton btnSalvarDistribuir;
    private javax.swing.JButton btnSalvarPerfil;
    private javax.swing.JComboBox cb_tipo_distribuir;
    private javax.swing.JComboBox cb_tipo_perfil;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpDistribuir;
    public javax.swing.JPanel jpFiscal;
    private javax.swing.JPanel jpPerfil;
    private javax.swing.JPanel jpSitFisc;
    private javax.swing.JTabbedPane jtbGuiaFiscal;
    private javax.swing.JLabel lbTitFaseFiscal;
    private javax.swing.JLabel lbTitStatusFiscal;
    private javax.swing.JLabel lb_andamento_perfil;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_data_distribuir;
    private javax.swing.JLabel lb_distribuir;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_obs_distribuir;
    private javax.swing.JLabel lb_obs_perfil;
    private javax.swing.JLabel lb_tipo_distribuir;
    private javax.swing.JLabel lb_tipo_perfil;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lb_validar;
    private javax.swing.JLabel lbcod_distribuir;
    private javax.swing.JLabel lbcod_perfil;
    private javax.swing.JTable tb_distribuir;
    private javax.swing.JTable tb_perfil;
    public static javax.swing.JLabel txt_andamento_fiscal;
    private javax.swing.JTextField txt_cod_distribuir;
    private javax.swing.JTextField txt_cod_perfil;
    public static javax.swing.JLabel txt_codigo;
    private javax.swing.JFormattedTextField txt_data_distribuir;
    private javax.swing.JFormattedTextField txt_data_perfil;
    public static javax.swing.JLabel txt_id;
    public static javax.swing.JLabel txt_nome;
    private javax.swing.JTextArea txt_obs_distribuir;
    private javax.swing.JTextArea txt_obs_perfil;
    public static javax.swing.JLabel txt_status_distribuir;
    public static javax.swing.JLabel txt_status_perfil;
    public static javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
        public void preencher_jtable_perfil(){
        tb_perfil.getColumnModel().getColumn(0);
        tb_perfil.getColumnModel().getColumn(1);
        tb_perfil.getColumnModel().getColumn(2);
        tb_perfil.getColumnModel().getColumn(3);
        tb_perfil.getColumnModel().getColumn(4);
        tb_perfil.getColumnModel().getColumn(5);
        con_perfil.executeSQL("select * from validarprefilfiscal where NumeroProcesso='"+processo+"' order by CodValidarPerfilFiscal");

        DefaultTableModel modelo = (DefaultTableModel)tb_perfil.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con_perfil.resultset.next())
                modelo.addRow(new Object [] {
                    con_perfil.resultset.getString("CodValidarPerfilFiscal"),
                    con_perfil.resultset.getString("NumeroProcesso"),
                    sdf.format(con_perfil.resultset.getTime("DatadeCadastroAndamento")),
                    con_perfil.resultset.getString("Tipo"),                    
                    con_perfil.resultset.getString("Obsevacao"),
                    con_perfil.resultset.getString("Usuario")});
            con_perfil.resultset.first();
        }   catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Perfil "+erro);
    }
}

    /**
     *
     */
    public void preencher_jtable_distribuir(){
        tb_distribuir.getColumnModel().getColumn(0);
        tb_distribuir.getColumnModel().getColumn(1);
        tb_distribuir.getColumnModel().getColumn(2);
        tb_distribuir.getColumnModel().getColumn(3);
        tb_distribuir.getColumnModel().getColumn(4);
        tb_distribuir.getColumnModel().getColumn(5);
        con_distribuir.executeSQL("select * from distribuirfuncionariointerno WHERE NumeroProcesso='"+processo+"' order by CodDistribuirFuncionarioInterno");
        //
        DefaultTableModel modelo = (DefaultTableModel)tb_distribuir.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con_distribuir.resultset.next())
                modelo.addRow(new Object [] {
                    con_distribuir.resultset.getString("CodDistribuirFuncionarioInterno"),
                    con_distribuir.resultset.getString("NumeroProcesso"),
                    sdf.format(con_distribuir.resultset.getTime("DatadeCadastroAndamento")),
                    con_distribuir.resultset.getString("Tipo"),
                    con_distribuir.resultset.getString("Obsevacao"),
                    con_distribuir.resultset.getString("Usuario")});
            con_distribuir.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na Tabela Responsavel "+erro);
        }
    }

    /**
     *
     */
    public void limpar_tabela_perfil(){
        DefaultTableModel tbm = (DefaultTableModel)tb_perfil.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    /**
     *
     */
    public void limpar_tabela_distribuir(){
        DefaultTableModel tbm = (DefaultTableModel)tb_distribuir.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    /**
     *
     */
    public void preencher_status(){
        try{
            String sql = "select * from fiscal WHERE Numerodoprocesso='"+processo+"'";
            con_fiscal.executeSQL(sql);
            con_fiscal.resultset.first();
            
            perfil = con_fiscal.resultset.getString("AndamentoValidarPerfilFiscal");
            distribuir = con_fiscal.resultset.getString("AndamenoDistribuirFuncionarioInterno");
            
            txt_status_perfil.setText(perfil);
            txt_status_distribuir.setText(distribuir);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao buscar tabela Fiscal!" +erro);
        }
    }

    /**
     *
     */
    public void atualiza_cadastrocliente(){
        if(txt_status_perfil.getText().equalsIgnoreCase("Finalizado") && txt_status_distribuir.getText().equalsIgnoreCase("Finalizado")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFiscal='Concluido' where codNumerodoprocesso="+processo;
                    con_fiscal.statement.executeUpdate(sql);

                    String andamento = "Concluido";
                    txt_andamento_fiscal.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }                      
        else if(txt_status_perfil.getText().equalsIgnoreCase("Em Aberto") && txt_status_distribuir.getText().equalsIgnoreCase("Em Aberto")){
                    String andamento = "Em Aberto";
                    txt_andamento_fiscal.setText(andamento);
        }
        else{
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoFiscal='Em Aberto' where codNumerodoprocesso=" +processo;
                    con_fiscal.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txt_andamento_fiscal.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!" +erro);
                }
        }
                
        distribuir_cores();
    }

    /**
     *
     */
    public void distribuir_cores(){
        if(txt_status_distribuir.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_distribuir.setBackground(Color.red);
        }
        else{
            txt_status_distribuir.setBackground(Color.green);
        }
        if(txt_status_perfil.getText().equalsIgnoreCase("Em Aberto")){
            txt_status_perfil.setBackground(Color.red);
        }
        else{
            txt_status_perfil.setBackground(Color.green);
        }
        if(txt_andamento_fiscal.getText().equalsIgnoreCase("Concluido")){
            txt_andamento_fiscal.setBackground(Color.green);
        }
        else if(txt_andamento_fiscal.getText().equalsIgnoreCase("Em Andamento")){
            txt_andamento_fiscal.setBackground(Color.orange);
        }
        else{
            txt_andamento_fiscal.setBackground(Color.red);
        }
    }

    /**
     *
     */
    public void limpar_tela_perfil(){
        txt_cod_perfil.setText("");
        txt_obs_perfil.setText("");
        txt_cod_perfil.setEditable(false);
        cb_tipo_perfil.setSelectedItem("Novo Andamento");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_perfil.setText(datahoje);
        
    }

    /**
     *
     */
    public void limpar_tela_distribuir(){
        txt_cod_distribuir.setEditable(false);
        txt_cod_distribuir.setText("");
        cb_tipo_distribuir.setSelectedItem("Novo Andamento");
        txt_obs_distribuir.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txt_data_distribuir.setText(datahoje);
    }

    /**
     *
     */
    public void atualiza_fiscal_distribuir(){
        if(cb_tipo_distribuir.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE fiscal set AndamenoDistribuirFuncionarioInterno ='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Distribuir a responsavel\n" +erro);
                    }
        }
        else{
            try{
                con_fiscal.executeSQL("select * from fiscal where Numerodoprocesso='" +processo+"' and AndamenoDistribuirFuncionarioInterno ='Finalizado'");
                if(con_fiscal.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados no painel Distribuição a Responsavel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_perfil.executeSQL("select * from DistribuirFuncionarioInterno where NumeroProcesso='"+processo+"'and AndamentoDistribuirFuncionarioInterno='Finalizado'");
                    
                    if(!con_perfil.resultset.last()){
                        try{
                
                        String sql = "UPDATE fiscal set AndamenoDistribuirFuncionarioInterno ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_fiscal.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Distribuição\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE fiscal set AndamenoDistribuirFuncionarioInterno ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Distribuir a responsavel\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na Tabela Fiscal>Distribuição: \n" +erro);
            }
                    
        }
    }

    /**
     *
     */
    public void atualiza_fiscal_perfil(){
        if(cb_tipo_perfil.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                    }
                }
        else{
            try{    
                    con_fiscal.executeSQL("select * from fiscal where Numerodoprocesso='" +processo+"' and AndamentoValidarPerfilFiscal ='Finalizado'");
                if(con_fiscal.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua todos os registros finalizados no painel Perfil Fiscal\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
                    con_perfil.executeSQL("select * from validarprefilfiscal where NumeroProcesso='"+processo+"'and AndamentoValidarPerfilFiscal='Finalizado'");
                    
                    if(!con_perfil.resultset.last()){
                        try{
                
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_fiscal.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                
                        String sql = "UPDATE fiscal set AndamentoValidarPerfilFiscal ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_fiscal.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Fiscal>Perfil Fiscal\n" +erro);
                    }
                         
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na Tabela Fiscal>Perfil Fiscal: \n" +erro);
            }
        }
    }

    /**
     *
     */
    public void criar_backup_perfil(){
        codPerfil_backup = txt_cod_perfil.getText();
        dataPerfil_backup = txt_data_perfil.getText();
        tipoPerfil_backup = (String)cb_tipo_perfil.getSelectedItem();
        obsPerfil_backup = txt_obs_perfil.getText();
    }

    /**
     *
     */
    public void restaurar_backup_perfil(){
        txt_cod_perfil.setText(codPerfil_backup);
        txt_data_perfil.setText(dataPerfil_backup);
        cb_tipo_perfil.setSelectedItem(tipoPerfil_backup);
        txt_obs_perfil.setText(obsPerfil_backup);
    }

    /**
     *
     */
    public void bloquear_tela_perfil(){
        txt_cod_perfil.setEditable(false);
        txt_data_perfil.setEditable(false);
        cb_tipo_perfil.setEditable(false);
        txt_obs_perfil.setEditable(false);
    }

    /**
     *
     */
    public void desbloquear_tela_perfil(){
        txt_cod_perfil.setEditable(false);
        txt_data_perfil.setEditable(true);
        cb_tipo_perfil.setEditable(true);
        txt_obs_perfil.setEditable(true);
    }
    
    /**
     *
     */
    public void criar_backup_distribuir(){
        codDist_backup = txt_cod_distribuir.getText();
        dataDist_backup = txt_data_distribuir.getText();
        tipoDist_backup = (String)cb_tipo_distribuir.getSelectedItem();
        obsDist_backup = txt_obs_distribuir.getText();
    }

    /**
     *
     */
    public void restaurar_backup_distribuir(){
        txt_cod_distribuir.setText(codDist_backup);
        txt_data_distribuir.setText(dataDist_backup);
        cb_tipo_distribuir.setSelectedItem(tipoDist_backup);
        txt_obs_distribuir.setText(obsDist_backup);
    }

    /**
     *
     */
    public void bloquear_tela_distribuir(){
        txt_cod_distribuir.setEditable(false);
        txt_data_distribuir.setEditable(false);
        cb_tipo_distribuir.setEditable(false);
        txt_obs_distribuir.setEditable(false);
    }

    /**
     *
     */
    public void desbloquear_tela_distribuir(){
        txt_cod_distribuir.setEditable(false);
        txt_data_distribuir.setEditable(true);
        cb_tipo_distribuir.setEditable(true);
        txt_obs_distribuir.setEditable(true);
    }
}