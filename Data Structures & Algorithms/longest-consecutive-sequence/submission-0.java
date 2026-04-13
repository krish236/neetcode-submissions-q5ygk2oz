class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer>mp = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            mp.put(nums[i],i);
        }

        int res = 0;

        for(int i = 0; i<nums.length; i++){
            if(mp.containsKey(nums[i]-1)==false){
                int tmpCnt =0;
                int num = nums[i];

                while(mp.containsKey(num)==true){
                    tmpCnt++;
                    num++;
                }
                res = Math.max(res,tmpCnt);
            }
        }
        return res;
    }
}
