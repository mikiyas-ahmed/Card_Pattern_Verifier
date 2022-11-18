package main;

public class RuntimeUserInputException {
    public static boolean inputValidator(String inputString){
        return ifNotnull(inputString)&&ifNumber(inputString);
    }
    public static  boolean ifNumber(String inputString){
        return inputString.matches("[0-9]+");
    }
    public static boolean ifNotnull(String inputString){
        return inputString!=null;
    }

}
