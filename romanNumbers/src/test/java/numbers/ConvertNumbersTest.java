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
    public void convertNumber1() {
        assertEquals(conversor.convert(1), "I");
    }

    @Test
    public void convertNumber5() {
        assertEquals(conversor.convert(5), "V");
    }

    @Test
    public void convertBasicNumbers() {
        assertEquals(conversor.convert(500), "D");
    }

    @Test
    public void convertNumber2() {
        assertEquals(conversor.convert(2), "II");
    }

    @Test
    public void convertNumber3(){
        assertEquals(conversor.convert(3), "III");
    }

    @Test
    public void convertNumber4(){
        assertEquals(conversor.convert(4), "IV");
    }
}
