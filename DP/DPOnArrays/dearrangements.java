import java.util.*;
//  for every element there are two scenarios 
//  First a number can be arranged in n-1 ways because we cant place it in original position
//  case 1 for next ele's there are n-1 elements are in their original pos
//  case 2 two ele's are interChanged,therefore there only n-2 ele's are present in thier original pos
class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(dearrange(n,dp));
        return;
    }
    
    public static int dearrange(int n,int[] dp){
        if(n==1) return 0;
        if(n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = (n-1)*(dearrange(n-1,dp)+dearrange(n-2,dp));
    }
}
// Tabulation
class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1]=0;
        dp[2]=1;
        
        for(int i=3;i<=n;i++){
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        }
        System.out.println(dp[n]);
        return;
    }
}