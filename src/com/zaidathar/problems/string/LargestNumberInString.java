package com.zaidathar.problems.string;

import java.util.Arrays;

public class LargestNumberInString {
    public static int largestNumberInString(String str){
        int res = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){
            int val = c - '0';

            if(val >=0  && val <=9){
                sb.append(c);
            }
            else{
                if(sb.length()==0)continue;
                int temp = Integer.valueOf(sb.toString());
                if(temp > res)res = temp;
                sb = new StringBuilder();
            }
        }
        if(sb.length()==0)return res;
        int temp = Integer.valueOf(sb.toString());
        if(temp > res)res = temp;
        return res;
    }
    public static void main(String[] args) {
        String str = "sachin74572ghd98yh11544";
        int res = largestNumberInString(str);
        if(res == Integer.MIN_VALUE)
            System.out.println("No number found in string");
        else
            System.out.println("Largest number in string is "+res);
    }
}
