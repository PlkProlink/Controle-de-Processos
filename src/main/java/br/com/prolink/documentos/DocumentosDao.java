/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos;

import br.com.prolink.factory.Conexao;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.Processo;
import br.com.prolink.model.ProcessoLogado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Tiago Dias
 */
public class DocumentosDao {
    Connection con;
    private Connection getConnection(){
        this.con = ConexaoStatement.getInstance().getConnetion();
        return this.con;
    }
    Processo p = ProcessoLogado.getInstance().getProcesso();
    String processo=p.getId()+"";    
}