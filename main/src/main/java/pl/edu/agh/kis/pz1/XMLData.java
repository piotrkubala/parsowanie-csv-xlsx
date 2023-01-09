package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.LinkedList;

@XmlRootElement(name = "JPK")
@XmlType(propOrder = { "listaFaktur", "fakturaCtrl", "listaFakturWiersz", "fakturaWierszCtrl" })
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLData {
    @XmlElement(name = "Faktura")
    LinkedList<Faktura> listaFaktur;
    @XmlElement(name = "FakturaWiersz")
    LinkedList<FakturaWiersz> listaFakturWiersz;

    @XmlRootElement(name = "FakturaCtrl")
    @XmlType(propOrder = { "liczbaFaktur", "wartoscFaktur" })
    static class FakturaCtrl {
        @XmlElement(name = "LiczbaFaktur")
        public int liczbaFaktur;
        @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
        @XmlElement(name = "WartoscFaktur")
        public Integer wartoscFaktur = 0;
    }

    @XmlRootElement(name = "FakturaWierszCtrl")
    @XmlType(propOrder = { "liczbaWierszyFaktur", "wartoscWierszyFaktur" })
    static class FakturaWierszCtrl {
        @XmlElement(name = "LiczbaWierszyFaktur")
        public int liczbaWierszyFaktur;
        @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
        @XmlElement(name = "WartośćWierszyFaktur")
        public Integer wartoscWierszyFaktur = 0;
    }

    @XmlElement(name = "FakturaCtrl")
    FakturaCtrl fakturaCtrl;
    @XmlElement(name = "FakturaWierszCtrl")
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
