package pl.edu.agh.kis.pz1;

import static junit.framework.TestCase.assertNotNull;
import org.junit.Test;

/**
 * @author Piotr Kubala
 */
public class MainTest {
    /**
     * Test for the construction of Main and the 
     * main method being called.
     */
    @Test
    public void shouldCreateMainObject(){
        Main main = new Main();
        Main.main(new String[] {"../TestFiles/In/faktury-sprzedazowe-test-short-2023.csv", "../TestFiles/Out/faktury-sprzedazowe-test-2023.xml" });
        assertNotNull("Main method called.", main);
    }
}


