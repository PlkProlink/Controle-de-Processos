package br.com.prolink.cadastros.enviodocumentos;

import br.com.prolink.cadastros.enviodocumentos.envios.*;
import br.com.prolink.inicio.*;
import java.text.SimpleDateFormat;


public class DocumentosEnviados extends javax.swing.JFrame {

    String nome=Ativador.nome, id=Ativador.id, processo=Ativador.processo, usuario=Login.usuario;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Conexao con;
    
    public DocumentosEnviados() {
        initComponents();
        
        con = new Conexao();
        con.conecta();
        
        btnRelatorio.setVisible(false);
        btnPDF.setVisible(false);
        btnExcel.setVisible(false);
        
        txtCodigo.setText(processo);
        txtNome.setText(nome);
        txtUsuario.setText(usuario);
        txtID.setText(id);
        
        tudo();
        
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
        okIrrfServ = new javax.swing.JLabel();
        okFgts = new javax.swing.JLabel();
        okIcms = new javax.swing.JLabel();
        okIpi = new javax.swing.JLabel();
        okIcmsServ = new javax.swing.JLabel();
        okBol = new javax.swing.JLabel();
        okDas = new javax.swing.JLabel();
        okCofins = new javax.swing.JLabel();
        okIrpj = new javax.swing.JLabel();
        okCsll = new javax.swing.JLabel();
        okGps = new javax.swing.JLabel();
        okIrrf = new javax.swing.JLabel();
        okIss = new javax.swing.JLabel();
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
        txtCodigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("1º Envio");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("2º Envio");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("3º Envio");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        lbBol1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbBol1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBol2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBol2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbBol2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbBol3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBol3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbBol3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDas1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbDas1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDas2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbDas2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbDas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDas3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbDas3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCofins1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCofins1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCofins1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCofins2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCofins2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCofins2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCofins3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCofins3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCofins3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpj1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpj1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpj1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpj2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpj2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpj3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpj3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCsll1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCsll1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCsll1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCsll2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCsll2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCsll2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbCsll3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCsll3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbCsll3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIss1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIss1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIss1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIss2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIss2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIss2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIss3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIss3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIss3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbGps1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGps1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbGps1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbGps2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGps2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbGps2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbGps3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGps3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbGps3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfSal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfSal1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpfSal1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfSal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfSal2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpfSal2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfSal3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfSal3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpfSal3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfServ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfServ1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpfServ1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfServ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfServ2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpfServ2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIrpfServ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIrpfServ3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIrpfServ3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFgts1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFgts1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbFgts1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFgts2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFgts2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbFgts2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbFgts3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFgts3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbFgts3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcms3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcms3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcms3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcms2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcms2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcms2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcms1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcms1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcms1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIpi3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIpi3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIpi3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIpi2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIpi2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIpi2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIpi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIpi1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIpi1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcmsServ3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcmsServ3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcmsServ3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcmsServ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcmsServ2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcmsServ2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lbIcmsServ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcmsServ1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcmsServ1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIrrfServ.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIrrfServ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIrrfServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIrrfServ.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okFgts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okFgts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okFgts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okFgts.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIcms.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIcms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIcms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIcms.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIpi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIpi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIpi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIpi.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIcmsServ.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIcmsServ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIcmsServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIcmsServ.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okBol.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okBol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okBol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okBol.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        okBol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okBolMouseClicked(evt);
            }
        });

        okDas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okDas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okDas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okDas.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        okDas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okDasMouseClicked(evt);
            }
        });

        okCofins.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okCofins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okCofins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okCofins.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIrpj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIrpj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIrpj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIrpj.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okCsll.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okCsll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okCsll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okCsll.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okGps.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okGps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okGps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okGps.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIrrf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIrrf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIrrf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIrrf.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        okIss.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        okIss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        okIss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/green_seta.png"))); // NOI18N
        okIss.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

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
                                .addComponent(lbIrpfServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(lbCsll3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(lbCofins3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbDas1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbDas2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbDas3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(lbBol3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(okIcmsServ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okFgts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okIrrfServ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okIrrf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okGps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okIss, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okCsll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okIrpj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okCofins, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okDas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okBol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(okBol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okDas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okCofins, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIrpj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okCsll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okGps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIrrf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIrrfServ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okFgts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okIcmsServ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                                    .addComponent(lbBol3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbDas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbCofins1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCofins2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbCofins3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbIrpj1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIrpj2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIrpj3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbIrpfServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIrpfServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIrpfServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbFgts1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFgts2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbFgts3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbIcms1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIcms2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIcms3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbIpi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIpi2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIpi3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbIcmsServ1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIcmsServ2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbIcmsServ3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/pdf_icon.png"))); // NOI18N
        btnPDF.setText("PDF");
        btnPDF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRelatorio.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/relatorio_icon.png"))); // NOI18N
        btnRelatorio.setText("Relatório");
        btnRelatorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExcel.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/prolink/cadastros/enviodocumentos/excel_icon.png"))); // NOI18N
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

    private void okBolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okBolMouseClicked
        jDesktopPane.removeAll();
        if(envbol == null){
            envbol = new EnviadosIntBoletos();
        }
        jDesktopPane.add(envbol);
        envbol.setVisible(true);
      
    }//GEN-LAST:event_okBolMouseClicked

    private void okDasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okDasMouseClicked
        jDesktopPane.removeAll();
        if(envdas == null){
            envdas = new EnviadosIntCsll();
        }
        jDesktopPane.add(envdas);
        envdas.setVisible(true);
    }//GEN-LAST:event_okDasMouseClicked


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
    private javax.swing.JButton btnExcel;
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
    private javax.swing.JLabel okBol;
    private javax.swing.JLabel okCofins;
    private javax.swing.JLabel okCsll;
    private javax.swing.JLabel okDas;
    private javax.swing.JLabel okFgts;
    private javax.swing.JLabel okGps;
    private javax.swing.JLabel okIcms;
    private javax.swing.JLabel okIcmsServ;
    private javax.swing.JLabel okIpi;
    private javax.swing.JLabel okIrpj;
    private javax.swing.JLabel okIrrf;
    private javax.swing.JLabel okIrrfServ;
    private javax.swing.JLabel okIss;
    public static javax.swing.JLabel txtCodigo;
    public static javax.swing.JLabel txtID;
    public static javax.swing.JLabel txtNome;
    public static javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
    EnviadosIntBoletos envbol;
    EnviadosIntDas envdas;
    EnviadosIntCofins encofins;
    
    public void tudo(){
        boleto();
        cofins();
        csll();
        das();
        fgts();
        gps();
        icms();
        icms_servico();
        ipi();
        irpf_salario();
        irpf_servico();
        irpj();
        iss();    

}
public void boleto(){
    
    try{
        con.executeSQL("select * from boletoplkacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbBol1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbBol2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbBol3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void das(){
    
    try{
        con.executeSQL("select * from dasacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbDas1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbDas2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbDas3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
}
public void cofins(){
    
    try{
        con.executeSQL("select * from pisacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbCofins1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbCofins2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbCofins3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void irpj(){
    
    try{
        con.executeSQL("select * from irpjacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIrpj1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIrpj2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIrpj3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void csll(){
    
    try{
        con.executeSQL("select * from csllacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbCsll1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbCsll2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbCsll3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void iss(){
    
    try{
        con.executeSQL("select * from issacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIss1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIss2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIss3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
}
public void gps(){
    
    try{
        con.executeSQL("select * from gpsacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbGps1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbGps2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbGps3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
}
public void irpf_salario(){
    
    try{
        con.executeSQL("select * from irpfsobresalarioacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIrpfSal1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIrpfSal2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIrpfSal3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
}
public void irpf_servico(){
    
    try{
        con.executeSQL("select * from irpfsobreservicotomadoacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIrpfServ1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIrpfServ2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIrpfServ3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
}
public void fgts(){
    
    try{
        con.executeSQL("select * from fgtsacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbFgts1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbFgts2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbFgts3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void icms(){
    
    try{
        con.executeSQL("select * from icmsacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIcms1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIcms2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIcms3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void ipi(){
    
    try{
        con.executeSQL("select * from ipiacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIpi1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIpi2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIpi3.setText(ndata3);
            }
        }
    }catch(Exception erro){
        
    }
}
public void icms_servico(){
    
    try{
        con.executeSQL("select * from icmsservtomacompanhamento where NumeroProcesso='"+processo+"'");
        if(con.resultset.last()){
            
            String data1, data2, data3;
            
            data1 = con.resultset.getString("Data1Envio");
            data2 = con.resultset.getString("Data2Envio");
            data3 = con.resultset.getString("Data3Envio");
            
            String  ndata1, ndata2, ndata3;
            
            if(data1.trim().length()==10 && !data1.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata1 = dia+"/"+mes+"/"+ano;
                lbIcmsServ1.setText(ndata1);
            }
            if(data2.trim().length()==10 && !data2.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata2 = dia+"/"+mes+"/"+ano;
                lbIcmsServ2.setText(ndata2);
            }
            if(data3.trim().length()==10 && !data3.equals("1111-11-11")){
                String ano = data1.substring(0, 4);
                String mes = data1.substring(5, 7);
                String dia = data1.substring(8);
                ndata3 = dia+"/"+mes+"/"+ano;
                lbIcmsServ3.setText(ndata3);
            }
            
        }
    }catch(Exception erro){
        
    }
}
}
