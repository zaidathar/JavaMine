package problems.pattern;

import java.util.Scanner;

public class AlphaRampPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        char ch = 'A';
        for(int i = 1; i<= row;i++){
            for(int j = 0; j<i ; j++){
                System.out.print(ch);
            }
            System.out.println();
            ch++;
        }
        sc.close();
    }
}
