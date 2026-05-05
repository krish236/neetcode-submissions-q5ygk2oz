class MinStack {
    Stack<Integer>minStack;
    Stack<Integer>st;
    public MinStack() {
        minStack = new Stack<>();
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        
        if(minStack.isEmpty()==true || val<=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int top = st.peek();
        st.pop();

        if(top == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
