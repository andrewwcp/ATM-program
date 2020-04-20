package atm;

import java.util.Scanner;

public class menu {

    lain ln = new lain();
    Scanner ini = new Scanner(System.in);
    int Pin, saldo, tambahsaldo, kurangsaldo;
    String nama;
    char ulang;

    void casePertama() {
        if (ln.dataSize() == 0) {
            System.out.println("Data kosong!!!");
            System.out.println("Tekan [enter] untuk proses...");
            new java.util.Scanner(System.in).nextLine();
        } else {
            for (int i = 0; i < ln.dataSize(); i++) {
                System.out.println((i + 1) + ". No.Pin   : " + ln.getPin(i));
                System.out.println("   Nama     : " + ln.getNama(i));
                System.out.println("   Saldo    : " + ln.getSaldo(i));
            }
        }
        ln.history.add("lihat data nasabah");
    }

    void caseKedua() {
        System.out.print("Buat pin baru : ");
        Pin = ini.nextInt();
        ln.setPin(Pin);
        ini.nextLine();
        System.out.print("Masukkan nama : ");
        nama = ini.nextLine();
        ln.setNama(nama);
        System.out.print("Masukkan saldo : ");
        saldo = ini.nextInt();
        ln.setSaldo(saldo);
        ln.history.add("input data nasabah baru dengan PIN " + (ln.getPin(ln.cekPin(Pin))));

    }

    void caseKetiga() {
        do {
            System.out.print("Masukkan pin : ");
            Pin = ini.nextInt();
            if (ln.cekPin(Pin) == -1) {
                System.out.println("Pin tidak ada!!!");
                System.out.println("Tekan [enter] untuk proses...");
                new java.util.Scanner(System.in).nextLine();
            }

        } while (ln.cekPin(Pin) == -1);

        System.out.println("Selamat datang " + ln.getNama(ln.cekPin(Pin)) + ", saldo anda Rp." + ln.getSaldo(ln.cekPin(Pin)));
        System.out.print("Masukan nominal uang : ");
        tambahsaldo = ini.nextInt();
        ln.tambahSaldo(Pin, tambahsaldo);
        System.out.println("Tekan [enter] untuk proses...");
        new java.util.Scanner(System.in).nextLine();

        ln.history.add("Tabung senilai Rp " + tambahsaldo + " ke No. Pin " + (ln.getPin(ln.cekPin(Pin))));
    }

    void caseKeempat() {
        do {
            System.out.print("Masukkan pin : ");
            Pin = ini.nextInt();
            if (ln.cekPin(Pin) == -1) {
                System.out.println("Pin tidak ada!!!");
                System.out.println("Tekan [enter] untuk proses...");
                new java.util.Scanner(System.in).nextLine();
            }

        } while (ln.cekPin(Pin) == -1);

        System.out.println("Selamat datang " + ln.getNama(ln.cekPin(Pin)) + ", saldo anda  Rp." + ln.getSaldo(ln.cekPin(Pin)));

        System.out.print("Masukan nominal uang : ");
        kurangsaldo = ini.nextInt();
        ln.kurangSaldo(Pin, kurangsaldo);

        System.out.println("Tekan [enter] untuk proses...");
        new java.util.Scanner(System.in).nextLine();

        ln.history.add("Tarik tunai senilai Rp " + kurangsaldo + " ke No. Pin " + (ln.getPin(ln.cekPin(Pin))));
    }

    void casekelima() {
        System.out.println("Hapus data\n");

        System.out.print("Masukkan pin : ");
        Pin = ini.nextInt();
        if (ln.cekPin(Pin) == -1) {
            System.out.println("Pin tidak ada!!!");
            System.out.println("Tekan [enter] untuk proses...");
            new java.util.Scanner(System.in).nextLine();
        } else {

            OUTER:
            do {
                System.out.println("No. pin   : " + ln.getPin(ln.cekPin(Pin)));
                System.out.println("Nama      : " + ln.getNama(ln.cekPin(Pin)));
                System.out.println("Saldo     : " + ln.getSaldo(ln.cekPin(Pin)));
                System.out.print("Yakin hapus?? [y/n] : ");
                ulang = ini.next().charAt(0);
                switch (ulang) {
                    case 'y':
                    case 'Y':
                        ln.history.add("Hapus data nasabah dengan No. pin : " + ln.getPin(ln.cekPin(Pin)) + " atas nama : " + ln.getNama(ln.cekPin(Pin)));
                        ln.dataHapus(Pin);
                        System.out.println("Data terhapus");
                        System.out.println("Tekan [enter] untuk proses...");
                        new java.util.Scanner(System.in).nextLine();
                        break OUTER;
                    case 'n':
                    case 'N':
                        System.out.println("data tidak jadi dihapus");
                        System.out.println("Tekan [enter] untuk proses...");
                        new java.util.Scanner(System.in).nextLine();
                        ln.history.add("Hapus data nasabah dengan No.pin : " + ln.getPin(ln.cekPin(Pin)) + " tapi batal");
                        break OUTER;
                    default:
                        System.out.println("Pilihan tidak ada!!!");
                }
            } while (false);

        }

    }

    void casekeenam() {
        System.out.println("Riwayat : ");
        ln.history.forEach((riwayat) -> {
            System.out.println(riwayat);
        });
    }
}
