import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cuixun on 3/24/15.
 */
public class TwoSum {
    public static void main(String[]args){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 23, 34, 45, 56, 67, 78, 89};
        int[] out = targetSumIndex(array, 167);
        ArrayList<Integer> list = twoSumIndex(array, 167);
        
        for(int i = 0; i < out.length; i++){

            System.out.print(out[i]+ " ");
        }

        System.out.println();
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+ " ");
        }
    }

    /**
     * We suppose the array has been sorted
     * @param array
     * @param targetSum
     * @return
     */
    public static int[] targetSumIndex(int[] array, int targetSum){
        int[] result = {-1, -1};
        for(int i = 0; i < array.length; i++){
            int data1 = array[i];
            int target = targetSum - data1;
            int j = isSearched(target, array, i + 1, array.length - 1);
            if(j > 0){
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }

        return result;
    }

    public static int isSearched(int target, int[] array, int left, int right) {
        if (left <= right) {
            int index = (left + right) / 2;
            int mid = array[index];
            if (mid == target) {
                return index;
            }
            if(target < mid) {
                int x = isSearched(target, array, left, index - 1);
                if (x > 0) {
                    return x;
                }
            }
            int y = isSearched(target, array, index + 1, right);
            return y;
        }
        return -1;
    }

    /**
     * we return ArrayList here to separate the previous method
     * the time complexity here is O(n) space complexity here is O(n)
     * @param array
     * @param target
     * @return
     */
    public static ArrayList<Integer> twoSumIndex(int[] array, int target){
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            int x = target - array[i];
            if(map.containsKey(target - x)){
                list.add(map.get(target - x) + 1);
                list.add(i + 1);
                return list;
            }
            map.put(x, i);
        }
        return list;
    }
}
