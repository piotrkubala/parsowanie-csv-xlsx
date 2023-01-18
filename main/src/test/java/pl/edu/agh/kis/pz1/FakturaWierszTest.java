package pl.edu.agh.kis.pz1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Test class for FakturaWiersz
 * @author Piotr Kubala
 */
public class FakturaWierszTest {
    /**
     * Test for constructor
     */
    @Test
    public void testConstructor() {
        // given
        FakturaWiersz fakturaWiersz = new FakturaWiersz();

        // when

        // then
        assertNotEquals(null, fakturaWiersz);
    }
}
