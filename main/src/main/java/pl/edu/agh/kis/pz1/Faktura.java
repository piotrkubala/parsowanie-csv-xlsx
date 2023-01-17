package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Faktura")
@XmlType(propOrder = { "waluta", "dataWystawienia", "nrFaktury",
        "nazwaOdbiorcy", "nazwaOdbiorcy3B", "nazwaWystawcy3C",
        "adresOdbiorcy", "P_4A", "NIPWystawcy", "NIP",
        "dataSprzedazy", "cenaNettoFakturyLacznie", "wartoscPodatku",
        "cenaBruttoFakturyLacznie", "P_16", "P_17", "P_18", "P_18A", "P_19",
        "P_20", "P_21", "P_22", "P_23", "P_106E_2", "P_106E_3", "rodzajFaktury" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktura {

    @XmlElement(name = "tns:KodWaluty")
    String waluta = "PLN";

    @XmlElement(name = "tns:P_1")
    String dataWystawienia;

    @XmlElement(name = "tns:P_2A")
    String nrFaktury;

    @XmlElement(name = "tns:P_3_A")
    String nazwaOdbiorcy;

    @XmlElement(name = "tns:P_3_B")
    String nazwaOdbiorcy3B;

    @XmlElement(name = "tns:P_3_C")
    String nazwaWystawcy3C = "\"CORE LOGIC\" SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ";
    @XmlElement(name = "tns::P_3D")
    String adresOdbiorcy;

    @XmlElement(name = "tns:P_4A")
    String P_4A = "PL";

    @XmlElement(name = "tns:P_4B")
    String NIPWystawcy = "6762484560";

    @XmlElement(name = "tns:P_5B")
    String NIP;

    @XmlElement(name = "tns:P_6")
    String dataSprzedazy;

    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_13_1")
    String cenaNettoFakturyLacznie;

    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_13_2")
    String wartoscPodatku;

    @XmlTransient
    int wartoscPodatkuL;

    @XmlTransient
    int cenaNettoFakturyLacznieL;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "tns:P_15")
    String cenaBruttoFakturyLacznie;

    @XmlTransient
    int cenaBruttoFakturyLacznieL;

    @XmlElement(name = "tns:P_16")
    boolean P_16 = false;

    @XmlElement(name = "tns:P_17")
    boolean P_17 = false;

    @XmlElement(name = "tns:P_18")
    boolean P_18 = false;

    @XmlElement(name = "tns:P_18A")
    boolean P_18A = false;

    @XmlElement(name = "tns:P_19")
    boolean P_19 = false;

    @XmlElement(name = "tns:P_20")
    boolean P_20 = false;

    @XmlElement(name = "tns:P_21")
    boolean P_21 = false;

    @XmlElement(name = "tns:P_22")
    boolean P_22 = false;

    @XmlElement(name = "tns:P_23")
    boolean P_23 = false;

    @XmlElement(name = "tns:P_106E_2")
    boolean P_106E_2 = false;

    @XmlElement(name = "tns:P_106E_3")
    boolean P_106E_3 = false;

    @XmlElement(name = "tns:RodzajFaktury")
    String rodzajFaktury = "VAT";

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

    public void setNazwaOdbiorcy(String nazwaOdbiorcy) {
        this.nazwaOdbiorcy = nazwaOdbiorcy;
        this.nazwaOdbiorcy3B = nazwaOdbiorcy + "-ADDRESS";
    }

    public void setAdresOdbiorcy(String adresOdbiorcy) {
        this.adresOdbiorcy = adresOdbiorcy;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public void setDataWystawienia(String dataWystawienia) {
        this.dataWystawienia = dataWystawienia;
    }

    public void setDataSprzedazy(String dataSprzedazy) {
        this.dataSprzedazy = dataSprzedazy;
    }

    public void setNrFaktury(String nrFaktury) {
        this.nrFaktury = nrFaktury;
    }

    public void setCenaNettoFakturyLacznie(String cenaNettoFakturyLacznie) {
        this.cenaNettoFakturyLacznie = cenaNettoFakturyLacznie;
        this.cenaNettoFakturyLacznieL = FakturaWiersz.toGrosze(cenaNettoFakturyLacznie);

        this.wartoscPodatkuL = cenaBruttoFakturyLacznieL - cenaNettoFakturyLacznieL;
        this.wartoscPodatku = FakturaWiersz.toZlote(wartoscPodatkuL);
    }

    public void setCenaBruttoFakturyLacznie(String cenaBruttoFakturyLacznie) {
        this.cenaBruttoFakturyLacznie = cenaBruttoFakturyLacznie;
        this.waluta = cenaNettoFakturyLacznie.substring(cenaBruttoFakturyLacznie.length() - 2);
        this.cenaBruttoFakturyLacznieL = FakturaWiersz.toGrosze(cenaBruttoFakturyLacznie);

        this.wartoscPodatkuL = cenaBruttoFakturyLacznieL - cenaNettoFakturyLacznieL;
        this.wartoscPodatku = FakturaWiersz.toZlote(wartoscPodatkuL);
    }

    public int getCenaNettoFakturyLacznieL() {
        return cenaNettoFakturyLacznieL;
    }

    public int getCenaBruttoFakturyLacznieL() {
        return cenaBruttoFakturyLacznieL;
    }
}
