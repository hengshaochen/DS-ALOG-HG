import java.io.*;
import java.util.*;
import java.util.regex.*;


public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    // Use map to count the total repeat time of URL and write to output file
    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        File f = new File(filename);
        Scanner reader = new Scanner(f);

        Map<String, Integer> map = new HashMap<>();
        while (reader.hasNextLine()) {
            String[] curLine = (reader.nextLine()).split(" ");
            String curURL = curLine[0];
            if (!map.containsKey(curURL)) {
                map.put(curURL, 1);
            } else {
                map.put(curURL, map.get(curURL) + 1);
            }
        }

        // Write File
        String outputFileName = "records_" + filename;
        File output = new File(outputFileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        bw.flush();
        bw.close();

    }
}



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public static List<String> missingWords(String s, String t) {
        // Time: O(N)
        // Algo: split the words by space and use two pointer. i point to String s, j point to String t, if current is equal then move i and j, otherwise move j
        // move i,  
        int i = 0, j = 0;
        String[] sArray = s.split(" ");
        String[] tArray = t.split(" ");
        List<String> ans = new ArrayList<>();
        while (i < sArray.length && j < tArray.length) {
            if (sArray[i].compareTo(tArray[j]) == 0) {
                i++;
                j++;
            } else {
                ans.add(sArray[i++]);
            }
        }
        while (i < sArray.length) {
            ans.add(sArray[i++]);
        }
        return ans;
    }

}

public class Solution {