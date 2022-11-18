package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PanFormatConfigurer {
    public  String stringToPanFormat(List<String> inputPanConfigList,String inputPan){

        if(inputPanConfigList!=null && RuntimeUserInputException.inputValidator(inputPan)){
            List<Pan> panFormatList = PanFormatFileReader.mapStringToPan(inputPanConfigList);
            List<Pan> result= formatVerifier(panFormatList,inputPan);
            if(result.isEmpty())
                throw new RuntimeException("User input Not Match");
            return convertInputToPanPattern(result.get(0),inputPan);
        }
        else throw new RuntimeException("User input PAN is Not Correct please try gain");
    }

    public List<Pan> formatVerifier(List<Pan> pans, String inputPan)  {
        if(pans!=null && RuntimeUserInputException.inputValidator(inputPan)){
            List<Pan> result = pans.stream()
                    .filter((x) -> x.getPanLength() == inputPan.length())
                    .sorted((o1, o2) -> o2.getPrefixLength() - o1.getPrefixLength())
                    .filter((y) -> suffixVerifier(y, inputPan))
                    .collect(Collectors.toList());
            return result;
        }
        else throw new RuntimeException("User input PAN is Not Correct please try gain");
    }

    static boolean suffixVerifier(Pan panFormats, String inputPan) {
        if(panFormats!=null && RuntimeUserInputException.inputValidator(inputPan)){
        return IntStream.rangeClosed(panFormats.getInnRangeLow(),panFormats.getInnRangeHigh())
                .anyMatch((y)->inputPan.startsWith(Integer.toString(y)));
        }
        else throw new RuntimeException("User input PAN is Not Correct please try gain");
    }
    public String convertInputToPanPattern(Pan pan,String inputPan){
        if(RuntimeUserInputException.inputValidator(inputPan) && pan!=null) {
            String result = "";
            int sum = 0;
            for (int pattern : pan.getPattern()) {
                result += inputPan.substring(sum, sum + pattern) + " ";
                sum = sum + pattern;
            }
            result = result.substring(0, result.length() - 1);
            return result;
        }
        else throw new RuntimeException("User input PAN is Not Correct please try gain");
    }

}
