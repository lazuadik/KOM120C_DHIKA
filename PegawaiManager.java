import java.util.*;

class Pegawai{
    protected String id;
    protected int usia;
    protected int tipe;
    protected int income;
    public Pegawai(){ 
        id=""; usia=income=0; tipe=1; 
    }
    public void set(String pid, int u, int t ){
        id=pid; usia=u; tipe=t; 
    }
    public String getID(){ 
        return id; 
    }
    public void show(){ 
        System.out.printf("%s %d %d\n", id, tipe, income);
    }
}

class Tetap extends Pegawai{
    private int lembur;

    public void set(String pid, int u, int t, int i){
        super.set(pid, u, t);
        income = i;
    }

    public void setLembur(int i){
        income = i;
        income += lembur;
    }
}

class Harian extends Pegawai{
    private int upah;

    public Harian(){
        income = 0;
    }

    public void setUpah(int up){
        upah = up;
        income += up;

    }
}

public class PegawaiManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector <Tetap> pegawaiTetap = new Vector<Tetap>();
        Vector <Harian> pegawaiHarian = new Vector<Harian>();
        for(int j = 0; j < n; j++){
            String id;
            int usia; 
            int tipe;
            id = sc.next();
            usia = sc.nextInt();
            tipe = sc.nextInt();
            if(tipe == 1){
                int gajiPokok;
                gajiPokok= sc.nextInt();
                Tetap pegawai = new Tetap();
                pegawai.set(id, usia, tipe, gajiPokok);
                pegawaiTetap.add(pegawai);
            }
            else if(tipe == 2){
                Harian pegawai = new Harian();
                pegawai.set(id, usia, tipe);
                pegawaiHarian.add(pegawai);

            }
        }

        String input;
        input = sc.next();

        while(!input.equals("END")){
            for(Tetap pegawai : pegawaiTetap){
                if(pegawai.getID().equals(input)){
                    int lembur;
                    lembur = sc.nextInt();
                    pegawai.setLembur(lembur);
                    break;
                }
            }
            for(Harian pegawai : pegawaiHarian){
                if(pegawai.getID().equals(input)){
                    int upah;
                    upah = sc.nextInt();
                    pegawai.setUpah(upah);
                    break;
                }
            }
            input = sc.next();
        }
        for(Tetap pegawai : pegawaiTetap){
            pegawai.show();
        }
        for(Harian pegawai : pegawaiHarian){
            pegawai.show();
        }
    }
}
