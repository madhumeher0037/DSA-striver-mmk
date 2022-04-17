
// pick and not pick
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> innerList= new ArrayList<Integer>();
        boolean[] f = new boolean[nums.length];
        findPermutation(nums,ans,innerList,f);
        return ans;
    }
    public static void findPermutation(int[] nums,List<List<Integer>> ans,List<Integer> innerList,boolean[] f){
        int n=nums.length;
        if(innerList.size()==n){
            ans.add(new ArrayList<Integer>(innerList));
            return;
        }
        for(int i=0;i<n;i++){
            if(!f[i]){
                f[i]=true;
                innerList.add(nums[i]);
                findPermutation(nums,ans,innerList,f);
                innerList.remove(innerList.size()-1);
                f[i]=false;
            }
        }
        return;
    }
}


// Swapping approch
// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine().trim());
            while(t-->0)
            {
                String S = br.readLine().trim();
                Solution obj = new Solution();
                List<String> ans = obj.find_permutation(S);
                for( int i = 0; i < ans.size(); i++)
                {
                    System.out.print(ans.get(i)+" ");
                }
                System.out.println();
                            
            }
        }
    }
    


    // } Driver Code Ends
    
    
    class Solution {
        public List<String> find_permutation(String S) {
            // Code here
            List<String> res = new ArrayList<String>();
            String[] str=S.split("");
            find_per(0,str,res);
            Collections.sort(res);
            return res;
        }
        public void find_per(int ind,String[] str,List<String> res){
            if(ind>=str.length){
                String temp="";
                for(int i=0;i<str.length;i++) temp+=str[i];
                res.add(temp);
                return;
            }
            for(int i=ind;i<str.length;i++){
                swap(str,ind,i);
                find_per(ind+1,str,res);
                swap(str,ind,i);
            }
        }
        public void swap(String[] str,int i,int j){
            String temp = str[i];
            str[i]=str[j];
            str[j]=temp;
        }
    }