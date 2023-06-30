package com.zaidathar.problems.basic;

public class StringToInt {
    public static int stringToInt(String num){

        int res = 0 , i =0 , mul = 1;
        int len = num.length();
        if(num.charAt(0) == '-'){
            mul = -1;
            i++;
            len--;
        }
        
        int pow = (int)Math.pow(10,len-1);

        for(;i<num.length();i++){
            int digit = (int)num.charAt(i) - (int)'0';
            res = pow*(digit) + res;
            pow/=10;
        }

        return res * mul;
    }
    
    public static void main(String[] args) {
        String num = "-12315";
        int res = stringToInt(num);
        System.out.println(res);
    }

    
}
