package br.com.prolink.view.interfaces;

import javafx.collections.ObservableList;

public interface InterfaceBanco {

    public Object retornaClasse();

    public ObservableList<Object> listar();

    public boolean deletar(Object o);

    public boolean atualizar(Object o);

    public boolean inserir(Object o);
}
