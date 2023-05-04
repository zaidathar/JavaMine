package problems.pattern;

import java.util.Scanner;

public class ReverseLetterTriangelPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row  = sc.nextInt();
        for(int i = row; i > 0 ;i-- ){
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
