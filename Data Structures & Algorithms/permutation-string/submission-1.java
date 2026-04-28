class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        Map<Character,Integer>mp = new HashMap<>();
        Map<Character,Integer>mp2 = new HashMap<>();

        for(int i = 0; i<n; i++){
            mp.put(s1.charAt(i), mp.getOrDefault(s1.charAt(i),0)+1);
        }

        int i = 0;
        int count = 0;
        for(int j = 0; j<m; j++){
            mp2.put(s2.charAt(j), mp2.getOrDefault(s2.charAt(j),0)+1);
            count++;
            while(count>n){
                
                mp2.put(s2.charAt(i), mp2.getOrDefault(s2.charAt(i),0)-1);
                count--;
                if(mp2.get(s2.charAt(i))==0) mp2.remove(s2.charAt(i));
                i++;
            }

            if(count==n && mp.equals(mp2)==true) return true;
        }
        return false;
    }
}
