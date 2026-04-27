class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int res = 0;
        int maxSum = 0;
        int i = 0;
        Map<Character,Integer>mp = new HashMap<>();
        for(int j = 0; j<n; j++){
            Character ch = s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);

            maxSum = Math.max(maxSum,mp.get(ch));
            
            while(i<j && j-i+1 - maxSum > k){
                mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)-1);
                if(mp.get(s.charAt(i))==0) mp.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
