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

}
