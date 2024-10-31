package LT_Buoi2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int n = sn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sn.nextInt();
        }
        for(int x : arr){
            mp.put(x, mp.get(x) + 1);
        }

        for(var value : mp.entrySet()) {
            System.out.println(value.getKey() + " " + value.getValue());
        }

    }
}
