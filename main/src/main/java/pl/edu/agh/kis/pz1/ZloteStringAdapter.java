package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ZloteStringAdapter extends XmlAdapter<String, String> {
    @Override
    public String unmarshal(String value) throws Exception {
        return value.replace(".", ",");
    }

    @Override
    public String marshal(String value) throws Exception {
        int index = value.indexOf("zł");
        if (index == -1) {
            return value;
        }

        return value.substring(0, index).replace(",", ".").replaceAll("[\\s\\u00A0]+", "");
    }
}
