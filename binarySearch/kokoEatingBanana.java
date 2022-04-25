class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=Integer.MIN_VALUE,res=Integer.MAX_VALUE;
        for(int i=0;i<piles.length;i++) high=Math.max(high,piles[i]);
        // System.out.println(high);
        while(low<=high){
            int mid=(low+high)/2;
            
            if(isPossible(mid,piles,h)){
                // System.out.println(mid);
                res=Math.min(res,mid);
                high=mid-1;
            }
            else low=mid+1;
        }
        return res;
    }
    public boolean isPossible(int mid,int[] piles,int h){
        int dummyH=0;
        
        for(int i=0;i<piles.length;i++){
            dummyH+=(piles[i]/mid);
            if(piles[i]%mid!=0) dummyH++;
        }
        // System.out.println(dummyH);
        return dummyH<=h;
    }
}