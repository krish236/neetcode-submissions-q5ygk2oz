class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<String>st = new Stack<>();

        for(int i = 0; i<n; i++){
            String ch = tokens[i];
            if(ch.equals("*")){
                int num1 = Integer.parseInt(st.peek());
                st.pop();
                int num2 = Integer.parseInt(st.peek());
                st.pop();
                int res = num1*num2;
                st.add(String.valueOf(res));
            }
            else if(ch.equals("+")){
                int num1 = Integer.parseInt(st.peek());
                st.pop();
                int num2 = Integer.parseInt(st.peek());
                st.pop();
                int res = num1+num2;
                st.add(String.valueOf(res));
            }
            else if(ch.equals("/")){
                int num1 = Integer.parseInt(st.peek());
                st.pop();
                int num2 = Integer.parseInt(st.peek());
                st.pop();
                int res = num2/num1;
                st.add(String.valueOf(res));
            }
            else if(ch.equals("-")){
                int num1 = Integer.parseInt(st.peek());
                st.pop();
                int num2 = Integer.parseInt(st.peek());
                st.pop();
                int res = num2-num1;
                st.add(String.valueOf(res));
            }
            else{
                System.out.println(ch);
                st.push(ch);
            }
        }

        int ans = Integer.parseInt(st.peek());
        return ans;
    }
}
