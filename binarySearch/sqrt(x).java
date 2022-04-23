class Solution {
    public int mySqrt(int x) {
        long low=1,high=x/2;
        while(low<=high){
            long mid=(low+high)/2;
            long val=mid*mid;
            if(val==x) return (int)mid;
            else if(val>x) high=mid-1;
            else low=mid+1;
        }
        return (int)high;
    }
}