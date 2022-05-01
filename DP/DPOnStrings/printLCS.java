import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'longestCommonSubsequence' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b) {
    // Write your code here
        int len1 = a.size();
        int len2 = b.size();
        
        int dp[][] = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++) dp[i][0]=0;
        for(int i=0;i<=len2;i++) dp[0][i]=0;
        
        for(int ind1=1;ind1<=len1;ind1++){
            for(int ind2=1;ind2<=len2;ind2++){
                if(a.get(ind1-1).equals(b.get(ind2-1))) dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        // System.out.println(dp[len1][len2]);
        List<Integer> res = new ArrayList<Integer>();
        int i=len1,j=len2;
        
        while(i>0 && j>0){
            if(a.get(i-1).equals(b.get(j-1))){
                // System.out.println(a.get(i-1));
                res.add(a.get(i-1));
                // index--;index
                i=i-1;
                j=j-1;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i=i-1;
            }
            else{
                 j=j-1;
            }
        }
        Collections.reverse(res);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.longestCommonSubsequence(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
