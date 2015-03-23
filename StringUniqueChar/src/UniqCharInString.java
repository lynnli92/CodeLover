import java.util.Scanner;

/**
 * Created by cuixun on 3/22/15.
 */
public class UniqCharInString {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        System.out.println("Please enter a string: ");
        String str = cin.nextLine();
        System.out.println();
        System.out.println(isStringUnique(str));

        /**
         * digits add means add each digit of an number;
         */
        /**
         System.out.println("Please enter an positive number: ");
         long num = cin.nextLong();
         if(num > 0){
         System.out.println(digitsAdd(num));
         }else{
         System.out.println("ERROR");
         }
         */

    }

    /**
     * isStringUnique is a method that judge whether the chars in the string is the only one or not;
     *
     * @param str
     * @return
     */
    public static boolean isStringUnique(String str) {
        boolean[] char_set = new boolean[256];
        int val;
        for (int i = 0; i < str.length(); i++) {
            val = str.charAt(i);
            //System.out.print(val + " ");
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }


        return true;
    }


}
