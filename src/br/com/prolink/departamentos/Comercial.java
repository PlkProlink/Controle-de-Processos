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


public class Comercial extends javax.swing.JFrame {
    //conexão com as tabelas necessarias
    Conexao con_geral = new Conexao();
    Conexao con = new Conexao();
    //maskara para o JFormattedTextField
    MaskFormatter formatoDiagnose, formatoProposta, formatoOS, formatoDocumentos,
            formatoTaxa, formatoRecebimento,
            formatoCertidoes, formatoTermo, formatoSenhas;
                    
    //Formatador para data
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    String  diagnose, proposta, os, documentos, taxa, recebimento, certidoes, termo, senhas, 
            codDiagnose_backup, dataDiagnose_backup, obsDiagnose_backup, tipoDiagnose_backup,
            codProposta_backup, dataProposta_backup, obsProposta_backup, tipoProposta_backup,
            codOS_backup, dataOS_backup, obsOS_backup, tipoOS_backup,
            codDoc_backup, dataDoc_backup, obsDoc_backup, tipoDoc_backup,
            codTaxa_backup, dataTaxa_backup, obsTaxa_backup, tipoTaxa_backup,
            codRec_backup, dataRec_backup, obsRec_backup, tipoRec_backup,
            codCert_backup, dataCert_backup, obsCert_backup, tipoCert_backup,
            codTermo_backup, dataTermo_backup, obsTermo_backup, tipoTermo_backup,
            codSenhas_backup, dataSenhas_backup, obsSenhas_backup, tipoSenhas_backup;
    
    String processo=Ativador.processo, nome=Ativador.nome, id=Ativador.id, usuario=Login.usuario;

    public Comercial() {
        initComponents();
        //instanciando as conexoes e executando o metodo conecta
        
        con_geral.conecta();
        con.conecta();
        
        //chamando metodo que preencha as tabelas
        preencher_tabela_diagnose();
        preencher_tabela_proposta();
        preencher_tabela_os();
        preencher_tabela_documentos();
        preencher_tabela_taxa();
        preencher_tabela_recebimento();
        preencher_tabela_certidoes();
        preencher_tabela_termo();
        preencher_tabela_senhas();
        //chamando metodo que preencha tela de status
        preencher_status();
        
        atualizar_cadastro_cliente();
        
        bloquear_tela_diagnose();
        bloquear_tela_proposta();
        bloquear_tela_os();
        bloquear_tela_certidoes();
        bloquear_tela_documentos();
        bloquear_tela_recebimento();
        bloquear_tela_senhas();
        bloquear_tela_taxa();
        bloquear_tela_termo();
        
        
        limpar_tela_diagnose();
        limpar_tela_proposta();
        limpar_tela_os();
        limpar_tela_certidoes();
        limpar_tela_documentos();
        limpar_tela_recebimento();
        limpar_tela_senhas();
        limpar_tela_taxa();
        limpar_tela_termo();
        
        tbDiagnose.setAutoCreateRowSorter(true);
        tbProposta.setAutoCreateRowSorter(true);
        tbOS.setAutoCreateRowSorter(true);
        tbCertidoes.setAutoCreateRowSorter(true);
        tbDocumentos.setAutoCreateRowSorter(true);
        tbRecebimento.setAutoCreateRowSorter(true);
        tbSenhas.setAutoCreateRowSorter(true);
        tbTaxa.setAutoCreateRowSorter(true);
        tbTermo.setAutoCreateRowSorter(true);
        
        
        txtCodigo.setText(processo);
        txtNome.setText(nome);
        txtId.setText(id);
        txtUsuario.setText(usuario);
        
        if(!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Comercial")){
            
            btnExcluirDiagnose.setEnabled(false);
            btnSalvarDiagnose.setEnabled(false);
            
            btnExcluirProposta.setEnabled(false);
            btnSalvarProposta.setEnabled(false);
            
            btnExcluirOS.setEnabled(false);
            btnSalvarOS.setEnabled(false);
            
            btnSalvarDocumentos.setEnabled(false);
            btnExcluirDocumentos.setEnabled(false);
            
            btnSalvarCertidoes.setEnabled(false);
            btnCancelarCertidoes.setEnabled(false);
            
            btnSalvarRecebimento.setEnabled(false);
            btnCancelarRecebimento.setEnabled(false);
            
            btnSalvarTaxa.setEnabled(false);
            btnCancelarTaxa.setEnabled(false);
            
            btnSalvarSenhas.setEnabled(false);
            btnCancelarSenhas.setEnabled(false);
            
            btnSalvarTermo.setEnabled(false);
            btnCancelarTermo.setEnabled(false);
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
        lbDiagnose = new javax.swing.JLabel();
        txtStatusDiagnose = new javax.swing.JLabel();
        lbProposta = new javax.swing.JLabel();
        txtStatusProposta = new javax.swing.JLabel();
        lbOS = new javax.swing.JLabel();
        txtStatusOS = new javax.swing.JLabel();
        txtAndamento = new javax.swing.JLabel();
        txtStatusTaxa = new javax.swing.JLabel();
        lbRecebimento = new javax.swing.JLabel();
        txtStatusRecebimento = new javax.swing.JLabel();
        lbDocumentos = new javax.swing.JLabel();
        txtStatusDocumentos = new javax.swing.JLabel();
        lbTaxa = new javax.swing.JLabel();
        lbCertidoes = new javax.swing.JLabel();
        txtStatusCertidoes = new javax.swing.JLabel();
        lbTermo = new javax.swing.JLabel();
        txtStatusSenhas = new javax.swing.JLabel();
        txtStatusTermo = new javax.swing.JLabel();
        lbSenhas = new javax.swing.JLabel();
        jpCadDiagnose = new javax.swing.JPanel();
        lbCodDiagnose = new javax.swing.JLabel();
        txtCodDiagnose = new javax.swing.JTextField();
        lbDataDiagnose = new javax.swing.JLabel();
        lbObsDiagnose = new javax.swing.JLabel();
        try {
     formatoDiagnose = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local diagnose: \n" +erro);
 }
        txtDataDiagnose = new JFormattedTextField(formatoDiagnose);
        lbTipoDiagnose = new javax.swing.JLabel();
        cbTipoDiagnose = new javax.swing.JComboBox();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtObsDiagnose = new javax.swing.JTextArea();
        btnNovoDiagnose = new javax.swing.JButton();
        btnAlterarDiagnose = new javax.swing.JButton();
        btnSalvarDiagnose = new javax.swing.JButton();
        btnCancelarDiagnose = new javax.swing.JButton();
        btnExcluirDiagnose = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbDiagnose = new javax.swing.JTable();
        jpProposta = new javax.swing.JPanel();
        lbCodProposta = new javax.swing.JLabel();
        txtCodProposta = new javax.swing.JTextField();
        lbDataProposta = new javax.swing.JLabel();
        try {
            formatoProposta = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em proposta: \n" +erro);
        }
        txtDataProposta = new JFormattedTextField(formatoProposta);
        lbTipoProposta = new javax.swing.JLabel();
        cbTipoProposta = new javax.swing.JComboBox();
        lbObsProposta = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtObsProposta = new javax.swing.JTextArea();
        btnNovoProposta = new javax.swing.JButton();
        btnAlterarProposta = new javax.swing.JButton();
        btnSalvarProposta = new javax.swing.JButton();
        btnCancelarProposta = new javax.swing.JButton();
        btnExcluirProposta = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbProposta = new javax.swing.JTable();
        jpOS = new javax.swing.JPanel();
        lbCodOS = new javax.swing.JLabel();
        txtCodOS = new javax.swing.JTextField();
        lbDataOS = new javax.swing.JLabel();
        try {
            formatoOS = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data em Gerar O.S.: " +erro);
        }
        txtDataOS = new JFormattedTextField(formatoOS);
        lbTipoOS = new javax.swing.JLabel();
        cbTipoOS = new javax.swing.JComboBox();
        lbObsOS = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtObsOS = new javax.swing.JTextArea();
        btnNovoOS = new javax.swing.JButton();
        btnAlterarOS = new javax.swing.JButton();
        btnSalvarOS = new javax.swing.JButton();
        btnCancelarOS = new javax.swing.JButton();
        btnExcluirOS = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbOS = new javax.swing.JTable();
        jpCadDocumentos = new javax.swing.JPanel();
        lbCodDocumentos = new javax.swing.JLabel();
        txtCodDocumentos = new javax.swing.JTextField();
        lbDataDocumentos = new javax.swing.JLabel();
        lbObsDocumentos = new javax.swing.JLabel();
        try {
     formatoDocumentos = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local documentos: " +erro);
 }
        txtDataDocumentos = new JFormattedTextField(formatoDocumentos);
        lbTipoDocumentos = new javax.swing.JLabel();
        cbTipoDocumentos = new javax.swing.JComboBox();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtObsDocumentos = new javax.swing.JTextArea();
        btnNovoDocumentos = new javax.swing.JButton();
        btnAlterarDocumentos = new javax.swing.JButton();
        btnSalvarDocumentos = new javax.swing.JButton();
        btnCancelarDocumentos = new javax.swing.JButton();
        btnExcluirDocumentos = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tbDocumentos = new javax.swing.JTable();
        jpCadTaxa = new javax.swing.JPanel();
        lbCodTaxa = new javax.swing.JLabel();
        txtCodTaxa = new javax.swing.JTextField();
        lbDataTaxa = new javax.swing.JLabel();
        lbObsTaxa = new javax.swing.JLabel();
        try {
     formatoTaxa = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local Taxa: " +erro);
 }
        txtDataTaxa = new JFormattedTextField(formatoTaxa);
        lbTipoTaxa = new javax.swing.JLabel();
        cbTipoTaxa = new javax.swing.JComboBox();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtObsTaxa = new javax.swing.JTextArea();
        btnNovoTaxa = new javax.swing.JButton();
        btnAlterarTaxa = new javax.swing.JButton();
        btnSalvarTaxa = new javax.swing.JButton();
        btnCancelarTaxa = new javax.swing.JButton();
        btnExcluirTaxa = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tbTaxa = new javax.swing.JTable();
        jpCadRecebimento = new javax.swing.JPanel();
        lbCodRecebimento = new javax.swing.JLabel();
        txtCodRecebimento = new javax.swing.JTextField();
        lbDataRecebimento = new javax.swing.JLabel();
        lbObsRecebimento = new javax.swing.JLabel();
        try {
     formatoRecebimento = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local Recebimento: " +erro);
 }
        txtDataRecebimento = new JFormattedTextField(formatoRecebimento);
        lbTipoRecebimento = new javax.swing.JLabel();
        cbTipoRecebimento = new javax.swing.JComboBox();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtObsRecebimento = new javax.swing.JTextArea();
        btnNovoRecebimento = new javax.swing.JButton();
        btnAlterarRecebimento = new javax.swing.JButton();
        btnSalvarRecebimento = new javax.swing.JButton();
        btnCancelarRecebimento = new javax.swing.JButton();
        btnExcluirRecebimento = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        tbRecebimento = new javax.swing.JTable();
        jpCadCertidoes = new javax.swing.JPanel();
        lbCodCertidoes = new javax.swing.JLabel();
        txtCodCertidoes = new javax.swing.JTextField();
        lbDataCertidoes = new javax.swing.JLabel();
        lbObsCertidoes = new javax.swing.JLabel();
        try {
     formatoCertidoes = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local Certidoes: \n" +erro);
 }
        txtDataCertidoes = new JFormattedTextField(formatoCertidoes);
        lbTipoCertidoes = new javax.swing.JLabel();
        cbTipoCertidoes = new javax.swing.JComboBox();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtObsCertidoes = new javax.swing.JTextArea();
        btnNovoCertidoes = new javax.swing.JButton();
        btnAlterarCertidoes = new javax.swing.JButton();
        btnSalvarCertidoes = new javax.swing.JButton();
        btnCancelarCertidoes = new javax.swing.JButton();
        btnExcluirCertidoes = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        tbCertidoes = new javax.swing.JTable();
        jpCadTermo = new javax.swing.JPanel();
        lbCodTermo = new javax.swing.JLabel();
        txtCodTermo = new javax.swing.JTextField();
        lbDataTermo = new javax.swing.JLabel();
        lbObsTermo = new javax.swing.JLabel();
        try {
     formatoTermo = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local Termo: \n" +erro);
 }
        txtDataTermo = new JFormattedTextField(formatoTermo);
        lbTipoTermo = new javax.swing.JLabel();
        cbTipoTermo = new javax.swing.JComboBox();
        jScrollPane20 = new javax.swing.JScrollPane();
        txtObsTermo = new javax.swing.JTextArea();
        btnNovoTermo = new javax.swing.JButton();
        btnAlterarTermo = new javax.swing.JButton();
        btnSalvarTermo = new javax.swing.JButton();
        btnCancelarTermo = new javax.swing.JButton();
        btnExcluirTermo = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        tbTermo = new javax.swing.JTable();
        jpCadSenhas = new javax.swing.JPanel();
        lbCodSenhas = new javax.swing.JLabel();
        txtCodSenhas = new javax.swing.JTextField();
        lbDataSenhas = new javax.swing.JLabel();
        lbObsSenhas = new javax.swing.JLabel();
        try {
     formatoSenhas = new MaskFormatter("##/##/####");
 }catch(Exception erro){
     JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data no local Senhas: " +erro);
 }
        txtDataSenhas = new JFormattedTextField(formatoSenhas);
        lbTipoSenhas = new javax.swing.JLabel();
        cbTipoSenhas = new javax.swing.JComboBox();
        jScrollPane22 = new javax.swing.JScrollPane();
        txtObsSenhas = new javax.swing.JTextArea();
        btnNovoSenhas = new javax.swing.JButton();
        btnAlterarSenhas = new javax.swing.JButton();
        btnSalvarSenhas = new javax.swing.JButton();
        btnCancelarSenhas = new javax.swing.JButton();
        btnExcluirSenhas = new javax.swing.JButton();
        jScrollPane23 = new javax.swing.JScrollPane();
        tbSenhas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comercial");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpComercial.setBackground(new java.awt.Color(245, 245, 245));

        lb_titulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("Controle Comercial");
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

        jtbGuia.setToolTipText("");
        jtbGuia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jpSit.setBackground(new java.awt.Color(245, 245, 245));

        lbTitFase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitFase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitFase.setText("Fase:");

        lbTitStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitStatus.setText("Status:");

        lbDiagnose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDiagnose.setText("Envio Diagnose:");

        txtStatusDiagnose.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusDiagnose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusDiagnose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusDiagnose.setOpaque(true);

        lbProposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbProposta.setText("Proposta Comercial:");

        txtStatusProposta.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusProposta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusProposta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusProposta.setOpaque(true);

        lbOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbOS.setText("Gerar O.S:");

        txtStatusOS.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusOS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusOS.setOpaque(true);

        txtAndamento.setBackground(new java.awt.Color(245, 245, 245));
        txtAndamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAndamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAndamento.setToolTipText("");
        txtAndamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAndamento.setOpaque(true);

        txtStatusTaxa.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusTaxa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusTaxa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusTaxa.setOpaque(true);

        lbRecebimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbRecebimento.setText("Confirmar Recebimento (Depósito):");

        txtStatusRecebimento.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusRecebimento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusRecebimento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusRecebimento.setOpaque(true);

        lbDocumentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDocumentos.setText("Requisição de Documentos:");

        txtStatusDocumentos.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusDocumentos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusDocumentos.setOpaque(true);

        lbTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTaxa.setText("Taxa Implantação:");

        lbCertidoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCertidoes.setText("Pesquisa de Certidões:");

        txtStatusCertidoes.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusCertidoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusCertidoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusCertidoes.setOpaque(true);

        lbTermo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTermo.setText("Termo de Responsabilidade Técnica:");

        txtStatusSenhas.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusSenhas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusSenhas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusSenhas.setOpaque(true);

        txtStatusTermo.setBackground(new java.awt.Color(245, 245, 245));
        txtStatusTermo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtStatusTermo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtStatusTermo.setOpaque(true);

        lbSenhas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSenhas.setText("Gravar Senhas Fiscais:");

        javax.swing.GroupLayout jpSitLayout = new javax.swing.GroupLayout(jpSit);
        jpSit.setLayout(jpSitLayout);
        jpSitLayout.setHorizontalGroup(
            jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addComponent(lbTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(txtStatusTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addComponent(lbSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtStatusSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addComponent(lbCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(txtStatusCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addComponent(lbTitFase, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(lbTitStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitLayout.createSequentialGroup()
                            .addComponent(lbTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(121, 121, 121)
                            .addComponent(txtStatusTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpSitLayout.createSequentialGroup()
                            .addComponent(lbRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(txtStatusRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpSitLayout.createSequentialGroup()
                            .addComponent(lbDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(txtStatusDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSitLayout.createSequentialGroup()
                            .addComponent(lbDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(txtStatusDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpSitLayout.createSequentialGroup()
                                .addComponent(lbProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(txtStatusProposta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpSitLayout.createSequentialGroup()
                                .addComponent(lbOS, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtStatusOS, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59))
            .addGroup(jpSitLayout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(txtAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lbDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusOS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStatusCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jpSitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpSitLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtStatusSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAndamento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jtbGuia.addTab("Situação", jpSit);

        jpCadDiagnose.setBackground(new java.awt.Color(245, 245, 245));

        lbCodDiagnose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodDiagnose.setText("Cod:");

        lbDataDiagnose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataDiagnose.setText("Data:");

        lbObsDiagnose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsDiagnose.setText("Observação:");

        lbTipoDiagnose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoDiagnose.setText("Tipo:");

        cbTipoDiagnose.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoDiagnose.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsDiagnose.setColumns(20);
        txtObsDiagnose.setLineWrap(true);
        txtObsDiagnose.setRows(5);
        jScrollPane9.setViewportView(txtObsDiagnose);

        btnNovoDiagnose.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoDiagnose.setText("Novo");
        btnNovoDiagnose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDiagnoseActionPerformed(evt);
            }
        });

        btnAlterarDiagnose.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarDiagnose.setText("Alterar");
        btnAlterarDiagnose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDiagnoseActionPerformed(evt);
            }
        });

        btnSalvarDiagnose.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarDiagnose.setText("Salvar");
        btnSalvarDiagnose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDiagnoseActionPerformed(evt);
            }
        });

        btnCancelarDiagnose.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarDiagnose.setText("Cancelar");
        btnCancelarDiagnose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDiagnoseActionPerformed(evt);
            }
        });

        btnExcluirDiagnose.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirDiagnose.setText("Excluir");
        btnExcluirDiagnose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDiagnoseActionPerformed(evt);
            }
        });

        tbDiagnose.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDiagnose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDiagnoseMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbDiagnose);
        if (tbDiagnose.getColumnModel().getColumnCount() > 0) {
            tbDiagnose.getColumnModel().getColumn(0).setMaxWidth(30);
            tbDiagnose.getColumnModel().getColumn(1).setMaxWidth(70);
            tbDiagnose.getColumnModel().getColumn(2).setMaxWidth(90);
            tbDiagnose.getColumnModel().getColumn(4).setMaxWidth(150);
            tbDiagnose.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadDiagnoseLayout = new javax.swing.GroupLayout(jpCadDiagnose);
        jpCadDiagnose.setLayout(jpCadDiagnoseLayout);
        jpCadDiagnoseLayout.setHorizontalGroup(
            jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                        .addComponent(lbCodDiagnose)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                        .addComponent(lbDataDiagnose)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoDiagnose)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                        .addComponent(lbObsDiagnose)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                                .addComponent(btnNovoDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9)))))
        );
        jpCadDiagnoseLayout.setVerticalGroup(
            jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodDiagnose))
                    .addComponent(txtCodDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataDiagnose))
                    .addComponent(txtDataDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadDiagnoseLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoDiagnose))
                    .addComponent(cbTipoDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsDiagnose)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovoDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvarDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadDiagnoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAlterarDiagnose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Envio Diagnose", jpCadDiagnose);

        jpProposta.setBackground(new java.awt.Color(245, 245, 245));

        lbCodProposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodProposta.setText("Cod:");

        lbDataProposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataProposta.setText("Data:");

        lbTipoProposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoProposta.setText("Tipo:");

        cbTipoProposta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoProposta.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        lbObsProposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsProposta.setText("Observação:");

        txtObsProposta.setColumns(20);
        txtObsProposta.setLineWrap(true);
        txtObsProposta.setRows(5);
        jScrollPane7.setViewportView(txtObsProposta);

        btnNovoProposta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoProposta.setText("Novo");
        btnNovoProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPropostaActionPerformed(evt);
            }
        });

        btnAlterarProposta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarProposta.setText("Alterar");
        btnAlterarProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarPropostaActionPerformed(evt);
            }
        });

        btnSalvarProposta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarProposta.setText("Salvar");
        btnSalvarProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPropostaActionPerformed(evt);
            }
        });

        btnCancelarProposta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarProposta.setText("Cancelar");
        btnCancelarProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPropostaActionPerformed(evt);
            }
        });

        btnExcluirProposta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirProposta.setText("Excluir");
        btnExcluirProposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPropostaActionPerformed(evt);
            }
        });

        tbProposta.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProposta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPropostaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbProposta);
        if (tbProposta.getColumnModel().getColumnCount() > 0) {
            tbProposta.getColumnModel().getColumn(0).setMaxWidth(30);
            tbProposta.getColumnModel().getColumn(1).setMaxWidth(70);
            tbProposta.getColumnModel().getColumn(2).setMaxWidth(90);
            tbProposta.getColumnModel().getColumn(4).setMaxWidth(150);
            tbProposta.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpPropostaLayout = new javax.swing.GroupLayout(jpProposta);
        jpProposta.setLayout(jpPropostaLayout);
        jpPropostaLayout.setHorizontalGroup(
            jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPropostaLayout.createSequentialGroup()
                .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPropostaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPropostaLayout.createSequentialGroup()
                                .addComponent(lbCodProposta)
                                .addGap(115, 115, 115)
                                .addComponent(txtCodProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPropostaLayout.createSequentialGroup()
                                .addComponent(lbDataProposta)
                                .addGap(111, 111, 111)
                                .addComponent(txtDataProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbTipoProposta)
                                .addGap(18, 18, 18)
                                .addComponent(cbTipoProposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPropostaLayout.createSequentialGroup()
                                .addComponent(lbObsProposta)
                                .addGap(73, 73, 73)
                                .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpPropostaLayout.createSequentialGroup()
                                        .addComponent(btnNovoProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAlterarProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvarProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelarProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExcluirProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpPropostaLayout.setVerticalGroup(
            jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPropostaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPropostaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodProposta))
                    .addComponent(txtCodProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPropostaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataProposta))
                    .addComponent(txtDataProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPropostaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoProposta))
                    .addComponent(cbTipoProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsProposta)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPropostaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirProposta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jpPropostaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCodProposta, txtDataProposta});

        jtbGuia.addTab("Proposta Com.", jpProposta);

        jpOS.setBackground(new java.awt.Color(245, 245, 245));

        lbCodOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodOS.setText("Cod:");

        lbDataOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataOS.setText("Data:");

        lbTipoOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoOS.setText("Tipo:");

        cbTipoOS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoOS.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        lbObsOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsOS.setText("Observação:");

        txtObsOS.setColumns(20);
        txtObsOS.setLineWrap(true);
        txtObsOS.setRows(5);
        jScrollPane10.setViewportView(txtObsOS);

        btnNovoOS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoOS.setText("Novo");
        btnNovoOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoOSActionPerformed(evt);
            }
        });

        btnAlterarOS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarOS.setText("Alterar");
        btnAlterarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarOSActionPerformed(evt);
            }
        });

        btnSalvarOS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarOS.setText("Salvar");
        btnSalvarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarOSActionPerformed(evt);
            }
        });

        btnCancelarOS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarOS.setText("Cancelar");
        btnCancelarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOSActionPerformed(evt);
            }
        });

        btnExcluirOS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirOS.setText("Excluir");
        btnExcluirOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirOSActionPerformed(evt);
            }
        });

        tbOS.setModel(new javax.swing.table.DefaultTableModel(
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
        tbOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOSMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tbOS);
        if (tbOS.getColumnModel().getColumnCount() > 0) {
            tbOS.getColumnModel().getColumn(0).setMaxWidth(30);
            tbOS.getColumnModel().getColumn(1).setMaxWidth(70);
            tbOS.getColumnModel().getColumn(2).setMaxWidth(90);
            tbOS.getColumnModel().getColumn(4).setMaxWidth(150);
            tbOS.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpOSLayout = new javax.swing.GroupLayout(jpOS);
        jpOS.setLayout(jpOSLayout);
        jpOSLayout.setHorizontalGroup(
            jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpOSLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOSLayout.createSequentialGroup()
                        .addComponent(lbCodOS)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodOS, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOSLayout.createSequentialGroup()
                        .addComponent(lbDataOS)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataOS, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoOS)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOSLayout.createSequentialGroup()
                        .addComponent(lbObsOS)
                        .addGap(73, 73, 73)
                        .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpOSLayout.createSequentialGroup()
                                .addComponent(btnNovoOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirOS, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10)))))
        );
        jpOSLayout.setVerticalGroup(
            jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOSLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOSLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodOS))
                    .addComponent(txtCodOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOSLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataOS))
                    .addComponent(txtDataOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpOSLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoOS))
                    .addComponent(cbTipoOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsOS)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoOS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirOS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("O.S", jpOS);

        jpCadDocumentos.setBackground(new java.awt.Color(245, 245, 245));

        lbCodDocumentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodDocumentos.setText("Cod:");

        lbDataDocumentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataDocumentos.setText("Data:");

        lbObsDocumentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsDocumentos.setText("Observação:");

        lbTipoDocumentos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoDocumentos.setText("Tipo:");

        cbTipoDocumentos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoDocumentos.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsDocumentos.setColumns(20);
        txtObsDocumentos.setLineWrap(true);
        txtObsDocumentos.setRows(5);
        jScrollPane12.setViewportView(txtObsDocumentos);

        btnNovoDocumentos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoDocumentos.setText("Novo");
        btnNovoDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDocumentosActionPerformed(evt);
            }
        });

        btnAlterarDocumentos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarDocumentos.setText("Alterar");
        btnAlterarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarDocumentosActionPerformed(evt);
            }
        });

        btnSalvarDocumentos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarDocumentos.setText("Salvar");
        btnSalvarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDocumentosActionPerformed(evt);
            }
        });

        btnCancelarDocumentos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarDocumentos.setText("Cancelar");
        btnCancelarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDocumentosActionPerformed(evt);
            }
        });

        btnExcluirDocumentos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirDocumentos.setText("Excluir");
        btnExcluirDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDocumentosActionPerformed(evt);
            }
        });

        tbDocumentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDocumentosMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tbDocumentos);
        if (tbDocumentos.getColumnModel().getColumnCount() > 0) {
            tbDocumentos.getColumnModel().getColumn(0).setMaxWidth(30);
            tbDocumentos.getColumnModel().getColumn(1).setMaxWidth(70);
            tbDocumentos.getColumnModel().getColumn(2).setMaxWidth(90);
            tbDocumentos.getColumnModel().getColumn(4).setMaxWidth(150);
            tbDocumentos.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadDocumentosLayout = new javax.swing.GroupLayout(jpCadDocumentos);
        jpCadDocumentos.setLayout(jpCadDocumentosLayout);
        jpCadDocumentosLayout.setHorizontalGroup(
            jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                        .addComponent(lbCodDocumentos)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                        .addComponent(lbDataDocumentos)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoDocumentos)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                        .addComponent(lbObsDocumentos)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                                .addComponent(btnNovoDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane12)))))
        );
        jpCadDocumentosLayout.setVerticalGroup(
            jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodDocumentos))
                    .addComponent(txtCodDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataDocumentos))
                    .addComponent(txtDataDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadDocumentosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoDocumentos))
                    .addComponent(cbTipoDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsDocumentos)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadDocumentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Req.Documentos", jpCadDocumentos);

        jpCadTaxa.setBackground(new java.awt.Color(245, 245, 245));

        lbCodTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodTaxa.setText("Cod:");

        lbDataTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataTaxa.setText("Data:");

        lbObsTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsTaxa.setText("Observação:");

        lbTipoTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoTaxa.setText("Tipo:");

        cbTipoTaxa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoTaxa.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsTaxa.setColumns(20);
        txtObsTaxa.setLineWrap(true);
        txtObsTaxa.setRows(5);
        jScrollPane14.setViewportView(txtObsTaxa);

        btnNovoTaxa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoTaxa.setText("Novo");
        btnNovoTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTaxaActionPerformed(evt);
            }
        });

        btnAlterarTaxa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarTaxa.setText("Alterar");
        btnAlterarTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTaxaActionPerformed(evt);
            }
        });

        btnSalvarTaxa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarTaxa.setText("Salvar");
        btnSalvarTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarTaxaActionPerformed(evt);
            }
        });

        btnCancelarTaxa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarTaxa.setText("Cancelar");
        btnCancelarTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTaxaActionPerformed(evt);
            }
        });

        btnExcluirTaxa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirTaxa.setText("Excluir");
        btnExcluirTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTaxaActionPerformed(evt);
            }
        });

        tbTaxa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTaxa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaxaMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tbTaxa);
        if (tbTaxa.getColumnModel().getColumnCount() > 0) {
            tbTaxa.getColumnModel().getColumn(0).setMaxWidth(30);
            tbTaxa.getColumnModel().getColumn(1).setMaxWidth(70);
            tbTaxa.getColumnModel().getColumn(2).setMaxWidth(90);
            tbTaxa.getColumnModel().getColumn(4).setMaxWidth(150);
            tbTaxa.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadTaxaLayout = new javax.swing.GroupLayout(jpCadTaxa);
        jpCadTaxa.setLayout(jpCadTaxaLayout);
        jpCadTaxaLayout.setHorizontalGroup(
            jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadTaxaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTaxaLayout.createSequentialGroup()
                        .addComponent(lbCodTaxa)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadTaxaLayout.createSequentialGroup()
                        .addComponent(lbDataTaxa)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoTaxa)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadTaxaLayout.createSequentialGroup()
                        .addComponent(lbObsTaxa)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadTaxaLayout.createSequentialGroup()
                                .addComponent(btnNovoTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane14)))))
        );
        jpCadTaxaLayout.setVerticalGroup(
            jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadTaxaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTaxaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodTaxa))
                    .addComponent(txtCodTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTaxaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataTaxa))
                    .addComponent(txtDataTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadTaxaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoTaxa))
                    .addComponent(cbTipoTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsTaxa)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadTaxaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Taxa Implantação", jpCadTaxa);

        jpCadRecebimento.setBackground(new java.awt.Color(245, 245, 245));

        lbCodRecebimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodRecebimento.setText("Cod:");

        lbDataRecebimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataRecebimento.setText("Data:");

        lbObsRecebimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsRecebimento.setText("Observação:");

        lbTipoRecebimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoRecebimento.setText("Tipo:");

        cbTipoRecebimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoRecebimento.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsRecebimento.setColumns(20);
        txtObsRecebimento.setLineWrap(true);
        txtObsRecebimento.setRows(5);
        jScrollPane16.setViewportView(txtObsRecebimento);

        btnNovoRecebimento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoRecebimento.setText("Novo");
        btnNovoRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoRecebimentoActionPerformed(evt);
            }
        });

        btnAlterarRecebimento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarRecebimento.setText("Alterar");
        btnAlterarRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRecebimentoActionPerformed(evt);
            }
        });

        btnSalvarRecebimento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarRecebimento.setText("Salvar");
        btnSalvarRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarRecebimentoActionPerformed(evt);
            }
        });

        btnCancelarRecebimento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarRecebimento.setText("Cancelar");
        btnCancelarRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRecebimentoActionPerformed(evt);
            }
        });

        btnExcluirRecebimento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirRecebimento.setText("Excluir");
        btnExcluirRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirRecebimentoActionPerformed(evt);
            }
        });

        tbRecebimento.setModel(new javax.swing.table.DefaultTableModel(
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
        tbRecebimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRecebimentoMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tbRecebimento);
        if (tbRecebimento.getColumnModel().getColumnCount() > 0) {
            tbRecebimento.getColumnModel().getColumn(0).setMaxWidth(30);
            tbRecebimento.getColumnModel().getColumn(1).setMaxWidth(70);
            tbRecebimento.getColumnModel().getColumn(2).setMaxWidth(90);
            tbRecebimento.getColumnModel().getColumn(4).setMaxWidth(150);
            tbRecebimento.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadRecebimentoLayout = new javax.swing.GroupLayout(jpCadRecebimento);
        jpCadRecebimento.setLayout(jpCadRecebimentoLayout);
        jpCadRecebimentoLayout.setHorizontalGroup(
            jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                        .addComponent(lbCodRecebimento)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                        .addComponent(lbDataRecebimento)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoRecebimento)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                        .addComponent(lbObsRecebimento)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                                .addComponent(btnNovoRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane16)))))
        );
        jpCadRecebimentoLayout.setVerticalGroup(
            jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodRecebimento))
                    .addComponent(txtCodRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataRecebimento))
                    .addComponent(txtDataRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadRecebimentoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoRecebimento))
                    .addComponent(cbTipoRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsRecebimento)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadRecebimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Confirmar Recebimento", jpCadRecebimento);

        jpCadCertidoes.setBackground(new java.awt.Color(245, 245, 245));

        lbCodCertidoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodCertidoes.setText("Cod:");

        lbDataCertidoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataCertidoes.setText("Data:");

        lbObsCertidoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsCertidoes.setText("Observação:");

        lbTipoCertidoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoCertidoes.setText("Tipo:");

        cbTipoCertidoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoCertidoes.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsCertidoes.setColumns(20);
        txtObsCertidoes.setLineWrap(true);
        txtObsCertidoes.setRows(5);
        jScrollPane18.setViewportView(txtObsCertidoes);

        btnNovoCertidoes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoCertidoes.setText("Novo");
        btnNovoCertidoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCertidoesActionPerformed(evt);
            }
        });

        btnAlterarCertidoes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarCertidoes.setText("Alterar");
        btnAlterarCertidoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCertidoesActionPerformed(evt);
            }
        });

        btnSalvarCertidoes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarCertidoes.setText("Salvar");
        btnSalvarCertidoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarCertidoesActionPerformed(evt);
            }
        });

        btnCancelarCertidoes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarCertidoes.setText("Cancelar");
        btnCancelarCertidoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCertidoesActionPerformed(evt);
            }
        });

        btnExcluirCertidoes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirCertidoes.setText("Excluir");
        btnExcluirCertidoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCertidoesActionPerformed(evt);
            }
        });

        tbCertidoes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCertidoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCertidoesMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tbCertidoes);
        if (tbCertidoes.getColumnModel().getColumnCount() > 0) {
            tbCertidoes.getColumnModel().getColumn(0).setMaxWidth(30);
            tbCertidoes.getColumnModel().getColumn(1).setMaxWidth(70);
            tbCertidoes.getColumnModel().getColumn(2).setMaxWidth(90);
            tbCertidoes.getColumnModel().getColumn(4).setMaxWidth(150);
            tbCertidoes.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadCertidoesLayout = new javax.swing.GroupLayout(jpCadCertidoes);
        jpCadCertidoes.setLayout(jpCadCertidoesLayout);
        jpCadCertidoesLayout.setHorizontalGroup(
            jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                        .addComponent(lbCodCertidoes)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                        .addComponent(lbDataCertidoes)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoCertidoes)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                        .addComponent(lbObsCertidoes)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                                .addComponent(btnNovoCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane18)))))
        );
        jpCadCertidoesLayout.setVerticalGroup(
            jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodCertidoes))
                    .addComponent(txtCodCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataCertidoes))
                    .addComponent(txtDataCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadCertidoesLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoCertidoes))
                    .addComponent(cbTipoCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsCertidoes)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadCertidoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirCertidoes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Pesquisa de Certidões", jpCadCertidoes);

        jpCadTermo.setBackground(new java.awt.Color(245, 245, 245));

        lbCodTermo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodTermo.setText("Cod:");

        lbDataTermo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataTermo.setText("Data:");

        lbObsTermo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsTermo.setText("Observação:");

        lbTipoTermo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoTermo.setText("Tipo:");

        cbTipoTermo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoTermo.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsTermo.setColumns(20);
        txtObsTermo.setLineWrap(true);
        txtObsTermo.setRows(5);
        jScrollPane20.setViewportView(txtObsTermo);

        btnNovoTermo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoTermo.setText("Novo");
        btnNovoTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTermoActionPerformed(evt);
            }
        });

        btnAlterarTermo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarTermo.setText("Alterar");
        btnAlterarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarTermoActionPerformed(evt);
            }
        });

        btnSalvarTermo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarTermo.setText("Salvar");
        btnSalvarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarTermoActionPerformed(evt);
            }
        });

        btnCancelarTermo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarTermo.setText("Cancelar");
        btnCancelarTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTermoActionPerformed(evt);
            }
        });

        btnExcluirTermo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirTermo.setText("Excluir");
        btnExcluirTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTermoActionPerformed(evt);
            }
        });

        tbTermo.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTermo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTermoMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tbTermo);
        if (tbTermo.getColumnModel().getColumnCount() > 0) {
            tbTermo.getColumnModel().getColumn(0).setMaxWidth(30);
            tbTermo.getColumnModel().getColumn(1).setMaxWidth(70);
            tbTermo.getColumnModel().getColumn(2).setMaxWidth(90);
            tbTermo.getColumnModel().getColumn(4).setMaxWidth(150);
            tbTermo.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadTermoLayout = new javax.swing.GroupLayout(jpCadTermo);
        jpCadTermo.setLayout(jpCadTermoLayout);
        jpCadTermoLayout.setHorizontalGroup(
            jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadTermoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTermoLayout.createSequentialGroup()
                        .addComponent(lbCodTermo)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadTermoLayout.createSequentialGroup()
                        .addComponent(lbDataTermo)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoTermo)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoTermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadTermoLayout.createSequentialGroup()
                        .addComponent(lbObsTermo)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadTermoLayout.createSequentialGroup()
                                .addComponent(btnNovoTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane20)))))
        );
        jpCadTermoLayout.setVerticalGroup(
            jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadTermoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTermoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodTermo))
                    .addComponent(txtCodTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTermoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataTermo))
                    .addComponent(txtDataTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadTermoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoTermo))
                    .addComponent(cbTipoTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsTermo)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadTermoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Termo de Responsabilidade", jpCadTermo);

        jpCadSenhas.setBackground(new java.awt.Color(245, 245, 245));

        lbCodSenhas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodSenhas.setText("Cod:");

        lbDataSenhas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDataSenhas.setText("Data:");

        lbObsSenhas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbObsSenhas.setText("Observação:");

        lbTipoSenhas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTipoSenhas.setText("Tipo:");

        cbTipoSenhas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Novo Andamento", "Finalizado" }));
        cbTipoSenhas.setToolTipText("Se desejar finalizar o andamento, selecione finalizado");

        txtObsSenhas.setColumns(20);
        txtObsSenhas.setLineWrap(true);
        txtObsSenhas.setRows(5);
        jScrollPane22.setViewportView(txtObsSenhas);

        btnNovoSenhas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnNovoSenhas.setText("Novo");
        btnNovoSenhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoSenhasActionPerformed(evt);
            }
        });

        btnAlterarSenhas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAlterarSenhas.setText("Alterar");
        btnAlterarSenhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarSenhasActionPerformed(evt);
            }
        });

        btnSalvarSenhas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSalvarSenhas.setText("Salvar");
        btnSalvarSenhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarSenhasActionPerformed(evt);
            }
        });

        btnCancelarSenhas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCancelarSenhas.setText("Cancelar");
        btnCancelarSenhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSenhasActionPerformed(evt);
            }
        });

        btnExcluirSenhas.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnExcluirSenhas.setText("Excluir");
        btnExcluirSenhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirSenhasActionPerformed(evt);
            }
        });

        tbSenhas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSenhas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSenhasMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(tbSenhas);
        if (tbSenhas.getColumnModel().getColumnCount() > 0) {
            tbSenhas.getColumnModel().getColumn(0).setMaxWidth(30);
            tbSenhas.getColumnModel().getColumn(1).setMaxWidth(70);
            tbSenhas.getColumnModel().getColumn(2).setMaxWidth(90);
            tbSenhas.getColumnModel().getColumn(4).setMaxWidth(150);
            tbSenhas.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jpCadSenhasLayout = new javax.swing.GroupLayout(jpCadSenhas);
        jpCadSenhas.setLayout(jpCadSenhasLayout);
        jpCadSenhasLayout.setHorizontalGroup(
            jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jpCadSenhasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSenhasLayout.createSequentialGroup()
                        .addComponent(lbCodSenhas)
                        .addGap(115, 115, 115)
                        .addComponent(txtCodSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadSenhasLayout.createSequentialGroup()
                        .addComponent(lbDataSenhas)
                        .addGap(111, 111, 111)
                        .addComponent(txtDataSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbTipoSenhas)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipoSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadSenhasLayout.createSequentialGroup()
                        .addComponent(lbObsSenhas)
                        .addGap(73, 73, 73)
                        .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpCadSenhasLayout.createSequentialGroup()
                                .addComponent(btnNovoSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlterarSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalvarSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluirSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane22)))))
        );
        jpCadSenhasLayout.setVerticalGroup(
            jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadSenhasLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSenhasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodSenhas))
                    .addComponent(txtCodSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSenhasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbDataSenhas))
                    .addComponent(txtDataSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCadSenhasLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbTipoSenhas))
                    .addComponent(cbTipoSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObsSenhas)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvarSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterarSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCadSenhasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelarSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirSenhas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jtbGuia.addTab("Senhas Fiscais", jpCadSenhas);

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

    private void btnExcluirPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPropostaActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txtCodProposta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                //busca cadastro de acordo com o codigo
                String sql = "select * from propostacomercial where CodPropostaComercial= "+txtCodProposta.getText();
                con_geral.executeSQL(sql);
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir um registro do cliente : " +nome+"?";
                    String operacao = con.resultset.getString("AndamentoPropostaComercial");
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        sql = "DELETE FROM propostacomercial Where CodPropostaComercial="+txtCodProposta.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if (conseguiu_excluir == 1){
                            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                            
                            limpar_tabela_proposta();
                            preencher_tabela_proposta();
                            limpar_tela_proposta();
                            
                            if("Finalizado".equals(operacao)){
                               con.executeSQL("select * from propostacomercial where NumeroProcesso='"+processo+ "' and AndamentoPropostaComercial='Finalizado'");
                               if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set AndamentoPropastaComercial='Em Aberto' where Numerodoprocesso='"+processo+"'");
                                    
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
    }//GEN-LAST:event_btnExcluirPropostaActionPerformed

    private void btnCancelarPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPropostaActionPerformed
       restaurar_backup_proposta();
       bloquear_tela_proposta();
    }//GEN-LAST:event_btnCancelarPropostaActionPerformed

    private void btnSalvarPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPropostaActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txtDataProposta.getText().equals("  /  /    ") || txtDataProposta.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cbTipoProposta.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
        }
        //evitando erros com cadastro ja salvo antes
        else if(txtCodProposta.getText().equals("")){
            try{
                String dataandamento = txtDataProposta.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamento;
                if(cbTipoProposta.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                    }
                String gry = "insert into propostacomercial ("+
                "NumeroProcesso, DatadeCadastroAndamento, Obsevacao, "+
                "Usuario, AndamentoPropostaComercial) values ('" +processo+"','"+
                new java.sql.Date(data.getTime())+"','"+
                txtObsProposta.getText()+"','"+
                usuario+"','"+
                andamento+"')";
                con.exeQuery(gry);
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                
                
                atualizar_proposta();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_proposta();
                preencher_tabela_proposta();
                
            }catch(ParseException | HeadlessException erro){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Proposta Comercial: \n"+erro);
            }
        }
        else if(!txtCodProposta.getText().equals("")){
            try{
               
                String dataandamento = txtDataProposta.getText();
                Date data = sdf.parse(dataandamento);
                
                String andamento;
                if(cbTipoProposta.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }else{
                    andamento = "Em Aberto";
                }
                String sql = "UPDATE propostacomercial set DatadeCadastroAndamento='"+
                new java.sql.Date(data.getTime())+"',"+
                "Obsevacao='"+txtObsProposta.getText()+"',"+
                "Usuario= '"+usuario+"',"+
                "AndamentoPropostaComercial='"+andamento+"' "+
                "where CodPropostaComercial = "+txtCodProposta.getText();

                con.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_proposta();
                preencher_status();
                limpar_tabela_proposta();
                preencher_tabela_proposta();
                atualizar_cadastro_cliente();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Proposta Comercial: \n " +erro);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Você digitou uma data não valida!\n"+ex);
            }
        
        }
    }//GEN-LAST:event_btnSalvarPropostaActionPerformed

    private void btnAlterarPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarPropostaActionPerformed
        criar_backup_proposta();
        desbloquear_tela_proposta();
    }//GEN-LAST:event_btnAlterarPropostaActionPerformed

    private void btnExcluirDiagnoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDiagnoseActionPerformed
        //se não selecionado nenhum cadastro, exclusão não será permitida
        if(txtCodDiagnose.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro selecione um registro para exclusão!");
        }
        else{
            try{
                String sql = "select * from enviodiaginose  "
                        + "where CodEnvioDgnose="+txtCodDiagnose.getText();
                con.executeSQL(sql);
                con.resultset.first();
                String cliente = "Tem certeza que deseja excluir esse cadastro do cliente : " +nome+"?";
                
                String operacao = con.resultset.getString("AndamentoEnioDiagnose");
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,cliente,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if(opcao_escolhida == JOptionPane.YES_OPTION){

                    sql = "DELETE FROM enviodiaginose Where CodEnvioDgnose = "+txtCodDiagnose.getText();
                    int conseguiu_excluir = con.statement.executeUpdate(sql);
                    if (conseguiu_excluir == 1){
                        JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                        limpar_tela_diagnose();
                        limpar_tabela_diagnose();
                        preencher_tabela_diagnose();
                        //verificar se não existe outro registro com o status finalizado nesse cliente
                        if("Finalizado".equals(operacao)){
                            con.executeSQL("select * from enviodiaginose where NumeroProcesso="+processo+" and AndamentoEnioDiagnose='Finalizado'");
                            if(!con.resultset.first()){
                                try{
                                    con_geral.statement.executeUpdate("update comercial set AndamentoEnvioDiagnose='Em Aberto'"
                                    +"Numerodoprocesso='"+processo);
                                    
                                    preencher_status();
                                    atualizar_cadastro_cliente();
                                    
                                }catch(SQLException erro){
                                    JOptionPane.showMessageDialog(null,"Falha ao atualizar a tabela Comercial:\n" +erro);
                                }
                            }
                        }
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro\n"+erro);
            }
        }
    }//GEN-LAST:event_btnExcluirDiagnoseActionPerformed

    private void btnCancelarDiagnoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDiagnoseActionPerformed
        restaurar_backup_diagnose();
        bloquear_tela_diagnose();
    }//GEN-LAST:event_btnCancelarDiagnoseActionPerformed

    private void btnSalvarDiagnoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDiagnoseActionPerformed
        //nao permitir que a primeira data fique vazia
        if(txtDataDiagnose.getText().equals("  /  /    ") || txtDataDiagnose.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Digite uma data valida no campo novo andamento!");
        }
        else if(cbTipoDiagnose.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
        }
        //evitando erros com cadastro ja salvo antes
        else if(txtCodDiagnose.getText().equals("")){
            try{
                //convertendo a primeira data
                String dataandamento = txtDataDiagnose.getText();
                Date data = sdf.parse(dataandamento);

                String andamento;
                
                if(cbTipoDiagnose.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }

                    String gry = "insert into enviodiaginose("
                    +"NumeroProcesso, DatadeCadastroAndamento, Obsevacao,"
                    +"Usuario, AndamentoEnioDiagnose) "
                    +"values ('"+processo+"','"
                    +new java.sql.Date(data.getTime())+"','"
                    +txtObsDiagnose.getText()+"','"
                    +usuario+"','"
                    +andamento+"')";
                    
                    con.exeQuery(gry);
                    
                    JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
                    
                    atualizar_diagnose();
                    preencher_status();
                    atualizar_cadastro_cliente();
                    limpar_tabela_diagnose();
                    preencher_tabela_diagnose();
                    
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir os dados na tabela Diagnose: "+add);
            }
        }
        else if(!txtCodDiagnose.getText().equals("")){
            try{
               
                String dataandamento = txtDataDiagnose.getText();
                Date datatermo = sdf.parse(dataandamento);

                String andamento;
                
                if(cbTipoDiagnose.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                    String sql = "UPDATE enviodiaginose set DatadeCadastroAndamento='"+
                new java.sql.Date(datatermo.getTime())+"',"+
                "Obsevacao='"+txtObsDiagnose.getText()+"',"+
                "Usuario = '"+usuario+"',"+
                "AndamentoEnioDiagnose='"+andamento+"' "+
                "where CodEnvioDgnose = "+txtCodDiagnose.getText();

                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                
                atualizar_diagnose();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_diagnose();
                preencher_tabela_diagnose();
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao atualizar os dados da tabela Diagnose: " +erro);
            }catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique a data informada, valor incorreto!\n"+ex);
            }
        }
    }//GEN-LAST:event_btnSalvarDiagnoseActionPerformed

    private void btnNovoDiagnoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDiagnoseActionPerformed
        criar_backup_diagnose();
        limpar_tela_diagnose();
        desbloquear_tela_diagnose();
    }//GEN-LAST:event_btnNovoDiagnoseActionPerformed

    private void tbDiagnoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDiagnoseMouseClicked
        Integer linha = tbDiagnose.getSelectedRow();
        String codigo = (String)tbDiagnose.getValueAt(linha, 0);
        String data = (String)tbDiagnose.getValueAt(linha, 1);
        String observacao = (String)tbDiagnose.getValueAt(linha, 3);
        String tipo = (String)tbDiagnose.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataDiagnose.setText(recebedataTabela);
        
        txtCodDiagnose.setText(codigo);
        txtObsDiagnose.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoDiagnose.setSelectedItem("Finalizado");
        }
        else
            cbTipoDiagnose.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbDiagnoseMouseClicked

    private void tbPropostaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPropostaMouseClicked
        Integer linha = tbProposta.getSelectedRow();
        String codigo = (String)tbProposta.getValueAt(linha, 0);
        String data = (String)tbProposta.getValueAt(linha, 1);
        String observacao = (String)tbProposta.getValueAt(linha, 3);
        String tipo = (String)tbProposta.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataProposta.setText(recebedataTabela);
        
        txtCodProposta.setText(codigo);
        txtObsProposta.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoProposta.setSelectedItem("Finalizado");
        }
        else
            cbTipoProposta.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbPropostaMouseClicked

    private void btnNovoOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoOSActionPerformed
        criar_backup_os();
        limpar_tela_os();
        desbloquear_tela_os();
    }//GEN-LAST:event_btnNovoOSActionPerformed

    private void btnSalvarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarOSActionPerformed
        if(txtDataOS.getText().equals("  /  /    ") || txtDataOS.getText().trim().length()<10){
            JOptionPane.showMessageDialog(null, "Data informada é invalida!");
        }
        else if(cbTipoOS.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Campo Tipo não pode ficar em branco");
        }
        else if(txtCodOS.getText().equals("")){
            try{
                String novadata = txtDataOS.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoOS.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into geraros (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoGerarOS)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsOS.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_os();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_os();
                preencher_tabela_os();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodOS.getText().equals("")){
            try{
                String novadata = txtDataOS.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoOS.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update geraros set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsOS.getText()+"',"
                        +"AndamentoGerarOS='"+andamento+"'"
                        +" where CodGerarOS="+txtCodOS.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_os();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_os();
                preencher_tabela_os();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
        
        
    }//GEN-LAST:event_btnSalvarOSActionPerformed

    private void btnCancelarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOSActionPerformed
        restaurar_backup_os();
        bloquear_tela_os();
    }//GEN-LAST:event_btnCancelarOSActionPerformed

    private void btnExcluirOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirOSActionPerformed
        if(txtCodOS.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão!");
        }
        else{
            try{
                con.executeSQL(("select * from geraros where CodGerarOS="+txtCodOS.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoGerarOS");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from geraros where CodGerarOS="+txtCodOS.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            
                            limpar_tabela_os();
                            preencher_tabela_os();
                            limpar_tela_os();
                            
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from geraros where NumeroProcesso="+processo+" and AndamentoGerarOS='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set AndamentoGerarOS='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Comercial!\n"+erro);
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
    }//GEN-LAST:event_btnExcluirOSActionPerformed

    private void tbOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOSMouseClicked
        Integer linha = tbOS.getSelectedRow();
        String codigo = (String)tbOS.getValueAt(linha, 0);
        String data = (String)tbOS.getValueAt(linha, 1);
        String observacao = (String)tbOS.getValueAt(linha, 3);
        String tipo = (String)tbOS.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataOS.setText(recebedataTabela);
        
        txtCodOS.setText(codigo);
        txtObsOS.setText(observacao);  
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoOS.setSelectedItem("Finalizado");
        }
        else
            cbTipoOS.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbOSMouseClicked

    private void btnAlterarDiagnoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDiagnoseActionPerformed
        criar_backup_diagnose();
        desbloquear_tela_diagnose();
    }//GEN-LAST:event_btnAlterarDiagnoseActionPerformed

    private void btnNovoPropostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPropostaActionPerformed
        criar_backup_proposta();
        limpar_tela_proposta();
        desbloquear_tela_proposta();
    }//GEN-LAST:event_btnNovoPropostaActionPerformed

    private void btnAlterarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarOSActionPerformed
        criar_backup_os();
        desbloquear_tela_os();
    }//GEN-LAST:event_btnAlterarOSActionPerformed

    private void btnNovoDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDocumentosActionPerformed
        criar_backup_documentos();
        limpar_tela_documentos();
        desbloquear_tela_documentos();
    }//GEN-LAST:event_btnNovoDocumentosActionPerformed

    private void btnAlterarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarDocumentosActionPerformed
        criar_backup_documentos();
        desbloquear_tela_documentos();
    }//GEN-LAST:event_btnAlterarDocumentosActionPerformed

    private void btnSalvarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDocumentosActionPerformed
        if(txtDataDocumentos.getText().trim().length()<10 || txtDataDocumentos.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        }
        else if(cbTipoDocumentos.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        }
        else if(txtCodDocumentos.getText().equals("")){
            try{
                String novadata = txtDataDocumentos.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoDocumentos.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into requisicaodocumentos (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoRequisicaoDocumentos)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsDocumentos.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_documentos();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_documentos();
                preencher_tabela_documentos();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodDocumentos.getText().equals("")){
            try{
                String novadata = txtDataDocumentos.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoDocumentos.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update requisicaodocumentos set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsDocumentos.getText()+"',"
                        +"AndamentoRequisicaoDocumentos='"+andamento+"'"
                        +" where CodRequisicaoDocumentos="+txtCodDocumentos.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_documentos();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_documentos();
                preencher_tabela_documentos();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
    }//GEN-LAST:event_btnSalvarDocumentosActionPerformed

    private void btnCancelarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDocumentosActionPerformed
        restaurar_backup_documentos();
        bloquear_tela_documentos();
    }//GEN-LAST:event_btnCancelarDocumentosActionPerformed

    private void btnExcluirDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDocumentosActionPerformed
        if(txtCodDocumentos.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um registro para exclusão!");
        }
        else{
            try{
                con.executeSQL(("select * from requisicaodocumentos where CodRequisicaoDocumentos="+txtCodDocumentos.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoRequisicaoDocumentos");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from requisicaodocumentos where CodRequisicaoDocumentos="+txtCodDocumentos.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_documentos();
                            preencher_tabela_documentos();
                            limpar_tela_documentos();
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from requisicaodocumentos where NumeroProcesso="+processo+" and AndamentoRequisicaoDocumentos='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set "
                                                + "AndamentoRequisicaoDocumentos='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial!\n"+erro);
                                    }
                                }
                            }
                        }
                    }
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Requisição de Documentos!\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirDocumentosActionPerformed

    private void tbDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDocumentosMouseClicked
        Integer linha = tbDocumentos.getSelectedRow();
        String codigo = (String)tbDocumentos.getValueAt(linha, 0);
        String data = (String)tbDocumentos.getValueAt(linha, 1);
        String observacao = (String)tbDocumentos.getValueAt(linha, 3);
        String tipo = (String)tbDocumentos.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataDocumentos.setText(recebedataTabela);
        
        txtCodDocumentos.setText(codigo);
        txtObsDocumentos.setText(observacao);
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoDocumentos.setSelectedItem("Finalizado");
        }
        else
            cbTipoDocumentos.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbDocumentosMouseClicked

    private void btnNovoTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTaxaActionPerformed
        criar_backup_taxa();
        limpar_tela_taxa();
        desbloquear_tela_taxa();
    }//GEN-LAST:event_btnNovoTaxaActionPerformed

    private void btnAlterarTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTaxaActionPerformed
        criar_backup_taxa();
        desbloquear_tela_taxa();
    }//GEN-LAST:event_btnAlterarTaxaActionPerformed

    private void btnSalvarTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTaxaActionPerformed
        if(txtDataTaxa.getText().trim().length()<10 || txtDataTaxa.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        }
        else if(cbTipoTaxa.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        }
        else if(txtCodTaxa.getText().equals("")){
            try{
                String novadata = txtDataTaxa.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoTaxa.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into taxadeimplantacaoetaxapg (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoTaxaDeImplantacaoEformaPG)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsTaxa.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_taxa();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_taxa();
                preencher_tabela_taxa();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodTaxa.getText().equals("")){
            try{
                String novadata = txtDataTaxa.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoTaxa.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update taxadeimplantacaoetaxapg set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsTaxa.getText()+"',"
                        +"AndamentoTaxaDeImplantacaoEformaPG='"+andamento+"'"
                        +" where CodTaxaDeImplantacaoEFormaDePG="+txtCodTaxa.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_taxa();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_taxa();
                preencher_tabela_taxa();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
        

    }//GEN-LAST:event_btnSalvarTaxaActionPerformed

    private void btnCancelarTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTaxaActionPerformed
        restaurar_backup_taxa();
        bloquear_tela_taxa();
    }//GEN-LAST:event_btnCancelarTaxaActionPerformed

    private void btnExcluirTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTaxaActionPerformed
        if(txtCodTaxa.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            try{
                con.executeSQL(("select * from taxadeimplantacaoetaxapg where CodTaxaDeImplantacaoEFormaDePG="+txtCodTaxa.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoTaxaDeImplantacaoEformaPG");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from taxadeimplantacaoetaxapg where CodTaxaDeImplantacaoEFormaDePG="+txtCodTaxa.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_taxa();
                            preencher_tabela_taxa();
                            limpar_tela_taxa();
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from taxadeimplantacaoetaxapg where NumeroProcesso="+processo+" and AndamentoTaxaDeImplantacaoEformaPG='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set "
                                                + "AndamentoTaxaDeImplantacaoEFormaDePagamento='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Comercial!\n"+erro);
                                    }
                                }
                            }
                        }
                    }
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Taxa de Implantação!\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirTaxaActionPerformed

    private void tbTaxaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaxaMouseClicked
        Integer linha = tbTaxa.getSelectedRow();
        String codigo = (String)tbTaxa.getValueAt(linha, 0);
        String data = (String)tbTaxa.getValueAt(linha, 1);
        String observacao = (String)tbTaxa.getValueAt(linha, 3);
        String tipo = (String)tbTaxa.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataTaxa.setText(recebedataTabela);
        
        txtCodTaxa.setText(codigo);
        txtObsTaxa.setText(observacao);    
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoTaxa.setSelectedItem("Finalizado");
        }
        else
            cbTipoTaxa.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbTaxaMouseClicked

    private void btnNovoRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoRecebimentoActionPerformed
        criar_backup_recebimento();
        limpar_tela_recebimento();
        desbloquear_tela_recebimento();
    }//GEN-LAST:event_btnNovoRecebimentoActionPerformed

    private void btnAlterarRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRecebimentoActionPerformed
        criar_backup_recebimento();
        desbloquear_tela_recebimento();
    }//GEN-LAST:event_btnAlterarRecebimentoActionPerformed

    private void btnSalvarRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarRecebimentoActionPerformed
        if(txtDataRecebimento.getText().trim().length()<10 || txtDataRecebimento.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        }
        else if(cbTipoRecebimento.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        }
        else if(txtCodRecebimento.getText().equals("")){
            try{
                String novadata = txtDataRecebimento.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoRecebimento.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into confirmarrecebimentodeposito (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoConfirmarrecebimentodeposito)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsRecebimento.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_recebimento();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_recebimento();
                preencher_tabela_recebimento();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodRecebimento.getText().equals("")){
            try{
                String novadata = txtDataRecebimento.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoRecebimento.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update confirmarrecebimentodeposito set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsRecebimento.getText()+"',"
                        +"AndamentoConfirmarrecebimentodeposito='"+andamento+"'"
                        +" where CodConfirmarrecebimentodeposito="+txtCodRecebimento.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_recebimento();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_recebimento();
                preencher_tabela_recebimento();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
    }//GEN-LAST:event_btnSalvarRecebimentoActionPerformed

    private void btnCancelarRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRecebimentoActionPerformed
        restaurar_backup_recebimento();
        bloquear_tela_recebimento();
    }//GEN-LAST:event_btnCancelarRecebimentoActionPerformed

    private void btnExcluirRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirRecebimentoActionPerformed
        if(txtCodRecebimento.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            try{
                con.executeSQL(("select * from confirmarrecebimentodeposito where CodConfirmarrecebimentodeposito="+txtCodRecebimento.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoConfirmarrecebimentodeposito");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from confirmarrecebimentodeposito where CodConfirmarrecebimentodeposito="+txtCodRecebimento.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_recebimento();
                            preencher_tabela_recebimento();
                            limpar_tela_recebimento();
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from confirmarrecebimentodeposito where NumeroProcesso="+processo+" and AndamentoConfirmarrecebimentodeposito='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set "
                                                + "AndamentoConfirmarRecebimentoDeposito='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Comercial!\n"+erro);
                                    }
                                }
                            }
                        }
                    }
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Recebimento!\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirRecebimentoActionPerformed

    private void tbRecebimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRecebimentoMouseClicked
        Integer linha = tbRecebimento.getSelectedRow();
        String codigo = (String)tbRecebimento.getValueAt(linha, 0);
        String data = (String)tbRecebimento.getValueAt(linha, 1);
        String observacao = (String)tbRecebimento.getValueAt(linha, 3);
        String tipo = (String)tbRecebimento.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataRecebimento.setText(recebedataTabela);
        
        txtCodRecebimento.setText(codigo);
        txtObsRecebimento.setText(observacao); 
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoRecebimento.setSelectedItem("Finalizado");
        }
        else
            cbTipoRecebimento.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbRecebimentoMouseClicked

    private void btnNovoCertidoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCertidoesActionPerformed
        criar_backup_certidoes();
        limpar_tela_certidoes();
        desbloquear_tela_certidoes();
    }//GEN-LAST:event_btnNovoCertidoesActionPerformed

    private void btnAlterarCertidoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCertidoesActionPerformed
        criar_backup_certidoes();
        desbloquear_tela_certidoes();
    }//GEN-LAST:event_btnAlterarCertidoesActionPerformed

    private void btnSalvarCertidoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarCertidoesActionPerformed
        if(txtDataCertidoes.getText().trim().length()<10 || txtDataCertidoes.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        }
        else if(cbTipoCertidoes.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        }
        else if(txtCodCertidoes.getText().equals("")){
            try{
                String novadata = txtDataCertidoes.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoCertidoes.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into pesquisafiscal (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoPesquisaFiscal)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsCertidoes.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_certidoes();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_certidoes();
                preencher_tabela_certidoes();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodCertidoes.getText().equals("")){
            try{
                String novadata = txtDataCertidoes.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoCertidoes.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update pesquisafiscal set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsCertidoes.getText()+"',"
                        +"AndamentoPesquisaFiscal='"+andamento+"'"
                        +" where CodPesquisaFiscal="+txtCodCertidoes.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_certidoes();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_certidoes();
                preencher_tabela_certidoes();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
    }//GEN-LAST:event_btnSalvarCertidoesActionPerformed

    private void btnCancelarCertidoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCertidoesActionPerformed
        restaurar_backup_certidoes();
        bloquear_tela_certidoes();
    }//GEN-LAST:event_btnCancelarCertidoesActionPerformed

    private void btnExcluirCertidoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCertidoesActionPerformed
        if(txtCodCertidoes.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            try{
                con.executeSQL(("select * from pesquisafiscal where CodPesquisaFiscal="+txtCodCertidoes.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoPesquisaFiscal");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from pesquisafiscal where CodPesquisaFiscal="+txtCodCertidoes.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_certidoes();
                            preencher_tabela_certidoes();
                            limpar_tela_certidoes();
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from pesquisafiscal where NumeroProcesso="+processo+""
                                        + " and AndamentoPesquisaFiscal='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set AndamentoPesquisaFiscal='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Comercial!\n"+erro);
                                    }
                                }
                            }
                        }
                    }
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Certidoes!\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirCertidoesActionPerformed

    private void tbCertidoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCertidoesMouseClicked
        Integer linha = tbCertidoes.getSelectedRow();
        String codigo = (String)tbCertidoes.getValueAt(linha, 0);
        String data = (String)tbCertidoes.getValueAt(linha, 1);
        String observacao = (String)tbCertidoes.getValueAt(linha, 3);
        String tipo = (String)tbCertidoes.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataCertidoes.setText(recebedataTabela);
        
        txtCodCertidoes.setText(codigo);
        txtObsCertidoes.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoCertidoes.setSelectedItem("Finalizado");
        }
        else
            cbTipoCertidoes.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbCertidoesMouseClicked

    private void btnNovoTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTermoActionPerformed
        criar_backup_termo();
        limpar_tela_termo();
        desbloquear_tela_termo();
    }//GEN-LAST:event_btnNovoTermoActionPerformed

    private void btnAlterarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarTermoActionPerformed
        criar_backup_termo();
        desbloquear_tela_termo();
    }//GEN-LAST:event_btnAlterarTermoActionPerformed

    private void btnSalvarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarTermoActionPerformed
        if(txtDataTermo.getText().trim().length()<10 || txtDataTermo.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        }
        if(cbTipoTermo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        }
        else if(txtCodTermo.getText().equals("")){
            try{
                String novadata = txtDataTermo.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoTermo.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into enviartermoresponsaparacliente (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoEnviarTermoResponsaParaCliente)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsTermo.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_termo();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_termo();
                preencher_tabela_termo();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodTermo.getText().equals("")){
            try{
                String novadata = txtDataTermo.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoTermo.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update enviartermoresponsaparacliente set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsTermo.getText()+"',"
                        +"AndamentoEnviarTermoResponsaParaCliente='"+andamento+"'"
                        +" where CodEnviarTermoResponsaParaCliente="+txtCodTermo.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_termo();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_termo();
                preencher_tabela_termo();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
    }//GEN-LAST:event_btnSalvarTermoActionPerformed

    private void btnCancelarTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTermoActionPerformed
        restaurar_backup_termo();
        bloquear_tela_termo();
    }//GEN-LAST:event_btnCancelarTermoActionPerformed

    private void btnExcluirTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTermoActionPerformed
                if(txtCodTermo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            try{
                con.executeSQL("select * from enviartermoresponsaparacliente where CodEnviarTermoResponsaParaCliente="+txtCodTermo.getText());
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoEnviarTermoResponsaParaCliente");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from enviartermoresponsaparacliente where CodEnviarTermoResponsaParaCliente="+txtCodTermo.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_termo();
                            preencher_tabela_termo();
                            limpar_tela_termo();
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from enviartermoresponsaparacliente where NumeroProcesso="+
                                        processo+" and AndamentoEnviarTermoResponsaParaCliente='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set "
                                                + "AndamentoEnviarTermoResponsaparacliente='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Comercial!\n"+erro);
                                    }
                                }
                            }
                        }
                    }
                }
                
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Falha ao excluir o registro da tabela Termo!\n"+erro);
            }
            
        }
    }//GEN-LAST:event_btnExcluirTermoActionPerformed

    private void tbTermoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTermoMouseClicked
        Integer linha = tbTermo.getSelectedRow();
        String codigo = (String)tbTermo.getValueAt(linha, 0);
        String data = (String)tbTermo.getValueAt(linha, 1);
        String observacao = (String)tbTermo.getValueAt(linha, 3);
        String tipo = (String)tbTermo.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataTermo.setText(recebedataTabela);
        
        txtCodTermo.setText(codigo);
        txtObsTermo.setText(observacao);
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoTermo.setSelectedItem("Finalizado");
        }
        else
            cbTipoTermo.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbTermoMouseClicked

    private void btnNovoSenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoSenhasActionPerformed
        criar_backup_senhas();
        limpar_tela_senhas();
        desbloquerar_tela_senhas();
    }//GEN-LAST:event_btnNovoSenhasActionPerformed

    private void btnAlterarSenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarSenhasActionPerformed
        criar_backup_senhas();
        desbloquerar_tela_senhas();
    }//GEN-LAST:event_btnAlterarSenhasActionPerformed

    private void btnSalvarSenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarSenhasActionPerformed
        if(txtDataSenhas.getText().trim().length()<10 || txtDataSenhas.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data informada esta incorreta");
        }
        if(cbTipoSenhas.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo!");
        }
        else if(txtCodSenhas.getText().equals("")){
            try{
                String novadata = txtDataSenhas.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoSenhas.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String gry = "insert into gravarsenhasfiscais (DatadeCadastroAndamento, NumeroProcesso,"
                        +"Usuario, Obsevacao, AndamentoGravarSenhasFiscais)"
                        +"values ('"+new java.sql.Date(data.getTime())+"','"
                        +processo+"','"
                        +usuario+"','"
                        +txtObsSenhas.getText()+"','"
                        +andamento+"')";
                con.exeQuery(gry);
                
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
                
                atualizar_senhas();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_senhas();
                preencher_tabela_senhas();
                
            }catch(ParseException | HeadlessException add){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +add);
            }
        }
        else if(!txtCodSenhas.getText().equals("")){
            try{
                String novadata = txtDataSenhas.getText();
                Date data = sdf.parse(novadata);
                
                String andamento;
                
                if(cbTipoSenhas.getSelectedItem().equals("Finalizado")){
                    andamento = "Finalizado";
                }
                else{
                    andamento = "Em Aberto";
                }
                
                String sql = "update gravarsenhasfiscais set "
                        +"DatadeCadastroAndamento='"+new java.sql.Date(data.getTime())+"',"
                        +"Usuario='"+usuario+"',"
                        +"Obsevacao='"+txtObsSenhas.getText()+"',"
                        +"AndamentoGravarSenhasFiscais='"+andamento+"'"
                        +" where CodGravarSenhasFiscais="+txtCodSenhas.getText();
                
                con.statement.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
                
                atualizar_senhas();
                preencher_status();
                atualizar_cadastro_cliente();
                limpar_tabela_senhas();
                preencher_tabela_senhas();
            
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao alterar o registro\n"+erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Erro ao inserir o novo registro!\n" +ex);
            }
        }
    }//GEN-LAST:event_btnSalvarSenhasActionPerformed

    private void btnCancelarSenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSenhasActionPerformed
        restaurar_backup_senhas();
        bloquear_tela_senhas();
    }//GEN-LAST:event_btnCancelarSenhasActionPerformed

    private void btnExcluirSenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirSenhasActionPerformed
        if(txtCodSenhas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um cliente para exclusão!");
        }
        else{
            try{
                con.executeSQL(("select * from gravarsenhasfiscais where CodGravarSenhasFiscais="+txtCodSenhas.getText()));
                if(con.resultset.first()){
                    String cliente = "Tem certeza que deseja excluir o registro do cliente " +nome+"?";
                    String andamento = con.resultset.getString("AndamentoGravarSenhasFiscais");
                    
                    int opcao_escolhida = JOptionPane.showConfirmDialog(null, cliente, "Exclusão",JOptionPane.YES_NO_OPTION);
                    if(opcao_escolhida == JOptionPane.YES_OPTION){
                        String sql = "delete from gravarsenhasfiscais where CodGravarSenhasFiscais="+txtCodSenhas.getText();
                        int conseguiu_excluir = con.statement.executeUpdate(sql);
                        if(conseguiu_excluir==1){
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
                            limpar_tabela_senhas();
                            preencher_tabela_senhas();
                            limpar_tela_senhas();
                            if("Finalizado".equals(andamento)){
                                con.executeSQL("select * from gravarsenhasfiscais where NumeroProcesso="+
                                        processo+" and AndamentoGravarSenhasFiscais='Finalizado'");
                                
                                if(!con.resultset.first()){
                                    try{
                                        con_geral.statement.executeUpdate("update comercial set AndamentoGravarSenhasFiscais='Em Aberto' where Numerodoprocesso='"+processo+"'");

                                        preencher_status();
                                        atualizar_cadastro_cliente();
                                        
                                    }catch(SQLException erro){
                                        JOptionPane.showMessageDialog(null, "Falha ao atualizar tabela Comercial!\n"+erro);
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
    }//GEN-LAST:event_btnExcluirSenhasActionPerformed

    private void tbSenhasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSenhasMouseClicked
        Integer linha = tbSenhas.getSelectedRow();
        String codigo = (String)tbSenhas.getValueAt(linha, 0);
        String data = (String)tbSenhas.getValueAt(linha, 1);
        String observacao = (String)tbSenhas.getValueAt(linha, 3);
        String tipo = (String)tbSenhas.getValueAt(linha, 4);
        
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebedataTabela = dia+mes+ano;
        
        txtDataSenhas.setText(recebedataTabela);
        
        txtCodSenhas.setText(codigo);
        txtObsSenhas.setText(observacao);
        
        if(tipo.equalsIgnoreCase("Finalizado")){
            cbTipoSenhas.setSelectedItem("Finalizado");
        }
        else
            cbTipoSenhas.setSelectedItem("Em Aberto");
        
    }//GEN-LAST:event_tbSenhasMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        con_geral.desconecta();
        con.desconecta();
    }//GEN-LAST:event_formWindowClosing
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            Comercial reg = new Comercial();
            reg.setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarCertidoes;
    private javax.swing.JButton btnAlterarDiagnose;
    private javax.swing.JButton btnAlterarDocumentos;
    private javax.swing.JButton btnAlterarOS;
    private javax.swing.JButton btnAlterarProposta;
    private javax.swing.JButton btnAlterarRecebimento;
    private javax.swing.JButton btnAlterarSenhas;
    private javax.swing.JButton btnAlterarTaxa;
    private javax.swing.JButton btnAlterarTermo;
    private javax.swing.JButton btnCancelarCertidoes;
    private javax.swing.JButton btnCancelarDiagnose;
    private javax.swing.JButton btnCancelarDocumentos;
    private javax.swing.JButton btnCancelarOS;
    private javax.swing.JButton btnCancelarProposta;
    private javax.swing.JButton btnCancelarRecebimento;
    private javax.swing.JButton btnCancelarSenhas;
    private javax.swing.JButton btnCancelarTaxa;
    private javax.swing.JButton btnCancelarTermo;
    private javax.swing.JButton btnExcluirCertidoes;
    private javax.swing.JButton btnExcluirDiagnose;
    private javax.swing.JButton btnExcluirDocumentos;
    private javax.swing.JButton btnExcluirOS;
    private javax.swing.JButton btnExcluirProposta;
    private javax.swing.JButton btnExcluirRecebimento;
    private javax.swing.JButton btnExcluirSenhas;
    private javax.swing.JButton btnExcluirTaxa;
    private javax.swing.JButton btnExcluirTermo;
    private javax.swing.JButton btnNovoCertidoes;
    private javax.swing.JButton btnNovoDiagnose;
    private javax.swing.JButton btnNovoDocumentos;
    private javax.swing.JButton btnNovoOS;
    private javax.swing.JButton btnNovoProposta;
    private javax.swing.JButton btnNovoRecebimento;
    private javax.swing.JButton btnNovoSenhas;
    private javax.swing.JButton btnNovoTaxa;
    private javax.swing.JButton btnNovoTermo;
    private javax.swing.JButton btnSalvarCertidoes;
    private javax.swing.JButton btnSalvarDiagnose;
    private javax.swing.JButton btnSalvarDocumentos;
    private javax.swing.JButton btnSalvarOS;
    private javax.swing.JButton btnSalvarProposta;
    private javax.swing.JButton btnSalvarRecebimento;
    private javax.swing.JButton btnSalvarSenhas;
    private javax.swing.JButton btnSalvarTaxa;
    private javax.swing.JButton btnSalvarTermo;
    private javax.swing.JComboBox cbTipoCertidoes;
    private javax.swing.JComboBox cbTipoDiagnose;
    private javax.swing.JComboBox cbTipoDocumentos;
    private javax.swing.JComboBox cbTipoOS;
    private javax.swing.JComboBox cbTipoProposta;
    private javax.swing.JComboBox cbTipoRecebimento;
    private javax.swing.JComboBox cbTipoSenhas;
    private javax.swing.JComboBox cbTipoTaxa;
    private javax.swing.JComboBox cbTipoTermo;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel jpCadCertidoes;
    private javax.swing.JPanel jpCadDiagnose;
    private javax.swing.JPanel jpCadDocumentos;
    private javax.swing.JPanel jpCadRecebimento;
    private javax.swing.JPanel jpCadSenhas;
    private javax.swing.JPanel jpCadTaxa;
    private javax.swing.JPanel jpCadTermo;
    public javax.swing.JPanel jpComercial;
    private javax.swing.JPanel jpOS;
    private javax.swing.JPanel jpProposta;
    private javax.swing.JPanel jpSit;
    private javax.swing.JTabbedPane jtbGuia;
    private javax.swing.JLabel lbCertidoes;
    private javax.swing.JLabel lbCodCertidoes;
    private javax.swing.JLabel lbCodDiagnose;
    private javax.swing.JLabel lbCodDocumentos;
    private javax.swing.JLabel lbCodOS;
    private javax.swing.JLabel lbCodProposta;
    private javax.swing.JLabel lbCodRecebimento;
    private javax.swing.JLabel lbCodSenhas;
    private javax.swing.JLabel lbCodTaxa;
    private javax.swing.JLabel lbCodTermo;
    private javax.swing.JLabel lbDataCertidoes;
    private javax.swing.JLabel lbDataDiagnose;
    private javax.swing.JLabel lbDataDocumentos;
    private javax.swing.JLabel lbDataOS;
    private javax.swing.JLabel lbDataProposta;
    private javax.swing.JLabel lbDataRecebimento;
    private javax.swing.JLabel lbDataSenhas;
    private javax.swing.JLabel lbDataTaxa;
    private javax.swing.JLabel lbDataTermo;
    private javax.swing.JLabel lbDiagnose;
    private javax.swing.JLabel lbDocumentos;
    private javax.swing.JLabel lbOS;
    private javax.swing.JLabel lbObsCertidoes;
    private javax.swing.JLabel lbObsDiagnose;
    private javax.swing.JLabel lbObsDocumentos;
    private javax.swing.JLabel lbObsOS;
    private javax.swing.JLabel lbObsProposta;
    private javax.swing.JLabel lbObsRecebimento;
    private javax.swing.JLabel lbObsSenhas;
    private javax.swing.JLabel lbObsTaxa;
    private javax.swing.JLabel lbObsTermo;
    private javax.swing.JLabel lbProposta;
    private javax.swing.JLabel lbRecebimento;
    private javax.swing.JLabel lbSenhas;
    private javax.swing.JLabel lbTaxa;
    private javax.swing.JLabel lbTermo;
    private javax.swing.JLabel lbTipoCertidoes;
    private javax.swing.JLabel lbTipoDiagnose;
    private javax.swing.JLabel lbTipoDocumentos;
    private javax.swing.JLabel lbTipoOS;
    private javax.swing.JLabel lbTipoProposta;
    private javax.swing.JLabel lbTipoRecebimento;
    private javax.swing.JLabel lbTipoSenhas;
    private javax.swing.JLabel lbTipoTaxa;
    private javax.swing.JLabel lbTipoTermo;
    private javax.swing.JLabel lbTitFase;
    private javax.swing.JLabel lbTitStatus;
    private javax.swing.JLabel lb_cod;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTable tbCertidoes;
    private javax.swing.JTable tbDiagnose;
    private javax.swing.JTable tbDocumentos;
    private javax.swing.JTable tbOS;
    private javax.swing.JTable tbProposta;
    private javax.swing.JTable tbRecebimento;
    private javax.swing.JTable tbSenhas;
    private javax.swing.JTable tbTaxa;
    private javax.swing.JTable tbTermo;
    public static javax.swing.JLabel txtAndamento;
    private javax.swing.JTextField txtCodCertidoes;
    private javax.swing.JTextField txtCodDiagnose;
    private javax.swing.JTextField txtCodDocumentos;
    private javax.swing.JTextField txtCodOS;
    private javax.swing.JTextField txtCodProposta;
    private javax.swing.JTextField txtCodRecebimento;
    private javax.swing.JTextField txtCodSenhas;
    private javax.swing.JTextField txtCodTaxa;
    private javax.swing.JTextField txtCodTermo;
    public static javax.swing.JLabel txtCodigo;
    private javax.swing.JFormattedTextField txtDataCertidoes;
    private javax.swing.JFormattedTextField txtDataDiagnose;
    private javax.swing.JFormattedTextField txtDataDocumentos;
    private javax.swing.JFormattedTextField txtDataOS;
    private javax.swing.JFormattedTextField txtDataProposta;
    private javax.swing.JFormattedTextField txtDataRecebimento;
    private javax.swing.JFormattedTextField txtDataSenhas;
    private javax.swing.JFormattedTextField txtDataTaxa;
    private javax.swing.JFormattedTextField txtDataTermo;
    public static javax.swing.JLabel txtId;
    public static javax.swing.JLabel txtNome;
    private javax.swing.JTextArea txtObsCertidoes;
    private javax.swing.JTextArea txtObsDiagnose;
    private javax.swing.JTextArea txtObsDocumentos;
    private javax.swing.JTextArea txtObsOS;
    private javax.swing.JTextArea txtObsProposta;
    private javax.swing.JTextArea txtObsRecebimento;
    private javax.swing.JTextArea txtObsSenhas;
    private javax.swing.JTextArea txtObsTaxa;
    private javax.swing.JTextArea txtObsTermo;
    public static javax.swing.JLabel txtStatusCertidoes;
    public static javax.swing.JLabel txtStatusDiagnose;
    public static javax.swing.JLabel txtStatusDocumentos;
    public static javax.swing.JLabel txtStatusOS;
    public static javax.swing.JLabel txtStatusProposta;
    public static javax.swing.JLabel txtStatusRecebimento;
    public static javax.swing.JLabel txtStatusSenhas;
    public static javax.swing.JLabel txtStatusTaxa;
    public static javax.swing.JLabel txtStatusTermo;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    public void preencher_tabela_diagnose(){
        tbDiagnose.getColumnModel().getColumn(0);
        tbDiagnose.getColumnModel().getColumn(1);
        tbDiagnose.getColumnModel().getColumn(2);
        tbDiagnose.getColumnModel().getColumn(3);
        tbDiagnose.getColumnModel().getColumn(4);
        tbDiagnose.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from enviodiaginose WHERE NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbDiagnose.getModel();
        //modelo.setNumRows(0);
        
        try
        {
            
            while (con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("CodEnvioDgnose"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoEnioDiagnose"),                    
                    con.resultset.getString("Usuario")});
            con.resultset.first();
        }   catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Diagnose " +erro);
    }
}
    public void preencher_tabela_proposta(){
        tbProposta.getColumnModel().getColumn(0);
        tbProposta.getColumnModel().getColumn(1);
        tbProposta.getColumnModel().getColumn(2);
        tbProposta.getColumnModel().getColumn(3);
        tbProposta.getColumnModel().getColumn(4);
        tbProposta.getColumnModel().getColumn(5);
        con.executeSQL("select * from propostacomercial WHERE NumeroProcesso='"+processo+"'");
        //
        DefaultTableModel modelo = (DefaultTableModel)tbProposta.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("CodPropostaComercial"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoPropostaComercial"),
                    con.resultset.getString("Usuario")});
            con.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Proposta Comercial "+erro);
        }
    }
    public void preencher_tabela_os(){
        tbOS.getColumnModel().getColumn(0);
        tbOS.getColumnModel().getColumn(1);
        tbOS.getColumnModel().getColumn(2);
        tbOS.getColumnModel().getColumn(3);
        tbOS.getColumnModel().getColumn(4);
        tbOS.getColumnModel().getColumn(5);
        con.executeSQL("select * from geraros where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbOS.getModel();
        
        try{
            while(con.resultset.next())
                modelo.addRow(new Object [] {
                    con.resultset.getString("CodGerarOS"),
                    sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                    con.resultset.getString("NumeroProcesso"),
                    con.resultset.getString("Obsevacao"),
                    con.resultset.getString("AndamentoGerarOS"),
                    con.resultset.getString("Usuario")});
            con.resultset.first();
        }catch(SQLException erro){
          JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Gerar O.S. " +erro);
        }
    }
    public void limpar_tabela_diagnose(){
        DefaultTableModel tbm = (DefaultTableModel)tbDiagnose.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void limpar_tabela_proposta(){
        DefaultTableModel tbm = (DefaultTableModel)tbProposta.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void limpar_tabela_os(){
        DefaultTableModel tbm = (DefaultTableModel)tbOS.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    public void preencher_status(){
        try{
            String sql = "select * from comercial WHERE Numerodoprocesso='"+processo+"'";
            con_geral.executeSQL(sql);
            con_geral.resultset.first();
            
            diagnose = con_geral.resultset.getString("AndamentoEnvioDiagnose");
            proposta = con_geral.resultset.getString("AndamentoPropastaComercial");
            os = con_geral.resultset.getString("AndamentoGerarOS");
            documentos  = con_geral.resultset.getString("AndamentoRequisicaoDocumentos");
            taxa = con_geral.resultset.getString("AndamentoTaxaDeImplantacaoEFormaDePagamento");
            recebimento = con_geral.resultset.getString("AndamentoConfirmarRecebimentoDeposito");
            certidoes = con_geral.resultset.getString("AndamentoPesquisaFiscal");
            termo = con_geral.resultset.getString("AndamentoEnviarTermoResponsaparacliente");
            senhas = con_geral.resultset.getString("AndamentoGravarSenhasFiscais");
                    
            txtStatusDiagnose.setText(diagnose);
            txtStatusProposta.setText(proposta);
            txtStatusOS.setText(os);
            txtStatusDocumentos.setText(documentos);
            txtStatusTaxa.setText(taxa);
            txtStatusRecebimento.setText(recebimento);
            txtStatusCertidoes.setText(certidoes);
            txtStatusTermo.setText(termo);
            txtStatusSenhas.setText(senhas);
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Falha ao preencher status!" +erro);
        }
    }
    public void atualizar_cadastro_cliente(){
        
        if(txtStatusDiagnose.getText().equalsIgnoreCase("Aberto") &&
                txtStatusProposta.getText().equalsIgnoreCase("Aberto") &&
                txtStatusOS.getText().equalsIgnoreCase("Aberto") &&
                txtStatusDocumentos.getText().equalsIgnoreCase("Aberto") &&
                txtStatusTaxa.getText().equalsIgnoreCase("Aberto") &&
                txtStatusRecebimento.getText().equalsIgnoreCase("Aberto") &&
                txtStatusCertidoes.getText().equalsIgnoreCase("Aberto") &&
                txtStatusTermo.getText().equalsIgnoreCase("Aberto") &&
                txtStatusSenhas.getText().equalsIgnoreCase("Aberto")){
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoComercial='Em Aberto' where codNumerodoprocesso=" +processo;
                    con_geral.statement.executeUpdate(sql);

                    String andamento = "Em Aberto";
                    txtAndamento.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" +erro);
                }
        }
        else if(txtStatusDiagnose.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusProposta.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusOS.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusDocumentos.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusTaxa.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusRecebimento.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusCertidoes.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusTermo.getText().equalsIgnoreCase("Finalizado") &&
                txtStatusSenhas.getText().equalsIgnoreCase("Finalizado"))
                {
       
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoComercial='Concluido' where codNumerodoprocesso="+processo;
                    con_geral.statement.executeUpdate(sql);

                    String andamento = "Concluido";
                    txtAndamento.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" +erro);
                }
        }
        else{
                try{
                    String sql = "UPDATE cadastrodeprocesso set AndamentoComercial='Em Aberto' where codNumerodoprocesso=" +processo;
                    con_geral.statement.executeUpdate(sql);

                    String andamento = "Em Andamento";
                    txtAndamento.setText(andamento);
                }catch(SQLException erro){
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar status final!\n" +erro);
                }
        }
        
        distribuir_cores();
    }
    public void distribuir_cores(){
        if(txtStatusDiagnose.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusDiagnose.setBackground(Color.red);
        }
        else{
            txtStatusDiagnose.setBackground(Color.green);
        }
        if(txtStatusProposta.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusProposta.setBackground(Color.red);
        }
        else{
            txtStatusProposta.setBackground(Color.green);
        }
        if(txtStatusOS.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusOS.setBackground(Color.red);
        }
        else{
            txtStatusOS.setBackground(Color.green);    
        }
        if(txtStatusTaxa.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusTaxa.setBackground(Color.red);
        }
        else{
            txtStatusTaxa.setBackground(Color.green);
        }
        if(txtStatusDocumentos.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusDocumentos.setBackground(Color.red);
        }
        else{
            txtStatusDocumentos.setBackground(Color.green);        
        }   
        if(txtStatusRecebimento.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusRecebimento.setBackground(Color.red);
        }
        else{
            txtStatusRecebimento.setBackground(Color.green);
        }
        if(txtStatusCertidoes.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusCertidoes.setBackground(Color.red);
        }
        else{
            txtStatusCertidoes.setBackground(Color.green);    
        }
        if(txtStatusTermo.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusTermo.setBackground(Color.red);
        }
        else{
            txtStatusTermo.setBackground(Color.green);
        }
        if(txtStatusSenhas.getText().equalsIgnoreCase("Em Aberto")){
            txtStatusSenhas.setBackground(Color.red);
        }
        else{
            txtStatusSenhas.setBackground(Color.green);    
        }
        if(txtAndamento.getText().equalsIgnoreCase("Concluido")){
            txtAndamento.setBackground(Color.green);
        }
        else if(txtAndamento.getText().equalsIgnoreCase("Em Andamento")){
            txtAndamento.setBackground(Color.orange);
        }
        else{
            txtAndamento.setBackground(Color.red);
        }
    }
    public void limpar_tela_diagnose(){
        txtCodDiagnose.setText("");
        txtObsDiagnose.setText("");
        txtCodDiagnose.setEditable(false);
        cbTipoDiagnose.setSelectedItem("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataDiagnose.setText(datahoje);
        
    }
    public void limpar_tela_proposta(){
        txtCodProposta.setEditable(false);
        txtCodProposta.setText("");
        cbTipoProposta.setSelectedItem("");
        txtObsProposta.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataProposta.setText(datahoje);
    }
    public void limpar_tela_os(){
        txtCodOS.setEditable(false);
        txtCodOS.setText("");
        cbTipoOS.setSelectedItem("");
        txtObsOS.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataOS.setText(datahoje);
    }

    public void atualizar_diagnose(){
        if(cbTipoDiagnose.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoEnvioDiagnose='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Diagnose\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoEnvioDiagnose ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from enviodiaginose where NumeroProcesso='"+processo+"'and AndamentoEnioDiagnose='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoEnvioDiagnose='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Diagnose\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoEnvioDiagnose ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Diagnose:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Diagnose: \n" +erro);
            }
                    
        }
    }
    public void atualizar_proposta(){
        if(cbTipoProposta.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoPropastaComercial='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial:\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoPropastaComercial ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from propostacomercial where NumeroProcesso='"+processo+"'and AndamentoPropostaComercial='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoPropastaComercial='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial:\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoPropastaComercial ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Proposta Comercial\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Proposta Comercial\n" +erro);
            }
                    
        }
    }
    public void atualizar_os(){
        if(cbTipoOS.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoGerarOS='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Coemrcial\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoGerarOS ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from geraros where NumeroProcesso='"+processo+"'and AndamentoGerarOS='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoGerarOS='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoGerarOS ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>GerarOS\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>GerarOS\n" +erro);
            }
                    
        }
    }
    public void bloquear_tela_proposta(){
        txtCodProposta.setEditable(false);
        txtDataProposta.setEditable(false);
        cbTipoProposta.setEditable(false);
        txtObsProposta.setEditable(false);
    }

    public void desbloquear_tela_proposta(){
        txtCodProposta.setEditable(false);
        txtDataProposta.setEditable(true);
        cbTipoProposta.setEditable(true);
        txtObsProposta.setEditable(true);
    }
    public void bloquear_tela_diagnose(){
        txtCodDiagnose.setEditable(false);
        txtDataDiagnose.setEditable(false);
        cbTipoDiagnose.setEditable(false);
        txtObsDiagnose.setEditable(false);
    }

    public void desbloquear_tela_diagnose(){
        txtCodDiagnose.setEditable(false);
        txtDataDiagnose.setEditable(true);
        cbTipoDiagnose.setEditable(true);
        txtObsDiagnose.setEditable(true);
    }
    public void bloquear_tela_os(){
        txtCodOS.setEditable(false);
        txtDataOS.setEditable(false);
        cbTipoOS.setEditable(false);
        txtObsOS.setEditable(false);
    }

    public void desbloquear_tela_os(){
        txtCodOS.setEditable(false);
        txtDataOS.setEditable(true);
        cbTipoOS.setEditable(true);
        txtObsOS.setEditable(true);
    }
    public void criar_backup_diagnose(){
        codDiagnose_backup = txtCodDiagnose.getText();
        tipoDiagnose_backup = (String)cbTipoDiagnose.getSelectedItem();
        dataDiagnose_backup = txtDataDiagnose.getText();
        obsDiagnose_backup = txtObsDiagnose.getText();
    }
    public void restaurar_backup_diagnose(){
        txtCodDiagnose.setText(codDiagnose_backup);
        cbTipoDiagnose.setSelectedItem(tipoDiagnose_backup);
        txtDataDiagnose.setText(dataDiagnose_backup);
        txtObsDiagnose.setText(obsDiagnose_backup);
    }
    public void criar_backup_proposta(){
        codProposta_backup = txtCodProposta.getText();
        tipoProposta_backup = (String)cbTipoProposta.getSelectedItem();
        dataProposta_backup = txtDataProposta.getText();
        obsProposta_backup = txtObsProposta.getText();
    }
    public void restaurar_backup_proposta(){
        txtCodProposta.setText(codProposta_backup);
        cbTipoProposta.setSelectedItem(tipoProposta_backup);
        txtDataProposta.setText(dataProposta_backup);
        txtObsProposta.setText(obsProposta_backup);
    }
    public void criar_backup_os(){
        codOS_backup = txtCodOS.getText();
        tipoOS_backup = (String)cbTipoOS.getSelectedItem();
        dataOS_backup = txtDataOS.getText();
        obsOS_backup = txtObsOS.getText();
    }
    public void restaurar_backup_os(){
        txtCodOS.setText(codOS_backup);
        cbTipoOS.setSelectedItem(tipoOS_backup);
        txtDataOS.setText(dataOS_backup);
        txtObsOS.setText(obsOS_backup);
    }

    private void criar_backup_documentos() {
        codDoc_backup = txtCodDocumentos.getText();
        tipoDoc_backup = (String)cbTipoDocumentos.getSelectedItem();
        dataDoc_backup = txtDataDocumentos.getText();
        obsDoc_backup = txtObsDocumentos.getText();
    }

    private void limpar_tela_documentos() {
        txtCodDocumentos.setEditable(false);
        txtCodDocumentos.setText("");
        cbTipoDocumentos.setSelectedItem("");
        txtObsDocumentos.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataDocumentos.setText(datahoje);
    }

    private void desbloquear_tela_documentos() {
        txtCodDocumentos.setEditable(false);
        txtDataDocumentos.setEditable(true);
        cbTipoDocumentos.setEditable(true);
        txtObsDocumentos.setEditable(true);
    }

    private void restaurar_backup_documentos() {
        txtCodDocumentos.setText(codDoc_backup);
        cbTipoDocumentos.setSelectedItem(tipoDoc_backup);
        txtDataDocumentos.setText(dataDoc_backup);
        txtObsDocumentos.setText(obsDoc_backup);
    }

    private void preencher_tabela_documentos() {
        tbDocumentos.getColumnModel().getColumn(0);
        tbDocumentos.getColumnModel().getColumn(1);
        tbDocumentos.getColumnModel().getColumn(2);
        tbDocumentos.getColumnModel().getColumn(3);
        tbDocumentos.getColumnModel().getColumn(4);
        tbDocumentos.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from requisicaodocumentos where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbDocumentos.getModel();
        try{
            while(con.resultset.next())modelo.addRow(new Object []
            {
                con.resultset.getString("CodRequisicaoDocumentos"),
                sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                con.resultset.getString("NumeroProcesso"),
                con.resultset.getString("Obsevacao"),
                con.resultset.getString("AndamentoRequisicaoDocumentos"),
                con.resultset.getString("Usuario"),
            });
            con.resultset.first();
            
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela Requisição Documentos!\n"+erro);
        }
    }
    private void preencher_tabela_taxa() {
        tbTaxa.getColumnModel().getColumn(0);
        tbTaxa.getColumnModel().getColumn(1);
        tbTaxa.getColumnModel().getColumn(2);
        tbTaxa.getColumnModel().getColumn(3);
        tbTaxa.getColumnModel().getColumn(4);
        tbTaxa.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from taxadeimplantacaoetaxapg where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbTaxa.getModel();
        
        try
        {
            while(con.resultset.next())modelo.addRow(new Object[] 
            {
                con.resultset.getString("CodTaxaDeImplantacaoEFormaDePG"),
                sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                con.resultset.getString("NumeroProcesso"),
                con.resultset.getString("Obsevacao"),
                con.resultset.getString("AndamentoTaxaDeImplantacaoEformaPG"),
                con.resultset.getString("Usuario"),
            });
            con.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela Taxa de Implantaçao!\n"+erro);
        }
    }
    private void preencher_tabela_recebimento() {
        tbRecebimento.getColumnModel().getColumn(0);
        tbRecebimento.getColumnModel().getColumn(1);
        tbRecebimento.getColumnModel().getColumn(2);
        tbRecebimento.getColumnModel().getColumn(3);
        tbRecebimento.getColumnModel().getColumn(4);
        tbRecebimento.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from confirmarrecebimentodeposito where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbRecebimento.getModel();
        
        try
        {
            while(con.resultset.next())modelo.addRow(new Object[] 
            {
                con.resultset.getString("CodConfirmarrecebimentodeposito"),
                sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                con.resultset.getString("NumeroProcesso"),
                con.resultset.getString("Obsevacao"),
                con.resultset.getString("AndamentoConfirmarrecebimentodeposito"),
                con.resultset.getString("Usuario"),
            });
            con.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela Recebimento de Deposito!\n"+erro);
        }
    }
    
    private void preencher_tabela_certidoes() {
        tbCertidoes.getColumnModel().getColumn(0);
        tbCertidoes.getColumnModel().getColumn(1);
        tbCertidoes.getColumnModel().getColumn(2);
        tbCertidoes.getColumnModel().getColumn(3);
        tbCertidoes.getColumnModel().getColumn(4);
        tbCertidoes.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from pesquisafiscal where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbCertidoes.getModel();
        
        try
        {
            while(con.resultset.next())modelo.addRow(new Object[] 
            {
                con.resultset.getString("CodPesquisaFiscal"),
                sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                con.resultset.getString("NumeroProcesso"),
                con.resultset.getString("Obsevacao"),
                con.resultset.getString("AndamentoPesquisaFiscal"),
                con.resultset.getString("Usuario"),
            });
            con.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela Pesquisa Fiscal!\n"+erro);
        }
    }
    private void preencher_tabela_termo() {
        tbTermo.getColumnModel().getColumn(0);
        tbTermo.getColumnModel().getColumn(1);
        tbTermo.getColumnModel().getColumn(2);
        tbTermo.getColumnModel().getColumn(3);
        tbTermo.getColumnModel().getColumn(4);
        tbTermo.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from enviartermoresponsaparacliente where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbTermo.getModel();
        
        try
        {
            while(con.resultset.next())modelo.addRow(new Object[] 
            {
                con.resultset.getString("CodEnviartermoResponsaParaCliente"),
                sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                con.resultset.getString("NumeroProcesso"),
                con.resultset.getString("Obsevacao"),
                con.resultset.getString("AndamentoEnviarTermoResponsaParaCliente"),
                con.resultset.getString("Usuario"),
            });
            con.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela Termo de Responsabilidade!\n"+erro);
        }
    }
    private void preencher_tabela_senhas() {
        tbSenhas.getColumnModel().getColumn(0);
        tbSenhas.getColumnModel().getColumn(1);
        tbSenhas.getColumnModel().getColumn(2);
        tbSenhas.getColumnModel().getColumn(3);
        tbSenhas.getColumnModel().getColumn(4);
        tbSenhas.getColumnModel().getColumn(5);
        
        con.executeSQL("select * from gravarsenhasfiscais where NumeroProcesso='"+processo+"'");
        
        DefaultTableModel modelo = (DefaultTableModel)tbSenhas.getModel();
        
        try
        {
            while(con.resultset.next())modelo.addRow(new Object[] 
            {
                con.resultset.getString("CodGravarSenhasFiscais"),
                sdf.format(con.resultset.getDate("DatadeCadastroAndamento")),
                con.resultset.getString("NumeroProcesso"),
                con.resultset.getString("Obsevacao"),
                con.resultset.getString("AndamentoGravarSenhasFiscais"),
                con.resultset.getString("Usuario"),
            });
            con.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao listar tabela Senhas Fiscais!\n"+erro);
        }
    }
    private void limpar_tabela_documentos() {
       DefaultTableModel tbm = (DefaultTableModel)tbDocumentos.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }


    private void bloquear_tela_documentos() {
        txtCodDocumentos.setEditable(false);
        cbTipoDocumentos.setEditable(false);
        txtObsDocumentos.setEditable(false);
    }

    private void limpar_tela_taxa() {
        txtCodTaxa.setEditable(false);
        txtCodTaxa.setText("");
        cbTipoTaxa.setSelectedItem("");
        txtObsTaxa.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataTaxa.setText(datahoje);
    }

    private void criar_backup_taxa() {
        codTaxa_backup = txtCodTaxa.getText();
        tipoTaxa_backup = (String)cbTipoTaxa.getSelectedItem();
        dataTaxa_backup = txtDataTaxa.getText();
        obsTaxa_backup = txtObsTaxa.getText();
    }

    private void desbloquear_tela_taxa() {
        txtCodTaxa.setEditable(false);
        txtDataTaxa.setEditable(true);
        cbTipoTaxa.setEditable(true);
        txtObsTaxa.setEditable(true);
    }

    private void restaurar_backup_taxa() {
        txtCodTaxa.setText(codTaxa_backup);
        cbTipoTaxa.setSelectedItem(tipoTaxa_backup);
        txtDataTaxa.setText(dataTaxa_backup);
        txtObsTaxa.setText(obsTaxa_backup);
    }

    private void bloquear_tela_taxa() {
        txtCodTaxa.setEditable(false);
        txtDataTaxa.setEditable(false);
        cbTipoTaxa.setEditable(false);
        txtObsTaxa.setEditable(false);    
    }

    private void limpar_tabela_taxa() {
        DefaultTableModel tbm = (DefaultTableModel)tbTaxa.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    private void atualizar_documentos() {
        if(cbTipoDocumentos.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoRequisicaoDocumentos='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Documentos\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoRequisicaoDocumentos ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from requisicaodocumentos where NumeroProcesso='"+processo+"'and AndamentoRequisicaoDocumentos='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoRequisicaoDocumentos='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Documentos\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoRequisicaoDocumentos ='Em Aberto' where Numerodoprocesso='"+processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Documentos:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Documentos: \n" +erro);
            }
                    
        }
    }
    private void atualizar_recebimento() {
        if(cbTipoRecebimento.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoConfirmarRecebimentoDeposito='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Recebimento\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoConfirmarRecebimentoDeposito ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from confirmarrecebimentodeposito where NumeroProcesso='"+processo+"'and AndamentoConfirmarrecebimentodeposito='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoConfirmarRecebimentoDeposito='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Recebimento\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoConfirmarRecebimentoDeposito ='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Recebimento:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Recebimento: \n" +erro);
            }
                    
        }
    }
    private void atualizar_taxa() {
       if(cbTipoTaxa.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoTaxaDeImplantacaoEFormaDePagamento='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Taxa\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoTaxaDeImplantacaoEFormaDePagamento ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from taxadeimplantacaoetaxapg where NumeroProcesso='"+processo+"'and AndamentoTaxaDeImplantacaoEformaPG='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoTaxaDeImplantacaoEFormaDePagamento='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Taxa\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoTaxaDeImplantacaoEFormaDePagamento ='Em Aberto' where Numerodoprocesso='"+processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Taxa:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Taxa: \n" +erro);
            }
                    
        }
    }

    private void atualizar_certidoes() {
       if(cbTipoCertidoes.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoPesquisaFiscal='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Certidoes\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoPesquisaFiscal ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from pesquisafiscal where NumeroProcesso='"+processo+"'and AndamentoPesquisaFiscal='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoPesquisaFiscal='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial>Certidoes\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoPesquisaFiscal ='Em Aberto' where Numerodoprocesso='"+processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Certidoes:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Certidoes: \n" +erro);
            }
                    
        }
    }

    private void atualizar_termo() {
        if(cbTipoTermo.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoEnviarTermoResponsaparacliente='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Termo\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoEnviarTermoResponsaparacliente ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from enviartermoresponsaparacliente where NumeroProcesso='"+processo+"'and AndamentoEnviarTermoResponsaParaCliente='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoEnviarTermoResponsaparacliente='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial>Termo\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoEnviarTermoResponsaparacliente ='Em Aberto' where Numerodoprocesso='"+processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Termo:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Termo: \n" +erro);
            }
                    
        }
    }

    private void atualizar_senhas() {
        if(cbTipoSenhas.getSelectedItem().equals("Finalizado")){
                    try{
                        String sql = "UPDATE comercial set AndamentoGravarSenhasFiscais='Finalizado' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Senhas\n" +erro);
                    }
        }
        else{
            try{
                con_geral.executeSQL("select * from comercial where Numerodoprocesso='" +processo+"' and AndamentoGravarSenhasFiscais ='Finalizado'");
                if(con_geral.resultset.next()){
                    JOptionPane.showMessageDialog(null, "O status desse processo ja foi finalizado! Mesmo com novo andamento cadastrado, \n"
                            + "para retomar o Status para 'Aberto' exclua ou altere todos os registros finalizados nesse painel\n"
                            + " ou assegure que não exista nenhum outro registro com situação 'Finalizado'");
                    //consulta se existe algum registro finalizado
     
                    con_geral.executeSQL("select * from gravarsenhasfiscais where NumeroProcesso='"+processo+"'and AndamentoGravarSenhasFiscais='Finalizado'");
                    
                    if(!con_geral.resultset.first()){
                        try{
                
                        String sql = "UPDATE comercial set AndamentoGravarSenhasFiscais='Em Aberto' where Numerodoprocesso='" +processo+"'";
                        con_geral.statement.executeUpdate(sql);
                        }catch(SQLException erro){
                            JOptionPane.showMessageDialog(null, "Falha ao atualizar a tabela Comercial>Senhas\n" +erro);
                        }
                        
                    }
                }
                else{
                    try{
                        String sql = "UPDATE comercial set AndamentoGravarSenhasFiscais ='Em Aberto' where Numerodoprocesso='"+processo+"'";
                        con_geral.statement.executeUpdate(sql);
                    }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null, "Falha ao atualizar  a tabela Comercial>Senhas:\n" +erro);
                    }
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro ao buscar status na tabela Comercial>Senhas: \n" +erro);
            }
                    
        }
    }

    private void criar_backup_recebimento() {
        codRec_backup = txtCodRecebimento.getText();
        tipoRec_backup = (String)cbTipoRecebimento.getSelectedItem();
        dataRec_backup = txtDataRecebimento.getText();
        obsRec_backup = txtObsRecebimento.getText();
    }

    private void limpar_tela_recebimento() {
        txtCodRecebimento.setEditable(false);
        txtCodRecebimento.setText("");
        cbTipoRecebimento.setSelectedItem("");
        txtObsRecebimento.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataRecebimento.setText(datahoje);
    }

    private void desbloquear_tela_recebimento() {
        txtCodRecebimento.setEditable(false);
        txtDataRecebimento.setEditable(true);
        cbTipoRecebimento.setEditable(true);
        txtObsRecebimento.setEditable(true);
    }

    private void bloquear_tela_recebimento() {
        txtCodRecebimento.setEditable(false);
        txtDataRecebimento.setEditable(false);
        cbTipoRecebimento.setEditable(false);
        txtObsRecebimento.setEditable(false);
    }

    private void restaurar_backup_recebimento() {
        txtCodRecebimento.setText(codRec_backup);
        cbTipoRecebimento.setSelectedItem(tipoRec_backup);
        txtDataRecebimento.setText(dataRec_backup);
        txtObsRecebimento.setText(obsRec_backup);
    }

    
    private void limpar_tabela_recebimento() {
        DefaultTableModel tbm = (DefaultTableModel)tbRecebimento.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }


    private void criar_backup_certidoes() {
        codCert_backup = txtCodCertidoes.getText();
        tipoCert_backup = (String)cbTipoCertidoes.getSelectedItem();
        dataCert_backup = txtDataCertidoes.getText();
        obsCert_backup = txtObsCertidoes.getText();
    }

    private void limpar_tela_certidoes() {
        txtCodCertidoes.setEditable(false);
        txtCodCertidoes.setText("");
        cbTipoCertidoes.setSelectedItem("");
        txtObsCertidoes.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataCertidoes.setText(datahoje);
    }

    private void desbloquear_tela_certidoes() {
        txtCodCertidoes.setEditable(false);
        txtDataCertidoes.setEditable(true);
        cbTipoCertidoes.setEditable(true);
        txtObsCertidoes.setEditable(true);
    }

    private void limpar_tabela_certidoes() {
       DefaultTableModel tbm = (DefaultTableModel)tbCertidoes.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    

    private void restaurar_backup_certidoes() {
        txtCodCertidoes.setText(codDoc_backup);
        cbTipoCertidoes.setSelectedItem(tipoDoc_backup);
        txtDataCertidoes.setText(dataDoc_backup);
        txtObsCertidoes.setText(obsDoc_backup);
    }

    private void bloquear_tela_certidoes() {
        txtCodCertidoes.setEditable(false);
        txtDataCertidoes.setEditable(false);
        cbTipoCertidoes.setEditable(false);
        txtObsCertidoes.setEditable(false);
    }

    private void criar_backup_termo() {
        codTermo_backup = txtCodTermo.getText();
        tipoTermo_backup = (String)cbTipoTermo.getSelectedItem();
        dataTermo_backup = txtDataTermo.getText();
        obsTermo_backup = txtObsTermo.getText();
    }

    private void desbloquear_tela_termo() {
        txtCodTermo.setEditable(false);
        txtDataTermo.setEditable(true);
        cbTipoTermo.setEditable(true);
        txtObsTermo.setEditable(true);
    }

    private void limpar_tela_termo() {
        txtCodTermo.setEditable(false);
        txtCodTermo.setText("");
        cbTipoTermo.setSelectedItem("");
        txtObsTermo.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataTermo.setText(datahoje);
    }

    private void restaurar_backup_termo() {
        txtCodTermo.setText(codTermo_backup);
        cbTipoTermo.setSelectedItem(tipoTermo_backup);
        txtDataTermo.setText(dataTermo_backup);
        txtObsTermo.setText(obsTermo_backup);
    }

    private void bloquear_tela_termo() {
        txtCodTermo.setEditable(false);
        txtDataTermo.setEditable(false);
        cbTipoTermo.setEditable(false);
        txtObsTermo.setEditable(false);
    }

    private void limpar_tabela_termo() {
        DefaultTableModel tbm = (DefaultTableModel)tbTermo.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }

    private void criar_backup_senhas() {
        codSenhas_backup = txtCodSenhas.getText();
        tipoSenhas_backup = (String)cbTipoSenhas.getSelectedItem();
        dataSenhas_backup = txtDataSenhas.getText();
        obsSenhas_backup = txtObsSenhas.getText();
    }

    private void limpar_tela_senhas() {
        txtCodSenhas.setEditable(false);
        txtCodSenhas.setText("");
        cbTipoSenhas.setSelectedItem("");
        txtObsSenhas.setText("");
        Date data = new Date();
        String datahoje = sdf.format(data);
        txtDataSenhas.setText(datahoje);
    }

    private void desbloquerar_tela_senhas() {
        txtCodSenhas.setEditable(false);
        txtDataSenhas.setEditable(true);
        cbTipoSenhas.setEditable(true);
        txtObsSenhas.setEditable(true);
    }

    private void limpar_tabela_senhas() {
        DefaultTableModel tbm = (DefaultTableModel)tbSenhas.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
                tbm.removeRow(i);
            }
    }
    
    private void restaurar_backup_senhas() {
        txtCodSenhas.setText(codSenhas_backup);
        cbTipoSenhas.setSelectedItem(tipoSenhas_backup);
        txtDataSenhas.setText(dataSenhas_backup);
        txtObsSenhas.setText(obsSenhas_backup);
    }

    private void bloquear_tela_senhas() {
        txtCodSenhas.setEditable(false);
        txtDataSenhas.setEditable(false);
        cbTipoSenhas.setEditable(false);
        txtObsSenhas.setEditable(false);
    }
}