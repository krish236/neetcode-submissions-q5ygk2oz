class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int count = 0;

        for(int i = 0; i<n; i++){
            int ind1 = i;
            int ind2 = i;

            while(ind1>=0 && ind2<n && s.charAt(ind1)==s.charAt(ind2)){
                count++;
                ind1--;
                ind2++;
            }

            ind1 = i;
            ind2 = i+1;
            
            while(ind1>=0 && ind2<n && s.charAt(ind1)==s.charAt(ind2)){
                count++;
                ind1--;
                ind2++;
            }
        }

        return count;

    }
}
