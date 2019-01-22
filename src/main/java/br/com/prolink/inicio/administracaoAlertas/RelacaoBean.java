/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

/**
 *
 * @author Tiago
 */
public class RelacaoBean {
    
    private int contagemDocumentos;
    private int contagemDepartamento;
    private int contagemTudo;
    //montar texto/detalhes dos documentos
    
    //montar interior tabelas
    private String textoDocumentos="";
    private String textoDepartamento="";

    //montando tabelas para html
    private String tabelaContagem="";
    private String tabelaDepartamento="";
    private String tabelaDocumentos="";
    
    /**
     * @return the contagemDocumentos
     */
    public int getContagemDocumentos() {
        return contagemDocumentos;
    }

    /**
     * @param contagemDocumentos the contagemDocumentos to set
     */
    public void setContagemDocumentos(int contagemDocumentos) {
        this.contagemDocumentos = contagemDocumentos;
    }

    /**
     * @return the contagemDepartamento
     */
    public int getContagemDepartamento() {
        return contagemDepartamento;
    }

    /**
     * @param contagemDepartamento the contagemDepartamento to set
     */
    public void setContagemDepartamento(int contagemDepartamento) {
        this.contagemDepartamento = contagemDepartamento;
    }

    /**
     * @return the contagemTudo
     */
    public int getContagemTudo() {
        return contagemTudo;
    }

    /**
     * @param contagemTudo the contagemTudo to set
     */
    public void setContagemTudo(int contagemTudo) {
        this.contagemTudo = contagemTudo;
    }

    /**
     * @return the textoDocumentos
     */
    public String getTextoDocumentos() {
        return textoDocumentos;
    }

    /**
     * @param textoDocumentos the textoDocumentos to set
     */
    public void setTextoDocumentos(String textoDocumentos) {
        this.textoDocumentos = textoDocumentos;
    }

    /**
     * @return the textoDepartamento
     */
    public String getTextoDepartamento() {
        return textoDepartamento;
    }

    /**
     * @param textoDepartamento the textoDepartamento to set
     */
    public void setTextoDepartamento(String textoDepartamento) {
        this.textoDepartamento = textoDepartamento;
    }

    /**
     * @return the tabelaContagem
     */
    public String getTabelaContagem() {
        return tabelaContagem;
    }

    /**
     * @param tabelaContagem the tabelaContagem to set
     */
    public void setTabelaContagem(String tabelaContagem) {
        this.tabelaContagem = tabelaContagem;
    }

    /**
     * @return the tabelaDepartamento
     */
    public String getTabelaDepartamento() {
        return tabelaDepartamento;
    }

    /**
     * @param tabelaDepartamento the tabelaDepartamento to set
     */
    public void setTabelaDepartamento(String tabelaDepartamento) {
        this.tabelaDepartamento = tabelaDepartamento;
    }

    /**
     * @return the tabelaDocumentos
     */
    public String getTabelaDocumentos() {
        return tabelaDocumentos;
    }

    /**
     * @param tabelaDocumentos the tabelaDocumentos to set
     */
    public void setTabelaDocumentos(String tabelaDocumentos) {
        this.tabelaDocumentos = tabelaDocumentos;
    }
    
}
