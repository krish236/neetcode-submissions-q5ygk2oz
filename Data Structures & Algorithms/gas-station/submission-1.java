class Solution {

    
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int n = gas.length;
       
       int tot = 0;
       int start = 0;
       int sum = 0;

       for(int it : gas)
            sum+=it;
        
        int sum2 = 0;
        for(int it : cost)
        {
            sum2+=it;
        }
       if(sum<sum2)   return -1;
       for(int i = 0; i<gas.length; i++)
       {
           
           tot += gas[i]-cost[i];
           if(tot<0)
           {
               start = i+1;
               tot = 0;
           }
       }

       return start;
    }
};