/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

/**
 *
 * @author Tiago
 */
public class UsuarioLogado {
    private static UsuarioLogado instance;
    private static Usuario usuario;
    public static UsuarioLogado getInstance(){
        if(instance==null)
            instance=new UsuarioLogado();
        return instance;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public void setUsuario(Usuario aUsuario) {
        usuario = aUsuario;
    }
}
