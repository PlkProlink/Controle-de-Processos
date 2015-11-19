/*não muito o que explicar, basicamente essa classe de menu, vai importar todas as classes,
será um gestor de ações, fara a chamada para as novas classes

Tiago Dias de Souza tiagoice@hotmail.com

1-etapa = telas
2-etapa = codigo + conexao
3-envio e recebebimento entre  telas
4-etapa = relatorios
5-etapa = graficos
6-javahelp
*/
package br.com.prolink.inicio;

import br.com.prolink.cadastros.enviodocumentos.DocumentosEnviados;
import br.com.prolink.departamentos.*;
import br.com.prolink.cadastros.*;
import br.com.prolink.usuario.*;;
import br.com.prolink.login.*;
import br.com.prolink.recepcao.*;



import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    data mostrar_data = new data();
   
    public TelaPrincipal() {
        initComponents();
        
        txt_usuario.setText(Login.usuario);
        txt_departamento.setText(Login.departamento);
        
        mostrar_data = new data();
        mostrar_data.lerData();
        txtData.setText(""+mostrar_data.dia_semana+
                        " , "+mostrar_data.dia+
                        " de "+mostrar_data.mes+
                        " de "+mostrar_data.ano);
        timer1.start();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timer1 = new org.netbeans.examples.lib.timerbean.Timer();
        jpPrincipal = new javax.swing.JPanel();
        jpDepartamentos = new javax.swing.JPanel();
        btnComercial = new javax.swing.JButton();
        btnContabil = new javax.swing.JButton();
        btnContratos = new javax.swing.JButton();
        btnPessoal = new javax.swing.JButton();
        btnFinanceiro = new javax.swing.JButton();
        btnFiscal = new javax.swing.JButton();
        btnRegularizacao = new javax.swing.JButton();
        jpOutros = new javax.swing.JPanel();
        btnArqEnviados = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();
        btnDocumentos = new javax.swing.JButton();
        btnAdministracao = new javax.swing.JButton();
        btnMensagem = new javax.swing.JButton();
        jpProcessos = new javax.swing.JPanel();
        btnClassificacao = new javax.swing.JButton();
        btnNovoProcesso = new javax.swing.JButton();
        jpRececepcao = new javax.swing.JPanel();
        btnConfirmarDocumento = new javax.swing.JButton();
        btnNovoDocumentoRec = new javax.swing.JButton();
        jpBarraInfo = new javax.swing.JPanel();
        txt_finalizada = new javax.swing.JLabel();
        lbFinalizada = new javax.swing.JLabel();
        txt_ativada = new javax.swing.JLabel();
        lbAtivada = new javax.swing.JLabel();
        lbClassificacao = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JLabel();
        txt_departamento = new javax.swing.JLabel();
        lb_apelido = new javax.swing.JLabel();
        btnModificarData = new javax.swing.JButton();
        txtData = new javax.swing.JLabel();
        txtHora = new javax.swing.JLabel();
        txt_classificacao = new javax.swing.JLabel();
        txt_nome = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JLabel();
        barraGuias = new javax.swing.JMenuBar();
        jmCadastro = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu6 = new javax.swing.JMenu();
        jmCadUsuario = new javax.swing.JMenuItem();
        jmDepartamento = new javax.swing.JMenuItem();
        jmControledeAcesso = new javax.swing.JMenuItem();
        jmAlteraSenha = new javax.swing.JMenuItem();
        jmTrocadeUsuario = new javax.swing.JMenuItem();
        jmRecepcao = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmControle = new javax.swing.JMenu();
        menu_arquivos = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menu_comercial = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menu_contabil = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menu_contratos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menu_deppessoal = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menu_documentos = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menu_financeiro = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        menu_fiscal = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        menu_regulazicacao = new javax.swing.JMenuItem();
        jmRelatorios = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jmAtivar = new javax.swing.JMenu();
        jmSobre = new javax.swing.JMenu();
        jmSair = new javax.swing.JMenu();

        timer1.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                timer1OnTime(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(false);
        setForeground(new java.awt.Color(255, 255, 255));
        setName("Menu Principal"); // NOI18N

        jpPrincipal.setBackground(new java.awt.Color(245, 245, 245));
        jpPrincipal.setToolTipText("");
        jpPrincipal.setMinimumSize(new java.awt.Dimension(800, 600));
        jpPrincipal.setName(""); // NOI18N
        jpPrincipal.setPreferredSize(new java.awt.Dimension(1280, 720));

        jpDepartamentos.setBackground(new java.awt.Color(245, 245, 245));
        jpDepartamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpDepartamentos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jpDepartamentos.setOpaque(false);

        btnComercial.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnComercial.setText("Comercial");
        btnComercial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnComercial.setBorderPainted(false);
        btnComercial.setMaximumSize(new java.awt.Dimension(80, 23));
        btnComercial.setPreferredSize(new java.awt.Dimension(80, 23));
        btnComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComercialActionPerformed(evt);
            }
        });

        btnContabil.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnContabil.setText("Contabil");
        btnContabil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContabil.setBorderPainted(false);
        btnContabil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContabilActionPerformed(evt);
            }
        });

        btnContratos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnContratos.setText("Contratos");
        btnContratos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContratos.setBorderPainted(false);
        btnContratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContratosActionPerformed(evt);
            }
        });

        btnPessoal.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnPessoal.setText("Dep.Pessoal");
        btnPessoal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPessoal.setBorderPainted(false);
        btnPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPessoalActionPerformed(evt);
            }
        });

        btnFinanceiro.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnFinanceiro.setText("Financeiro");
        btnFinanceiro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFinanceiro.setBorderPainted(false);
        btnFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiroActionPerformed(evt);
            }
        });

        btnFiscal.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnFiscal.setText("Fiscal");
        btnFiscal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFiscal.setBorderPainted(false);
        btnFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiscalActionPerformed(evt);
            }
        });

        btnRegularizacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnRegularizacao.setText("Regularização");
        btnRegularizacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegularizacao.setBorderPainted(false);
        btnRegularizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegularizacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDepartamentosLayout = new javax.swing.GroupLayout(jpDepartamentos);
        jpDepartamentos.setLayout(jpDepartamentosLayout);
        jpDepartamentosLayout.setHorizontalGroup(
            jpDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDepartamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContabil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegularizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDepartamentosLayout.setVerticalGroup(
            jpDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDepartamentosLayout.createSequentialGroup()
                .addGroup(jpDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContabil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegularizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpDepartamentosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnComercial, btnContabil, btnContratos, btnFinanceiro, btnFiscal, btnPessoal, btnRegularizacao});

        jpOutros.setBackground(new java.awt.Color(245, 245, 245));
        jpOutros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles Gerenciais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpOutros.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jpOutros.setOpaque(false);

        btnArqEnviados.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnArqEnviados.setText("Arq.Enviados");
        btnArqEnviados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArqEnviados.setBorderPainted(false);
        btnArqEnviados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArqEnviadosActionPerformed(evt);
            }
        });

        btnRelatorios.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnRelatorios.setText("Relatórios");
        btnRelatorios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRelatorios.setBorderPainted(false);
        btnRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatoriosActionPerformed(evt);
            }
        });

        btnDocumentos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnDocumentos.setText("Documentos");
        btnDocumentos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDocumentos.setBorderPainted(false);

        btnAdministracao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnAdministracao.setText("Acessos");
        btnAdministracao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdministracao.setBorderPainted(false);
        btnAdministracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministracaoActionPerformed(evt);
            }
        });

        btnMensagem.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnMensagem.setText("Mensagem");
        btnMensagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMensagem.setBorderPainted(false);
        btnMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMensagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOutrosLayout = new javax.swing.GroupLayout(jpOutros);
        jpOutros.setLayout(jpOutrosLayout);
        jpOutrosLayout.setHorizontalGroup(
            jpOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOutrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnArqEnviados, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdministracao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpOutrosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdministracao, btnArqEnviados, btnDocumentos, btnMensagem, btnRelatorios});

        jpOutrosLayout.setVerticalGroup(
            jpOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOutrosLayout.createSequentialGroup()
                .addGroup(jpOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArqEnviados, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDocumentos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdministracao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpOutrosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdministracao, btnArqEnviados, btnDocumentos, btnMensagem, btnRelatorios});

        btnArqEnviados.getAccessibleContext().setAccessibleName("");
        btnRelatorios.getAccessibleContext().setAccessibleName("");
        btnDocumentos.getAccessibleContext().setAccessibleName("");
        btnAdministracao.getAccessibleContext().setAccessibleName("");
        btnMensagem.getAccessibleContext().setAccessibleName("");

        jpProcessos.setBackground(new java.awt.Color(245, 245, 245));
        jpProcessos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Guia de Processos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpProcessos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jpProcessos.setOpaque(false);

        btnClassificacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnClassificacao.setText("Perfis");
        btnClassificacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClassificacao.setBorderPainted(false);
        btnClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassificacaoActionPerformed(evt);
            }
        });

        btnNovoProcesso.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnNovoProcesso.setText("Novo");
        btnNovoProcesso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNovoProcesso.setBorderPainted(false);
        btnNovoProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpProcessosLayout = new javax.swing.GroupLayout(jpProcessos);
        jpProcessos.setLayout(jpProcessosLayout);
        jpProcessosLayout.setHorizontalGroup(
            jpProcessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProcessosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpProcessosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClassificacao, btnNovoProcesso});

        jpProcessosLayout.setVerticalGroup(
            jpProcessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProcessosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnNovoProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpProcessosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClassificacao, btnNovoProcesso});

        jpRececepcao.setBackground(new java.awt.Color(245, 245, 245));
        jpRececepcao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recepção de Documentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jpRececepcao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jpRececepcao.setOpaque(false);

        btnConfirmarDocumento.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnConfirmarDocumento.setText("Confirmar");
        btnConfirmarDocumento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfirmarDocumento.setBorderPainted(false);
        btnConfirmarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarDocumentoActionPerformed(evt);
            }
        });

        btnNovoDocumentoRec.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnNovoDocumentoRec.setText("Novo");
        btnNovoDocumentoRec.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNovoDocumentoRec.setBorderPainted(false);
        btnNovoDocumentoRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDocumentoRecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRececepcaoLayout = new javax.swing.GroupLayout(jpRececepcao);
        jpRececepcao.setLayout(jpRececepcaoLayout);
        jpRececepcaoLayout.setHorizontalGroup(
            jpRececepcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRececepcaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoDocumentoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpRececepcaoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnConfirmarDocumento, btnNovoDocumentoRec});

        jpRececepcaoLayout.setVerticalGroup(
            jpRececepcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRececepcaoLayout.createSequentialGroup()
                .addGroup(jpRececepcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoDocumentoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmarDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpRececepcaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnConfirmarDocumento, btnNovoDocumentoRec});

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpRececepcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOutros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jpRececepcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addComponent(jpDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpBarraInfo.setBackground(new java.awt.Color(245, 245, 245));
        jpBarraInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpBarraInfo.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N

        txt_finalizada.setBackground(new java.awt.Color(255, 255, 255));
        txt_finalizada.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_finalizada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbFinalizada.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbFinalizada.setText("Finalizada:");

        txt_ativada.setBackground(new java.awt.Color(255, 255, 255));
        txt_ativada.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_ativada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbAtivada.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbAtivada.setText("Ativada:");

        lbClassificacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbClassificacao.setText("Classificação:");

        lbNome.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbNome.setText("Nome:");

        lbCodigo.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCodigo.setText("Cod:");

        txt_usuario.setBackground(new java.awt.Color(255, 255, 255));
        txt_usuario.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_departamento.setBackground(new java.awt.Color(255, 255, 255));
        txt_departamento.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_departamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_departamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lb_apelido.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lb_apelido.setText("Apelido:");

        btnModificarData.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        btnModificarData.setText("Modificar");
        btnModificarData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificarData.setContentAreaFilled(false);

        txtData.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txtHora.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txt_classificacao.setBackground(new java.awt.Color(255, 255, 255));
        txt_classificacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_classificacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_nome.setBackground(new java.awt.Color(255, 255, 255));
        txt_nome.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_nome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_id.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_codigo.setBackground(new java.awt.Color(255, 255, 255));
        txt_codigo.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txt_codigo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpBarraInfoLayout = new javax.swing.GroupLayout(jpBarraInfo);
        jpBarraInfo.setLayout(jpBarraInfoLayout);
        jpBarraInfoLayout.setHorizontalGroup(
            jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBarraInfoLayout.createSequentialGroup()
                .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBarraInfoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbClassificacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lbAtivada)
                        .addGap(13, 13, 13)
                        .addComponent(txt_ativada, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbFinalizada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_finalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarData, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBarraInfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );
        jpBarraInfoLayout.setVerticalGroup(
            jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarraInfoLayout.createSequentialGroup()
                .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBarraInfoLayout.createSequentialGroup()
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpBarraInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ativada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbAtivada, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbClassificacao, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                    .addComponent(txt_finalizada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbFinalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModificarData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_apelido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpBarraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jpBarraInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_ativada, txt_departamento, txt_finalizada, txt_usuario});

        barraGuias.setBackground(new java.awt.Color(245, 245, 245));

        jmCadastro.setText("Cadastro");
        jmCadastro.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jMenu5.setText("Clientes");
        jMenu5.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem1.setText("Gerenciar");
        jMenu5.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem2.setText("Perfis");
        jMenu5.add(jMenuItem2);

        jmCadastro.add(jMenu5);
        jmCadastro.add(jSeparator1);

        jMenu6.setText("Usuários");
        jMenu6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N

        jmCadUsuario.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jmCadUsuario.setText("Gerenciar");
        jMenu6.add(jmCadUsuario);

        jmDepartamento.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jmDepartamento.setText("Departamento");
        jMenu6.add(jmDepartamento);

        jmControledeAcesso.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jmControledeAcesso.setText("Controle de Acesso");
        jMenu6.add(jmControledeAcesso);

        jmCadastro.add(jMenu6);

        jmAlteraSenha.setText("Alterar Senha");
        jmAlteraSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlteraSenhaActionPerformed(evt);
            }
        });
        jmCadastro.add(jmAlteraSenha);

        jmTrocadeUsuario.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jmTrocadeUsuario.setText("Trocar de Usuário");
        jmTrocadeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTrocadeUsuarioActionPerformed(evt);
            }
        });
        jmCadastro.add(jmTrocadeUsuario);

        barraGuias.add(jmCadastro);

        jmRecepcao.setText("Recepção");
        jmRecepcao.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem6.setText("Cadastrar Entrada");
        jmRecepcao.add(jMenuItem6);
        jmRecepcao.add(jSeparator2);

        jMenuItem7.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem7.setText("Confirmar Recebimento");
        jmRecepcao.add(jMenuItem7);
        jmRecepcao.add(jSeparator3);

        jMenuItem8.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem8.setText("Relação de Recebimentos");
        jmRecepcao.add(jMenuItem8);

        barraGuias.add(jmRecepcao);

        jmControle.setText("Controle");
        jmControle.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        menu_arquivos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_arquivos.setText("Arquivos");
        jmControle.add(menu_arquivos);
        jmControle.add(jSeparator4);

        menu_comercial.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_comercial.setText("Comercial");
        jmControle.add(menu_comercial);
        jmControle.add(jSeparator5);

        menu_contabil.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_contabil.setText("Contabil");
        jmControle.add(menu_contabil);
        jmControle.add(jSeparator6);

        menu_contratos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_contratos.setText("Contratos");
        jmControle.add(menu_contratos);
        jmControle.add(jSeparator7);

        menu_deppessoal.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_deppessoal.setText("Dep.Pessoal");
        jmControle.add(menu_deppessoal);
        jmControle.add(jSeparator8);

        menu_documentos.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_documentos.setText("Documentos");
        jmControle.add(menu_documentos);
        jmControle.add(jSeparator9);

        menu_financeiro.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_financeiro.setText("Financeiro");
        jmControle.add(menu_financeiro);
        jmControle.add(jSeparator10);

        menu_fiscal.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_fiscal.setText("Fiscal");
        jmControle.add(menu_fiscal);
        jmControle.add(jSeparator11);

        menu_regulazicacao.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        menu_regulazicacao.setText("Regularização");
        jmControle.add(menu_regulazicacao);

        barraGuias.add(jmControle);

        jmRelatorios.setText("Relatórios");
        jmRelatorios.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jmRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmRelatoriosMouseClicked(evt);
            }
        });

        jMenu8.setText("Processos");

        jMenuItem18.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem18.setText("Individual");
        jMenu8.add(jMenuItem18);
        jMenu8.add(jSeparator12);

        jMenuItem19.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem19.setText("Geral");
        jMenu8.add(jMenuItem19);

        jmRelatorios.add(jMenu8);

        jMenuItem21.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenuItem21.setText("Gráficos");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem21);

        barraGuias.add(jmRelatorios);

        jmAtivar.setText("Ativar Empresa");
        jmAtivar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jmAtivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmAtivarMouseClicked(evt);
            }
        });
        barraGuias.add(jmAtivar);

        jmSobre.setText("Sobre");
        jmSobre.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jmSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSobreMouseClicked(evt);
            }
        });
        barraGuias.add(jmSobre);

        jmSair.setText("Sair");
        jmSair.setFocusable(false);
        jmSair.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        barraGuias.add(jmSair);

        setJMenuBar(barraGuias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBarraInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBarraInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1336, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSobreMouseClicked
            sobre = new Sobre();
            sobre.setVisible(true);
        
    }//GEN-LAST:event_jmSobreMouseClicked

    private void jmRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmRelatoriosMouseClicked
        JOptionPane.showMessageDialog(null, "Modulo em desenvolvimento");
    }//GEN-LAST:event_jmRelatoriosMouseClicked

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        JOptionPane.showMessageDialog(null, "Modulo em Desenvolvimento!");
        dispose();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jmTrocadeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTrocadeUsuarioActionPerformed
        trocarAcesso = new LoginTrocadeAcesso();
        trocarAcesso.setVisible(true);
        dispose();
    }//GEN-LAST:event_jmTrocadeUsuarioActionPerformed

    private void btnRegularizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegularizacaoActionPerformed
//*Se o campo estiver em branco, solicitara que o usuario ative uma empresa
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro ative uma empresa!");
            Ativador ativador = new Ativador();
            ativador.setVisible(true);
        }
        else{
            regularizacao = new Regularizacao();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            regularizacao.txt_codigo.setText(Ativador.processo);
            regularizacao.txt_nome.setText(Ativador.nome);
            regularizacao.txt_id.setText(Ativador.id);
            regularizacao.txt_usuario.setText(Login.usuario);
            
            regularizacao.setVisible(true);
            //JOptionPane.showMessageDialog(null, "A tela solicitada já se encontra aberta!");
            
        }
    }//GEN-LAST:event_btnRegularizacaoActionPerformed

    private void timer1OnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timer1OnTime
        mostrar_data.lerHora();
        txtHora.setText(""+mostrar_data.hora);
        
    }//GEN-LAST:event_timer1OnTime

    private void btnRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatoriosActionPerformed
        JOptionPane.showMessageDialog(null, "Modulo em desenvolvimento");
    }//GEN-LAST:event_btnRelatoriosActionPerformed

    private void btnNovoProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProcessoActionPerformed
        cadClientes = new CadastroClientes();
        cadClientes.setVisible(true);
        
    }//GEN-LAST:event_btnNovoProcessoActionPerformed

    private void btnClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassificacaoActionPerformed
        classificacao = new CadastroClassificacao();
        classificacao.setVisible(true);
        
    }//GEN-LAST:event_btnClassificacaoActionPerformed

    private void btnFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiscalActionPerformed
        fiscal = new Fiscal();
        fiscal.txt_codigo.setText(Ativador.processo);
        fiscal.txt_nome.setText(Ativador.nome);
        fiscal.txt_id.setText(Ativador.id);
        fiscal.txt_usuario.setText(Login.usuario);
        fiscal.setVisible(true);
    }//GEN-LAST:event_btnFiscalActionPerformed

    private void btnNovoDocumentoRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDocumentoRecActionPerformed
        conferirdoc = new ConferirDocumento();
        conferirdoc.setVisible(true);
        
    }//GEN-LAST:event_btnNovoDocumentoRecActionPerformed

    private void btnComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComercialActionPerformed

    }//GEN-LAST:event_btnComercialActionPerformed

    private void btnContabilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContabilActionPerformed
        //*Se o campo estiver em branco, solicitara que o usuario ative uma empresa
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Primeiro ative uma empresa!");
            Ativador ma = new Ativador();
            ma.setVisible(true);
        }
        else{   
            contabil = new Contabil();
            //Chamando a tela, enviando os dados do cliente para a tela solicitada
            contabil.txt_codigo.setText(Ativador.processo);
            contabil.txt_nome.setText(Ativador.nome);
            contabil.txt_id.setText(Ativador.id);
            contabil.txt_usuario.setText(Login.usuario);
            
            contabil.setVisible(true);
        }
    }//GEN-LAST:event_btnContabilActionPerformed

    private void btnMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMensagemActionPerformed
        JOptionPane.showMessageDialog(null,"Esse modulo será descontinuado!");
    }//GEN-LAST:event_btnMensagemActionPerformed

    private void btnContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContratosActionPerformed

    }//GEN-LAST:event_btnContratosActionPerformed

    private void btnPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPessoalActionPerformed
        
    }//GEN-LAST:event_btnPessoalActionPerformed

    private void btnFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiroActionPerformed
        financeiro = new Financeiro();
        financeiro.txt_codigo.setText(Ativador.processo);
        financeiro.txt_nome.setText(Ativador.nome);
        financeiro.txt_id.setText(Ativador.id);
        financeiro.txt_usuario.setText(Login.usuario);
            
        financeiro.setVisible(true);
    }//GEN-LAST:event_btnFinanceiroActionPerformed

    private void btnAdministracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministracaoActionPerformed
            cadUsuario = new CadastroUsuarios();
            cadUsuario.setVisible(true);

    }//GEN-LAST:event_btnAdministracaoActionPerformed

    private void btnConfirmarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarDocumentoActionPerformed
           listaDocumentos = new ListagemDocumentos();
            listaDocumentos.setVisible(true);
        
    }//GEN-LAST:event_btnConfirmarDocumentoActionPerformed

    private void jmAtivarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmAtivarMouseClicked
            Ativador ativador = new Ativador();
            ativador.setVisible(true);
    }//GEN-LAST:event_jmAtivarMouseClicked

    private void jmAlteraSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlteraSenhaActionPerformed
            ts = new TrocadeSenha();
            ts.setVisible(true);
  
    }//GEN-LAST:event_jmAlteraSenhaActionPerformed

    private void btnArqEnviadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArqEnviadosActionPerformed
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ative uma empresa!");
            Ativador ativador = new Ativador();
            ativador.setVisible(true);
        }
        else{
            docEnv = new DocumentosEnviados();
            
            docEnv.txtCodigo.setText(Ativador.processo);
            docEnv.txtNome.setText(Ativador.nome);
            docEnv.txtID.setText(Ativador.id);
            docEnv.txtUsuario.setText(Login.usuario);
            
            docEnv.setVisible(true);
            
        }
    }//GEN-LAST:event_btnArqEnviadosActionPerformed
    
    /**
     *
     * @param args
     */
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                  TelaPrincipal telaPrincipal = new TelaPrincipal();
                  telaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraGuias;
    private javax.swing.JButton btnAdministracao;
    private javax.swing.JButton btnArqEnviados;
    private javax.swing.JButton btnClassificacao;
    private javax.swing.JButton btnComercial;
    private javax.swing.JButton btnConfirmarDocumento;
    private javax.swing.JButton btnContabil;
    private javax.swing.JButton btnContratos;
    private javax.swing.JButton btnDocumentos;
    private javax.swing.JButton btnFinanceiro;
    private javax.swing.JButton btnFiscal;
    private javax.swing.JButton btnMensagem;
    private javax.swing.JButton btnModificarData;
    private javax.swing.JButton btnNovoDocumentoRec;
    private javax.swing.JButton btnNovoProcesso;
    private javax.swing.JButton btnPessoal;
    private javax.swing.JButton btnRegularizacao;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem jmAlteraSenha;
    private javax.swing.JMenu jmAtivar;
    private javax.swing.JMenuItem jmCadUsuario;
    private javax.swing.JMenu jmCadastro;
    private javax.swing.JMenu jmControle;
    private javax.swing.JMenuItem jmControledeAcesso;
    private javax.swing.JMenuItem jmDepartamento;
    private javax.swing.JMenu jmRecepcao;
    private javax.swing.JMenu jmRelatorios;
    private javax.swing.JMenu jmSair;
    private javax.swing.JMenu jmSobre;
    private javax.swing.JMenuItem jmTrocadeUsuario;
    private javax.swing.JPanel jpBarraInfo;
    private javax.swing.JPanel jpDepartamentos;
    private javax.swing.JPanel jpOutros;
    public static javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpProcessos;
    private javax.swing.JPanel jpRececepcao;
    private javax.swing.JLabel lbAtivada;
    private javax.swing.JLabel lbClassificacao;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbFinalizada;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lb_apelido;
    private javax.swing.JMenuItem menu_arquivos;
    private javax.swing.JMenuItem menu_comercial;
    private javax.swing.JMenuItem menu_contabil;
    private javax.swing.JMenuItem menu_contratos;
    private javax.swing.JMenuItem menu_deppessoal;
    private javax.swing.JMenuItem menu_documentos;
    private javax.swing.JMenuItem menu_financeiro;
    private javax.swing.JMenuItem menu_fiscal;
    private javax.swing.JMenuItem menu_regulazicacao;
    private org.netbeans.examples.lib.timerbean.Timer timer1;
    public static javax.swing.JLabel txtData;
    public static javax.swing.JLabel txtHora;
    public static javax.swing.JLabel txt_ativada;
    public static javax.swing.JLabel txt_classificacao;
    public static javax.swing.JLabel txt_codigo;
    public static javax.swing.JLabel txt_departamento;
    public static javax.swing.JLabel txt_finalizada;
    public static javax.swing.JLabel txt_id;
    public static javax.swing.JLabel txt_nome;
    public static javax.swing.JLabel txt_usuario;
    // End of variables declaration//GEN-END:variables
    Regularizacao regularizacao;
    Fiscal fiscal;
    Contabil contabil;
    Financeiro financeiro;
    //Contratos contratos;
    CadastroUsuarios cadUsuario;
    CadastroClientes cadClientes;
    CadastroClassificacao classificacao;
    TrocadeSenha ts;
    CadastroDepartamento cd;
    ConferirDocumento conferirdoc;
    ListagemDocumentos listaDocumentos;
    DocumentosEnviados docEnv;
    Sobre sobre;
    LoginTrocadeAcesso trocarAcesso;
}