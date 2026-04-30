class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character>st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(st.size()==0 && (ch ==')' | ch=='}' || ch ==']'))
                return false;
            if(ch == ')' && st.peek()=='(' 
            || ch == '}' && st.peek()=='{' 
            || ch == ']' && st.peek()=='[')
                st.pop();    
            else st.add(ch);
        }
        return st.size()==0;
    }
}
