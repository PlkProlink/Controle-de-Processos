/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.modeldao;

import java.sql.Connection;
import javafx.collections.ObservableList;

/**
 *
 * @author Tiago
 */
public interface InterfaceFXDao {
    public Connection pegarConexao();
    public void fecharConexao(Connection con);
    public Object retornaClasse(int id);
    
    public ObservableList<Object> listar();

    public boolean deletar(Object o);

    public boolean atualizar(Object o);

    public boolean inserir(Object o);
}
