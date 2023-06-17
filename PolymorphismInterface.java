import java.text.DecimalFormat;
import java.util.*;

interface Bilangan{
    abstract public void print();
}

class BilanganDesimal implements Bilangan{
    protected double nilai;

    BilanganDesimal(double nilai){
        this.nilai = nilai;
    }

    public void add(BilanganDesimal b){
        this.nilai += b.nilai;
    }

    public void print(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(nilai));
    }

}

class BilanganPecahan implements Bilangan{
    protected int pembilang;
    protected int penyebut;

    BilanganPecahan(int pembilang, int penyebut){
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public void add(BilanganPecahan b){
        int p = this.pembilang;
        int q = this.penyebut;
        int r = b.pembilang;
        int s = b.penyebut;
    
        this.pembilang = p*s + q*r;
        this.penyebut = q*s;

        int gcd = 1;
        for(int i = 1; i <= this.pembilang && this.penyebut >= i; i++){
            if(this.pembilang % i == 0 && this.penyebut % i == 0){
                gcd = i;
            }
        }

        this.pembilang /= gcd;
        this.penyebut /= gcd;

    }

    public void print(){
        System.out.println(pembilang + " " + penyebut);
    }
}

public class PolymorphisInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bilangan[] bilangan = new Bilangan[n];
        for(int i = 0; i < n; i++){
            int select = sc.nextInt();
            if(select == 1){
                BilanganDesimal a = new BilanganDesimal(sc.nextDouble());
                BilanganDesimal b = new BilanganDesimal(sc.nextDouble());
                a.add(b);
                bilangan[i] = a;
            }
            else if(select == 2){
                BilanganPecahan a = new BilanganPecahan(sc.nextInt(), sc.nextInt());
                BilanganPecahan b = new BilanganPecahan(sc.nextInt(), sc.nextInt());
                a.add(b);
                bilangan[i] = a;
            }
        }
        int inputakhir1 = sc.nextInt();
        int inputakhir2 = sc.nextInt();

        for(int j = 1; j < inputakhir2; j++){
            bilangan[j].print();
        }
    }
}
