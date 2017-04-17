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
    public void convertBasicNumbers() throws Exception {
        assertEquals(conversor.convert(500), "D");
    }

    @Test
    public void convertNumberAntecedentThatRest() throws Exception{
            assertEquals(conversor.convert(4), "IV");
    }

    @Test
    public void convertACompoundNumber() throws Exception{
        assertEquals(conversor.convert(1800), "MDCCC");
    }

    @Test()
    public void convertNumber0() throws Exception {
        expectedException.expect(InvalidNumberException.class);
        expectedException.expectMessage("The number must be positive and minor to 3001");
        conversor.convert(0);
    }

    @Test
    public void raiseAndExceptionForNumber3999() throws Exception{
        expectedException.expect(InvalidNumberException.class);
        expectedException.expectMessage("The number must be positive and minor to 3001");
        conversor.convert(3999);
    }

    @Test
    public void raiseAndExceptionForNumberNegative1() throws Exception{
        expectedException.expect(InvalidNumberException.class);
        expectedException.expectMessage("The number must be positive and minor to 3001");
        conversor.convert(-1);
    }
}