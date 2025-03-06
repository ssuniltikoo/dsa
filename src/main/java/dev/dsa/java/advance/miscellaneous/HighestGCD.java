package dev.dsa.java.advance.miscellaneous;

import java.util.ArrayList;

public class HighestGCD {

    public static void main(String[] args) {
        HighestGCD hg = new HighestGCD();
        // find gcd by deleting one number
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);
        list.add(30);
        hg.solve(list);
    }


        public int solve(ArrayList<Integer> A) {

            ArrayList<Integer> pgcd = new ArrayList();
            ArrayList<Integer> sgcd = new ArrayList();
            pgcd.add(A.get(0));
            sgcd.add(0);
            for(int i=1; i < A.size();i++){
                pgcd.add(gcd(A.get(i),pgcd.get(i-1)));
                sgcd.add(0);
            }

            sgcd.set(( A.size() - 1)  , A.get(A.size() - 1) );

            for(int i= A.size()-2; i >=0;i--){
                sgcd.set(i, gcd( A.get(i) , sgcd.get(i+1)));
            }

            int max = Integer.MIN_VALUE;

            for(int i=0; i < A.size()-1;i++){
                if(i==0){
                    max= getMax(max, sgcd.get(1));
                }
                else if(i==A.size()-1){
                    max= getMax(max, pgcd.get(A.size()-2) );
                }else
                 max= getMax(max, gcd( pgcd.get(i-1), sgcd.get(i+1)) );
            }

            return max;
        }


        public int gcd(int a, int b){
            if(b==0){
                return a;
            }
            if(a==0){
                return b;
            }
            if(a>b)
                return gcd(b,a%b);
            else
                return gcd(a,b%a);
        }

        public int getMax(int a, int b){
            return a>b?a:b;
        }
}
