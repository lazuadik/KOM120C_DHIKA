import java.text.DecimalFormat;
import java.util.*;

interface shape2D{
    void set(int n, double[] x, double[] y);
    void print();
    double keliling();
}

class Poligon implements shape2D{
    private int n;
    private double[] x;
    private double[] y;

    public void set(int n, double[] x, double[] y){
        this.n = n;
        this.x = x;
        this.y = y;
    }

    public void print(){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("[" + df.format(x[0]) + "," + df.format(y[0]) + "]" + "-" + "[" + df.format(x[n-1]) + "," + df.format(y[n-1]) + "]");
    }

    public double keliling(){
        double totalSisi = 0.00;
        for(int i = 0; i < n-1; i ++){
            double dx = x[i+1] - x[i];
            double dy = y[i+1] - y[i];
            totalSisi += Math.sqrt(dx*dx + dy*dy);
        }
        double dx = x[0] - x[n-1];
        double dy = y[0] - y[n-1];
        totalSisi += Math.sqrt(dx*dx + dy*dy);
        return totalSisi;
    }
}

public class Interface2D{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];
        for(int i = 0; i < n; i++){
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }
        Poligon poligon = new Poligon();
        poligon.set(n, x, y);
        poligon.print();
        double keliling = poligon.keliling();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(keliling));
}
}

