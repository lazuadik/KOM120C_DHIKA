import java.util.*;

public class Person{
    private String nama;
    private int usia;
    private int tinggi;
    private double berat;

    public Person(){
        nama = "";
        usia = 0;
        tinggi = 0;
        berat = 0;
    }

    public void setPerson(String nama, int usia, int tinggi, double berat){
        this.nama = nama;
        this.usia = usia;
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public String getNama(){
        return nama;
    }

    public int getUsia(){
        return usia;
    }

    public int getTinggi(){
        return tinggi;
    }

    public double getBerat(){
        return berat;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalTinggi = 0;
        int n;
        n = sc.nextInt();
        Person [] p = new Person[n];
        for(int i = 0; i < n; i++){
            p[i] = new Person();
            String nama = sc.next();
            int usia = sc.nextInt();
            int tinggi = sc.nextInt();
            double berat = sc.nextDouble();
            p[i].setPerson(nama, usia, tinggi, berat);
            totalTinggi += p[i].getTinggi();
        }
        double rataan;
        rataan = totalTinggi / n;

        int atasRata;
        int counter = 0;
        for(int i = 0; i < n; i++){
            if (p[i].getTinggi() > rataan){
                counter++;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.printf(p[i].nama + " " + p[i].usia);
            System.out.printf("\n");
        }
        System.out.printf("%.2f\n", rataan);
        System.out.println(counter);

    }
}
