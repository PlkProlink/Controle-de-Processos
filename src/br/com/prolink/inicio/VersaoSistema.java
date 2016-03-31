package br.com.prolink.inicio;

/**
 *
 * @author Tiago
 */
public class VersaoSistema {
    
    private String versaoSistema="2.1.16";
    private String baseDados= "2.0.2";
    /*
    Historico de versões
    2.0 - Projeto entregue
    2.1 - Correção na listagem
    2.1.1 - Correção na tela Documentos
    2.1.2 - Corrigido erros nas telas internas de Documentos(25 telas)
    2.1.3 - Correção na tela Documentos Enviados
    2.1.4 - Correção de erros nas telas internas de Documentos Enviados
    2.1.6 - Aplicando cores na LIstagem
    2.1.15- Graficos em Documentos Recebidos e Confirmação, Nova Tela de Encaminhamento + Telas Interna
    Encaminhar e Contestar
    2.1.16 - Correção na tela ativador
    2.1.17 - Correção em telas Documentos Enviados
    
    Orientação a objetos em telas internas de Documentos e Documentos Enviados
    Orientação a objetos em Listagem de documentos
    Relatorios em Documentos e Documentos Enviados (array de objetosl)
    */
    
    
    public String getVersao(){
    
        return versaoSistema;
    }
    public String getVersaoBanco(){
        return baseDados;
    }
}
