package pl.edu.agh.kis.pz1;

import pl.edu.agh.kis.pz1.util.CustomLogger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Przykładowy kod do zajęć laboratoryjnych 2, 3, 4 z przedmiotu: Programowanie zaawansowane 1
 * @author Paweł Skrzyński
 */
public class Main {
    static CustomLogger logger = new CustomLogger(Main.class.getName());

    public static void main(String[] args) {
        if (args.length < 2) {
            logger.severe("Nie podano argumentu!");
            logger.info("Podaj argumenty: nazwa_pliku_wejsciowego nazwa_pliku_wyjsciowego");
            return;
        }

        String filename = args[0];
        String output_filename = args[1];

        logger.info("Plik do odczytu: " + filename);

        try {
            XMLData xmlData = null;

            if (filename.endsWith(".xlsx")) {
                XLSXReader reader = new XLSXReader(filename);
                xmlData = reader.readXLSX();
            } else if (filename.endsWith(".csv")) {
                CSVReader reader = new CSVReader(filename);
                xmlData = reader.readCSV();
            } else {
                logger.severe("Nieobsługiwany format pliku!");
            }

            if (xmlData != null) {
                JAXBContext context = JAXBContext.newInstance(XMLData.class);
                Marshaller mar = context.createMarshaller();
                mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                mar.setProperty(Marshaller.JAXB_FRAGMENT, true);
                mar.marshal(xmlData, new File(output_filename));
            }
        } catch (Exception e) {
            logger.severe("Wystąpił błąd: " + e.getMessage());
        }
    }
}
