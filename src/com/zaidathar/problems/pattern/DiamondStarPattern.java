package com.zaidathar.problems.pattern;

import java.util.Scanner;

public class DiamondStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startIndex = n - 1 , endIndex = n-1;
        for(int i = 0 ;i < n ;i++){
            
            for(int j = 0 ;j < 2*n -1 ; j++){
                if(j >= startIndex && j<= endIndex){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();

            startIndex--;endIndex++;
        }
        startIndex = 0 ; endIndex = 2*n-2;
        for(int i = 0 ;i < n ;i++){
            
            for(int j = 0 ;j < 2*n -1 ; j++){
                if(j >= startIndex && j<= endIndex){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();

            startIndex++;endIndex--;
        }
        sc.close();
    }
}
