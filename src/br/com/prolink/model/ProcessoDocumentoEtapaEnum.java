/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

/**
 *
 * @author tiago
 */
public enum ProcessoDocumentoEtapaEnum {
    ETAPA1("Enviado para o Cliente"),
    ETAPA2("Aguardando Validação"),
    ETAPA3("Validação Efetuada");
    
    private String descricao;
    private ProcessoDocumentoEtapaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
