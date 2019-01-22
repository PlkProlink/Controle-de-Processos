/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.ProcessoLogado;
import br.com.prolink.config.init.UsuarioLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Relatorios extends javax.swing.JInternalFrame {

    private String gerar = "";
    private String create = "Atual";
    private String tela = "";
    List<String> listaNomeGeral = new ArrayList();

    /**
     * Creates new form Relatorios
     *
     * @param gerar
     * @param tela
     * @param nome
     */
    public Relatorios(String gerar, String tela, List nome) {
        initComponents();

        this.listaNomeGeral = nome;
        table.setAutoCreateRowSorter(true);
        tbAuxiliar.setAutoCreateRowSorter(true);
        //Alerta=envia alerta com graficos
        //Relatorio= gera relatorio
        //
        //Alerta, Relatorio
        this.gerar = gerar;
        this.tela = tela;
        recebeValores();

        jProgressBar1.setVisible(false);
        lbAviso.setVisible(false);
        rbAtual.setSelected(true);
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);

        if (tela.equals("Geral")) {
            chEmail.setVisible(false);
        }
        if (ProcessoLogado.getInstance().getProcesso() == null) {
            rbAtual.setEnabled(false);
            rbSelecao.setSelected(true);
            jPanel1.setVisible(true);
            jPanel2.setVisible(true);
            carregaTodos();
            create = "Selecao";
            limparTabela(tbAuxiliar);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroup = new javax.swing.ButtonGroup();
        lbDestinoEmail = new javax.swing.JLabel();
        chEmail = new javax.swing.JCheckBox();
        rbAtual = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        rbSelecao = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        btInicia = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btRmAll = new javax.swing.JButton();
        btRm = new javax.swing.JButton();
        btAddAll = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAuxiliar = new javax.swing.JTable();
        cbDestino = new javax.swing.JComboBox<>();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lbAviso = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        lbDestinoEmail.setText("Destino:");

        chEmail.setBackground(new java.awt.Color(250, 250, 250));
        chEmail.setText("Receber Cópia");

        rbAtual.setBackground(new java.awt.Color(250, 250, 250));
        btGroup.add(rbAtual);
        rbAtual.setText("Cliente Atual");
        rbAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAtualActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rbSelecao.setBackground(new java.awt.Color(250, 250, 250));
        btGroup.add(rbSelecao);
        rbSelecao.setText("Selecionar");
        rbSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSelecaoActionPerformed(evt);
            }
        });

        rbTodos.setBackground(new java.awt.Color(250, 250, 250));
        btGroup.add(rbTodos);
        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        btInicia.setText("Concluir");
        btInicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        btRmAll.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btRmAll.setText("<<");
        btRmAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRmAllActionPerformed(evt);
            }
        });

        btRm.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btRm.setText("<");
        btRm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRmActionPerformed(evt);
            }
        });

        btAddAll.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btAddAll.setText(">>");
        btAddAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddAllActionPerformed(evt);
            }
        });

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        btAdd.setText(">");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        tbAuxiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbAuxiliar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAddAll)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRmAll, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btRm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btRmAll, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cbDestino.setBackground(new java.awt.Color(250, 250, 250));
        cbDestino.setMaximumSize(new java.awt.Dimension(110, 32767));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbSelecao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTodos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lbDestinoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lbAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chEmail)
                                    .addComponent(btInicia))
                                .addGap(0, 14, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAtual)
                    .addComponent(rbSelecao)
                    .addComponent(rbTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(lbDestinoEmail)
                            .addGap(4, 4, 4)
                            .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btInicia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        setBounds(0, 0, 500, 245);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        this.setLocation(0, 0);
    }//GEN-LAST:event_formComponentMoved

    private void rbAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAtualActionPerformed
        if (rbAtual.isSelected()) {
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
            create = "Atual";
        }
    }//GEN-LAST:event_rbAtualActionPerformed

    private void rbSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSelecaoActionPerformed
        if (rbSelecao.isSelected()) {
            jPanel1.setVisible(true);
            jPanel2.setVisible(true);
            carregaTodos();
            create = "Selecao";
            limparTabela(tbAuxiliar);
        }
    }//GEN-LAST:event_rbSelecaoActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        if (rbTodos.isSelected()) {
            jPanel1.setVisible(true);
            jPanel2.setVisible(false);
            create = "Todos";
            carregaTodos();
        }
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciaActionPerformed
        if (rbAtual.isSelected()) {
            if (ProcessoLogado.getInstance().getProcesso() != null) {
                iniciar();
            } else {
                JOptionPane.showMessageDialog(null, "Primeiro ative um cliente!");
            }
        } else {
            iniciar();
        }
    }//GEN-LAST:event_btIniciaActionPerformed

    private void btRmAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRmAllActionPerformed
        addTudoOrRemoveTudo(tbAuxiliar, table);
    }//GEN-LAST:event_btRmAllActionPerformed

    private void btRmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRmActionPerformed
        addUmOrRemoveUm(tbAuxiliar, table, "remover", "tabela a direita");
    }//GEN-LAST:event_btRmActionPerformed

    private void btAddAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddAllActionPerformed
        addTudoOrRemoveTudo(table, tbAuxiliar);
    }//GEN-LAST:event_btAddAllActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        addUmOrRemoveUm(table, tbAuxiliar, "adicionar", "tabela a esquerda");
    }//GEN-LAST:event_btAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAddAll;
    private javax.swing.ButtonGroup btGroup;
    private javax.swing.JButton btInicia;
    private javax.swing.JButton btRm;
    private javax.swing.JButton btRmAll;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JCheckBox chEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAviso;
    private javax.swing.JLabel lbDestinoEmail;
    private javax.swing.JRadioButton rbAtual;
    private javax.swing.JRadioButton rbSelecao;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable table;
    private javax.swing.JTable tbAuxiliar;
    // End of variables declaration//GEN-END:variables
    private void carregaTodos() {
        table.getColumnModel().getColumn(0);
        table.getColumnModel().getColumn(1);
        table.getColumnModel().getColumn(2);
        DefaultTableModel tbm = (DefaultTableModel) table.getModel();

        limparTabela(table);
        Connection con = new ConexaoStatement().getConnetion();

        try {
            String sql = "select codNumerodoprocesso, Apelido, Cliente from cadastrodeprocesso where Situacao=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    tbm.addRow(new String[1]);
                    tbm.setValueAt(rs.getString(1), i, 0);
                    tbm.setValueAt(rs.getString(2), i, 1);
                    tbm.setValueAt(rs.getString(3), i, 2);
                    i++;
                }
            }
        } catch (SQLException e) {

        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    private void limparTabela(JTable table) {
        DefaultTableModel tbm = (DefaultTableModel) table.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {
            tbm.removeRow(i);
        }
    }

    private void addTudoOrRemoveTudo(JTable tabela1, JTable tabela2) {
        DefaultTableModel tb1 = (DefaultTableModel) tabela1.getModel();
        DefaultTableModel tb2 = (DefaultTableModel) tabela2.getModel();

        while (tb1.getRowCount() > 0) {
            int linha = tb2.getRowCount();

            for (int i = 0; i < tb1.getRowCount(); i++) {
                String codigo = (String) tb1.getValueAt(i, 0);
                String apelido = (String) tb1.getValueAt(i, 1);
                String nome = (String) tb1.getValueAt(i, 2);

                tb2.addRow(new Object[1]);
                tb2.setValueAt(codigo, linha, 0);
                tb2.setValueAt(apelido, linha, 1);
                tb2.setValueAt(nome, linha, 2);
                linha++;

                tb1.removeRow(i);
            }
        }
    }

    private void addUmOrRemoveUm(JTable tabela1, JTable tabela2, String action, String tabela) {
        DefaultTableModel tb1 = (DefaultTableModel) tabela1.getModel();
        DefaultTableModel tb2 = (DefaultTableModel) tabela2.getModel();

        if (tb1.getRowCount() > 0) {
            int linha = tabela1.getSelectedRow();
            if (linha != -1) {
                String codigo = (String) tabela1.getValueAt(linha, 0);
                String apelido = (String) tabela1.getValueAt(linha, 1);
                String nome = (String) tb1.getValueAt(linha, 2);

                int linhaAux = tabela2.getRowCount();
                tb2.addRow(new Object[1]);
                tb2.setValueAt(codigo, linhaAux, 0);
                tb2.setValueAt(apelido, linhaAux, 1);
                tb2.setValueAt(nome, linhaAux, 2);
                tb1.removeRow(linha);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um valor da " + tabela + " para " + action + "!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há valores na tabela para " + action + "!");
        }
    }

    private void recebeValores() {
        switch (tela) {
            case "Comercial":
                preencherCombo("comercial");
                break;
            case "Contabil":
                preencherCombo("contabil");
                break;
            case "Contratos":
                preencherCombo("contratos");
                break;
            case "Fiscal":
                preencherCombo("fiscal");
                break;
            case "Pessoal":
                preencherCombo("pessoal");
                break;
            case "Regularizacao":
                preencherCombo("regularizacao");
                break;
            case "Geral":
                lbDestinoEmail.setVisible(false);
                cbDestino.setVisible(false);
                break;
            default:
                break;
        }
    }

    private void preencherCombo(String valor) {
        String sql = "select Nome from login where Departamento=? and Ativo=1";
        try {
            Connection con = new ConexaoStatement().getConnetion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ResultSet rs = ps.executeQuery();
            cbDestino.removeAll();
            if (rs != null) {
                while (rs.next()) {
                    cbDestino.addItem(rs.getString(1));
                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void iniciar() {
        List<String> lista = new ArrayList<>();
        boolean aproved = false;
        switch (create) {
            case "Atual":
                if (ProcessoLogado.getInstance().getProcesso() != null) {
                    aproved = true;
                    lista.add(ProcessoLogado.getInstance().getProcesso().getId() + "");
                }
                break;
            case "Selecao":
                //passando valores para a lista
                DefaultTableModel tb2 = (DefaultTableModel) tbAuxiliar.getModel();
                if (tb2.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Você deve selecionar os valores para poder continuar!");
                }
                ;
                while (tb2.getRowCount() > 0) {
                    aproved = true;
                    for (int i = 0; i < tb2.getRowCount(); i++) {
                        String codigo = (String) tb2.getValueAt(i, 0);
                        lista.add(codigo);
                        tb2.removeRow(i);
                    }
                }
                break;
            case "Todos":
                DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
                while (tb1.getRowCount() > 0) {
                    aproved = true;
                    for (int i = 0; i < tb1.getRowCount(); i++) {
                        String codigo = (String) tb1.getValueAt(i, 0);
                        lista.add(codigo);
                        tb1.removeRow(i);
                    }
                }
                break;
            default:
                break;
        }
        if (aproved) {
            switch (gerar) {
                case "Alerta":
                    iniciarEmail(lista);
                    break;
                case "Relatorio":
                    //iniciarRelatorio();
                    break;
                default:
                    break;
            }
        }
    }

    private void iniciarEmail(List listaDeProcessos) {
        AvisoEmail aviso = new AvisoEmail();
        StringBuilder builderContagem;
        StringBuilder builderDepartamento;
        StringBuilder builderDocumentos;
        jProgressBar1.setVisible(true);
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setStringPainted(true);
        String emailAtendente = recuperaEmail(UsuarioLogado.getInstance().getUsuario().getUsuario());
        String atendente = UsuarioLogado.getInstance().getUsuario().getUsuario();

        if (!tela.equals("Geral")) {
            builderContagem = new StringBuilder();
            builderDepartamento = new StringBuilder();
            builderDocumentos = new StringBuilder();
            int quantidade = 0;
            for (int i = 0; i < listaDeProcessos.size(); i++) {//pegando codigos dos processos
                ColhedoraDeDados dados = new ColhedoraDeDados();
                dados.conexaoDepartamentos(Integer.parseInt(listaDeProcessos.get(i).toString()), true, tela);
                dados.conexaoDocumentos(Integer.parseInt(listaDeProcessos.get(i).toString()), true, tela);
                builderContagem.append(dados.getTabelaContador(i));
                builderDepartamento.append(dados.getTabelaDepartamento(i));
                builderDocumentos.append(dados.getTabelaDocumentos(i));
                quantidade += dados.getContaTudo();
            }
            String code
                    = "<tr class=\"table-active\">"
                    + "<td colspan=\"2\" class=\"centralizar\"><strong>Total</strong></td>"
                    + "<td colspan=\"2\" class=\"centralizar\"><strong>" + quantidade + "</strong></td>"
                    + "</tr>";
            builderContagem.append(code);

            String titulo = "Prolink - Implantação de Cliente - " + (String) cbDestino.getSelectedItem() + ", estamos aguardando sua interação";
            String contaDestino = recuperaEmail((String) cbDestino.getSelectedItem());
            String htmlTexto = getHtml(tela, atendente, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString());

            Runnable run = () -> {
                jProgressBar1.setString("Enviando...");
                aviso.enviaAlerta(contaDestino, chEmail.isSelected() ? new String[]{emailAtendente} : null, titulo, htmlTexto);
                jProgressBar1.setString("Concluido!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }
                jProgressBar1.setVisible(false);
            };
            new Thread(run).start();
        } else {
            jProgressBar1.setString("Aguarde...");
            for (int i = 0; i < listaNomeGeral.size(); i++) {//pegando lista de pessoas para receber o comunicado
                //um builder para cada pessoa
                builderContagem = new StringBuilder();
                builderDepartamento = new StringBuilder();
                builderDocumentos = new StringBuilder();
                String telaGeral = recuperaDepartamento(listaNomeGeral.get(i));
                int quantidade = 0;
                for (int j = 0; j < listaDeProcessos.size(); j++) {//pegando os codigos para envio
                    ColhedoraDeDados dados = new ColhedoraDeDados();
                    dados.conexaoDepartamentos(Integer.parseInt(listaDeProcessos.get(j).toString()), true, telaGeral);
                    dados.conexaoDocumentos(Integer.parseInt(listaDeProcessos.get(j).toString()), true, telaGeral);
                    builderContagem.append(dados.getTabelaContador(j));
                    builderDepartamento.append(dados.getTabelaDepartamento(j));
                    builderDocumentos.append(dados.getTabelaDocumentos(j));
                    quantidade += dados.getContaTudo();
                }
                String code
                        = "<tr class=\"table-active\">"
                        + "<td colspan=\"2\" class=\"centralizar\"><strong>Total</strong></td>"
                        + "<td colspan=\"2\" class=\"centralizar\"><strong>" + quantidade + "</strong></td>"
                        + "</tr>";
                builderContagem.append(code);
                String titulo = "Prolink - Implantação de Cliente - " + listaNomeGeral.get(i) + ", estamos aguardando sua interação";
                String contaDestino = recuperaEmail(listaNomeGeral.get(i));
                String htmlTexto = getHtml(telaGeral, atendente, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString());

                final int a = (i + 1);
                final int l = listaNomeGeral.size();
                Runnable run = () -> {
                    jProgressBar1.setString("Enviando " + a + " de " + l);
                    aviso.enviaAlerta(contaDestino, chEmail.isSelected() ? new String[]{emailAtendente} : null, titulo, htmlTexto);
                };
                new Thread(run).start();
            }
            Runnable run = () -> {
                jProgressBar1.setString("Concluido!!!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                }
                jProgressBar1.setVisible(false);
            };
            new Thread(run).start();
        }
//    else{
//        for(int i=0; i<lista.size(); i++){
//            ColhedoraDeDados dados = new ColhedoraDeDados();
//            dados.conexaoDepartamentos(Integer.parseInt(lista.get(i).toString()), true, tela);
//            dados.conexaoDocumentos(Integer.parseInt(lista.get(i).toString()), true, tela);
//            tudo = dados.getContaTudo(tudo);
//            builderContagem.append(dados.getTabelaContador());
//            builderDepartamento.append(dados.getTabelaDepartamento());
//            builderDocumentos.append(dados.getTabelaDocumentos());
//        }
//        AvisoEmail aviso = new AvisoEmail();
//        
//        if(aviso.enviaAlerta("tiago.dias@prolinkcontabil.com.br",(String)cbDestino.getSelectedItem(), tela, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString(), tudo)){
//            //recuperaEmail((String)cbDestino.getSelectedItem())
//            //recuperaEmail(Login.usuario)
//            lbAviso.setVisible(true);
//            lbAviso.setText("Enviado!");
//            lbAviso.setBackground(Color.green);
//            if(chEmail.isSelected()){
//                aviso.enviaAlerta("tiago.dias@prolinkcontabil.com.br",(String)cbDestino.getSelectedItem(), tela, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString(), tudo);
//                lbAviso.setText("Copia Enviada!");
//            }
//            
//        }
//        else{
//            lbAviso.setVisible(true);
//            lbAviso.setText("Não Enviado!");
//            lbAviso.setBackground(Color.red);
//        }
//    }
    }

    private String recuperaEmail(String valor) {
        Connection con = new ConexaoStatement().getConnetion();
        try {
            String sql = "select Email from login where Nome like '" + valor + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            String email = "";
            if (rs != null) {
                while (rs.next()) {
                    email = rs.getString("Email");
                }
            }
            return email;
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        return "";
    }

    private String recuperaDepartamento(String valor) {
        Connection con = new ConexaoStatement().getConnetion();
        try {
            String sql = "select Departamento from login where Nome like '" + valor + "%'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            String email = "";
            if (rs != null) {
                while (rs.next()) {
                    email = rs.getString("Departamento");
                }
            }
            return email;
        } catch (SQLException e) {
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        return "";
    }

    private String getHtml(String departamento, String usuario, String tabelaContador, String tabelaDepartamento, String tabelaDocumentos) {
        // BuildMyString.com generated code. Please enjoy your string responsibly.

        StringBuilder builder = new StringBuilder();

        builder.append("<!DOCTYPE html>");
        builder.append("<html lang=\"pt-br\">");
        builder.append("	<head>");
        builder.append("		<title>Controle de Processos</title>");
        builder.append("		<meta charset=\"UTF-8\">");
        builder.append("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        builder.append("		<!-- Bootstrap CSS -->");
        builder.append("		<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">");
        builder.append("		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js\" integrity=\"sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1\" crossorigin=\"anonymous\"></script>");
        builder.append("		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->");
        builder.append("		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->");
        builder.append("		<!--[if lt IE 9]>");
        builder.append("		  <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>");
        builder.append("		  <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>");
        builder.append("		<![endif]-->");
        builder.append("		<style type=\"text/css\">");
        builder.append("			.paragrafo{");
        builder.append("				font-size: 18px;");
        builder.append("				font-weight: bolder;");
        builder.append("			}");
        builder.append("			th{");
        builder.append("				text-align: center;");
        builder.append("			}");
        builder.append("			.centralizar{");
        builder.append("				text-align: center;");
        builder.append("			}");
        builder.append("			caption{");
        builder.append("				font-size: 20px;");
        builder.append("				font-weigth: bold;");
        builder.append("				text-align: center;");
        builder.append("				caption-side: top;");
        builder.append("			}");
        builder.append("			");
        builder.append("		</style>");
        builder.append("	</head>");
        builder.append("	<body>");
        builder.append("		<div class=\"container\">	");
        builder.append("			<div class=\"page-header\">");
        builder.append("				<p class=\"paragrafo\">Ol&aacute;,<br>");
        builder.append("				Foi disparado para voc&ecirc; uma cobran&ccedil;a para valida&ccedil;&otilde;es dentro no sistema Controle de Processos.</p>");
        builder.append("				<p class=\"paragrafo\">Essa opera&ccedil;&atilde;o foi gerado manualmente por {user.name}, ");
        builder.append("				nesse caso &eacute; necess&aacute;rio que voc&ecirc; logue no sistema e finalize as opera&ccedil;&otilde;es em aberto.</p>");
        builder.append("				<ul>");
        builder.append("					<li>Para validar a op&ccedil;&atilde;o <strong>Controle {departamento}</strong> use a guia <strong>Implanta&ccedil;&atilde;o > {departamento}.</strong></li>");
        builder.append("					<li>Para validar os <strong>Documentos Recebidos para Implanta&ccedil;&atilde;o</strong> use a guia <strong>Implanta&ccedil;&atilde;o > Documentos Recebidos.</strong></li>");
        builder.append("				</ul>");
        builder.append("			</div>");
        builder.append("			<br><br>");
        builder.append("			<div class=\"col-8 col-sm-12\">");
        builder.append("				<table class=\"table table-striped table-bordered table-hover table-condensed table-responsive table-sm\">");
        builder.append("					<caption>Quantidade de Valida&ccedil;&otilde;es Pendentes do Departamento {departamento}</caption>");
        builder.append("					<thead>");
        builder.append("						<tr class=\"table-danger\">");
        builder.append("							<th>ID</th>");
        builder.append("							<th>Nome</th>");
        builder.append("							<th>Controle {departamento}</th>");
        builder.append("							<th>Documentos Recebidos <br>para Implanta&ccedil;&atilde;o</th>");
        builder.append("						</th>");
        builder.append("						</tr>");
        builder.append("					</thead>");
        builder.append("					<tbody>");
        builder.append("						{tabelaContador}									");
        builder.append("					</tbody>");
        builder.append("				</table>");
        builder.append("			</div>");
        builder.append("			<br><br>");
        builder.append("			<div class=\"col-8 col-sm-12\">");
        builder.append("				<table class=\"table table-striped table-bordered table-hover table-condensed table-responsive table-sm\">");
        builder.append("					<caption>Detalhes do Controle do Departamento {departamento}</caption>");
        builder.append("					");
        builder.append("					<thead>");
        builder.append("						<tr class=\"table-danger\">");
        builder.append("							<th>ID</th>");
        builder.append("							<th>Nome</th>");
        builder.append("							<th>Valida&ccedil;&otilde;es Pendentes</th>");
        builder.append("						</th>");
        builder.append("						</tr>");
        builder.append("					</thead>");
        builder.append("					<tbody>");
        builder.append("						{tabelaDepartamento}						");
        builder.append("					</tbody>");
        builder.append("				</table>");
        builder.append("			<div>");
        builder.append("			<br><br>");
        builder.append("			<div class=\"col-8 col-sm-12\">");
        builder.append("				<table class=\"table table-striped table-bordered table-hover table-condensed table-responsive table-sm\">");
        builder.append("					<caption>Detalhes dos Documentos Recebidos - Pend&ecirc;ncias de Valida&ccedil;&atilde;o do Departamento {departamento}</caption>");
        builder.append("					<thead>");
        builder.append("						<tr class=\"table-danger\">");
        builder.append("							<th>ID</th>");
        builder.append("							<th>Nome</th>");
        builder.append("							<th>Valida&ccedil;&otilde;es Pendentes</th>");
        builder.append("						</th>");
        builder.append("						</tr>");
        builder.append("					</thead>");
        builder.append("					<tbody>");
        builder.append("						{tabelaDocumentos}						");
        builder.append("					</tbody>");
        builder.append("				</table>");
        builder.append("			</div>");
        builder.append("		</div>");
        builder.append("		<br><br>");
        builder.append("		<div class=\"container\">");
        builder.append("			<div class=\"row\">");
        builder.append("				<div class=\"col-12\">");
        builder.append("					<p align=\"center\">Todos os Direitos reservados a Prolink Contabil - 2017</p>");
        builder.append("				</div>");
        builder.append("			</div>");
        builder.append("		</div>");
        builder.append("	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->");
        builder.append("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
        builder.append("	</body>");
        builder.append("</html>");
        return builder.toString()
                .replace("{departamento}", Normalizer
                        .normalize(departamento, Normalizer.Form.NFD)
                        .replaceAll("[^\\p{ASCII}]", ""))
                .replace("{user.name}", usuario)
                .replace("{tabelaContador}", tabelaContador)
                .replace("{tabelaDepartamento}", tabelaDepartamento)
                .replace("{tabelaDocumentos}", tabelaDocumentos);
    }

}
