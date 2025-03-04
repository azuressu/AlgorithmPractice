package main.java.org.leetcode;

public class GcdOfStrings {

    /**
     * 1071. Greatest Common Divisor of Strings
     * Easy
     * Topics
     * Companies
     * Hint
     * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
     *
     * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
     *
     *
     *
     * Example 1:
     *
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     * Example 2:
     *
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     * Example 3:
     *
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     *
     *
     * Constraints:
     *
     * 1 <= str1.length, str2.length <= 1000
     * str1 and str2 consist of English uppercase letters.
     */
    public static String gcdOfStrings(String str1, String str2) {
        if (str1.contains(str2)) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (int i=0; i<str1.length() - str2.length(); i++) {
                int num = 0;
                boolean flag = true;
                if (str1.charAt(i) == str2.charAt(num)) {
                    for (int j = 0; j<str2.length(); j++) {
                        if (str1.charAt(i + j) != str2.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    index = i;
                    break;
                }
            }
            sb.append(str1, index+str2.length(), str1.length());
            return sb.toString();
        } else {
            return "";
        }
    }

    public static String gcdOfString(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)){
            return "";
        }
        int j = gcd(str1.length(), str2.length());
        return str1.substring(0, j);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        String result1 = gcdOfStrings("ABCABC", "ABC");
        System.out.println("ABCABC / ABC = " +  result1);

        String result2 = gcdOfStrings("ABABAB", "ABAB");
        System.out.println("ABABAB / ABAB = " +  result2);

        String result3 = gcdOfStrings("LEET", "CODE");
        System.out.println("LEET / CODE = " +  result3);

        String result4 = gcdOfString("ABCDEF", "ABC");
        System.out.println("ABCDEF / ABC = " +  result4);
    }
}
