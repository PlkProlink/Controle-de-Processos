/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Processo implements Serializable {

    private int id;
    private String apelido;
    private Date dataCadastro;
    private String cliente;
    private String email;
    private String classificacao;
    private String andamentoComercial;
    private String andamentoFinanceiro;
    private String andamentoContratos;
    private String andamentoDP;
    private String andamentoContabil;
    private String andamentoFiscal;
    private String andamentoRegularizacao;
    private String acompanhamentoEnvios;
    private String andamentoDocumentos;
    private String observacao;
    private Date dataAtivacao;
    private Date dataArquivamentoProcesso;
    private Usuario usuario;
    private int numeroProcesso;
    private int situacao;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the classificacao
     */
    public String getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the andamentoComercial
     */
    public String getAndamentoComercial() {
        return andamentoComercial;
    }

    /**
     * @param andamentoComercial the andamentoComercial to set
     */
    public void setAndamentoComercial(String andamentoComercial) {
        this.andamentoComercial = andamentoComercial;
    }

    /**
     * @return the andamentoFinanceiro
     */
    public String getAndamentoFinanceiro() {
        return andamentoFinanceiro;
    }

    /**
     * @param andamentoFinanceiro the andamentoFinanceiro to set
     */
    public void setAndamentoFinanceiro(String andamentoFinanceiro) {
        this.andamentoFinanceiro = andamentoFinanceiro;
    }

    /**
     * @return the andamentoContratos
     */
    public String getAndamentoContratos() {
        return andamentoContratos;
    }

    /**
     * @param andamentoContratos the andamentoContratos to set
     */
    public void setAndamentoContratos(String andamentoContratos) {
        this.andamentoContratos = andamentoContratos;
    }

    /**
     * @return the andamentoDP
     */
    public String getAndamentoDP() {
        return andamentoDP;
    }

    /**
     * @param andamentoDP the andamentoDP to set
     */
    public void setAndamentoDP(String andamentoDP) {
        this.andamentoDP = andamentoDP;
    }

    /**
     * @return the andamentoContabil
     */
    public String getAndamentoContabil() {
        return andamentoContabil;
    }

    /**
     * @param andamentoContabil the andamentoContabil to set
     */
    public void setAndamentoContabil(String andamentoContabil) {
        this.andamentoContabil = andamentoContabil;
    }

    /**
     * @return the andamentoFiscal
     */
    public String getAndamentoFiscal() {
        return andamentoFiscal;
    }

    /**
     * @param andamentoFiscal the andamentoFiscal to set
     */
    public void setAndamentoFiscal(String andamentoFiscal) {
        this.andamentoFiscal = andamentoFiscal;
    }

    /**
     * @return the andamentoRegularizacao
     */
    public String getAndamentoRegularizacao() {
        return andamentoRegularizacao;
    }

    /**
     * @param andamentoRegularizacao the andamentoRegularizacao to set
     */
    public void setAndamentoRegularizacao(String andamentoRegularizacao) {
        this.andamentoRegularizacao = andamentoRegularizacao;
    }

    /**
     * @return the acompanhamentoEnvios
     */
    public String getAcompanhamentoEnvios() {
        return acompanhamentoEnvios;
    }

    /**
     * @param acompanhamentoEnvios the acompanhamentoEnvios to set
     */
    public void setAcompanhamentoEnvios(String acompanhamentoEnvios) {
        this.acompanhamentoEnvios = acompanhamentoEnvios;
    }

    /**
     * @return the andamentoDocumentos
     */
    public String getAndamentoDocumentos() {
        return andamentoDocumentos;
    }

    /**
     * @param andamentoDocumentos the andamentoDocumentos to set
     */
    public void setAndamentoDocumentos(String andamentoDocumentos) {
        this.andamentoDocumentos = andamentoDocumentos;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the dataAtivacao
     */
    public Date getDataAtivacao() {
        return dataAtivacao;
    }

    /**
     * @param dataAtivacao the dataAtivacao to set
     */
    public void setDataAtivacao(Date dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    /**
     * @return the dataArquivamentoProcesso
     */
    public Date getDataArquivamentoProcesso() {
        return dataArquivamentoProcesso;
    }

    /**
     * @param dataArquivamentoProcesso the dataArquivamentoProcesso to set
     */
    public void setDataArquivamentoProcesso(Date dataArquivamentoProcesso) {
        this.dataArquivamentoProcesso = dataArquivamentoProcesso;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the numeroProcesso
     */
    public int getNumeroProcesso() {
        return numeroProcesso;
    }

    /**
     * @param numeroProcesso the numeroProcesso to set
     */
    public void setNumeroProcesso(int numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    /**
     * @return the situacao
     */
    public int getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

}
