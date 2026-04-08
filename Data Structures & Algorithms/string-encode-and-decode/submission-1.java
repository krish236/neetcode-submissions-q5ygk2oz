class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0) return "";
        int n = strs.size();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            sb.append(strs.get(i));
            sb.append("?.?");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str == "") return new ArrayList<>();
        List<String>ls = new ArrayList<>();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n-3; i++){
            if(str.charAt(i)=='?' && str.charAt(i+1)=='.' && str.charAt(i+2)=='?'){
                ls.add(sb.toString());
                sb.setLength(0);
                i = i+2;
            }else{
                sb.append(str.charAt(i));
            }   
        }
        ls.add(sb.toString());
        return ls;
    }
}
