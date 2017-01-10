/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

import br.com.prolink.departamentos.Fiscal;
import br.com.prolink.documentos.Documentos;
import br.com.prolink.inicio.Ativador;
import br.com.prolink.inicio.ConexaoStatement;
import br.com.prolink.inicio.TelaPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class InternoFiscal extends javax.swing.JInternalFrame {
    boolean controle = true;
    int documento = 0;
    /**
     * Creates new form InternoComercial
     */
    public InternoFiscal() {
        initComponents();
        btRelatorio.setVisible(false);
        carregaCombo();
        String value = TelaPrincipal.txt_codigo.getText();
        if(value!=null && value!=""){
            fiscal(TelaPrincipal.txt_codigo.getText());
            //add(TelaPrincipal.txt_codigo.getText());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tbSolicitacao = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btRelatorio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel10 = new javax.swing.JLabel();
        jPDepartamento = new javax.swing.JPanel();
        lbDistribuir = new javax.swing.JLabel();
        lbGeral = new javax.swing.JLabel();
        lbPerfil = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(250, 250, 250));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(860, 600));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        tbSolicitacao.setBackground(new java.awt.Color(250, 250, 250));
        tbSolicitacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aguardando Validação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbSolicitacao);

        jButton1.setText("Visualizar Tela");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Visualizar Tela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Gerar Alerta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btRelatorio.setText("Relatório");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Documentos:");

        jDesktopPane1.setBackground(new java.awt.Color(250, 250, 250));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(500, 245));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Controle:");

        jPDepartamento.setBackground(new java.awt.Color(250, 250, 250));
        jPDepartamento.setAutoscrolls(true);

        lbDistribuir.setBackground(new java.awt.Color(250, 250, 250));
        lbDistribuir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbDistribuir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDistribuir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbDistribuir.setOpaque(true);
        lbDistribuir.setPreferredSize(new java.awt.Dimension(0, 22));

        lbGeral.setBackground(new java.awt.Color(250, 250, 250));
        lbGeral.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbGeral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGeral.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbGeral.setOpaque(true);

        lbPerfil.setBackground(new java.awt.Color(250, 250, 250));
        lbPerfil.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPerfil.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbPerfil.setOpaque(true);
        lbPerfil.setPreferredSize(new java.awt.Dimension(0, 22));

        javax.swing.GroupLayout jPDepartamentoLayout = new javax.swing.GroupLayout(jPDepartamento);
        jPDepartamento.setLayout(jPDepartamentoLayout);
        jPDepartamentoLayout.setHorizontalGroup(
            jPDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDepartamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDistribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPDepartamentoLayout.setVerticalGroup(
            jPDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDepartamentoLayout.createSequentialGroup()
                .addComponent(lbGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(lbDistribuir, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setText("Distribuir para Funcionário:");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Validar Perfil Fiscal");

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fiscal");
        jLabel1.setOpaque(true);

        jComboBox1.setBackground(new java.awt.Color(250, 250, 250));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jButton1))
                        .addGap(34, 34, 34)
                        .addComponent(jPDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(137, 137, 137)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addComponent(jPDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btRelatorio, jButton1, jButton2, jButton3});

        setBounds(0, 0, 860, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        this.setLocation(0,0);
    }//GEN-LAST:event_formComponentMoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!controle){
            JOptionPane.showMessageDialog(null,"Não existem pendências do cliente "+TelaPrincipal.txt_nome+" \npara serem validadas para esse departamento!");
        }
        else{
            List <String> nova = new ArrayList<>();
            nova.add("");
            Relatorios relatorio = new Relatorios("Alerta", "Fiscal", nova);
            jDesktopPane1.removeAll();
            ((BasicInternalFrameUI)relatorio.getUI()).setNorthPane(null);
            jDesktopPane1.add(relatorio);
            relatorio.setVisible(true);        
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        
    }//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(!jComboBox1.getSelectedItem().equals("Clique aqui para Ativar!")  &&
                !jComboBox1.getSelectedItem().equals(null)){
            combo((String)jComboBox1.getSelectedItem());
            fiscal(TelaPrincipal.txt_codigo.getText());
//            add(TelaPrincipal.txt_codigo.getText());
            
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        abrirFiscal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        abrirDocumentos();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRelatorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPDepartamento;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbDistribuir;
    private javax.swing.JLabel lbGeral;
    private javax.swing.JLabel lbPerfil;
    private javax.swing.JTable tbSolicitacao;
    // End of variables declaration//GEN-END:variables
    Documentos documentos;
    Fiscal fiscal;
    
    public void carregaCombo(){
        Connection con = null;
        try{
            String sql ="select SUBSTRING_INDEX(SUBSTRING_INDEX(Cliente, ' ', 3), ' ', -3) as Cliente from cadastrodeprocesso where Situacao=1";
            con = new ConexaoStatement().getConnetion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jComboBox1.removeAll();
            jComboBox1.addItem("Clique aqui para Ativar!");
            
                        
            if(rs!=null){
                while(rs.next()){
                    jComboBox1.addItem(rs.getString("Cliente"));
                }
                String valor = TelaPrincipal.txt_nome.getText();
                if(!valor.equals(null) && !valor.equals(""))
                    jComboBox1.setSelectedItem(valor);
                else
                    jComboBox1.setSelectedItem("Clique aqui para Ativar!");

            }
            
            
        }catch(SQLException e){
        }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    private void abrirDocumentos(){
        if(TelaPrincipal.txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Para prosseguir ative um cadastro!");
            Ativador ativador = new Ativador();
            ativador.setVisible(true);
        }
        else{
            documentos = new Documentos();            
            documentos.setVisible(true);
            
        }
    }
    
    private void abrirFiscal(){
        if(TelaPrincipal.txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Para prosseguir ative um cadastro!");
            Ativador ma = new Ativador();
            ma.setVisible(true);
        }
        else{   
            fiscal = new Fiscal();
            fiscal.setVisible(true);
        }
    }
    public void combo(String valor){
        Connection con = null;
        try{
            String sql ="select * from cadastrodeprocesso where Cliente like '"+valor+"%'";
            con = new ConexaoStatement().getConnetion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs!=null){
                if(rs.next()){
                    TelaPrincipal.txt_codigo.setText(rs.getString("codNumerodoprocesso"));
                    TelaPrincipal.txt_nome.setText(rs.getString("Cliente"));
                    TelaPrincipal.txt_id.setText(rs.getString("Apelido"));
                    TelaPrincipal.txt_classificacao.setText(rs.getString("Classificacao"));
                    TelaPrincipal.txt_ativada.setText("");
                    TelaPrincipal.txt_finalizada.setText("");
                }
            }
            
        }catch(SQLException e){
        }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    }
    public void fiscal(String processo){
        Connection con = new ConexaoStatement().getConnetion();
        
        String sql = "select B.AndamentoFiscal as GERAL,"
                +   "A.AndamenoDistribuirFuncionarioInterno as DISTRIBUIR,"
                +   "A.AndamentoValidarPerfilFiscal as PERFIL "
                +   "from fiscal as A " 
                +   "inner join cadastrodeprocesso as B "
                +   "on A.Numerodoprocesso=B.codNumerodoprocesso "
                +   "where A.Numerodoprocesso='"+processo+"'"; 
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    lbGeral.setText(rs.getString("GERAL"));
                    lbPerfil.setText(rs.getString("PERFIL"));
                    lbDistribuir.setText(rs.getString("DISTRIBUIR"));
                }
            colorir(jPDepartamento);
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao listar na tabela " +erro);
            }finally{try{con.close();}catch(Exception e){}
        }
}
private void colorir(JPanel jpanel){
    
    for(int i = 0; i<jpanel.getComponentCount();i++){
        if(jpanel.getComponent(i) instanceof JLabel){
            JLabel label =((JLabel)jpanel.getComponent(i));
            if(label.getText().equals("Concluido") || 
                label.getText().equals("Finalizado")){
                    controle=false;
                    label.setBackground(Color.GREEN);
                    label.setForeground(Color.WHITE);
            }else{
                label.setBackground(Color.RED);
                label.setForeground(Color.WHITE);
                
            }
        }
    }
}

private void add(String processo){
    limpar_tabela(tbSolicitacao);
    Connection con = new ConexaoStatement().getConnetion();
    String sql = "select * from documentos where Numerodoprocesso='"+processo+"'";
    try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    //area contratos
//                    contexto("Ato Constitutivo",rs.getString("AtoConstitutivo"));
//                    contexto("Documentos do Socio",rs.getString("RGeCPFSocio"));
//                    contexto("Comprovantes dos Sócios",rs.getString("ComprovanteResidencia"));
//                    contexto("Numero Pis",rs.getString("NumeroPIS"));
//                    contexto("Habilitar NFe PMSP",rs.getString("AutorizacaoNotaFiscalEletronica"));
//                    contexto("Senha Posto Fiscal",rs.getString("SenhaPostoFiscal"));
//                    contexto("Senha Simples Nacional",rs.getString("SenhaSimplesNacional"));
//                    contexto("Perfil Fiscal PMSP",rs.getString("ConfigurarPerfilFiscalNoSitePrefeituraDocumento"));

//area contabil
//                    contexto("Balanço e D.R.E",rs.getString("BalancoDRE"));
//                    contexto("Contas Patrimoniais",rs.getString("ComposicaoDeContasPatrimoniais"));
//                    contexto("Plano de Contas",rs.getString("PlanoDeContas"));
//                    contexto("Balancete",rs.getString("BalanceteExercicio"));
                    //departamento pessoal
//                    contexto("Folha de Pagamento",rs.getString("FolhadePagamentoDocumento"));
//                    contexto("Fichs de Funcionários",rs.getString("LivroOuFichadeRegistroFuncionario"));
//                    contexto("Caged",rs.getString("CAGED"));
//                    contexto("Recisões",rs.getString("Recisao"));
//                    contexto("Recibo de Férias",rs.getString("Ferias"));
//                    contexto("Afastamentos",rs.getString("Afastamento"));
                    //regularizacao senhas
//                    contexto("Senha Receita Federal",rs.getString("OutorgaSenhaEletronicaReceita"));
//                    contexto("Termo Resp.Tecnica",rs.getString("TermodeResponsabilidadeDocumento"));
//                    contexto("Senha do Inss",rs.getString("SenhaINSS"));
                    
                    }
//            statusTabel(tbRecebimento);
//            statusTabel(tbSolicitacao);
           }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro ao listar na tabela Diagnose " +erro);
           }finally{try{if(con!=null)con.close();}catch(Exception e){}}
    
}
private void contexto(String nomeLabel, String valor){
    if(valor.trim().equals("Aguardando Validação")){
        criaLabel(tbSolicitacao, nomeLabel);
    }
}
private void criaLabel(JTable tabela, String text){
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    int linha = modelo.getRowCount();
    modelo.addRow(new String[1]);
        tabela.setValueAt(text, linha, 0);
    
}
public static void limpar_tabela(JTable jtable){
  DefaultTableModel tbm = (DefaultTableModel)jtable.getModel();
            for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
}
private void statusTabel(JTable tabela){
    DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
    if(modelo.getRowCount()==0){
        modelo.addRow(new String[1]);
        tabela.setValueAt("Nenhuma Pendência", 0, 0);
    }
}
}
