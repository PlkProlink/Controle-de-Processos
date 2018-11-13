drop table boletoplkacompanhamento;
drop table dasacompanhamento;
drop table pisacompanhamento;
drop table irpjacompanhamento;
drop table csllacompanhamento;
drop table issacompanhamento;
drop table gpsacompanhamento;
drop table irpfsobresalarioacompanhamento;
drop table irpfsobreservicotomadoacompanhamento;
drop table fgtsacompanhamento;
drop table icmsacompanhamento;
drop table ipiacompanhamento;
drop table icmsservtomacompanhamento;
drop table acompanhamentodeenvios;

CREATE TABLE processo_documento (
	id INT(11) AUTO_INCREMENT,
	criado_em DATE,
	processo_id INT(11),
	usuario VARCHAR(50),
	observacao text,
	data_andamento DATE,
	andamento text,
	evento varchar(100),
	PRIMARY KEY (id)
);

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'AFASTAMENTO'
from afastamento as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','AFASTAMENTO'
from afastamento as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','AFASTAMENTO'
from afastamento as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE afastamento;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'FERIAS'
from ferias as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','FERIAS'
from ferias as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','FERIAS'
from ferias as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE ferias;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'ATOCONSTITUTIVO'
from atoconstitutivo as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','ATOCONSTITUTIVO'
from atoconstitutivo as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','ATOCONSTITUTIVO'
from atoconstitutivo as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE atoconstitutivo;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'BALANCETEEXERCICIO'
from balanceteexercicio as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','BALANCETEEXERCICIO'
from balanceteexercicio as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','BALANCETEEXERCICIO'
from balanceteexercicio as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE balanceteexercicio;


insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'BALANCODRE'
from balancodre as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','BALANCODRE'
from balancodre as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','BALANCODRE'
from balancodre as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE balancodre;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'CAGED'
from caged as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','CAGED'
from caged as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','CAGED'
from caged as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE caged;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'COMPROVANTERESIDENCIA'
from comprovanteresidencia as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','COMPROVANTERESIDENCIA'
from comprovanteresidencia as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','COMPROVANTERESIDENCIA'
from comprovanteresidencia as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE comprovanteresidencia;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'COMPOSICAODECONTASPATRIMONIAIS'
from composicaodecontaspatrimoniais as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','COMPOSICAODECONTASPATRIMONIAIS'
from composicaodecontaspatrimoniais as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','COMPOSICAODECONTASPATRIMONIAIS'
from composicaodecontaspatrimoniais as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE composicaodecontaspatrimoniais;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'RGECPFSOCIO'
from rgecpfsocio as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','RGECPFSOCIO'
from rgecpfsocio as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','RGECPFSOCIO'
from rgecpfsocio as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE rgecpfsocio;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'LIVROOUFICHADEREGISTROFUNCIONARIO'
from livrooufichaderegistrofuncionario as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','LIVROOUFICHADEREGISTROFUNCIONARIO'
from livrooufichaderegistrofuncionario as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','LIVROOUFICHADEREGISTROFUNCIONARIO'
from livrooufichaderegistrofuncionario as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE livrooufichaderegistrofuncionario;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'AUTORIZACAONOTAFISCALELETRONICA'
from autorizacaonotafiscaleletronica as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','AUTORIZACAONOTAFISCALELETRONICA'
from autorizacaonotafiscaleletronica as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','AUTORIZACAONOTAFISCALELETRONICA'
from autorizacaonotafiscaleletronica as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE autorizacaonotafiscaleletronica;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'SENHAINSS'
from senhainss as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','SENHAINSS'
from senhainss as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','SENHAINSS'
from senhainss as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE senhainss;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'NUMEROPIS'
from numeropis as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','NUMEROPIS'
from numeropis as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','NUMEROPIS'
from numeropis as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE numeropis;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'PLANODECONTAS'
from planodecontas as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','PLANODECONTAS'
from planodecontas as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','PLANODECONTAS'
from planodecontas as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE planodecontas;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'SENHAPOSTOFISCAL'
from senhapostofiscal as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','SENHAPOSTOFISCAL'
from senhapostofiscal as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','SENHAPOSTOFISCAL'
from senhapostofiscal as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE senhapostofiscal;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'CONFIGURARPERFILFISCALNOSITEPREFEITURADOCUMENTO'
from configurarperfilfiscalnositeprefeituradocumento as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','CONFIGURARPERFILFISCALNOSITEPREFEITURADOCUMENTO'
from configurarperfilfiscalnositeprefeituradocumento as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','CONFIGURARPERFILFISCALNOSITEPREFEITURADOCUMENTO'
from configurarperfilfiscalnositeprefeituradocumento as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE configurarperfilfiscalnositeprefeituradocumento;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'OUTORGASENHAELETRONICARECEITA'
from outorgasenhaeletronicareceita as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','OUTORGASENHAELETRONICARECEITA'
from outorgasenhaeletronicareceita as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','OUTORGASENHAELETRONICARECEITA'
from outorgasenhaeletronicareceita as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE outorgasenhaeletronicareceita;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'RECISAO'
from recisao as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','RECISAO'
from recisao as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','RECISAO'
from recisao as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE recisao;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'SENHASIMPLESNACIONAL'
from senhasimplesnacional as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','SENHASIMPLESNACIONAL'
from senhasimplesnacional as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','SENHASIMPLESNACIONAL'
from senhasimplesnacional as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE senhasimplesnacional;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'TERMODERESPONSABILIDADEDOCUMENTO'
from termoderesponsabilidadedocumento as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','TERMODERESPONSABILIDADEDOCUMENTO'
from termoderesponsabilidadedocumento as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','TERMODERESPONSABILIDADEDOCUMENTO'
from termoderesponsabilidadedocumento as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE termoderesponsabilidadedocumento;

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DatadeCadastroAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DatadeCadastroAndamento, 'Enviado para o Cliente', 'FOLHADEPAGAMENTODOCUMENTO'
from folhadepagamentodocumento as a where a.Andamento like 'Enviado para o Cliente%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataDevulucaoCliente,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataDevulucaoCliente, 'Aguardando Validação','FOLHADEPAGAMENTODOCUMENTO'
from folhadepagamentodocumento as a where a.Andamento like 'Aguardando Validação%';

insert into processo_documento (criado_em,processo_id,usuario,observacao,data_andamento,andamento,evento) 
select a.DataFinalAndamento,a.NumeroProcesso,a.Usuario,a.Obsevacao, a.DataFinalAndamento, 'Validação Efetuada','FOLHADEPAGAMENTODOCUMENTO'
from folhadepagamentodocumento as a where a.Andamento like 'Validação Efetuada%';

DROP TABLE folhadepagamentodocumento;

//contabil
drop table gerarplanodecontas;

//regularização
drop table enviartermoderesponsabilidadeparacomercial;
drop table arquivamentodoprocesso;

//folha
drop table cadastrosocioadmcontrol;
drop table cadastrodosdependentesdosociaadm;
drop table implantardadosfolhapg;

//fiscal
drop table validarprefilfiscal;
drop table distribuirfuncionariointerno;

//financeiro
drop table lancamentodedadosnaplancobranca;
drop table emissaoboleto;
drop table entrarnocontrolcontroleos;

//contratos
drop table geraridnaplancadastro;
drop table cadastrarcontrolecontimatic;
drop table elaborarcontratodeprestacaodeservico;
drop table recebercontratoasscliente;
drop table ativarcliente;
drop table elaborarperfilfiscal;

//comercial
drop table enviodiaginose;
drop table propostacomercial;
drop table geraros;
drop table requisicaodocumentos;
drop table taxadeimplantacaoetaxapg;
drop table confirmarrecebimentodeposito;
drop table pesquisafiscal;
drop table enviartermoresponsaparacliente;
drop table gravarsenhasfiscais;

drop table cheklist;
drop table cofiisacompanhamento;
drop table guiasdarfgpsfgts;
drop table guiasindical;
drop table livrodiario;
drop table mensagemdepartamento;
drop table mensagensusuario;
drop table sefip;
drop table documentos;

drop table comercial;
drop table contabil;
drop table contratos;
drop table dp;
drop table financeiro;
drop table fiscal;
drop table regularizacao;
