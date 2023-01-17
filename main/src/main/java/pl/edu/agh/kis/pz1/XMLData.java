package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

@XmlRootElement(name = "tns:JPK")
@XmlType(propOrder = { "naglowek", "podmiot1", "listaFaktur", "fakturaCtrl", "listaFakturWiersz", "fakturaWierszCtrl" })
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLData {
    @XmlRootElement(name = "tns:Naglowek")
    @XmlType(propOrder = {"wersjaFormularza", "wariantFormularza", "celZlozenia", "dataWytworzeniaJPK", "dataOd", "dataDo", "kodUrzedu" })
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Naglowek {
        @XmlRootElement(name = "tns:KodFormularza")
        @XmlType(propOrder = {})
        @XmlAccessorType(XmlAccessType.FIELD)
        static class WersjaFormularza {
            @XmlAttribute(name = "kodSystemowy")
            String kodSystemowy = "JPK_FA (3)";
            @XmlAttribute(name = "wersjaSchemy")
            String wersjaSchemy = "1-0";
        }

        @XmlElement(name = "tns:KodFormularza")
        WersjaFormularza wersjaFormularza = new WersjaFormularza();

        @XmlElement(name = "tns:WersjaFormularza")
        String wariantFormularza = "3";

        @XmlElement(name = "tns:CelZlozenia")
        String celZlozenia = "1";

        @XmlElement(name = "tns:DataWytworzeniaJPK")
        String dataWytworzeniaJPK = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")).format(new java.util.Date());

        @XmlElement(name = "tns:DataOd")
        String dataOd = "2020-10-01";

        @XmlElement(name = "tns:DataDo")
        String dataDo = "2020-12-31";

        @XmlElement(name = "tns:KodUrzedu")
        String kodUrzedu = "1208";
    }

    @XmlRootElement(name = "tns:Podmiot1")
    @XmlType(propOrder = {"identyfikatorPodmiotu", "adresPodmiotu"})
    @XmlAccessorType(XmlAccessType.FIELD)
    static class Podmiot1 {
        @XmlRootElement(name = "tns:IdentyfikatorPodmiotu")
        @XmlType(propOrder = { "NIP", "PelnaNazwa" })
        @XmlAccessorType(XmlAccessType.FIELD)
        static class IdentyfikatorPodmiotu {
            @XmlElement(name = "etd:NIP")
            String NIP = "6762484560";
            @XmlElement(name = "etd:PelnaNazwa")
            String PelnaNazwa = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
        }

        @XmlRootElement(name = "tns:AdressPodmiotu")
        @XmlType(propOrder = { "kodKraju", "wojewodztwo", "powiat", "gmina", "ulica", "nrDomu", "nrLokalu", "miejscowosc", "kodPocztowy" })
        @XmlAccessorType(XmlAccessType.FIELD)
        static class AdresPodmiotu {
            @XmlElement(name = "etd:KodKraju")
            String kodKraju = "PL";
            @XmlElement(name = "etd:Wojewodztwo")
            String wojewodztwo = "małopolskie";
            @XmlElement(name = "etd:Powiat")
            String powiat = "m. Kraków";
            @XmlElement(name = "etd:Gmina")
            String gmina = "Kraków";
            @XmlElement(name = "etd:Ulica")
            String ulica = "ul. Feliksa Radwańskiego";
            @XmlElement(name = "etd:NrDomu")
            String nrDomu = "15";
            @XmlElement(name = "etd:NrLokalu")
            String nrLokalu = "1";
            @XmlElement(name = "etd:Miejscowosc")
            String miejscowosc = "Kraków";
            @XmlElement(name = "etd:KodPocztowy")
            String kodPocztowy = "31-123";
        }

        @XmlElement(name = "tns:IdentyfikatorPodmiotu")
        IdentyfikatorPodmiotu identyfikatorPodmiotu = new IdentyfikatorPodmiotu();

        @XmlElement(name = "tns:AdresPodmiotu")
        AdresPodmiotu adresPodmiotu = new AdresPodmiotu();
    }

    @XmlElement(name = "tns:Naglowek")
    Naglowek naglowek = new Naglowek();

    @XmlElement(name = "tns:Podmiot1")
    Podmiot1 podmiot1 = new Podmiot1();

    @XmlElement(name = "tns:Faktura")
    LinkedList<Faktura> listaFaktur;
    @XmlElement(name = "tns:FakturaWiersz")
    LinkedList<FakturaWiersz> listaFakturWiersz;

    @XmlRootElement(name = "tns:FakturaCtrl")
    @XmlType(propOrder = { "liczbaFaktur", "wartoscFaktur" })
    static class FakturaCtrl {
        @XmlElement(name = "LiczbaFaktur")
        public int liczbaFaktur;
        @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
        @XmlElement(name = "WartoscFaktur")
        public Integer wartoscFaktur = 0;
    }

    @XmlRootElement(name = "tns:FakturaWierszCtrl")
    @XmlType(propOrder = { "liczbaWierszyFaktur", "wartoscWierszyFaktur" })
    static class FakturaWierszCtrl {
        @XmlElement(name = "LiczbaWierszyFaktur")
        public int liczbaWierszyFaktur;
        @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
        @XmlElement(name = "WartośćWierszyFaktur")
        public Integer wartoscWierszyFaktur = 0;
    }

    @XmlElement(name = "tns:FakturaCtrl")
    FakturaCtrl fakturaCtrl;
    @XmlElement(name = "tns:FakturaWierszCtrl")
    FakturaWierszCtrl fakturaWierszCtrl;

    public XMLData() {
        listaFaktur = new LinkedList<>();
        listaFakturWiersz = new LinkedList<>();
        fakturaWierszCtrl = new FakturaWierszCtrl();
        fakturaCtrl = new FakturaCtrl();
    }

    public void addFaktura(Faktura faktura) {
        listaFaktur.add(faktura);

        fakturaCtrl.liczbaFaktur++;
        fakturaCtrl.wartoscFaktur += faktura.getCenaBruttoFakturyLacznieL();
    }

    public void addFakturaWiersz(FakturaWiersz fakturaWiersz) {
        listaFakturWiersz.add(fakturaWiersz);

        fakturaWierszCtrl.liczbaWierszyFaktur++;
        fakturaWierszCtrl.wartoscWierszyFaktur += fakturaWiersz.getCenaNettoL();
    }
}
