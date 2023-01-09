package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Faktura")
@XmlType(propOrder = { "waluta", "nazwaOdbiorcy", "adresOdbiorcy", "NIP", "dataWystawienia", "dataSprzedazy", "nrFaktury", "cenaNettoFakturyLacznie", "cenaBruttoFakturyLacznie" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Faktura {
    @XmlElement(name = "NazwaOdbiorcy")
    String nazwaOdbiorcy;
    @XmlElement(name = "NazwaOdbiorcy")
    String adresOdbiorcy;
    @XmlElement(name = "NIP")
    String NIP;
    @XmlElement(name = "DataWystawienia")
    String dataWystawienia;
    @XmlElement(name = "DataSprzedaży")
    String dataSprzedazy;
    @XmlElement(name = "NumerFaktury")
    String nrFaktury;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "CenaNettoFakturyŁącznie")
    String cenaNettoFakturyLacznie;

    @XmlTransient
    int cenaNettoFakturyLacznieL;
    @XmlJavaTypeAdapter(type = String.class, value = ZloteStringAdapter.class)
    @XmlElement(name = "CenaBruttoFakturyŁącznie")
    String cenaBruttoFakturyLacznie;

    @XmlTransient
    int cenaBruttoFakturyLacznieL;

    @XmlElement(name = "KodWaluty")
    String waluta;

    public Faktura() {
        nazwaOdbiorcy = "";
        adresOdbiorcy = "";
        NIP = "";
        dataWystawienia = "";
        dataSprzedazy = "";
        nrFaktury = "";
        cenaNettoFakturyLacznie = "";
        cenaBruttoFakturyLacznie = "";
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
    }

    public void setCenaBruttoFakturyLacznie(String cenaBruttoFakturyLacznie) {
        this.cenaBruttoFakturyLacznie = cenaBruttoFakturyLacznie;
        this.waluta = cenaNettoFakturyLacznie.substring(cenaBruttoFakturyLacznie.length() - 2);
        this.cenaBruttoFakturyLacznieL = FakturaWiersz.toGrosze(cenaBruttoFakturyLacznie);
    }

    public int getCenaNettoFakturyLacznieL() {
        return cenaNettoFakturyLacznieL;
    }

    public int getCenaBruttoFakturyLacznieL() {
        return cenaBruttoFakturyLacznieL;
    }
}
