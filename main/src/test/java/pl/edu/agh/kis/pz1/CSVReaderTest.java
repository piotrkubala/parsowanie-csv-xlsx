package pl.edu.agh.kis.pz1;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Test class for CSVReader
 */
public class CSVReaderTest {
    /**
     * Test for constructor
     */
    @Test
    public void testConstructor() {
        // given
        CSVReader csvReader = null;

        // when
        try {
            csvReader = new CSVReader("../TestFiles/In/faktury-sprzedazowe-test-short-2023.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then
        assertNotEquals(null, csvReader);
    }
}
