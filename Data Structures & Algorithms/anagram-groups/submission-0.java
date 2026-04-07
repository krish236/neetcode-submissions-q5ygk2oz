class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<Map<Character,Integer>, List<String>>mp = new HashMap<>();
        int n = strs.length;
        for(int i = 0; i<n; i++){
            String st = strs[i];
            Map<Character,Integer> tmp = new HashMap<>();
            for(int j = 0; j<st.length(); j++){
                tmp.put(st.charAt(j), tmp.getOrDefault(st.charAt(j),0)+1);
            }

            if(mp.containsKey(tmp)==true){
                mp.get(tmp).add(st);
            }
            else{
                List<String>stl = new ArrayList<>();
                stl.add(st);
                mp.put(tmp,stl);
            }
        }

        for(Map<Character,Integer>tmp : mp.keySet()){
            res.add(mp.get(tmp));
        }
        return res;

    }
}
