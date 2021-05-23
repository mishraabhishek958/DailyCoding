/*
Abhishek Mishra
Question: Given an array of integers return a new array such that each element at index i of the new array is the product of all the
numbers in the original array except the one at i
 */
public class Solution002 {

    public static void main(String s[]) {
        int arr[] = {1, 2, 3, 4, 5};
        check1(arr);
        check(arr);
    }

    //method 1
    public static void check(int[] arr) {

        int newArray[] = new int[arr.length];
        int product = 1;
        for (int val : arr) {
            product *= val;
        }
        for (int i = 0; i < arr.length; i++) {
            //System.out.print(" hi ");
            newArray[i] = product / arr[i];
        }
        for (int i = 0; i < newArray.length; i++) {
            //System.out.print(" hi ");
            System.out.print(" " + newArray[i]);
        }
    }

    //method 2
    public static void check1(int arr[]) {
        int newArray[] = new int[arr.length];
        int p1, p2;
        int newArray1[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            p1 = 1;
            p2 = 1;
            for (int j = 0; j < i; j++) {
                p1 *= arr[j];
            }
            for (int k = i + 1; k < arr.length; k++) {
                p2 *= arr[k];
            }
            int result = p2 * p1;
            newArray1[i] = result;
        }
        for (int i = 0; i < newArray1.length; i++) {
            System.out.print(" " + newArray1[i]);
        }
    }


}
