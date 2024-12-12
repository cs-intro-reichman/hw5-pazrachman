/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
        ///  System.out.println("\nTesting remove:");
        System.out.println("\nTesting randomStringOfLetters:");
        System.out.println("length 5 -> " + MyString.randomStringOfLetters(5));
        System.out.println("committee - meet -> " + MyString.remove("committee", "meet") + " (expected: comit)");
        System.out.println("\nTesting remove:");
        System.out.println("committee - meet -> " + MyString.remove("committee", "meet") + " (expected: comit)");
        System.out.println("abc - abc -> " + MyString.remove("abc", "abc") + " (expected: )");
        System.out.println("abc - b -> " + MyString.remove("abc", "b") + " (expected: ac)");
        System.out.println("hello - empty string -> " + MyString.remove("hello", "") + " (expected: hello)");

    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c')
     * returns 0.
     * 
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }

        }
        return count;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.length() == 0) {
            return true;
        }
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int countStr1 = countChar(str1, ch);
            int countStr2 = countChar(str2, ch);
            if (countStr1 > countStr2) {
                return false;
            }

        }

        return true;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1) {
                newString += str.charAt(i) + " "; // return all the chars until the last one with space
            } else {
                newString += str.charAt(i); // return the last char without space
            }

        }

        return newString;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomStr = "";
        for (int i = 0; i < n; i++) {
            char randomCh = (char) ((int) (Math.random() * 26) + 'a');
            randomStr += randomCh;
        }

        return randomStr;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in
     * the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str2.length() == 0) {
                return str1;
            }
        }
        for (int j = 0; j < str2.length(); j++) {
            char charAt = str2.charAt(j);
            if (str1.indexOf(charAt) > -1) {
                str1 = str1.substring(0, str1.indexOf(charAt)) + str1.substring(str1.indexOf(charAt) + 1);

            }
        }
        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or
     * "cast", or "cats".
     * 
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        // Generate a random index between 0 and str.length()
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        // Insert the character at the random inde
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}
