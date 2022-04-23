public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(B>A.size()) return -1;
        int low=Integer.MIN_VALUE,high=0;
        for(Integer i:A){
            high+=i;
            low=Math.max(low,i);
        }
        int res=Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(possibleSol(A,mid,B)) {
                res = Math.min(res,mid);
                high = mid-1;
            }
            else low=mid+1;
        }
        return res;
    }
    public static boolean possibleSol(ArrayList<Integer> A,int mid,int B){
        int sumOfEle=0,noOfStu=1;
        for(Integer i:A){
            if(i>mid) return false;
            if(sumOfEle+i>mid){
                noOfStu++;
                sumOfEle=i;
            }
            else sumOfEle+=i;
        }
        return noOfStu<=B;
    }
}
