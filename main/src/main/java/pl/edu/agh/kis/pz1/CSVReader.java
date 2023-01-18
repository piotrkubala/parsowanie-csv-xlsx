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

        for (CSVRecord csv_record : records) {
            //przetworz kolejny wiersz - pierwsza kolumn to nazwa firmy
            String nrFaktury = csv_record.get(5);

            if (!mapFaktury.containsKey(nrFaktury)) {
                Faktura faktura = new Faktura(csv_record.get(0), csv_record.get(1), csv_record.get(2), csv_record.get(3), csv_record.get(4), nrFaktury, csv_record.get(13), csv_record.get(14));
                mapFaktury.put(nrFaktury, faktura);

                xmlData.addFaktura(faktura);
            }

            try {
                FakturaWiersz fakturaWiersz = new FakturaWiersz(csv_record.get(6), csv_record.get(7), csv_record.get(8), csv_record.get(9), csv_record.get(10), csv_record.get(11), csv_record.get(12), nrFaktury);
                xmlData.addFakturaWiersz(fakturaWiersz);
            } catch (Exception e) {
                logger.severe(String.format("Błąd podczas parsowania komórki faktury: %s", e.getMessage()));
            }
        }

        return xmlData;
    }
}
