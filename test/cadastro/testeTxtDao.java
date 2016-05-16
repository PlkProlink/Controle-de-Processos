package cadastro;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */

/**
 *
 * @author User
 */
public class testeTxtDao {
    public List<bean> Listar(){
    try{
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\User\\Dropbox\\Cadastro.txt"))
                       .useDelimiter("\t");
    List<bean> lista = new ArrayList<>();
    scanner.nextLine();
        while (scanner.hasNext()) {
            bean b = new bean();
            
            String cod = scanner.next();
            if(cod.indexOf("10")!=-1) break;
            b.setCOD(cod);
            b.setSTATUS(scanner.next());
            b.setCOMPL_STS(scanner.next());
            b.setATENDIMENTO(scanner.next());
            b.setPROCESSOS(scanner.next());
            b.setSISTEMA(scanner.next());
            b.setMP(scanner.next());
            b.setTIPO(scanner.next());
            b.setREGIME_TRIBUTARIO(scanner.next());
            b.setQUANT_SOC_GER(scanner.next());
            b.setEMPRESA(scanner.next());
            b.setNOME(scanner.next());
            b.setENDERECO(scanner.next());
            b.setBAIRRO(scanner.next());
            b.setCIDADE(scanner.next());
            b.setEST(scanner.next());
            b.setCEP(scanner.next());
            b.setCNPJ(scanner.next());
            b.setDATA_CNPJ(scanner.next());
            b.setIE(scanner.next());
            b.setVLR_CAPITAL(scanner.next());
            b.setVL_EXTENSO(scanner.next());
            b.setVL_COTA(scanner.next());
            b.setVL_EXT_COTA(scanner.next());
            b.setCOTAS_TOTAL(scanner.next());
            b.setCOTAS_EXTENSO(scanner.next());
            b.setPERC_CAP_1(scanner.next());
            b.setPERC_CAP_2(scanner.next());
            b.setPERC_CAP_DEMAIS(scanner.next());
            b.setSOMA_PERC_CAP(scanner.next());
            b.setCotas_01(scanner.next());
            b.setCotas_02(scanner.next());
            b.setPREF(scanner.next());
            b.setDATA_IM(scanner.next());
            b.setN_CONTRIB(scanner.next());
            b.setALIQUOTA_DE_ISS(scanner.next());
            b.setENC_MUNIC(scanner.next());
            b.setDT_DISTRATO(scanner.next());
            b.setNIRC(scanner.next());
            b.setN_REG_CART_OU_NIRE(scanner.next());
            b.setDATA_REG_CART_OU_JUCESP(scanner.next());
            b.setSIND_CNPJ(scanner.next());
            b.setATIVIDADE(scanner.next());
            b.setSINDICATO(scanner.next());
            b.setCNAE1(scanner.next());
            b.setCOMP_CNAE1(scanner.next());
            b.setDIG_CNAE1(scanner.next());
            b.setCNAE(scanner.next());
            b.setCOMP_CNAE(scanner.next());
            b.setDIG_CNAE(scanner.next());
            b.setFPAS(scanner.next());
            b.setQUANT_SocioS(scanner.next());
            b.setDATA_INSS(scanner.next());
            b.setCONSULTORIA_INICIO(scanner.next());
            b.setALOCADO(scanner.next());
            b.setINDICADO(scanner.next());
            b.setCONSULT_ATUAL(scanner.next());
            b.setAPELIDO_1(scanner.next());
            b.setEND_CORRESP(scanner.next());
            b.setBAIRRO_CO(scanner.next());
            b.setCID_CO(scanner.next());
            b.setEST_CO(scanner.next());
            b.setCEP_CO(scanner.next());
            b.setNOME_Socio1(scanner.next());
            b.setQUALIDADE1(scanner.next());
            b.setNAC_01(scanner.next());
            b.setNATURALIDADE_1(scanner.next());
            b.setEST_CIVEL_01(scanner.next());
            b.setMaior_EMANCIPADO_1(scanner.next());
            b.setPROF_01(scanner.next());
            b.setDIA_NASC1(scanner.next());
            b.setMÊS_NASC1(scanner.next());
            b.setANO_NASC1(scanner.next());
            b.setPIS_SOC1(scanner.next());
            b.setEND_SOC_1(scanner.next());
            b.setBAIRRO1_(scanner.next());
            b.setCIDADE1(scanner.next());
            b.setEST1(scanner.next());
            b.setCEP1(scanner.next());
            b.setRG1(scanner.next());
            b.setORGAO1(scanner.next());
            b.setESTD1(scanner.next());
            b.setDATA_EXP1(scanner.next());
            b.setCPF1(scanner.next());
            b.setEMAIL_SOC_1(scanner.next());
            b.setEMAIL_FINANCEIRO(scanner.next());
            b.setDDD1(scanner.next());
            b.setFONERES1(scanner.next());
            b.setRES_RAMAL_1(scanner.next());
            b.setDDD1COML(scanner.next());
            b.setFONECOML1(scanner.next());
            b.setCOML_RAMAL_1(scanner.next());
            b.setDDD1CEL(scanner.next());
            b.setCELULAR(scanner.next());
            b.setDDD1REC(scanner.next());
            b.setFONEREC1(scanner.next());
            b.setOBSFONE_REC1(scanner.next());
            b.setNOME_SOC_2(scanner.next());
            b.setQUALIDADE2(scanner.next());
            b.setNAC_02(scanner.next());
            b.setNATURALIDADE_2(scanner.next());
            b.setEST_CIVEL_02(scanner.next());
            b.setMaior_EMANCIPADO_2(scanner.next());
            b.setPROF_02(scanner.next());
            b.setEND_SOC_2(scanner.next());
            b.setBAIRRO2(scanner.next());
            b.setCIDADE2(scanner.next());
            b.setEST2(scanner.next());
            b.setCEP2(scanner.next());
            b.setDIA_NASC2(scanner.next());
            b.setMÊS_NASC2(scanner.next());
            b.setANO_NASC2(scanner.next());
            b.setPIS_SOC2(scanner.next());
            b.setRG2(scanner.next());
            b.setORGAO2(scanner.next());
            b.setESTD2(scanner.next());
            b.setDATA_EXP2(scanner.next());
            b.setCPF2(scanner.next());
            b.setDDD2RES(scanner.next());
            b.setFONERES2(scanner.next());
            b.setDDD2COML(scanner.next());
            b.setFONECOM2(scanner.next());
            b.setDDD2CEL(scanner.next());
            b.setCELULAR2(scanner.next());
            b.setDDD2REC(scanner.next());
            b.setFONEREC2(scanner.next());
            b.setHISTÓRIO_DO_STATOS(scanner.next());
            b.setOBSFONE_RC2(scanner.next());
            b.setBco(scanner.nextLine());
            lista.add(b);
        }
        scanner.close();
        return lista;
    }catch(Exception e){
    }
    return null;
    }
}

