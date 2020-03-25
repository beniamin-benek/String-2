import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //System.out.println(countHi("hiho not HOHIhi"));
        //System.out.println(bobThere("123abcbcdbabxyz"));
        //System.out.println(catDog("catdog"));
        //System.out.println(endOther("AbC", "HiaBc"));
        //System.out.println(repeatEnd("Hello", 3));
        //System.out.println(prefixAgain("aa", 1));
        //System.out.println(sameStarChar("xy*zzz"));
        //System.out.println(plusOut("12xy34", "xy"));
        //System.out.println(zipZap("zi"));
        //System.out.println(xyzThere("abcxyz"));
        //String string = "abc1abc1abc";
        //System.out.println(string);
        //System.out.println(wordEnds("XY", "XY"));
    }

    //Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string.
    private static String repeatSeparator(String word, String sep, int count) {
        String output = "";
        int i = 0;
        while (i < count) {
            if (i < count - 1)
                output = output.concat(word).concat(sep);
            else
                output = output.concat(word);
            i++;
        }
        return output;
    }

    //Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one.
    private static boolean xyzMiddle(String str) {

        if (str == null || str.length() == 0 || str.length() == 1 || str.length() == 2)
            return false;

        int middleIndex;
        if (str.length() % 2 == 0) {
            middleIndex = (str.length() / 2) - 1;
            return (str.charAt(middleIndex) == 'x' && str.charAt(middleIndex + 1) == 'y' && str.charAt(middleIndex + 2) == 'z') || (str.charAt(middleIndex - 1) == 'x' && str.charAt(middleIndex) == 'y' && str.charAt(middleIndex + 1) == 'z');
        } else {
            middleIndex = str.length() / 2;
            return (str.charAt(middleIndex - 1) == 'x' && str.charAt(middleIndex) == 'y' && str.charAt(middleIndex + 1) == 'z');
        }
    }

    //Given a string, return a string where for every char in the original, there are two chars.
    private static String doubleChar(String str) {
        String doubleChars = "";
        int i = 0;
        while (i < str.length()) {
            doubleChars = doubleChars.concat(str.charAt(i) + "").concat(str.charAt(i) + "");
            i++;
        }
        return doubleChars;
    }

    //Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
    private static int countCode(String str) {
        int counter = 0;

        for (int i = 0; i <= str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e')
                counter++;
        }

        return counter;
    }

    //Return the number of times that the string "hi" appears anywhere in the given string.
    private static int countHi(String str) {
        int counter = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("hi"))
                counter++;
        }
        return counter;
    }

    //Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    private static boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b')
                return true;
        }
        return false;
    }

    //Return true if the string "cat" and "dog" appear the same number of times in the given string.
    private static boolean catDog(String str) {
        int dogs = 0;
        int cats = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("dog")) dogs++;
            if (str.substring(i, i + 3).equals("cat")) cats++;
        }

        return dogs == cats;
    }

    //Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences.
    private static boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() >= b.length()) return a.substring(a.length() - b.length()).equals(b);
        else return b.substring(b.length() - a.length()).equals(a);

    }

    //We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
    private static boolean xyBalance(String str) {
        if (str == null || str.length() == 0 || str.indexOf('x') == -1) return true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(str.length() - 1) == 'x') return false;
            if (str.charAt(i) == 'x') {
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(j) == 'y') return true;
                }
            }
        }
        return false;
    }

    private static boolean xyBalanceV2(String str) {
        boolean thereIsY = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'y') thereIsY = true;

            if (str.charAt(i) == 'x' && !thereIsY) return false;
        }
        return true;
    }

    //Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
    private static String mixString(String a, String b) {
        String output = "";

        if (a.length() >= b.length()) {
            for (int i = 0; i < b.length(); i++)
                output = output.concat(a.charAt(i) + "").concat(b.charAt(i) + "");

            return output.concat(a.substring(b.length()));
        } else {
            for (int i = 0; i < a.length(); i++)
                output = output.concat(a.charAt(i) + "").concat(b.charAt(i) + "");

            return output.concat(b.substring(a.length()));
        }
    }

    //Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    private static String repeatEnd(String str, int n) {
        if (str == null || n == 0 || n > str.length()) return "";

        StringBuilder stringBuilder = new StringBuilder();
        String endChars = str.substring(str.length() - n);

        for (int i = 0; i < n; i++)
            stringBuilder.append(endChars);

        return stringBuilder.toString();
    }

    //Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string?
    private static boolean prefixAgain(String str, int n) {

        if (str == null || n <= 0 || str.length() <= 0 || str.length() < n)
            throw new IllegalArgumentException();

        String prefix = str.substring(0, n);
        System.out.println(prefix);

        for (int i = n; i <= str.length() - n; i++) {
            if (str.substring(i, i + n).equals(prefix))
                return true;
        }

        return false;
    }

//    private static boolean sameStarChar(String str) {
//        List<Integer> indexes = new ArrayList<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '*')
//                indexes.add(i);
//        }
//        for (int i = 1; i < indexes.size() - 1; i++) {
//            //System.out.println("acab0");
//            if (!str.contains("*") || str.charAt(indexes.get(i) - 1) != str.charAt(indexes.get(i) + 1))
//                return false;
//        }
//        return true;
//    }

    //Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same.
    private static boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1))
                return false;
        }
        return true;
    }

    //Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
    private static boolean xyzThere(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("xyz")) return true;

        for (int i = 1; i < str.length() - 2; i++) {
            if (str.charAt(i - 1) != '.' && str.substring(i, i + 3).equals("xyz")) return true;
        }
        return false;
    }

    //Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"),
    //except for appearances of the word string which are preserved unchanged.
    private static String plusOut(String str, String word) {
        StringBuilder output = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (i <= str.length() - word.length() && str.substring(i, i + word.length()).equals(word)) {
                output.append(word);
                i = i + word.length();
            } else {
                output.append("+");
                i++;
            }
        }
        return output.toString();
    }

    //Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
    //Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
    private static String zipZap(String str) {
        StringBuilder output = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (str.length() >= 3 && str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                output.append(str.charAt(i)).append(str.charAt(i + 2));
                i = i + 3;
            } else {
                output.append(str.charAt(i));
                i++;
            }
        }
        return output.toString();
    }

    //Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone.
    private static String starOut(String str) {
        if (str == null || str.length() == 0) return "";
        if (str.length() == 1 && str.charAt(0) == '*') return "";
        if (str.length() == 1 && str.charAt(0) != '*') return str;

        StringBuilder stringBuilder = new StringBuilder();

        if (str.charAt(0) != '*' && str.charAt(1) != '*')
            stringBuilder.append(str.charAt(0));

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i - 1) != '*' && str.charAt(i) != '*' && str.charAt(i + 1) != '*')
                stringBuilder.append(str.charAt(i));
        }

        if (str.charAt(str.length() - 1) != '*' && str.charAt(str.length() - 2) != '*')
            stringBuilder.append(str.charAt(str.length() - 1));

        return stringBuilder.toString();
    }

    //Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string.
    //Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words.
    private static String wordEnds(String str, String word) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null || str.length() < word.length()) return "";

        if (str.substring(0, word.length()).equals(word))
            stringBuilder.append(str.charAt(word.length()));

        for (int i = word.length() - 1; i < str.length() - word.length(); i++) {
            if (str.substring(i, i + word.length()).equals(word))
                stringBuilder.append(str.charAt(i - 1)).append(str.charAt(i + word.length()));
        }

        if (str.substring(str.length() - word.length()).equals(word))
            stringBuilder.append(str.charAt(str.length() - word.length() - 1));

        return stringBuilder.toString();
    }

}