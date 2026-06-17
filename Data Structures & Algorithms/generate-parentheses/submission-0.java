class Solution {

    void backTrack(String s, int n, List<String>res, int open, int closed){
        if(open == n && closed==n){
            res.add(s);
            return;
        }

        if(open>n) return;
        if(closed>open) return;

        backTrack(s+'(',n,res,open+1,closed);
        backTrack(s+')',n,res,open,closed+1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "";

        backTrack(s,n,res,0,0);
        return res;
    }
}
