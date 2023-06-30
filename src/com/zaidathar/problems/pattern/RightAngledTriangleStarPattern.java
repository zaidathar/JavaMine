package com.zaidathar.problems.pattern;

import java.util.Scanner;

public class RightAngledTriangleStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();

        for(int i =1 ;i<=row;i++){
            for(int j= 0 ;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
