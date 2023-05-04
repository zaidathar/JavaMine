package problems.pattern;

import java.util.Scanner;

public class InvertedNumberRightPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        for( int i = row ; i > 0 ; i--){
            for(int j = 1; j <= i ; j++){
                System.out.print(j);

            }
            System.out.println();
        }
        sc.close();
    }
}