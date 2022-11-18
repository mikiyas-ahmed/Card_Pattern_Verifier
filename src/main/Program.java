package main;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Input:\n");
        Scanner in = new Scanner(System.in);
        String input= in.nextLine();
        String path="src"+File.separator+"resources"+ File.separator+"conf4.csv";

        PanFormatConfigurer panFormatConfigurer= new PanFormatConfigurer();
        String pan = panFormatConfigurer.stringToPanFormat(FileReader.fileReader(path),input);
        System.out.println(pan);
    }
}
