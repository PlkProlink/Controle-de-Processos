/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.cadastros;


import java.awt.HeadlessException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import br.com.prolink.inicio.*;

/**
 *
 * @author Tiago Dias
 */
public class CadastroClientes extends javax.swing.JFrame {
    MaskFormatter formatoData, formatoAtivada, formatoFim;
 
    Conexao con_cliente = new Conexao();
    Conexao con_classificacao= new Conexao();
    
    String codigo_backup, apelido_backup, nome_backup, classificacao_backup, data_backup, datainicio_backup, datafim_backup;  
    
    SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
    SimpleDateFormat in = new SimpleDateFormat("yyyy-mm-dd");//do sistema para o banco
    SimpleDateFormat out = new SimpleDateFormat("dd/mm/yyyy");//do banco para o sistema
    
    public CadastroClientes() {
        initComponents();
        
        con_cliente.conecta();
        
        atualiza_combo_box_classificacao();
        
        txt_codigo.setEditable(false);
        txt_data.setEditable(false);
        
        txt_pesquisa.setVisible(false);
        
        verificar_acesso();
        
        preencher_jtable();
        
        data_agora();
        tb_clientes.setAutoCreateRowSorter(true);
        trava_campos();
        
        /*String dia = ""+data.getDate();
        String mes = ""+String.valueOf(data.getMonth()+1);
        String ano = ""+(1900+data.getYear());
        if (Integer.parseInt(mes)<=9)
            mes = "0"+mes;
        txt_data.setText(dia+mes+ano);*/
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblDatadeCadastro = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        lbClassificacao = new javax.swing.JLabel();
        try {
            formatoData = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
        }
        txt_data = new JFormattedTextField(formatoData);
        txt_apelido = new javax.swing.JTextField();
        lbid = new javax.swing.JLabel();
        cb_classificacao = new javax.swing.JComboBox();
        lbOrganizar = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        try {
            formatoAtivada = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
        }
        txt_datainicio = new JFormattedTextField(formatoAtivada);
        lblDatadeCadastro1 = new javax.swing.JLabel();
        lblDatadeCadastro2 = new javax.swing.JLabel();
        try {
            formatoFim = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
        }
        txt_datafim = new JFormattedTextField(formatoFim);
        jPanel3 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_fechar = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novos Processos");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setPreferredSize(new java.awt.Dimension(700, 650));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        lblTitulo.setBackground(new java.awt.Color(245, 245, 245));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Processos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        lblNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNumero.setText("Nº Processo:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblDatadeCadastro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDatadeCadastro.setText("Data de Cadastro:");

        lbClassificacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbClassificacao.setText("Classificacao:");

        lbid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbid.setText("Apelido(ID):");

        lbOrganizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbOrganizar.setText("Pesquisar:");

        txt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisaActionPerformed(evt);
            }
        });

        lblDatadeCadastro1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDatadeCadastro1.setText("Ativada em:");

        lblDatadeCadastro2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDatadeCadastro2.setText("Finalizada em:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDatadeCadastro)
                    .addComponent(lbClassificacao)
                    .addComponent(lblNumero)
                    .addComponent(lbOrganizar)
                    .addComponent(lblNome))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbid)
                        .addGap(18, 18, 18)
                        .addComponent(txt_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDatadeCadastro1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_datainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDatadeCadastro2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_datafim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cb_classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOrganizar)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbid)
                        .addComponent(txt_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatadeCadastro)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_datainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatadeCadastro1)
                    .addComponent(lblDatadeCadastro2)
                    .addComponent(txt_datafim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbClassificacao)
                    .addComponent(cb_classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        bt_excluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_excluir.setText("Excluir");
        bt_excluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        bt_fechar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_fechar.setMaximumSize(new java.awt.Dimension(65, 30));
        bt_fechar.setMinimumSize(new java.awt.Dimension(65, 30));
        bt_fechar.setPreferredSize(new java.awt.Dimension(90, 40));
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });

        bt_novo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_novo.setText("Novo");
        bt_novo.setToolTipText("");
        bt_novo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_novo.setName(""); // NOI18N
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancelar.setMaximumSize(new java.awt.Dimension(65, 30));
        btn_cancelar.setMinimumSize(new java.awt.Dimension(65, 30));
        btn_cancelar.setPreferredSize(new java.awt.Dimension(90, 40));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlterar)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_excluir)
                .addGap(18, 18, 18)
                .addComponent(bt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_excluir, bt_fechar, bt_novo, btnAlterar, btnSalvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(bt_excluir)
                    .addComponent(bt_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_novo)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_excluir, bt_fechar, bt_novo, btnAlterar, btnSalvar});

        tb_clientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Apelido", "Nome", "Entrada", "Classificação", "Cadastrado por"
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
        tb_clientes.setOpaque(false);
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_clientes);
        if (tb_clientes.getColumnModel().getColumnCount() > 0) {
            tb_clientes.getColumnModel().getColumn(0).setResizable(false);
            tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_clientes.getColumnModel().getColumn(1).setPreferredWidth(75);
            tb_clientes.getColumnModel().getColumn(3).setResizable(false);
            tb_clientes.getColumnModel().getColumn(3).setPreferredWidth(75);
            tb_clientes.getColumnModel().getColumn(4).setPreferredWidth(90);
            tb_clientes.getColumnModel().getColumn(5).setPreferredWidth(100);
            tb_clientes.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(595, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        //*Quando clicado na linha da tabela, os dados serão enviados para os campos
        
        Integer linha =  tb_clientes.getSelectedRow();
        String codigo = (String)tb_clientes.getValueAt(linha, 0);
        String apelido = (String)tb_clientes.getValueAt(linha, 1);
        String nome = (String)tb_clientes.getValueAt(linha, 2);
        String data = (String)tb_clientes.getValueAt(linha, 3);
        String classificacao = (String)tb_clientes.getValueAt(linha, 4);
        
        //2012-00-09
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String recebeMysql = dia+mes+ano;
        
        txt_data.setText(recebeMysql);
        
       
        txt_codigo.setText(codigo);
        txt_nome.setText(nome);
        txt_apelido.setText(apelido);
        cb_classificacao.setSelectedItem(classificacao);
        
        if(!txt_codigo.getText().equals("")){
            
            try{
                con_cliente.executeSQL("select * from cadastrodeprocesso where codNumerodoprocesso="+txt_codigo.getText());   
                if(con_cliente.resultset.first()){

                    datainicio_backup = con_cliente.resultset.getString("DatadeAtivacao");
                    datafim_backup = con_cliente.resultset.getString("DataDeArquivamentodoProcesso");

                    if(datainicio_backup.length()==10 && !"1111-11-11".equals(datainicio_backup)){
                        String anoi = datainicio_backup.substring(0, 4);
                        String mesi = datainicio_backup.substring(5, 7);
                        String diai = datainicio_backup.substring(8);
                        String recebeinicio = diai+"/"+mesi+"/"+anoi;

                        txt_datainicio.setText(recebeinicio);

                    }
                    if(datafim_backup.length()==10 && !"1111-11-11".equals(datafim_backup)){
                        String anof = datafim_backup.substring(0, 4);
                        String mesf = datafim_backup.substring(5, 7);
                        String diaf = datafim_backup.substring(8);
                        String recebef = diaf+"/"+mesf+"/"+anof;

                        txt_datafim.setText(recebef);

                    }
                }
            }catch(Exception erro){
            }
        
    }
        
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    if(txt_data.getText().trim().length() != 10){
        JOptionPane.showMessageDialog(null, "Data informada esta invalida!");
    }
    else if(txt_nome.getText().trim().equals("")){
        JOptionPane.showMessageDialog(null, "Campo nome não pode ficar em branco!");
    }
    else if(txt_nome.getText().trim().length()>150){
        JOptionPane.showMessageDialog(null, "O nome do cliente excede o tamanho permitido de caracteres, \n Reduza o nome ou chame o suporte.");
    }
    else if(cb_classificacao.getSelectedItem().equals("")){
        JOptionPane.showMessageDialog(null, "Campo classificação não pode ficar em branco!");
    }
    else if(!txt_codigo.getText().equals("")){
        
        try{
            String str = txt_data.getText();  
            Date data = sdf.parse(str);
            
            String sql ="UPDATE cadastrodeprocesso SET Cliente ='"+txt_nome.getText()+"',"+
                    "Apelido = '" +txt_apelido.getText()+"',"+
                    "Datadecadastro = '" +new java.sql.Date(data.getTime())+"',"+
                    "Classificacao = '" +cb_classificacao.getSelectedItem()+"',"+
                    "Usuario = '" +Login.usuario+
                    "' where codNumerodoprocesso = "+txt_codigo.getText();
            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Alteração realizado com sucesso!");
            
            enviar_data1();
            enviar_data2();
            
            limpar_tabela();
            preencher_jtable();
            
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro a tentar Alterar o registro..."+erro);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Problema na tentativa de conversão de data, contate o suporte!" +ex);
        }
        
    }
    else if (txt_codigo.getText().equals("")){ 
        
        try{
            String str = txt_data.getText();  
            Date data = sdf.parse(str);
            String gry = "insert into cadastrodeprocesso (Apelido, Datadecadastro,"
                    + " Cliente, Classificacao, Usuario, "
                    + "AndamentoComercial, AndamentoFinanceiro, AndamentoContratos,"
                    + "AndamentoDP,AndamentoContabil, AndamentoFiscal, AndamentoRegularizacao) values ('"+
                            txt_apelido.getText()+"','"+
                            new java.sql.Date(data.getTime())+"','"+
                            txt_nome.getText()+"','"+
                            cb_classificacao.getSelectedItem()+"','"+
                            Login.usuario+"','"
                    + "Em Aberto', 'Em Aberto', 'Em Aberto', 'Em Aberto', 'Em Aberto', 'Em Aberto', 'Em Aberto')";
                                
                con_cliente.exeQuery(gry);
                expandir_cadastro();
                enviar_data1();
                enviar_data2();
                
                limpar_tabela();
                //atualizando tabela
                preencher_jtable();
            
                JOptionPane.showMessageDialog(null,"Gravado com sucesso!");
                }catch(ParseException | HeadlessException add){
                         JOptionPane.showMessageDialog(null,"Falha ao gravar o registro: " +add);
                }
        
    }
    trava_campos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        cria_backup();
        limpar_tela();
        destrava_campos();        
    }//GEN-LAST:event_bt_novoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        cria_backup();
        destrava_campos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        if(txt_codigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Para realizar a exclusão, por favor selecione um registro!");
        }
        else{
            
            try{
                String sql = "select * from cadastrodeprocesso where codNumerodoprocesso=" +txt_codigo.getText();
                con_cliente.executeSQL(sql);
                con_cliente.resultset.first();
                String nome = "Tem certeza que deseja excluir o cadastro do cliente " +con_cliente.resultset.getString("Cliente")+"?";
                int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"Exclusão ",JOptionPane.YES_NO_OPTION);
                if (opcao_escolhida == JOptionPane.YES_OPTION)
                {
                    String aviso = "Ao excluir esse registro, irá afetar todo os processos desse cliente, \n"
                            +"essa exclusão será irreparável  e um registro dessa tentativa será salvo!\n"
                            +"Mesmo assim você deseja continuar?";
                    int opcao_aviso = JOptionPane.showConfirmDialog(null, aviso, "Atenção!", JOptionPane.OK_CANCEL_OPTION);
                    
                    if(opcao_aviso == JOptionPane.YES_OPTION){
                        sql = "DELETE FROM cadastrodeprocesso Where codNumerodoprocesso ="+txt_codigo.getText();
                            int conseguiu_excluir = con_cliente.statement.executeUpdate(sql);
                            if (conseguiu_excluir == 1)
                            {
                            JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso");
                            //disparar e-mail para administradores alertando exclusão
                            AlertaExclusao alerta = new AlertaExclusao();
                            alerta.destino = "tiago.dias@prolinkcontabil.com.br";
                            alerta.assunto = "Controle de Processos - Cadastro Excluido";
                            alerta.mensagem = "Olá,\n Se você recebeu essa mensagem significa que "+Login.usuario+" realizou uma tentativa de exclusão"+
                                    " no cliente abaixo \n Nome:"+nome+" \nProcesso: "+txt_codigo.getText()+
                                    "\n Todos os registros desse cliente foram perdidos!";
                            
                            limpar_tabela();
                            preencher_jtable();
                            limpar_tela();
                            data_agora();
                            }
                    }
                }
            }
            catch (SQLException erro)
            {
                    JOptionPane.showMessageDialog(null,"Erro a tentar excluir o registro..."+erro);
            }
            
        }
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed
        limpar_tabela();
        try{
            
            String pesquisa = "select * from cadastrodeprocesso where Cliente like '"+txt_pesquisa.getText()+"%' order by Cliente";
            con_cliente.executeSQL(pesquisa);
            if(con_cliente.resultset.first())
            {
                
                preencher_jtable_nome();
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Não existe registro com as letras "+txt_pesquisa.getText().toUpperCase());
                
            }
        }catch(SQLException | HeadlessException erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel localizar os dados via digitação..."+erro);
        }
         
    }//GEN-LAST:event_txt_pesquisaActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        restaura_backup();
        trava_campos();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClientes().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JComboBox cb_classificacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbClassificacao;
    private javax.swing.JLabel lbOrganizar;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lblDatadeCadastro;
    private javax.swing.JLabel lblDatadeCadastro1;
    private javax.swing.JLabel lblDatadeCadastro2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTextField txt_apelido;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JFormattedTextField txt_data;
    private javax.swing.JFormattedTextField txt_datafim;
    private javax.swing.JFormattedTextField txt_datainicio;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
    /**
     *
     */
    public void atualiza_combo_box_classificacao()
    {
        con_classificacao.conecta();
        try
        {
            cb_classificacao.removeAllItems();
            con_classificacao.executeSQL("select * from classificacao order by Status");
            while(con_classificacao.resultset.next())
                cb_classificacao.addItem(con_classificacao.resultset.getString("Status"));
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"Não localizou dados na tabela classificacao!"+erro);
        }
        con_classificacao.desconecta();
        
    }

    /**
     *
     */
    public void preencher_jtable_nome()
{
        tb_clientes.getColumnModel().getColumn(0);
        tb_clientes.getColumnModel().getColumn(1);
        tb_clientes.getColumnModel().getColumn(2);
        tb_clientes.getColumnModel().getColumn(3);
        tb_clientes.getColumnModel().getColumn(4);
        tb_clientes.getColumnModel().getColumn(5);

        DefaultTableModel modelo = (DefaultTableModel)tb_clientes.getModel();
        //modelo.setNumRows(0);
        
        try
        {
        while (con_cliente.resultset.next())
                modelo.addRow(new Object [] {
                    con_cliente.resultset.getString("codNumerodoprocesso"),
                    con_cliente.resultset.getString("Apelido"),
                    con_cliente.resultset.getString("Cliente"),
                    sdf.format(con_cliente.resultset.getDate("Datadecadastro")),
                    con_cliente.resultset.getString("Classificacao"),                    
                    con_cliente.resultset.getString("Usuario")});
            con_cliente.resultset.first();
        }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar no JTable "+erro);
}
}

    /**
     *
     */
    public void preencher_jtable()
{
        
        tb_clientes.getColumnModel().getColumn(0);
        tb_clientes.getColumnModel().getColumn(1);
        tb_clientes.getColumnModel().getColumn(2);
        tb_clientes.getColumnModel().getColumn(3);
        tb_clientes.getColumnModel().getColumn(4);
        tb_clientes.getColumnModel().getColumn(5);

        con_cliente.executeSQL("select * from cadastrodeprocesso order by codNumerodoprocesso");
        
        DefaultTableModel modelo = (DefaultTableModel)tb_clientes.getModel();
        //modelo.setNumRows(0);
        try
        {
            while (con_cliente.resultset.next())
                modelo.addRow(new Object [] {
                    con_cliente.resultset.getString("codNumerodoprocesso"),
                    con_cliente.resultset.getString("Apelido"),
                    con_cliente.resultset.getString("Cliente"),
                    sdf.format(con_cliente.resultset.getDate("Datadecadastro")),
                    con_cliente.resultset.getString("Classificacao"),                    
                    con_cliente.resultset.getString("Usuario")});
           
            con_cliente.resultset.first();
        }
catch (SQLException erro){
    JOptionPane.showMessageDialog(null,"Erro ao listar na tabela! "+erro);
}
}

    /**
     *
     */
    public void limpar_tabela()
{
    DefaultTableModel tbm = (DefaultTableModel)tb_clientes.getModel();
        for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
}
}

    /**
     *
     */
    public void trava_campos(){
    txt_apelido.setEditable(false);
    txt_codigo.setEditable(false);
    txt_nome.setEditable(false);
    cb_classificacao.setEditable(false);
    txt_data.setEditable(false);
    txt_datainicio.setEditable(false);
    txt_datafim.setEditable(false);
}

    /**
     *
     */
    public void destrava_campos(){
    txt_pesquisa.setEditable(false);
    txt_apelido.setEditable(true);
    txt_nome.setEditable(true);
    cb_classificacao.setEditable(true);
    txt_data.setEditable(true);
    txt_datainicio.setEditable(true);
    txt_datafim.setEditable(true);
}

    /**
     *
     */
    public void limpar_tela(){
    txt_pesquisa.setEditable(false);
    txt_apelido.setText("");
    txt_codigo.setText("");
    txt_nome.setText("");
    cb_classificacao.setSelectedItem("");
    data_agora();
    txt_datafim.setText("");
    txt_datainicio.setText("");
}

    /**
     *
     */
    public void cria_backup(){
    codigo_backup = txt_codigo.getText();
    apelido_backup = txt_apelido.getText();
    nome_backup = txt_nome.getText();
    classificacao_backup = (String)cb_classificacao.getSelectedItem();
    data_backup = txt_data.getText();
    if(txt_datainicio.getText().trim().length()==10){
        datainicio_backup = txt_datainicio.getText();
    }
    else
        datainicio_backup = "";
    if(txt_datafim.getText().trim().length()==10){
        datafim_backup = txt_datafim.getText();
    }
    else
        datafim_backup = "";
    }

    /**
     *
     */
    public void restaura_backup(){
    txt_apelido.setText(apelido_backup);
    txt_codigo.setText(codigo_backup);
    txt_nome.setText(nome_backup);
    cb_classificacao.setSelectedItem(classificacao_backup);
    txt_data.setText(data_backup);
    if(datainicio_backup.trim().length()==10){
        txt_datainicio.setText(datainicio_backup);
    }
    if(datafim_backup.trim().length()==10){
        txt_datafim.setText(datafim_backup);
    }
}

    /**
     *
     */
    public void data_agora(){
    Date data = new Date(); // pega a data atual
    String datatela = sdf.format(data);
    txt_data.setText(datatela);
}
    public void verificar_acesso(){
        if(!Login.nivel.equals("1") && !Login.departamento.equalsIgnoreCase("Comercial")){
            btnAlterar.setEnabled(false);
            btnSalvar.setEnabled(false);
            bt_excluir.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Você não tem autorização para incluir/alterar/excluir processos!\n"
                                                +"Essa tela é reservada ao setor Comercial e Coordenação!");
        }
    }
    public void expandir_cadastro(){
    try{
        
        String str = txt_data.getText();
        Date data = sdf.parse(str);
        
        con_cliente.executeSQL("select * from cadastrodeprocesso order by codNumerodoprocesso desc limit 1");
            if(con_cliente.resultset.first()){
                    txt_codigo.setText(con_cliente.resultset.getString("codNumerodoprocesso"));
                    //Inserir o codigo do cliente nas tabelas
                    con_cliente.exeQuery("insert into comercial (AndamentoTaxaDeImplantacaoEFormaDePagamento,AndamentoGravarSenhasFiscais,"
                                    + "AndamentoGerarOS,AndamentoEnviarTermoResponsaparacliente,AndamentoPropastaComercial,"
                                    + "AndamentoEnvioDiagnose,AndamentoChekList,AndamentoPesquisaFiscal,AndamentoRequisicaoDocumentos,"
                                    + "AndamentoConfirmarRecebimentoDeposito,Numerodoprocesso, DataCadastroProcesso) "
                                    + "values ('Em Aberto','Em Aberto','Em Aberto','Em Aberto',"
                                    + "'Em Aberto','Em Aberto','Em Aberto','Em Aberto','Em Aberto','Em Aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                                        
                    con_cliente.exeQuery("insert into contabil (AndamentoGerarPlanoDeContas,Numerodoprocesso,DataCadastroProcesso)"
                                    + " values ('Em aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                    con_cliente.exeQuery("insert into contratos (AndamentoElaborarContratoPrestacaoDeServico, AndamentoCadastrarControlEContmatic, "
                                    + "AndamentoAtivarCliente, AndamentoElaborarPrefilFiscal, AndamentoReceberContratoAssCliente, "
                                    + "AndamentoGerarIDPlanCadastro, Numerodoprocesso, DataCadastroProcesso)"
                                    + " values ('Em Aberto','Em Aberto','Em Aberto','Em Aberto','Em Aberto','Em Aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                    con_cliente.exeQuery("insert into fiscal (AndamenoDistribuirFuncionarioInterno,AndamentoValidarPerfilFiscal,Numerodoprocesso,"
                                    + "DataCadastroProcesso) values ('Em Aberto','Em Aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                    con_cliente.exeQuery("insert into financeiro (AndamentoLancamentodeDadosPlanCobranca,AndamentoEmissaoBoleto,"
                                    + "AndamentoEntrarNoControlControleDoOs,Numerodoprocesso,DataCadastroProcesso) "
                                    + "values ('Em Aberto','Em Aberto','Em Aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                    con_cliente.exeQuery("insert into regularizacao (AndamentoEnviarTernoReponsaParaComercial,AndamentoArquivarProcesso,"
                                    + "Numerodoprocesso,DataCadastroProcesso) values ('Em Aberto', 'Em Aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                    con_cliente.exeQuery("insert into dp (AndamentoCadastroDoSocioNoControl,AndamentoCadastroDependentesdoSocioADM,"
                                    + "AndamentoIplantacaodadosFolhaPg,Numerodoprocesso,DataCadastroProcesso) "
                                    + "values ('Em Aberto','Em Aberto','Em Aberto',"
                                    + txt_codigo.getText()+",'"
                                    + new java.sql.Date(data.getTime())+"')");
                    con_cliente.exeQuery("insert into acompanhamentodeenvios (Numerodoprocesso) values ("
                                    +txt_codigo.getText()+")");
                    con_cliente.exeQuery("insert into documentos (Numerodoprocesso) values ("+txt_codigo.getText()+")");
                        }
    }catch(ParseException | SQLException add){
    JOptionPane.showMessageDialog(null, "Erro ao distribuir cadastro, chame o suporte :\n");   
    }
    }
    public void enviar_data1(){
        if(txt_datainicio.getText().trim().length()==10){
            
            
            try{
                String st = txt_datainicio.getText();
                Date data1 = sdf.parse(st);
                
                con_cliente.statement.executeUpdate("update cadastrodeprocesso "
                        + "set DatadeAtivacao='"+ new java.sql.Date(data1.getTime())+
                        "' where codNumerodoprocesso="+txt_codigo.getText());
            }catch(Exception erro){
            }  
        }
    }
    public void enviar_data2(){
        if(txt_datafim.getText().trim().length()==10){
            
            
            try{
                String st = txt_datafim.getText();
                Date data1 = sdf.parse(st);
                
                con_cliente.statement.executeUpdate("update cadastrodeprocesso "
                        + "set DataDeArquivamentodoProcesso='"+ new java.sql.Date(data1.getTime())+
                        "' where codNumerodoprocesso="+txt_codigo.getText());
            }catch(Exception erro){
            }  
        }
    }
}
