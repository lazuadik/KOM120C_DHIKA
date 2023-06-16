import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int shift = 0;
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while(input != -9){
            list.add(input);
            input = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        int sizearray = list.size();
        double mean_awal = (double) (sum / sizearray);

        int index = sc.nextInt();
        while(index != -9){
            list.remove(index-1-shift);
            shift++;
            index = sc.nextInt();
        }

        int sumafter = 0;
        for(int i = 0; i < list.size(); i++){
            sumafter += list.get(i); 
        }
        int sizearrayafter = list.size();

        double mean_after = (double) (sumafter/sizearrayafter);

        System.out.println(sizearray);
        System.out.println(sizearrayafter);
        System.out.printf("%.2f ", mean_awal);
        System.out.printf("%.2f", mean_after);
    }
}
