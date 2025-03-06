package dev.dsa.java.advance.miscellaneous;

/*

    Problem Description

Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.







For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB


 */


public class ExcelColumnTile {
    public static void main(String[] args) {
        NumberToAlphabet numberToAlphabet = new NumberToAlphabet();
        String b = numberToAlphabet.convertToTitle(52);
        System.out.println(   b);
//        for(int i =1; i<=10000; i++) {
//            String a = numberToAlphabet.convertToTitle(i);
//            System.out.println( i + " :: " + a.toUpperCase());
//        }
    }
}

class NumberToAlphabet{

    public String convertToTitle(int A) {
        char[] ch = new char[27];
        for(int i =0; i <=26; i++){
            ch[i] = (char) (i+96);
        }

        int num = A;
        String ans = "";
        if(A==26){
            return "z";
        }
        while(num>0){
            int rem = num%26;
            num = num/26;
            if(rem==0){
                ans = String.valueOf('z').concat(ans);
                num=num-1;
            }else
                ans = String.valueOf(ch[rem]).concat(ans);

        }



         return ans;

       // return new String(String.valueOf(ch[A-1]));
    }

}
