class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        
        List<Integer>ls = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(i>=k && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(dq.isEmpty() == false && nums[dq.peekLast()]< nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i>=k-1){
                ls.add(nums[dq.peekFirst()]);
            }
        }

        return ls.stream().mapToInt(Integer::intValue).toArray();
    }
}
