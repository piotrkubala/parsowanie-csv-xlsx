package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * @author Piotr Kubala
 */
@XmlRootElement(name = "Faktura")
@XmlType(propOrder = { "waluta", "dataWystawienia", "nrFaktury",
        "nazwaOdbiorcy", "nazwaOdbiorcy3B", "nazwaWystawcy3C",
        "adresOdbiorcy", "P_4A", "NIPWystawcy", "NIP",
        "dataSprzedazy", "cenaNettoFakturyLacznie", "wartoscPodatku",
        "cenaBruttoFakturyLacznie", "P_16", "P_17", "P_18", "P_18A", "P_19",
        "P_20", "P_21", "P_22", "P_23", "P_106E_2", "P_106E_3", "rodzajFaktury" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktura {
    /**
     * Waluta faktury
     */
    @XmlElement(name = "tns:KodWaluty")
    String waluta = "PLN";

    /**
     * Data wystawienia faktury
     */
    @XmlElement(name = "tns:P_1")
    String dataWystawienia;

    /**
     * Numer faktury
     */
    @XmlElement(name = "tns:P_2A")
    String nrFaktury;

    /**
     * Nazwa odbiorcy
     */
    @XmlElement(name = "tns:P_3_A")
    String nazwaOdbiorcy;

    /**
     * Nazwa odbiorcy 3B
     */
    @XmlElement(name = "tns:P_3_B")
    String nazwaOdbiorcy3B;

    /**
     * Nazwa wystawcy 3C
     */
    @XmlElement(name = "tns:P_3_C")
    String nazwaWystawcy3C = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";

    /**
     * Adres odbiorcy
     */
    @XmlElement(name = "tns::P_3D")
    String adresOdbiorcy;

    /**
     * P_4A
     */
    @XmlElement(name = "tns:P_4A")
    String P_4A = "PL";

    /**
     * NIP wystawcy
     */
    @XmlElement(name = "tns:P_4B")
    String NIPWystawcy = "6762484560";

    /**
     * NIP odbiorcy
     */
    @XmlElement(name = "tns:P_5B")
    String NIP;

    /**
     * Data sprzedaży
     */
    @XmlElement(name = "tns:P_6")
    String dataSprzedazy;

    /**
     * Cena netto faktury łącznie
     */
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_13_1")
    String cenaNettoFakturyLacznie;

    /**
     * Wartość podatku
     */
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_13_2")
    String wartoscPodatku;

    /**
     * Cena brutto faktury łącznie
     */
    @XmlTransient
    int wartoscPodatkuL;

    /**
     * Cena brutto faktury łącznie
     */
    @XmlTransient
    int cenaNettoFakturyLacznieL;

    /**
     * Cena brutto faktury łącznie
     */
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_15")
    String cenaBruttoFakturyLacznie;

    /**
     * P_16
     */
    @XmlTransient
    int cenaBruttoFakturyLacznieL;

    /**
     * P_16
     */
    @XmlElement(name = "tns:P_16")
    boolean P_16 = false;

    /**
     * P_17
     */
    @XmlElement(name = "tns:P_17")
    boolean P_17 = false;

    /**
     * P_18
     */
    @XmlElement(name = "tns:P_18")
    boolean P_18 = false;

    /**
     * P_18A
     */
    @XmlElement(name = "tns:P_18A")
    boolean P_18A = false;

    /**
     * P_19
     */
    @XmlElement(name = "tns:P_19")
    boolean P_19 = false;

    /**
     * P_20
     */
    @XmlElement(name = "tns:P_20")
    boolean P_20 = false;

    /**
     * P_21
     */
    @XmlElement(name = "tns:P_21")
    boolean P_21 = false;

    /**
     * P_22
     */
    @XmlElement(name = "tns:P_22")
    boolean P_22 = false;

    /**
     * P_23
     */
    @XmlElement(name = "tns:P_23")
    boolean P_23 = false;

    /**
     * P_106E_2
     */
    @XmlElement(name = "tns:P_106E_2")
    boolean P_106E_2 = false;

    /**
     * P_106E_3
     */
    @XmlElement(name = "tns:P_106E_3")
    boolean P_106E_3 = false;

    /**
     * Rodzaj faktury
     */
    @XmlElement(name = "tns:RodzajFaktury")
    String rodzajFaktury = "VAT";

    /**
     * Konstruktor
     */
    public Faktura() {
        nazwaOdbiorcy = "";
        adresOdbiorcy = "";
        NIP = "";
        dataWystawienia = "";
        dataSprzedazy = "";
        nrFaktury = "";
        cenaNettoFakturyLacznie = "";
        cenaBruttoFakturyLacznie = "";
        nazwaOdbiorcy3B = "";
        waluta = "";
    }

    /**
     * Konstruktor
     *
     * @param nazwaOdbiorcy nazwa odbiorcy
     * @param adresOdbiorcy adres odbiorcy
     * @param NIP NIP odbiorcy
     * @param dataWystawienia data wystawienia faktury
     * @param dataSprzedazy data sprzedaży
     * @param nrFaktury numer faktury
     * @param cenaNettoFakturyLacznie cena netto faktury łącznie
     * @param cenaBruttoFakturyLacznie cena brutto faktury łącznie
     */
    public Faktura(String nazwaOdbiorcy, String adresOdbiorcy, String NIP, String dataWystawienia, String dataSprzedazy, String nrFaktury, String cenaNettoFakturyLacznie, String cenaBruttoFakturyLacznie) {
        setNazwaOdbiorcy(nazwaOdbiorcy);
        setAdresOdbiorcy(adresOdbiorcy);
        setNIP(NIP);
        setDataWystawienia(dataWystawienia);
        setDataSprzedazy(dataSprzedazy);
        setNrFaktury(nrFaktury);
        setCenaNettoFakturyLacznie(cenaNettoFakturyLacznie);
        setCenaBruttoFakturyLacznie(cenaBruttoFakturyLacznie);
    }

    /**
     * @return the nazwaOdbiorcy
     */
    public void setNazwaOdbiorcy(String nazwaOdbiorcy) {
        this.nazwaOdbiorcy = nazwaOdbiorcy;
        this.nazwaOdbiorcy3B = nazwaOdbiorcy + "-ADDRESS";
    }

    /**
     * @return the adresOdbiorcy
     */
    public void setAdresOdbiorcy(String adresOdbiorcy) {
        this.adresOdbiorcy = adresOdbiorcy;
    }

    /**
     * @return the NIP
     */
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    /**
     * @return the dataWystawienia
     */
    public void setDataWystawienia(String dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    /**
     * @return the dataSprzedazy
     */
    public void setDataSprzedazy(String dataSprzedazy) {
        this.dataSprzedazy = dataSprzedazy;
    }

    /**
     * @return the nrFaktury
     */
    public void setNrFaktury(String nrFaktury) {
        this.nrFaktury = nrFaktury;
    }

    /**
     * @return the cenaNettoFakturyLacznie
     */
    public void setCenaNettoFakturyLacznie(String cenaNettoFakturyLacznie) {
        this.cenaNettoFakturyLacznie = cenaNettoFakturyLacznie;
        this.cenaNettoFakturyLacznieL = FakturaWiersz.toGrosze(cenaNettoFakturyLacznie);

        this.wartoscPodatkuL = cenaBruttoFakturyLacznieL - cenaNettoFakturyLacznieL;
        this.wartoscPodatku = FakturaWiersz.toZlote(wartoscPodatkuL);
    }

    /**
     * @return the cenaBruttoFakturyLacznie
     */
    public void setCenaBruttoFakturyLacznie(String cenaBruttoFakturyLacznie) {
        this.cenaBruttoFakturyLacznie = cenaBruttoFakturyLacznie;
        if (cenaBruttoFakturyLacznie.charAt(cenaBruttoFakturyLacznie.length() - 1) != 'ł') {
            this.waluta = "zł";
            this.cenaBruttoFakturyLacznieL = FakturaWiersz.toGrosze(cenaBruttoFakturyLacznie + " zł");
        } else {
            this.waluta = cenaNettoFakturyLacznie.substring(cenaBruttoFakturyLacznie.length() - 2);
            this.cenaBruttoFakturyLacznieL = FakturaWiersz.toGrosze(cenaBruttoFakturyLacznie);
        }

        this.wartoscPodatkuL = cenaBruttoFakturyLacznieL - cenaNettoFakturyLacznieL;
        this.wartoscPodatku = FakturaWiersz.toZlote(wartoscPodatkuL);
    }

    /**
     * @return cenaNettoFakturyLacznieL
     */
    public int getCenaNettoFakturyLacznieL() {
        return cenaNettoFakturyLacznieL;
    }

    /**
     * @return cenaBruttoFakturyLacznieL
     */
    public int getCenaBruttoFakturyLacznieL() {
        return cenaBruttoFakturyLacznieL;
    }
}
