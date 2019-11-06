package exercitii;

import com.sda.ExInterviu;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExInterviuTest {

    @Test
    public void verifyPin() {
        ExInterviu test = new ExInterviu();
        boolean output = test.verifyPin("sdfasd12");
        assertEquals(true, output);
    }
}