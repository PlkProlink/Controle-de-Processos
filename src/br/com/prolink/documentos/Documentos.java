package br.com.prolink.documentos;

import br.com.prolink.documentos.internas.DocumentosIntPerfil;
import br.com.prolink.documentos.internas.DocumentosIntSenhaInss;
import br.com.prolink.documentos.internas.*;
import br.com.prolink.inicio.*;
import java.text.SimpleDateFormat;


public class Documentos extends javax.swing.JFrame {

    String nome=Ativador.nome, id=Ativador.id, processo=Ativador.processo, usuario=Login.usuario;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Conexao con;
 /**
 *
 * @author Tiago Dias
 */
    public Documentos() {
        initComponents();
        
        con = new Conexao();
        con.conecta();
       
        afastamentos();
        ato();
        balancete();
        balanco();
        caged();
        comSocios();
        contas();
        darf();
        docSocios();
        ferias();
        funcionarios();
        hab();
        inss();
        pisSocio();
        plano();
        posto();
        prefeitura();
        receita();
        recisoes();
        sefip();
        simples();
        sindical();
        termo();
        folha();
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbProcesso = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbatoconstitutivo = new javax.swing.JLabel();
        lbdocumentossocio = new javax.swing.JLabel();
        lbcomprovantessocios = new javax.swing.JLabel();
        lbpissocio = new javax.swing.JLabel();
        lbhabilitacao = new javax.swing.JLabel();
        lbpostofiscal = new javax.swing.JLabel();
        lbsimples = new javax.swing.JLabel();
        btnAto = new javax.swing.JButton();
        btnDocSocios = new javax.swing.JButton();
        btnComSocios = new javax.swing.JButton();
        btnPisSocio = new javax.swing.JButton();
        btnHab = new javax.swing.JButton();
        btnPosto = new javax.swing.JButton();
        btnSimples = new javax.swing.JButton();
        lbComp1 = new javax.swing.JLabel();
        lbComp2 = new javax.swing.JLabel();
        lbComp3 = new javax.swing.JLabel();
        lbPis1 = new javax.swing.JLabel();
        lbPis2 = new javax.swing.JLabel();
        lbPis3 = new javax.swing.JLabel();
        lbHab1 = new javax.swing.JLabel();
        lbHab2 = new javax.swing.JLabel();
        lbHab3 = new javax.swing.JLabel();
        lbPosto1 = new javax.swing.JLabel();
        lbPosto2 = new javax.swing.JLabel();
        lbPosto3 = new javax.swing.JLabel();
        lbSimples1 = new javax.swing.JLabel();
        lbSimples2 = new javax.swing.JLabel();
        lbSimples3 = new javax.swing.JLabel();
        lbAto1 = new javax.swing.JLabel();
        lbAto2 = new javax.swing.JLabel();
        lbAto3 = new javax.swing.JLabel();
        lbDoc1 = new javax.swing.JLabel();
        lbDoc2 = new javax.swing.JLabel();
        lbDoc3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnFuncionarios = new javax.swing.JButton();
        btnCaged = new javax.swing.JButton();
        btnSefip = new javax.swing.JButton();
        btnSindical = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnDarf = new javax.swing.JButton();
        btnRecisoes = new javax.swing.JButton();
        btnFerias = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btnAfastamentos = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbDarf1 = new javax.swing.JLabel();
        lbDarf2 = new javax.swing.JLabel();
        lbDarf3 = new javax.swing.JLabel();
        lbRecisoes3 = new javax.swing.JLabel();
        lbRecisoes2 = new javax.swing.JLabel();
        lbRecisoes1 = new javax.swing.JLabel();
        lbFerias3 = new javax.swing.JLabel();
        lbFerias2 = new javax.swing.JLabel();
        lbFerias1 = new javax.swing.JLabel();
        lbAfastamentos3 = new javax.swing.JLabel();
        lbAfastamentos2 = new javax.swing.JLabel();
        lbAfastamentos1 = new javax.swing.JLabel();
        lbFuncionarios3 = new javax.swing.JLabel();
        lbFuncionarios2 = new javax.swing.JLabel();
        lbFuncionarios1 = new javax.swing.JLabel();
        lbCaged3 = new javax.swing.JLabel();
        lbCaged2 = new javax.swing.JLabel();
        lbCaged1 = new javax.swing.JLabel();
        lbSefip3 = new javax.swing.JLabel();
        lbSefip2 = new javax.swing.JLabel();
        lbSefip1 = new javax.swing.JLabel();
        lbSindical3 = new javax.swing.JLabel();
        lbSindical2 = new javax.swing.JLabel();
        lbSindical1 = new javax.swing.JLabel();
        btnFolha = new javax.swing.JButton();
        LBFolha = new javax.swing.JLabel();
        lbFolha3 = new javax.swing.JLabel();
        lbFolha2 = new javax.swing.JLabel();
        lbFolha1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btnReceita = new javax.swing.JButton();
        btnPrefeitura = new javax.swing.JButton();
        btnTermo = new javax.swing.JButton();
        btnInss = new javax.swing.JButton();
        lbInss1 = new javax.swing.JLabel();
        lbInss2 = new javax.swing.JLabel();
        lbInss3 = new javax.swing.JLabel();
        lbReceita1 = new javax.swing.JLabel();
        lbReceita2 = new javax.swing.JLabel();
        lbReceita3 = new javax.swing.JLabel();
        lbPrefeitura1 = new javax.swing.JLabel();
        lbPrefeitura2 = new javax.swing.JLabel();
        lbPrefeitura3 = new javax.swing.JLabel();
        lbTermo3 = new javax.swing.JLabel();
        lbTermo2 = new javax.swing.JLabel();
        lbTermo1 = new javax.swing.JLabel();
        jDesktopPane = new javax.swing.JDesktopPane();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnBalanco = new javax.swing.JButton();
        lbContas2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbContas1 = new javax.swing.JLabel();
        lbBalanco3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbBalanco2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbBalanco1 = new javax.swing.JLabel();
        lbBalancete3 = new javax.swing.JLabel();
        lbBalancete2 = new javax.swing.JLabel();
        lbBalancete1 = new javax.swing.JLabel();
        lbPlano1 = new javax.swing.JLabel();
        btnBalancete = new javax.swing.JButton();
        lbPlano2 = new javax.swing.JLabel();
        btnPlano = new javax.swing.JButton();
        lbPlano3 = new javax.swing.JLabel();
        btnContas = new javax.swing.JButton();
        lbContas3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Documentos Enviados");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        lbProcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbProcesso.setText("Processo:");

        lbId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbId.setText("ID:");

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Solicitação:");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Recebido:");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Validado:");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("ACOMPANHAMETOS");

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contratos"));

        lbatoconstitutivo.setText("ATO CONSTITUTIVO");
        lbatoconstitutivo.setToolTipText("Ato constitutivo e todas alterações registradas");

        lbdocumentossocio.setText("DOCUMETOS DOS SOCIOS");
        lbdocumentossocio.setToolTipText("Rg e cpf dos socios da empresa");

        lbcomprovantessocios.setText("COMPROVANTES DOS SOCIOS");
        lbcomprovantessocios.setToolTipText("Comprovantes de residencia dos socios");

        lbpissocio.setText("PIS SOCIO E/OU ADMINIST.");

        lbhabilitacao.setText("HABILITAÇÃO NF-E PMSP");

        lbpostofiscal.setText("SENHA POSTO FISCAL");
        lbpostofiscal.setToolTipText("Senha de acesso ao posto fiscal se houver");

        lbsimples.setText("SENHA SIMPLES NACIONAL");
        lbsimples.setToolTipText("");

        btnAto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnAto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAto.setContentAreaFilled(false);
        btnAto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtoActionPerformed(evt);
            }
        });

        btnDocSocios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnDocSocios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDocSocios.setContentAreaFilled(false);
        btnDocSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocSociosActionPerformed(evt);
            }
        });

        btnComSocios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnComSocios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnComSocios.setContentAreaFilled(false);
        btnComSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComSociosActionPerformed(evt);
            }
        });

        btnPisSocio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPisSocio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPisSocio.setContentAreaFilled(false);
        btnPisSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPisSocioActionPerformed(evt);
            }
        });

        btnHab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnHab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHab.setContentAreaFilled(false);
        btnHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabActionPerformed(evt);
            }
        });

        btnPosto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPosto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPosto.setContentAreaFilled(false);
        btnPosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostoActionPerformed(evt);
            }
        });

        btnSimples.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnSimples.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSimples.setContentAreaFilled(false);
        btnSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimplesActionPerformed(evt);
            }
        });

        lbComp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbComp1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbComp1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbComp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbComp2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbComp2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbComp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbComp3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbComp3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPis1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPis1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPis1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPis2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPis2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPis2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPis3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPis3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPis3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbHab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHab1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbHab1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbHab2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHab2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbHab2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbHab3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHab3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbHab3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPosto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPosto1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPosto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPosto2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPosto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPosto3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPosto3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSimples1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSimples1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSimples1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSimples2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSimples2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSimples2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSimples3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSimples3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSimples3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbAto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAto1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbAto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAto2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbAto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAto3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAto3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDoc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoc1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDoc1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDoc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoc2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDoc2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDoc3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoc3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDoc3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbpostofiscal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbhabilitacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbpissocio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbcomprovantessocios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(lbdocumentossocio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbatoconstitutivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbsimples, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnSimples, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDocSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPisSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lbSimples1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbSimples2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbSimples3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbDoc3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbComp1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbComp2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbComp3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbPosto1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbPosto2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbPosto3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbHab1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbHab2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbHab3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbPis1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbPis2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbPis3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(lbAto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(lbAto2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(lbAto3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbAto1, lbAto2, lbComp1, lbComp2, lbComp3, lbDoc1, lbDoc2, lbDoc3, lbHab1, lbHab2, lbHab3, lbPis1, lbPis2, lbPis3, lbPosto1, lbPosto2, lbPosto3, lbSimples1, lbSimples2, lbSimples3});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDoc3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbComp1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbComp2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbComp3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPis1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPis2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPis3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHab1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHab2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHab3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPosto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPosto2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPosto3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSimples1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSimples2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSimples3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbatoconstitutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbdocumentossocio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcomprovantessocios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbpissocio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lbhabilitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbpostofiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbsimples, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnComSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDocSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPisSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHab, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimples, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(250, 250, 250));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Departamento Pessoal"));

        btnFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnFuncionarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFuncionarios.setContentAreaFilled(false);
        btnFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionariosActionPerformed(evt);
            }
        });

        btnCaged.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnCaged.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCaged.setContentAreaFilled(false);
        btnCaged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCagedActionPerformed(evt);
            }
        });

        btnSefip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnSefip.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSefip.setContentAreaFilled(false);
        btnSefip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSefipActionPerformed(evt);
            }
        });

        btnSindical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnSindical.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSindical.setContentAreaFilled(false);
        btnSindical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSindicalActionPerformed(evt);
            }
        });

        jLabel20.setText("FICHAS DE FUNCIONARIOS");
        jLabel20.setToolTipText("Livros e fichas de registros dos colaboradores");

        jLabel21.setText("CAGED");

        jLabel27.setText("SEFIP");

        jLabel28.setText("GUIA SINDICAL");

        btnDarf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnDarf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDarf.setContentAreaFilled(false);
        btnDarf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarfActionPerformed(evt);
            }
        });

        btnRecisoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnRecisoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRecisoes.setContentAreaFilled(false);
        btnRecisoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecisoesActionPerformed(evt);
            }
        });

        btnFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnFerias.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFerias.setContentAreaFilled(false);
        btnFerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeriasActionPerformed(evt);
            }
        });

        jLabel25.setText("DARF, GPS, FGTS");

        btnAfastamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnAfastamentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAfastamentos.setContentAreaFilled(false);
        btnAfastamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfastamentosActionPerformed(evt);
            }
        });

        jLabel26.setText("RECISÕES");

        jLabel29.setText("RECIBOS DE FÉRIAS");

        jLabel30.setText("AFASTAMENTOS");

        lbDarf1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDarf1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDarf1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDarf2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDarf2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDarf2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDarf3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDarf3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDarf3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbRecisoes3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRecisoes3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbRecisoes3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbRecisoes2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRecisoes2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbRecisoes2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbRecisoes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRecisoes1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbRecisoes1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFerias3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFerias3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFerias3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFerias2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFerias2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFerias2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFerias1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFerias1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFerias1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbAfastamentos3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAfastamentos3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAfastamentos3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbAfastamentos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAfastamentos2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAfastamentos2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbAfastamentos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAfastamentos1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbAfastamentos1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFuncionarios3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFuncionarios3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFuncionarios3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFuncionarios2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFuncionarios2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFuncionarios2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFuncionarios1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFuncionarios1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFuncionarios1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCaged3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCaged3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCaged3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCaged2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCaged2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCaged2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCaged1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCaged1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCaged1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSefip3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSefip3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSefip3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSefip2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSefip2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSefip2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSefip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSefip1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSefip1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSindical3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSindical3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSindical3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSindical2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSindical2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSindical2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbSindical1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSindical1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbSindical1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnFolha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnFolha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFolha.setContentAreaFilled(false);
        btnFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolhaActionPerformed(evt);
            }
        });

        LBFolha.setText("FOLHA DE PAGAMENTO");
        LBFolha.setToolTipText("Livros e fichas de registros dos colaboradores");

        lbFolha3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFolha3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFolha3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFolha2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFolha2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFolha2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFolha1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFolha1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFolha1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(LBFolha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(lbFolha1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbFolha2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbFolha3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSefip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCaged, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSindical, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRecisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAfastamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDarf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbFuncionarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFuncionarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFuncionarios3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbCaged1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCaged2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCaged3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbSefip1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbSefip2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbSefip3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbSindical1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbSindical2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbSindical3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbDarf1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbDarf2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbDarf3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbRecisoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbRecisoes2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbRecisoes3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbFerias1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFerias2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFerias3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbAfastamentos1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbAfastamentos2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbAfastamentos3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(33, 33, 33))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFolha1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbFolha2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbFolha3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCaged, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSefip, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSindical, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDarf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAfastamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFuncionarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFuncionarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFuncionarios3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCaged1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCaged2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCaged3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSefip1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSefip2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSefip3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSindical1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSindical2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSindical3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDarf1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDarf2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDarf3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbRecisoes1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRecisoes2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRecisoes3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFerias1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFerias2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbFerias3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbAfastamentos1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAfastamentos2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAfastamentos3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel8.setBackground(new java.awt.Color(250, 250, 250));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Outras Senhas/ Procurações"));

        jLabel31.setText("SENHA RECEITA FEDERAL");
        jLabel31.setToolTipText("Outurgação de senhas eletronicas junto a Receita Federal");

        jLabel32.setText("PERFIL FISCAL PMSP");
        jLabel32.setToolTipText("Configuração do perfil fiscal do Prefeitura Municipal SP");

        jLabel33.setText("TERMO RESP.TECNICA");

        jLabel34.setText("SENHA DO INSS");

        btnReceita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnReceita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReceita.setContentAreaFilled(false);
        btnReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceitaActionPerformed(evt);
            }
        });

        btnPrefeitura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPrefeitura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrefeitura.setContentAreaFilled(false);
        btnPrefeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrefeituraActionPerformed(evt);
            }
        });

        btnTermo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnTermo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTermo.setContentAreaFilled(false);
        btnTermo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTermoActionPerformed(evt);
            }
        });

        btnInss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnInss.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInss.setContentAreaFilled(false);
        btnInss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInssActionPerformed(evt);
            }
        });

        lbInss1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInss1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbInss1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbInss2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInss2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbInss2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbInss3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInss3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbInss3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbReceita1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReceita1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbReceita1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbReceita2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReceita2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbReceita2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbReceita3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReceita3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbReceita3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPrefeitura1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrefeitura1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPrefeitura1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPrefeitura2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrefeitura2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPrefeitura2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPrefeitura3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrefeitura3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPrefeitura3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbTermo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTermo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTermo3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbTermo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTermo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTermo2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbTermo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTermo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbTermo1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrefeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbTermo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTermo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbTermo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbPrefeitura1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPrefeitura2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPrefeitura3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbReceita1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbReceita2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbReceita3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbInss1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbInss2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbInss3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbReceita1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReceita2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbReceita3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrefeitura1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrefeitura2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrefeitura3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTermo1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTermo2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTermo3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInss1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbInss2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbInss3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(btnReceita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrefeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInss, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDesktopPane.setBackground(new java.awt.Color(250, 250, 250));
        jDesktopPane.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPane.setToolTipText("Cadastros");
        jDesktopPane.setDesktopManager(null);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Solicitação:");
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Recebido:");
        jLabel36.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Validado:");
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jPanel9.setBackground(new java.awt.Color(250, 250, 250));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contabil"));

        btnBalanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnBalanco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBalanco.setContentAreaFilled(false);
        btnBalanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalancoActionPerformed(evt);
            }
        });

        lbContas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbContas2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbContas2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel19.setText("BALANCETE");
        jLabel19.setToolTipText("Balancete do exercicio atual se houver");

        lbContas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbContas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbContas1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBalanco3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalanco3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBalanco3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel17.setText("CONTAS PATRIMONIAIS");
        jLabel17.setToolTipText("Composição das contas patrimoniais");

        lbBalanco2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalanco2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBalanco2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel16.setText("BALANÇO E D.R.E");
        jLabel16.setToolTipText("Balanço e D.R.E do periodo anterior");

        lbBalanco1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalanco1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBalanco1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBalancete3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalancete3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBalancete3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBalancete2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalancete2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBalancete2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBalancete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalancete1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBalancete1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbPlano1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlano1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPlano1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnBalancete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnBalancete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBalancete.setContentAreaFilled(false);
        btnBalancete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceteActionPerformed(evt);
            }
        });

        lbPlano2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlano2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPlano2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnPlano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnPlano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPlano.setContentAreaFilled(false);
        btnPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlanoActionPerformed(evt);
            }
        });

        lbPlano3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlano3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPlano3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta_menor.png"))); // NOI18N
        btnContas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContas.setContentAreaFilled(false);
        btnContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContasActionPerformed(evt);
            }
        });

        lbContas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbContas3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbContas3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel18.setText("PLANO DE CONTAS");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBalancete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBalanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPlano2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPlano3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbContas1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbContas2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbContas3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbBalanco1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbBalanco2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbBalanco3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbBalancete1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbBalancete2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbBalancete3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBalanco1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBalanco2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBalanco3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbContas1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbContas2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbContas3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPlano1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPlano2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPlano3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBalancete1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBalancete2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBalancete3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(btnBalanco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBalancete, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDesktopPane)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel5, jPanel7});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37))
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbProcesso)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lbId)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lbNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtoActionPerformed
        jDesktopPane.removeAll();
        if(atoconstitutivo==null){
            atoconstitutivo = new DocumentosIntAtoConstitutivo();
        }
        jDesktopPane.add(atoconstitutivo);
        atoconstitutivo.setVisible(true);
    }//GEN-LAST:event_btnAtoActionPerformed

    private void btnDocSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocSociosActionPerformed
        jDesktopPane.removeAll();
        if(docsocios==null){
            docsocios = new DocumentosIntDocumentosSocios();
        }
        jDesktopPane.add(docsocios);
        docsocios.setVisible(true);
    }//GEN-LAST:event_btnDocSociosActionPerformed

    private void btnComSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComSociosActionPerformed
        jDesktopPane.removeAll();
        if(docsocios==null){
            docsocios = new DocumentosIntDocumentosSocios();
        }
        jDesktopPane.add(docsocios);
        docsocios.setVisible(true);
    }//GEN-LAST:event_btnComSociosActionPerformed

    private void btnPisSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPisSocioActionPerformed
        jDesktopPane.removeAll();
        if(npis==null){
            npis = new DocumentosIntNumeroPis();
        }
        jDesktopPane.add(npis);
        npis.setVisible(true);
    }//GEN-LAST:event_btnPisSocioActionPerformed
    
    private void btnHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabActionPerformed
        jDesktopPane.removeAll();
        if(habnfe==null){
            habnfe = new DocumentosIntHabilitacaoNFE();
        }
        jDesktopPane.add(habnfe);
        habnfe.setVisible(true);
    }//GEN-LAST:event_btnHabActionPerformed

    private void btnPostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostoActionPerformed
       jDesktopPane.removeAll();
        if(sposto==null){
            sposto = new DocumentosIntSenhaPosto();
        }
        jDesktopPane.add(sposto);
        sposto.setVisible(true);
    }//GEN-LAST:event_btnPostoActionPerformed

    private void btnSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimplesActionPerformed
        jDesktopPane.removeAll();
        if(ssimples==null){
            ssimples = new DocumentosIntSenhaSimples();
        }
        jDesktopPane.add(ssimples);
        ssimples.setVisible(true);
    }//GEN-LAST:event_btnSimplesActionPerformed

    private void btnBalancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalancoActionPerformed
        jDesktopPane.removeAll();
        if(balanco==null){
            balanco = new DocumentosIntBalanco();
        }
        jDesktopPane.add(balanco);
        balanco.setVisible(true);
    }//GEN-LAST:event_btnBalancoActionPerformed

    private void btnContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContasActionPerformed
        jDesktopPane.removeAll();
        if(contas==null){
            contas = new DocumentosIntContas();
        }
        jDesktopPane.add(contas);
        contas.setVisible(true);
    }//GEN-LAST:event_btnContasActionPerformed

    private void btnPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlanoActionPerformed
        jDesktopPane.removeAll();
        if(pcontas==null){
            pcontas = new DocumentosIntPlanodeContas();
        }
        jDesktopPane.add(pcontas);
        pcontas.setVisible(true);
    }//GEN-LAST:event_btnPlanoActionPerformed

    private void btnBalanceteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceteActionPerformed
        jDesktopPane.removeAll();
        if(balancete==null){
            balancete = new DocumentosIntBalancete();
        }
        jDesktopPane.add(balancete);
        balancete.setVisible(true);
    }//GEN-LAST:event_btnBalanceteActionPerformed

    private void btnFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionariosActionPerformed
        jDesktopPane.removeAll();
        if(fichas==null){
            fichas = new DocumentosIntFichas();
        }
        jDesktopPane.add(fichas);
        fichas.setVisible(true);
    }//GEN-LAST:event_btnFuncionariosActionPerformed

    private void btnCagedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCagedActionPerformed
        jDesktopPane.removeAll();
        if(caged==null){
            caged = new DocumentosIntCaged();
        }
        jDesktopPane.add(caged);
        caged.setVisible(true);
    }//GEN-LAST:event_btnCagedActionPerformed

    private void btnSefipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSefipActionPerformed
        jDesktopPane.removeAll();
        if(sefip==null){
            sefip = new DocumentosIntSefip();
        }
        jDesktopPane.add(sefip);
        sefip.setVisible(true);
    }//GEN-LAST:event_btnSefipActionPerformed

    private void btnSindicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSindicalActionPerformed
        jDesktopPane.removeAll();
        if(sindical==null){
            sindical = new DocumentosIntSindical();
        }
        jDesktopPane.add(sindical);
        sindical.setVisible(true);
    }//GEN-LAST:event_btnSindicalActionPerformed

    private void btnDarfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarfActionPerformed
        jDesktopPane.removeAll();
        if(guias==null){
            guias = new DocumentosIntGuias();
        }
        jDesktopPane.add(guias);
        guias.setVisible(true);
    }//GEN-LAST:event_btnDarfActionPerformed

    private void btnRecisoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecisoesActionPerformed
        jDesktopPane.removeAll();
        if(recisoes==null){
            recisoes = new DocumentosIntRecisoes();
        }
        jDesktopPane.add(recisoes);
        recisoes.setVisible(true);
    }//GEN-LAST:event_btnRecisoesActionPerformed

    private void btnFeriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeriasActionPerformed
        jDesktopPane.removeAll();
        if(ferias==null){
            ferias = new DocumentosIntFerias();
        }
        jDesktopPane.add(ferias);
        ferias.setVisible(true);
    }//GEN-LAST:event_btnFeriasActionPerformed

    private void btnAfastamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfastamentosActionPerformed
        jDesktopPane.removeAll();
        if(afastamento==null){
            afastamento = new DocumentosIntAfastamento();
        }
        jDesktopPane.add(afastamento);
        afastamento.setVisible(true);
    }//GEN-LAST:event_btnAfastamentosActionPerformed

    private void btnReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceitaActionPerformed
        jDesktopPane.removeAll();
        if(outorgar==null){
            outorgar = new DocumentosIntOutorgar();
        }
        jDesktopPane.add(outorgar);
        outorgar.setVisible(true);
    }//GEN-LAST:event_btnReceitaActionPerformed

    private void btnPrefeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrefeituraActionPerformed
        jDesktopPane.removeAll();
        if(perfil==null){
            perfil = new DocumentosIntPerfil();
        }
        jDesktopPane.add(perfil);
        perfil.setVisible(true);
    }//GEN-LAST:event_btnPrefeituraActionPerformed

    private void btnTermoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTermoActionPerformed
        jDesktopPane.removeAll();
        if(termo==null){
            termo = new DocumentosIntTermo();
        }
        jDesktopPane.add(termo);
        termo.setVisible(true);
    }//GEN-LAST:event_btnTermoActionPerformed

    private void btnInssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInssActionPerformed
        jDesktopPane.removeAll();
        if(sinss==null){
            sinss = new DocumentosIntSenhaInss();
        }
        jDesktopPane.add(sinss);
        sinss.setVisible(true);
    }//GEN-LAST:event_btnInssActionPerformed

    private void btnFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFolhaActionPerformed
        jDesktopPane.removeAll();
        if(folha==null){
            folha = new DocumentosIntFolha();
        }
        jDesktopPane.add(folha);
        folha.setVisible(true);
    }//GEN-LAST:event_btnFolhaActionPerformed


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
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Documentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Documentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBFolha;
    private javax.swing.JButton btnAfastamentos;
    private javax.swing.JButton btnAto;
    private javax.swing.JButton btnBalancete;
    private javax.swing.JButton btnBalanco;
    private javax.swing.JButton btnCaged;
    private javax.swing.JButton btnComSocios;
    private javax.swing.JButton btnContas;
    private javax.swing.JButton btnDarf;
    private javax.swing.JButton btnDocSocios;
    private javax.swing.JButton btnFerias;
    private javax.swing.JButton btnFolha;
    private javax.swing.JButton btnFuncionarios;
    private javax.swing.JButton btnHab;
    private javax.swing.JButton btnInss;
    private javax.swing.JButton btnPisSocio;
    private javax.swing.JButton btnPlano;
    private javax.swing.JButton btnPosto;
    private javax.swing.JButton btnPrefeitura;
    private javax.swing.JButton btnReceita;
    private javax.swing.JButton btnRecisoes;
    private javax.swing.JButton btnSefip;
    private javax.swing.JButton btnSimples;
    private javax.swing.JButton btnSindical;
    private javax.swing.JButton btnTermo;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JLabel lbAfastamentos1;
    public static javax.swing.JLabel lbAfastamentos2;
    public static javax.swing.JLabel lbAfastamentos3;
    public static javax.swing.JLabel lbAto1;
    public static javax.swing.JLabel lbAto2;
    public static javax.swing.JLabel lbAto3;
    public static javax.swing.JLabel lbBalancete1;
    public static javax.swing.JLabel lbBalancete2;
    public static javax.swing.JLabel lbBalancete3;
    public static javax.swing.JLabel lbBalanco1;
    public static javax.swing.JLabel lbBalanco2;
    public static javax.swing.JLabel lbBalanco3;
    public static javax.swing.JLabel lbCaged1;
    public static javax.swing.JLabel lbCaged2;
    public static javax.swing.JLabel lbCaged3;
    public static javax.swing.JLabel lbComp1;
    public static javax.swing.JLabel lbComp2;
    public static javax.swing.JLabel lbComp3;
    public static javax.swing.JLabel lbContas1;
    public static javax.swing.JLabel lbContas2;
    public static javax.swing.JLabel lbContas3;
    public static javax.swing.JLabel lbDarf1;
    public static javax.swing.JLabel lbDarf2;
    public static javax.swing.JLabel lbDarf3;
    public static javax.swing.JLabel lbDoc1;
    public static javax.swing.JLabel lbDoc2;
    public static javax.swing.JLabel lbDoc3;
    public static javax.swing.JLabel lbFerias1;
    public static javax.swing.JLabel lbFerias2;
    public static javax.swing.JLabel lbFerias3;
    public static javax.swing.JLabel lbFolha1;
    public static javax.swing.JLabel lbFolha2;
    public static javax.swing.JLabel lbFolha3;
    public static javax.swing.JLabel lbFuncionarios1;
    public static javax.swing.JLabel lbFuncionarios2;
    public static javax.swing.JLabel lbFuncionarios3;
    public static javax.swing.JLabel lbHab1;
    public static javax.swing.JLabel lbHab2;
    public static javax.swing.JLabel lbHab3;
    private javax.swing.JLabel lbId;
    public static javax.swing.JLabel lbInss1;
    public static javax.swing.JLabel lbInss2;
    public static javax.swing.JLabel lbInss3;
    private javax.swing.JLabel lbNome;
    public static javax.swing.JLabel lbPis1;
    public static javax.swing.JLabel lbPis2;
    public static javax.swing.JLabel lbPis3;
    public static javax.swing.JLabel lbPlano1;
    public static javax.swing.JLabel lbPlano2;
    public static javax.swing.JLabel lbPlano3;
    public static javax.swing.JLabel lbPosto1;
    public static javax.swing.JLabel lbPosto2;
    public static javax.swing.JLabel lbPosto3;
    public static javax.swing.JLabel lbPrefeitura1;
    public static javax.swing.JLabel lbPrefeitura2;
    public static javax.swing.JLabel lbPrefeitura3;
    private javax.swing.JLabel lbProcesso;
    public static javax.swing.JLabel lbReceita1;
    public static javax.swing.JLabel lbReceita2;
    public static javax.swing.JLabel lbReceita3;
    public static javax.swing.JLabel lbRecisoes1;
    public static javax.swing.JLabel lbRecisoes2;
    public static javax.swing.JLabel lbRecisoes3;
    public static javax.swing.JLabel lbSefip1;
    public static javax.swing.JLabel lbSefip2;
    public static javax.swing.JLabel lbSefip3;
    public static javax.swing.JLabel lbSimples1;
    public static javax.swing.JLabel lbSimples2;
    public static javax.swing.JLabel lbSimples3;
    public static javax.swing.JLabel lbSindical1;
    public static javax.swing.JLabel lbSindical2;
    public static javax.swing.JLabel lbSindical3;
    public static javax.swing.JLabel lbTermo1;
    public static javax.swing.JLabel lbTermo2;
    public static javax.swing.JLabel lbTermo3;
    private javax.swing.JLabel lbatoconstitutivo;
    private javax.swing.JLabel lbcomprovantessocios;
    private javax.swing.JLabel lbdocumentossocio;
    private javax.swing.JLabel lbhabilitacao;
    private javax.swing.JLabel lbpissocio;
    private javax.swing.JLabel lbpostofiscal;
    private javax.swing.JLabel lbsimples;
    public static javax.swing.JLabel txtCodigo;
    public static javax.swing.JLabel txtID;
    public static javax.swing.JLabel txtNome;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    DocumentosIntAfastamento afastamento;
    DocumentosIntAtoConstitutivo atoconstitutivo;
    DocumentosIntDocumentosSocios docsocios;
    DocumentosIntComprovantesSocios comsocios;
    DocumentosIntNumeroPis npis;
    DocumentosIntHabilitacaoNFE habnfe;
    DocumentosIntSenhaPosto sposto;
    DocumentosIntSenhaSimples ssimples;
    DocumentosIntBalanco balanco;
    DocumentosIntContas contas;
    DocumentosIntPlanodeContas pcontas;
    DocumentosIntBalancete balancete;
    DocumentosIntFolha folha;
    DocumentosIntFichas fichas;
    DocumentosIntCaged caged;
    DocumentosIntSefip sefip;
    DocumentosIntSindical sindical;
    DocumentosIntGuias guias;
    DocumentosIntRecisoes recisoes;
    DocumentosIntFerias ferias;
    DocumentosIntOutorgar outorgar;
    DocumentosIntPerfil perfil;
    DocumentosIntTermo termo;
    DocumentosIntSenhaInss sinss;
    
    public void afastamentos(){
    
    lbAfastamentos1.setText("");
    lbAfastamentos2.setText("");
    lbAfastamentos3.setText("");
    
    
    try{
        con.executeSQL("select * from afastamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbAfastamentos1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbAfastamentos2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbAfastamentos3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }
}

    private void ato() {
    lbAto1.setText("");
    lbAto2.setText("");
    lbAto3.setText("");
    
    
    try{
        con.executeSQL("select * from atoconstitutivo where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbAto1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbAto2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbAto3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }
    }

    private void balancete() {
    lbBalancete1.setText("");
    lbBalancete2.setText("");
    lbBalancete3.setText("");
    
    
    try{
        con.executeSQL("select * from balanceteexercicio where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbBalancete1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbBalancete2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbBalancete3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void balanco() {
    lbBalanco1.setText("");
    lbBalanco2.setText("");
    lbBalanco3.setText("");
    
    
    try{
        con.executeSQL("select * from balancodre where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbBalanco1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbBalanco2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbBalanco3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void caged() {
    lbCaged1.setText("");
    lbCaged2.setText("");
    lbCaged3.setText("");
    
    
    try{
        con.executeSQL("select * from caged where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbCaged1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbCaged2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbCaged3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void comSocios() {
    lbComp1.setText("");
    lbComp2.setText("");
    lbComp3.setText("");
    
    
    try{
        con.executeSQL("select * from comprovanteresidencia where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbComp1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbComp2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbComp3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void contas() {
    lbContas1.setText("");
    lbContas2.setText("");
    lbContas3.setText("");
    
    
    try{
        con.executeSQL("select * from composicaodecontaspatrimoniais where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbContas1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbContas2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbContas3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void darf() {
    lbDarf1.setText("");
    lbDarf2.setText("");
    lbDarf3.setText("");
    
    
    try{
        con.executeSQL("select * from guiasdarfgpsfgts where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbDarf1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbDarf2.setText(ndata2);
            }
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbDarf3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void docSocios() {
    lbComp1.setText("");
    lbComp2.setText("");
    lbComp3.setText("");
    
    
    try{
        con.executeSQL("select * from rgecpfsocio where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbComp1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbComp2.setText(ndata2);
            }
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbComp3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void ferias() {
    lbFerias1.setText("");
    lbFerias2.setText("");
    lbFerias3.setText("");
    
    
    try{
        con.executeSQL("select * from ferias where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbFerias1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbFerias2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
            
                lbFerias3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void funcionarios() {
    lbFuncionarios1.setText("");
    lbFuncionarios2.setText("");
    lbFuncionarios3.setText("");
    
    
    try{
        con.executeSQL("select * from livrooufichaderegistrofuncionario where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbFuncionarios1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbFuncionarios2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbFuncionarios3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void hab() {
    lbHab1.setText("");
    lbHab2.setText("");
    lbHab3.setText("");
    
    
    try{
        con.executeSQL("select * from autorizacaonotafiscaleletronica where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbHab1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbHab2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbHab3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }    
    
    private void inss() {
    lbInss1.setText("");
    lbInss2.setText("");
    lbInss3.setText("");
    
    
    try{
        con.executeSQL("select * from senhainss where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbInss1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbInss2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbInss3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }
    
    private void pisSocio() {
    lbPis1.setText("");
    lbPis2.setText("");
    lbPis3.setText("");
    
    
    try{
        con.executeSQL("select * from numeropis where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbPis1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbPis2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbPis3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void plano() {
    lbPlano1.setText("");
    lbPlano2.setText("");
    lbPlano3.setText("");
    
    
    try{
        con.executeSQL("select * from planodecontas where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbPlano1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbPlano2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbPlano3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void posto() {
    lbPosto1.setText("");
    lbPosto2.setText("");
    lbPosto3.setText("");
    
    
    try{
        con.executeSQL("select * from senhapostofiscal where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbPosto1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbPosto2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbPosto3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void prefeitura() {
    lbPrefeitura1.setText("");
    lbPrefeitura2.setText("");
    lbPrefeitura3.setText("");
    
    
    try{
        con.executeSQL("select * from configurarperfilfiscalnositeprefeituradocumento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbPrefeitura1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbPrefeitura2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
               lbPrefeitura3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void receita() {
    lbReceita1.setText("");
    lbReceita2.setText("");
    lbReceita3.setText("");
    
    
    try{
        con.executeSQL("select * from outorgasenhaeletronicareceita where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbReceita1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbReceita2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbReceita3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void recisoes() {
    lbRecisoes1.setText("");
    lbRecisoes2.setText("");
    lbRecisoes3.setText("");
    
    
    try{
        con.executeSQL("select * from recisao where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbRecisoes1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbRecisoes2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbRecisoes3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void sefip() {
    lbSefip1.setText("");
    lbSefip2.setText("");
    lbSefip3.setText("");
    
    
    try{
        con.executeSQL("select * from sefip where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbSefip1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbSefip2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbSefip3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void simples() {
    lbSimples1.setText("");
    lbSimples2.setText("");
    lbSimples3.setText("");
    
    
    try{
        con.executeSQL("select * from senhasimplesnacional where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbSimples1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbSimples2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbSimples3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }

    private void sindical() {
    lbSindical1.setText("");
    lbSindical2.setText("");
    lbSindical3.setText("");
    
    
    try{
        con.executeSQL("select * from guiasindical where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbSindical1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbSindical2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
               lbSindical3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }    

    private void termo() {
    lbTermo1.setText("");
    lbTermo2.setText("");
    lbTermo3.setText("");
    
    
    try{
        con.executeSQL("select * from termoderesponsabilidadedocumento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbTermo1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbTermo2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbTermo3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }    
    }
    
    public void folha(){
    lbFolha1.setText("");
    lbFolha2.setText("");
    lbFolha3.setText("");
    
    
    try{
        con.executeSQL("select * from folhadepagamentodocumento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("DatadeCadastroAndamento");
            data2 = con.resultset.getString("DataDevulucaoCliente");
            data3 = con.resultset.getString("DataFinalAndamento");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbFolha1.setText(ndata1);
            }
            
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbFolha2.setText(ndata2);
            }
            
            
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbFolha3.setText(ndata3);
            }
        }
    }catch(Exception erro){
    }
    }    
}