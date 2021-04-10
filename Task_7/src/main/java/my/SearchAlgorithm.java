package my;

import java.util.Arrays;

public class SearchAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[] {1, 3, 2, 10, 8};
        int maxNumber = linearMax(array);

        System.out.println("max " + maxNumber);

//        bubbleSort(array);
//        System.out.println("buble sort " + Arrays.toString(array));
//
//        int first = 0; //первый элемент массива
//        int last = array.length - 1; //последний элемент массива
//
//        int number = binarySearch(array, 10, first, last);
//        System.out.println(number);
    }

    static int linearMax(int[] array) {
        //O(n)
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static void bubbleSort(int[] arr) {
        //O(n^2)
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        //O(log(n))
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
