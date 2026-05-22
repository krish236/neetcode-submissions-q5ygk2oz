class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int i = 0; i<piles.length; i++){
            high = Math.max(high,piles[i]);
        }
        int n = piles.length;
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int curr = 0;
            for(int i = 0; i<n; i++){
                curr = curr + (int)Math.ceil((double)piles[i]/mid);                
            }
            //System.out.println();
            if(curr<=h){
                System.out.println(mid);
                
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
