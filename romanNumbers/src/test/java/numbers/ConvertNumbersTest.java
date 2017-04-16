package numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertNumbersTest {

    private NumberConversor conversor;

    @Before
    public void setUp() {
        conversor = new NumberConversor();
    }

    @Test
    public void convertNumber0() {
        assertEquals(conversor.convert(0), " ");
    }

    @Test
    public void convertBasicNumbers() {
        assertEquals(conversor.convert(500), "D");
    }

    @Test
    public void convertNumberAntecedentThatRest(){
            assertEquals(conversor.convert(4), "IV");
    }

    @Test
    public void convertACompoundNumber(){
        assertEquals(conversor.convert(1800), "MDCCC");
    }

    @Test
    public void raiseAndExceptionForNumber3999(){
        assertEquals(conversor.convert(3999), "The number must be positive and minor to 3001");
    }
}