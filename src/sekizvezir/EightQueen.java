/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekizvezir;

import java.util.Random;

/**
 *
 * @author pvg
 */
public class EightQueen {

    public EightQueen() {
    }

    public int[][] create() {
        Random rnd = new Random();

        int[][] tahta = new int[8][8];

        for (int i = 0; i < 8; i++) {
            int secim = rnd.nextInt(4);
            tahta[i][secim] = 1;
        }

        for (int j = 0; j < 8; j++) {
            System.out.print("\n");
            for (int k = 0; k < 8; k++) {
                System.out.print(tahta[j][k]);
            }
        }

        return tahta;
    }

    //bu metod sutunlardaki ve köşegendeki çakışmayı bulur.

    public int test_dik(int dizi[][]) {
        int toplam_dik = 0, value = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (dizi[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        if (dizi[k][j] == 1) {
                            if (k != i) {
                                toplam_dik++;
                            }

                        }
                    }

                }
            }
        }

        for (int i = 0, j = 0; i < dizi.length; i++) {

            if (dizi[i][i] == 1) {
                while (j < dizi.length) {
                    if (dizi[j][j] == 1) {
                        value++;
                    }
                    j++;
                }
            }
        }
        value = (value - 1) * value;

        return toplam_dik + value;
    }
    int toplam_alt = 0;

    //köşegeninaltında kalan çakışmaları bulur.
    public int test_alt(int tahta[][]) {
        int value = 0;
        int[][] tahta_alt = new int[tahta.length - 1][tahta.length - 1];
        for (int i = 0; i < tahta.length - 1; i++) {
            for (int j = 0; j < tahta.length - 1; j++) {
                tahta_alt[i][j] = tahta[i + 1][j];
            }
        }

        /* for (int j = 0; j < tahta_alt.length; j++) {
         System.out.print("\n");
         for (int k = 0; k < tahta_alt.length; k++) {
         System.out.print(tahta_alt[j][k]);
         }
         }*/
        for (int i = 0, j = 0; i < tahta_alt.length; i++) {

            if (tahta_alt[i][i] == 1) {
                while (j < tahta_alt.length) {
                    if (tahta_alt[j][j] == 1) {
                        value++;
                    }
                    j++;
                }
            }
        }
        value = (value - 1) * value;
        toplam_alt = toplam_alt + value;

        if (tahta.length > 3) {
            test_alt(tahta_alt);
        }
        return toplam_alt;

    }

    int toplam_ust = 0;

    //köşegenin üstünde kalan çakışmaları bulur
    public int test_ust(int tahta[][]) {
        int value = 0;
        int[][] tahta_ust = new int[tahta.length - 1][tahta.length - 1];
        for (int i = 0; i < tahta.length - 1; i++) {
            for (int j = 0; j < tahta.length - 1; j++) {
                tahta_ust[i][j] = tahta[i][j + 1];
            }
        }

        /*for (int j = 0; j < tahta_ust.length; j++) {
         System.out.print("\n");
         for (int k = 0; k < tahta_ust.length; k++) {
         System.out.print(tahta_ust[j][k]);
         }
         }*/
        for (int i = 0, j = 0; i < tahta_ust.length; i++) {

            if (tahta_ust[i][i] == 1) {
                while (j < tahta_ust.length) {
                    if (tahta_ust[j][j] == 1) {
                        value++;
                    }
                    j++;
                }
            }
        }
        value = (value - 1) * value;
        toplam_ust = toplam_ust + value;

        if (tahta.length > 3) {
            test_alt(tahta_ust);
        }
        return toplam_ust;

    }
}
