class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;

        while(i<=j){
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                if(Character.isLetterOrDigit(s.charAt(i))==false) i++;
                else if(Character.isLetterOrDigit(s.charAt(j))==false) j--;
                else return false;
            }
            else{
                i++;
                j--;
            }

        }
        return true;
    }
}
