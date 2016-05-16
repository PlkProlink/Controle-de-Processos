package br.com.prolink.departamentos;

import br.com.prolink.login.Login;
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

public class Contratos extends javax.swing.JFrame {

    //conexão com as tabelas necessarias
    Conexao con_geral = new Conexao();
    Conexao con = new Conexao();
    
    MaskFormatter formatoId, formatoCadastro, formatoContrato, formatoRec, formatoAtivar, formatoPerfil;
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String gerarid, cadastro, contratos, receber, ativar, perfil,
            apelido_backup, codgerar_backup, datagerar_backup, obsgerar_backup, tipogerar_backup,
            codCad_backup, dataCad_backup, obsCad_backup, tipoCad_backup,
            codCont_backup, dataCont_backup, obsCont_backup, tipoCont_backup,
            codRec_backup, dataRec_backup, obsRec_backup, tipoRec_backup,
            codAtivar_backup, dataAtivar_backup, obsAtivar_backup, tipoAtivar_backup,
            codPerfil_backup, dataPerfil_backup, obsPerfil_backup, tipoPerfil_backup;

    String processo=TelaPrincipal.txt_codigo.getText(), nome=TelaPrincipal.txt_nome.getText(), id=TelaPrincipal.txt_id.getText(), usuario=Login.usuario;

    public Contratos() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        con_geral.conecta();
        con.conecta();
        
        apelido_backup = id;

        //chamando metodo que preencha as tabelas
        
        preencher_tabela_id();
        preencher_tabela_cadastro();
        preencher_tabela_perfil();
        preencher_tabela_contrato();
        preencher_tabela_receber();
        preencher_tabela_ativar();
        //chamando metodo que preencha tela de status
        preencher_status();
        atualizar_cadastro_cliente();

        bloquear_tela_id();
        bloquear_tela_cadastro();
        bloquear_tela_contrato();
        bloquear_tela_perfil();
        bloquear_tela_ativar();
        bloquear_tela_receber();

        limpar_tela_id();
        limpar_tela_cadastro();
        limpar_tela_contrato();
        limpar_tela_receber();
        limpar_tela_perfil();
        limpar_tela_ativar();

        txtIdApelido.setEditable(false);

        tbId.setAutoCreateRowSorter(true);
        tbCadastro.setAutoCreateRowSorter(true);
        tbContrato.setAutoCreateRowSorter(true);
        tbRec.setAutoCreateRowSorter(true);
        tbAtivar.setAutoCreateRowSorter(true);
        tbPerfil.setAutoCreateRowSorter(true);

        txtCodigo.setText(processo);
        txtNome.setText(nome);
        txtId.setText(id);
        txtUsuario.setText(usuario);

        if (!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Contratos")) {

            btnExcluirId.setEnabled(false);
            btnSalvarId.setEnabled(false);

            btnExcluirCadastro.setEnabled(false);
            btnSalvarCadastro.setEnabled(false);

            btnExcluirContrato.setEnabled(false);
            btnSalvarContrato.setEnabled(false);

            btnSalvarRec.setEnabled(false);
            btnExcluirRec.setEnabled(false);

            btnSalvarAtivar.setEnabled(false);
            btnExcluirAtivar.setEnabled(false);

            btnSalvarPerfil.setEnabled(false);
            btnExcluirPerfil.setEnabled(false);

            JOptionPane.showMessageDialog(null, "Você não tem permissão para editar os registros dessa tela!");
        }
        //chamando metodo que busca a data atual e envia para os campos de datas
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpComercial = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_cod = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        jtbGuia = new javax.swing.JTabbedPane();
        jpSit = new javax.swing.JPanel();
        lbTitFase = new javax.swing.JLabel();
        lbTitStatus = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        txtStatusId = new javax.swing.JLabel();
        lbCadastro = new javax.swing.JLabel();
        txtStatusCadastro = new javax.swing.JLabel();
        lbContrato = new javax.swing.JLabel();
        txtStatusContrato = new javax.swing.JLabel();
        txtStatusAtivar = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        txtStatusPerfil = new javax.swing.JLabel();
        lbRecContrato = new javax.swing.JLabel();
        txtStatusRecContratos = new javax.swing.JLabel();
        lbAtivar = new javax.swing.JLabel();
        txtAndamento = new javax.swing.JLabel();
        jpCadId = new javax.swing.JPanel();
        lbCodId = new javax.swing.JLabel();
        txtCodId = new javax.swing.JTextField();
        lbDataId = new javax.swing.JLabel();
        lbObsId = new javax.swing.JLabel();
        try {
     formatoId = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data: " +erro);
 }
        txtDataId = new JFormattedTextField(formatoId);
        lbTipoId = new javax.swing.JLabel();
        cbTipoId = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtObsId = new javax.swing.JTextArea();
        btnNovoId = new javax.swing.JButton();
        btnAlterarId = new javax.swing.JButton();
        btnSalvarId = new javax.swing.JButton();
        btnCancelarId = new javax.swing.JButton();
        btnExcluirId = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbId = new javax.swing.JTable();
        lbApelido = new javax.swing.JLabel();
        txtIdApelido = new javax.swing.JTextField();
        btnApelido = new javax.swing.JButton();
        jpCadastro = new javax.swing.JPanel();
        lbCodCadastro = new javax.swing.JLabel();
        txtCodCadastro = new javax.swing.JTextField();
        lbDataCadastro = new javax.swing.JLabel();
        try {
     formatoCadastro = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data: " +erro);
 }
        txtDataCadastro = new JFormattedTextField(formatoCadastro);
        lbTipoCadastro = new javax.swing.JLabel();
        cbTipoCadastro = new javax.swing.JComboBox();
        lbObsCadastro = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtObsCadastro = new javax.swing.JTextArea();
        btnNovoCadastro = new javax.swing.JButton();
        btnAlterarCadastro = new javax.swing.JButton();
        btnSalvarCadastro = new javax.swing.JButton();
        btnCancelarCadastro = new javax.swing.JButton();
        btnExcluirCadastro = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbCadastro = new javax.swing.JTable();
        jpContrato = new javax.swing.JPanel();
        lbCodContrato = new javax.swing.JLabel();
        txtCodContrato = new javax.swing.JTextField();
        lbDataContrato = new javax.swing.JLabel();
        try {
     formatoContrato = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data: " +erro);
 }
        txtDataContrato = new JFormattedTextField(formatoContrato);
        lbTipoContrato = new javax.swing.JLabel();
        cbTipoContrato = new javax.swing.JComboBox();
        lbObsContrato = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtObsContrato = new javax.swing.JTextArea();
        btnNovoContrato = new javax.swing.JButton();
        btnAlterarContrato = new javax.swing.JButton();
        btnSalvarContrato = new javax.swing.JButton();
        btnContrato = new javax.swing.JButton();
        btnExcluirContrato = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbContrato = new javax.swing.JTable();
        jpRecContrato = new javax.swing.JPanel();
        lbCodRec = new javax.swing.JLabel();
        txtCodRec = new javax.swing.JTextField();
        lbDataRec = new javax.swing.JLabel();
        lbObsRec = new javax.swing.JLabel();
        try {
     formatoRec = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data: " +erro);
 }
        txtDataRec = new JFormattedTextField(formatoRec);
        lbTipoRec = new javax.swing.JLabel();
        cbTipoRec = new javax.swing.JComboBox();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtObsRec = new javax.swing.JTextArea();
        btnNovoRec = new javax.swing.JButton();
        btnAlterarRec = new javax.swing.JButton();
        btnSalvarRec = new javax.swing.JButton();
        btnCancelarRec = new javax.swing.JButton();
        btnExcluirRec = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbRec = new javax.swing.JTable();
        jpAtivar = new javax.swing.JPanel();
        lbCodAtivar = new javax.swing.JLabel();
        txtCodAtivar = new javax.swing.JTextField();
        lbDataAtivar = new javax.swing.JLabel();
        lbObsAtivar = new javax.swing.JLabel();
        try {
     formatoAtivar = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
 }
        txtDataAtivar = new JFormattedTextField(formatoAtivar);
        lbTipoAtivar = new javax.swing.JLabel();
        cbTipoAtivar = new javax.swing.JComboBox();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtObsAtivar = new javax.swing.JTextArea();
        btnNovoAtivar = new javax.swing.JButton();
        btnAlterarAtivar = new javax.swing.JButton();
        btnSalvarAtivar = new javax.swing.JButton();
        btnCancelaAtivar = new javax.swing.JButton();
        btnExcluirAtivar = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbAtivar = new javax.swing.JTable();
        jpPerfil = new javax.swing.JPanel();
        lbCodPerfil = new javax.swing.JLabel();
        txtCodPerfil = new javax.swing.JTextField();
        lbDataPerfil = new javax.swing.JLabel();
        lbObsPerfil = new javax.swing.JLabel();
        try {
     formatoPerfil = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data: " +erro);
 }
        txtDataPerfil = new JFormattedTextField(formatoPerfil);
        lbTipoPerfil = new javax.swing.JLabel();
        cbTipoPerfil = new javax.swing.JComboBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtObsPerfil = new javax.swing.JTextArea();
        btnNovoPerfil = new javax.swing.JButton();
        btnAlterarPerfil = new javax.swing.JButton();
        btnSalvarPerfil = new javax.swing.JButton();
        btnCancelarPerfil = new javax.swing.JButton();
        btnExcluirPerfil = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbPerfil = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contratos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpComercial.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Contratos");
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

        jtbGuia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpSit.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFase.setText("Fase:");

        lbTitStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatus.setText("Status:");

        lbID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbID.setText("Gerar ID:");

        txtStatusId.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusId.setOpaque(true);

        lbCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCadastro.setText("Cadastro Control e Contmatic:");

        txtStatusCadastro.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusCadastro.setOpaque(true);

        lbContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbContrato.setText("Elaborar Contrato Prest.Serviço:");

        txtStatusContrato.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusContrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusContrato.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusContrato.setOpaque(true);

        txtStatusAtivar.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusAtivar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusAtivar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusAtivar.setOpaque(true);

        lbPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPerfil.setText("Elaborar Perfil Fiscal Cliente:");

        txtStatusPerfil.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusPerfil.setOpaque(true);

        lbRecContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbRecContrato.setText("Receber Contrato do Cliente:");

        txtStatusRecContratos.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusRecContratos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusRecContratos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusRecContratos.setOpaque(true);

        lbAtivar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAtivar.setText("Ativar Cliente:");

        txtAndamento.setBackground(new java.awt.Color(245, 245, 245));
        txtAndamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAndamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAndamento.setToolTipText("");
        txtAndamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAndamento.setOpaque(true);

        javax.swing.GroupLayout jpSitLayout = new javax.swing.GroupLayout(jpSit);
        jpSit.setLayout(jpSitLayout);
        jpSitLayout.setHorizontalGroup(
            jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addComponent(lbTitFase, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(lbTitStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitLayout.createSequentialGroup()
                            .addComponent(lbAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(121, 121, 121)
                            .addComponent(txtStatusAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpSitLayout.createSequentialGroup()
                            .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(txtStatusId, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitLayout.createSequentialGroup()
                            .addComponent(lbRecContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(txtStatusRecContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpSitLayout.createSequentialGroup()
                                .addComponent(lbCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(txtStatusCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpSitLayout.createSequentialGroup()
                                .addComponent(lbContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtStatusContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jpSitLayout.createSequentialGroup()
                            .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addComponent(txtStatusPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );
        jpSitLayout.setVerticalGroup(
            jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitFase)
                    .addComponent(lbTitStatus))
                .addGap(12, 12, 12)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRecContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusRecContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addComponent(txtAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jtbGuia.addTab("Situação", jpSit);

        jpCadId.setBackground(new java.awt.Color(245, 245, 245));

        lbCodId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodId.setText("Cod:");

        lbDataId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataId.setText("Data:");

        lbObsId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsId.setText("Observação:");

        lbTipoId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoId.setText("Tipo:");

        cbTipoId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoId.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsId.setColumns(20);
        txtObsId.setLineWrap(true);
        txtObsId.setRows(5);
        jScrollPane9.setViewportView(txtObsId);

        btnNovoId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoId.setText("Novo");
        btnNovoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoIdActionPerformed(evt);
            }
        });

        btnAlterarId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarId.setText("Alterar");
        btnAlterarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarIdActionPerformed(evt);
            }
        });

        btnSalvarId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarId.setText("Salvar");
        btnSalvarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarIdActionPerformed(evt);
            }
        });

        btnCancelarId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarId.setText("Cancelar");
        btnCancelarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarIdActionPerformed(evt);
            }
        });

        btnExcluirId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirId.setText("Excluir");
        btnExcluirId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirIdActionPerformed(evt);
            }
        });

        tbId.setModel(new javax.swing.table.DefaultTableModel(
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
        tbId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIdMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbId);
        if (tbId.getColumnModel().getColumnCount() > 0) {
            tbId.getColumnModel().getColumn(0).setMaxWidth(30);
            tbId.getColumnModel().getColumn(1).setMaxWidth(70);
            tbId.getColumnModel().getColumn(2).setMaxWidth(90);
            tbId.getColumnModel().getColumn(4).setMaxWidth(150);
            tbId.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        lbApelido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbApelido.setText("Apelido?");
        lbApelido.setToolTipText("Infome nesse campo se houver apelido para esse cliente, o cadastro atual será atualizado.");

        btnApelido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnApelido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApelidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCadIdLayout = new javax.swing.GroupLayout(jpCadId);
        jpCadId.setLayout(jpCadIdLayout);
        jpCadIdLayout.setHorizontalGroup(
            jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadIdLayout.createSequentialGroup()
                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadIdLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadIdLayout.createSequentialGroup()
                                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpCadIdLayout.createSequentialGroup()
                                        .addComponent(lbDataId)
                                        .addGap(111, 111, 111)
                                        .addComponent(txtDataId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpCadIdLayout.createSequentialGroup()
                                        .addComponent(lbCodId)
                                        .addGap(115, 115, 115)
                                        .addComponent(txtCodId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpCadIdLayout.createSequentialGroup()
                                        .addComponent(lbTipoId)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTipoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpCadIdLayout.createSequentialGroup()
                                        .addComponent(lbApelido)
                                        .addGap(16, 16, 16)
                                        .addComponent(btnApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIdApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpCadIdLayout.createSequentialGroup()
                                .addComponent(lbObsId)
                                .addGap(73, 73, 73)
                                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpCadIdLayout.createSequentialGroup()
                                        .addComponent(btnNovoId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane9))))))
                .addGap(5, 5, 5))
        );
        jpCadIdLayout.setVerticalGroup(
            jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadIdLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadIdLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodId))
                    .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbApelido)
                        .addComponent(txtIdApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpCadIdLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataId))
                    .addComponent(txtDataId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(jpCadIdLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoId))
                    .addComponent(cbTipoId))
                .addGap(16, 16, 16)
                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsId)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Gerar ID", jpCadId);

        jpCadastro.setBackground(new java.awt.Color(245, 245, 245));

        lbCodCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodCadastro.setText("Cod:");

        lbDataCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataCadastro.setText("Data:");

        lbTipoCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoCadastro.setText("Tipo:");

        cbTipoCadastro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoCadastro.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        lbObsCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsCadastro.setText("Observação:");

        txtObsCadastro.setColumns(20);
        txtObsCadastro.setLineWrap(true);
        txtObsCadastro.setRows(5);
        jScrollPane7.setViewportView(txtObsCadastro);

        btnNovoCadastro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoCadastro.setText("Novo");
        btnNovoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCadastroActionPerformed(evt);
            }
        });

        btnAlterarCadastro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarCadastro.setText("Alterar");
        btnAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCadastroActionPerformed(evt);
            }
        });

        btnSalvarCadastro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarCadastro.setText("Salvar");
        btnSalvarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCadastroActionPerformed(evt);
            }
        });

        btnCancelarCadastro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarCadastro.setText("Cancelar");
        btnCancelarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCadastroActionPerformed(evt);
            }
        });

        btnExcluirCadastro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirCadastro.setText("Excluir");
        btnExcluirCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCadastroActionPerformed(evt);
            }
        });

        tbCadastro.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCadastroMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbCadastro);
        if (tbCadastro.getColumnModel().getColumnCount() > 0) {
            tbCadastro.getColumnModel().getColumn(0).setMaxWidth(30);
            tbCadastro.getColumnModel().getColumn(1).setMaxWidth(70);
            tbCadastro.getColumnModel().getColumn(2).setMaxWidth(90);
            tbCadastro.getColumnModel().getColumn(4).setMaxWidth(150);
            tbCadastro.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addComponent(lbCodCadastro)
                                .addGap(115, 115, 115)
                                .addComponent(txtCodCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addComponent(lbDataCadastro)
                                .addGap(111, 111, 111)
                                .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbTipoCadastro)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpCadastroLayout.createSequentialGroup()
                                .addComponent(lbObsCadastro)
                                .addGap(73, 73, 73)
                                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpCadastroLayout.createSequentialGroup()
                                        .addComponent(btnNovoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7))))))
                .addGap(5, 5, 5))
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodCadastro))
                    .addComponent(txtCodCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataCadastro))
                    .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadastroLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoCadastro))
                    .addComponent(cbTipoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsCadastro)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jpCadastroLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCodCadastro, txtDataCadastro});

        jtbGuia.addTab("Control/Contmatic", jpCadastro);

        jpContrato.setBackground(new java.awt.Color(245, 245, 245));

        lbCodContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodContrato.setText("Cod:");

        lbDataContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataContrato.setText("Data:");

        lbTipoContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoContrato.setText("Tipo:");

        cbTipoContrato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoContrato.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        lbObsContrato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsContrato.setText("Observação:");

        txtObsContrato.setColumns(20);
        txtObsContrato.setLineWrap(true);
        txtObsContrato.setRows(5);
        jScrollPane10.setViewportView(txtObsContrato);

        btnNovoContrato.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoContrato.setText("Novo");
        btnNovoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoContratoActionPerformed(evt);
            }
        });

        btnAlterarContrato.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarContrato.setText("Alterar");
        btnAlterarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarContratoActionPerformed(evt);
            }
        });

        btnSalvarContrato.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarContrato.setText("Salvar");
        btnSalvarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarContratoActionPerformed(evt);
            }
        });

        btnContrato.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnContrato.setText("Cancelar");
        btnContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContratoActionPerformed(evt);
            }
        });

        btnExcluirContrato.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirContrato.setText("Excluir");
        btnExcluirContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirContratoActionPerformed(evt);
            }
        });

        tbContrato.setModel(new javax.swing.table.DefaultTableModel(
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
        tbContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbContratoMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbContrato);
        if (tbContrato.getColumnModel().getColumnCount() > 0) {
            tbContrato.getColumnModel().getColumn(0).setMaxWidth(30);
            tbContrato.getColumnModel().getColumn(1).setMaxWidth(70);
            tbContrato.getColumnModel().getColumn(2).setMaxWidth(90);
            tbContrato.getColumnModel().getColumn(4).setMaxWidth(150);
            tbContrato.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpContratoLayout = new javax.swing.GroupLayout(jpContrato);
        jpContrato.setLayout(jpContratoLayout);
        jpContratoLayout.setHorizontalGroup(
            jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContratoLayout.createSequentialGroup()
                .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpContratoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpContratoLayout.createSequentialGroup()
                                .addComponent(lbCodContrato)
                                .addGap(115, 115, 115)
                                .addComponent(txtCodContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpContratoLayout.createSequentialGroup()
                                .addComponent(lbDataContrato)
                                .addGap(111, 111, 111)
                                .addComponent(txtDataContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbTipoContrato)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpContratoLayout.createSequentialGroup()
                                .addComponent(lbObsContrato)
                                .addGap(73, 73, 73)
                                .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpContratoLayout.createSequentialGroup()
                                        .addComponent(btnNovoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane10))))))
                .addGap(5, 5, 5))
        );
        jpContratoLayout.setVerticalGroup(
            jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContratoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContratoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodContrato))
                    .addComponent(txtCodContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContratoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataContrato))
                    .addComponent(txtDataContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpContratoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoContrato))
                    .addComponent(cbTipoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsContrato)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Elaborar Contrato", jpContrato);

        jpRecContrato.setBackground(new java.awt.Color(245, 245, 245));

        lbCodRec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodRec.setText("Cod:");

        lbDataRec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataRec.setText("Data:");

        lbObsRec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsRec.setText("Observação:");

        lbTipoRec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoRec.setText("Tipo:");

        cbTipoRec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoRec.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsRec.setColumns(20);
        txtObsRec.setLineWrap(true);
        txtObsRec.setRows(5);
        jScrollPane12.setViewportView(txtObsRec);

        btnNovoRec.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoRec.setText("Novo");
        btnNovoRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoRecActionPerformed(evt);
            }
        });

        btnAlterarRec.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarRec.setText("Alterar");
        btnAlterarRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRecActionPerformed(evt);
            }
        });

        btnSalvarRec.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarRec.setText("Salvar");
        btnSalvarRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarRecActionPerformed(evt);
            }
        });

        btnCancelarRec.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarRec.setText("Cancelar");
        btnCancelarRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRecActionPerformed(evt);
            }
        });

        btnExcluirRec.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirRec.setText("Excluir");
        btnExcluirRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirRecActionPerformed(evt);
            }
        });

        tbRec.setModel(new javax.swing.table.DefaultTableModel(
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
        tbRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRecMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tbRec);
        if (tbRec.getColumnModel().getColumnCount() > 0) {
            tbRec.getColumnModel().getColumn(0).setMaxWidth(30);
            tbRec.getColumnModel().getColumn(1).setMaxWidth(70);
            tbRec.getColumnModel().getColumn(2).setMaxWidth(90);
            tbRec.getColumnModel().getColumn(4).setMaxWidth(150);
            tbRec.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpRecContratoLayout = new javax.swing.GroupLayout(jpRecContrato);
        jpRecContrato.setLayout(jpRecContratoLayout);
        jpRecContratoLayout.setHorizontalGroup(
            jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecContratoLayout.createSequentialGroup()
                .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpRecContratoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpRecContratoLayout.createSequentialGroup()
                                .addComponent(lbCodRec)
                                .addGap(115, 115, 115)
                                .addComponent(txtCodRec, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpRecContratoLayout.createSequentialGroup()
                                .addComponent(lbDataRec)
                                .addGap(111, 111, 111)
                                .addComponent(txtDataRec, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbTipoRec)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpRecContratoLayout.createSequentialGroup()
                                .addComponent(lbObsRec)
                                .addGap(73, 73, 73)
                                .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpRecContratoLayout.createSequentialGroup()
                                        .addComponent(btnNovoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarRec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarRec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarRec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirRec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane12))))))
                .addGap(5, 5, 5))
        );
        jpRecContratoLayout.setVerticalGroup(
            jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecContratoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecContratoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodRec))
                    .addComponent(txtCodRec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecContratoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataRec))
                    .addComponent(txtDataRec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpRecContratoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoRec))
                    .addComponent(cbTipoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsRec)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarRec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarRec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRecContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarRec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirRec, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Receber Contrato", jpRecContrato);

        jpAtivar.setBackground(new java.awt.Color(245, 245, 245));

        lbCodAtivar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodAtivar.setText("Cod:");

        lbDataAtivar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataAtivar.setText("Data:");

        lbObsAtivar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsAtivar.setText("Observação:");

        lbTipoAtivar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoAtivar.setText("Tipo:");

        cbTipoAtivar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoAtivar.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsAtivar.setColumns(20);
        txtObsAtivar.setLineWrap(true);
        txtObsAtivar.setRows(5);
        jScrollPane14.setViewportView(txtObsAtivar);

        btnNovoAtivar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoAtivar.setText("Novo");
        btnNovoAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAtivarActionPerformed(evt);
            }
        });

        btnAlterarAtivar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarAtivar.setText("Alterar");
        btnAlterarAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarAtivarActionPerformed(evt);
            }
        });

        btnSalvarAtivar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarAtivar.setText("Salvar");
        btnSalvarAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAtivarActionPerformed(evt);
            }
        });

        btnCancelaAtivar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelaAtivar.setText("Cancelar");
        btnCancelaAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaAtivarActionPerformed(evt);
            }
        });

        btnExcluirAtivar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirAtivar.setText("Excluir");
        btnExcluirAtivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAtivarActionPerformed(evt);
            }
        });

        tbAtivar.setModel(new javax.swing.table.DefaultTableModel(
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
        tbAtivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAtivarMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tbAtivar);
        if (tbAtivar.getColumnModel().getColumnCount() > 0) {
            tbAtivar.getColumnModel().getColumn(0).setMaxWidth(30);
            tbAtivar.getColumnModel().getColumn(1).setMaxWidth(70);
            tbAtivar.getColumnModel().getColumn(2).setMaxWidth(90);
            tbAtivar.getColumnModel().getColumn(4).setMaxWidth(150);
            tbAtivar.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpAtivarLayout = new javax.swing.GroupLayout(jpAtivar);
        jpAtivar.setLayout(jpAtivarLayout);
        jpAtivarLayout.setHorizontalGroup(
            jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtivarLayout.createSequentialGroup()
                .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpAtivarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAtivarLayout.createSequentialGroup()
                                .addComponent(lbCodAtivar)
                                .addGap(115, 115, 115)
                                .addComponent(txtCodAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAtivarLayout.createSequentialGroup()
                                .addComponent(lbDataAtivar)
                                .addGap(111, 111, 111)
                                .addComponent(txtDataAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbTipoAtivar)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAtivarLayout.createSequentialGroup()
                                .addComponent(lbObsAtivar)
                                .addGap(73, 73, 73)
                                .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpAtivarLayout.createSequentialGroup()
                                        .addComponent(btnNovoAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelaAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane14))))))
                .addGap(5, 5, 5))
        );
        jpAtivarLayout.setVerticalGroup(
            jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtivarLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtivarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodAtivar))
                    .addComponent(txtCodAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtivarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataAtivar))
                    .addComponent(txtDataAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpAtivarLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoAtivar))
                    .addComponent(cbTipoAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsAtivar)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAtivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelaAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirAtivar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Ativar Cliente", jpAtivar);

        jpPerfil.setBackground(new java.awt.Color(245, 245, 245));

        lbCodPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodPerfil.setText("Cod:");

        lbDataPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataPerfil.setText("Data:");

        lbObsPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsPerfil.setText("Observação:");

        lbTipoPerfil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoPerfil.setText("Tipo:");

        cbTipoPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoPerfil.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsPerfil.setColumns(20);
        txtObsPerfil.setLineWrap(true);
        txtObsPerfil.setRows(5);
        jScrollPane16.setViewportView(txtObsPerfil);

        btnNovoPerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoPerfil.setText("Novo");
        btnNovoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPerfilActionPerformed(evt);
            }
        });

        btnAlterarPerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarPerfil.setText("Alterar");
        btnAlterarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarPerfilActionPerformed(evt);
            }
        });

        btnSalvarPerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarPerfil.setText("Salvar");
        btnSalvarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPerfilActionPerformed(evt);
            }
        });

        btnCancelarPerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarPerfil.setText("Cancelar");
        btnCancelarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPerfilActionPerformed(evt);
            }
        });

        btnExcluirPerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirPerfil.setText("Excluir");
        btnExcluirPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPerfilActionPerformed(evt);
            }
        });

        tbPerfil.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPerfilMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tbPerfil);
        if (tbPerfil.getColumnModel().getColumnCount() > 0) {
            tbPerfil.getColumnModel().getColumn(0).setMaxWidth(30);
            tbPerfil.getColumnModel().getColumn(1).setMaxWidth(70);
            tbPerfil.getColumnModel().getColumn(2).setMaxWidth(90);
            tbPerfil.getColumnModel().getColumn(4).setMaxWidth(150);
            tbPerfil.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpPerfilLayout = new javax.swing.GroupLayout(jpPerfil);
        jpPerfil.setLayout(jpPerfilLayout);
        jpPerfilLayout.setHorizontalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPerfilLayout.createSequentialGroup()
                                .addComponent(lbCodPerfil)
                                .addGap(115, 115, 115)
                                .addComponent(txtCodPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPerfilLayout.createSequentialGroup()
                                .addComponent(lbDataPerfil)
                                .addGap(111, 111, 111)
                                .addComponent(txtDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbTipoPerfil)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPerfilLayout.createSequentialGroup()
                                .addComponent(lbObsPerfil)
                                .addGap(73, 73, 73)
                                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpPerfilLayout.createSequentialGroup()
                                        .addComponent(btnNovoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane16))))))
                .addGap(5, 5, 5))
        );
        jpPerfilLayout.setVerticalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodPerfil))
                    .addComponent(txtCodPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataPerfil))
                    .addComponent(txtDataPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoPerfil))
                    .addComponent(cbTipoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsPerfil)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Elaborar Perfil Fiscal", jpPerfil);

        javax.swing.GroupLayout jpComercialLayout = new javax.swing.GroupLayout(jpComercial);
        jpComercial.setLayout(jpComercialLayout);
        jpComercialLayout.setHorizontalGroup(
            jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComercialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpComercialLayout.createSequentialGroup()
                        .addGroup(jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_cod)
                            .addComponent(lb_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbGuia))
                .addContainerGap())
            .addComponent(lb_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpComercialLayout.setVerticalGroup(
            jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpComercialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_titulo)
                .addGap(18, 18, 18)
                .addGroup(jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_nome)
                        .addComponent(lb_cod)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpComercialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_id)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jtbGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpComercial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPerfilMouseClicked
        Integer linha = tbPerfil.getSelectedRow();
        String codigo = (String) tbPerfil.getValueAt(linha, 0);
        String data = (String) tbPerfil.getValueAt(linha, 1);
        String observacao = (String) tbPerfil.getValueAt(linha, 3);
        String tipo = (String) tbPerfil.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia + mes + ano;

        txtDataPerfil.setText(recebedataTabela);

        txtCodPerfil.setText(codigo);
        txtObsPerfil.setText(observacao);

        if (tipo.equalsIgnoreCase("Finalizado")) {
            cbTipoPerfil.setSelectedItem("Finalizado");
        } else {
            cbTipoPerfil.setSelectedItem("Novo Andamento");
        }
    }//GEN-LAST:event_tbPerfilMouseClicked

    private void btnExcluirPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPerfilActionPerformed
        if (txtCodPerfil.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        } else {
            try {
                con.executeSQL(("select * from elaborarperfilfiscal where CodElaborarPerfilFiscal=" + txtCodPerfil.getText()));
                if (con.resultset.first()) {
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " + nome + "?";
                    String andamento = con.resultset.getString("AndamentoElaborarPerfilFiscal");

                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION) {
                        String sql = "delete from elaborarperfilfiscal where CodElaborarPerfilFiscal=" + txtCodPerfil.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

                            limpar_tabela_perfil();
                            preencher_tabela_perfil();
                            limpar_tela_perfil();

                            if ("Finalizado".equals(andamento)) {
                                con.executeSQL("select * from elaborarperfilfiscal where NumeroProcesso=" +processo+ " and AndamentoElaborarPerfilFiscal='Finalizado'");

                                if (!con.resultset.first()) {
                                    try {
                                        con_geral.statement.executeUpdate("update contratos set AndamentoElaborarPrefilFiscal='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    } catch (SQLException erro) {
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Contratos!\n" + erro);
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Recebimento!\n" + erro);
            }

        }
    }//GEN-LAST:event_btnExcluirPerfilActionPerformed

    private void btnCancelarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPerfilActionPerformed
        restaurar_backup_perfil();
        bloquear_tela_perfil();
    }//GEN-LAST:event_btnCancelarPerfilActionPerformed

    private void btnSalvarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPerfilActionPerformed
        if (txtDataPerfil.getText().trim().length() < 10 || txtDataPerfil.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        } else if (cbTipoPerfil.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        } else if (txtCodPerfil.getText().equals("")) {
            try {
                String novadata = txtDataPerfil.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoPerfil.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String gry = "insert into elaborarperfilfiscal (DatadeCadastroAndamento, NumeroProcesso,"
                        + "Usuario, Obsevacao, AndamentoElaborarPerfilFiscal)"
                        + "values ('" + new java.sql.Date(data.getTime()) + "','"
                        +processo+ "','"
                        + usuario + "','"
                        + txtObsPerfil.getText() + "','"
                        + andamento + "')";
                con.exeQuery(gry);

                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

                atualizar_perfil();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_perfil();
                preencher_tabela_perfil();

            } catch (ParseException | HeadlessException add) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro na tabela Perfil!\n" + add);
            }
        } else if (!txtCodPerfil.getText().equals("")) {
            try {
                String novadata = txtDataPerfil.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoPerfil.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String sql = "update elaborarperfilfiscal set "
                        + "DatadeCadastroAndamento='" + new java.sql.Date(data.getTime()) + "',"
                        + "Usuario='" + usuario + "',"
                        + "Obsevacao='" + txtObsPerfil.getText() + "',"
                        + "AndamentoElaborarPerfilFiscal='" + andamento + "'"
                        + " where CodElaborarPerfilFiscal=" + txtCodPerfil.getText();

                con.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

                atualizar_perfil();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_perfil();
                preencher_tabela_perfil();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro na tabela Perfil\n" + erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro\n Erro na conversão da data!\n" + ex);
            }
        }
    }//GEN-LAST:event_btnSalvarPerfilActionPerformed

    private void btnAlterarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarPerfilActionPerformed
        criar_backup_perfil();
        desbloquear_tela_perfil();
    }//GEN-LAST:event_btnAlterarPerfilActionPerformed

    private void btnNovoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPerfilActionPerformed
        criar_backup_perfil();
        limpar_tela_perfil();
        desbloquear_tela_perfil();
    }//GEN-LAST:event_btnNovoPerfilActionPerformed

    private void tbAtivarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAtivarMouseClicked
        Integer linha = tbAtivar.getSelectedRow();
        String codigo = (String) tbAtivar.getValueAt(linha, 0);
        String data = (String) tbAtivar.getValueAt(linha, 1);
        String observacao = (String) tbAtivar.getValueAt(linha, 3);
        String tipo = (String) tbAtivar.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia + mes + ano;

        txtDataAtivar.setText(recebedataTabela);

        txtCodAtivar.setText(codigo);
        txtObsAtivar.setText(observacao);

        if (tipo.equalsIgnoreCase("Finalizado")) {
            cbTipoAtivar.setSelectedItem("Finalizado");
        } else {
            cbTipoAtivar.setSelectedItem("Novo Andamento");
        }
    }//GEN-LAST:event_tbAtivarMouseClicked

    private void btnExcluirAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAtivarActionPerformed
        if (txtCodAtivar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        } else {
            try {
                con.executeSQL(("select * from ativarcliente where CodAtivarCliente=" + txtCodAtivar.getText()));
                if (con.resultset.first()) {
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " + nome + "?";
                    String andamento = con.resultset.getString("AndamentoAtivarCliente");

                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION) {
                        String sql = "delete from ativarcliente where CodAtivarCliente=" + txtCodAtivar.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

                            limpar_tabela_ativar();
                            preencher_tabela_ativar();
                            limpar_tela_ativar();

                            if ("Finalizado".equals(andamento)) {
                                con.executeSQL("select * from ativarcliente where NumeroProcesso=" +processo+ " and AndamentoAtivarCliente='Finalizado'");

                                if (!con.resultset.first()) {
                                    try {
                                        con_geral.statement.executeUpdate("update comercial set AndamentoAtivarCliente='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    } catch (SQLException erro) {
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Contratos!\n" + erro);
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Ativar Cliente!\n" + erro);
            }

        }
    }//GEN-LAST:event_btnExcluirAtivarActionPerformed

    private void btnCancelaAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaAtivarActionPerformed
        restaurar_backup_ativar();
        bloquear_tela_ativar();
    }//GEN-LAST:event_btnCancelaAtivarActionPerformed

    private void btnSalvarAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAtivarActionPerformed
        if (txtDataAtivar.getText().trim().length() < 10 || txtDataAtivar.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        } else if (cbTipoAtivar.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        } else if (txtCodAtivar.getText().equals("")) {
            try {
                String novadata = txtDataAtivar.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoAtivar.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String gry = "insert into ativarcliente (DatadeCadastroAndamento, NumeroProcesso,"
                        + "Usuario, Obsevacao, AndamentoAtivarCliente)"
                        + "values ('" + new java.sql.Date(data.getTime()) + "','"
                        +processo+ "','"
                        + usuario + "','"
                        + txtObsAtivar.getText() + "','"
                        + andamento + "')";
                con.exeQuery(gry);

                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

                atualizar_ativar();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_ativar();
                preencher_tabela_ativar();

            } catch (ParseException | HeadlessException add) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro na tabela Ativar!\n" + add);
            }
        } else if (!txtCodAtivar.getText().equals("")) {
            try {
                String novadata = txtDataAtivar.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoAtivar.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String sql = "update ativarcliente set "
                        + "DatadeCadastroAndamento='" + new java.sql.Date(data.getTime()) + "',"
                        + "Usuario='" + usuario + "',"
                        + "Obsevacao='" + txtObsAtivar.getText() + "',"
                        + "AndamentoAtivarCliente='" + andamento + "'"
                        + " where CodAtivarCliente=" + txtCodAtivar.getText();

                con.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

                atualizar_ativar();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_ativar();
                preencher_tabela_ativar();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro na tabela Ativar\n" + erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro\n Falha na conversão de data!\n" + ex);
            }
        }

    }//GEN-LAST:event_btnSalvarAtivarActionPerformed

    private void btnAlterarAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarAtivarActionPerformed
        criar_backup_ativar();
        desbloquear_tela_ativar();
    }//GEN-LAST:event_btnAlterarAtivarActionPerformed

    private void btnNovoAtivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAtivarActionPerformed
        criar_backup_ativar();
        limpar_tela_ativar();
        desbloquear_tela_ativar();
    }//GEN-LAST:event_btnNovoAtivarActionPerformed

    private void tbRecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRecMouseClicked
        Integer linha = tbRec.getSelectedRow();
        String codigo = (String) tbRec.getValueAt(linha, 0);
        String data = (String) tbRec.getValueAt(linha, 1);
        String observacao = (String) tbRec.getValueAt(linha, 3);
        String tipo = (String) tbRec.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia + mes + ano;

        txtDataRec.setText(recebedataTabela);

        txtCodRec.setText(codigo);
        txtObsRec.setText(observacao);

        if (tipo.equalsIgnoreCase("Finalizado")) {
            cbTipoRec.setSelectedItem("Finalizado");
        } else {
            cbTipoRec.setSelectedItem("Novo Andamento");
        }
    }//GEN-LAST:event_tbRecMouseClicked

    private void btnExcluirRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirRecActionPerformed
        if (txtCodRec.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão!");
        } else {
            try {
                con.executeSQL(("select * from recebercontratoasscliente where CodReceberContratoAssCliente=" + txtCodRec.getText()));
                if (con.resultset.first()) {
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " + nome + "?";
                    String andamento = con.resultset.getString("AndamentoReceberContratoAssCliente");

                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION) {
                        String sql = "delete from recebercontratoasscliente where CodReceberContratoAssCliente=" + txtCodRec.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

                            limpar_tabela_receber();
                            preencher_tabela_receber();
                            limpar_tela_receber();

                            if ("Finalizado".equals(andamento)) {
                                con.executeSQL("select * from recebercontratoasscliente where NumeroProcesso=" +processo+ " and AndamentoReceberContratoAssCliente='Finalizado'");

                                if (!con.resultset.first()) {
                                    try {
                                        con_geral.statement.executeUpdate("update contratos set AndamentoReceberContratoAssCliente='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    } catch (SQLException erro) {
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contrato!\n" + erro);
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Recebimento de Contrato!\n" + erro);
            }

        }
    }//GEN-LAST:event_btnExcluirRecActionPerformed

    private void btnCancelarRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRecActionPerformed
        restaurar_backup_receber();
        bloquear_tela_receber();
    }//GEN-LAST:event_btnCancelarRecActionPerformed

    private void btnSalvarRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarRecActionPerformed
        if (txtDataRec.getText().trim().length() < 10 || txtDataRec.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        } else if (cbTipoRec.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        } else if (txtCodRec.getText().equals("")) {
            try {
                String novadata = txtDataRec.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoRec.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String gry = "insert into recebercontratoasscliente (DatadeCadastroAndamento, NumeroProcesso,"
                        + "Usuario, Obsevacao, AndamentoReceberContratoAssCliente)"
                        + "values ('" + new java.sql.Date(data.getTime()) + "','"
                        + processo+ "','"
                        + usuario + "','"
                        + txtObsRec.getText() + "','"
                        + andamento + "')";
                con.exeQuery(gry);

                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

                atualizar_receber();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_receber();
                preencher_tabela_receber();

            } catch (ParseException | HeadlessException add) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro Recebimento de Contrato!\n" + add);
            }
        } else if (!txtCodRec.getText().equals("")) {
            try {
                String novadata = txtDataRec.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoRec.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String sql = "update recebercontratoasscliente set "
                        + "DatadeCadastroAndamento='" + new java.sql.Date(data.getTime()) + "',"
                        + "Usuario='" + usuario + "',"
                        + "Obsevacao='" + txtObsRec.getText() + "',"
                        + "AndamentoReceberContratoAssCliente='" + andamento + "'"
                        + " where CodReceberContratoAssCliente=" + txtCodRec.getText();

                con.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

                atualizar_receber();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_receber();
                preencher_tabela_receber();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro na tabela Recebimento de Contrato\n" + erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao converter data informada!\n" + ex);
            }
        }
    }//GEN-LAST:event_btnSalvarRecActionPerformed

    private void btnAlterarRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRecActionPerformed
        criar_backup_receber();
        desbloquear_tela_receber();
    }//GEN-LAST:event_btnAlterarRecActionPerformed

    private void btnNovoRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoRecActionPerformed
        criar_backup_receber();
        limpar_tela_receber();
        desbloquear_tela_receber();
    }//GEN-LAST:event_btnNovoRecActionPerformed

    private void tbContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbContratoMouseClicked
        Integer linha = tbContrato.getSelectedRow();
        String codigo = (String) tbContrato.getValueAt(linha, 0);
        String data = (String) tbContrato.getValueAt(linha, 1);
        String observacao = (String) tbContrato.getValueAt(linha, 3);
        String tipo = (String) tbContrato.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia + mes + ano;

        txtDataContrato.setText(recebedataTabela);

        txtCodContrato.setText(codigo);
        txtObsContrato.setText(observacao);

        if (tipo.equalsIgnoreCase("Finalizado")) {
            cbTipoContrato.setSelectedItem("Finalizado");
        } else {
            cbTipoContrato.setSelectedItem("Novo Andamento");
        }
    }//GEN-LAST:event_tbContratoMouseClicked

    private void btnExcluirContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirContratoActionPerformed
        if (txtCodContrato.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão!");
        } else {
            try {
                con.executeSQL(("select * from elaborarcontratodeprestacaodeservico where CodEleborarPropostaPrestacaoDeServico=" + txtCodContrato.getText()));
                if (con.resultset.first()) {
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " + nome + "?";
                    String andamento = con.resultset.getString("AndamentoElaborarPropostaPrestacaoDeServico");

                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão", JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION) {
                        String sql = "delete from elaborarcontratodeprestacaodeservico where CodEleborarPropostaPrestacaoDeServico=" + txtCodContrato.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

                            limpar_tabela_contrato();
                            preencher_tabela_contrato();
                            limpar_tela_contrato();

                            if ("Finalizado".equals(andamento)) {
                                con.executeSQL("select * from elaborarcontratodeprestacaodeservico where NumeroProcesso=" +processo+ " and AndamentoElaborarPropostaPrestacaoDeServico='Finalizado'");

                                if (!con.resultset.first()) {
                                    try {
                                        con_geral.statement.executeUpdate("update contratos set AndamentoElaborarContratoPrestacaoDeServico='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    } catch (SQLException erro) {
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Contrato!\n" + erro);
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Elaborar Contrato!\n" + erro);
            }

        }
    }//GEN-LAST:event_btnExcluirContratoActionPerformed

    private void btnContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContratoActionPerformed
        restaurar_backup_contrato();
        bloquear_tela_contrato();
    }//GEN-LAST:event_btnContratoActionPerformed

    private void btnSalvarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarContratoActionPerformed
        if (txtDataContrato.getText().equals("  /  /    ") || txtDataContrato.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Data informada é invalida!");
        } else if (cbTipoContrato.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Tipo não pode ficar em branco");
        } else if (txtCodContrato.getText().equals("")) {
            try {
                String novadata = txtDataContrato.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoContrato.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String gry = "insert into elaborarcontratodeprestacaodeservico (DatadeCadastroAndamento, NumeroProcesso,"
                        + "Usuario, Obsevacao, AndamentoElaborarPropostaPrestacaoDeServico)"
                        + "values ('" + new java.sql.Date(data.getTime()) + "','"
                        +processo+ "','"
                        + usuario + "','"
                        + txtObsContrato.getText() + "','"
                        + andamento + "')";
                con.exeQuery(gry);

                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

                atualizar_contrato();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_contrato();
                preencher_tabela_contrato();

            } catch (ParseException | HeadlessException add) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro na tabela Contrato!\n" + add);
            }
        } else if (!txtCodContrato.getText().equals("")) {
            try {
                String novadata = txtDataContrato.getText();
                Date data = sdf.parse(novadata);

                String andamento;

                if (cbTipoContrato.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String sql = "update elaborarcontratodeprestacaodeservico set "
                        + "DatadeCadastroAndamento='" + new java.sql.Date(data.getTime()) + "',"
                        + "Usuario='" + usuario + "',"
                        + "Obsevacao='" + txtObsContrato.getText() + "',"
                        + "AndamentoElaborarPropostaPrestacaoDeServico='" + andamento + "'"
                        + " where CodEleborarPropostaPrestacaoDeServico=" + txtCodContrato.getText();

                con.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

                atualizar_contrato();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_contrato();
                preencher_tabela_contrato();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n" + erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro na tabela Contrato!\n" + ex);
            }
        }

    }//GEN-LAST:event_btnSalvarContratoActionPerformed

    private void btnAlterarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarContratoActionPerformed
        criar_backup_contrato();
        desbloquear_tela_contrato();
    }//GEN-LAST:event_btnAlterarContratoActionPerformed

    private void btnNovoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoContratoActionPerformed
        criar_backup_contrato();
        limpar_tela_contrato();
        desbloquear_tela_contrato();
    }//GEN-LAST:event_btnNovoContratoActionPerformed

    private void tbCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCadastroMouseClicked
        Integer linha = tbCadastro.getSelectedRow();
        String codigo = (String) tbCadastro.getValueAt(linha, 0);
        String data = (String) tbCadastro.getValueAt(linha, 1);
        String observacao = (String) tbCadastro.getValueAt(linha, 3);
        String tipo = (String) tbCadastro.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia + mes + ano;

        txtDataCadastro.setText(recebedataTabela);

        txtCodCadastro.setText(codigo);
        txtObsCadastro.setText(observacao);

        if (tipo.equalsIgnoreCase("Finalizado")) {
            cbTipoCadastro.setSelectedItem("Finalizado");
        } else {
            cbTipoCadastro.setSelectedItem("Novo Andamento");
        }
    }//GEN-LAST:event_tbCadastroMouseClicked

    private void btnExcluirCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCadastroActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if (txtCodCadastro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        } else {
            try {
                //busca cadastro de acordo com o codigo
                String sql = "select * from cadastrarcontrolecontimatic where CodCadastrarControlEContimatic= " + txtCodCadastro.getText();
                con.executeSQL(sql);
                if (con.resultset.first()) {
                    String cliente = "Tem certeza que deseja excluir um registro do cliente : " + nome + "?";
                    String operacao = con.resultset.getString("AndamentoCadastrarControlEContimatic");
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão ", JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION) {
                        sql = "DELETE FROM cadastrarcontrolecontimatic Where CodCadastrarControlEContimatic=" + txtCodCadastro.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
                            limpar_tabela_cadastro();
                            preencher_tabela_cadastro();
                            limpar_tela_cadastro();

                            if ("Finalizado".equals(operacao)) {
                                con.executeSQL("select * from cadastrarcontrolecontimatic where NumerodoProcesso='" +processo+ "' and AndamentoCadatrarControlEContimatic='Finalizado'");
                                if (!con.resultset.first()) {
                                    try {
                                        con_geral.statement.executeUpdate("update contratos set AndamentoCadastrarControlEContmatic='Em Aberto' where NumeroProcesso='" +processo+ "'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    } catch (SQLException erro) {
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar\n" + erro);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro\n" + erro);
            }
        }
    }//GEN-LAST:event_btnExcluirCadastroActionPerformed

    private void btnCancelarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCadastroActionPerformed
        restaurar_backup_cadastro();
        bloquear_tela_cadastro();
    }//GEN-LAST:event_btnCancelarCadastroActionPerformed

    private void btnSalvarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCadastroActionPerformed
        //nao permitir que a primeira data fique vazia
        if (txtDataCadastro.getText().equals("  /  /    ") || txtDataCadastro.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        } else if (cbTipoCadastro.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Tipo não pode ficar em branco");
        } //evitando erros com cadastro ja salvo antes
        else if (txtCodCadastro.getText().equals("")) {
            try {
                String dataandamento = txtDataCadastro.getText();
                Date data = sdf.parse(dataandamento);

                String andamento;
                if (cbTipoCadastro.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }
                String gry = "insert into cadastrarcontrolecontimatic ("
                        + "NumeroProcesso, DatadeCadastroAndamento, Obsevacao, "
                        + "Usuario, AndamentoCadastrarControlEContimatic) values ('" +processo+ "','"
                        + new java.sql.Date(data.getTime()) + "','"
                        + txtObsCadastro.getText() + "','"
                        + usuario + "','"
                        + andamento + "')";
                con.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                atualizar_cadastro();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_cadastro();
                preencher_tabela_cadastro();

            } catch (ParseException | HeadlessException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Cadastro Control e Contmatic: \n" + erro);
            }
        } else if (!txtCodCadastro.getText().equals("")) {
            try {

                String dataandamento = txtDataCadastro.getText();
                Date data = sdf.parse(dataandamento);

                String andamento;
                if (cbTipoCadastro.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }
                String sql = "UPDATE cadastrarcontrolecontimatic set DatadeCadastroAndamento='"
                        + new java.sql.Date(data.getTime()) + "',"
                        + "Obsevacao='" + txtObsCadastro.getText() + "',"
                        + "Usuario= '" + usuario + "',"
                        + "AndamentoCadastrarControlEContimatic='" + andamento + "' "
                        + "where CodCadastrarControlEContimatic = " + txtCodCadastro.getText();

                con.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

                atualizar_cadastro();
                preencher_status();
                limpar_tabela_cadastro();
                preencher_tabela_cadastro();
                atualizar_cadastro_cliente();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Cadastro Control e Contmatic: \n " + erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n" + ex);
            }

        }
    }//GEN-LAST:event_btnSalvarCadastroActionPerformed

    private void btnAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCadastroActionPerformed
        criar_backup_cadastro();
        desbloquear_tela_cadastro();
    }//GEN-LAST:event_btnAlterarCadastroActionPerformed

    private void btnNovoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCadastroActionPerformed
        criar_backup_cadastro();
        limpar_tela_cadastro();
        desbloquear_tela_cadastro();
    }//GEN-LAST:event_btnNovoCadastroActionPerformed

    private void btnApelidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApelidoActionPerformed
        txtIdApelido.setEditable(true);
        txtIdApelido.setText(id);
    }//GEN-LAST:event_btnApelidoActionPerformed

    private void tbIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbIdMouseClicked
        Integer linha = tbId.getSelectedRow();
        String codigo = (String) tbId.getValueAt(linha, 0);
        String data = (String) tbId.getValueAt(linha, 1);
        String observacao = (String) tbId.getValueAt(linha, 3);
        String tipo = (String) tbId.getValueAt(linha, 4);

        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia + mes + ano;

        txtDataId.setText(recebedataTabela);

        txtCodId.setText(codigo);
        txtObsId.setText(observacao);
        if (tipo.equalsIgnoreCase("Finalizado")) {
            cbTipoId.setSelectedItem("Finalizado");
        } else {
            cbTipoId.setSelectedItem("Novo Andamento");
        }

    }//GEN-LAST:event_tbIdMouseClicked

    private void btnExcluirIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirIdActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if (txtCodId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        } else {
            try {
                String sql = "select * from geraridnaplancadastro  "
                        + "where CodGerarIdNaPlanCadastro=" + txtCodId.getText();
                con.executeSQL(sql);
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir esse cadastro do cliente : " + nome + "?";
                    String operacao = con.resultset.getString("AndamentoGerarIdNaPlanCadastro");
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão ", JOptionPane.YES_NO_OPTION);
                    if (opcao_escolhida == JOptionPane.YES_OPTION) {

                        sql = "DELETE FROM geraridnaplancadastro Where CodGerarIdNaPlanCadastro = " + txtCodId.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1) {
                            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
                            limpar_tela_id();
                            limpar_tabela_id();
                            preencher_tabela_id();
                            //verificar se não existe outro registro com o status finalizado nesse cliente
                            if ("Finalizado".equals(operacao)) {
                                con.executeSQL("select * from geraridnaplancadastro where NumeroProcesso='" +processo+ "' and AndamentoGerarIdNaPlanCadastro='Finalizado'");
                                if (!con.resultset.first()) {
                                    try {
                                        con_geral.statement.executeUpdate("update contratos set AndamentoGerarIDPlanCadastro='Em Aberto'"
                                                + " where Numerodoprocesso='"+processo+"'");
                                        preencher_status();
                                        atualizar_cadastro_cliente();

                                    } catch (SQLException erro) {
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos:\n" + erro);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro\n" + erro);
            }
        }
    }//GEN-LAST:event_btnExcluirIdActionPerformed

    private void btnCancelarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarIdActionPerformed
        restaurar_backup_id();
        bloquear_tela_id();
    }//GEN-LAST:event_btnCancelarIdActionPerformed

    private void btnSalvarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarIdActionPerformed
        //nao permitir que a primeira data fique vazia
        if (txtDataId.getText().equals("  /  /    ") || txtDataId.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        } else if (cbTipoId.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Tipo não pode ficar em branco");
        } //evitando erros com cadastro ja salvo antes
        else if (txtCodId.getText().equals("")) {
            try {

                String apelido;
                //regra para cadastrar apelido do cliente
                if (txtIdApelido.getText().trim().length() > 0
                        && !txtIdApelido.getText().equals(id)) {
                    apelido = txtIdApelido.getText().trim();

                    try {
                        con.statement.executeUpdate("update cadastrodeprocesso set Apelido='" + apelido + "' where codNumerodoprocesso=" + processo);

                        txtId.setText(apelido);
                        TelaPrincipal.txt_id.setText(apelido);
                        Ativador.id = apelido;

                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar o apelido do cliente!\n" + erro);
                    }

                }

                //convertendo a primeira data
                String dataandamento = txtDataId.getText();
                Date data = sdf.parse(dataandamento);

                String andamento;

                if (cbTipoId.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String gry = "insert into geraridnaplancadastro("
                        + "NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"
                        + "Usuario, AndamentoGerarIdNaPlanCadastro) "
                        + "values ('" +processo+ "','"
                        + new java.sql.Date(data.getTime()) + "','"
                        + txtObsId.getText() + "','"
                        + usuario + "','"
                        + andamento + "')";

                con.exeQuery(gry);

                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");

                atualizar_id();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_id();
                preencher_tabela_id();

            } catch (ParseException | HeadlessException add) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Cadastro de ID: " + add);
            }
        } else if (!txtCodId.getText().equals("")) {
            try {

                String apelido;
                //regra para cadastrar apelido do cliente
                if (txtIdApelido.getText().trim().length() > 0
                        && !txtIdApelido.getText().equals(id)) {
                    apelido = txtIdApelido.getText().trim();

                    try {
                        con.statement.executeUpdate("update cadastrodeprocesso set Apelido='" + apelido + "' where codNumerodoprocesso=" + processo);

                        txtId.setText(apelido);
                        TelaPrincipal.txt_id.setText(apelido);
                        Ativador.id = apelido;

                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Erro ao atualizar o apelido do cliente!\n" + erro);
                    }

                }

                String dataandamento = txtDataId.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamento;

                if (cbTipoId.getSelectedItem().equals("Finalizado")) {
                    andamento = "Finalizado";
                } else {
                    andamento = "Em Aberto";
                }

                String sql = "UPDATE geraridnaplancadastro set DatadeCadastroAndamento='"
                        + new java.sql.Date(datatermo.getTime()) + "',"
                        + "Obsevacao='" + txtObsId.getText() + "',"
                        + "Usuario = '" + usuario + "',"
                        + "AndamentoGerarIdNaPlanCadastro='" + andamento + "' "
                        + "where CodGerarIdNaPlanCadastro = " + txtCodId.getText();

                con.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

                atualizar_id();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_id();
                preencher_tabela_id();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Cadastro de ID: " + erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique a data informada, valor incorreto!\n" + ex);
            }
        }
    }//GEN-LAST:event_btnSalvarIdActionPerformed

    private void btnAlterarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarIdActionPerformed
        criar_backup_id();
        desbloquear_tela_id();
    }//GEN-LAST:event_btnAlterarIdActionPerformed

    private void btnNovoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoIdActionPerformed
        criar_backup_id();
        limpar_tela_id();
        desbloquear_tela_id();
    }//GEN-LAST:event_btnNovoIdActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con.desconecta();
        con_geral.desconecta();
    }//GEN-LAST:event_formWindowClosing
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Contratos reg = new Contratos();
                reg.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarAtivar;
    private javax.swing.JButton btnAlterarCadastro;
    private javax.swing.JButton btnAlterarContrato;
    private javax.swing.JButton btnAlterarId;
    private javax.swing.JButton btnAlterarPerfil;
    private javax.swing.JButton btnAlterarRec;
    private javax.swing.JButton btnApelido;
    private javax.swing.JButton btnCancelaAtivar;
    private javax.swing.JButton btnCancelarCadastro;
    private javax.swing.JButton btnCancelarId;
    private javax.swing.JButton btnCancelarPerfil;
    private javax.swing.JButton btnCancelarRec;
    private javax.swing.JButton btnContrato;
    private javax.swing.JButton btnExcluirAtivar;
    private javax.swing.JButton btnExcluirCadastro;
    private javax.swing.JButton btnExcluirContrato;
    private javax.swing.JButton btnExcluirId;
    private javax.swing.JButton btnExcluirPerfil;
    private javax.swing.JButton btnExcluirRec;
    private javax.swing.JButton btnNovoAtivar;
    private javax.swing.JButton btnNovoCadastro;
    private javax.swing.JButton btnNovoContrato;
    private javax.swing.JButton btnNovoId;
    private javax.swing.JButton btnNovoPerfil;
    private javax.swing.JButton btnNovoRec;
    private javax.swing.JButton btnSalvarAtivar;
    private javax.swing.JButton btnSalvarCadastro;
    private javax.swing.JButton btnSalvarContrato;
    private javax.swing.JButton btnSalvarId;
    private javax.swing.JButton btnSalvarPerfil;
    private javax.swing.JButton btnSalvarRec;
    private javax.swing.JComboBox cbTipoAtivar;
    private javax.swing.JComboBox cbTipoCadastro;
    private javax.swing.JComboBox cbTipoContrato;
    private javax.swing.JComboBox cbTipoId;
    private javax.swing.JComboBox cbTipoPerfil;
    private javax.swing.JComboBox cbTipoRec;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpAtivar;
    private javax.swing.JPanel jpCadId;
    private javax.swing.JPanel jpCadastro;
    public javax.swing.JPanel jpComercial;
    private javax.swing.JPanel jpContrato;
    private javax.swing.JPanel jpPerfil;
    private javax.swing.JPanel jpRecContrato;
    private javax.swing.JPanel jpSit;
    private javax.swing.JTabbedPane jtbGuia;
    private javax.swing.JLabel lbApelido;
    private javax.swing.JLabel lbAtivar;
    private javax.swing.JLabel lbCadastro;
    private javax.swing.JLabel lbCodAtivar;
    private javax.swing.JLabel lbCodCadastro;
    private javax.swing.JLabel lbCodContrato;
    private javax.swing.JLabel lbCodId;
    private javax.swing.JLabel lbCodPerfil;
    private javax.swing.JLabel lbCodRec;
    private javax.swing.JLabel lbContrato;
    private javax.swing.JLabel lbDataAtivar;
    private javax.swing.JLabel lbDataCadastro;
    private javax.swing.JLabel lbDataContrato;
    private javax.swing.JLabel lbDataId;
    private javax.swing.JLabel lbDataPerfil;
    private javax.swing.JLabel lbDataRec;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbObsAtivar;
    private javax.swing.JLabel lbObsCadastro;
    private javax.swing.JLabel lbObsContrato;
    private javax.swing.JLabel lbObsId;
    private javax.swing.JLabel lbObsPerfil;
    private javax.swing.JLabel lbObsRec;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JLabel lbRecContrato;
    private javax.swing.JLabel lbTipoAtivar;
    private javax.swing.JLabel lbTipoCadastro;
    private javax.swing.JLabel lbTipoContrato;
    private javax.swing.JLabel lbTipoId;
    private javax.swing.JLabel lbTipoPerfil;
    private javax.swing.JLabel lbTipoRec;
    private javax.swing.JLabel lbTitFase;
    private javax.swing.JLabel lbTitStatus;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTable tbAtivar;
    private javax.swing.JTable tbCadastro;
    private javax.swing.JTable tbContrato;
    private javax.swing.JTable tbId;
    private javax.swing.JTable tbPerfil;
    private javax.swing.JTable tbRec;
    public static javax.swing.JLabel txtAndamento;
    private javax.swing.JTextField txtCodAtivar;
    private javax.swing.JTextField txtCodCadastro;
    private javax.swing.JTextField txtCodContrato;
    private javax.swing.JTextField txtCodId;
    private javax.swing.JTextField txtCodPerfil;
    private javax.swing.JTextField txtCodRec;
    public static javax.swing.JLabel txtCodigo;
    private javax.swing.JFormattedTextField txtDataAtivar;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JFormattedTextField txtDataContrato;
    private javax.swing.JFormattedTextField txtDataId;
    private javax.swing.JFormattedTextField txtDataPerfil;
    private javax.swing.JFormattedTextField txtDataRec;
    public static javax.swing.JLabel txtId;
    private javax.swing.JTextField txtIdApelido;
    public static javax.swing.JLabel txtNome;
    private javax.swing.JTextArea txtObsAtivar;
    private javax.swing.JTextArea txtObsCadastro;
    private javax.swing.JTextArea txtObsContrato;
    private javax.swing.JTextArea txtObsId;
    private javax.swing.JTextArea txtObsPerfil;
    private javax.swing.JTextArea txtObsRec;
    public static javax.swing.JLabel txtStatusAtivar;
    public static javax.swing.JLabel txtStatusCadastro;
    public static javax.swing.JLabel txtStatusContrato;
    public static javax.swing.JLabel txtStatusId;
    public static javax.swing.JLabel txtStatusPerfil;
    public static javax.swing.JLabel txtStatusRecContratos;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    public void preencher_tabela_id() {
        
        tbId.getColumnModel().getColumn(0);
        tbId.getColumnModel().getColumn(1);
        tbId.getColumnModel().getColumn(2);
        tbId.getColumnModel().getColumn(3);
        tbId.getColumnModel().getColumn(4);
        tbId.getColumnModel().getColumn(5);

        con.executeSQL("select * from geraridnaplancadastro WHERE NumeroProcesso='" +processo+ "'");
        DefaultTableModel modelo = (DefaultTableModel) tbId.getModel();
        //modelo.setNumRows(0);

        try {

            while (con.resultset.next()) {
                modelo.addRow(new Object[]{
                    con.resultset.getString("CodGerarIdNaPlanCadastro"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoGerarIdNaPlanCadastro"),
                    con.resultset.getString("Usuario")});
            }
            con.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Gerar ID " + erro);
        }
    }

    public void preencher_tabela_cadastro() {
        tbCadastro.getColumnModel().getColumn(0);
        tbCadastro.getColumnModel().getColumn(1);
        tbCadastro.getColumnModel().getColumn(2);
        tbCadastro.getColumnModel().getColumn(3);
        tbCadastro.getColumnModel().getColumn(4);
        tbCadastro.getColumnModel().getColumn(5);
        con.executeSQL("select * from cadastrarcontrolecontimatic WHERE NumeroProcesso='" +processo+ "'");
        //
        DefaultTableModel modelo = (DefaultTableModel) tbCadastro.getModel();
        //modelo.setNumRows(0);
        try {
            while (con.resultset.next()) {
                modelo.addRow(new Object[]{
                    con.resultset.getString("CodCadastrarControlEContimatic"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoCadastrarControlEContimatic"),
                    con.resultset.getString("Usuario")});
            }
            con.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Cadastro " + erro);
        }
    }

    public void preencher_tabela_contrato() {
        tbContrato.getColumnModel().getColumn(0);
        tbContrato.getColumnModel().getColumn(1);
        tbContrato.getColumnModel().getColumn(2);
        tbContrato.getColumnModel().getColumn(3);
        tbContrato.getColumnModel().getColumn(4);
        tbContrato.getColumnModel().getColumn(5);
        con.executeSQL("select * from elaborarcontratodeprestacaodeservico where NumeroProcesso='" +processo+ "'");

        DefaultTableModel modelo = (DefaultTableModel) tbContrato.getModel();

        try {
            while (con.resultset.next()) {
                modelo.addRow(new Object[]{
                    con.resultset.getString("CodEleborarPropostaPrestacaoDeServico"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoElaborarPropostaPrestacaoDeServico"),
                    con.resultset.getString("Usuario")});
            }
            con.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Elaborar Contrato " + erro);
        }
    }

    public void limpar_tabela_id() {
        DefaultTableModel tbm = (DefaultTableModel) tbId.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    public void limpar_tabela_cadastro() {
        DefaultTableModel tbm = (DefaultTableModel) tbCadastro.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    public void limpar_tabela_contrato() {
        DefaultTableModel tbm = (DefaultTableModel) tbContrato.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    public void preencher_status() {
        try {
            String sql = "select * from contratos WHERE Numerodoprocesso='" +processo+ "'";
            con_geral.executeSQL(sql);
            con_geral.resultset.first();

            gerarid = con_geral.resultset.getString("AndamentoGerarIDPlanCadastro");
            cadastro = con_geral.resultset.getString("AndamentoCadastrarControlEContmatic");
            contratos = con_geral.resultset.getString("AndamentoElaborarContratoPrestacaoDeServico");
            receber = con_geral.resultset.getString("AndamentoReceberContratoAssCliente");
            ativar = con_geral.resultset.getString("AndamentoAtivarCliente");
            perfil = con_geral.resultset.getString("AndamentoElaborarPrefilFiscal");

            txtStatusId.setText(gerarid);
            txtStatusCadastro.setText(cadastro);
            txtStatusContrato.setText(contratos);
            txtStatusRecContratos.setText(receber);
            txtStatusAtivar.setText(ativar);
            txtStatusPerfil.setText(perfil);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao preencher status!\n" + erro);
        }
    }

    public void atualizar_cadastro_cliente() {

        if (txtStatusId.getText().equalsIgnoreCase("Em Aberto")
                && txtStatusCadastro.getText().equalsIgnoreCase("Em Aberto")
                && txtStatusContrato.getText().equalsIgnoreCase("Em Aberto")
                && txtStatusRecContratos.getText().equalsIgnoreCase("Em Aberto")
                && txtStatusAtivar.getText().equalsIgnoreCase("Em Aberto")
                && txtStatusPerfil.getText().equalsIgnoreCase("Em Aberto")) {

            try {
                String sql = "UPDATE cadastrodeprocesso set AndamentoContratos='Em Aberto' where codNumerodoprocesso=" + processo;
                con_geral.statement.executeUpdate(sql);

                String andamento = "Em Aberto";
                txtAndamento.setText(andamento);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" + erro);
            }
        } else if (txtStatusId.getText().equalsIgnoreCase("Em Aberto")
                || txtStatusCadastro.getText().equalsIgnoreCase("Em Aberto")
                || txtStatusContrato.getText().equalsIgnoreCase("Em Aberto")
                || txtStatusRecContratos.getText().equalsIgnoreCase("Em Aberto")
                || txtStatusAtivar.getText().equalsIgnoreCase("Em Aberto")
                || txtStatusPerfil.getText().equalsIgnoreCase("Em Aberto")) {

            try {
                String sql = "UPDATE cadastrodeprocesso set AndamentoContratos='Em Aberto' where codNumerodoprocesso=" + processo;
                con_geral.statement.executeUpdate(sql);

                String andamento = "Em Andamento";
                txtAndamento.setText(andamento);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" + erro);
            }
        } else if (txtStatusId.getText().equalsIgnoreCase("Finalizado")
                && txtStatusCadastro.getText().equalsIgnoreCase("Finalizado")
                && txtStatusContrato.getText().equalsIgnoreCase("Finalizado")
                && txtStatusRecContratos.getText().equalsIgnoreCase("Finalizado")
                && txtStatusAtivar.getText().equalsIgnoreCase("Finalizado")
                && txtStatusPerfil.getText().equalsIgnoreCase("Finalizado")) {

            try {
                String sql = "UPDATE cadastrodeprocesso set AndamentoContratos='Concluido' where codNumerodoprocesso=" + processo;
                con_geral.statement.executeUpdate(sql);

                String andamento = "Concluido";
                txtAndamento.setText(andamento);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" + erro);
            }
        }
        distribuir_cores();
    }

    public void distribuir_cores() {
        if (txtStatusId.getText().equalsIgnoreCase("Em Aberto")) {
            txtStatusId.setBackground(Color.red);
        } else {
            txtStatusId.setBackground(Color.green);
        }
        if (txtStatusCadastro.getText().equalsIgnoreCase("Em Aberto")) {
            txtStatusCadastro.setBackground(Color.red);
        } else {
            txtStatusCadastro.setBackground(Color.green);
        }
        if (txtStatusContrato.getText().equalsIgnoreCase("Em Aberto")) {
            txtStatusContrato.setBackground(Color.red);
        } else {
            txtStatusContrato.setBackground(Color.green);
        }
        if (txtStatusRecContratos.getText().equalsIgnoreCase("Em Aberto")) {
            txtStatusRecContratos.setBackground(Color.red);
        } else {
            txtStatusRecContratos.setBackground(Color.green);
        }
        if (txtStatusAtivar.getText().equalsIgnoreCase("Em Aberto")) {
            txtStatusAtivar.setBackground(Color.red);
        } else {
            txtStatusAtivar.setBackground(Color.green);
        }
        if (txtStatusPerfil.getText().equalsIgnoreCase("Em Aberto")) {
            txtStatusPerfil.setBackground(Color.red);
        } else {
            txtStatusPerfil.setBackground(Color.green);
        }
        if (txtAndamento.getText().equalsIgnoreCase("Concluido")) {
            txtAndamento.setBackground(Color.green);
        } else if (txtAndamento.getText().equalsIgnoreCase("Em Andamento")) {
            txtAndamento.setBackground(Color.orange);
        } else {
            txtAndamento.setBackground(Color.red);
        }
    }

    public void limpar_tela_id() {
        txtCodId.setText("");
        txtObsId.setText("");
        txtCodId.setEditable(false);
        cbTipoId.setSelectedItem("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataId.setText(datahoje);

    }

    public void limpar_tela_cadastro() {
        txtCodCadastro.setEditable(false);
        txtCodCadastro.setText("");
        cbTipoCadastro.setSelectedItem("");
        txtObsCadastro.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataCadastro.setText(datahoje);
    }

    public void limpar_tela_contrato() {
        txtCodContrato.setEditable(false);
        txtCodContrato.setText("");
        cbTipoContrato.setSelectedItem("");
        txtObsContrato.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataContrato.setText(datahoje);
    }

    public void atualizar_id() {
        if (cbTipoId.getSelectedItem().equals("Finalizado")) {
            try {
                String sql = "UPDATE contratos set AndamentoGerarIDPlanCadastro='Finalizado' where Numerodoprocesso='" +processo+ "'";
                con_geral.statement.executeUpdate(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>GerarID\n" + erro);
            }
        } else {
            try {
                con_geral.executeSQL("select * from contratos where Numerodoprocesso='" +processo+ "' and AndamentoGerarIDPlanCadastro ='Finalizado'");
                if (con_geral.resultset.first()) {
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado

                    con_geral.executeSQL("select * from geraridnaplancadastro  where NumeroProcesso='" + processo
                            + "'and AndamentoGerarIdNaPlanCadastro='Finalizado'");

                    if (!con_geral.resultset.first()) {
                        try {

                            String sql = "UPDATE contratos set AndamentoGerarIDPlanCadastro='Em Aberto' where Numerodoprocesso='" +processo+ "'";
                            con_geral.statement.executeUpdate(sql);
                        } catch (SQLException erro) {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>GerarID\n" + erro);
                        }

                    }
                } else {
                    try {
                        String sql = "UPDATE contratos set AndamentoGerarIDPlanCadastro ='Em Aberto' where Numerodoprocesso='" + txtCodigo.getText() + "'";
                        con_geral.statement.executeUpdate(sql);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>GerarID\n" + erro);
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Contratos>GerarID \n" + erro);
            }

        }
    }

    public void atualizar_cadastro() {
        if (cbTipoCadastro.getSelectedItem().equals("Finalizado")) {
            try {
                String sql = "UPDATE contratos set AndamentoCadastrarControlEContmatic='Finalizado' where Numerodoprocesso='" +processo+ "'";
                con_geral.statement.executeUpdate(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos>Cadastro de Id:\n" + erro);
            }
        } else {
            try {
                con_geral.executeSQL("select * from contratos where Numerodoprocesso='" +processo+ "' and AndamentoCadastrarControlEContmatic ='Finalizado'");
                if (con_geral.resultset.next()) {
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado

                    con_geral.executeSQL("select * from cadastrarcontrolecontimatic where NumeroProcesso='" + processo
                            + "'and AndamentoCadastrarControlEContimatic='Finalizado'");

                    if (!con_geral.resultset.first()) {
                        try {

                            String sql = "UPDATE contratos set AndamentoCadastrarControlEContmatic='Em Aberto' where Numerodoprocesso='" +processo+ "'";
                            con_geral.statement.executeUpdate(sql);
                        } catch (SQLException erro) {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos>Cadastro de Id:\n" + erro);
                        }

                    }
                } else {
                    try {
                        String sql = "UPDATE contratos set AndamentoCadastroDependentesdoSocioADM ='Em Aberto' where Numerodoprocesso='" + txtCodigo.getText() + "'";
                        con_geral.statement.executeUpdate(sql);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Cadastro de Id\n" + erro);
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Contratos>Cadastro de Id\n" + erro);
            }

        }
    }

    public void atualizar_contrato() {
        if (cbTipoContrato.getSelectedItem().equals("Finalizado")) {
            try {
                String sql = "UPDATE contratos set AndamentoElaborarContratoPrestacaoDeServico='Finalizado' where Numerodoprocesso='" +processo+ "'";
                con_geral.statement.executeUpdate(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Elaborar Contrato\n" + erro);
            }
        } else {
            try {
                con_geral.executeSQL("select * from contratos where Numerodoprocesso='" +processo+ "' and AndamentoElaborarContratoPrestacaoDeServico ='Finalizado'");
                if (con_geral.resultset.next()) {
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado

                    con_geral.executeSQL("select * from elaborarcontratodeprestacaodeservico where NumeroProcesso='" +processo+ "'and AndamentoElaborarPropostaPrestacaoDeServico='Finalizado'");

                    if (!con_geral.resultset.first()) {
                        try {

                            String sql = "UPDATE contratos set AndamentoElaborarContratoPrestacaoDeServico='Em Aberto' where Numerodoprocesso='" +processo+ "'";
                            con_geral.statement.executeUpdate(sql);
                        } catch (SQLException erro) {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos>Elaborar Contrato\n" + erro);
                        }

                    }
                } else {
                    try {
                        String sql = "UPDATE contratos set AndamentoElaborarContratoPrestacaoDeServico ='Em Aberto' where Numerodoprocesso='" + txtCodigo.getText() + "'";
                        con_geral.statement.executeUpdate(sql);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Elaborar Contrato\n" + erro);
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Contratos>Elaborar Contrato\n" + erro);
            }

        }
    }

    public void bloquear_tela_cadastro() {
        txtCodCadastro.setEditable(false);
        txtDataCadastro.setEditable(false);
        cbTipoCadastro.setEditable(false);
        txtObsCadastro.setEditable(false);
    }

    public void desbloquear_tela_cadastro() {
        txtDataCadastro.setEditable(true);
        cbTipoCadastro.setEditable(true);
        txtObsCadastro.setEditable(true);
    }

    public void bloquear_tela_id() {
        txtCodId.setEditable(false);
        txtDataId.setEditable(false);
        cbTipoId.setEditable(false);
        txtObsId.setEditable(false);
    }

    public void desbloquear_tela_id() {
        txtDataId.setEditable(true);
        cbTipoId.setEditable(true);
        txtObsId.setEditable(true);
    }

    public void bloquear_tela_contrato() {
        txtCodContrato.setEditable(false);
        txtDataContrato.setEditable(false);
        cbTipoContrato.setEditable(false);
        txtObsContrato.setEditable(false);
    }

    public void desbloquear_tela_contrato() {
        txtDataContrato.setEditable(true);
        cbTipoContrato.setEditable(true);
        txtObsContrato.setEditable(true);
    }

    public void criar_backup_id() {
        codgerar_backup = txtCodId.getText();
        tipogerar_backup = (String) cbTipoId.getSelectedItem();
        datagerar_backup = txtDataId.getText();
        obsgerar_backup = txtObsId.getText();
    }

    public void restaurar_backup_id() {
        txtCodId.setText(codgerar_backup);
        cbTipoId.setSelectedItem(tipogerar_backup);
        txtDataId.setText(datagerar_backup);
        txtObsId.setText(obsgerar_backup);
    }

    public void criar_backup_cadastro() {
        codCad_backup = txtCodCadastro.getText();
        tipoCad_backup = (String) cbTipoCadastro.getSelectedItem();
        dataCad_backup = txtDataCadastro.getText();
        obsCad_backup = txtObsCadastro.getText();
    }

    public void restaurar_backup_cadastro() {
        txtCodCadastro.setText(codCad_backup);
        cbTipoCadastro.setSelectedItem(tipoCad_backup);
        txtDataCadastro.setText(dataCad_backup);
        txtObsCadastro.setText(obsCad_backup);
    }

    public void criar_backup_contrato() {
        codCont_backup = txtCodContrato.getText();
        tipoCont_backup = (String) cbTipoContrato.getSelectedItem();
        dataCont_backup = txtDataContrato.getText();
        obsCont_backup = txtObsContrato.getText();
    }

    public void restaurar_backup_contrato() {
        txtCodContrato.setText(codCont_backup);
        cbTipoContrato.setSelectedItem(tipoCont_backup);
        txtDataContrato.setText(dataCont_backup);
        txtObsContrato.setText(obsCont_backup);
    }

    public void criar_backup_receber() {
        codRec_backup = txtCodRec.getText();
        tipoRec_backup = (String) cbTipoRec.getSelectedItem();
        dataRec_backup = txtDataRec.getText();
        obsRec_backup = txtObsRec.getText();
    }

    public void limpar_tela_receber() {
        txtCodRec.setEditable(false);
        txtCodRec.setText("");
        cbTipoRec.setSelectedItem("");
        txtObsRec.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataRec.setText(datahoje);
    }

    public void desbloquear_tela_receber() {
        txtDataRec.setEditable(true);
        cbTipoRec.setEditable(true);
        txtObsRec.setEditable(true);
    }

    public void restaurar_backup_receber() {
        txtCodRec.setText(codRec_backup);
        cbTipoRec.setSelectedItem(tipoRec_backup);
        txtDataRec.setText(dataRec_backup);
        txtObsRec.setText(obsRec_backup);
    }

    public void atualizar_receber() {
        if (cbTipoRec.getSelectedItem().equals("Finalizado")) {
            try {
                String sql = "UPDATE contratos set AndamentoReceberContratoAssCliente='Finalizado' where Numerodoprocesso='" +processo+ "'";
                con_geral.statement.executeUpdate(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Receber Contrato\n" + erro);
            }
        } else {
            try {
                con_geral.executeSQL("select * from contratos where Numerodoprocesso='" +processo+ "' and AndamentoReceberContratoAssCliente ='Finalizado'");
                if (con_geral.resultset.next()) {
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado

                    con_geral.executeSQL("select * from recebercontratoasscliente where NumeroProcesso='" +processo+ "'and AndamentoReceberContratoAssCliente='Finalizado'");

                    if (!con_geral.resultset.first()) {
                        try {

                            String sql = "UPDATE contratos set AndamentoReceberContratoAssCliente='Em Aberto' where Numerodoprocesso='" +processo+ "'";
                            con_geral.statement.executeUpdate(sql);
                        } catch (SQLException erro) {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos>Receber Contrato\n" + erro);
                        }

                    }
                } else {
                    try {
                        String sql = "UPDATE contratos set AndamentoReceberContratoAssCliente ='Em Aberto' where Numerodoprocesso='" + txtCodigo.getText() + "'";
                        con_geral.statement.executeUpdate(sql);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Receber Contrato\n" + erro);
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Contratos>Receber Contrato\n" + erro);
            }

        }
    }

    public void limpar_tabela_receber() {
        DefaultTableModel tbm = (DefaultTableModel) tbRec.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    public void preencher_tabela_receber() {
        tbRec.getColumnModel().getColumn(0);
        tbRec.getColumnModel().getColumn(1);
        tbRec.getColumnModel().getColumn(2);
        tbRec.getColumnModel().getColumn(3);
        tbRec.getColumnModel().getColumn(4);
        tbRec.getColumnModel().getColumn(5);

        con.executeSQL("select * from recebercontratoasscliente WHERE NumeroProcesso='" +processo+ "'");
        DefaultTableModel modelo = (DefaultTableModel) tbRec.getModel();
        //modelo.setNumRows(0);

        try {

            while (con.resultset.next()) {
                modelo.addRow(new Object[]{
                    con.resultset.getString("CodReceberContratoAssCliente"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoReceberContratoAssCliente"),
                    con.resultset.getString("Usuario")});
            }
            con.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Receber Contrato " + erro);
        }
    }

    public void bloquear_tela_receber() {
        txtCodRec.setEditable(false);
        txtDataRec.setEditable(false);
        cbTipoRec.setEditable(false);
        txtObsRec.setEditable(false);
    }

    public void limpar_tela_ativar() {
        txtCodAtivar.setEditable(false);
        txtCodAtivar.setText("");
        cbTipoAtivar.setSelectedItem("");
        txtObsAtivar.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataAtivar.setText(datahoje);
    }

    public void criar_backup_ativar() {
        codAtivar_backup = txtCodAtivar.getText();
        tipoAtivar_backup = (String) cbTipoAtivar.getSelectedItem();
        dataAtivar_backup = txtDataAtivar.getText();
        obsAtivar_backup = txtObsAtivar.getText();
    }

    public void desbloquear_tela_ativar() {
        txtDataAtivar.setEditable(true);
        cbTipoAtivar.setEditable(true);
        txtObsAtivar.setEditable(true);
    }

    public void restaurar_backup_ativar() {
        txtCodAtivar.setText(codAtivar_backup);
        cbTipoAtivar.setSelectedItem(tipoAtivar_backup);
        txtDataAtivar.setText(dataAtivar_backup);
        txtObsAtivar.setText(obsAtivar_backup);
    }

    public void bloquear_tela_ativar() {
        txtCodAtivar.setEditable(false);
        txtDataAtivar.setEditable(false);
        cbTipoAtivar.setEditable(false);
        txtObsAtivar.setEditable(false);
    }

    public void preencher_tabela_ativar() {
        tbAtivar.getColumnModel().getColumn(0);
        tbAtivar.getColumnModel().getColumn(1);
        tbAtivar.getColumnModel().getColumn(2);
        tbAtivar.getColumnModel().getColumn(3);
        tbAtivar.getColumnModel().getColumn(4);
        tbAtivar.getColumnModel().getColumn(5);

        con.executeSQL("select * from ativarcliente WHERE NumeroProcesso='" +processo+ "'");
        DefaultTableModel modelo = (DefaultTableModel) tbAtivar.getModel();
        //modelo.setNumRows(0);

        try {

            while (con.resultset.next()) {
                modelo.addRow(new Object[]{
                    con.resultset.getString("CodAtivarCliente"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoAtivarCliente"),
                    con.resultset.getString("Usuario")});
            }
            con.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Ativar Cliente " + erro);
        }
    }

    public void limpar_tabela_ativar() {
        DefaultTableModel tbm = (DefaultTableModel) tbAtivar.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    public void criar_backup_perfil() {
        codPerfil_backup = txtCodPerfil.getText();
        tipoPerfil_backup = (String) cbTipoPerfil.getSelectedItem();
        dataPerfil_backup = txtDataPerfil.getText();
        obsPerfil_backup = txtObsPerfil.getText();
    }

    public void limpar_tela_perfil() {
        txtCodPerfil.setEditable(false);
        txtCodPerfil.setText("");
        cbTipoPerfil.setSelectedItem("");
        txtObsPerfil.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataPerfil.setText(datahoje);
    }

    public void desbloquear_tela_perfil() {
        txtDataRec.setEditable(true);
        cbTipoRec.setEditable(true);
        txtObsRec.setEditable(true);
    }

    public void bloquear_tela_perfil() {
        txtCodRec.setEditable(false);
        txtDataRec.setEditable(false);
        cbTipoRec.setEditable(false);
        txtObsRec.setEditable(false);
    }

    public void restaurar_backup_perfil() {
        txtCodPerfil.setText(codAtivar_backup);
        cbTipoPerfil.setSelectedItem(tipoAtivar_backup);
        txtDataPerfil.setText(dataAtivar_backup);
        txtObsPerfil.setText(obsAtivar_backup);
    }

    public void atualizar_ativar() {
        if (cbTipoAtivar.getSelectedItem().equals("Finalizado")) {
            try {
                String sql = "UPDATE contratos set AndamentoAtivarCliente='Finalizado' where Numerodoprocesso='" +processo+ "'";
                con_geral.statement.executeUpdate(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Ativar Cliente\n" + erro);
            }
        } else {
            try {
                con_geral.executeSQL("select * from contratos where Numerodoprocesso='" +processo+ "' and AndamentoAtivarCliente ='Finalizado'");
                if (con_geral.resultset.next()) {
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado

                    con_geral.executeSQL("select * from ativarcliente where NumeroProcesso='" +processo+ "' and AndamentoAtivarCliente='Finalizado'");

                    if (!con_geral.resultset.first()) {
                        try {

                            String sql = "UPDATE contratos set AndamentoAtivarCliente='Em Aberto' where Numerodoprocesso='" +processo+ "'";
                            con_geral.statement.executeUpdate(sql);
                        } catch (SQLException erro) {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos>Ativar Cliente\n" + erro);
                        }

                    }
                } else {
                    try {
                        String sql = "UPDATE contratos set AndamentoAtivarCliente ='Em Aberto' where Numerodoprocesso='" + txtCodigo.getText() + "'";
                        con_geral.statement.executeUpdate(sql);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Ativar Cliente\n" + erro);
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Contratos>Ativar Cliente\n" + erro);
            }

        }
    }

    public void atualizar_perfil() {
        if (cbTipoPerfil.getSelectedItem().equals("Finalizado")) {
            try {
                String sql = "UPDATE contratos set AndamentoElaborarPrefilFiscal='Finalizado' where Numerodoprocesso='" +processo+ "'";
                con_geral.statement.executeUpdate(sql);
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Perfil\n" + erro);
            }
        } else {
            try {
                con_geral.executeSQL("select * from contratos where Numerodoprocesso='" +processo+ "' and AndamentoElaborarPrefilFiscal ='Finalizado'");
                if (con_geral.resultset.first()) {
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado

                    con_geral.executeSQL("select * from elaborarperfilfiscal where NumeroProcesso='" + processo
                            + "' and AndamentoElaborarPerfilFiscal='Finalizado'");

                    if (!con_geral.resultset.first()) {
                        try {

                            String sql = "UPDATE contratos set AndamentoElaborarPrefilFiscal='Em Aberto' where Numerodoprocesso='" +processo+ "'";
                            con_geral.statement.executeUpdate(sql);
                        } catch (SQLException erro) {
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Contratos>Perfil\n" + erro);
                        }

                    }
                } else {
                    try {
                        String sql = "UPDATE contratos set AndamentoElaborarPrefilFiscal ='Em Aberto' where Numerodoprocesso='" + txtCodigo.getText() + "'";
                        con_geral.statement.executeUpdate(sql);
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Contratos>Perfil\n" + erro);
                    }
                }
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Contratos>Perfil\n" + erro);
            }

        }
    }

    public void limpar_tabela_perfil() {
        DefaultTableModel tbm = (DefaultTableModel) tbPerfil.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    public void preencher_tabela_perfil() {
        tbPerfil.getColumnModel().getColumn(0);
        tbPerfil.getColumnModel().getColumn(1);
        tbPerfil.getColumnModel().getColumn(2);
        tbPerfil.getColumnModel().getColumn(3);
        tbPerfil.getColumnModel().getColumn(4);
        tbPerfil.getColumnModel().getColumn(5);

        con.executeSQL("select * from elaborarperfilfiscal WHERE NumeroProcesso='" +processo+ "'");
        DefaultTableModel modelo = (DefaultTableModel) tbPerfil.getModel();
        //modelo.setNumRows(0);

        try {

            while (con.resultset.next()) {
                modelo.addRow(new Object[]{
                    con.resultset.getString("CodElaborarPerfilFiscal"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoElaborarPerfilFiscal"),
                    con.resultset.getString("Usuario")});
            }
            con.resultset.first();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar na tabela Elaborar Perfil Fiscal " + erro);
        }
    }
}
