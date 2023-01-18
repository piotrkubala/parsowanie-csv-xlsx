package pl.edu.agh.kis.pz1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Test class for Faktura
 * @author Piotr Kubala
 */
public class FakturaTest {
    /**
     * Test for constructor
     */
    @Test
    public void testConstructor() {
        // given
        Faktura faktura = new Faktura();

        // when

        // then
        assertNotEquals(null, faktura);
    }
}
