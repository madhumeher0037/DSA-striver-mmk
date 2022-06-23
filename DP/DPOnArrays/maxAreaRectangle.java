class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] histogram = new int[matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0') histogram[j]=0;
                else histogram[j]+=1;
            }
            max = Math.max(max,findMaxRectangle(histogram));
        }
        return max;
    }
    public int findMaxRectangle(int[] h){
        int n = h.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && h[st.peek()]>=h[i]) st.pop();
            if(st.isEmpty()) left[i]=0;
            else left[i]=st.peek()+1;
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && h[st.peek()]>=h[i]) st.pop();
            if(st.isEmpty()) right[i]=n-1;
            else right[i]=st.peek()-1;
            st.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++) max = Math.max(max,(right[i]-left[i]+1)*h[i]);
        return max;
    }
}