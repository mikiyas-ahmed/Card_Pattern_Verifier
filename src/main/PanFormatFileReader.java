package main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PanFormatFileReader {
    public static List<Pan> mapStringToPan(List<String> inputPanConfigList){
        if(inputPanConfigList!=null){
            List<Pan> panFormatList = inputPanConfigList
                    .stream()
                    .map(mapToPanFormat)
                    .collect(Collectors.toList());
            return panFormatList;
        }
        else throw new RuntimeException("input List is null");
    }
    static Function<String,Pan> mapToPanFormat =  (line) -> {
        String[] recordColumn = line.split(";");
        List<Integer> integers  = Arrays
                .asList(recordColumn[5]
                        .split(" "))
                .stream()
                .filter(x->x.contains("#"))
                .map(String::length)
                .collect(Collectors.toList());
        return new Pan(recordColumn[0],
                Integer.parseInt(recordColumn[1]),
                Integer.parseInt(recordColumn[2]),
                Integer.parseInt(recordColumn[3]),
                Integer.parseInt(recordColumn[4]),
                integers);
    };
}
