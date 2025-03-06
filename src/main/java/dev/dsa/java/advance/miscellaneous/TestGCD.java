package dev.dsa.java.advance.miscellaneous;

public class TestGCD {
    public static void main(String[] args) {
        MagicalNumber magicalNumber = new MagicalNumber();
        int a = 11;
        int b = 12;
        int c = 13;
        System.out.println(magicalNumber.findMagicalNumber(a,b,c));
    }


}

/*
Problem Description

You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.


 */
class MagicalNumber {
    public int findMagicalNumber(int A, int B, int C) {
        long mod = 1000000007;
        long result = findAthMagicalNumber(A,B,C);
        return (int)(result%mod);

    }

    private long findAthMagicalNumber(long A, long B, long C){
        long low = 1 ;
        long high = A * Math.min(B, C);
        long mid=-1;
        while(low <= high){
            // find mid
             mid = ((low) + (high-low)/2);
            long count = getNumberOMagicalValues(mid,B,C);
//            if(count==A){
//                return mid;
//            }
            if(count >= A){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high+1;
    }

    private long getNumberOMagicalValues(long range,long B , long C){
        long counntB = range/B;
        long countC = range/C;
        long countLCM = range/calculateLCM(B,C);
        return counntB + countC -countLCM;

    }

    private long calculateLCM(long a , long b){
        long h = calculateHCF(a,b);

        return ((a/h)*b);
    }


    // to calculate gcd
    private long calculateHCF(long a , long b){
        if(b==0){
            return a;
        }
        if(a==0){
            return b;
        }

        if(a>b){
            return calculateHCF(b,a%b);
        }else
            return calculateHCF(a,b%a);

    }
}
