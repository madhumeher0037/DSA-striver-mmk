class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<Integer>();
        int[] left = new int[n];
        int[] right = new int[n];
//         find left borders for each index
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()) left[i]=0;
            else left[i]=st.peek()+1;
            st.push(i);
        }
//         find right borders for each index
        while(!st.isEmpty()) st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()) right[i]=n-1;
            else right[i]=st.peek()-1;
            st.push(i);
        }
//         find the max rectangle area (right - left + 1)*arr[i]
        int max = 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++) max = Math.max(max,((right[i]-left[i]+1)*heights[i]));
        return max;
    }
}