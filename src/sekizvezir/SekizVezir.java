/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekizvezir;

/**
 *
 * @author pvg
 */
public class SekizVezir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EightQueen nesne = new EightQueen();
        int[][] dizi = nesne.create();
        int cksm_ust = nesne.test_ust(dizi);
        int cksm_alt = nesne.test_alt(dizi);
        int cksm = nesne.test_dik(dizi);
        int toplam_cksm = cksm_alt + cksm_ust + cksm;

        System.out.println("\nToplam Cakisma:" + toplam_cksm);
    }

}
