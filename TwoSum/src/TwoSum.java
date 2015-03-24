/**
 * Created by cuixun on 3/24/15.
 */
public class TwoSum {
    public static void main(String[]args){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 23, 34, 45, 56, 67, 78, 89};
        int[] out = targetSumIndex(array, 167);
        for(int i = 0; i < out.length; i++){
            System.out.print(out[i]+ " ");
        }
    }

    public static int[] targetSumIndex(int[] array, int targetSum){
        int[] result = {-1, -1};
        for(int i = 0; i < array.length; i++){
            int data1 = array[i];
            int target = targetSum - data1;
            int j = isSearched(target, array, i + 1, array.length - 1);
            if(j > 0){
                result[0] = i;
                result[1] = j;
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
            int x = isSearched(target, array, left, index - 1);
            int y = isSearched(target, array, index + 1, right);
            if (x > 0) {
                return x;
            }
            return y;
        }
        return -1;
    }
}
