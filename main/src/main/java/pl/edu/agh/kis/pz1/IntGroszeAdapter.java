package pl.edu.agh.kis.pz1;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntGroszeAdapter extends XmlAdapter<String, Integer> {
    @Override
    public Integer unmarshal(String value) throws Exception {
        return Integer.parseInt(value.replace(".", ""));
    }

    @Override
    public String marshal(Integer value) throws Exception {
        return (value / 100) + "." + (value % 100);
    }
}
