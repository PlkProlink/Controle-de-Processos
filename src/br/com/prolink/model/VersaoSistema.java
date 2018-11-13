package br.com.prolink.model;

/**
 *
 * @author Tiago
 */
public class VersaoSistema {
    
    private final String versaoSistema="2.2.7";
    private final String baseDados= "2.0.6";
    /*
    Historico de versões
    2.0 - Projeto entregue
    2.1 - Correção na listagem
    2.1.1 - Correção na tela Documentos
    2.1.2 - Corrigido erros nas telas internas de Documentos(25 telas)
    2.1.3 - Correção na tela Documentos Enviados
    2.1.4 - Correção de erros nas telas internas de Documentos Enviados
    2.1.6 - Aplicando cores na Listagem
    2.1.15- Graficos em Documentos Recebidos e Confirmação,Nova Tela de Encaminhamento + Telas Interna Encaminhar e Contestar
    2.1.16 - Correção na tela ativador
    2.1.32 - Correção em telas Documentos Enviados +16 Telas
    2.1.33 - Alterações no trabalho com alertas em Recepcao de Documentos 
    prevenção no erro do servidor de e-mail
    2.1.34 - Criação da coluna AndamentoDocumentos em cadastrodeprocesso
    Habilitação da função atualizar status
    2.1.35 - Inserir nova coluna no ativador AndamentoDocumentos
    2.1.36 - Habilitando função desativar cliente em Cadastro de Cliente
    2.1.37 - Removido Botoes e Logomarca na tela inicial
    2.1.38 - Correções nas telas de admnistração e documentos
    2.1.39 - Atualização na tela Visao Geral, e criação da Tela de Acessos
    2.1.40 - Trava na tela de relatorios que inabilita envio de documentos que não estão pendentes
    2.1.41 - Inserido JDialog com calendario em Documentos/Internas/Form Modelo solicitado pela Monary
    2.1.42 - Trocando Calendario com.toedter.calendar.JCalendar para com.towel.swing.calendar.CalendarView;
    2.1.43 - Inserido filtros na tela de cadastro de processos, executar listagem ao abrir menu,melhorado design das tabelas Listagem e Recepção
    2.1.44 - com.towel.swing.calendar.CalendarView deu problema, retomando para com.toedter.calendar.JCalendar
    2.1.45 - Corrigido bug na tela ControleRecepcao
    Relatorios em Documentos e Documentos Enviados (array de objetos)
    2.1.46 - Iniciando manipulação com protocolos 
    2.1.47 - Inserido classe autocomplete
    2.1.48, 49, 50 - Inserindo JavaFX
    2.1.51 - Alteração classe conexao em cadastro de clientes para Statement
    2.2.0 - Aplicado atualização de conexao na tela de documentos e telas internas, ajustes
    2.2.1 - Bug que impedia a classes documentos de ser aberta, sqlexception alterada para exception
    2.2.2 - Efeitos JFoenix
    2.2.3  - Alterando botoes e inserindo grafico de pizza em Documentos Recebidos, Decorator
    2.2.4 - Alterado metodo de conexao em documentos enviados.
    2.2.5 - Removido bug na tela de Protocolo de Entrada
    2.2.6 - Protocolo de Entrada - Corrigindo bug que nao alterava a opção passivel de devolução quando era negativo
    Melhorado relatorio de pendencias via e-mail, melhoria no processo de envio.
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
