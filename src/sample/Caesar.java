package sample;

import java.util.Locale;

public class Caesar {

    public static String encrypt(String word,int a, int b){
        String encrypted = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        word = word.toUpperCase();

        char[] arr = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.charAt(i);
        }

        int currentIndex =0;
        for (char ch: arr
             ) {
            for(int i = 0; i < alphabet.length(); i++){
                if(ch == alphabet.charAt(i)) {
                    currentIndex =  i;
                }
            }
            int newIndex = (currentIndex * a + b )% 26;
            char x = alphabet.charAt(newIndex);
            encrypted += x;
        }
        //f(x) = (ax + b) mod 26

        return encrypted;
    }

    public static String decrypt(String word,int a, int b){

        String decrypted = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        word = word.toUpperCase();

        char[] arr = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.charAt(i);
        }

        int currentIndex = 0;
        for (char ch: arr
        ) {
            for(int i = 0; i < alphabet.length(); i++){
                if(ch == alphabet.charAt(i)) {
                    currentIndex =  i;
                }
            }
            int de = 15;

             int newIndex = mod(de * (currentIndex - b) , 26);
            char x = alphabet.charAt(newIndex);
            decrypted += x;

        }



       return decrypted;
    }

    static int mod(int aa, int bb)
    {
        int r = aa % bb;
        return r < 0 ? r + bb : r;
    }
}
