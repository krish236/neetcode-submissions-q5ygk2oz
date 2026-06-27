class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();

        int num = n;
        int sum = 0;
        while(true){
            while(num>0){
                int rem = num%10;
                num = num/10;
                sum+= rem*rem;
            }

            if(sum==1) return true;
            if(st.contains(sum)==true) return false;

            st.add(sum);

            num = sum;
            sum = 0;
        }
        
    }
}
