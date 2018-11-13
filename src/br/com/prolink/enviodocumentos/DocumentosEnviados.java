package br.com.prolink.enviodocumentos;

import br.com.prolink.enviodocumentos.internas.EnviadosIntIpi;
import br.com.prolink.enviodocumentos.internas.EnviadosIntIrpfSalario;
import br.com.prolink.enviodocumentos.internas.EnviadosIntIrpfServicos;
import br.com.prolink.enviodocumentos.internas.EnviadosIntIss;
import br.com.prolink.enviodocumentos.internas.EnviadosIntIcms;
import br.com.prolink.enviodocumentos.internas.EnviadosIntCofins;
import br.com.prolink.enviodocumentos.internas.EnviadosIntIcmsServicos;
import br.com.prolink.enviodocumentos.internas.EnviadosIntIrpj;
import br.com.prolink.enviodocumentos.internas.EnviadosIntFgts;
import br.com.prolink.enviodocumentos.internas.EnviadosIntDas;
import br.com.prolink.enviodocumentos.internas.EnviadosIntBoletos;
import br.com.prolink.enviodocumentos.internas.EnviadosIntCsll;
import br.com.prolink.enviodocumentos.internas.EnviadosIntGps;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.factory.ConfigTables;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import br.com.prolink.model.UsuarioLogado;
import java.sql.Connection;
import java.sql.SQLException;

public class DocumentosEnviados extends javax.swing.JFrame {
    Processo p = ProcessoLogado.getInstance().getProcesso();
    String processo=p.getId()+"", nome=p.getCliente(),id=p.getApelido(),usuario=UsuarioLogado.getInstance().getUsuario().getUsuario();
    
    public DocumentosEnviados() {
        initComponents();
        btnRelatorio.setVisible(false);
        btnPDF.setVisible(false);
        btnExcel.setVisible(false);
        
        txtCodigo.setText(processo);
        txtNome.setText(nome);
        txtUsuario.setText(usuario);
        txtID.setText(id);
        DocumentosEnviadosDao doc = new DocumentosEnviadosDao();
        doc.atualizarTudo();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbBol1 = new javax.swing.JLabel();
        lbBol2 = new javax.swing.JLabel();
        lbBol3 = new javax.swing.JLabel();
        lbDas1 = new javax.swing.JLabel();
        lbDas2 = new javax.swing.JLabel();
        lbDas3 = new javax.swing.JLabel();
        lbCofins1 = new javax.swing.JLabel();
        lbCofins2 = new javax.swing.JLabel();
        lbCofins3 = new javax.swing.JLabel();
        lbIrpj1 = new javax.swing.JLabel();
        lbIrpj2 = new javax.swing.JLabel();
        lbIrpj3 = new javax.swing.JLabel();
        lbCsll1 = new javax.swing.JLabel();
        lbCsll2 = new javax.swing.JLabel();
        lbCsll3 = new javax.swing.JLabel();
        lbIss1 = new javax.swing.JLabel();
        lbIss2 = new javax.swing.JLabel();
        lbIss3 = new javax.swing.JLabel();
        lbGps1 = new javax.swing.JLabel();
        lbGps2 = new javax.swing.JLabel();
        lbGps3 = new javax.swing.JLabel();
        lbIrpfSal1 = new javax.swing.JLabel();
        lbIrpfSal2 = new javax.swing.JLabel();
        lbIrpfSal3 = new javax.swing.JLabel();
        lbIrpfServ1 = new javax.swing.JLabel();
        lbIrpfServ2 = new javax.swing.JLabel();
        lbIrpfServ3 = new javax.swing.JLabel();
        lbFgts1 = new javax.swing.JLabel();
        lbFgts2 = new javax.swing.JLabel();
        lbFgts3 = new javax.swing.JLabel();
        lbIcms3 = new javax.swing.JLabel();
        lbIcms2 = new javax.swing.JLabel();
        lbIcms1 = new javax.swing.JLabel();
        lbIpi3 = new javax.swing.JLabel();
        lbIpi2 = new javax.swing.JLabel();
        lbIpi1 = new javax.swing.JLabel();
        lbIcmsServ3 = new javax.swing.JLabel();
        lbIcmsServ2 = new javax.swing.JLabel();
        lbIcmsServ1 = new javax.swing.JLabel();
        btnBol = new javax.swing.JButton();
        btnDas = new javax.swing.JButton();
        btnCofins = new javax.swing.JButton();
        btnIrpj = new javax.swing.JButton();
        btnCsll = new javax.swing.JButton();
        btnIss = new javax.swing.JButton();
        btnIrpfSal = new javax.swing.JButton();
        btnGps = new javax.swing.JButton();
        btnIrpfServ = new javax.swing.JButton();
        btnFgts = new javax.swing.JButton();
        btnIpi = new javax.swing.JButton();
        btnIcms = new javax.swing.JButton();
        btnIcmsServ = new javax.swing.JButton();
        jDesktopPane = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        btnPDF = new javax.swing.JButton();
        btnRelatorio = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();

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
        txtCodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtID.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbId)
                    .addComponent(lbProcesso))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(lbNome)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbId, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("1º Envio");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("2º Envio");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("3º Envio");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Acompanhamento de Envios");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("BOLETO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("DAS");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("COFINS");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("IRPJ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("CSLL");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("ISS");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("GPS");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("IRPF SOBRE SALARIO");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("IRPF SOBRE SERVIÇO TOMADO");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("FGTS");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("ICMS");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("IPI");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("ICMS SERVIÇO");

        lbBol1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBol1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBol1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBol2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBol2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBol3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBol3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbBol3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDas1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDas2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDas2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDas3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDas3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCofins1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCofins1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCofins1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCofins2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCofins2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCofins2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCofins3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCofins3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCofins3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpj1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpj1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpj1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpj2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpj2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpj3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpj3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCsll1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCsll1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCsll1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCsll2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCsll2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCsll2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCsll3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCsll3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbCsll3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIss1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIss1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIss1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIss2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIss2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIss2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIss3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIss3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIss3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbGps1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGps1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbGps1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbGps2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGps2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbGps2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbGps3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGps3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbGps3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfSal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfSal1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpfSal1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfSal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfSal2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpfSal2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfSal3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfSal3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpfSal3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfServ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfServ1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpfServ1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfServ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfServ2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpfServ2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfServ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfServ3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIrpfServ3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFgts1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFgts1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFgts1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFgts2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFgts2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFgts2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFgts3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFgts3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbFgts3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcms3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcms3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIcms3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcms2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcms2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIcms2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcms1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcms1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIcms1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIpi3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIpi3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIpi3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIpi2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIpi2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIpi2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIpi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIpi1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIpi1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcmsServ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcmsServ3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIcmsServ3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcmsServ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcmsServ2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIcmsServ2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcmsServ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcmsServ1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbIcmsServ1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnBol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnBol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBol.setContentAreaFilled(false);
        btnBol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBolActionPerformed(evt);
            }
        });

        btnDas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnDas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDas.setContentAreaFilled(false);
        btnDas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDasActionPerformed(evt);
            }
        });

        btnCofins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnCofins.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCofins.setContentAreaFilled(false);
        btnCofins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCofinsActionPerformed(evt);
            }
        });

        btnIrpj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIrpj.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIrpj.setContentAreaFilled(false);
        btnIrpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrpjActionPerformed(evt);
            }
        });

        btnCsll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnCsll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCsll.setContentAreaFilled(false);
        btnCsll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCsllActionPerformed(evt);
            }
        });

        btnIss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIss.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIss.setContentAreaFilled(false);
        btnIss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssActionPerformed(evt);
            }
        });

        btnIrpfSal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIrpfSal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIrpfSal.setContentAreaFilled(false);
        btnIrpfSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrpfSalActionPerformed(evt);
            }
        });

        btnGps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnGps.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGps.setContentAreaFilled(false);
        btnGps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGpsActionPerformed(evt);
            }
        });

        btnIrpfServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIrpfServ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIrpfServ.setContentAreaFilled(false);
        btnIrpfServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrpfServActionPerformed(evt);
            }
        });

        btnFgts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnFgts.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFgts.setContentAreaFilled(false);
        btnFgts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFgtsActionPerformed(evt);
            }
        });

        btnIpi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIpi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIpi.setContentAreaFilled(false);
        btnIpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIpiActionPerformed(evt);
            }
        });

        btnIcms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIcms.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIcms.setContentAreaFilled(false);
        btnIcms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcmsActionPerformed(evt);
            }
        });

        btnIcmsServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/green_seta.png"))); // NOI18N
        btnIcmsServ.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnIcmsServ.setContentAreaFilled(false);
        btnIcmsServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcmsServActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbDas1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbDas2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbDas3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbBol1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbBol2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbBol3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIrpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIrpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIrpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbCofins1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCofins2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCofins3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIrpj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCofins, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIrpfSal1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIrpfSal2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIrpfSal3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbGps1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbGps2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbGps3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIss1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIss2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIss3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbCsll1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCsll2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbCsll3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIss, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCsll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIrpfSal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIcmsServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIcmsServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIcmsServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIpi1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIpi2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIpi3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIcms1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIcms2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIcms3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbFgts1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFgts2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbFgts3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lbIrpfServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIrpfServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbIrpfServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFgts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIrpfServ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnIcmsServ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBol, btnCofins, btnCsll, btnDas, btnFgts, btnGps, btnIcms, btnIcmsServ, btnIpi, btnIrpfSal, btnIrpfServ, btnIrpj, btnIss});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbBol1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBol2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBol3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBol, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbDas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCofins, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCofins1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCofins2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCofins3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIrpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIrpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIrpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIrpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCsll1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCsll2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCsll3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIss1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIss2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIss3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCsll, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(btnIss, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbGps1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbGps2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbGps3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIrpfSal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIrpfSal2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIrpfSal3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGps, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIrpfSal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIrpfServ, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIrpfServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIrpfServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIrpfServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbFgts1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFgts2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFgts3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnFgts, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIcms1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIcms2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIcms3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIpi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIpi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIpi3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIpi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbIcmsServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIcmsServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbIcmsServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIcmsServ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55))
        );

        jDesktopPane.setBackground(new java.awt.Color(250, 250, 250));
        jDesktopPane.setForeground(new java.awt.Color(255, 255, 255));
        jDesktopPane.setToolTipText("Cadastros");
        jDesktopPane.setDesktopManager(null);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gerar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnPDF.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/pdf_icon.png"))); // NOI18N
        btnPDF.setText("PDF");
        btnPDF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRelatorio.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/relatorio_icon.png"))); // NOI18N
        btnRelatorio.setText("Relatório");
        btnRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExcel.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/imagens/excel_icon.png"))); // NOI18N
        btnExcel.setText("EXCEL");
        btnExcel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPDF)
                .addGap(45, 45, 45))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcel, btnPDF, btnRelatorio});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBolActionPerformed
        jDesktopPane.removeAll();
        if(bol == null){
            bol = new EnviadosIntBoletos();
        }
        jDesktopPane.add(bol);
        bol.setVisible(true);
 
    }//GEN-LAST:event_btnBolActionPerformed

    private void btnDasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDasActionPerformed
        jDesktopPane.removeAll();
        if(das == null){
            das = new EnviadosIntDas();
        }
        jDesktopPane.add(das);
        das.setVisible(true);
 
    }//GEN-LAST:event_btnDasActionPerformed

    private void btnCofinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCofinsActionPerformed
        jDesktopPane.removeAll();
        if(cofins == null){
            cofins = new EnviadosIntCofins();
        }
        jDesktopPane.add(cofins);
        cofins.setVisible(true);
 
    }//GEN-LAST:event_btnCofinsActionPerformed

    private void btnIrpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrpjActionPerformed
        jDesktopPane.removeAll();
        if(irpj == null){
            irpj = new EnviadosIntIrpj();
        }
        jDesktopPane.add(irpj);
        irpj.setVisible(true);
    }//GEN-LAST:event_btnIrpjActionPerformed

    private void btnCsllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCsllActionPerformed
        jDesktopPane.removeAll();
        if(csll == null){
            csll = new EnviadosIntCsll();
        }
        jDesktopPane.add(csll);
        csll.setVisible(true);
    }//GEN-LAST:event_btnCsllActionPerformed

    private void btnIssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssActionPerformed
        jDesktopPane.removeAll();
        if(iss == null){
            iss = new EnviadosIntIss();
        }
        jDesktopPane.add(iss);
        iss.setVisible(true);
    }//GEN-LAST:event_btnIssActionPerformed

    private void btnGpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGpsActionPerformed
        jDesktopPane.removeAll();
        if(gps == null){
            gps = new EnviadosIntGps();
        }
        jDesktopPane.add(gps);
        gps.setVisible(true);
    }//GEN-LAST:event_btnGpsActionPerformed

    private void btnIrpfSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrpfSalActionPerformed
        jDesktopPane.removeAll();
        if(irpfSal == null){
            irpfSal = new EnviadosIntIrpfSalario();
        }
        jDesktopPane.add(irpfSal);
        irpfSal.setVisible(true);
    }//GEN-LAST:event_btnIrpfSalActionPerformed

    private void btnIrpfServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrpfServActionPerformed
        jDesktopPane.removeAll();
        if(irpfServ == null){
            irpfServ = new EnviadosIntIrpfServicos();
        }
        jDesktopPane.add(irpfServ);
        irpfServ.setVisible(true);
    }//GEN-LAST:event_btnIrpfServActionPerformed

    private void btnFgtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFgtsActionPerformed
        jDesktopPane.removeAll();
        if(fgts == null){
            fgts = new EnviadosIntFgts();
        }
        jDesktopPane.add(fgts);
        fgts.setVisible(true);
    }//GEN-LAST:event_btnFgtsActionPerformed

    private void btnIcmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcmsActionPerformed
        jDesktopPane.removeAll();
        if(icms == null){
            icms = new EnviadosIntIcms();
        }
        jDesktopPane.add(icms);
        icms.setVisible(true);
    }//GEN-LAST:event_btnIcmsActionPerformed

    private void btnIpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIpiActionPerformed
        jDesktopPane.removeAll();
        if(ipi == null){
            ipi = new EnviadosIntIpi();
        }
        jDesktopPane.add(ipi);
        ipi.setVisible(true);
    }//GEN-LAST:event_btnIpiActionPerformed

    private void btnIcmsServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcmsServActionPerformed
        jDesktopPane.removeAll();
        if(icmsServ == null){
            icmsServ = new EnviadosIntIcmsServicos();
        }
        jDesktopPane.add(icmsServ);
        icmsServ.setVisible(true);
    }//GEN-LAST:event_btnIcmsServActionPerformed
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
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumentosEnviados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumentosEnviados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBol;
    private javax.swing.JButton btnCofins;
    private javax.swing.JButton btnCsll;
    private javax.swing.JButton btnDas;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFgts;
    private javax.swing.JButton btnGps;
    private javax.swing.JButton btnIcms;
    private javax.swing.JButton btnIcmsServ;
    private javax.swing.JButton btnIpi;
    private javax.swing.JButton btnIrpfSal;
    private javax.swing.JButton btnIrpfServ;
    private javax.swing.JButton btnIrpj;
    private javax.swing.JButton btnIss;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel lbBol1;
    public static javax.swing.JLabel lbBol2;
    public static javax.swing.JLabel lbBol3;
    public static javax.swing.JLabel lbCofins1;
    public static javax.swing.JLabel lbCofins2;
    public static javax.swing.JLabel lbCofins3;
    public static javax.swing.JLabel lbCsll1;
    public static javax.swing.JLabel lbCsll2;
    public static javax.swing.JLabel lbCsll3;
    public static javax.swing.JLabel lbDas1;
    public static javax.swing.JLabel lbDas2;
    public static javax.swing.JLabel lbDas3;
    public static javax.swing.JLabel lbFgts1;
    public static javax.swing.JLabel lbFgts2;
    public static javax.swing.JLabel lbFgts3;
    public static javax.swing.JLabel lbGps1;
    public static javax.swing.JLabel lbGps2;
    public static javax.swing.JLabel lbGps3;
    public static javax.swing.JLabel lbIcms1;
    public static javax.swing.JLabel lbIcms2;
    public static javax.swing.JLabel lbIcms3;
    public static javax.swing.JLabel lbIcmsServ1;
    public static javax.swing.JLabel lbIcmsServ2;
    public static javax.swing.JLabel lbIcmsServ3;
    private javax.swing.JLabel lbId;
    public static javax.swing.JLabel lbIpi1;
    public static javax.swing.JLabel lbIpi2;
    public static javax.swing.JLabel lbIpi3;
    public static javax.swing.JLabel lbIrpfSal1;
    public static javax.swing.JLabel lbIrpfSal2;
    public static javax.swing.JLabel lbIrpfSal3;
    public static javax.swing.JLabel lbIrpfServ1;
    public static javax.swing.JLabel lbIrpfServ2;
    public static javax.swing.JLabel lbIrpfServ3;
    public static javax.swing.JLabel lbIrpj1;
    public static javax.swing.JLabel lbIrpj2;
    public static javax.swing.JLabel lbIrpj3;
    public static javax.swing.JLabel lbIss1;
    public static javax.swing.JLabel lbIss2;
    public static javax.swing.JLabel lbIss3;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbProcesso;
    public static javax.swing.JLabel txtCodigo;
    public static javax.swing.JLabel txtID;
    public static javax.swing.JLabel txtNome;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    EnviadosIntBoletos bol;
    EnviadosIntCofins cofins;
    EnviadosIntCsll csll;
    EnviadosIntDas das;
    EnviadosIntFgts fgts;
    EnviadosIntGps gps;
    EnviadosIntIcms icms;
    EnviadosIntIcmsServicos icmsServ;
    EnviadosIntIpi ipi;
    EnviadosIntIrpfSalario irpfSal;
    EnviadosIntIrpfServicos irpfServ;
    EnviadosIntIrpj irpj;
    EnviadosIntIss iss;
}