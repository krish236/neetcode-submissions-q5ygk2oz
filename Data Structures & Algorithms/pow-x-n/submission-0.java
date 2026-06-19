// x^n = if n = even (x*x)^n/2 odd x*(x)^n-1;

/*

int nn = n;
if(n<0) nn = nn*-1;
    double res = 0;
    while(nn!=0){

        if(nn%2==0){
            nn = nn/2;
            x = x/2;
        }
        else{
            nn = nn-1;
            res = res*x;
        }
    }

    if(n<0){
        res = (double)1/(double)res;    
    }

    return res;
*/
class Solution {
    public double myPow(double x, int n) {
        
        long nn = n;

        if(n<0) nn = nn*-1;
        double res = 1;
        while(nn!=0){
            if(nn%2==0){
                x = x*x;
                nn = nn/2;
            }
            else{
                res = res*x;
                nn = nn-1;
            }
        }

        if(n<0){
            res = (double)1/(double)res;
        }
        return res;
    }
}
