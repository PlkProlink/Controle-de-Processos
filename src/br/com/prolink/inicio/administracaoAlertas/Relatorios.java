/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

import br.com.prolink.inicio.ConexaoStatement;
import br.com.prolink.inicio.TelaPrincipal;
import br.com.prolink.login.Login;
import static br.com.prolink.login.Login.TREE_SECOND;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Relatorios extends javax.swing.JInternalFrame{

    private String gerar="";
    private String create="Atual";
    private String tela="";
    public final static int TREE_SECOND=3;
    private Timer tempo;
    int cont;
    String valor = TelaPrincipal.txt_codigo.getText();
    
    List<String> listaNomeGeral = new ArrayList();
    
    /**
     * Creates new form Relatorios
     * @param gerar
     * @param tela
     * @param nome
     */
    public Relatorios(String gerar, String tela, List nome) {
        initComponents();
        
        this.listaNomeGeral=nome;
        
        table.setAutoCreateRowSorter(true);
        tbAuxiliar.setAutoCreateRowSorter(true);
        //Alerta=envia alerta com graficos
        //Relatorio= gera relatorio
        //
        //Alerta, Relatorio
        this.gerar = gerar;
        this.tela=tela;
        
        recebeValores();
        
        jProgressBar1.setVisible(false);
        lbAviso.setVisible(false);
        
        rbAtual.setSelected(true);
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        if(tela.equals("Geral")){
            chEmail.setVisible(false);
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
        if(rbAtual.isSelected()){
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
            create="Atual";
        }
    }//GEN-LAST:event_rbAtualActionPerformed

    private void rbSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSelecaoActionPerformed
        if(rbSelecao.isSelected()){
            jPanel1.setVisible(true);
            jPanel2.setVisible(true);
            carregaTodos();
            create="Selecao";
            limparTabela(tbAuxiliar);
        }
    }//GEN-LAST:event_rbSelecaoActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        if(rbTodos.isSelected()){
            jPanel1.setVisible(true);
            jPanel2.setVisible(false);
            create="Todos";
            carregaTodos();
        }
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btIniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciaActionPerformed
        if(rbAtual.isSelected()){
            if(!TelaPrincipal.txt_codigo.getText().equals(""))
            iniciar();
        else
            JOptionPane.showMessageDialog(null, "Primeiro ative um cliente!");
        }
        else
            iniciar();
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
class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        cont++;
        jProgressBar1.setValue(cont);
        if(cont==100){
            tempo.stop();
            jProgressBar1.setVisible(false);
            lbAviso.setText("");
        }
        }
    }
    
    
private void carregaTodos(){
    table.getColumnModel().getColumn(0);
    table.getColumnModel().getColumn(1);
    table.getColumnModel().getColumn(2);
    DefaultTableModel tbm = (DefaultTableModel)table.getModel();
    
    limparTabela(table);
    Connection con  = new ConexaoStatement().getConnetion();
    
    
    try{
        String sql = "select codNumerodoprocesso, Apelido, Cliente from cadastrodeprocesso where Situacao=1";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int i=0;
        if(rs!=null){
            while(rs.next()){
                tbm.addRow(new String[1]);
                tbm.setValueAt(rs.getString(1), i , 0);
                tbm.setValueAt(rs.getString(2), i , 1);
                tbm.setValueAt(rs.getString(3), i , 2);
                i++;
            }
        }
    }catch(SQLException e){
        
    }finally{if(con!=null)try {con.close();} catch (SQLException ex) {}}
}
private void limparTabela(JTable table){
    DefaultTableModel tbm = (DefaultTableModel)table.getModel();
    for(int i=tbm.getRowCount()-1; i>=0; i--){
        tbm.removeRow(i);
    }
}
private void addTudoOrRemoveTudo(JTable tabela1, JTable tabela2){
    DefaultTableModel tb1 = (DefaultTableModel)tabela1.getModel();
    DefaultTableModel tb2 = (DefaultTableModel)tabela2.getModel();
   
    while(tb1.getRowCount()>0){
        int linha = tb2.getRowCount();

        for(int i=0; i<tb1.getRowCount(); i++){
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
private void addUmOrRemoveUm(JTable tabela1, JTable tabela2, String action, String tabela){
    DefaultTableModel tb1 = (DefaultTableModel)tabela1.getModel();
    DefaultTableModel tb2 = (DefaultTableModel)tabela2.getModel();
    
    if(tb1.getRowCount()>0){
        int linha = tabela1.getSelectedRow();
        if(linha!=-1){
            String codigo = (String) tabela1.getValueAt(linha, 0);
            String apelido = (String) tabela1.getValueAt(linha, 1);
            String nome = (String) tb1.getValueAt(linha, 2);
            
            int linhaAux = tabela2.getRowCount();
            tb2.addRow(new Object[1]);
            tb2.setValueAt(codigo, linhaAux, 0);
            tb2.setValueAt(apelido, linhaAux, 1);
            tb2.setValueAt(nome, linhaAux, 2);
            tb1.removeRow(linha);
        }
        else
            JOptionPane.showMessageDialog(null, "Selecione um valor da "+tabela+" para "+action+"!");
    }
    else
        JOptionPane.showMessageDialog(null, "Não há valores na tabela para "+action+"!");
}

private void recebeValores(){
    switch(tela){
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


private void preencherCombo(String valor){
    String sql = "select Nome from login where Departamento=?";
    
    try{
        Connection con = new ConexaoStatement().getConnetion();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, valor);
        ResultSet rs = ps.executeQuery();
        cbDestino.removeAll();
        if(rs!=null){
            while(rs.next()){
                cbDestino.addItem(rs.getString(1));
            }
        }
        con.close();
    }catch(SQLException e){
        e.printStackTrace();
    }
}
private void iniciar(){
    List<String> lista = new ArrayList<>();
    boolean aproved =false;
    switch(create){
        case "Atual":
            if(TelaPrincipal.txt_codigo.getText().equals("")){
                aproved=false;
            }
            else
                aproved=true;
                lista.add(valor);
        break;
        case "Selecao":
            //passando valores para a lista
            DefaultTableModel tb2 = (DefaultTableModel)tbAuxiliar.getModel();
            if(tb2.getRowCount()==0){
                JOptionPane.showMessageDialog(null, "Você deve selecionar os valores para poder continuar!");
            };
            while(tb2.getRowCount()>0){
                aproved=true;
                for(int i = 0;i<tb2.getRowCount();i++){
                    String codigo = (String) tb2.getValueAt(i,0);
                    lista.add(codigo);
                    tb2.removeRow(i);
                }
            }
        break;
        case "Todos":
            DefaultTableModel tb1 = (DefaultTableModel)table.getModel();
            while(tb1.getRowCount()>0){
                aproved=true;
                for(int i = 0;i<tb1.getRowCount();i++){
                    String codigo = (String) tb1.getValueAt(i,0);
                    lista.add(codigo);
                    tb1.removeRow(i);
                }
            }
        break;
        default:
        break;
    }
    if(aproved==true){
        switch(gerar){
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


private void iniciarEmail(List lista){
    
    StringBuilder builderContagem;
    StringBuilder builderDepartamento;
    StringBuilder builderDocumentos;
    
    if(!tela.equals("Geral")){
        int tudo=0;
    
        builderContagem = new StringBuilder();
        builderDepartamento = new StringBuilder();
        builderDocumentos = new StringBuilder();
        
        for(int i=0; i<lista.size(); i++){//pegando codigos gerados
            
            ColhedoraDeDados dados = new ColhedoraDeDados();
            dados.conexaoDepartamentos(Integer.parseInt(lista.get(i).toString()), true, tela);
            dados.conexaoDocumentos(Integer.parseInt(lista.get(i).toString()), true, tela);
            tudo = dados.getContaTudo(tudo);
            builderContagem.append(dados.getTabelaContador());
            builderDepartamento.append(dados.getTabelaDepartamento());
            builderDocumentos.append(dados.getTabelaDocumentos());
        }
        AvisoEmail aviso = new AvisoEmail();
        if(aviso.enviaAlerta(recuperaEmail((String)cbDestino.getSelectedItem()),(String)cbDestino.getSelectedItem(), tela, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString(), tudo)){
            if(chEmail.isSelected()){
                if(aviso.enviaAlerta(recuperaEmail(Login.usuario),Login.usuario, tela, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString(), tudo)){
                    lbAviso.setText("Enviando...");
                }
            }
            lbAviso.setText("Enviando...");
            jProgressBar1.setVisible(true);
            cont=-1;
            jProgressBar1.setValue(0);
            jProgressBar1.setStringPainted(true);
            tempo = new Timer(TREE_SECOND,new Relatorios.TimerListener());
            tempo.start();
        }
    }
    else{
        for(int i = 0; i<listaNomeGeral.size(); i++){//pegando lista de pessoas para receber o comunicado
            int tudo=0;
    
            //um builder para cada pessoa
            builderContagem = new StringBuilder();
            builderDepartamento = new StringBuilder();
            builderDocumentos = new StringBuilder();
            String telaGeral = recuperaDepartamento(listaNomeGeral.get(i));
            
            for(int j=0; j<lista.size(); j++){//pegando os codigos para envio
                ColhedoraDeDados dados = new ColhedoraDeDados();
                dados.conexaoDepartamentos(Integer.parseInt(lista.get(j).toString()), true, telaGeral);
                dados.conexaoDocumentos(Integer.parseInt(lista.get(j).toString()), true, telaGeral);
                tudo = dados.getContaTudo(tudo);
                builderContagem.append(dados.getTabelaContador());
                builderDepartamento.append(dados.getTabelaDepartamento());
                builderDocumentos.append(dados.getTabelaDocumentos());
            }
            AvisoEmail aviso = new AvisoEmail();
            if(aviso.enviaAlerta(recuperaEmail(listaNomeGeral.get(i)),listaNomeGeral.get(i), telaGeral, builderContagem.toString(), builderDepartamento.toString(), builderDocumentos.toString(), tudo)){
                lbAviso.setVisible(true);
                lbAviso.setText("Enviando...");
                jProgressBar1.setVisible(true);
                cont=-1;
                jProgressBar1.setValue(0);
                jProgressBar1.setStringPainted(true);
                tempo = new Timer(TREE_SECOND,new Relatorios.TimerListener());
                tempo.start();
            }
            
        }
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
private String recuperaEmail(String valor){
    Connection con  = new ConexaoStatement().getConnetion();
    try{
        String sql = "select Email from login where Nome like '"+valor+"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int i=0;
        String email="";
        if(rs!=null){
            while(rs.next()){
                email= rs.getString("Email");
            }
        }
        return email;
    }catch(SQLException e){
    }finally{if(con!=null)try {con.close();} catch (SQLException ex) {}}
    return "";
}
private String recuperaDepartamento(String valor){
    Connection con  = new ConexaoStatement().getConnetion();
    try{
        String sql = "select Departamento from login where Nome like '"+valor+"%'";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int i=0;
        String email="";
        if(rs!=null){
            while(rs.next()){
                email= rs.getString("Departamento");
            }
        }
        return email;
    }catch(SQLException e){
    }finally{if(con!=null)try {con.close();} catch (SQLException ex) {}}
    return "";
}

private void iniciarRelatorio(){}

}
