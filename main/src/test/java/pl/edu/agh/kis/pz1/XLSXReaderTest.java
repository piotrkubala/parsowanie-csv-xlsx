package pl.edu.agh.kis.pz1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Test class for XLSXReader
 * @author Piotr Kubala
 */
public class XLSXReaderTest {
    /**
     * Test for constructor
     */
    @Test
    public void testConstructor() {
        // given
        XLSXReader xlsxReader = null;

        // when
        try {
            xlsxReader = new XLSXReader("../TestFiles/In/faktury-sprzedazowe-test-2023.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then
        assertNotEquals(null, xlsxReader);
    }
}
