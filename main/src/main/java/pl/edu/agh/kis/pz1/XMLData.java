package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

/**
 * Class for storing data from XML file
 * @author Piotr Kubala
 */
@XmlRootElement(name = "tns:JPK")
@XmlType(propOrder = { "naglowek", "podmiot1", "listaFaktur", "fakturaCtrl", "listaFakturWiersz", "fakturaWierszCtrl" })
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLData {
    /**
     * Header of the XML file1
     */
    @XmlAttribute(name = "xsi:schemaLocation")
    String schemaLocation = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/ https://www.gov.pl/attachment/1abeab45-4e71-4616-b8d5-6b71699e86f8";

    /**
     * Header of the XML file2
     */
    @XmlAttribute(name = "xmlns:tns")
    String xmlnsTns = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/";

    /**
     * Header of the XML file3
     */
    @XmlAttribute(name = "xmlns:xsi")
    String xsi = "http://www.w3.org/2001/XMLSchema-instance";

    /**
     * Header of the XML file4
     */
    @XmlAttribute(name = "xmlns:etd")
    String etd = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/";

    /**
     * Header of the XML file5
     */
    @XmlAttribute(name = "xmlns:kck")
    String kck = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2013/05/23/eD/KodyCECHKRAJOW/";

    /**
     * Header of the XML file6
     */
    @XmlAttribute(name = "xmlns:xsd")
    String xsd = "http://www.w3.org/2001/XMLSchema";

    /**
     * Header of the XML file7
     */
    @XmlAttribute(name = "xmlns:msxsl")
    String msxsl = "urn:schemas-microsoft-com:xslt";

    /**
     * Header of the XML file8
     */
    @XmlAttribute(name = "xmlns:usr")
    String usr = "urn:the-xml-files:xslt";

    /**
     * Naglowek of the XML file
     */
    @XmlRootElement(name = "tns:Naglowek")
    @XmlType(propOrder = {"wersjaFormularza", "wariantFormularza", "celZlozenia", "dataWytworzeniaJPK", "dataOd", "dataDo", "kodUrzedu" })
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Naglowek {
        /**
         * Wersja formularza
         */
        @XmlRootElement(name = "tns:KodFormularza")
        @XmlType(propOrder = { "kodSystemowy", "wersjaSchemy" })
        @XmlAccessorType(XmlAccessType.FIELD)
        static class WersjaFormularza {
            /**
             * Kod systemowy
             */
            @XmlAttribute(name = "kodSystemowy")
            String kodSystemowy = "JPK_FA (3)";
            /**
             * Wersja schemy
             */
            @XmlValue
            String JPK_FA = "JPK_FA";
            /**
             * Wersja schemy
             */
            @XmlAttribute(name = "wersjaSchemy")
            String wersjaSchemy = "1-0";
        }

        /**
         * Kod formularza
         */
        @XmlElement(name = "tns:KodFormularza")
        WersjaFormularza wersjaFormularza = new WersjaFormularza();

        /**
         * Wariant formularza
         */
        @XmlElement(name = "tns:WersjaFormularza")
        String wariantFormularza = "3";

        /**
         * Cel zlozenia
         */
        @XmlElement(name = "tns:CelZlozenia")
        String celZlozenia = "1";

        /**
         * Data wytworzenia JPK
         */
        @XmlElement(name = "tns:DataWytworzeniaJPK")
        String dataWytworzeniaJPK = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")).format(new java.util.Date());

        /**
         * Data od
         */
        @XmlElement(name = "tns:DataOd")
        String dataOd = "2020-10-01";

        /**
         * Data do
         */
        @XmlElement(name = "tns:DataDo")
        String dataDo = "2020-12-31";

        /**
         * Kod urzedu
         */
        @XmlElement(name = "tns:KodUrzedu")
        String kodUrzedu = "1208";
    }

    /**
     * Naglowek of the XML file
     */
    @XmlRootElement(name = "tns:Podmiot1")
    @XmlType(propOrder = {"identyfikatorPodmiotu", "adresPodmiotu"})
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Podmiot1 {
        /**
         * Identyfikator podmiotu
         */
        @XmlRootElement(name = "tns:IdentyfikatorPodmiotu")
        @XmlType(propOrder = { "NIP", "PelnaNazwa" })
        @XmlAccessorType(XmlAccessType.FIELD)
        static class IdentyfikatorPodmiotu {
            /**
             * NIP
             */
            @XmlElement(name = "etd:NIP")
            String NIP = "6762484560";
            /**
             * Pelna nazwa
             */
            @XmlElement(name = "etd:PelnaNazwa")
            String PelnaNazwa = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        }

        /**
         * Identyfikator podmiotu
         */
        @XmlRootElement(name = "tns:AdressPodmiotu")
        @XmlType(propOrder = { "kodKraju", "wojewodztwo", "powiat", "gmina", "ulica", "nrDomu", "nrLokalu", "miejscowosc", "kodPocztowy" })
        @XmlAccessorType(XmlAccessType.FIELD)
        static class AdresPodmiotu {
            /**
             * Kod kraju
             */
            @XmlElement(name = "etd:KodKraju")
            String kodKraju = "PL";
            /**
             * Wojewodztwo
             */
            @XmlElement(name = "etd:Wojewodztwo")
            String wojewodztwo = "małopolskie";
            /**
             * Powiat
             */
            @XmlElement(name = "etd:Powiat")
            String powiat = "m. Kraków";
            /**
             * Gmina
             */
            @XmlElement(name = "etd:Gmina")
            String gmina = "Kraków";
            /**
             * Ulica
             */
            @XmlElement(name = "etd:Ulica")
            String ulica = "ul. Feliksa Radwańskiego";
            /**
             * Nr domu
             */
            @XmlElement(name = "etd:NrDomu")
            String nrDomu = "15";
            /**
             * Nr lokalu
             */
            @XmlElement(name = "etd:NrLokalu")
            String nrLokalu = "1";
            /**
             * Miejscowosc
             */
            @XmlElement(name = "etd:Miejscowosc")
            String miejscowosc = "Kraków";
            /**
             * Kod pocztowy
             */
            @XmlElement(name = "etd:KodPocztowy")
            String kodPocztowy = "31-123";
        }

        /**
         * Identyfikator podmiotu
         */
        @XmlElement(name = "tns:IdentyfikatorPodmiotu")
        IdentyfikatorPodmiotu identyfikatorPodmiotu = new IdentyfikatorPodmiotu();

        /**
         * Adres podmiotu
         */
        @XmlElement(name = "tns:AdresPodmiotu")
        AdresPodmiotu adresPodmiotu = new AdresPodmiotu();
    }

    /**
     * Naglowek of the XML file
     */
    @XmlElement(name = "tns:Naglowek")
    Naglowek naglowek = new Naglowek();

    /**
     * Podmiot of the XML file
     */
    @XmlElement(name = "tns:Podmiot1")
    Podmiot1 podmiot1 = new Podmiot1();

    /**
     * Faktura of the XML file
     */
    @XmlElement(name = "tns:Faktura")
    LinkedList<Faktura> listaFaktur;

    /**
     * FakturaWiersz of the XML file
     */
    @XmlElement(name = "tns:FakturaWiersz")
    LinkedList<FakturaWiersz> listaFakturWiersz;

    /**
     * FakturaCtrl of the XML file
     */
    @XmlRootElement(name = "tns:FakturaCtrl")
    @XmlType(propOrder = { "liczbaFaktur", "wartoscFaktur" })
    static class FakturaCtrl {
        /**
         * Liczba faktur
         */
        @XmlElement(name = "LiczbaFaktur")
        public int liczbaFaktur;
        /**
         * Wartosc faktur
         */
        @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
        @XmlElement(name = "WartoscFaktur")
        public Integer wartoscFaktur = 0;
    }

    /**
     * FakturaWierszCtrl of the XML file
     */
    @XmlRootElement(name = "tns:FakturaWierszCtrl")
    @XmlType(propOrder = { "liczbaWierszyFaktur", "wartoscWierszyFaktur" })
    static class FakturaWierszCtrl {
        /**
         * Liczba wierszy faktur
         */
        @XmlElement(name = "LiczbaWierszyFaktur")
        public int liczbaWierszyFaktur;
        /**
         * Wartosc wierszy faktur
         */
        @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
        @XmlElement(name = "WartośćWierszyFaktur")
        public Integer wartoscWierszyFaktur = 0;
    }

    /**
     * FakturaCtrl of the XML file
     */
    @XmlElement(name = "tns:FakturaCtrl")
    FakturaCtrl fakturaCtrl;
    /**
     * FakturaWierszCtrl of the XML file
     */
    @XmlElement(name = "tns:FakturaWierszCtrl")
    FakturaWierszCtrl fakturaWierszCtrl;

    /**
     * Konstruktor
     */
    public XMLData() {
        listaFaktur = new LinkedList<>();
        listaFakturWiersz = new LinkedList<>();
        fakturaWierszCtrl = new FakturaWierszCtrl();
        fakturaCtrl = new FakturaCtrl();
    }

    /**
     * Dodaje fakturę do listy faktur
     *
     * @param faktura
     *            faktura do dodania
     */
    public void addFaktura(Faktura faktura) {
        listaFaktur.add(faktura);

        fakturaCtrl.liczbaFaktur++;
        fakturaCtrl.wartoscFaktur += faktura.getCenaBruttoFakturyLacznieL();
    }

    /**
     * Dodaje wiersz faktury do listy wierszy faktur
     *
     * @param fakturaWiersz
     *            wiersz faktury do dodania
     */
    public void addFakturaWiersz(FakturaWiersz fakturaWiersz) {
        listaFakturWiersz.add(fakturaWiersz);

        fakturaWierszCtrl.liczbaWierszyFaktur++;
        fakturaWierszCtrl.wartoscWierszyFaktur += fakturaWiersz.getCenaNettoL();
    }
}
