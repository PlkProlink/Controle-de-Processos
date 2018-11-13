/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.factory.ConfigTables;
import static br.com.prolink.factory.ConfigTables.CLIENTE;
import static br.com.prolink.factory.ConfigTables.CLIENTE_id;
import static br.com.prolink.factory.ConfigTables.CLIENTE_nome;
import static br.com.prolink.factory.ConfigTables.CLIENTE_cnpj;
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
public class ClienteDao implements InterfaceDao,ConfigTables{

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
    @Override
    public List listar() {
        Connection con = pegarConexao();
        List lista = new ArrayList<>();
        try{
            String sql = "select * from "+CLIENTE+" order by "+CLIENTE_id;
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt(CLIENTE_id));
                    cliente.setNome(rs.getString(CLIENTE_nome));
                    cliente.setStatus(rs.getString(CLIENTE_status));
                    cliente.setCnpj(rs.getString(CLIENTE_cnpj));
                    lista.add(cliente);
                } 
                return lista;
        }catch(SQLException | NullPointerException ex){
            ex.printStackTrace();
            return null;
        }finally{fecharConexao(con);}
    }

    @Override
    public boolean deletar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean atualizar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
