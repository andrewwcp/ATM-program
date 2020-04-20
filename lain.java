package atm;

import java.util.ArrayList;


public class lain {


    private ArrayList<Integer> pin = new ArrayList();
    private ArrayList<String> nama = new ArrayList();
    private ArrayList<Integer> saldo = new ArrayList();
    public ArrayList history = new ArrayList();

    public void setPin(int pin) {     //pin
        this.pin.add(pin);
    }

    public int getPin(int i) {
        return this.pin.get(i);
    }

    public void setNama(String nama) {    //nama
        this.nama.add(nama);
    }

    public String getNama(int i) {
        return this.nama.get(i);
    }

    public void setSaldo(int saldo) {   //saldo
        this.saldo.add(saldo);
    }

    public int getSaldo(int i) {
        return this.saldo.get(i);
    }

    
     public void tambahSaldo(int Pin,int tambahsaldo){
        this.saldo.add(cekPin(Pin), this.saldo.get(cekPin(Pin))+tambahsaldo);
    }
     
    public void kurangSaldo(int Pin, int kurangsaldo){
        if (this.saldo.get(cekPin(Pin))-kurangsaldo >= 0) {
        this.saldo.add(cekPin(Pin), this.saldo.get(cekPin(Pin))-kurangsaldo);
        }
        else { 
            System.out.println("Saldo tidak mencukupi, silahkan ulang masukkan");
        }
    }
   

    public int dataSize() {
        return pin.size();
    }

    public int cekPin(int Pin) {
        return this.pin.indexOf(Pin);
       
    }
    
    public void dataHapus(int Pin){
        saldo.remove(cekPin(Pin));
        nama.remove(cekPin(Pin));
        pin.remove(cekPin(Pin));
        
        
    }
 

}
