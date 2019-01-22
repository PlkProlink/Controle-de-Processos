/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.prolink.inicio.administracaoAlertas;

/**
 *
 * @author Tiago
 */
public class ClienteBean {
    private String apeligo;
    private int codigo;
    private String nome;
    private RelacaoBean relacaoBean;

    /**
     * @return the apeligo
     */
    public String getApeligo() {
        return apeligo;
    }

    /**
     * @param apeligo the apeligo to set
     */
    public void setApeligo(String apeligo) {
        this.apeligo = apeligo;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the relacaoBean
     */
    public RelacaoBean getRelacaoBean() {
        return relacaoBean;
    }

    /**
     * @param relacaoBean the relacaoBean to set
     */
    public void setRelacaoBean(RelacaoBean relacaoBean) {
        this.relacaoBean = relacaoBean;
    }
            
}
