import java.util.*;

abstract class Shape{
    public double hitungSemua(double kel1, double kel2){
        double keliling = kel1 + kel2;
        return keliling;
    }
    abstract public void set(double panjang, double lebar);
    abstract public double hitungArea();
}

class Rectangle extends Shape{
    protected double panjang;
    protected double lebar;
    protected double keliling;

    public void set(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double hitungArea(){
        return 2*(panjang+lebar);
    }
}

class Circle extends Shape{
    protected double radius;

    public void set(double panjang, double lebar){
        this.radius = panjang;
    }

    public double hitungArea(){
        return Math.PI*2*radius;
    }
}

public class keliling {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        Double kel1 = 0.0;
        Double kel2 = 0.0;
        Double kel3 = 0.0;
        Shape shp;
        shp = new Rectangle();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int select = sc.nextInt();
            if(select == 0){
                double panjang = sc.nextDouble();
                double lebar = sc.nextDouble();
                shp.set(panjang, lebar);
                kel1 += shp.hitungArea();
                list.add(shp.hitungArea());
            }
            else if(select == 1){
                shp = new Circle();
                double radius = sc.nextDouble();
                shp.set(radius, 0.00);
                kel2 += shp.hitungArea();
                list.add(shp.hitungArea());
            }
        }
        for(int i = 0; i < n; i++){
            if(list.get(i) > shp.hitungSemua(kel1, kel2)/n){
                kel3 += list.get(i);
            }
        }
        System.out.printf("%.2f\n", kel3);
    }
}
