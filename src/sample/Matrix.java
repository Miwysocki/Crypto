package sample;

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
                if(index >= word.length()-1) break;
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

}
