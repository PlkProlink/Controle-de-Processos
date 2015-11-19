-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: clientev2
-- ------------------------------------------------------
-- Server version	5.6.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acompanhamentodeenvios`
--

DROP TABLE IF EXISTS `acompanhamentodeenvios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acompanhamentodeenvios` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `PISacompanhamento` varchar(50) DEFAULT NULL,
  `COFIISacompanhamento` varchar(50) DEFAULT NULL,
  `IRPJacompanhamento` varchar(50) DEFAULT NULL,
  `CSLLacompanhamento` varchar(50) DEFAULT NULL,
  `ISSacompanhamento` varchar(50) DEFAULT NULL,
  `GPSacompanhamento` varchar(50) DEFAULT NULL,
  `BoletoPLKacompanhamento` varchar(50) DEFAULT NULL,
  `IRPFsobreSalarioacompanhamento` varchar(50) DEFAULT NULL,
  `IRPFsobreServicoTomadoacompanhamento` varchar(50) DEFAULT NULL,
  `FGTSacompanhamento` varchar(50) DEFAULT NULL,
  `ICMSacompanhamento` varchar(50) DEFAULT NULL,
  `DASacompanhamento` varchar(50) DEFAULT NULL,
  `IPIacompanhamento` varchar(50) DEFAULT NULL,
  `ICMSServTomacompanhamento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `acompanhamentodeenvios_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acompanhamentodeenvios`
--

LOCK TABLES `acompanhamentodeenvios` WRITE;
/*!40000 ALTER TABLE `acompanhamentodeenvios` DISABLE KEYS */;
/*!40000 ALTER TABLE `acompanhamentodeenvios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `afastamento`
--

DROP TABLE IF EXISTS `afastamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afastamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `afastamento_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afastamento`
--

LOCK TABLES `afastamento` WRITE;
/*!40000 ALTER TABLE `afastamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `afastamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `arquivamentodoprocesso`
--

DROP TABLE IF EXISTS `arquivamentodoprocesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arquivamentodoprocesso` (
  `CodArquivamento` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Andamentoarquivar` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `CodRegularizacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodArquivamento`),
  KEY `CodRegularizacao` (`CodRegularizacao`),
  CONSTRAINT `arquivamentodoprocesso_ibfk_1` FOREIGN KEY (`CodRegularizacao`) REFERENCES `regularizacao` (`CodRegularizacao`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arquivamentodoprocesso`
--

LOCK TABLES `arquivamentodoprocesso` WRITE;
/*!40000 ALTER TABLE `arquivamentodoprocesso` DISABLE KEYS */;
/*!40000 ALTER TABLE `arquivamentodoprocesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ativarcliente`
--

DROP TABLE IF EXISTS `ativarcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ativarcliente` (
  `CodAtivarCliente` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoAtivarCliente` varchar(50) DEFAULT NULL,
  `CodContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodAtivarCliente`),
  KEY `CodContratos` (`CodContratos`),
  CONSTRAINT `ativarcliente_ibfk_1` FOREIGN KEY (`CodContratos`) REFERENCES `contratos` (`CodContratos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ativarcliente`
--

LOCK TABLES `ativarcliente` WRITE;
/*!40000 ALTER TABLE `ativarcliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `ativarcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atoconstitutivo`
--

DROP TABLE IF EXISTS `atoconstitutivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atoconstitutivo` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `atoconstitutivo_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atoconstitutivo`
--

LOCK TABLES `atoconstitutivo` WRITE;
/*!40000 ALTER TABLE `atoconstitutivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `atoconstitutivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorizacaonotafiscaleletronica`
--

DROP TABLE IF EXISTS `autorizacaonotafiscaleletronica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autorizacaonotafiscaleletronica` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `autorizacaonotafiscaleletronica_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizacaonotafiscaleletronica`
--

LOCK TABLES `autorizacaonotafiscaleletronica` WRITE;
/*!40000 ALTER TABLE `autorizacaonotafiscaleletronica` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorizacaonotafiscaleletronica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balanceteexercicio`
--

DROP TABLE IF EXISTS `balanceteexercicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balanceteexercicio` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `balanceteexercicio_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balanceteexercicio`
--

LOCK TABLES `balanceteexercicio` WRITE;
/*!40000 ALTER TABLE `balanceteexercicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `balanceteexercicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balancodre`
--

DROP TABLE IF EXISTS `balancodre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balancodre` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `balancodre_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balancodre`
--

LOCK TABLES `balancodre` WRITE;
/*!40000 ALTER TABLE `balancodre` DISABLE KEYS */;
/*!40000 ALTER TABLE `balancodre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletoplkacompanhamento`
--

DROP TABLE IF EXISTS `boletoplkacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletoplkacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `boletoplkacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletoplkacompanhamento`
--

LOCK TABLES `boletoplkacompanhamento` WRITE;
/*!40000 ALTER TABLE `boletoplkacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletoplkacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastrarcontrolecontimatic`
--

DROP TABLE IF EXISTS `cadastrarcontrolecontimatic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadastrarcontrolecontimatic` (
  `CodCadastrarControlEContimatic` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoCadastrarControlEContimatic` varchar(50) DEFAULT NULL,
  `CodContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodCadastrarControlEContimatic`),
  KEY `CodContratos` (`CodContratos`),
  CONSTRAINT `cadastrarcontrolecontimatic_ibfk_1` FOREIGN KEY (`CodContratos`) REFERENCES `contratos` (`CodContratos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrarcontrolecontimatic`
--

LOCK TABLES `cadastrarcontrolecontimatic` WRITE;
/*!40000 ALTER TABLE `cadastrarcontrolecontimatic` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastrarcontrolecontimatic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastrodeprocesso`
--

DROP TABLE IF EXISTS `cadastrodeprocesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadastrodeprocesso` (
  `codNumerodoprocesso` int(11) NOT NULL AUTO_INCREMENT,
  `Datadecadastro` date DEFAULT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Classificacao` varchar(50) DEFAULT NULL,
  `AndamentoComercial` varchar(50) DEFAULT NULL,
  `AndamentoFinanceiro` varchar(50) DEFAULT NULL,
  `AndamentoContratos` varchar(50) DEFAULT NULL,
  `AndamentoDP` varchar(50) DEFAULT NULL,
  `AndamentoContabil` varchar(50) DEFAULT NULL,
  `AndamentoFiscal` varchar(50) DEFAULT NULL,
  `AndamentoRegularizacao` varchar(50) DEFAULT NULL,
  `AcompanhamentodeEnvios` varchar(45) DEFAULT NULL,
  `Observacao` longtext,
  `DatadeAtivacao` date DEFAULT NULL,
  `DataDeArquivamentodoProcesso` date DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `apelido` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codNumerodoprocesso`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrodeprocesso`
--

LOCK TABLES `cadastrodeprocesso` WRITE;
/*!40000 ALTER TABLE `cadastrodeprocesso` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastrodeprocesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastrodosdependentesdosociaadm`
--

DROP TABLE IF EXISTS `cadastrodosdependentesdosociaadm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadastrodosdependentesdosociaadm` (
  `CodCadastroDependentesSocioADM` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoCadastroDependentesSocioADM` varchar(50) DEFAULT NULL,
  `CodDP` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodCadastroDependentesSocioADM`),
  KEY `CodDP` (`CodDP`),
  CONSTRAINT `cadastrodosdependentesdosociaadm_ibfk_1` FOREIGN KEY (`CodDP`) REFERENCES `dp` (`CodDP`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrodosdependentesdosociaadm`
--

LOCK TABLES `cadastrodosdependentesdosociaadm` WRITE;
/*!40000 ALTER TABLE `cadastrodosdependentesdosociaadm` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastrodosdependentesdosociaadm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastrosocioadmcontrol`
--

DROP TABLE IF EXISTS `cadastrosocioadmcontrol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cadastrosocioadmcontrol` (
  `CodCadastroSocioADMControl` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoCadastroSocioADMControl` varchar(50) DEFAULT NULL,
  `CodDP` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodCadastroSocioADMControl`),
  KEY `CodDP` (`CodDP`),
  CONSTRAINT `cadastrosocioadmcontrol_ibfk_1` FOREIGN KEY (`CodDP`) REFERENCES `dp` (`CodDP`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrosocioadmcontrol`
--

LOCK TABLES `cadastrosocioadmcontrol` WRITE;
/*!40000 ALTER TABLE `cadastrosocioadmcontrol` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastrosocioadmcontrol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caged`
--

DROP TABLE IF EXISTS `caged`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caged` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `caged_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caged`
--

LOCK TABLES `caged` WRITE;
/*!40000 ALTER TABLE `caged` DISABLE KEYS */;
/*!40000 ALTER TABLE `caged` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheklist`
--

DROP TABLE IF EXISTS `cheklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheklist` (
  `CodChekList` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoChekList` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodChekList`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `cheklist_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheklist`
--

LOCK TABLES `cheklist` WRITE;
/*!40000 ALTER TABLE `cheklist` DISABLE KEYS */;
/*!40000 ALTER TABLE `cheklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificacao`
--

DROP TABLE IF EXISTS `classificacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classificacao` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificacao`
--

LOCK TABLES `classificacao` WRITE;
/*!40000 ALTER TABLE `classificacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `classificacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cofiisacompanhamento`
--

DROP TABLE IF EXISTS `cofiisacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cofiisacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `cofiisacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `cofiisacompanhamento` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cofiisacompanhamento`
--

LOCK TABLES `cofiisacompanhamento` WRITE;
/*!40000 ALTER TABLE `cofiisacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `cofiisacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comercial`
--

DROP TABLE IF EXISTS `comercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comercial` (
  `CodComercial` int(11) NOT NULL AUTO_INCREMENT,
  `AndamentoTaxaDeImplantacaoEFormaDePagamento` varchar(50) DEFAULT NULL,
  `AndamentoGravarSenhasFiscais` varchar(50) DEFAULT NULL,
  `AndamentoGerarOS` varchar(50) DEFAULT NULL,
  `AndamentoEnviarTermoResponsaparacliente` varchar(50) DEFAULT NULL,
  `AndamentoPropastaComercial` varchar(50) DEFAULT NULL,
  `AndamentoEnvioDiagnose` varchar(50) DEFAULT NULL,
  `AndamentoChekList` varchar(50) DEFAULT NULL,
  `AndamentoPesquisaFiscal` varchar(50) DEFAULT NULL,
  `AndamentoRequisicaoDocumentos` varchar(50) DEFAULT NULL,
  `AndamentoConfirmarRecebimentoDeposito` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodComercial`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `comercial_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comercial`
--

LOCK TABLES `comercial` WRITE;
/*!40000 ALTER TABLE `comercial` DISABLE KEYS */;
/*!40000 ALTER TABLE `comercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `composicaodecontaspatrimoniais`
--

DROP TABLE IF EXISTS `composicaodecontaspatrimoniais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `composicaodecontaspatrimoniais` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `composicaodecontaspatrimoniais_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composicaodecontaspatrimoniais`
--

LOCK TABLES `composicaodecontaspatrimoniais` WRITE;
/*!40000 ALTER TABLE `composicaodecontaspatrimoniais` DISABLE KEYS */;
/*!40000 ALTER TABLE `composicaodecontaspatrimoniais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprovanteresidencia`
--

DROP TABLE IF EXISTS `comprovanteresidencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprovanteresidencia` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `comprovanteresidencia_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprovanteresidencia`
--

LOCK TABLES `comprovanteresidencia` WRITE;
/*!40000 ALTER TABLE `comprovanteresidencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprovanteresidencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configurarperfilfiscalnositeprefeituradocumento`
--

DROP TABLE IF EXISTS `configurarperfilfiscalnositeprefeituradocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configurarperfilfiscalnositeprefeituradocumento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `configurarperfilfiscalnositeprefeituradocumento_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configurarperfilfiscalnositeprefeituradocumento`
--

LOCK TABLES `configurarperfilfiscalnositeprefeituradocumento` WRITE;
/*!40000 ALTER TABLE `configurarperfilfiscalnositeprefeituradocumento` DISABLE KEYS */;
/*!40000 ALTER TABLE `configurarperfilfiscalnositeprefeituradocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmarrecebimentodeposito`
--

DROP TABLE IF EXISTS `confirmarrecebimentodeposito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `confirmarrecebimentodeposito` (
  `CodConfirmarrecebimentodeposito` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoConfirmarrecebimentodeposito` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodConfirmarrecebimentodeposito`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `confirmarrecebimentodeposito_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmarrecebimentodeposito`
--

LOCK TABLES `confirmarrecebimentodeposito` WRITE;
/*!40000 ALTER TABLE `confirmarrecebimentodeposito` DISABLE KEYS */;
/*!40000 ALTER TABLE `confirmarrecebimentodeposito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contabil`
--

DROP TABLE IF EXISTS `contabil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contabil` (
  `CodContabil` int(11) NOT NULL AUTO_INCREMENT,
  `AndamentoGerarPlanoDeContas` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodContabil`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `contabil_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contabil`
--

LOCK TABLES `contabil` WRITE;
/*!40000 ALTER TABLE `contabil` DISABLE KEYS */;
/*!40000 ALTER TABLE `contabil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratos`
--

DROP TABLE IF EXISTS `contratos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contratos` (
  `CodContratos` int(11) NOT NULL AUTO_INCREMENT,
  `AndamentoElaborarContratoPrestacaoDeServico` varchar(50) DEFAULT NULL,
  `AndamentoCadastrarControlEContmatic` varchar(50) DEFAULT NULL,
  `AndamentoAtivarCliente` varchar(50) DEFAULT NULL,
  `AndamentoElaborarPrefilFiscal` varchar(50) DEFAULT NULL,
  `AndamentoReceberContratoAssCliente` varchar(50) DEFAULT NULL,
  `AndamentoGerarIDPlanCadastro` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodContratos`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `contratos_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratos`
--

LOCK TABLES `contratos` WRITE;
/*!40000 ALTER TABLE `contratos` DISABLE KEYS */;
/*!40000 ALTER TABLE `contratos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `csllacompanhamento`
--

DROP TABLE IF EXISTS `csllacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `csllacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `csllacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csllacompanhamento`
--

LOCK TABLES `csllacompanhamento` WRITE;
/*!40000 ALTER TABLE `csllacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `csllacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dasacompanhamento`
--

DROP TABLE IF EXISTS `dasacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dasacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `dasacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dasacompanhamento`
--

LOCK TABLES `dasacompanhamento` WRITE;
/*!40000 ALTER TABLE `dasacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `dasacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuirfuncionariointerno`
--

DROP TABLE IF EXISTS `distribuirfuncionariointerno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distribuirfuncionariointerno` (
  `CodDistribuirFuncionarioInterno` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoDistribuirFuncionarioInterno` varchar(50) DEFAULT NULL,
  `CodFiscal` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodDistribuirFuncionarioInterno`),
  KEY `CodFiscal` (`CodFiscal`),
  CONSTRAINT `distribuirfuncionariointerno_ibfk_1` FOREIGN KEY (`CodFiscal`) REFERENCES `fiscal` (`CodFiscal`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuirfuncionariointerno`
--

LOCK TABLES `distribuirfuncionariointerno` WRITE;
/*!40000 ALTER TABLE `distribuirfuncionariointerno` DISABLE KEYS */;
/*!40000 ALTER TABLE `distribuirfuncionariointerno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentos`
--

DROP TABLE IF EXISTS `documentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentos` (
  `CodDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `AtoConstitutivo` varchar(50) DEFAULT NULL,
  `RGeCPFSocio` varchar(50) DEFAULT NULL,
  `ComprovanteResidencia` varchar(50) DEFAULT NULL,
  `NumeroPIS` varchar(50) DEFAULT NULL,
  `AutorizacaoNotaFiscalEletronica` varchar(50) DEFAULT NULL,
  `SenhaPostoFiscal` varchar(50) DEFAULT NULL,
  `SenhaSimplesNacional` varchar(50) DEFAULT NULL,
  `BalancoDRE` varchar(50) DEFAULT NULL,
  `ComposicaoDeContasPatrimoniais` varchar(50) DEFAULT NULL,
  `PlanoDeContas` varchar(50) DEFAULT NULL,
  `BalanceteExercicio` varchar(50) DEFAULT NULL,
  `FolhadePagamentoDocumento` varchar(50) DEFAULT NULL,
  `LivroOuFichadeRegistroFuncionario` varchar(50) DEFAULT NULL,
  `CAGED` varchar(50) DEFAULT NULL,
  `SEFIP` varchar(50) DEFAULT NULL,
  `GuiaSindical` varchar(50) DEFAULT NULL,
  `GuiasDarfGpsFgts` varchar(50) DEFAULT NULL,
  `Recisao` varchar(50) DEFAULT NULL,
  `Ferias` varchar(50) DEFAULT NULL,
  `Afastamento` varchar(50) DEFAULT NULL,
  `OutorgaSenhaEletronicaReceita` varchar(50) DEFAULT NULL,
  `ConfigurarPerfilFiscalNoSitePrefeituraDocumento` varchar(50) DEFAULT NULL,
  `TermodeResponsabilidadeDocumento` varchar(50) DEFAULT NULL,
  `SenhaINSS` varchar(50) DEFAULT NULL,
  `LivroDiario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CodDocumento`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `documentos_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentos`
--

LOCK TABLES `documentos` WRITE;
/*!40000 ALTER TABLE `documentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentos_recebidos`
--

DROP TABLE IF EXISTS `documentos_recebidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentos_recebidos` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `Data_Recebimento` date DEFAULT NULL,
  `Quem_Entregou` varchar(100) DEFAULT NULL,
  `Empresa` varchar(100) DEFAULT NULL,
  `ID` int(11) DEFAULT NULL,
  `Historico` longtext,
  `Para_Quem` varchar(100) DEFAULT NULL,
  `Quem_recebeu` varchar(100) DEFAULT NULL,
  `Data_Funcionario_Recebeu` date DEFAULT NULL,
  `Observacao` longtext,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=2826 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentos_recebidos`
--

LOCK TABLES `documentos_recebidos` WRITE;
/*!40000 ALTER TABLE `documentos_recebidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentos_recebidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dp`
--

DROP TABLE IF EXISTS `dp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dp` (
  `CodDP` int(11) NOT NULL AUTO_INCREMENT,
  `AndamentoCadastroDoSocioNoControl` varchar(50) DEFAULT NULL,
  `AndamentoCadastroDependentesdoSocioADM` varchar(50) DEFAULT NULL,
  `AndamentoIplantacaodadosFolhaPg` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodDP`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `dp_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dp`
--

LOCK TABLES `dp` WRITE;
/*!40000 ALTER TABLE `dp` DISABLE KEYS */;
/*!40000 ALTER TABLE `dp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elaborarcontratodeprestacaodeservico`
--

DROP TABLE IF EXISTS `elaborarcontratodeprestacaodeservico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elaborarcontratodeprestacaodeservico` (
  `CodEleborarPropostaPrestacaoDeServico` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoElaborarPropostaPrestacaoDeServico` varchar(50) DEFAULT NULL,
  `CodContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEleborarPropostaPrestacaoDeServico`),
  KEY `CodContratos` (`CodContratos`),
  CONSTRAINT `elaborarcontratodeprestacaodeservico_ibfk_1` FOREIGN KEY (`CodContratos`) REFERENCES `contratos` (`CodContratos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elaborarcontratodeprestacaodeservico`
--

LOCK TABLES `elaborarcontratodeprestacaodeservico` WRITE;
/*!40000 ALTER TABLE `elaborarcontratodeprestacaodeservico` DISABLE KEYS */;
/*!40000 ALTER TABLE `elaborarcontratodeprestacaodeservico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elaborarperfilfiscal`
--

DROP TABLE IF EXISTS `elaborarperfilfiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elaborarperfilfiscal` (
  `CodElaborarPerfilFiscal` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoElaborarPerfilFiscal` varchar(50) DEFAULT NULL,
  `CodContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodElaborarPerfilFiscal`),
  KEY `CodContratos` (`CodContratos`),
  CONSTRAINT `elaborarperfilfiscal_ibfk_1` FOREIGN KEY (`CodContratos`) REFERENCES `contratos` (`CodContratos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elaborarperfilfiscal`
--

LOCK TABLES `elaborarperfilfiscal` WRITE;
/*!40000 ALTER TABLE `elaborarperfilfiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `elaborarperfilfiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emissaoboleto`
--

DROP TABLE IF EXISTS `emissaoboleto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emissaoboleto` (
  `CodEmissaoBoleto` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoEmissaoBoleto` varchar(50) DEFAULT NULL,
  `CodFianceiro` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEmissaoBoleto`),
  KEY `CodFianceiro` (`CodFianceiro`),
  CONSTRAINT `emissaoboleto_ibfk_1` FOREIGN KEY (`CodFianceiro`) REFERENCES `financeiro` (`CodFianceiro`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emissaoboleto`
--

LOCK TABLES `emissaoboleto` WRITE;
/*!40000 ALTER TABLE `emissaoboleto` DISABLE KEYS */;
/*!40000 ALTER TABLE `emissaoboleto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrarnocontrolcontroleos`
--

DROP TABLE IF EXISTS `entrarnocontrolcontroleos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrarnocontrolcontroleos` (
  `CodEntrarNoControlControleOS` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoEntrarNControlControleOS` varchar(50) DEFAULT NULL,
  `CodFianceiro` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEntrarNoControlControleOS`),
  KEY `CodFianceiro` (`CodFianceiro`),
  CONSTRAINT `entrarnocontrolcontroleos_ibfk_1` FOREIGN KEY (`CodFianceiro`) REFERENCES `financeiro` (`CodFianceiro`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrarnocontrolcontroleos`
--

LOCK TABLES `entrarnocontrolcontroleos` WRITE;
/*!40000 ALTER TABLE `entrarnocontrolcontroleos` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrarnocontrolcontroleos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enviartermoderesponsabilidadeparacomercial`
--

DROP TABLE IF EXISTS `enviartermoderesponsabilidadeparacomercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enviartermoderesponsabilidadeparacomercial` (
  `CodEnviartermoderesponsaparaComercial` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `DataCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intLivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoEnvioTermoResponsabiidadeparaComercial` varchar(50) DEFAULT NULL,
  `CodRegularizacao` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEnviartermoderesponsaparaComercial`),
  KEY `CodRegularizacao` (`CodRegularizacao`),
  CONSTRAINT `enviartermoderesponsabilidadeparacomercial_ibfk_1` FOREIGN KEY (`CodRegularizacao`) REFERENCES `regularizacao` (`CodRegularizacao`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enviartermoderesponsabilidadeparacomercial`
--

LOCK TABLES `enviartermoderesponsabilidadeparacomercial` WRITE;
/*!40000 ALTER TABLE `enviartermoderesponsabilidadeparacomercial` DISABLE KEYS */;
/*!40000 ALTER TABLE `enviartermoderesponsabilidadeparacomercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enviartermoresponsaparacliente`
--

DROP TABLE IF EXISTS `enviartermoresponsaparacliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enviartermoresponsaparacliente` (
  `CodEnviarTermoResponsaParaCliente` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoEnviarTermoResponsaParaCliente` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEnviarTermoResponsaParaCliente`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `enviartermoresponsaparacliente_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enviartermoresponsaparacliente`
--

LOCK TABLES `enviartermoresponsaparacliente` WRITE;
/*!40000 ALTER TABLE `enviartermoresponsaparacliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `enviartermoresponsaparacliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enviodiaginose`
--

DROP TABLE IF EXISTS `enviodiaginose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enviodiaginose` (
  `CodEnvioDgnose` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoEnioDiagnose` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEnvioDgnose`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `enviodiaginose_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enviodiaginose`
--

LOCK TABLES `enviodiaginose` WRITE;
/*!40000 ALTER TABLE `enviodiaginose` DISABLE KEYS */;
/*!40000 ALTER TABLE `enviodiaginose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ferias`
--

DROP TABLE IF EXISTS `ferias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ferias` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `ferias_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ferias`
--

LOCK TABLES `ferias` WRITE;
/*!40000 ALTER TABLE `ferias` DISABLE KEYS */;
/*!40000 ALTER TABLE `ferias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fgtsacompanhamento`
--

DROP TABLE IF EXISTS `fgtsacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fgtsacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `fgtsacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fgtsacompanhamento`
--

LOCK TABLES `fgtsacompanhamento` WRITE;
/*!40000 ALTER TABLE `fgtsacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `fgtsacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financeiro`
--

DROP TABLE IF EXISTS `financeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financeiro` (
  `CodFianceiro` int(11) NOT NULL AUTO_INCREMENT,
  `AndamentoLancamentodeDadosPlanCobranca` varchar(50) DEFAULT NULL,
  `AndamentoEmissaoBoleto` varchar(50) DEFAULT NULL,
  `AndamentoEntrarNoControlControleDoOs` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodFianceiro`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `financeiro_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financeiro`
--

LOCK TABLES `financeiro` WRITE;
/*!40000 ALTER TABLE `financeiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `financeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiscal`
--

DROP TABLE IF EXISTS `fiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fiscal` (
  `CodFiscal` int(11) NOT NULL AUTO_INCREMENT,
  `AndamenoDistribuirFuncionarioInterno` varchar(50) DEFAULT NULL,
  `AndamentoValidarPerfilFiscal` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodFiscal`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `fiscal_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiscal`
--

LOCK TABLES `fiscal` WRITE;
/*!40000 ALTER TABLE `fiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `fiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `folhadepagamentodocumento`
--

DROP TABLE IF EXISTS `folhadepagamentodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `folhadepagamentodocumento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `folhadepagamentodocumento_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `folhadepagamentodocumento`
--

LOCK TABLES `folhadepagamentodocumento` WRITE;
/*!40000 ALTER TABLE `folhadepagamentodocumento` DISABLE KEYS */;
/*!40000 ALTER TABLE `folhadepagamentodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geraridnaplancadastro`
--

DROP TABLE IF EXISTS `geraridnaplancadastro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geraridnaplancadastro` (
  `CodGerarIdNaPlanCadastro` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoGerarIdNaPlanCadastro` varchar(50) DEFAULT NULL,
  `CodContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodGerarIdNaPlanCadastro`),
  KEY `CodContratos` (`CodContratos`),
  CONSTRAINT `geraridnaplancadastro_ibfk_1` FOREIGN KEY (`CodContratos`) REFERENCES `contratos` (`CodContratos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geraridnaplancadastro`
--

LOCK TABLES `geraridnaplancadastro` WRITE;
/*!40000 ALTER TABLE `geraridnaplancadastro` DISABLE KEYS */;
/*!40000 ALTER TABLE `geraridnaplancadastro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `geraros`
--

DROP TABLE IF EXISTS `geraros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `geraros` (
  `CodGerarOS` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoGerarOS` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodGerarOS`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `geraros_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `geraros`
--

LOCK TABLES `geraros` WRITE;
/*!40000 ALTER TABLE `geraros` DISABLE KEYS */;
/*!40000 ALTER TABLE `geraros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerarplanodecontas`
--

DROP TABLE IF EXISTS `gerarplanodecontas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gerarplanodecontas` (
  `CodGerarPlanoDeContas` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoGerarPlanoDeContas` varchar(50) DEFAULT NULL,
  `CodContabil` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodGerarPlanoDeContas`),
  KEY `CodContabil` (`CodContabil`),
  CONSTRAINT `gerarplanodecontas_ibfk_1` FOREIGN KEY (`CodContabil`) REFERENCES `contabil` (`CodContabil`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerarplanodecontas`
--

LOCK TABLES `gerarplanodecontas` WRITE;
/*!40000 ALTER TABLE `gerarplanodecontas` DISABLE KEYS */;
/*!40000 ALTER TABLE `gerarplanodecontas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpsacompanhamento`
--

DROP TABLE IF EXISTS `gpsacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gpsacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `gpsacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpsacompanhamento`
--

LOCK TABLES `gpsacompanhamento` WRITE;
/*!40000 ALTER TABLE `gpsacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `gpsacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gravarsenhasfiscais`
--

DROP TABLE IF EXISTS `gravarsenhasfiscais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gravarsenhasfiscais` (
  `CodGravarSenhasFiscais` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoGravarSenhasFiscais` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodGravarSenhasFiscais`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `gravarsenhasfiscais_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gravarsenhasfiscais`
--

LOCK TABLES `gravarsenhasfiscais` WRITE;
/*!40000 ALTER TABLE `gravarsenhasfiscais` DISABLE KEYS */;
/*!40000 ALTER TABLE `gravarsenhasfiscais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guiasdarfgpsfgts`
--

DROP TABLE IF EXISTS `guiasdarfgpsfgts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guiasdarfgpsfgts` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `guiasdarfgpsfgts_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guiasdarfgpsfgts`
--

LOCK TABLES `guiasdarfgpsfgts` WRITE;
/*!40000 ALTER TABLE `guiasdarfgpsfgts` DISABLE KEYS */;
/*!40000 ALTER TABLE `guiasdarfgpsfgts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guiasindical`
--

DROP TABLE IF EXISTS `guiasindical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guiasindical` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `guiasindical_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guiasindical`
--

LOCK TABLES `guiasindical` WRITE;
/*!40000 ALTER TABLE `guiasindical` DISABLE KEYS */;
/*!40000 ALTER TABLE `guiasindical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icmsacompanhamento`
--

DROP TABLE IF EXISTS `icmsacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icmsacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `icmsacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icmsacompanhamento`
--

LOCK TABLES `icmsacompanhamento` WRITE;
/*!40000 ALTER TABLE `icmsacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `icmsacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icmsservtomacompanhamento`
--

DROP TABLE IF EXISTS `icmsservtomacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icmsservtomacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `icmsservtomacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icmsservtomacompanhamento`
--

LOCK TABLES `icmsservtomacompanhamento` WRITE;
/*!40000 ALTER TABLE `icmsservtomacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `icmsservtomacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `implantardadosfolhapg`
--

DROP TABLE IF EXISTS `implantardadosfolhapg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `implantardadosfolhapg` (
  `CodImplantarDadosFolhaPG` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoImplantarDadosFolhaPG` varchar(50) DEFAULT NULL,
  `CodDP` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodImplantarDadosFolhaPG`),
  KEY `CodDP` (`CodDP`),
  CONSTRAINT `implantardadosfolhapg_ibfk_1` FOREIGN KEY (`CodDP`) REFERENCES `dp` (`CodDP`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `implantardadosfolhapg`
--

LOCK TABLES `implantardadosfolhapg` WRITE;
/*!40000 ALTER TABLE `implantardadosfolhapg` DISABLE KEYS */;
/*!40000 ALTER TABLE `implantardadosfolhapg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ipiacompanhamento`
--

DROP TABLE IF EXISTS `ipiacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ipiacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `ipiacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ipiacompanhamento`
--

LOCK TABLES `ipiacompanhamento` WRITE;
/*!40000 ALTER TABLE `ipiacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `ipiacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irpfsobresalarioacompanhamento`
--

DROP TABLE IF EXISTS `irpfsobresalarioacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `irpfsobresalarioacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `irpfsobresalarioacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irpfsobresalarioacompanhamento`
--

LOCK TABLES `irpfsobresalarioacompanhamento` WRITE;
/*!40000 ALTER TABLE `irpfsobresalarioacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `irpfsobresalarioacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irpfsobreservicotomadoacompanhamento`
--

DROP TABLE IF EXISTS `irpfsobreservicotomadoacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `irpfsobreservicotomadoacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `irpfsobreservicotomadoacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irpfsobreservicotomadoacompanhamento`
--

LOCK TABLES `irpfsobreservicotomadoacompanhamento` WRITE;
/*!40000 ALTER TABLE `irpfsobreservicotomadoacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `irpfsobreservicotomadoacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `irpjacompanhamento`
--

DROP TABLE IF EXISTS `irpjacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `irpjacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `irpjacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `irpjacompanhamento`
--

LOCK TABLES `irpjacompanhamento` WRITE;
/*!40000 ALTER TABLE `irpjacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `irpjacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issacompanhamento`
--

DROP TABLE IF EXISTS `issacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `issacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issacompanhamento`
--

LOCK TABLES `issacompanhamento` WRITE;
/*!40000 ALTER TABLE `issacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `issacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lancamentodedadosnaplancobranca`
--

DROP TABLE IF EXISTS `lancamentodedadosnaplancobranca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lancamentodedadosnaplancobranca` (
  `CodLancamentoDeDadosNaPlanConbranca` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoLancamentoDeDadosPlanCobranca` varchar(50) DEFAULT NULL,
  `CodFianceiro` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodLancamentoDeDadosNaPlanConbranca`),
  KEY `CodFianceiro` (`CodFianceiro`),
  CONSTRAINT `lancamentodedadosnaplancobranca_ibfk_1` FOREIGN KEY (`CodFianceiro`) REFERENCES `financeiro` (`CodFianceiro`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamentodedadosnaplancobranca`
--

LOCK TABLES `lancamentodedadosnaplancobranca` WRITE;
/*!40000 ALTER TABLE `lancamentodedadosnaplancobranca` DISABLE KEYS */;
/*!40000 ALTER TABLE `lancamentodedadosnaplancobranca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livrodiario`
--

DROP TABLE IF EXISTS `livrodiario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livrodiario` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `livrodiario_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livrodiario`
--

LOCK TABLES `livrodiario` WRITE;
/*!40000 ALTER TABLE `livrodiario` DISABLE KEYS */;
/*!40000 ALTER TABLE `livrodiario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livrooufichaderegistrofuncionario`
--

DROP TABLE IF EXISTS `livrooufichaderegistrofuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livrooufichaderegistrofuncionario` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `livrooufichaderegistrofuncionario_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livrooufichaderegistrofuncionario`
--

LOCK TABLES `livrooufichaderegistrofuncionario` WRITE;
/*!40000 ALTER TABLE `livrooufichaderegistrofuncionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `livrooufichaderegistrofuncionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(50) DEFAULT NULL,
  `Senha` varchar(50) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Mensagem` int(11) DEFAULT NULL,
  `MensagemDepartamento` int(11) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagemdepartamento`
--

DROP TABLE IF EXISTS `mensagemdepartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensagemdepartamento` (
  `CodMensagem` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `DataEnvio` date DEFAULT NULL,
  `Mensagem` longtext,
  `DataLeitura` date DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodMensagem`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagemdepartamento`
--

LOCK TABLES `mensagemdepartamento` WRITE;
/*!40000 ALTER TABLE `mensagemdepartamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensagemdepartamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagensusuario`
--

DROP TABLE IF EXISTS `mensagensusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensagensusuario` (
  `CodMensagem` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Mensagem` longtext,
  `DataEnvio` date DEFAULT NULL,
  `DataLeitura` date DEFAULT NULL,
  `Usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodMensagem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagensusuario`
--

LOCK TABLES `mensagensusuario` WRITE;
/*!40000 ALTER TABLE `mensagensusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensagensusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numeropis`
--

DROP TABLE IF EXISTS `numeropis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numeropis` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `numeropis_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeropis`
--

LOCK TABLES `numeropis` WRITE;
/*!40000 ALTER TABLE `numeropis` DISABLE KEYS */;
/*!40000 ALTER TABLE `numeropis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outorgasenhaeletronicareceita`
--

DROP TABLE IF EXISTS `outorgasenhaeletronicareceita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outorgasenhaeletronicareceita` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `outorgasenhaeletronicareceita_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outorgasenhaeletronicareceita`
--

LOCK TABLES `outorgasenhaeletronicareceita` WRITE;
/*!40000 ALTER TABLE `outorgasenhaeletronicareceita` DISABLE KEYS */;
/*!40000 ALTER TABLE `outorgasenhaeletronicareceita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesquisafiscal`
--

DROP TABLE IF EXISTS `pesquisafiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesquisafiscal` (
  `CodPesquisaFiscal` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoPesquisaFiscal` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodPesquisaFiscal`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `pesquisafiscal_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesquisafiscal`
--

LOCK TABLES `pesquisafiscal` WRITE;
/*!40000 ALTER TABLE `pesquisafiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `pesquisafiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pisacompanhamento`
--

DROP TABLE IF EXISTS `pisacompanhamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pisacompanhamento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DataAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Observacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `StatusDoEnvio1` varchar(50) DEFAULT NULL,
  `Data1Envio` date DEFAULT NULL,
  `StatusDoEnvio2` varchar(50) DEFAULT NULL,
  `Data2Envio` date DEFAULT NULL,
  `StatusDoEnvio3` varchar(50) DEFAULT NULL,
  `Data3Envio` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodAconpanhamentodeEnvios` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodAconpanhamentodeEnvios` (`CodAconpanhamentodeEnvios`),
  CONSTRAINT `pisacompanhamento_ibfk_1` FOREIGN KEY (`CodAconpanhamentodeEnvios`) REFERENCES `acompanhamentodeenvios` (`Cod`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pisacompanhamento`
--

LOCK TABLES `pisacompanhamento` WRITE;
/*!40000 ALTER TABLE `pisacompanhamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pisacompanhamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planodecontas`
--

DROP TABLE IF EXISTS `planodecontas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planodecontas` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `planodecontas_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planodecontas`
--

LOCK TABLES `planodecontas` WRITE;
/*!40000 ALTER TABLE `planodecontas` DISABLE KEYS */;
/*!40000 ALTER TABLE `planodecontas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propostacomercial`
--

DROP TABLE IF EXISTS `propostacomercial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propostacomercial` (
  `CodPropostaComercial` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoPropostaComercial` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodPropostaComercial`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `propostacomercial_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propostacomercial`
--

LOCK TABLES `propostacomercial` WRITE;
/*!40000 ALTER TABLE `propostacomercial` DISABLE KEYS */;
/*!40000 ALTER TABLE `propostacomercial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recebercontratoasscliente`
--

DROP TABLE IF EXISTS `recebercontratoasscliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recebercontratoasscliente` (
  `CodReceberContratoAssCliente` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoReceberContratoAssCliente` varchar(50) DEFAULT NULL,
  `CodContratos` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodReceberContratoAssCliente`),
  KEY `CodContratos` (`CodContratos`),
  CONSTRAINT `recebercontratoasscliente_ibfk_1` FOREIGN KEY (`CodContratos`) REFERENCES `contratos` (`CodContratos`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recebercontratoasscliente`
--

LOCK TABLES `recebercontratoasscliente` WRITE;
/*!40000 ALTER TABLE `recebercontratoasscliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `recebercontratoasscliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recisao`
--

DROP TABLE IF EXISTS `recisao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recisao` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `recisao_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recisao`
--

LOCK TABLES `recisao` WRITE;
/*!40000 ALTER TABLE `recisao` DISABLE KEYS */;
/*!40000 ALTER TABLE `recisao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regularizacao`
--

DROP TABLE IF EXISTS `regularizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regularizacao` (
  `CodRegularizacao` int(11) NOT NULL AUTO_INCREMENT,
  `AndamentoEnviarTernoReponsaParaComercial` varchar(50) DEFAULT NULL,
  `AndamentoArquivarProcesso` varchar(50) DEFAULT NULL,
  `Numerodoprocesso` int(11) DEFAULT NULL,
  `DataCadastroProcesso` date DEFAULT NULL,
  PRIMARY KEY (`CodRegularizacao`),
  KEY `Numerodoprocesso` (`Numerodoprocesso`),
  CONSTRAINT `regularizacao_ibfk_1` FOREIGN KEY (`Numerodoprocesso`) REFERENCES `cadastrodeprocesso` (`codNumerodoprocesso`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regularizacao`
--

LOCK TABLES `regularizacao` WRITE;
/*!40000 ALTER TABLE `regularizacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `regularizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisicaodocumentos`
--

DROP TABLE IF EXISTS `requisicaodocumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requisicaodocumentos` (
  `CodRequisicaoDocumentos` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoRequisicaoDocumentos` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodRequisicaoDocumentos`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `requisicaodocumentos_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisicaodocumentos`
--

LOCK TABLES `requisicaodocumentos` WRITE;
/*!40000 ALTER TABLE `requisicaodocumentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `requisicaodocumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rgecpfsocio`
--

DROP TABLE IF EXISTS `rgecpfsocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rgecpfsocio` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `rgecpfsocio_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rgecpfsocio`
--

LOCK TABLES `rgecpfsocio` WRITE;
/*!40000 ALTER TABLE `rgecpfsocio` DISABLE KEYS */;
/*!40000 ALTER TABLE `rgecpfsocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sefip`
--

DROP TABLE IF EXISTS `sefip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sefip` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `sefip_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sefip`
--

LOCK TABLES `sefip` WRITE;
/*!40000 ALTER TABLE `sefip` DISABLE KEYS */;
/*!40000 ALTER TABLE `sefip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `senhainss`
--

DROP TABLE IF EXISTS `senhainss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `senhainss` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `senhainss_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `senhainss`
--

LOCK TABLES `senhainss` WRITE;
/*!40000 ALTER TABLE `senhainss` DISABLE KEYS */;
/*!40000 ALTER TABLE `senhainss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `senhapostofiscal`
--

DROP TABLE IF EXISTS `senhapostofiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `senhapostofiscal` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `senhapostofiscal_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `senhapostofiscal`
--

LOCK TABLES `senhapostofiscal` WRITE;
/*!40000 ALTER TABLE `senhapostofiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `senhapostofiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `senhasimplesnacional`
--

DROP TABLE IF EXISTS `senhasimplesnacional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `senhasimplesnacional` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `senhasimplesnacional_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `senhasimplesnacional`
--

LOCK TABLES `senhasimplesnacional` WRITE;
/*!40000 ALTER TABLE `senhasimplesnacional` DISABLE KEYS */;
/*!40000 ALTER TABLE `senhasimplesnacional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxadeimplantacaoetaxapg`
--

DROP TABLE IF EXISTS `taxadeimplantacaoetaxapg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taxadeimplantacaoetaxapg` (
  `CodTaxaDeImplantacaoEFormaDePG` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Obsevacao` longtext,
  `intlivre` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `AndamentoTaxaDeImplantacaoEformaPG` varchar(50) DEFAULT NULL,
  `CodComercial` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodTaxaDeImplantacaoEFormaDePG`),
  KEY `CodComercial` (`CodComercial`),
  CONSTRAINT `taxadeimplantacaoetaxapg_ibfk_1` FOREIGN KEY (`CodComercial`) REFERENCES `comercial` (`CodComercial`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxadeimplantacaoetaxapg`
--

LOCK TABLES `taxadeimplantacaoetaxapg` WRITE;
/*!40000 ALTER TABLE `taxadeimplantacaoetaxapg` DISABLE KEYS */;
/*!40000 ALTER TABLE `taxadeimplantacaoetaxapg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `termoderesponsabilidadedocumento`
--

DROP TABLE IF EXISTS `termoderesponsabilidadedocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `termoderesponsabilidadedocumento` (
  `Cod` int(11) NOT NULL AUTO_INCREMENT,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `DataDevulucaoCliente` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `Andamento` varchar(50) DEFAULT NULL,
  `CodDocumento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod`),
  KEY `CodDocumento` (`CodDocumento`),
  CONSTRAINT `termoderesponsabilidadedocumento_ibfk_1` FOREIGN KEY (`CodDocumento`) REFERENCES `documentos` (`CodDocumento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `termoderesponsabilidadedocumento`
--

LOCK TABLES `termoderesponsabilidadedocumento` WRITE;
/*!40000 ALTER TABLE `termoderesponsabilidadedocumento` DISABLE KEYS */;
/*!40000 ALTER TABLE `termoderesponsabilidadedocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `validarprefilfiscal`
--

DROP TABLE IF EXISTS `validarprefilfiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `validarprefilfiscal` (
  `CodValidarPerfilFiscal` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProcesso` int(11) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Obsevacao` longtext,
  `Departamento` varchar(50) DEFAULT NULL,
  `Livre` varchar(50) DEFAULT NULL,
  `intlivre` int(11) DEFAULT NULL,
  `DatadeCadastroAndamento` date DEFAULT NULL,
  `DataFinalAndamento` date DEFAULT NULL,
  `AndamentoValidarPerfilFiscal` varchar(50) DEFAULT NULL,
  `CodFiscal` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodValidarPerfilFiscal`),
  KEY `CodFiscal` (`CodFiscal`),
  CONSTRAINT `validarprefilfiscal_ibfk_1` FOREIGN KEY (`CodFiscal`) REFERENCES `fiscal` (`CodFiscal`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `validarprefilfiscal`
--

LOCK TABLES `validarprefilfiscal` WRITE;
/*!40000 ALTER TABLE `validarprefilfiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `validarprefilfiscal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-16 18:08:57
