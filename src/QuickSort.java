import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    /**
     * The public function of QuickSort
     * @param arr the input array
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * The helper function of quickSort;
     * @param arr the current array
     * @param low the left bound
     * @param high the right bound
     */
    private void quickSort(int[] arr, int low, int high) {
        // True: when there is at least 1 item
        if (high >= low) {
            int pivot = partition(arr, low, high);
            // after partition, pivot is at its proper position
            // numbers at left ; < pivot
            // numbers at right; > pivot
            // we don't need to touch pivot again
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * Swap two values in an array
     * @param arr the input array
     * @param idx1 the first index
     * @param idx2 the second index
     */
    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    /**
     * to random pivot index between low and high inclusive
     * @param low
     * @param high
     * @return the random pivot index
     */
    private int getPivot(int low, int high) {
        Random rand = new Random();
        // rand.nextInt(n) => 0(Inclusive) ... n(Exclusive)
        return rand.nextInt((high - low) + 1) + low;
    }

    /**
     * Move all numbers < pivot to left of pivot
     * Move all numbers > pivot to right of pivot
     * @param arr the input array
     * @param low the left bound
     * @param high the right bound
     * @return the current pivot index
     */
    private int partition(int[] arr, int low, int high) {
        // 1. move pivot to the leftmost position
        swap(arr, low, getPivot(low, high));
        // Now: pivot is at low
        // 2. Set the border which is the idx right next to pivot(low)
        int border = low + 1;
        // 3. Process all the numbers at right side of pivot
        for (int i = border; i <= high; i++) {
            if (arr[i] < arr[low]) {
                swap(arr, i, border++);
            }
        }

        // 4. Swap the pivot to its proper position
        // Now: pivot: border - 1
        swap(arr, low, border - 1);
        return border - 1;
    }


    /**
     * The main function of QuickSort;
     * @param args
     */
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int arr[] = {5, 3, 2, 1, 9, 8, 8, 6};
        System.out.println(Arrays.toString(arr));
        qs.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
