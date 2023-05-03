package problems.pattern;

import java.util.Scanner;

public class IncreasingNumberTriangle {
    public static void main(String[] args) {
        /*
         1
         2 3
         4 5 6
         7 8 9 10
         */
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int num = 1;

        for(int i = 1; i <= row ;i++){
            for(int j = 0; j < i ; j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }

        sc.close();
    }
}
