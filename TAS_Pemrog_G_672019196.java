package tas_pemrog_g_672019196;

import java.util.Scanner;

public class TAS_Pemrog_G_672019196 {

    public static void main(String[] args) {
        Scanner ini = new Scanner(System.in);
        menu data = new menu();
        int pilihan = 7;
        do {
            System.out.println("<------------------->");
            System.out.println("       MENU ATM      ");
            System.out.println("<------------------->");
            System.out.println("\n1. Lihat data Nasabah");
            System.out.println("2. Input data Nasabah");
            System.out.println("3. Tabung");
            System.out.println("4. Tarik tunai");
            System.out.println("5. Hapus Data Nasabah");
            System.out.println("6. History");
            System.out.println("7. Exit");
            System.out.print("\nPilih Menu : ");
            pilihan = ini.nextInt();
            System.out.println("========================");
            switch (pilihan) {
                case 1:
                    data.casePertama();
                    break;
                case 2:
                    data.caseKedua();
                    break;
                case 3:
                    data.caseKetiga();
                    break;
                case 4:
                    data.caseKeempat();
                    break;
                case 5:
                    data.casekelima();
                    break;
                case 6:
                    data.casekeenam();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Pilihan hanya sampai 7 !!!");

            }

        } while (true);
    }

}
