import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by cuixun on 2/26/15.
 */
public class FindLongestPalindrome {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Please enter one string: ");
        String s = cin.nextLine();
        //String out = findLongestPalin(s);
        String out = improveFind(s);
        System.out.println(out);
    }

    /**
     * The time complexity of this method is n^3, whick is to high for a string whose length is hundreds
     *
     * @param s
     * @return
     */
    public static String findLongestPalin(String s) {
        String subS = "";
        int count = 0;
        String longestPalindorme = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                subS = s.substring(i, j);
                if (subS.length() > count && isPalindrome(subS)) {
                    count = subS.length();
                    longestPalindorme = subS;

                }
            }
        }
        System.out.println(count);
        return longestPalindorme;
    }

    /**
     * Here is an another method, whose time complexity is n^2 but its space complexity is n^2 too.
     * Which may occupy a lot of spaces.
     *
     * @param s
     * @return
     */
    public static String improveFind(String s) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String longSubS = "";
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!stringArrayList.contains(s.substring(i, j))) {
                    stringArrayList.add(s.substring(i, j));
                }
            }
        }
        while (stringArrayList != null && !stringArrayList.isEmpty()) {
            String sub = stringArrayList.get(index);
            if (sub.length() > longSubS.length() &&
                    isPalindrome(sub)) {
                longSubS = sub;
            }
            stringArrayList.remove(index);

        }
        return longSubS;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int last = s.length() - 1;
        while (last - start > 0) {
            if (s.charAt(start) != s.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
}
