package main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PanFormatFileReaderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void mapStringToPanWithNull() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("input List is null");
        List<String> list = null;
        List<Pan> result= PanFormatFileReader.mapStringToPan(list);

    }
    @Test
    public void mapStringToPanWithEmptyList() {
        List<String> list = new ArrayList<>();
        List<Pan> result= PanFormatFileReader.mapStringToPan(list);
        List<Pan> expected= new ArrayList<>();
        assertEquals(expected,result);

    }
    @Test
    public void mapStringToPan() {
        List<String> list = new ArrayList<>();
        list.add("Visa (incl. VPay);15;1;4;4;Pattern not known");
        String expected= "[PanFormat{" +
                "issuerName='" + "Visa (incl. VPay)" + '\'' +
                ", panLength=" + 15 +
                ", prefixLength=" + 1 +
                ", innRangeLow=" + 4 +
                ", innRangeHigh=" + 4 +
                ", pattern='" + new ArrayList<Integer>()+ '\'' +
                "}]";

        String result= PanFormatFileReader.mapStringToPan(list).toString();
        assertEquals(expected,result);
    }
    @Test
    public void mapToPanFormat() {
        List<String> list = new ArrayList<>();
        list.add("Visa (incl. VPay);15;1;4;4;Pattern not known");
        String expected= "[PanFormat{issuerName='Visa (incl. VPay)', panLength=15, prefixLength=1, innRangeLow=4, innRangeHigh=4, pattern='[]'}]";
        String result= list.stream().map(PanFormatFileReader.mapToPanFormat).collect(Collectors.toList()).toString();
        assertEquals(expected,result);
    }

}