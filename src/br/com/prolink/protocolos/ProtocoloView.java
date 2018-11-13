package br.com.prolink.protocolos;

import br.com.prolink.model.SuperGeradorRandomico;
import br.com.prolink.model.ProtocoloItem;
import br.com.prolink.model.FTPDownload;
import br.com.prolink.model.FTPUpload;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.UsuarioLogado;
import br.com.prolink.view.Login;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */

/**
 *
 * @author Tiago
 */
public class ProtocoloView extends javax.swing.JDialog {
    
    int linhaItens=-1;
    Map<String, String> empresas = new HashMap<>();
    Map<String, Integer> atendentes = new HashMap<>();
    List<ProtocoloItem> items = new ArrayList<>();
    List<ProtocoloItem> aRemover = new ArrayList<>();
    Connection con;
    //int aPos = 1; 
    
    private Connection getConnection(){
        this.con =  new ConexaoStatement().getConnetion();
        return con;
    }
    /**
     * Creates new form Protocolo
     */
    public ProtocoloView(int protocolo_entrada) {
    //    super(frame,modal);
        initComponents();
        preencherClientes();
        preencherProtocolo();
        preencherAtendentes();
        
        cbProtocoloPesquisa.addItemListener(new EstabelecerFiltro());
        cbAtendentePesquisa.addItemListener(new EstabelecerFiltro());
        
        cbAtendentePesquisa.setSelectedItem(UsuarioLogado.getInstance().getUsuario().getUsuario());
        //cbAtendentePesquisa.setSelectedItem("Tiago");
        //String sql = "select * from documentos_recebidos where passivel_devolucao=1 and recebido='S' and devolvido=0 and para_quem_id="+atendentes.get((String)cbAtendentePesquisa.getSelectedItem());
        String sql = "select * from protocolo_saida where prot_usuario_id="+UsuarioLogado.getInstance().getUsuario().getCod()+"";
        preencherTabela(sql);
        desbloquearFormulario(pnCadastro, false);
        salvarCancelar();
        cbApelido.addItemListener(new MudarCliente());
        if(protocolo_entrada!=-1){ 
            tbPanelPrincipal.setSelectedIndex(1);
            preencherFormularioEntrada(protocolo_entrada);
            novoEditar();
            desbloquearFormulario(pnCadastro, true);
            txCodProtocolo.setText(protocolo_entrada+"");
            
        }
        else
            tbPanelPrincipal.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        tbPanelPrincipal = new javax.swing.JTabbedPane();
        panPesquisa = new javax.swing.JPanel();
        btnNovoProtocolo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProtocoloPesquisa = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbAtendentePesquisa = new javax.swing.JComboBox<>();
        cbProtocoloPesquisa = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        panCadastro = new javax.swing.JPanel();
        pnCadastro = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbItem = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txDetalhes = new javax.swing.JTextArea();
        btApagarItem = new javax.swing.JButton();
        btIncluirItem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbItens = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txObservacao = new javax.swing.JTextArea();
        spQuantidade = new javax.swing.JSpinner();
        txIdItem = new javax.swing.JLabel();
        cbSetor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txEmpresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbApelido = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txCodigo = new javax.swing.JLabel();
        txFuncionario = new javax.swing.JTextField();
        txCodProtocolo = new javax.swing.JLabel();
        txIdItem1 = new javax.swing.JLabel();
        txIdItem2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        btnAdicionar1Via = new javax.swing.JButton();
        txComprovante = new javax.swing.JTextField();
        btnVisualizar1Via = new javax.swing.JButton();
        btnVerProtocolo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(250, 250, 250));

        tbPanelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPanelPrincipalMouseClicked(evt);
            }
        });

        panPesquisa.setBackground(new java.awt.Color(250, 250, 250));

        btnNovoProtocolo.setText("Novo Protocolo");
        btnNovoProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProtocoloActionPerformed(evt);
            }
        });

        tbProtocoloPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Cliente Apelido", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProtocoloPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProtocoloPesquisaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbProtocoloPesquisa);
        if (tbProtocoloPesquisa.getColumnModel().getColumnCount() > 0) {
            tbProtocoloPesquisa.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbProtocoloPesquisa.getColumnModel().getColumn(0).setMaxWidth(70);
            tbProtocoloPesquisa.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbProtocoloPesquisa.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbProtocoloPesquisa.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jLabel7.setText("Filtro:");

        jLabel12.setText("Protocolo de Saída:");

        jLabel14.setText("Atendente:");

        cbProtocoloPesquisa.setEditable(true);

        jLabel16.setText("Protocolo de Saída:");

        jTextPane1.setEditable(false);
        jTextPane1.setText("Nessa area você visualiza todos os protocolos gerados (Saída), mesmo o destinatário sendo cliente ou não.");
        jTextPane1.setName(""); // NOI18N
        jTextPane1.setOpaque(false);
        jScrollPane5.setViewportView(jTextPane1);

        javax.swing.GroupLayout panPesquisaLayout = new javax.swing.GroupLayout(panPesquisa);
        panPesquisa.setLayout(panPesquisaLayout);
        panPesquisaLayout.setHorizontalGroup(
            panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPesquisaLayout.createSequentialGroup()
                        .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panPesquisaLayout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnNovoProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 182, Short.MAX_VALUE))
                    .addGroup(panPesquisaLayout.createSequentialGroup()
                        .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPesquisaLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(11, 11, 11)
                                .addComponent(cbProtocoloPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAtendentePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panPesquisaLayout.setVerticalGroup(
            panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPesquisaLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProtocoloPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(cbAtendentePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovoProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        tbPanelPrincipal.addTab("Pesquisa", panPesquisa);

        panCadastro.setBackground(new java.awt.Color(250, 250, 250));

        pnCadastro.setBackground(new java.awt.Color(250, 250, 250));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Detalhes do Protocolo");

        jLabel8.setText("Tipo:");

        jLabel9.setText("Qtde:");

        cbItem.setEditable(true);
        cbItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aviso de Férias", "Carimbo", "Carta de Recomendação", "Carteira de Trabalho", "Certificado Digital A3", "Comprovantes de Pagamentos Diversos", "Diário Geral", "Documentos Admissionais", "Documentos de Abertura", "Documentos de Alteração", "Documentos de Encerramento", "Documentos Demissionais", "Documentos para Alteração Contratual", "Documentos para Homologação", "Documentos para Implantação", "Documentos para Imposto de Renda", "Documentos para Processos - Prefeitura", "Documentos para Processos - Receita", "Extrato", "FGTS, DAS, DARF, GPS", "Ficha de Plano de Saude", "Guia Previdência Social", "Livro de Registro", "Midia (CD, Pen Drive)", "Movimentação Financeira", "Movimento Contabil", "Movimento Fiscal (Notas Fiscais de Entrada, Saida)", "Notas Fiscais(Entrada,Saida)", "Outros", "Procuração" }));

        txDetalhes.setColumns(20);
        txDetalhes.setLineWrap(true);
        txDetalhes.setRows(5);
        jScrollPane3.setViewportView(txDetalhes);

        btApagarItem.setText("Remover");
        btApagarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarItemActionPerformed(evt);
            }
        });

        btIncluirItem.setText("Incluir");
        btIncluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirItemActionPerformed(evt);
            }
        });

        jLabel10.setText("Detalhes");

        tbItens.setBackground(new java.awt.Color(250, 250, 250));
        tbItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Item", "Qtde", "Detalhes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbItensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbItens);
        if (tbItens.getColumnModel().getColumnCount() > 0) {
            tbItens.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbItens.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        jLabel6.setText("Incluir Observacão:");

        txObservacao.setColumns(20);
        txObservacao.setLineWrap(true);
        txObservacao.setRows(5);
        jScrollPane1.setViewportView(txObservacao);

        spQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10000, 1));

        txIdItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txIdItem.setToolTipText("");

        cbSetor.setEditable(true);
        cbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoal", "Fiscal", "Financeiro" }));

        jLabel4.setText("Setor:");

        jLabel3.setText("Funcionário:");

        txEmpresa.setEnabled(false);

        jLabel2.setText("Empresa:");

        cbApelido.setEditable(true);

        jLabel5.setText("Apelido/Empresa:");

        txCodigo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txCodProtocolo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        txIdItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txIdItem1.setText("Nº");
        txIdItem1.setToolTipText("");

        txIdItem2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txIdItem2.setText("Entrada Nº");
        txIdItem2.setToolTipText("");

        jEditorPane1.setEditable(false);
        jEditorPane1.setText("Permite que gere um protocolo em branco com destinatário sendo cliente ou não, também é possivel gerar um novo protocolo a partir de um Protocolo de Entrada na opção Confirmar Recebimento na Tela Inicial!");
        jEditorPane1.setOpaque(false);
        jScrollPane6.setViewportView(jEditorPane1);

        javax.swing.GroupLayout pnCadastroLayout = new javax.swing.GroupLayout(pnCadastro);
        pnCadastro.setLayout(pnCadastroLayout);
        pnCadastroLayout.setHorizontalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                                .addComponent(txIdItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txIdItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txCodProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnCadastroLayout.createSequentialGroup()
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnCadastroLayout.createSequentialGroup()
                                                .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(91, 91, 91)
                                        .addComponent(txIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btApagarItem)
                                            .addComponent(btIncluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnCadastroLayout.createSequentialGroup()
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txFuncionario))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(81, 81, 81)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );

        pnCadastroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btApagarItem, btIncluirItem});

        pnCadastroLayout.setVerticalGroup(
            pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txCodProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txIdItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txIdItem2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(txEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnCadastroLayout.createSequentialGroup()
                                    .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnCadastroLayout.createSequentialGroup()
                        .addComponent(btIncluirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btApagarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );

        btnAdicionar1Via.setText("Anexar 1ª Via");
        btnAdicionar1Via.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionar1ViaActionPerformed(evt);
            }
        });

        txComprovante.setEditable(false);

        btnVisualizar1Via.setText("Visualizar");
        btnVisualizar1Via.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizar1ViaActionPerformed(evt);
            }
        });

        btnVerProtocolo.setText("Abrir Protocolo");
        btnVerProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProtocoloActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jTextPane2.setEditable(false);
        jTextPane2.setText("Armazene um comprovate digitalizado através da opção Anexar 1ª via");
        jScrollPane7.setViewportView(jTextPane2);

        javax.swing.GroupLayout panCadastroLayout = new javax.swing.GroupLayout(panCadastro);
        panCadastro.setLayout(panCadastroLayout);
        panCadastroLayout.setHorizontalGroup(
            panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastroLayout.createSequentialGroup()
                .addGroup(panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCadastroLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerProtocolo))
                    .addGroup(panCadastroLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCadastroLayout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionar1Via)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVisualizar1Via))
                            .addComponent(pnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        panCadastroLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnCancelar, btnExcluir, btnNovo, btnSalvar});

        panCadastroLayout.setVerticalGroup(
            panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionar1Via)
                        .addComponent(txComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVisualizar1Via))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnVerProtocolo)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        tbPanelPrincipal.addTab("Cadastro", panCadastro);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanelPrincipal)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanelPrincipal)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbPanelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPanelPrincipalMouseClicked

    }//GEN-LAST:event_tbPanelPrincipalMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        salvarCancelar();
        desbloquearFormulario(pnCadastro, false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoEditar();
        limparFormulario(pnCadastro);
        desbloquearFormulario(pnCadastro, true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        novoEditar();
        desbloquearFormulario(pnCadastro, true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        salvarCancelar();
        desbloquearFormulario(pnCadastro, false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVerProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProtocoloActionPerformed
        abrirProtocolo();
    }//GEN-LAST:event_btnVerProtocoloActionPerformed

    private void btnVisualizar1ViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizar1ViaActionPerformed
        if(txComprovante.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhum documento foi anexado!");
        }
        else{
            FTPDownload download = new FTPDownload();
            if(download.downloadFile(txComprovante.getText())){
                try {
                    Desktop.getDesktop().open(download.returnFile());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnVisualizar1ViaActionPerformed

    private void btnAdicionar1ViaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionar1ViaActionPerformed
        if("".equals(txCodigo.getText())){
            JOptionPane.showMessageDialog(null, "Antes, salve um documentos para depois anexar!");
        }
        else{
            if(txComprovante.getText().equals(""))
            gerarSerial();
            else{
                int escolha = JOptionPane.showConfirmDialog(null, "Ja existe um comprovante anexado, deseja substituir?", "Substituir comprovante...", JOptionPane.YES_NO_OPTION);
                if(escolha==JOptionPane.YES_OPTION)
                gerarSerial();
            }

        }
    }//GEN-LAST:event_btnAdicionar1ViaActionPerformed

    private void tbItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbItensMouseClicked
        if(tbItens.getSelectedRow()>=0){
            linhaItens = tbItens.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tbItens.getModel();
            txIdItem.setText(String.valueOf(model.getValueAt(linhaItens, 0)));
            boolean contem = true;
            for(int i = 0; i<cbItem.getItemCount(); i++){
                if(cbItem.getItemAt(i).equals((String)model.getValueAt(linhaItens, 1))){
                    contem = true;
                    break;
                }
                else
                contem = false;
            }
            if(!contem) cbItem.addItem((String)model.getValueAt(linhaItens, 1));
            cbItem.setSelectedItem((String)model.getValueAt(linhaItens, 1));
            spQuantidade.setValue(Integer.parseInt(String.valueOf(model.getValueAt(linhaItens, 2))));
            txDetalhes.setText((String)model.getValueAt(linhaItens, 3));
        }
    }//GEN-LAST:event_tbItensMouseClicked

    private void btIncluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirItemActionPerformed
        if(txDetalhes.getText().length()<=50 && !"".equals((String)cbItem.getSelectedItem())){
            try{
                JComponent component = spQuantidade.getEditor();
                JFormattedTextField textQuantidade = ((JSpinner.NumberEditor)component).getTextField();
                int valor = Integer.parseInt(textQuantidade.getText());

                DefaultTableModel model = (DefaultTableModel) tbItens.getModel();
                Object[] object = new Object[4];
                object[0]=txIdItem.getText();
                object[1]=(String)cbItem.getSelectedItem();
                object[2]=valor;
                object[3]=txDetalhes.getText();

                if(linhaItens>=0){
                    model.setValueAt(object[0], linhaItens, 0);
                    model.setValueAt(object[1], linhaItens, 1);
                    model.setValueAt(object[2], linhaItens, 2);
                    model.setValueAt(object[3], linhaItens, 3);
                }
                else
                model.addRow(object);
                linhaItens=-1;
                txIdItem.setText("");
                cbItem.setSelectedIndex(0);
                spQuantidade.setValue(1);
                txDetalhes.setText("");
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "O valor em quantidade deve ser um número valido!","Valor invalido", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        JOptionPane.showMessageDialog(null, "O campo Tipo deve ser preenchido!\nCampo resumo deve conter até 50 caracteres");
    }//GEN-LAST:event_btIncluirItemActionPerformed

    private void btApagarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarItemActionPerformed
        if(linhaItens>=0){
            DefaultTableModel model = (DefaultTableModel) tbItens.getModel();

            String valor = String.valueOf(model.getValueAt(linhaItens,0));
            if(!"".equals(valor)){
                JOptionPane.showMessageDialog(null,
                    "Quando você exclui um item ele apenas será ocultado nesse protocolo\n "
                    + "ele continuará pendente de entrega até ser gerado um novo protocolo\n"
                    + "ou alterado seu prazo é possivel desabilitar a devolução","Pedido de exclusão",JOptionPane.YES_NO_OPTION);
            }
            model.removeRow(linhaItens);
            linhaItens=-1;
            txIdItem.setText("");
            cbItem.setSelectedItem("");
            spQuantidade.setValue(1);
            txDetalhes.setText("");
        }
    }//GEN-LAST:event_btApagarItemActionPerformed

    private void tbProtocoloPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProtocoloPesquisaMouseClicked
        if(tbProtocoloPesquisa.getSelectedRow()>=0){
            preencherFormulario(Integer.parseInt(String.valueOf(tbProtocoloPesquisa.getValueAt(tbProtocoloPesquisa.getSelectedRow(), 0))));
            tbPanelPrincipal.setSelectedIndex(1);
            salvarCancelar();
        }
    }//GEN-LAST:event_tbProtocoloPesquisaMouseClicked

    private void btnNovoProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProtocoloActionPerformed
        tbPanelPrincipal.setSelectedIndex(1);
        limparFormulario(pnCadastro);
        txCodProtocolo.setText("");
    }//GEN-LAST:event_btnNovoProtocoloActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApagarItem;
    private javax.swing.JButton btIncluirItem;
    private javax.swing.JButton btnAdicionar1Via;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnNovoProtocolo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVerProtocolo;
    private javax.swing.JButton btnVisualizar1Via;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbApelido;
    private javax.swing.JComboBox<String> cbAtendentePesquisa;
    private javax.swing.JComboBox<String> cbItem;
    private javax.swing.JComboBox<String> cbProtocoloPesquisa;
    private javax.swing.JComboBox<String> cbSetor;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JPanel panCadastro;
    private javax.swing.JPanel panPesquisa;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel pnCadastro;
    private javax.swing.JSpinner spQuantidade;
    private javax.swing.JTable tbItens;
    private javax.swing.JTabbedPane tbPanelPrincipal;
    private javax.swing.JTable tbProtocoloPesquisa;
    public static javax.swing.JLabel txCodProtocolo;
    public static javax.swing.JLabel txCodigo;
    private javax.swing.JTextField txComprovante;
    private javax.swing.JTextArea txDetalhes;
    private javax.swing.JTextField txEmpresa;
    private javax.swing.JTextField txFuncionario;
    private javax.swing.JLabel txIdItem;
    private javax.swing.JLabel txIdItem1;
    private javax.swing.JLabel txIdItem2;
    private javax.swing.JTextArea txObservacao;
    // End of variables declaration//GEN-END:variables
    
    private void preencherTabela(String sql){
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel)tbProtocoloPesquisa.getModel();
            while(model.getRowCount()>0)
                model.removeRow(0);
            while(rs.next()){
                Object[] o = new Object[7];
                o[0]=rs.getInt(1);
                o[1]=rs.getString(2);
                o[2]=new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate(8));
                model.addRow(o);
            }            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preecher a tabela protocolo\n"+e);
        } finally{
            try{con.close();}catch(SQLException e){e.printStackTrace();};
        }
    }
    private void preencherAtendentes(){
    try {
            String sql = "select * from login where Ativo=1 order by Usuario";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbAtendentePesquisa.removeAllItems();
            cbAtendentePesquisa.addItem("");
            atendentes.clear();
            while(rs.next()){
                cbAtendentePesquisa.addItem(rs.getString(2));
                atendentes.put(rs.getString(2), rs.getInt(1));
            }
            cbAtendentePesquisa.setSelectedItem("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preecher combo protocolo");
        } finally{
            try{con.close();}catch(SQLException e){e.printStackTrace();};
        }
    }
    private void preencherProtocolo(){
        try {
            String sql = "select prot_id from protocolo_saida";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbProtocoloPesquisa.removeAllItems();
            cbProtocoloPesquisa.addItem("");
            while(rs.next()){
                int number = rs.getInt(1);
                cbProtocoloPesquisa.addItem(String.valueOf(number));
            }
            cbProtocoloPesquisa.setSelectedItem("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preecher combo protocolo");
        } finally{
            try{con.close();}catch(SQLException e){e.printStackTrace();};
        }
    }
    private void preencherClientes() {
        try {
            String sql = "select * from cliente order by id";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbApelido.removeAllItems();
            empresas.clear();
            while(rs.next()){
                empresas.put(rs.getString(1), rs.getString(2));
            }
            cbApelido.addItem("");
            
            List<String> lista = new ArrayList<>();
            
            empresas.keySet().stream().forEach((s) -> {
                lista.add(s);
            });
            Collections.sort(lista);
            cbApelido.setSelectedItem("");
            lista.forEach(c-> {
                cbApelido.addItem(c);
            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preecher empresas");
        } finally{
            try{con.close();}catch(SQLException e){e.printStackTrace();}
        }
    }
    private void desbloquearFormulario(JPanel jPanel3, boolean desbloquear) {
        for(int i=0; i<jPanel3.getComponentCount(); i++){
            if(jPanel3.getComponent(i) instanceof JTextField)
                ((JTextField)jPanel3.getComponent(i)).setEditable(desbloquear);
            else if(jPanel3.getComponent(i) instanceof JFormattedTextField)
                ((JFormattedTextField)jPanel3.getComponent(i)).setEditable(desbloquear);
            else if(jPanel3.getComponent(i) instanceof JTextArea)
                ((JTextArea)jPanel3.getComponent(i)).setEditable(desbloquear);
            else if(jPanel3.getComponent(i) instanceof JComboBox)
                ((JComboBox)jPanel3.getComponent(i)).setEnabled(desbloquear);
            else if(jPanel3.getComponent(i) instanceof JScrollPane){
                JViewport viewport = ((JScrollPane)jPanel3.getComponent(i)).getViewport();
                Component[] comp = viewport.getComponents();
                for(Component c : comp){
                    if(c instanceof JTextArea){
                        ((JTextArea)c).setEditable(desbloquear);
                    }
                    else if(c instanceof JTable){
                        ((JTable)c).setEnabled(desbloquear);
                    }
                }
            }
        }
        btIncluirItem.setEnabled(desbloquear);
        btApagarItem.setEnabled(desbloquear);
    }
    public static void limparFormulario(JPanel jPanel3){
        txCodigo.setText("");
        txCodProtocolo.setText("");
        for(int i=0; i<jPanel3.getComponentCount();i++){
            if(jPanel3.getComponent(i) instanceof JTextField)
                ((JTextField)jPanel3.getComponent(i)).setText("");
            else if(jPanel3.getComponent(i) instanceof JFormattedTextField)
                ((JFormattedTextField)jPanel3.getComponent(i)).setText("");
            else if(jPanel3.getComponent(i) instanceof JComboBox)
                ((JComboBox)jPanel3.getComponent(i)).setSelectedItem("");
            else if(jPanel3.getComponent(i) instanceof JScrollPane){
                JViewport viewport = ((JScrollPane)jPanel3.getComponent(i)).getViewport();
                Component[] comp = viewport.getComponents();
                for(Component c : comp){
                    if(c instanceof JTextArea){
                        ((JTextArea)c).setText("");
                    }
                    else if(c instanceof JTable){
                        DefaultTableModel model = (DefaultTableModel)((JTable)c).getModel();
                        if(model.getRowCount()>0)
                            model.removeRow(0);
                    }
                }
            }
        }
        
    }
    private void preencherFormulario(int registro) {
        if(registro>0){
            try{
                if(con.isClosed())
                    getConnection();
                PreparedStatement ps =  con.prepareStatement("select * from protocolo_saida where prot_id=?");
                ps.setInt(1,registro);
                ResultSet rs = ps.executeQuery();
                ProtocoloSaidaBean p = new ProtocoloSaidaBean();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                    p.setEmpresaNome(rs.getString(2));
                    p.setCliente(rs.getInt(3));
                    p.setUsuarioId(rs.getInt(4));
                    p.setFuncionarioPara(rs.getString(5));
                    p.setSetorPara(rs.getString(6));
                    p.setObservacao(rs.getString(7));
                    p.setData(rs.getDate(8));
                    p.setComprovante(rs.getString(9));
                    p.setProtocoloEntradaId(rs.getString(10)==null?-1:rs.getInt(10));
                }
                ps.clearParameters();
                ps = con.prepareStatement("select * from protocolo_item where item_prot_saida_id=?");
                ps.setInt(1, registro);
                rs = ps.executeQuery();
                Set<ProtocoloItem> proIt =  new HashSet<>();
                while(rs.next()){
                    ProtocoloItem itens = new ProtocoloItem();
                    itens.setId(rs.getInt(1));
                    itens.setNome(rs.getString(2));
                    itens.setQuantidade(rs.getInt(3));
                    itens.setDetalhe(rs.getString(4));
                    proIt.add(itens);
                }
                p.setItems(proIt);
                cbItem.setSelectedIndex(1);
                spQuantidade.setValue(1);
                txDetalhes.setText("");
                DefaultTableModel model = (DefaultTableModel)tbItens.getModel();
                while(model.getRowCount()>0)
                    model.removeRow(0);
                
                Iterator<ProtocoloItem> iterator = proIt.iterator();
                while(iterator.hasNext()){
                    ProtocoloItem bean = iterator.next();
                    Object[] o = new Object[4];
                    o[0]=bean.getId();
                    o[1]=bean.getNome();
                    o[2]=bean.getQuantidade();
                    o[3]=bean.getDetalhe();
                    model.addRow(o);
                }
                txCodigo.setText(""+p.getId());
                txCodProtocolo.setText(p.getProtocoloEntradaId()==-1?"":p.getProtocoloEntradaId()+"");
                txObservacao.setText(p.getObservacao());
                txComprovante.setText(p.getComprovante());
                txFuncionario.setText(p.getFuncionarioPara());
                if(p.getCliente()!=1){
                    cbApelido.addItem(p.getEmpresaNome());
                }
                cbApelido.setSelectedItem(p.getEmpresaNome());
                
                for(int i = 0; i<cbSetor.getItemCount(); i++){
                    if(cbSetor.getItemAt(i).equals(p.getSetorPara())){
                        cbSetor.addItem(p.getSetorPara());
                        break;
                    }
                }
                cbSetor.setSelectedItem(p.getSetorPara());
            }catch(SQLException e){
                e.printStackTrace();
            }finally{try{con.close();}catch(SQLException ex){}}
        }
    }
    private void preencherFormularioEntrada(int registro) {
        if(registro>0){
            try{
                PreparedStatement ps =  getConnection().prepareStatement("select * from protocolo_saida where prot_documento_recebido_id=?");
                ps.setInt(1,registro);
                ResultSet rs = ps.executeQuery();
                int result = -1;
                if(rs.next()){
                    System.out.println(rs.getInt(1));
                    result = rs.getInt(1);
                }
                if(result!=-1){
                    preencherFormulario(rs.getInt(1));
                }
                else{
                    ps.clearParameters();
                    ps = con.prepareStatement("select * from protocolo_item where item_prot_entrada_id=?");
                    ps.setInt(1, registro);
                    rs = ps.executeQuery();
                    
                    DefaultTableModel model = (DefaultTableModel)tbItens.getModel();
                    while(model.getRowCount()>0)
                        model.removeRow(0);
                    while(rs.next()){
                        cbApelido.setSelectedItem(rs.getInt(12));
                        Object[] o = new Object[4];
                        o[0]=rs.getInt(1);
                        o[1]=rs.getString(2);
                        o[2]=rs.getString(3);
                        o[3]=rs.getString(4);
                        model.addRow(o);
                    }
                    cbItem.setSelectedIndex(1);
                    spQuantidade.setValue(1);
                    txDetalhes.setText("");
                    txComprovante.setText("");
                    txObservacao.setText("");
                    txCodigo.setText("");
                    txCodProtocolo.setText("");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }finally{try{con.close();}catch(SQLException ex){}}
        }
    }

    private void novoEditar() {
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(true);
        if(!txCodigo.getText().equals("")){
            btnAdicionar1Via.setEnabled(true);
            btnVerProtocolo.setEnabled(true);
        }
        else{
            btnVerProtocolo.setEnabled(false);
            btnAdicionar1Via.setEnabled(false);
        }
        if(!txComprovante.getText().equals(""))
            btnVisualizar1Via.setEnabled(true);
        txEmpresa.setEditable(false);
    }

    private void salvarCancelar() {
        if("".equals(txCodigo.getText())){
            btnAlterar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
        else{
            btnAdicionar1Via.setEnabled(true);
            btnVerProtocolo.setEnabled(true);
            btnAlterar.setEnabled(true);
            btnExcluir.setEnabled(true);
        }
        if(!txComprovante.getText().equals(""))
            btnVisualizar1Via.setEnabled(true);
        else
            btnVisualizar1Via.setEnabled(false);
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);        
    }
    private void excluir() {
        if(!"".equals(txCodigo.getText())){
            String mensagem = "Deseja remover o protocolo escolhido? Os itens não serão apagados!";
            int escolha = JOptionPane.showConfirmDialog(null, mensagem,"Excluir registro",JOptionPane.YES_NO_OPTION);
            if(escolha==JOptionPane.YES_OPTION){
                try{
                    String sql = "select * from protocolo_saida where prot_id=?";
                    PreparedStatement ps = getConnection().prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(txCodigo.getText()));
                    ResultSet rs = ps.executeQuery();
                    if(rs!=null){
                        ps.clearParameters();
                        ps = con.prepareStatement("delete from protocolo_saida where prot_id=?");
                        ps.setInt(1, Integer.parseInt(txCodigo.getText()));
                        if(ps.executeUpdate()>0){
                            JOptionPane.showMessageDialog(null, "Exluido com sucesso");
                            limparFormulario(pnCadastro);
                            salvarCancelar();
                            desbloquearFormulario(pnCadastro, false);
                        }
                    }
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }finally{try{con.close();}catch(SQLException ex){}}
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Nenhum registro foi selecionado!");
        }
    }

    private void salvar() {
        PreparedStatement ps;
        getConnection();
        if("".equals(txCodigo.getText())){
            try{
                long key = 1L;
                String sql = "insert into protocolo_saida "
                        + "(prot_empresa_nome,prot_funcionario_para, prot_setor_para,prot_observacao,prot_usuario_id, prot_data, prot_cliente,prot_documento_recebido_id)"
                        + " value (?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, String.valueOf(cbApelido.getSelectedItem()));
                ps.setString(2, txFuncionario.getText());
                ps.setString(3, (String)cbSetor.getSelectedItem());
                ps.setString(4, txObservacao.getText());
                ps.setInt(5, UsuarioLogado.getInstance().getUsuario().getCod());
                ps.setDate(6, new java.sql.Date(new Date().getTime()));
                ps.setInt(7, retornaClienteValido());
                ps.setString(8, txCodProtocolo.getText().equals("")?null:txCodProtocolo.getText());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if(rs!=null && rs.next()){
                    key = rs.getLong(1);
                    txCodigo.setText(""+key);
                }
                DefaultTableModel model = (DefaultTableModel)tbItens.getModel();
                List<ProtocoloItem> itemsAdd = new ArrayList<>();
                for(int i =0; i<model.getRowCount(); i++){
                    ProtocoloItem pb = new ProtocoloItem();
                    String id = model.getValueAt(i, 0).toString();
                    pb.setId("".equals(id)?-1:Integer.parseInt(id));
                    pb.setNome(model.getValueAt(i, 1).toString());
                    pb.setQuantidade(Integer.parseInt(model.getValueAt(i, 2).toString()));
                    pb.setDetalhe(model.getValueAt(i, 3).toString());
                    pb.setProtocoloSaida((int)key);
                    itemsAdd.add(pb);
                }
                for(int j=0;j<itemsAdd.size();j++){
                    ps.clearParameters();
                    ProtocoloItem pi = itemsAdd.get(j);
                    if(itemsAdd.get(j).getId()!=-1){
                        sql = "update protocolo_item set item_nome=?,"
                                + "item_quantidade=?,"
                                + "item_detalhe=?,"
                                + "item_prot_saida_id=?,"
                                + "item_data_saida=?,"
                                + "item_entregue=? where"
                                + " item_id=?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, pi.getNome());
                        ps.setInt(2, pi.getQuantidade());
                        ps.setString(3, pi.getDetalhe());
                        ps.setInt(4, pi.getProtocoloSaida());
                        ps.setDate(5, new java.sql.Date(new Date().getTime()));
                        ps.setInt(6, pi.getEntregue());
                        ps.setInt(7, pi.getId());
                    }
                    else{
                        sql = "insert into protocolo_item (item_nome,item_quantidade,item_detalhe,item_prot_saida_id,item_data_saida,item_entregue) value (?,?,?,?,?,?)";
                        ps = con.prepareStatement(sql);
                         ps.setString(1, pi.getNome());
                        ps.setInt(2, pi.getQuantidade());
                        ps.setString(3, pi.getDetalhe());
                        ps.setInt(4, pi.getProtocoloSaida());
                        ps.setDate(5, new java.sql.Date(new Date().getTime()));
                        ps.setInt(6, pi.getEntregue());
                    }
                    ps.executeUpdate();
                    if(!txCodProtocolo.getText().equals("")){
                        ps = con.prepareStatement("update documentos_recebidos set devolvido=1 where cod=?");
                        ps.setInt(1, Integer.parseInt(txCodProtocolo.getText()));
                        ps.executeUpdate();
                    }
                }
                preencherFormulario(Integer.parseInt(txCodigo.getText()));
                salvarCancelar();
                desbloquearFormulario(pnCadastro, false);
                abrirProtocolo();
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally{
                try{con.close();}catch(SQLException e){}
            }
        }
        else{
            try{
                String sql = "update protocolo_saida set"
                        + " prot_empresa_nome=?,prot_funcionario_para=?, prot_setor_para=?,prot_observacao=?,prot_usuario_id=?, prot_cliente=?"
                        + " where prot_id=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, (String)cbApelido.getSelectedItem());
                ps.setString(2, txFuncionario.getText());
                ps.setString(3, (String)cbSetor.getSelectedItem());
                ps.setString(4, txObservacao.getText());
                ps.setInt(5, UsuarioLogado.getInstance().getUsuario().getCod());
                ps.setInt(6, retornaClienteValido());
                ps.setInt(7, Integer.parseInt(txCodigo.getText()));
                
                ps.executeUpdate();
                
                DefaultTableModel model = (DefaultTableModel)tbItens.getModel();
                List<ProtocoloItem> itemsAdd = new ArrayList<>();
                for(int i =0; i<model.getRowCount(); i++){
                    ProtocoloItem pb = new ProtocoloItem();
                    String id = model.getValueAt(i, 0).toString();
                    pb.setId("".equals(id)?-1:Integer.parseInt(id));
                    pb.setNome(model.getValueAt(i, 1).toString());
                    pb.setQuantidade(Integer.parseInt(model.getValueAt(i, 2).toString()));
                    pb.setDetalhe(model.getValueAt(i, 3).toString());
                    pb.setProtocoloSaida(Integer.parseInt(txCodigo.getText()));
                    itemsAdd.add(pb);
                }
                for(int j=0;j<itemsAdd.size();j++){
                    ps.clearParameters();
                    ProtocoloItem pi = itemsAdd.get(j);
                    if(itemsAdd.get(j).getId()!=-1){
                        sql = "update protocolo_item set item_nome=?,"
                                + "item_quantidade=?,"
                                + "item_detalhe=?,"
                                + "item_prot_saida_id=?,"
                                + "item_entregue=? where"
                                + " item_id=?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, pi.getNome());
                        ps.setInt(2, pi.getQuantidade());
                        ps.setString(3, pi.getDetalhe());
                        ps.setInt(4, pi.getProtocoloSaida());
                        ps.setInt(5, pi.getEntregue());
                        ps.setInt(6, pi.getId());
                    }
                    else{
                        sql = "insert into protocolo_item (item_nome,item_quantidade,item_detalhe,item_prot_saida_id,item_data_saida,item_entregue) value (?,?,?,?,?,?)";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, pi.getNome());
                        ps.setInt(2, pi.getQuantidade());
                        ps.setString(3, pi.getDetalhe());
                        ps.setInt(4, pi.getProtocoloSaida());
                        ps.setDate(5, new java.sql.Date(new Date().getTime()));
                        ps.setInt(6, pi.getEntregue());
                    }
                    ps.executeUpdate();
                }
                preencherFormulario(Integer.parseInt(txCodigo.getText()));
                salvarCancelar();
                desbloquearFormulario(pnCadastro, false);
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                try{con.close();}catch(SQLException e){}
            }
        }
    }
    private Integer retornaClienteValido(){
        Set<String> emp = empresas.keySet();
        if(emp.contains(String.valueOf(cbApelido.getSelectedItem()))){
            return 1;
        }
        else return 0;
    }
    private void abrirProtocolo() {
        if(!"".equals(txCodigo.getText())){
            try{
                getConnection();
                HashMap parametros = new HashMap();
                parametros.put("CODIGO", Integer.parseInt(txCodigo.getText()));
                JasperPrint jp = null;
                try {
                    jp = JasperFillManager.fillReport("\\\\plkserver\\Sistemas\\Implantacao\\relatorios\\Protocolo.jasper", parametros,con);
//                    jp = JasperFillManager.fillReport("./relatorios/Protocolo.jasper", parametros, con); //"./relatorios/Protocolo.jasper"
                } catch (JRException ex) {
                    JOptionPane.showMessageDialog(null,"Erro ao abrir o Protocolo!\n"+ex);
                }
                JasperViewer jrv = new JasperViewer(jp,false);
                jrv.setVisible(true);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
                try{
                    con.close();
                }catch(SQLException ex){
                } 
            }
        }
    }
    private File carregarArquivo(){
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(true);
        chooser.setDialogTitle("Selecione um arquivo");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Documento PDF", "pdf"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office","doc","docx","xls", "xlsx", "pptx"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        int retorno = chooser.showOpenDialog(null);
        if(retorno==JFileChooser.OPEN_DIALOG){
            return chooser.getSelectedFile();
        }
        return null;
    }
    private void gerarSerial(){
        SuperGeradorRandomico gerador = new SuperGeradorRandomico();
        String nomeArquivo = gerador.gerarSerial(txCodigo.getText());
        FTPUpload upload = new FTPUpload();
        File file = carregarArquivo();
        if(file!=null){
            nomeArquivo+=file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());//inserindo extensao no nome do arquivo
            if(upload.uploadFile(file, nomeArquivo)){
                try{
                    PreparedStatement ps = getConnection().prepareStatement("update protocolo_saida set prot_comprovante=? "
                            + "where prot_id=?");
                    ps.setString(1,nomeArquivo);
                    ps.setInt(2, Integer.parseInt(txCodigo.getText()));
                    if(ps.executeUpdate()>0){
                        txComprovante.setText(nomeArquivo);
                        btnVisualizar1Via.setEnabled(true);
                    }
                }catch(SQLException e){
                    txComprovante.setText("Ocorreu um erro ao enviar o arquivo..Tente novamente!");
                }finally{
                    try{con.close();}catch(SQLException e){}
                }
            }
        }
    }
    private class EstabelecerFiltro implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.DESELECTED){
                String sql = "select * from protocolo_saida";
                if(!"".equals(cbProtocoloPesquisa.getSelectedItem())){
//                    if(Integer.parseInt((String)cbProtocoloPesquisa.getSelectedItem())>=aPos){
//                       //String sql = "select * from documentos_recebidos where passivel_devolucao=1 and recebido='S' and devolvido=0 and para_quem='"+(String)cbAtendentePesquisa.getSelectedItem()+"'";
//                       sql+= " where prot_id='"+(String)cbProtocoloPesquisa.getSelectedItem()+"'";
//                    }
//                    else
//                        JOptionPane.showMessageDialog(null, "Numero de protocolo de entrada não disponível para consulta!");
                    sql+= " where prot_id='"+(String)cbProtocoloPesquisa.getSelectedItem()+"'";
                }
                else if(!"".equals(cbAtendentePesquisa.getSelectedItem()))
                    sql+= " where prot_usuario_id="+atendentes.get((String)cbAtendentePesquisa.getSelectedItem())+"";
                preencherTabela(sql);
            }
        }
    }
    public void processar(){
        if(!"".equals(cbApelido.getSelectedItem())){
                    try{
                        txEmpresa.setText("");
                        int valor = Integer.parseInt(String.valueOf(cbApelido.getSelectedItem()));
                        if(empresas.get(valor)!=null){
                            txEmpresa.setEditable(false);
                            txEmpresa.setText(empresas.get(valor));
                        }
                    }catch(NumberFormatException ex){
                        txEmpresa.setText("");
                    }
                }else{
                    txEmpresa.setText("");
                }
    }    
    public class MudarCliente implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.DESELECTED){
                 processar();
            }
        }
    }
}
