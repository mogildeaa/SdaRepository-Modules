package com.sda.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

/**
 * Anotarea indica faptul ca aceasta clasa de test se va rula cu un runner specific( Ex: Parameterized.class)
 */
@RunWith(Parameterized.class)
public class CalculatorTestParametrizat {

    private Calculator target = new Calculator(0, 0);

    /**
     * Pentru fiecare parametru care va fi preluat dintr-un array de input trebuie salvata valoarea intr-o variabila
     * de acel tip. Mecanism obtinut cu anotarea @Parameterized.Parameter(<indexul din array al valorii dorite>)
     */
    @Parameter(0)
    public int parametru1;
    @Parameter(1)
    public int parametru2;
    @Parameter(2)
    public int parametru3;

    /**
     * Avem nevoie de o metoda publica si statica, care sa intoarca o colectie de array-uri de tipul care trebuie testat
     * Am nevoie de colectie pentru ca trebuie implementata interfata Iterable (in spate trbeuie sa imi construiasca un
     * iterator de array-uri. E nevoie sa fie statica pentru a nu depinde de clasa de test (nu trb instantiata)
     * Se anoteaza cu @Parameters pt a-i indica Runnerului ca e sursa de date.
     * @return
     */
    @Parameters
    public static Collection<Integer[]> initializedImputParameters() {
        return Arrays.asList(
                new Integer[][]{
                        {1, 2, 3},
                        {2, 3, 5},
                        {3, 5, 8},
                        {123, 698, 821},
                        {1, 1, 2}
                }
        );
    }

    @Test
    public void aduna() {
        assertEquals(parametru3, target.aduna(parametru1, parametru2));
    }
}