package trabalho2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ProximaDataTest {
    private ProximaData proximaData;

    @Test
    public void testCheckerLength() {
        proximaData = new ProximaData();
        assertEquals("13/12/2020", proximaData.checkerLength("12/12/2020"));
        assertEquals("ERRO: tamanho invalido.", proximaData.checkerLength("12/12/20"));
        assertEquals("ERRO: tamanho invalido.", proximaData.checkerLength("12/12/2020/"));
        assertEquals("13/12/2020", proximaData.checkerLength("12/12/2020"));
        assertEquals("13/11/2020", proximaData.checkerLength("12/11/2020"));
       
    }

    @Test
    public void testCheckerDigit() {
        proximaData = new ProximaData();
        assertEquals("ERRO: nao utilizou '/'.", proximaData.checkerDigit("12122020"));
        assertEquals("ERRO: nao utilizou '/'.", proximaData.checkerDigit("12 12 2020"));
        assertEquals("ERRO: nao utilizou digito.", proximaData.checkerDigit("12/12/20a0"));
        assertEquals("ERRO: nao utilizou digito.", proximaData.checkerDigit("1-/12/2020"));
        assertEquals("13/12/2020", proximaData.checkerDigit("12/12/2020"));
        
    }

    @Test
    public void testCheckerValidYear() {
        proximaData = new ProximaData();
        assertEquals("ERRO: data invalida.", proximaData.checkerValidYear("12/12/9999"));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidYear("12/12/1400"));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidYear("12/12/1599"));
        assertEquals("13/12/2020", proximaData.checkerValidYear("12/12/2020"));
        assertEquals("13/12/1600", proximaData.checkerValidYear("12/12/1600"));
        assertEquals(null, proximaData.checkerValidYear("10/10"));
    
    }

    @Test
    public void testCheckerValidMonth() {
        proximaData = new ProximaData();
        assertEquals("ERRO: data invalida.", proximaData.checkerValidMonth("12/13/2020", 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidMonth("12/00/2020", 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidMonth("12/99/2020", 2020));
        assertEquals("13/12/2020", proximaData.checkerValidMonth("12/12/2020", 2020));
        assertEquals("13/01/2020", proximaData.checkerValidMonth("12/01/2020", 2020));
        assertEquals(null, proximaData.checkerValidMonth("11", 2020));
    }

    @Test
    public void testCheckerValidDay() {
        proximaData = new ProximaData();
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("32/12/2020", 12, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("00/12/2020", 12, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("99/12/2020", 12, 2020));
        assertEquals("13/12/2020", proximaData.checkerValidDay("12/12/2020", 12, 2020));
        assertEquals("01/12/2020", proximaData.checkerValidDay("30/11/2020", 11, 2020));
        assertEquals("01/02/2020", proximaData.checkerValidDay("31/01/2020", 1, 2020));
        assertEquals("01/03/2020", proximaData.checkerValidDay("29/02/2020", 2, 2020)); 
        assertEquals("01/03/2021", proximaData.checkerValidDay("28/02/2021", 2, 2021)); 
        assertEquals("01/05/2020", proximaData.checkerValidDay("30/04/2020", 4, 2020));
        assertEquals("01/07/2020", proximaData.checkerValidDay("30/06/2020", 6, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/06/2020", 6, 2020));
        assertEquals("01/09/2020", proximaData.checkerValidDay("31/08/2020", 8, 2020));
        assertEquals("01/11/2020", proximaData.checkerValidDay("31/10/2020", 10, 2020));
        assertEquals("01/01/2021", proximaData.checkerValidDay("31/12/2020", 12, 2020));
        assertEquals("01/04/2020", proximaData.checkerValidDay("31/03/2020", 3, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/04/2020", 4, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("29/02/2021", 2, 2021));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("30/02/2020", 2, 2020));
        assertEquals("09/02/2020", proximaData.checkerValidDay("08/02/2020", 2, 2020));
        assertEquals("09/02/2021", proximaData.checkerValidDay("08/02/2021", 2, 2021));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("00/04/2020", 4, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/04/2020", 4, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("00/06/2020", 6, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/06/2020", 6, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("00/09/2020", 9, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/09/2020", 9, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("00/11/2020", 11, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/11/2020", 11, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("31/11/2020", 11, 2020));
        assertEquals("ERRO: data invalida.", proximaData.checkerValidDay("32/2/2020", 2, 2020));
        assertEquals("01/05/2020", proximaData.checkerValidDay("30/4/2020", 4, 2020));
        assertEquals("01/02/2020", proximaData.checkerValidDay("31/1/2020", 1, 2020));
        assertEquals(null, proximaData.checkerValidDay("", 11, 2020));
       
    }

    @Test
    public void testProximoDia(){
        ProximaData proximaData = new ProximaData(); 
        assertEquals("02/11/2020", proximaData.proximoDia(1, 11, 2020));
        assertEquals("01/12/2020", proximaData.proximoDia(30, 11, 2020));
        assertEquals("01/01/2021", proximaData.proximoDia(31, 12, 2020));
        assertEquals("01/02/2020", proximaData.proximoDia(31, 1, 2020));
        assertEquals("29/02/2020", proximaData.proximoDia(28, 2, 2020));
        assertEquals("01/03/2020", proximaData.proximoDia(29, 2, 2020));
        assertEquals("01/03/2021", proximaData.proximoDia(28, 2, 2021));
        assertEquals("01/02/2021", proximaData.proximoDia(31, 1, 2021)); 
        assertEquals("01/03/2021", proximaData.proximoDia(28, 2, 2021)); 
        assertEquals("01/04/2021", proximaData.proximoDia(31, 3, 2021)); 
        assertEquals("01/05/2021", proximaData.proximoDia(30, 4, 2021)); 
        assertEquals("01/06/2021", proximaData.proximoDia(31, 5, 2021)); 
        assertEquals("01/07/2021", proximaData.proximoDia(30, 6, 2021)); 
        assertEquals("01/08/2021", proximaData.proximoDia(31, 7, 2021)); 
        assertEquals("01/09/2021", proximaData.proximoDia(31, 8, 2021)); 
        assertEquals("01/10/2021", proximaData.proximoDia(30, 9, 2021)); 
        assertEquals("01/11/2021", proximaData.proximoDia(31, 10, 2021)); 
        assertEquals("01/12/2021", proximaData.proximoDia(30, 11, 2021)); 
        assertEquals("01/01/2022", proximaData.proximoDia(31, 12, 2021)); 
                
        
    }
    
}

