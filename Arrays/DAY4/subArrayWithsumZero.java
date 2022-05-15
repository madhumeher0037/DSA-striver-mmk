// { Driver Code Starts
    import java.util.*;

    class MaxLenZeroSumSub
    {
    
        // Returns length of the maximum length subarray with 0 sum
    
        // Drive method
        public static void main(String arg[])
        {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++)
                    arr[i] = sc.nextInt();
    
                GfG g = new GfG();
                System.out.println(g.maxLen(arr, n));
                T--;
            }
        }
    }// } Driver Code Ends
    
    
    class GfG
    {
        int maxLen(int arr[], int n)
        {
            // Your code here
            int sum=0,max=0;
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            for(int i=0;i<n;i++){
                sum+=arr[i];
                if(sum==0){
                    max=Math.max(max,i+1);
                }
                else if(!hm.containsKey(sum)){
                    hm.put(sum,i);
                }
                else{
                    max=Math.max(max,i-hm.get(sum));
                }
            }
            return max;
        }
    }
    // basically saving the prefix sum in the hashmap
    // when that sum is repeated again means that sum contains the presum+0.
    // find the max length by excluding the presum index;