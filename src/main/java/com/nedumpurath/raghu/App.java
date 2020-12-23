package com.nedumpurath.raghu;

import java.util.stream.IntStream;

public class App 
{
    public static void main( String[] args )
    {
        //String testResult = removeSpecialChars("maeream");
        //String testString = "aba!!@ba";
        String testString = "";

        System.out.println( "testString: " + testString );

        String tempString = removeSpecialChars(testString);
        System.out.println( "isPalindrome(): " + isPalindrome(tempString));

        System.out.println( "isPalindromeMethod1(): " + isPalindromeMethod1(testString));

        System.out.println( "isPalindromeMethod2(): " + isPalindromeMethod2(testString));

        System.out.println( "isPalindromeMethod3(): " + isPalindromeMethod3(testString));

        System.out.println( "isPalindromeRecursiveMethod(): " + isPalindromeRecursiveMethod(testString));
    }

    static String removeSpecialChars(String input) {
        String result = input.replaceAll("[^a-zA-Z ]", "");
        return result;
    }

    static Boolean isPalindrome(String input) {
        int inputLength = input.length();
        for (int i = 0; i < inputLength/2; i++) {
            if (input.charAt(i) != input.charAt(inputLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static Boolean isPalindromeMethod1(String input) {
        int inputLength = input.length();
        if (inputLength < 1) return true;
        int tracker1 = 0;
        int tracker2 = inputLength - 1;
        do {

            while (tracker1 < inputLength && !isAllowedChar(input.charAt(tracker1)))  {
                tracker1++;
            }
            if (tracker1 >= tracker2) return true;

            while (tracker2 > 0 && !isAllowedChar(input.charAt(tracker2))) {
                tracker2--;
            }

            if (tracker1 >= tracker2) return true;

            if (input.charAt(tracker1) != input.charAt(tracker2) ) return false;

            tracker1++;
            tracker2--;

        } while (tracker1 < tracker2);

        return true;
    }

    static Boolean isPalindromeMethod2(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z ]", "");
        StringBuffer inputBuffer = new StringBuffer(cleanedInput);
        StringBuffer reverseBuffer = inputBuffer.reverse();
        return inputBuffer.toString().equals(cleanedInput);
    }

    static Boolean isPalindromeMethod3(String input) {
        final String cleanedInput = input.replaceAll("[^a-zA-Z ]", "");
        final int inputLenght = cleanedInput.length();
        return IntStream.range(0, inputLenght/2).allMatch(i -> cleanedInput.charAt(i) == cleanedInput.charAt(inputLenght - i -1));
    }

    static Boolean isPalindromeRecursiveMethod(String input) {
        final String cleanedInput = input.replaceAll("[^a-zA-Z ]", "");
        final int inputLenght = cleanedInput.length();
        return isPalindromeRecursive(cleanedInput, 0, inputLenght - 1);
    }

    static Boolean isPalindromeRecursive(String input, int first, int last) {
        if (first >= last) return true;

        if (input.charAt(first) != input.charAt(last)) return false;

        return isPalindromeRecursive(input, first + 1, last - 1);
    }


    static Boolean isAllowedChar(Character chr) {
        return Character.isLetter(chr);
    }
}
