package com.zaidathar.problems.pattern;

import java.util.Scanner;

public class IncreasingLetterTriangle {
    /*
    Required pattern as below
        A
        AB
        ABC
        ABCD
        ABCDE
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row  = sc.nextInt();
        for(int i = 1; i <= row ;i++ ){
            char ch ='A';
            for(int j=0 ; j<i ; j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
        sc.close();
    }
    
}