import java.util.*;
/*
Abhishek Mishra
Question: Given a list of numbers and a number k, return whether any two numbers from the list add up to k
 */
public class Solution001 {

    public static void main(String s[]) {

        int arr[] = {15, 10, 3, 7};
        int k = 17;
        System.out.println(check(arr, k));

    }

    private static boolean check(int[] arr, int k) {

        if (arr == null || arr.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int val : arr) {
            if (set.contains(val)) {
                return true;
            }
            set.add(k - val);
        }
        return false;
    }

}
