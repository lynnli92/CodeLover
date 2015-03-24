import java.util.Stack;

/**
 * Created by cuixun on 3/24/15.
 */
public class LongSubNoRepeat {
    public static void main(String[]args){
        String s = "jjjbnvcskhjhjsdjahjdahshhhhjshdjhjbcasdc";
        System.out.println(longSub(s));
    }
    public static String longSub(String s){
        int longLength = 0;
        Stack<String> subStrings = new Stack<String>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){  // exclutive or not
                String sub = s.substring(i, j + 1);
                if(!isRepeat(sub) && sub.length() > longLength){
                    subStrings.push(sub);
                    longLength = sub.length();
                }
            }
        }
        return subStrings.peek();
    }
    public static boolean isRepeat(String s){
        boolean[] buffer = new boolean[256];
        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i);
            if(buffer[x]){
                return true;
            }
            buffer[x] = true;
        }
        return false;
    }
}
