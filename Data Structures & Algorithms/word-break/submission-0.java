class Solution {

    boolean solve(String s, int ind, Set<String>st, int []dp){
        if(ind == s.length()){
            return true;
        }
        if(dp[ind]!=-1) return dp[ind]==1?true:false;
        String str = "";
        for(int i = ind;  i<s.length(); i++){
            str+= s.charAt(i);

            if(st.contains(str)==true){
                if(solve(s,i+1,st,dp)==true){
                    dp[ind] = 1;
                    return true;
                } 
            }
        }
        dp[ind] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Set<String>st = new HashSet<>();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        for(String str : wordDict){
            st.add(str);
        }

        return solve(s,0,st,dp);
    }
}
