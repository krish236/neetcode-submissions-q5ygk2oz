class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>mp = new HashMap<>();
        int res = 0;
        int n = s.length();
        int j = 0;
        for(int i = 0; i<n; i++){
            Character ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);

            while(mp.size()<i-j+1){
                mp.put(s.charAt(j),mp.getOrDefault(s.charAt(j),0)-1);
                if(mp.get(s.charAt(j))==0) mp.remove(s.charAt(j));
                j++;

            }
            res = Math.max(res,i-j+1);
        }
        return res;
    }
}
