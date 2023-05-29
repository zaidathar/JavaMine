package problems.string;

public class CountSubstring {
    public static String createSubString(String s ,int start , int end){
        if(end > s.length())end = s.length()-1;

        StringBuilder sb = new StringBuilder();

        for(int i = start ;i<=end ;i++){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static int conuntSubString(String s, String substr){
        int res = 0;

        int subStrLen = substr.length();

        int front = 0, back = subStrLen - 1;

        while(back < s.length()){
            if(createSubString(s, front, back).equalsIgnoreCase(substr)){
                res++;
            }
            front++;back++;
        }

        return res;
    }
    public static void main(String[] args) {
        String s = "JavaIsCoolJavaIsRobustJavaIsAwesome Java -Java-Jar java JaVa";
        String subStr = "Java";

        System.out.println(conuntSubString(s, subStr));
    }
}
