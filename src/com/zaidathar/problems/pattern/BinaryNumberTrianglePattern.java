package com.zaidathar.problems.pattern;

import java.util.Scanner;

public class BinaryNumberTrianglePattern {
    /*
        Required pattern
        1 
        0 1 
        1 0 1
        0 1 0 1 
        1 0 1 0 1

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        boolean rowFlag = true;
        for(int i = 1; i <= row ; i++){
            boolean colFlag = rowFlag;
            for(int j = 0 ; j < i;j++){
                int res = colFlag ? 1 : 0;
                System.out.print(res);
                colFlag = !colFlag;
            }
            rowFlag = !rowFlag;
            System.out.println();
        }
        sc.close();
    }
}
