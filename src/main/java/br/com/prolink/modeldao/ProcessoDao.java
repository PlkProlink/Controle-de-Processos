/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.modeldao;

import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.factory.ConfigTables;
import br.com.prolink.model.Processo;
import br.com.prolink.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class ProcessoDao implements InterfaceDao,ConfigTables{

    @Override
    public Connection pegarConexao() {
        return ConexaoStatement.getInstance().getConnetion();
    }

    @Override
    public void fecharConexao(Connection con) {
            try{if(con!=null)con.close();
        }catch(SQLException e){}
    }

    @Override
    public Object retornaClasse(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List processar(String sql){
        Connection con = pegarConexao();
        List lista = new ArrayList<>();
        try{
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Processo p = new Processo();
                    p.setId(rs.getInt(CADASTRODEPROCESSO_codNumerodoprocesso));
                    p.setApelido(rs.getString(CADASTRODEPROCESSO_Apelido));
                    p.setDataCadastro(rs.getDate(CADASTRODEPROCESSO_Datadecadastro));
                    p.setCliente(rs.getString(CADASTRODEPROCESSO_Cliente));
                    p.setEmail(rs.getString(CADASTRODEPROCESSO_Email));
                    p.setClassificacao(rs.getString(CADASTRODEPROCESSO_Classificacao));
                    p.setAndamentoComercial(rs.getString(CADASTRODEPROCESSO_AndamentoComercial));
                    p.setAndamentoFinanceiro(rs.getString(CADASTRODEPROCESSO_AndamentoFinanceiro));
                    p.setAndamentoContratos(rs.getString(CADASTRODEPROCESSO_AndamentoContratos));
                    p.setAndamentoDP(rs.getString(CADASTRODEPROCESSO_AndamentoDP));
                    p.setAndamentoContabil(rs.getString(CADASTRODEPROCESSO_AndamentoContabil));
                    p.setAndamentoFiscal(rs.getString(CADASTRODEPROCESSO_AndamentoFiscal));
                    p.setAndamentoRegularizacao(rs.getString(CADASTRODEPROCESSO_AndamentoRegularizacao));
                    p.setAcompanhamentoEnvios(rs.getString(CADASTRODEPROCESSO_AcompanhamentodeEnvios));
                    p.setAndamentoDocumentos(rs.getString(CADASTRODEPROCESSO_AndamentoDocumentos));
                    p.setObservacao(rs.getString(CADASTRODEPROCESSO_Observacao));
                    p.setDataAtivacao(rs.getDate(CADASTRODEPROCESSO_DatadeAtivacao));
                    p.setDataArquivamentoProcesso(rs.getDate(CADASTRODEPROCESSO_DataDeArquivamentodoProcesso));
                    
                    Usuario u = new Usuario();
                    u.setUsuario(rs.getString(CADASTRODEPROCESSO_Usuario));
                    p.setUsuario(u);
                    p.setSituacao(rs.getInt(CADASTRODEPROCESSO_Situacao));
                    lista.add(p);
                } 
                return lista;
        }catch(SQLException | NullPointerException ex){
            ex.printStackTrace();
            return null;
        }finally{fecharConexao(con);}
    }
    
    @Override
    public List listar() {
        return processar("SELECT * FROM "+CADASTRODEPROCESSO+" where "+CADASTRODEPROCESSO_Situacao+"=1");
    }
    @Override
    public boolean deletar(Object o) {
        return false;
    }

    @Override
    public boolean atualizar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List filtrar(String sql) {
        return processar(sql);
    }
    }
