package pl.edu.agh.kis.pz1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Test class for XMLData
 * @author Piotr Kubala
 */
public class XMLDataTest {
    /**
     * Test for constructor
     */
    @Test
    public void testConstructor() {
        // given
        XMLData xMLData = new XMLData();

        // when

        // then
        assertNotEquals(null, xMLData);
    }
}
