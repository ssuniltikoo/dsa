package dev.dsa.java.advance.miscellaneous;

/*

Problem Description

Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.




x! means factorial of x i.e. x! = 1 * 2 * 3... * x.






Problem Constraints

1 <= A * B <= 106

1 <= B <= A

1 <= C <= 106


 */

public class FindNCRMod {
    public static void main(String[] args) {
       Solution solution = new Solution();
       // System.out.println(solution.fastPower(3,4,1000000007));
        int ans = solution.solve(2069,759,93701);
        System.out.println(ans);
    }

}

 class Solution {

    public int solve(int A, int B, int C) {
        // (A!)(1/((n-r))!(r!))%m
        //use fermet to solve this problem;
        // (A!)%C * ((A-B)!)^(C-2)%C) * (B!)^-1%C
        //   (X * Y * Z) % C  where X = (A!)%C   , Y = (A-B)^(C-2)    , Z = (B)^(C-2)%C
        //Note : one mistake in this solution C should be prime but in problem it os not mentioned so we have to consider c as both prime or non prime
         int X = findFactorialOfNumber(A,C);
         int Y = findFactorialOfNumber((A-B),C);
         int Z = findFactorialOfNumber(B,C);

        // result = (A! * Y *Z)% modulo
          int yP = fastPower(Y,(C-2),C);

        int zP = fastPower(Z,(C-2),C);

//        int yP = fastPower(Z,(C-2),C);

        // As above direction was not correct we will use 2 properties to find ncr
        // ncr = n-1cr-1 + n-1cr-1 and nc0 =1

        // try to find if this can be evaluated using recursion
        // e.g 5c2 = 5!/3!*2! = 5*4/2=10
       // int yP = findValueUsingPascalsTriangle(A,B,C);

       int result = (((X*yP)%C *  (zP%C))%C);

        return result;

    }

    // as below has o(2^n) tc usining DP
    public int findValueUsingPascalsTriangle(int n , int r, int m){
        if(n==r){
            return 1;
        }

        if(r==0){
            return 1;
        }

        int result = ((findValueUsingPascalsTriangle(n-1,r,m) % m) + (findValueUsingPascalsTriangle(n-1,r-1,m)%m))%m;

        return result;

    }

    public int findValueUsingPascalsTriangleDPMethod(int n , int r , int m){

        int[][] dp = new int[n+1][r+1];

        for(int i =0 ; i <= n; i++){

            for(int j =0 ; j <= Math.min(i,r) ; j++){
                if(j==0 || j==1){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[n][r];
    }


    public int findFactorialOfNumber(int number, int modulo){
        long product=1;
        for(int i = 1; i <= number; i++){
            product = ((product%modulo)*(i%modulo))%modulo;
        }
        return (int)product;

    }


    public int fastPower(int number, int power, int modulo){
        if(power==0){
            return 1;
        }

        long product = fastPower(number, power/2, modulo);
        int ans =1;
        if(power%2==0){
            ans = (int)(((product%modulo) * (product%modulo))%modulo);
        }
        else{
            ans =  (int)((((product*product)%modulo)*((product)))%modulo);
        }

        return ans;

    }


}

