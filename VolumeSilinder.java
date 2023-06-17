import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

abstract class BangunDatar{
    abstract double luas();
}

class Rectangle extends BangunDatar{
    protected double panjang = 0.00;
    protected double lebar = 0.00;

    public void setPanjang(double panjang){
        this.panjang = panjang;
    }

    public void setLebar(double lebar){
        this.lebar = lebar;
    }
    
    public Rectangle(double panjang, double lebar){
        setPanjang(panjang);
        setLebar(lebar);

    }

    public double luas(){
        return panjang*lebar;
    }

}

class Circle extends BangunDatar{
    protected double diameter = 0.00;

    public void setDiameter(double diameter){
        this.diameter = diameter;
    }

    public Circle(double diameter){
        setDiameter(diameter);
    }

    public double luas(){
        return Math.PI*diameter*diameter/4;
    }
}

class Silinder{
    protected double diameter;
    protected double tinggi;
    protected double volume;
    protected Circle alas;
    protected Rectangle luas;

    public double hitungVolume(){
        return alas.luas()*this.tinggi;
    }

    public Silinder(double diameter, double lebar, double tinggi){
        this.diameter = diameter;
        this.tinggi = tinggi;
        alas = new Circle(diameter);
        luas = new Rectangle(lebar, tinggi);
        volume = hitungVolume();
    }
}

public class VolumeSilinder{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalVolume = 0.00;
        int n;
        n = sc.nextInt();
        Silinder[] silinder = new Silinder[n];
        for(int i = 0; i < n; i++){
            double diameter;
            diameter = sc.nextDouble();
            double lebar;
            lebar = sc.nextDouble();
            double tinggi;
            tinggi = sc.nextDouble();
            silinder[i] = new Silinder(diameter, lebar, tinggi);
            totalVolume += silinder[i].volume;
        }
        double rataan;
        rataan = totalVolume/n;
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(silinder[i].volume > rataan){
                counter++;
            }
        }
        System.out.printf("%.2f ", rataan);
        System.out.println(counter);
    }
}