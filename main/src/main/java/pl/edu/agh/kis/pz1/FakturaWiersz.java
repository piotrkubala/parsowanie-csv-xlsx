package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "FakturaWiersz")
@XmlType(propOrder = { "nrFaktury", "typSprzedazy", "P_8A", "liczbaSztuk",
        "cenaJednostkowa", "cenaJednostkowaBruttoGrosze", "cenaNetto", "stawkaPodatku" })
@XmlAccessorType(XmlAccessType.FIELD)
public class FakturaWiersz {
    @XmlElement(name = "tns:P_2B")
    String nrFaktury;

    @XmlTransient
    String tytulPozycji;

    @XmlElement(name = "tns:P_7")
    String typSprzedazy = "Sprzedaż usług krajowych";

    @XmlElement(name = "tns:P_8A")
    String P_8A = "szt";

    @XmlElement(name = "tns:P_8B")
    String liczbaSztuk;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_9A")
    String cenaJednostkowa;

    @XmlJavaTypeAdapter(type = String.class, value = IntGroszeAdapter.class)
    @XmlElement(name = "tns:P_9B")
    Integer cenaJednostkowaBruttoGrosze;

    @XmlTransient
    float cenaJednostkowaL;

    @XmlTransient
    String kwotaPodatku;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_11")
    String cenaNetto;
    @XmlTransient
    int cenaNettoL;

    @XmlTransient
    String cenaBrutto;

    @XmlElement(name = "tns:P_12")
    String stawkaPodatku;

    @XmlTransient
    int stawkaPodatkuL;

    @XmlTransient
    int cenaBruttoL;

    static int toGrosze(String kwota) {
        String przetworzony = kwota.replaceAll("[^0-9.,]+", "");

        int wartosc = Integer.parseInt(kwota.replaceAll("[^0-9]+", ""));
        int pozycja = przetworzony.indexOf('.');

        if (pozycja == -1) {
            pozycja = przetworzony.indexOf(',');
        }

        if (pozycja != -1) {
            wartosc *= (int) Math.pow(10, 2 - (przetworzony.length() - pozycja - 1));
        } else {
            wartosc *= 100;
        }

        return wartosc;
    }

    static String toZlote(int grosze) {
        return grosze / 100 + "," + grosze % 100 + " zł";
    }

    public FakturaWiersz() {
        tytulPozycji = "";
        liczbaSztuk = "";
        cenaJednostkowa = "";
        stawkaPodatku = "";
        kwotaPodatku = "";
        cenaNetto = "";
        cenaNettoL = 0;
        cenaBrutto = "";
        cenaBruttoL = 0;
        nrFaktury = "";
        cenaJednostkowaBruttoGrosze = 0;
    }

    public FakturaWiersz(String tytulPozycji, String liczbaSztuk, String cenaJednostkowa, String stawkaPodatku, String kwotaPodatku, String cenaNetto, String cenaBrutto, String nrFaktury) throws NumberFormatException {
        setStawkaPodatku(stawkaPodatku.replace(".", ""));
        setTytulPozycji(tytulPozycji);
        setLiczbaSztuk(liczbaSztuk);
        setCenaJednostkowa(cenaJednostkowa);
        setKwotaPodatku(kwotaPodatku);
        setCenaNetto(cenaNetto);
        setCenaBrutto(cenaBrutto);
        setNrFaktury(nrFaktury);
    }

    public void setTytulPozycji(String tytulPozycji) {
        this.tytulPozycji = tytulPozycji;
    }

    public void setLiczbaSztuk(String liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk.replace(",", ".");
    }

    public void setCenaJednostkowa(String cenaJednostkowa) {
        this.cenaJednostkowa = cenaJednostkowa;
        this.cenaJednostkowaL = toGrosze(cenaJednostkowa);

        cenaJednostkowaBruttoGrosze = (int) (cenaJednostkowaL * this.stawkaPodatkuL / 100);
    }

    public void setStawkaPodatku(String stawkaPodatku) {
        this.stawkaPodatku = stawkaPodatku;
        this.stawkaPodatkuL = Integer.parseInt(stawkaPodatku) + 100;
    }

    public void setKwotaPodatku(String kwotaPodatku) {
        this.kwotaPodatku = kwotaPodatku;
    }

    public void setCenaNetto(String cenaNetto) {
        this.cenaNetto = cenaNetto;
        this.cenaNettoL = toGrosze(cenaNetto);
    }

    public void setCenaBrutto(String cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
        this.cenaBruttoL = toGrosze(cenaBrutto);
    }

    public void setNrFaktury(String nrFaktury) {
        this.nrFaktury = nrFaktury;
    }

    public int getCenaNettoL() {
        return cenaNettoL;
    }

    public int getCenaBruttoL() {
        return cenaBruttoL;
    }

    public String getCenaNetto() {
        return cenaNetto;
    }

    public String getCenaBrutto() {
        return cenaBrutto;
    }
}
