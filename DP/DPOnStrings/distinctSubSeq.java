// recursion our appraoch
// giving TLE
import java.util.*;
public class Solution {
    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        // Write your code here..
		HashMap<String,Integer> dp = new HashMap<String,Integer>();
		return countSubSeq(0,t,s,"",lt,dp); 
    }
	public static int countSubSeq(int ind,String t,String s,String temp,int lt,HashMap<String,Integer> dp){
		if(ind==lt){
			if(temp.equals(s)) return 1;
			return 0;
		}
		String key = String.valueOf(ind)+" "+temp;
		if(dp.containsKey(key)) return dp.get(key);
		int pick = countSubSeq(ind+1,t,s,temp+t.charAt(ind),lt,dp);
		int notPick = countSubSeq(ind+1,t,s,temp,lt,dp);
		dp.put(key,pick+notPick);
		return pick+notPick;
	}

}

// memoization
class Solution {
    public int numDistinct(String s, String t) {
        int lt =s.length(),ls =t.length();
        int[][] dp = new int[lt+1][ls+1];
        for(int i=0;i<=lt;i++) Arrays.fill(dp[i],-1);
        return countSubSeq(lt,ls,s,t,dp); 
    }
    public static int countSubSeq(int ind1,int ind2,String t,String s,int[][] dp){
		if(ind2<1) return 1;
		if(ind1<1) return 0;
		if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
		if(t.charAt(ind1-1)==s.charAt(ind2-1)){
			return dp[ind1][ind2]=countSubSeq(ind1-1,ind2-1,t,s,dp)+countSubSeq(ind1-1,ind2,t,s,dp);
		}
		return dp[ind1][ind2]=countSubSeq(ind1-1,ind2,t,s,dp);
	}

}

// tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int ls =s.length(),lt =t.length();
        int[][] dp = new int[ls+1][lt+1];
        // for(int i=0;i<=ls;i++) Arrays.fill(dp[i],-1);
        // return countSubSeq(ls,lt,s,t,dp); 
        for(int i=0;i<=ls;i++) dp[i][0]=1;
        for(int i=1;i<=lt;i++) dp[0][i]=0;
        
        for(int ind1=1;ind1<=ls;ind1++){
            for(int ind2=1;ind2<=lt;ind2++){
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    dp[ind1][ind2]=dp[ind1-1][ind2-1]+dp[ind1-1][ind2];
                }
                else{
                    dp[ind1][ind2]=dp[ind1-1][ind2];
                }
            }
        }
        return dp[ls][lt];
    }
}