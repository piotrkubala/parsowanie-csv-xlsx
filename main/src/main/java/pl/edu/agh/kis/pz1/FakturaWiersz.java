package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "FakturaWiersz")
@XmlType(propOrder = { "tytulPozycji", "liczbaSztuk", "cenaJednostkowa", "stawkaPodatku", "kwotaPodatku", "cenaNetto", "cenaBrutto", "nrFaktury" })
@XmlAccessorType(XmlAccessType.FIELD)
public class FakturaWiersz {
    @XmlElement(name = "TytułPozycji")
    String tytulPozycji;
    @XmlElement(name = "LiczbaSztuk")
    String liczbaSztuk;
    @XmlElement(name = "CenaJednostkowa")
    String cenaJednostkowa;
    @XmlTransient
    float cenaJednostkowaL;
    @XmlElement(name = "StawkaPodatku")
    String stawkaPodatku;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "KwotaPodatku")
    String kwotaPodatku;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "CenaNetto")
    String cenaNetto;
    @XmlTransient
    int cenaNettoL;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "CenaBrutto")
    String cenaBrutto;

    @XmlTransient
    int cenaBruttoL;

    @XmlElement(name = "NumerFaktury")
    String nrFaktury;

    static int toGrosze(String kwota) {
        return Integer.parseInt(kwota.substring(0, kwota.length() - 2).replaceAll("[\\s\\u00A0]+", "").replace(",", ""));
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
    }

    public FakturaWiersz(String tytulPozycji, String liczbaSztuk, String cenaJednostkowa, String stawkaPodatku, String kwotaPodatku, String cenaNetto, String cenaBrutto, String nrFaktury) throws NumberFormatException {
        setTytulPozycji(tytulPozycji);
        setLiczbaSztuk(liczbaSztuk);
        setCenaJednostkowa(cenaJednostkowa);
        setStawkaPodatku(stawkaPodatku);
        setKwotaPodatku(kwotaPodatku);
        setCenaNetto(cenaNetto);
        setCenaBrutto(cenaBrutto);
        setNrFaktury(nrFaktury);
    }

    public void setTytulPozycji(String tytulPozycji) {
        this.tytulPozycji = tytulPozycji;
    }

    public void setLiczbaSztuk(String liczbaSztuk) {
        this.liczbaSztuk = liczbaSztuk;
    }

    public void setCenaJednostkowa(String cenaJednostkowa) {
        this.cenaJednostkowa = cenaJednostkowa;
        this.cenaJednostkowaL = toGrosze(cenaJednostkowa);
    }

    public void setStawkaPodatku(String stawkaPodatku) {
        this.stawkaPodatku = stawkaPodatku;
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
}
