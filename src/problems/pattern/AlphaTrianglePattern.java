package problems.pattern;

import java.util.Scanner;

public class AlphaTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        char ch = 'A';
        ch+=row;
        for(int i=1 ;i<=row;i++){
            char c = ch;
            c -= (i);
            for(int j = 0 ; j < i;j++){
                System.out.print(c);
                c++;
            }
            System.out.println();

        }
        sc.close();
    }
}
