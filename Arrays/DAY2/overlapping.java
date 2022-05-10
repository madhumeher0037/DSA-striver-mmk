// bruteForce
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0],end = intervals[i][1];
//             if this interval already exits,we'll not care about it
            if(arr.size()!=0 && start<=arr.get(arr.size()-1).get(1)){
                continue;
            }
//             find the overlap arrays
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[j][0]<=end){
                    if(end<=intervals[j][1]) end = intervals[j][1];
                }
            }
            List<Integer> innerarr = new ArrayList<Integer>();
            innerarr.add(start);
            innerarr.add(end);
            arr.add(new ArrayList<Integer>(innerarr));
        }
        // System.out.println(arr);
        int[][] res = new int[arr.size()][2];
        int i=0;
        for(List<Integer> l : arr){
            res[i][0]=l.get(0);
            res[i][1]=l.get(1);
            i++;
        }
        return res;
    }
}

// Optimal Approach

class Solution {
    public int[][] merge(int[][] intervals) {
//         sort the array
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int last = intervals[0][1];
//         iterate through intervals,which are overlapping merge them
        for(int[] arr:intervals){
            if(arr[0]<=last){
                last = Math.max(last,arr[1]);
            }
            else{
                res.add(new int[]{start,last});
                start = arr[0];
                last = arr[1];
            }
        }
        res.add(new int[]{start,last});
        return res.toArray(new int[0][]);
    }
}