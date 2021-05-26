
/*
Abhishek Mishra
find out the first positive missing number in the array.
 */
public class Solution004 {

    public static void main(String s[]) {

        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{1, 5, 3, 3, -2}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1 }));
    }


    /*
    space complexity : O(1)
     */
    public static int firstMissingPositive(int arr[]) {
        boolean oneExist = false;
        //first check whether 1 exist or not
        for (int i : arr) {
            if (i == 1) {
                oneExist = true;
            }
        }
        if (!oneExist) {
            return 1;
        }
        int n = arr.length;
        //convert all negative number and 0 and number greater than length of array to 1
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }
        //get the value from each index and just convert the value present at that index to negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);

            if (index < n) {
                arr[index] = -1 * Math.abs(arr[index]);
            } else {
                arr[0] = -1 * Math.abs(arr[0]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] > 0) {
                return i;
            }

        }
        if (arr[0] > 0) {
            return n;
        }
        return n + 1;
    }
}
