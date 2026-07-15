class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer>ls = new ArrayList<>();
        int carry = 1;
        for(int i = n-1; i>=0; i--){
            int sum = 0;
            sum+= carry;
            sum += digits[i];
            carry = sum/10;
            ls.add(sum%10); 
        }
        if(carry!=0)
        ls.add(carry);
        Collections.reverse(ls);
        int res [] = new int[ls.size()];
        for(int i = 0; i<ls.size(); i++){
            res[i] = ls.get(i);
        }
        return res;
    }
}
