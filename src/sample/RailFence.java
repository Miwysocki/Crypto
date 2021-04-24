package sample;

public class RailFence {

    public static String  encrypt(String word, int n) {
        String encrypted = "";
        boolean goDown = true;
        char tab[][] = new char[n][word.length()];
        int index = 0;
        int rail = 0;
        int width[] = new int[word.length()];

        while (index < word.length()) {
            tab[rail][width[rail]] = word.charAt(index);
            index++;

            width[rail]++;
            //direction
            if (rail == n - 1 && goDown == true) goDown = false;
            if (rail == 0) goDown = true;

            //rail
            if (rail < n - 1 && goDown == true) rail++;
            if (rail > 0 && goDown == false) rail--;


        }

        int i =0;

        while (encrypted.length() < word.length()) {
            int wdth = 0;
            while (tab[i][wdth] != 0) {
                encrypted += tab[i][wdth];
                wdth++;
            }
            i++;
        }
        return encrypted;
    }

    public static String decrypt(String word, int n) {
        String decrypted = "";
        boolean direction = false;
        int row = 0;
        int column = word.length();
        char[][] tab = new char[n][column];

        for (int i = 0; i < column; i++) {
            if (row == 0 || row == n - 1) {
                direction = !direction;
            }
            tab[row][i] = '*';

            if (direction) row++;
            else row--;
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < column; j++) {
                if (tab[i][j] == '*' && index < column) {
                    tab[i][j] = word.charAt(index++);
                }
            }
        }

        direction = false;
        row = 0;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < n; j++) {
                if (row == 0 || row == n - 1) direction = !direction;
                decrypted += tab[j][i];
                if (direction) row++;
                else row--;
            }
        }

        return decrypted;
    }

}

