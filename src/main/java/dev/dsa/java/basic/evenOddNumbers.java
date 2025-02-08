package dev.dsa.java.basic;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class evenOddNumbers {
    public static void main(String[] args) {
        System.out.println("Eneter number to print table ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i =1; i <= 10; i++){
            System.out.println(num + " * " + i + " = " + num * i);
//            if(i%2==0){
//                System.out.println("EVEN NUMBER IS :"+ i);
//            }else{
//                System.out.println("ODD NUMBER IS :"+ i);
//            }
        }
    }
}
