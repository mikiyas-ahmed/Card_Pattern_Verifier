package main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PanFormatConfigurerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void stringToPanFormat() {
        List<String> inputList = new ArrayList<>();
        inputList.add("Visa (incl. VPay);15;1;4;4;Pattern not known");
        inputList.add("Diners Club Carte Blanche;14;3;300;305;#### ###### ####");
        inputList.add("InterPayment;17;3;636;636;Pattern not known");
        String inputPan = "30122994494222";
        String expected= "3012 299449 4222";
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        String result= panFormatConfigurer.stringToPanFormat(inputList,inputPan);
        assertEquals(expected,result);
    }
    @Test
    public void stringToPanFormatWithNullList() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User input PAN is Not Correct please try gain");
        List<String> list = null;
        String inputPan = "30122994494222";
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        String result= panFormatConfigurer.stringToPanFormat(list,inputPan);
    }
    @Test
    public void stringToPanFormatWithNullString() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User input PAN is Not Correct please try gain");
        List<String> inputList = new ArrayList<>();
        inputList.add("Visa (incl. VPay);15;1;4;4;Pattern not known");
        inputList.add("Diners Club Carte Blanche;14;3;300;305;#### ###### ####");
        inputList.add("InterPayment;17;3;636;636;Pattern not known");
        String inputPan = null;
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        String result= panFormatConfigurer.stringToPanFormat(inputList,inputPan);
    }
    @Test
    public void stringToPanFormatWithEmpty() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User input Not Match");
        List<String> inputList = new ArrayList<>();
        String inputPan = "30122994494222";;
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        String result= panFormatConfigurer.stringToPanFormat(inputList,inputPan);
    }

    @Test
    public void formatVerifierWithNullList() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User input PAN is Not Correct please try gain");
        List<Pan> list = null;
        String inputPan = "30122994494222";
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        List<Pan> result= panFormatConfigurer.formatVerifier(list,inputPan);
    }
    @Test
    public void formatVerifier() {
        List<Pan> inputList = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        number.add(4);number.add(4);number.add(4);number.add(4);
        inputList.add(new Pan("Visa (incl. VPay)",16,1,4,4,number));
        String inputPan ="4444444444444444" ;
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        List<Pan> result= panFormatConfigurer.formatVerifier(inputList,inputPan);
    }

    @Test
    public void formatVerifierWithNullString() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("User input PAN is Not Correct please try gain");
        List<Pan> inputList = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        number.add(4);number.add(4);number.add(4);number.add(4);
        inputList.add(new Pan("Visa (incl. VPay)",16,1,4,4,number));
        String inputPan = null;
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        List<Pan> result= panFormatConfigurer.formatVerifier(inputList,inputPan);
    }

    @Test
    public void suffixVerifier() {
        List<Integer> number = new ArrayList<>();
        number.add(4);number.add(4);number.add(4);number.add(4);
        Pan pan= new Pan("Visa (incl. VPay)",16,1,4,4,number);
        String inputPan ="4444444444444444";
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        boolean result= PanFormatConfigurer.suffixVerifier(pan,inputPan);
        assertEquals(true, result);
    }

    @Test
    public void convertInputToPanPattern() {
        List<Integer> number = new ArrayList<>();
        number.add(4);number.add(4);number.add(4);number.add(4);
        Pan pan= new Pan("Visa (incl. VPay)",16,1,4,4,number);
        String inputPan ="4444444444444444";
        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        String result= panFormatConfigurer.convertInputToPanPattern(pan,inputPan);
        String expected= "4444 4444 4444 4444";
        assertEquals(expected, result);
    }
}