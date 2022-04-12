class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // storing the key as elements and values as their frequency
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int a = hm.getOrDefault(nums[i],0);
            hm.put(nums[i],++a);
        }
        // sort the hashMap based on values 
        // List<Map.Entry<Integer,Integer>> hm1 = new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());
        // Collections.sort(hm1,new Comparator<Map.Entry<Integer,Integer>>(){
        //      public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b){
        //         return b.getValue().compareTo(a.getValue());
        //     }
        // });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k,(a,b)->(a[1]-b[1]));
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){
            pq.offer(new int[]{(int)e.getKey(),(int)e.getValue()});
            if(pq.size()>k) pq.poll();
        }
        int[] arr = new int[k];
        int i=0;
        while(pq.size()>0){
            // arr[i]=(int)e.getKey(); 
            arr[i]=pq.poll()[0];
            i++;
            // if(>=k) break;
        }
        return arr;
    }
}