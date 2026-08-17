package com.loan.week5;

public class StringBasics {
    public static void main(String[] args) {
        //String immutable
        String s = "Hello";
        s+="World"; // new object created instead of adding in same object

        //String Builder
        // StringBuilder is not thread-safe but executes much faster,
        // whereas StringBuffer is thread-safe because its methods are synchronized,
        // making it slower due to performance overhead

        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" World");

        String result = sb.toString();
        System.out.println(result);

        //Character Access
        String s1 ="Hello";
        char ch1 = s1.charAt(0);
        System.out.println(ch1);
        System.out.println(s1.length());
        System.out.println(s1.substring(1,3));

        //to char Array
        char[] ch=s1.toCharArray();
        for(char c:ch){
            System.out.println(c);
        }

        //reverse String
        StringBuilder sb1=new StringBuilder("Shyam Bhimani");
        String reverse = sb1.reverse().toString();
        System.out.println(reverse);

    }

}
