package sample;

public class Vigenere {
    public static String encryption(String word, String key ){
        int in =0;
        while(key.length() < word.length()){
            key += key.charAt(in);
            in++;
        }
        String encrypted = "";


    }
}
