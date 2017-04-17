package numbers;

import exceptions.InvalidNumberException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ConvertNumbersTest {

    private NumberConversor conversor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp()  {
        conversor = new NumberConversor();
    }
    @Test
    public void convertBasicNumber() throws Exception {
        assertEquals(conversor.convert(500), "D");
    }

    @Test
    public void convertNumberAntecedentThatRest() throws Exception{
        assertEquals(conversor.convert(9), "IX");
    }

    @Test
    public void convertNumberWithTwoFigures() throws Exception{
        assertEquals(conversor.convert(20), "XX");
    }

    @Test
    public void convertNumberWithThreeFigures() throws Exception{
        assertEquals(conversor.convert(250), "CCL");
    }

    @Test
    public void convertACompoundNumber() throws Exception{
        assertEquals(conversor.convert(1800), "MDCCC");
    }

    @Test()
    public void raiseExceptionForNumber0() throws Exception {
        expectedException.expect(InvalidNumberException.class);
        expectedException.expectMessage("The number must be positive and minor to 3001");
        conversor.convert(0);
    }

    @Test
    public void raiseExceptionForNumber3999() throws Exception{
        expectedException.expect(InvalidNumberException.class);
        expectedException.expectMessage("The number must be positive and minor to 3001");
        conversor.convert(3999);
    }

    @Test
    public void raiseExceptionForNumber1Negative() throws Exception{
        expectedException.expect(InvalidNumberException.class);
        expectedException.expectMessage("The number must be positive and minor to 3001");
        conversor.convert(-1);
    }
}