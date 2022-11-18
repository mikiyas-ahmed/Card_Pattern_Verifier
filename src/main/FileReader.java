package main;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileReader {
     public static List<String> fileReader(String file){
        List<String> panFormatList;
        try{
        File inputF = new File(file);
        InputStream inputFS = new FileInputStream(inputF);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            panFormatList = br.lines().skip(1).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            throw new RuntimeException("something is wrong with reading the file");
        }
       return panFormatList;
    }

}
