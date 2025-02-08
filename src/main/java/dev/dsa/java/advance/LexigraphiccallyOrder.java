package dev.dsa.java.advance;


/*

*Problem Description

Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003


 */
public class LexigraphiccallyOrder {
    public static void main(String[] args) {
        RankSolution rankSolution = new RankSolution();
        System.out.println(rankSolution.findRank("gTFAMYjxCewRlftmGOKJHUuhSBVDZnbqyoPQadEkLrpNsv"));
    }
}

class RankSolution {
    public int findRank(String A) {

        int rank =0;
        int len = A.length();
        for(int i=0;i<A.length();i++){
            int counter = findRankOfChar(A.substring(i,len));
            if(counter >0){
                int   ans = (int)((calculateFactorial(len-(i+1)))%(1000003));
                ans =  (((counter%1000003)*(ans %1000003))%1000003);

                rank  = (rank%1000003 + ans%1000003)%1000003;
            }

        }


        return rank+1;

    }

    public long calculateFactorial(int len){
            if(len==1)
                return 1;
            return (((calculateFactorial(len-1)%1000003) * (len)%1000003));
    }

    public int findRankOfChar(String A) {
        int length = A.length();
        char firstCharacter = A.charAt(0);
        int counter =0;
        for(int i=1; i < length; i++){
            char alpha = A.charAt(i);
            if(alpha < firstCharacter){
                counter++;
            }
        }
        return counter;
    }
}

