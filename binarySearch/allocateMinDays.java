class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<bloomDay.length;i++) max= Math.max(max,bloomDay[i]);
//         our ans lies between 1 and max days
        int low =1,high = max,ans=-1;
        
        while(low<=high){
            int mid = (low+high)/2;
//         check if that mid day is possible or not
            if(possible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return ans;
    }
    
    public static boolean possible(int[] bloom,int mid,int m,int k){
        int flower = k;
        int bouquets = m;
        
        for(int i=0;i<bloom.length && bouquets>0;i++){
//             if that day satiesfies then dec the flowers 
//             when any adjacent day is not satiesfied then make sure take the next day as starting and intialize the day with k
            if((bloom[i]-1)/mid==0 && flower>0){
                flower--;
            }
            else flower=k;
            
//             dec bouquets for each successfull bouquet 
            if(flower==0){
                bouquets--;
                flower=k;
            }
        }
        
        return bouquets==0;
    }
    
}