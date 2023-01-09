package pl.edu.agh.kis.pz1;

import org.apache.commons.csv.CSVFormat;//potrzebne importy
import org.apache.commons.csv.CSVRecord;//j.w.
import pl.edu.agh.kis.pz1.util.CustomLogger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

public class CSVReader {
    String filename;
    Reader in;

    CustomLogger logger = new CustomLogger(CSVReader.class.getName());

    public CSVReader(String filename) throws FileNotFoundException {
        this.filename = filename;

        this.in = new FileReader(filename);
    }

    public XMLData readCSV() throws IOException {
        CSVFormat format = CSVFormat.EXCEL.withDelimiter('\t');

        HashMap<String, Faktura> mapFaktury = new HashMap<>();

        Iterable<CSVRecord> records = format.parse(in);

        XMLData xmlData = new XMLData();

        records.iterator().next();//pomijamy pierwszy wiersz

        for (CSVRecord record : records) {
            //przetworz kolejny wiersz - pierwsza kolumn to nazwa firmy
            String nrFaktury = record.get(5);

            if (!mapFaktury.containsKey(nrFaktury)) {
                Faktura faktura = new Faktura(record.get(0), record.get(1), record.get(2), record.get(3), record.get(4), nrFaktury, record.get(13), record.get(14));
                mapFaktury.put(nrFaktury, faktura);

                xmlData.addFaktura(faktura);
            }

            try {
                FakturaWiersz fakturaWiersz = new FakturaWiersz(record.get(6), record.get(7), record.get(8), record.get(9), record.get(10), record.get(11), record.get(12), nrFaktury);
                xmlData.addFakturaWiersz(fakturaWiersz);
            } catch (Exception e) {
                logger.severe(String.format("Błąd podczas parsowania komórki faktury: %s", e.getMessage()));
            }
        }

        return xmlData;
    }
}
