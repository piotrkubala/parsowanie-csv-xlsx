package pl.edu.agh.kis.pz1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.edu.agh.kis.pz1.util.CustomLogger;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;

public class XLSXReader {
    String filename;

    FileInputStream file;
    XSSFWorkbook workbook;

    CustomLogger logger = new CustomLogger(XLSXReader.class.getName());

    public XLSXReader(String filename) {
        try {
            this.filename = filename;

            this.file = new FileInputStream(filename);
            this.workbook = new XSSFWorkbook(file);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    public XMLData readXLSX() {
        //Pobierz pierwszy arkusz w pliku XLSX
        XSSFSheet sheet = workbook.getSheetAt(0);
        //Wczytaj wiersze
        Iterator<Row> rowIterator = sheet.iterator();

        XMLData xmlData = new XMLData();

        HashMap<String, Faktura> mapFaktury = new HashMap<>();

        for (rowIterator.next(); rowIterator.hasNext(); ) {
            Row row = rowIterator.next();

            for (int i = 0; i < 15; i++) {
                row.getCell(i).setCellType(1);
            }

            String nrFaktury = row.getCell(5).getStringCellValue();

            if (!mapFaktury.containsKey(nrFaktury)) {
                Faktura faktura = new Faktura(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue(), nrFaktury, row.getCell(13).getStringCellValue(), row.getCell(14).getStringCellValue());
                mapFaktury.put(nrFaktury, faktura);

                xmlData.addFaktura(faktura);
            }

            try {
                FakturaWiersz fakturaWiersz = new FakturaWiersz(row.getCell(6).getStringCellValue(), row.getCell(7).getStringCellValue(), row.getCell(8).getStringCellValue(),
                                                                row.getCell(9).getStringCellValue(), row.getCell(10).getStringCellValue(),
                                                                row.getCell(11).getStringCellValue(), row.getCell(12).getStringCellValue(), nrFaktury);

                xmlData.addFakturaWiersz(fakturaWiersz);
            } catch (Exception e) {
                logger.severe(String.format("Błąd podczas parsowania komórki faktury: %s", e.getMessage()));
            }
        }

        return xmlData;
    }
}
