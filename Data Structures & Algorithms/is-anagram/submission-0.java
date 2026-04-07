class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if(n!=m) return false;

        Map<Character,Integer>mp = new HashMap<>();

        for(int i = 0; i<n; i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i = 0; i<m; i++){
            if(mp.containsKey(t.charAt(i))==false) return false;


            mp.put(t.charAt(i), mp.get(t.charAt(i))-1);

            if(mp.get(t.charAt(i))==0) mp.remove(t.charAt(i));
        }

        return mp.size()==0?true:false;
    }
}
