class Solution {

    int countBit(int num){

        int count = 0;
        for(int i = 31; i>=0; i--){
            if((num&(1<<i))!=0) count++;
        }

        return count;
    }
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int i = 0; i<=n; i++){
            int temp = countBit(i);
            res[i] = temp;
        }

        return res;
    }
}
