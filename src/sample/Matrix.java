package sample;

import java.util.Arrays;

public class Matrix {
    public static String  encrypt_2a(String word)
    {
        char tab[][] = new char [5][word.length()];

        int index = 0;
        int row = 0;
        while(index < word.length())
        {
            for(int i =0; i < 5; i++){
                if(index ==word.length()) break;
                tab[i][row] = word.charAt(index);
                index++;
            }
            row++;
        }

        String encrypted = "";
         row = 0;
        while(encrypted.length() <  word.length()){
            //3-4-1-5-2
            encrypted += tab[2][row];
            encrypted += tab[3][row];
            encrypted += tab[0][row];
            encrypted += tab[4][row];
            encrypted += tab[1][row];
            row++;
        }
        return encrypted;
    }

    public static String decrypt_2a(String word){
        String decrypted ="";


        //3-4-1-5-2
        int[] key   = new int[]{2,3,0,4,1};
        int col = 0;
        int index = 0;

        //
        char tab[][] = new char [5][word.length()/5+1];
        index = 0;
        int row=0;
        while(index < word.length()){
            int a = ( (word.length()) - index );
            int[] key3   = new int[]{2,0,1};
            int[] key4   = new int[]{2,3,0,1};
            if( ( (word.length()) - index ) ==3 )
            {
                for(int i =0; i < 3 ;i++){
                    tab[key3[i]][row] = word.charAt(index);
                    index++;
                }
            }
            if( ( (word.length()) - index ) ==4 )
            {
                for(int i =0; i < 4 ;i++){
                    tab[key4[i]][row] = word.charAt(index);
                    index++;
                }
            }

           for(int i=0;i<5;i++) {
               if(index == (word.length())) break;
                tab[key[i]][row] = word.charAt(index);
                index++;
            }
           row++;

        }

        row = 0;
        while (decrypted.length() < word.length()){
            for(int i=0;i<5;i++) {
                decrypted += tab[i][row];
            }
            row++;
        }

    return decrypted;

    }

    public static String encrypt_2b(String word, String key) {
        String encrypted = "";

        char tab[][] = new char[key.length()][key.length() + 1];
        int tabKey[] = new int[key.length()];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int indexTab = 1;
        for (int j = 0; j < alphabet.length(); j++) {
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == alphabet.charAt(j)) {
                    tabKey[i] = indexTab;
                    indexTab++;
                }
            }
        }

        int glIndex = 0;
        int width = 0;
        while(glIndex < word.length()){

            for (int length = 0; length < key.length(); length++) {
                if(glIndex >= word.length()) break;
                tab[length][width] = word.charAt(glIndex);
                glIndex++;
            }
            width++;
        }


        int index = 0;
        int wdt = word.length() / key.length() +1;
         for(int i =1; i < key.length()+1; i++){
             for(int j=0; j < tabKey.length; j++){
                 if(tabKey[j] == i) index = j;
             }

             for(int k =0; k <wdt; k++){
                 encrypted += tab[index][k];
             }

         }

        return encrypted;
    }

    public static String decrypt_2b(String word, String key) {
        String decrypted ="";

        int lines = word.length() / key.length();
        int redundantLetters = word.length() % key.length();
        int red = redundantLetters;
        char tab[][] = new char[key.length()][lines + 1];
        int tabKey[] = new int[key.length()];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int indexTab = 0;
        for (int j = 0; j < alphabet.length(); j++) {
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == alphabet.charAt(j)) {
                    tabKey[i] = indexTab;
                    indexTab++;
                }
            }
        }


        int index = 0;
        int j = 0;
        int whichColumn;
        while(j < key.length()){

            for( whichColumn=0; whichColumn < tabKey.length; whichColumn++)
                 {if(tabKey[whichColumn] == j) break;}

            for(int i =0; i < lines; i++){
                if(index >= word.length()) break;
                tab[whichColumn][i] = word.charAt(index);
                index++;
            }
            //check if one of first columns -
            boolean redundantColumn = false;
            for(int c =0; c < red; c++){
                if(whichColumn == c) redundantColumn = true;
            }


            if(redundantLetters > 0 && redundantColumn ){
                tab[whichColumn][lines] = word.charAt(index);
                redundantLetters--;
                index++;
            }
            j++;
        }

        int columns = key.length();
        if(word.length() % key.length() != 0 ) lines += 1;
        int i =0;
        while (decrypted.length() < word.length())
        {
            for(int k =0; k < columns; k++){
                if(decrypted.length() >= word.length()) break;
                if(tab[k][i] != 0) decrypted += tab[k][i];

            }
            i++;
        }

            return decrypted;
    }

    public static String encrypt_2c(String word, String key) {
        String encrypted = "";
        StringBuilder stringBuilder = new StringBuilder();
        double column = key.length();
        double row = column;
        char[][] textCharArray = new char[(int) row][(int) column];
        char[] keyCharArray = new char[key.length()];
        char[] sortedKeyCharArray;

        for (int i = 0; i < keyCharArray.length; i++) {
            keyCharArray[i] = key.charAt(i);
        }

        sortedKeyCharArray = keyCharArray.clone();
        Arrays.sort(sortedKeyCharArray);

        int[] arrayOfIndexes = new int[keyCharArray.length];
        char[] tmpKeyCharArray;
        tmpKeyCharArray = keyCharArray.clone();
        for (int i = 0; i < keyCharArray.length; i++) {
            for (int j = 0; j < sortedKeyCharArray.length; j++) {
                if (sortedKeyCharArray[i] == tmpKeyCharArray[j]) {
                    tmpKeyCharArray[j] = 0;
                    arrayOfIndexes[i] = j;
                    break;
                }
            }
        }

        int size = 0;
        boolean finished = false;
        int index = 0;

        for (int i = 0; i < column; i++) {
            if (finished) {
                break;
            }
            for (int j = 0; j <= arrayOfIndexes[i]; j++) {
                if (index < word.length()) {
                    if (size >= word.length()) {
                        finished = true;
                        break;
                    }
                    textCharArray[i][j] = word.charAt(index++);
                    size++;
                }
            }
        }

        for (int i = 0; i < column; i++) {
            index = arrayOfIndexes[i];
            for (int j = 0; j < row; j++) {
                stringBuilder.append(textCharArray[j][index]);
            }
        }
        encrypted = String.valueOf(stringBuilder);
        return encrypted;

    }
    static public String decrypt_2c(String word, String key) {
        String decrypted ="";

        int lines = word.length() / key.length();
        char tab[][] = new char[key.length()][key.length()];
        int tabKey[] = new int[key.length()];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int indexTab = 0;
        for (int j = 0; j < alphabet.length(); j++) {
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == alphabet.charAt(j)) {
                    tabKey[i] = indexTab;
                    indexTab++;
                }
            }
        }

        for(int i =0; i < tabKey.length; i ++){
            for(int j =0 ; j < tabKey.length; j++){
                if(tabKey[j] == i){
                    for( int k =0; k <= j; k++){
                        tab[i][k] = '*';
                    }
                }
            }
        }

        int redundant=0;
        //counting number of lines
        int numberOfLines =0;
        int numOfWords = word.length();
        for(int i =0; i < key.length(); i++){
            for(int j =0; j < key.length();j++){
                if(numOfWords <= 0) break;
                if(tabKey[j] == i){
                    numOfWords -= j+1;
                    if(numOfWords < 0){ // not full line
                        redundant = (j+1) + numOfWords;
                    }
                    numberOfLines++;
                }
            }
        }

        int lastLineField = redundant;
        boolean lastLineNotFull = false;
        if(redundant > 0)  lastLineNotFull = true;

        int index = 0;
        for(int k = 0; k < key.length(); k ++){
            int whichColumn;
            for( whichColumn = 0; whichColumn < tabKey.length; whichColumn++){
                if( tabKey[whichColumn] == k){
                    break;
                }
            }

                for(int w = 0; w < numberOfLines; w ++){
                    if(w == (numberOfLines-1 )&& lastLineNotFull){ //last line
                        if(redundant > 0  && tab[w][whichColumn] == '*'){
                            if(index == word.length()) {
                                break;
                            }
                            //czy nalezy do tych pierwszych kolumn
                            if(whichColumn < lastLineField){
                                tab[w][whichColumn] = word.charAt(index);
                                index++;
                                redundant--;
                            }
                        }
                    }
                    else if(tab[w][whichColumn] == '*'){
                        if(index == word.length()) {
                            break;
                        }
                            tab[w][whichColumn] = word.charAt(index);
                            index++;
                    }
                }

        }

        for(int k = 0; k < numberOfLines; k++){
            for(int w    = 0; w < key.length(); w++){
                if(tab[k][w] != '*')
                decrypted += tab[k][w];
            }
        }
        return decrypted;
    }




    static long sequence(int n) {
        long sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += i;
        }
        return sum;
    }
}
