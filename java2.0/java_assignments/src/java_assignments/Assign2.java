
import java.util.*;

public class Assign2 {
    
    public static void main(String[] args) {
        int arr[]= {2,4,6,8};

        int sum =0;
        int avg = 0;
        int i=0;

        while(arr.length-1>=i){
            sum+=arr[i];
            i--;
        }
        avg= sum/arr.length;
        System.out.println(avg);
    }
}
