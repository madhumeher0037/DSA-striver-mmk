// bruteForce
public class Solution {
  
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long Count=0;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(arr[i]>arr[j]) Count++;
			}
		}
		return Count;
    }
}

// MergeSort
public class Solution {
  
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        int low =0,high=n-1;
		long[] temp = new long[n];
		return mergeSort(arr,temp,low,high);
    }
	
	public static long mergeSort(long[] arr,long[] temp,int low,int high){
		long inverseCnt=0;
		if(low<high){
			int mid = (low+high)/2;
			inverseCnt+=mergeSort(arr,temp,low,mid);
			inverseCnt+=mergeSort(arr,temp,mid+1,high);
			inverseCnt+=merge(arr,temp,low,mid,high);
		}
		return inverseCnt;
	}
	
	public static long merge(long[] arr,long[] temp,int low,int mid,int high){
		int i=low;
		int j=mid+1;
		int k = low;
		long cnt=0;
		while(i<=mid && j<=high){
			if(arr[i]<=arr[j]){
				temp[k++]=arr[i++];
			}
			else{
				temp[k++]=arr[j++];
				cnt = cnt +(mid+1-i);
			}
		}
		while(i<=mid) temp[k++]=arr[i++];
		while(j<=high) temp[k++]=arr[j++];
		
		for(int ind=low;ind<=high;ind++){
			arr[ind]=temp[ind];
		}
		return cnt;
	}
}