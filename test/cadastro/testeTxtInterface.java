package cadastro;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class testeTxtInterface {
    public static void main(String[] args){

        bean b = new bean();
        testeTxtDao txt = new testeTxtDao();
        List<bean> lista = new ArrayList<>();
        lista = txt.Listar();
        
        for(bean bean : lista){
            if(bean.getCOD().trim().length()>=1){
                System.out.println("COD:"+bean.getCOD());
                System.out.println("STATUS:"+bean.getSTATUS().trim());
                System.out.println("COMPL_STS:"+bean.getCOMPL_STS().trim());
                System.out.println("ATENDIMENTO:"+bean.getATENDIMENTO().trim());
                System.out.println("PROCESSOS:"+bean.getPROCESSOS().trim());
                System.out.println("SISTEMA:"+bean.getSISTEMA().trim());
                System.out.println("MP:"+bean.getMP().trim());
                System.out.println("TIPO:"+bean.getTIPO().trim());
                System.out.println("REGIME_TRIBUTARIO:"+bean.getREGIME_TRIBUTARIO().trim());
                System.out.println("QUANT_SOC_GER:"+bean.getQUANT_SOC_GER().trim());
                System.out.println("EMPRESA:"+bean.getEMPRESA().trim());
                System.out.println("NOME:"+bean.getNOME().trim());
                System.out.println("ENDERECO:"+bean.getENDERECO().trim());
                System.out.println("BAIRRO:"+bean.getBAIRRO().trim());
                System.out.println("CIDADE:"+bean.getCIDADE().trim());
                System.out.println("EST:"+bean.getEST().trim());
                System.out.println("CEP:"+bean.getCEP().trim());
                System.out.println("CNPJ:"+bean.getCNPJ().trim());
                System.out.println("DATA_CNPJ:"+bean.getDATA_CNPJ().trim());
                System.out.println("IE:"+bean.getIE().trim());
                System.out.println("VLR_CAPITAL:"+bean.getVLR_CAPITAL().trim());
                System.out.println("VL_EXTENSO:"+bean.getVL_EXTENSO().trim());
                System.out.println("VL_COTA:"+bean.getVL_COTA().trim());
                System.out.println("VL_EXT_COTA:"+bean.getVL_EXT_COTA().trim());
                System.out.println("COTAS_TOTAL:"+bean.getCOTAS_TOTAL().trim());
                System.out.println("COTAS_EXTENSO:"+bean.getCOTAS_EXTENSO().trim());
                System.out.println("PERC_CAP_1:"+bean.getPERC_CAP_1().trim());
                System.out.println("PERC_CAP_2:"+bean.getPERC_CAP_2().trim());
                System.out.println("PERC_CAP_DEMAIS:"+bean.getPERC_CAP_DEMAIS().trim());
                System.out.println("SOMA_PERC_CAP:"+bean.getSOMA_PERC_CAP().trim());
                System.out.println("Cotas_01:"+bean.getCotas_01().trim());
                System.out.println("Cotas_02:"+bean.getCotas_02().trim());
                System.out.println("PREF:"+bean.getPREF().trim());
                System.out.println("DATA_IM:"+bean.getDATA_IM().trim());
                System.out.println("N_CONTRIB:"+bean.getN_CONTRIB().trim());
                System.out.println("ALIQUOTA_DE_ISS:"+bean.getALIQUOTA_DE_ISS().trim());
                System.out.println("ENC_MUNIC:"+bean.getENC_MUNIC().trim());
                System.out.println("DT_DISTRATO:"+bean.getDT_DISTRATO().trim());
                System.out.println("NIRC:"+bean.getNIRC().trim());
                System.out.println("N_REG_CART_OU_NIRE:"+bean.getN_REG_CART_OU_NIRE().trim());
                System.out.println("DATA_REG_CART_OU_JUCESP:"+bean.getDATA_REG_CART_OU_JUCESP().trim());
                System.out.println("SIND_CNPJ:"+bean.getSIND_CNPJ().trim());
                System.out.println("ATIVIDADE:"+bean.getATIVIDADE().trim());
                System.out.println("SINDICATO:"+bean.getSINDICATO().trim());
                System.out.println("CNAE1:"+bean.getCNAE1().trim());
                System.out.println("COMP_CNAE1:"+bean.getCOMP_CNAE1().trim());
                System.out.println("DIG_CNAE1:"+bean.getDIG_CNAE1().trim());
                System.out.println("CNAE:"+bean.getCNAE().trim());
                System.out.println("COMP_CNAE:"+bean.getCOMP_CNAE().trim());
                System.out.println("DIG_CNAE:"+bean.getDIG_CNAE().trim());
                System.out.println("FPAS:"+bean.getFPAS().trim());
                System.out.println("QUANT_SocioS:"+bean.getQUANT_SocioS().trim());
                System.out.println("DATA_INSS:"+bean.getDATA_INSS().trim());
                System.out.println("CONSULTORIA_INICIO:"+bean.getCONSULTORIA_INICIO().trim());
                System.out.println("ALOCADO:"+bean.getALOCADO().trim());
                System.out.println("INDICADO:"+bean.getINDICADO().trim());
                System.out.println("CONSULT_ATUAL:"+bean.getCONSULT_ATUAL().trim());
                System.out.println("APELIDO_1:"+bean.getAPELIDO_1().trim());
                System.out.println("END_CORRESP:"+bean.getEND_CORRESP().trim());
                System.out.println("BAIRRO_CO:"+bean.getBAIRRO_CO().trim());
                System.out.println("CID_CO:"+bean.getCID_CO().trim());
                System.out.println("EST_CO:"+bean.getEST_CO().trim());
                System.out.println("CEP_CO:"+bean.getCEP_CO().trim());
                System.out.println("NOME_Socio1:"+bean.getNOME_Socio1().trim());
                System.out.println("QUALIDADE1:"+bean.getQUALIDADE1().trim());
                System.out.println("NAC_01:"+bean.getNAC_01().trim());
                System.out.println("NATURALIDADE_1:"+bean.getNATURALIDADE_1().trim());
                System.out.println("EST_CIVEL_01:"+bean.getEST_CIVEL_01().trim());
                System.out.println("maior_EMANCIPADO_1:"+bean.getMaior_EMANCIPADO_1().trim());
                System.out.println("PROF_01:"+bean.getPROF_01().trim());
                System.out.println("DIA_NASC1:"+bean.getDIA_NASC1().trim());
                System.out.println("MÊS_NASC1:"+bean.getMÊS_NASC1().trim());
                System.out.println("ANO_NASC1:"+bean.getANO_NASC1().trim());
                System.out.println("PIS_SOC1:"+bean.getPIS_SOC1().trim());
                System.out.println("END_SOC_1:"+bean.getEND_SOC_1().trim());
                System.out.println("BAIRRO1_:"+bean.getBAIRRO1_().trim());
                System.out.println("CIDADE1:"+bean.getCIDADE1().trim());
                System.out.println("EST1:"+bean.getEST1().trim());
                System.out.println("CEP1:"+bean.getCEP1().trim());
                System.out.println("RG1:"+bean.getRG1().trim());
                System.out.println("ORGAO1:"+bean.getORGAO1().trim());
                System.out.println("ESTD1:"+bean.getESTD1().trim());
                System.out.println("DATA_EXP1:"+bean.getDATA_EXP1().trim());
                System.out.println("CPF1:"+bean.getCPF1().trim());
                System.out.println("EMAIL_SOC_1:"+bean.getEMAIL_SOC_1().trim());
                System.out.println("EMAIL_FINANCEIRO:"+bean.getEMAIL_FINANCEIRO().trim());
                System.out.println("DDD1:"+bean.getDDD1().trim());
                System.out.println("FONERES1:"+bean.getFONERES1().trim());
                System.out.println("RES_RAMAL_1:"+bean.getRES_RAMAL_1().trim());
                System.out.println("DDD1COML:"+bean.getDDD1COML().trim());
                System.out.println("FONECOML1:"+bean.getFONECOML1().trim());
                System.out.println("COML_RAMAL_1:"+bean.getCOML_RAMAL_1().trim());
                System.out.println("DDD1CEL:"+bean.getDDD1CEL().trim());
                System.out.println("CELULAR:"+bean.getCELULAR().trim());
                System.out.println("DDD1REC:"+bean.getDDD1REC().trim());
                System.out.println("FONEREC1:"+bean.getFONEREC1().trim());
                System.out.println("OBSFONE_REC1:"+bean.getOBSFONE_REC1().trim());
                System.out.println("NOME_SOC_2:"+bean.getNOME_SOC_2().trim());
                System.out.println("QUALIDADE2:"+bean.getQUALIDADE2().trim());
                System.out.println("NAC_02:"+bean.getNAC_02().trim());
                System.out.println("NATURALIDADE_2:"+bean.getNATURALIDADE_2().trim());
                System.out.println("EST_CIVEL_02:"+bean.getEST_CIVEL_02().trim());
                System.out.println("maior_EMANCIPADO_2:"+bean.getMaior_EMANCIPADO_2().trim());
                System.out.println("PROF_02:"+bean.getPROF_02().trim());
                System.out.println("END_SOC_2:"+bean.getEND_SOC_2().trim());
                System.out.println("BAIRRO2:"+bean.getBAIRRO2().trim());
                System.out.println("CIDADE2:"+bean.getCIDADE2().trim());
                System.out.println("EST2:"+bean.getEST2().trim());
                System.out.println("CEP2:"+bean.getCEP2().trim());
                System.out.println("DIA_NASC2:"+bean.getDIA_NASC2().trim());
                System.out.println("MÊS_NASC2:"+bean.getMÊS_NASC2().trim());
                System.out.println("ANO_NASC2:"+bean.getANO_NASC2().trim());
                System.out.println("PIS_SOC2:"+bean.getPIS_SOC2().trim());
                System.out.println("RG2:"+bean.getRG2().trim());
                System.out.println("ORGAO2:"+bean.getORGAO2().trim());
                System.out.println("ESTD2:"+bean.getESTD2().trim());
                System.out.println("DATA_EXP2:"+bean.getDATA_EXP2().trim());
                System.out.println("CPF2:"+bean.getCPF2().trim());
                System.out.println("DDD2RES:"+bean.getDDD2RES().trim());
                System.out.println("FONERES2:"+bean.getFONERES2().trim());
                System.out.println("DDD2COML:"+bean.getDDD2COML().trim());
                System.out.println("FONECOM2:"+bean.getFONECOM2().trim());
                System.out.println("DDD2CEL:"+bean.getDDD2CEL().trim());
                System.out.println("CELULAR2:"+bean.getCELULAR2().trim());
                System.out.println("DDD2REC:"+bean.getDDD2REC().trim());
                System.out.println("FONEREC2:"+bean.getFONEREC2().trim());
                System.out.println("HISTÓRIO_DO_STATOS:"+bean.getHISTÓRIO_DO_STATOS().trim());
                System.out.println("OBSFONE_RC2:"+bean.getOBSFONE_RC2().trim());
                System.out.println("bco:"+bean.getBco().trim());

            }
            else
                break;
        }
        
    }
}
