import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter yourcode here. Read input from STDIN. Print output to STDOUT */
        new Solution(args);
    }
    


    public Solution(String args[]) {
        Scanner reader = new Scanner(System.in);
        
        List<Integer> lists = new ArrayList<>();
        int numSellers = reader.nextInt();
        reader.nextLine();
        for (int i = 0; i < numSellers; i++) {
            lists.add(reader.nextInt());
            reader.nextLine();  // move the reader pointer to nextLine (skip the int)
        }
        int numTickets = reader.nextInt();
        
        System.out.println(lists);
        System.out.println(numTickets);
        
        int[] bucket = new int[100001];
        for (int i = 0; i < lists.size(); i++) {
            int cur = lists.get(i);
            for (int j = 1; j <= cur; j++) {
                bucket[j] += 1;
            }
        }
        
        long ans = 0;
        for (int i = 100000; i >= 1; i--) {
            if (bucket[i] != 0) {
                if (bucket[i] < numTickets) {
                    ans += bucket[i] * i;
                    numTickets -= bucket[i];
                } else if (bucket[i] >= numTickets) {
                    // exit
                    ans += numTickets * i;
                    numTickets -= bucket[i];
                    break;
                }
            }
        }
        System.out.println("ans: " + ans);

    }
    

    
    
}