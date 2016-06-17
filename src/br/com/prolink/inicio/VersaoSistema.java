package br.com.prolink.inicio;

/**
 *
 * @author Tiago
 */
public class VersaoSistema {
    
    private String versaoSistema="2.1.39 Beta";
    private String baseDados= "2.0.5";
    /*
    Historico de versões
    2.0 - Projeto entregue
    2.1 - Correção na listagem
    2.1.1 - Correção na tela Documentos
    2.1.2 - Corrigido erros nas telas internas de Documentos(25 telas)
    2.1.3 - Correção na tela Documentos Enviados
    2.1.4 - Correção de erros nas telas internas de Documentos Enviados
    2.1.6 - Aplicando cores na Listagem
    2.1.15- Graficos em Documentos Recebidos e Confirmação, 
    Nova Tela de Encaminhamento + Telas Interna Encaminhar e Contestar
    2.1.16 - Correção na tela ativador
    2.1.32 - Correção em telas Documentos Enviados +16 Telas
    2.1.33 - Alterações no trabalho com alertas em Recepcao de Documentos 
    prevenção no erro do servidor de e-mail
    
    2.1.34 - Criação da coluna AndamentoDocumentos em cadastrodeprocesso,
    Habilitação da função atualizar status
    2.1.35 - Inserir nova coluna no ativador AndamentoDocumentos
    2.1.36 - Habilitando função desativar cliente em Cadastro de Cliente
    2.1.37 - Removido Botoes e Logomarca na tela inicial
    2.1.38 - Correções nas telas de admnistração e documentos
    2.1.39 - Atualização na tela Visao Geral, e criação da Tela de Acessos
    2.1.44 - Novas telas para Relatorios
    
    Relatorios em Documentos e Documentos Enviados (array de objetos)
    
    Orientação a objetos em telas internas de Documentos e Documentos Enviados
    Orientação a objetos em Listagem de documentos
    
    Alterado nomeclatura de todas as tabelas e colunas
    Aplicado MVC no projeto
    Migração de base de dados (MYSQL para Postgresql)
    
    */
    
    
    public String getVersao(){
    
        return versaoSistema;
    }
    public String getVersaoBanco(){
        return baseDados;
    }
}
