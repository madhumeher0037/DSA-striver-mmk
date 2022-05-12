// /*
//  * 
// Given an array of scores that are non-negative integers. 
// Player 1 picks one of the numbers from either end of the array followed by 
// the player 2 and then player 1 and so on. Each time a player picks a number,
// that number will not be available for the next player. 
// This continues until all the scores have been chosen. 
// The player with the maximum score wins.

// Given an array of scores, predict whether player 1 is the winner. 
// You can assume each player plays to maximize his score.

// Sample Input: 
// 1 5 2

// Sample Output: 
// false

// Explanation: Initially, player 1 can choose between 1 and 2. 
// If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. 
// If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
// So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
// Hence, player 1 will never be the winner and you need to return False.

// Sample Input: 
// 1 5 233 7

// Output: 
// true

// Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. 
// No matter which number player 2 choose, player 1 can choose 233.
// Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

import java.util.*;

class Test{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] num = new int[s.length];
        int tot=0,n=num.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(s[i]);
            tot+=num[i];
            Arrays.fill(dp[i],-1);
        }
        
        int maxOfP1=findMax(0,n-1,num,dp);
        
        System.out.println(maxOfP1>=tot-maxOfP1);
    }
    
    public static int findMax(int first,int last,int[] nums,int[][] dp){
        if(first>last) return 0;
        
        if(dp[first][last]!=-1) return dp[first][last];
        int pickFirst = nums[first]+Math.min(findMax(first+2,last,nums,dp),findMax(first+1,last-1,nums,dp));
        int pickLast = nums[last]+Math.min(findMax(first+1,last-1,nums,dp),findMax(first,last-2,nums,dp));
        
        return dp[first][last]=Math.max(pickFirst,pickLast);
    }
}
