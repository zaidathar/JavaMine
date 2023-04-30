package problems.pattern;

import java.util.*;

public class RectangularStarPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        for(int i = 0 ;i < row ; i+=1){
            for(int j = 0;j<col ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();

    }
}
