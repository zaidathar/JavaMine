package problems.pattern;

import java.util.Scanner;

public class NumberCrownPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        for(int i = 1 ; i <= row ; i++){
            int target = i ;
            for(int j = 1 ; j <= row ;j++){
                if(j <= target)System.out.print(j);
                else System.out.print(" ");
            }
            for(int j = row ; j >0 ;j--){
                if(j <= target)System.out.print(j);
                else System.out.print(" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
