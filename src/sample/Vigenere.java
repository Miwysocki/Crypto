package sample;

import java.util.Locale;

public class Vigenere {
    public static String encryption(String word, String key ){
        int in =0;
        while(key.length() < word.length()){
            key += key.charAt(in);
            in++;
        }
        String encrypted = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        word = word.toUpperCase();
        key = key.toUpperCase();

        char [][] tab = new char [alphabet.length()][alphabet.length()];

        for(int j = 0; j < alphabet.length();j++){
            for(int i = 0; i < alphabet.length();i++){
                tab[i][j] = alphabet.charAt(i);
            }
            char firstLetter = alphabet.charAt(0);
            String newAlpha = alphabet.substring(1);
            alphabet = newAlpha + firstLetter;
        }
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int currentWordIndex =0;
        int currentKeyIndex  =0;
    for(int j =0; j < word.length();j++) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (word.charAt(j) == alphabet.charAt(i)){
                currentWordIndex = i;
            }
            if (key.charAt(j) == alphabet.charAt(i)){
                currentKeyIndex = i;
            }

        }
        encrypted += tab[currentWordIndex][currentKeyIndex];
    }

        return  encrypted;

    }

    public static String decrypt(String word,String key){
        String decrypted = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        word = word.toUpperCase();
        key = key.toUpperCase();
        int in=0;
        while(key.length() < word.length()){
            key += key.charAt(in);
            in++;
        }

        char [][] tab = new char [alphabet.length()][alphabet.length()];

        for(int j = 0; j < alphabet.length();j++){
            for(int i = 0; i < alphabet.length();i++){
                tab[i][j] = alphabet.charAt(i);
            }
            char firstLetter = alphabet.charAt(0);
            String newAlpha = alphabet.substring(1);
            alphabet = newAlpha + firstLetter;
        }
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int currentKeyIndex = 0;
        for(int j=0; j< key.length(); j++) {
            for (int i = 0; i < alphabet.length(); i++) {
                if (alphabet.charAt(i) == key.charAt(j)) {
                    currentKeyIndex = i;
                }
            }
                for(int k=0; k < alphabet.length();k++){
                    if(tab[currentKeyIndex][k] == word.charAt(j)){ //x
                        decrypted += alphabet.charAt(k);
                    }
                }

        }

         return decrypted;
    }
}
