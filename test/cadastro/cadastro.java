package cadastro;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/*
 * Todos direitos reservados a Tiago Dias de Souza.
 * OpenSource Project www.github.com.br/tiagods
 */

/**
 *
 * @author Tiago
 */
public class cadastro {
    public static void main(String[] args) throws FileNotFoundException{
//        try {
//
//        InputStream inp = new FileInputStream("c:\\tmp\\protectedFile.xls");
//        org.apache.poi.hssf.record.crypto.Biff8EncryptionKey.setCurrentUserPassword("abracadabra"); 
//
//        Workbook wb;
//        wb = WorkbookFactory.create(inp);
//
//        // Write the output to a file
//        FileOutputStream fileOut;
//        fileOut = new FileOutputStream("c:\\tmp\\unprotectedworkbook.xlsx");
//        wb.write(fileOut);
//        fileOut.close();
//    } catch (InvalidFormatException e) {
//        e.printStackTrace();
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    }        
        
        String COD="",STATUS="",COMPL_STS="",ATENDIMENTO="",PROCESSOS="",SISTEMA="",MP="",TIPO="",
                REGIME_TRIBUTARIO="",QUANT_SOC_GER="",EMPRESA="",NOME="",ENDERECO="",BAIRRO="",
                CIDADE="",EST="",CEP="",CNPJ="",DATA_CNPJ="",IE="",VLR_CAPITAL="",VL_EXTENSO="",VL_COTA="",
                VL_EXT_COTA="",COTAS_TOTAL="",COTAS_EXTENSO="",PERC_CAP_1="",PERC_CAP_2="",
                PERC_CAP_DEMAIS="",SOMA_PERC_CAP="",Cotas_01="",Cotas_02="",PREF="",DATA_IM="",
                N_CONTRIB="",ALIQUOTA_DE_ISS="",ENC_MUNIC="",DT_DISTRATO="",NIRC="",N_REG_CART_OU_NIRE="",
                DATA_REG_CART_OU_JUCESP="",SIND_CNPJ="",ATIVIDADE="",SINDICATO="",CNAE1="",COMP_CNAE1="",
                DIG_CNAE1="",CNAE="",COMP_CNAE="",DIG_CNAE="",FPAS="",QUANT_SocioS="",DATA_INSS="",
                CONSULTORIA_INICIO="",ALOCADO="",INDICADO="",CONSULT_ATUAL="",APELIDO_1="",END_CORRESP="",
                BAIRRO_CO="",CID_CO="",EST_CO="",CEP_CO="",NOME_Socio1="",QUALIDADE1="",NAC_01="",
                NATURALIDADE_1="",EST_CIVEL_01="",maior_EMANCIPADO_1="",PROF_01="",DIA_NASC1="",
                MÊS_NASC1="",ANO_NASC1="",PIS_SOC1="",END_SOC_1="",BAIRRO1_="",CIDADE1="",EST1="",CEP1="",
                RG1="",ORGAO1="",ESTD1="",DATA_EXP1="",CPF1="",EMAIL_SOC_1="",EMAIL_FINANCEIRO="",DDD1="",
                FONERES1="",RES_RAMAL_1="",DDD1COML="",FONECOML1="",COML_RAMAL_1="",DDD1CEL="",
                CELULAR="",DDD1REC="",FONEREC1="",OBSFONE_REC1="",NOME_SOC_2="",QUALIDADE2="",NAC_02="",
                NATURALIDADE_2="",EST_CIVEL_02="",maior_EMANCIPADO_2="",PROF_02="",END_SOC_2="",BAIRRO2="",
                CIDADE2="",EST2="",CEP2="",DIA_NASC2="",MÊS_NASC2="",ANO_NASC2="",PIS_SOC2="",RG2="",ORGAO2="",
                ESTD2="",DATA_EXP2="",CPF2="",DDD2RES="",FONERES2="",DDD2COML="",FONECOM2="",DDD2CEL="",
                CELULAR2="",DDD2REC="",FONEREC2="",HISTÓRIO_DO_STATOS="",OBSFONE_RC2="",bco = "";

        
        try (Scanner scanner = new Scanner(new FileReader("C:\\Users\\User\\Dropbox\\Cadastro.txt"))
                .useDelimiter("\t")) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                    System.out.println("COD:"+scanner.next());
                    System.out.println("STATUS:"+scanner.next());
                    System.out.println("COMPL_STS:"+scanner.next());
                    System.out.println("ATENDIMENTO:"+scanner.next());
                    System.out.println("PROCESSOS:"+scanner.next());
                    System.out.println("SISTEMA:"+scanner.next());
                    System.out.println("MP:"+scanner.next());
                    System.out.println("TIPO:"+scanner.next());
                    System.out.println("REGIME_TRIBUTARIO:"+scanner.next());
                    System.out.println("QUANT_SOC_GER:"+scanner.next());
                    System.out.println("EMPRESA:"+scanner.next());
                    System.out.println("NOME:"+scanner.next());
                    System.out.println("ENDERECO:"+scanner.next());
                    System.out.println("BAIRRO:"+scanner.next());
                    System.out.println("CIDADE:"+scanner.next());
                    System.out.println("EST:"+scanner.next());
                    System.out.println("CEP:"+scanner.next());
                    System.out.println("CNPJ:"+scanner.next());
                    System.out.println("DATA_CNPJ:"+scanner.next());
                    System.out.println("IE:"+scanner.next());
                    System.out.println("VLR_CAPITAL:"+scanner.next());
                    System.out.println("VL_EXTENSO:"+scanner.next());
                    System.out.println("VL_COTA:"+scanner.next());
                    System.out.println("VL_EXT_COTA:"+scanner.next());
                    System.out.println("COTAS_TOTAL:"+scanner.next());
                    System.out.println("COTAS_EXTENSO:"+scanner.next());
                    System.out.println("PERC_CAP_1:"+scanner.next());
                    System.out.println("PERC_CAP_2:"+scanner.next());
                    System.out.println("PERC_CAP_DEMAIS:"+scanner.next());
                    System.out.println("SOMA_PERC_CAP:"+scanner.next());
                    System.out.println("Cotas_01:"+scanner.next());
                    System.out.println("Cotas_02:"+scanner.next());
                    System.out.println("PREF:"+scanner.next());
                    System.out.println("DATA_IM:"+scanner.next());
                    System.out.println("N_CONTRIB:"+scanner.next());
                    System.out.println("ALIQUOTA_DE_ISS:"+scanner.next());
                    System.out.println("ENC_MUNIC:"+scanner.next());
                    System.out.println("DT_DISTRATO:"+scanner.next());
                    System.out.println("NIRC:"+scanner.next());
                    System.out.println("N_REG_CART_OU_NIRE:"+scanner.next());
                    System.out.println("DATA_REG_CART_OU_JUCESP:"+scanner.next());
                    System.out.println("SIND_CNPJ:"+scanner.next());
                    System.out.println("ATIVIDADE:"+scanner.next());
                    System.out.println("SINDICATO:"+scanner.next());
                    System.out.println("CNAE1:"+scanner.next());
                    System.out.println("COMP_CNAE1:"+scanner.next());
                    System.out.println("DIG_CNAE1:"+scanner.next());
                    System.out.println("CNAE:"+scanner.next());
                    System.out.println("COMP_CNAE:"+scanner.next());
                    System.out.println("DIG_CNAE:"+scanner.next());
                    System.out.println("FPAS:"+scanner.next());
                    System.out.println("QUANT_SocioS:"+scanner.next());
                    System.out.println("DATA_INSS:"+scanner.next());
                    System.out.println("CONSULTORIA_INICIO:"+scanner.next());
                    System.out.println("ALOCADO:"+scanner.next());
                    System.out.println("INDICADO:"+scanner.next());
                    System.out.println("CONSULT_ATUAL:"+scanner.next());
                    System.out.println("APELIDO_1:"+scanner.next());
                    System.out.println("END_CORRESP:"+scanner.next());
                    System.out.println("BAIRRO_CO:"+scanner.next());
                    System.out.println("CID_CO:"+scanner.next());
                    System.out.println("EST_CO:"+scanner.next());
                    System.out.println("CEP_CO:"+scanner.next());
                    System.out.println("NOME_Socio1:"+scanner.next());
                    System.out.println("QUALIDADE1:"+scanner.next());
                    System.out.println("NAC_01:"+scanner.next());
                    System.out.println("NATURALIDADE_1:"+scanner.next());
                    System.out.println("EST_CIVEL_01:"+scanner.next());
                    System.out.println("maior_EMANCIPADO_1:"+scanner.next());
                    System.out.println("PROF_01:"+scanner.next());
                    System.out.println("DIA_NASC1:"+scanner.next());
                    System.out.println("MÊS_NASC1:"+scanner.next());
                    System.out.println("ANO_NASC1:"+scanner.next());
                    System.out.println("PIS_SOC1:"+scanner.next());
                    System.out.println("END_SOC_1:"+scanner.next());
                    System.out.println("BAIRRO1_:"+scanner.next());
                    System.out.println("CIDADE1:"+scanner.next());
                    System.out.println("EST1:"+scanner.next());
                    System.out.println("CEP1:"+scanner.next());
                    System.out.println("RG1:"+scanner.next());
                    System.out.println("ORGAO1:"+scanner.next());
                    System.out.println("ESTD1:"+scanner.next());
                    System.out.println("DATA_EXP1:"+scanner.next());
                    System.out.println("CPF1:"+scanner.next());
                    System.out.println("EMAIL_SOC_1:"+scanner.next());
                    System.out.println("EMAIL_FINANCEIRO:"+scanner.next());
                    System.out.println("DDD1:"+scanner.next());
                    System.out.println("FONERES1:"+scanner.next());
                    System.out.println("RES_RAMAL_1:"+scanner.next());
                    System.out.println("DDD1COML:"+scanner.next());
                    System.out.println("FONECOML1:"+scanner.next());
                    System.out.println("COML_RAMAL_1:"+scanner.next());
                    System.out.println("DDD1CEL:"+scanner.next());
                    System.out.println("CELULAR:"+scanner.next());
                    System.out.println("DDD1REC:"+scanner.next());
                    System.out.println("FONEREC1:"+scanner.next());
                    System.out.println("OBSFONE_REC1:"+scanner.next());
                    System.out.println("NOME_SOC_2:"+scanner.next());
                    System.out.println("QUALIDADE2:"+scanner.next());
                    System.out.println("NAC_02:"+scanner.next());
                    System.out.println("NATURALIDADE_2:"+scanner.next());
                    System.out.println("EST_CIVEL_02:"+scanner.next());
                    System.out.println("maior_EMANCIPADO_2:"+scanner.next());
                    System.out.println("PROF_02:"+scanner.next());
                    System.out.println("END_SOC_2:"+scanner.next());
                    System.out.println("BAIRRO2:"+scanner.next());
                    System.out.println("CIDADE2:"+scanner.next());
                    System.out.println("EST2:"+scanner.next());
                    System.out.println("CEP2:"+scanner.next());
                    System.out.println("DIA_NASC2:"+scanner.next());
                    System.out.println("MÊS_NASC2:"+scanner.next());
                    System.out.println("ANO_NASC2:"+scanner.next());
                    System.out.println("PIS_SOC2:"+scanner.next());
                    System.out.println("RG2:"+scanner.next());
                    System.out.println("ORGAO2:"+scanner.next());
                    System.out.println("ESTD2:"+scanner.next());
                    System.out.println("DATA_EXP2:"+scanner.next());
                    System.out.println("CPF2:"+scanner.next());
                    System.out.println("DDD2RES:"+scanner.next());
                    System.out.println("FONERES2:"+scanner.next());
                    System.out.println("DDD2COML:"+scanner.next());
                    System.out.println("FONECOM2:"+scanner.next());
                    System.out.println("DDD2CEL:"+scanner.next());
                    System.out.println("CELULAR2:"+scanner.next());
                    System.out.println("DDD2REC:"+scanner.next());
                    System.out.println("FONEREC2:"+scanner.next());
                    System.out.println("HISTÓRIO_DO_STATOS:"+scanner.next());
                    System.out.println("OBSFONE_RC2:"+scanner.next());
                    System.out.println("bco:"+scanner.nextLine());

            }
            scanner.close();
        }
    }
}
